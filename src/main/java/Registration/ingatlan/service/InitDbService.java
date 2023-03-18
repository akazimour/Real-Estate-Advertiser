package Registration.ingatlan.service;

import Registration.ingatlan.model.Property;
import Registration.ingatlan.model.PropertyType;
import Registration.ingatlan.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class InitDbService {

    @Autowired
    PropertyRepo propertyRepo;
    @Transactional
   public void addProperties(){
       Property first = new Property(1L,"Family House for Selling","Good quality refurbished family house can be purchased", LocalDateTime.of(2019, 7, 15, 8, 9),"Budapest", PropertyType.HOUSE,45000000,20945190 );
       Property second = new Property(2L,"Refurbished Flat for Selling","Good quality refurbished flat can be purchased", LocalDateTime.of(2019, 7, 15, 8, 9),"Székesfehérvár", PropertyType.FLAT,25000000,304548855 );
propertyRepo.save(first);
propertyRepo.save(second);
   }

}
