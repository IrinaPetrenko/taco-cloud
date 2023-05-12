package tacos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "Taco_Order")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Field is required")
    public String name;
    @NotBlank(message = "Field is required")
    public String street;
    @NotBlank(message = "Field is required")
    public String city;
    @NotBlank(message = "Field is required")
    public String state;
    @NotBlank(message = "Field is required")
    public String zip;
    @CreditCardNumber(message = "Not a valid card number")
    public String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    public String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    public String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    public List<Taco> tacos = new ArrayList<>();
    private Date placedAt;

    public void addDesign(Taco taco) {
        this.tacos.add(taco);
    }

    @PrePersist
    private void placedAt() {
        this.placedAt = new Date();
    }

    public Order appendFields(Order fromRequest) {
        this.name = fromRequest.getName();
        this.street = fromRequest.getStreet();
        this.city = fromRequest.getCity();
        this.state = fromRequest.getState();
        this.zip = fromRequest.getZip();
        this.ccNumber = fromRequest.getCcNumber();
        this.ccExpiration = fromRequest.getCcExpiration();
        this.ccCVV = fromRequest.getCcCVV();
        return this;
    }
}
