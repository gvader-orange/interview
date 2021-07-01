package pl.example.codereview.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Min;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferRequestDto {
    private String title;
    private String descriptionLong;
    @Min(1)
    private int quantity;
    @Min(1)
    private float price;
    private boolean hidden;

    public OfferRequestDto(String title, String descriptionLong, int quantity, float price, boolean hidden) {
        this.title = title;
        this.descriptionLong = descriptionLong;
        this.quantity = quantity;
        this.price = price;
        this.hidden = hidden;
    }

    public OfferRequestDto() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public boolean isHidden() {
        return hidden;
    }

    @Override
    public String toString() {
        return "OfferRequestDto{" +
                "title='" + title + '\'' +
                ", descriptionLong='" + descriptionLong + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", hidden= " + hidden +
                '}';
    }
}
