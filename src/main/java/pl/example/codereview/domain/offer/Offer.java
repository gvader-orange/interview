package pl.example.codereview.domain.offer;

import javax.persistence.*;

@Table(name = "offers")
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String descriptionLong;
    private int userId;
    private int quantity;
    private float price;
    private boolean hidden;

    public Offer() {
    }

    public Offer(String title,
                 String descriptionLong,
                 int userId,
                 int quantity,
                 float price,
                 boolean hidden) {
        this.title = title;
        this.descriptionLong = descriptionLong;
        this.userId = userId;
        this.quantity = quantity;
        this.price = price;
        this.hidden = hidden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
