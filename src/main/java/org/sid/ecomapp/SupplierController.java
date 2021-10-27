package org.sid.ecomapp;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class SupplierController {

    @Autowired
    KeycloakRestTemplate keycloakRestTemplate;

    @GetMapping("suppliers")
    public String index(Model model) {
        ResponseEntity<PagedModel<Supplier>> responseEntity = keycloakRestTemplate.exchange("http://localhost:8083/suppliers", HttpMethod.GET, null, new ParameterizedTypeReference<PagedModel<Supplier>>() { } );
        model.addAttribute("suppliers", responseEntity.getBody().getContent());
        return "suppliers";

    }
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Model model) {
        model.addAttribute("errorMessage", "Not Authorized");
        return "errors";
    }

}
