package Registration.ingatlan.Mapper;

import Registration.ingatlan.dto.PropertyDto;
import Registration.ingatlan.model.Property;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropertyMapper {

    @Mapping(target = "phoneNumber", ignore = true)
    @Named("sum")
    PropertyDto propertyToSummaryDto (Property property);
    @IterableMapping(qualifiedByName = "sum")
    List<PropertyDto> propertiesToSummaryDtos (List<Property> property);
    @Mapping(target = "phoneNumber", ignore = true)
    @Named("summary")
    PropertyDto propertyToDto (Property property);
    @Mapping(target = "phoneNumber", ignore = true)
    Property propertyDtoToProperty (PropertyDto propertyDto);
    @IterableMapping(qualifiedByName = "summary")
    List<PropertyDto> propertiesToDtos (List<Property> property);
}
