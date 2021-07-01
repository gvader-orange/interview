package pl.example.codereview.domain.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OfferController {

    private OfferRepository repository;

    @Autowired
    public OfferController(OfferRepository repository) {
        this.repository = repository;
    }


    public void addOffer(Offer offer) {
        this.repository.save(offer);
    }

    public List<Offer> findBySearchParam(String param) {
        if (param.equals("")) {
            return this.repository.findAllByHidden(false);
        } else {
            return this.repository.getAllByTitleContainsAndHidden(param);
        }
    }

    public Offer getOfferById(int id) {
        return this.repository
                .findById(id);
    }
}
