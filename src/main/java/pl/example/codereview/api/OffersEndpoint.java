package pl.example.codereview.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.example.codereview.api.dto.OfferRequestDto;
import pl.example.codereview.api.mapping.DtoMapper;
import pl.example.codereview.domain.offer.OfferController;
import pl.example.codereview.domain.offer.Offer;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/offers")
@RestController
public class OffersEndpoint {

    private DtoMapper dtoMapper;
    private OfferController offerController;

    @Autowired
    public OffersEndpoint(DtoMapper mapper, OfferController offerController) {
        this.dtoMapper = mapper;
        this.offerController = offerController;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addOffer(@RequestBody @Valid OfferRequestDto offer) {
        System.out.println("[POST] /api/offers-> offer: " + offer.toString());
        offerController.addOffer(dtoMapper.offerRequestToOffer(offer));
    }

    @GetMapping()
    public List<Offer> getOffers(@RequestParam String parameter) {
        System.out.println("[GET] /api/offers -> parameter: " + parameter);
        return offerController.findBySearchParam(parameter);
    }

    @GetMapping("{id}")
    public Offer getOffer(@PathVariable int id) {
        System.out.println("[GET] /api/offers/" + id);
        return offerController.getOfferById(id);
    }
}
