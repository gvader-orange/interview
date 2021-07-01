package pl.example.codereview.api;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/tech")
@Component
public class TechEndpoint {

    @GetMapping("/health")
    @ResponseBody
    public boolean healthCheck() {
        return true;
    }
}
