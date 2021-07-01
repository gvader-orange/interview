package pl.example.codereview.domain.offer;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfferRepository {

    private JdbcTemplate jdbcTemplate;

    public OfferRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Offer> getAllByTitleContainsAndHidden(String title) {
        String sql = "SELECT * FROM offers WHERE title LIKE \"%" + title + "%\"";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<Offer>(Offer.class));
    }

    List<Offer> findAllByHidden(boolean isHidden) {
        String sql = "SELECT * FROM offers WHERE hidden IS " + isHidden;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Offer>(Offer.class));
    }

    Offer findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM offers WHERE id=" + id,
                new BeanPropertyRowMapper<Offer>(Offer.class));
    }

    void save(Offer offer) {
        String sql = "INSERT INTO offers (title, descriptionLong, userId, quantity, price, hidden) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[]{offer.getTitle(), offer.getDescriptionLong(), offer.getUserId(), offer.getQuantity(), offer.getPrice(), offer.isHidden()};
        jdbcTemplate.update(sql, param);
    }
}
