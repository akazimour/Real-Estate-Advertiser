package Registration.ingatlan.dto;

import Registration.ingatlan.model.Interest;
import Registration.ingatlan.model.PropertyType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.List;

public class PropertyDto extends RepresentationModel<PropertyDto> {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private String settlement;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    private int referencePrice;

    private int phoneNumber;

    @OneToMany(mappedBy = "property")
    private List<Interest> interest;
    @JsonCreator
    public List<Interest> getInterest() {
        return interest;
    }
    @JsonCreator
    public void setInterest(List<Interest> interest) {
        this.interest = interest;
    }

    public PropertyDto() {
    }
    @JsonCreator
    public PropertyDto(@JsonProperty("id") Long id, @JsonProperty("title") String title, @JsonProperty("description") String description, @JsonProperty("creationDate") LocalDateTime creationDate, @JsonProperty("settlement") String settlement, @JsonProperty("propertyType") PropertyType propertyType, @JsonProperty("referencePrice") int referencePrice, @JsonProperty("phoneNumber") int phoneNumber) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.settlement = settlement;
        this.propertyType = propertyType;
        this.referencePrice = referencePrice;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public int getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(int referencePrice) {
        this.referencePrice = referencePrice;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", settlement='" + settlement + '\'' +
                ", propertyType=" + propertyType +
                ", referencePrice=" + referencePrice +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
