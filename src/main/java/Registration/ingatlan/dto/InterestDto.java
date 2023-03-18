package Registration.ingatlan.dto;

import Registration.ingatlan.model.InterestType;
import Registration.ingatlan.model.Property;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class InterestDto {
    private Long id;
    private LocalDateTime interestDate;
    private String interestedUser;
    private InterestType interestType;

    @ManyToOne
    private Property property;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public InterestDto() {
    }

    public InterestDto(String interestedUser, InterestType interestType) {
        this.interestedUser = interestedUser;
        this.interestType = interestType;
        this.interestDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInterestDate() {
        return interestDate;
    }

    public void setInterestDate(LocalDateTime interestDate) {
        this.interestDate = interestDate;
    }

    public String getInterestedUser() {
        return interestedUser;
    }

    public void setInterestedUser(String interestedUser) {
        this.interestedUser = interestedUser;
    }

    public InterestType getInterestType() {
        return interestType;
    }

    public void setInterestType(InterestType interestType) {
        this.interestType = interestType;
    }
}
