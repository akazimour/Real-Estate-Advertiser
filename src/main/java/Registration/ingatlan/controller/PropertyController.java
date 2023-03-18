package Registration.ingatlan.controller;

import Registration.ingatlan.Mapper.PropertyMapper;
import Registration.ingatlan.repository.PropertyRepo;
import Registration.ingatlan.service.PhoneNumberById;
import Registration.ingatlan.service.PropertyService;
import Registration.ingatlan.model.Property;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("api/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;
    @Autowired
    PropertyMapper propertyMapper;

    @Autowired
    PropertyRepo propertyRepo;


    @GetMapping
   public ResponseEntity<Collection<Property>> getAllProperties(){
        List<Property> allProp = propertyService.getAllProp();
        List<Property>response = new ArrayList<>();
        allProp.forEach(propertyDto -> { propertyDto.add(linkTo(methodOn(PropertyController.class).getPropById(propertyDto.getId(),null)).withSelfRel());
        });
        return new ResponseEntity<>(allProp,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @JsonIgnoreProperties(value = "phoneNumber")
    public ResponseEntity<Property> getPropById(@PathVariable Long id,Authentication authentication){
        Property byId = propertyService.getById(id,authentication);
        byId.setPhoneNumber(0);
        byId.add(linkTo(methodOn(PropertyController.class).getAllProperties()).withSelfRel());
        return new ResponseEntity<>(byId, HttpStatus.OK);

    }
    @GetMapping("/{id}/phoneNumber")
    public List<PhoneNumberById> retrievePhoneNumber(@PathVariable Long id, Authentication authentication){
       return propertyService.retrievePhoneNumber(id,authentication);
    }
    @PostMapping
    public ResponseEntity<Property> insertNewProperty(@RequestBody Property property){
        Property newProperty = propertyService.addNewProperty(property);
        newProperty.add(linkTo(methodOn(PropertyController.class).getPropById(property.getId(),null)).withSelfRel());
        return new ResponseEntity<>(newProperty,HttpStatus.OK);
}
    @GetMapping("/settings")
    public String index(Model model) {
        return "This is a new site";
    }

}
