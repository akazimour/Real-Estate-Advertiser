package Registration.ingatlan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Interest {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime interestDate;
    private String interestedUser;
    @Enumerated(EnumType.STRING)
    private InterestType interestType;
@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Property property;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Interest() {
    }

    public Interest(String interestedUser, InterestType interestType) {
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
