package tacos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;


@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=5, message="Name must be at least 5 symbols")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min=1, message="Chose at least 1 ingredient")
    private List<Ingredient> ingredients;

    private Date createdAt;

    @PrePersist
    @Column(name = "created_at")
    void createdAt() {
        this.createdAt = new Date();
    }

}
