package uz.pdp.codingbat.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Helper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String helperTitle;

    @Column(nullable = false)
    private String helperContent;

    @ManyToOne
    private ProgramingLanguage programingLanguage;
}
