package uz.pdp.codingbat.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProblemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String categoryName;

    @Column(nullable = false)
    private Integer categoryLevel;

    @ManyToOne
    private ProgramingLanguage programingLanguage;
}
