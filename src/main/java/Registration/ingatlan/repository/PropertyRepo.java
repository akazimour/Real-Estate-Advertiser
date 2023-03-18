package Registration.ingatlan.repository;

import Registration.ingatlan.model.Property;
import Registration.ingatlan.service.PhoneNumberById;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropertyRepo extends JpaRepository<Property,Long> {

    @Query(" SELECT p.phoneNumber AS phoneNumber FROM Property p WHERE p.id =:id ")
   List<PhoneNumberById> findByIdWithPhoneNumber(Long id);

    @Query("SELECT DISTINCT p FROM Property p LEFT JOIN FETCH p.interest ")
    List<Property> findAllWithInterest();

}
