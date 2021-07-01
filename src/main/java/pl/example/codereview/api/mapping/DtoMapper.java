package pl.example.codereview.api.mapping;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.example.codereview.infrastructure.config.SecurityUtils;
import pl.example.codereview.api.dto.OfferRequestDto;
import pl.example.codereview.api.dto.UserRequestDto;
import pl.example.codereview.domain.offer.Offer;
import pl.example.codereview.domain.user.User;

@Component
public class DtoMapper {

    private PasswordEncoder encoder;
    private SecurityUtils securityUtils;

    public DtoMapper(PasswordEncoder encoder, SecurityUtils securityUtils) {
        this.encoder = encoder;
        this.securityUtils = securityUtils;
    }

    public Offer offerRequestToOffer(OfferRequestDto dto) {
        return new Offer(
                dto.getTitle(),
                dto.getDescriptionLong(),
                securityUtils.getCurrentUserId(),
                dto.getQuantity(),
                dto.getPrice(),
                dto.isHidden()
        );
    }

    public User userRequestToUser(UserRequestDto dto) {
        return new User(
                dto.getName(),
                encoder.encode(dto.getPassword()),
                dto.getMail(),
                dto.getPhone(),
                dto.getLogin(),
                dto.isAdmin()
        );
    }

}
