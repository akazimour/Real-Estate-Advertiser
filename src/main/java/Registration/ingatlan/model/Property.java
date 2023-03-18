package Registration.ingatlan.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Property extends RepresentationModel<Property> {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private String settlement;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    private int referencePrice;
    private int phoneNumber;

    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Interest> interest;
    @JsonCreator
    public List<Interest> getInterest() {
        return interest;
    }
    @JsonCreator
    public void setInterest(List<Interest> interest) {
        this.interest = interest;
    }

    public Property() {
    }
@JsonCreator
    public Property(@JsonProperty("id") Long id, @JsonProperty("title") String title, @JsonProperty("description") String description, @JsonProperty("creationDate") LocalDateTime creationDate, @JsonProperty("settlement") String settlement, @JsonProperty("propertyType") PropertyType propertyType, @JsonProperty("referencePrice") int referencePrice, @JsonProperty("phoneNumber") int phoneNumber) {
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

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addInterestToProperty(Interest addedInterest) {
        if (this.interest == null)
            this.interest= new ArrayList<>();
        addedInterest.setProperty(this);
        this.interest.add(addedInterest);
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
