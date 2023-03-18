package Registration.ingatlan.service;

import Registration.ingatlan.model.Interest;
import Registration.ingatlan.model.InterestType;
import Registration.ingatlan.model.Property;
import Registration.ingatlan.repository.InterestRepo;
import Registration.ingatlan.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    PropertyRepo propertyRepo;

    @Autowired
    InterestRepo interestRepo;

    public List<Property> getAllProp() {
        return propertyRepo.findAllWithInterest();
    }

    @Transactional
    public Property getById(Long id, Authentication authentication) throws ConcurrentModificationException {
        Optional<Property> byId = propertyRepo.findById(id);
        if (byId.isPresent()) {
            Property property = byId.get();
            Interest notSerious = new Interest(authentication.getName(), InterestType.WITHOUT_PHONE_NUMBER);
            Interest Serious = new Interest(authentication.getName(), InterestType.WITH_PHONE_NUMBER);
            List<Interest> interest = property.getInterest();
            if (!interest.isEmpty()) {
                if (interest.stream().filter(interest1 -> interest1.getInterestedUser().equals(authentication.getName()) && interest1.getInterestType().equals(InterestType.WITHOUT_PHONE_NUMBER)).findAny().isPresent()) {
                    System.out.println("This User Already Interested in this Property with id: " + id);
                } else if (interest.stream().filter(interest1 -> interest1.getInterestedUser().equals(authentication.getName()) && interest1.getInterestType().equals(InterestType.WITH_PHONE_NUMBER)).findAny().isPresent()) {
                    property.addInterestToProperty(notSerious);
                    notSerious.setProperty(property);
                }
            } else if (interest.isEmpty()) {
                property.addInterestToProperty(notSerious);
                notSerious.setProperty(property);
            }
            return property;
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Address does not exist with id: " + id);
    }

    public Property addNewProperty(Property property) {
        return propertyRepo.save(property);
    }


    @Transactional
    public List<PhoneNumberById> retrievePhoneNumber(Long id, Authentication authentication) {
        List<PhoneNumberById> byIdWithPhoneNumber = propertyRepo.findByIdWithPhoneNumber(id);
        Optional<Property> byId = propertyRepo.findById(id);
        if (byId.isPresent()) {
            Property property = byId.get();
            Interest notSerious = new Interest(authentication.getName(), InterestType.WITHOUT_PHONE_NUMBER);
            Interest Serious = new Interest(authentication.getName(), InterestType.WITH_PHONE_NUMBER);
            List<Interest> interest = property.getInterest();
            if (!interest.isEmpty()) {
                if (interest.stream().filter(interest1 -> interest1.getInterestedUser().equals(authentication.getName()) && interest1.getInterestType().equals(InterestType.WITH_PHONE_NUMBER)).findAny().isPresent()) {
                } else if (interest.stream().filter(interest1 -> interest1.getInterestedUser().equals(authentication.getName()) && interest1.getInterestType().equals(InterestType.WITHOUT_PHONE_NUMBER)).findAny().isPresent()) {
                    property.addInterestToProperty(notSerious);
                    notSerious.setProperty(property);
                }
            } else if (interest.isEmpty()) {
                property.addInterestToProperty(Serious);
                Serious.setProperty(property);
            }
            return byIdWithPhoneNumber;
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Phone number does not exist with id: " + id);

    }

}
