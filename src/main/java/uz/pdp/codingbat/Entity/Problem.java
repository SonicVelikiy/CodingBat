package uz.pdp.codingbat.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String probName;

    private boolean statusProblemForUser;

    @ManyToOne
    private ProblemCategory problemCategory;

    @ManyToOne
    private Users users;

}
