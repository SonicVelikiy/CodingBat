package uz.pdp.codingbat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.codingbat.Entity.Problem;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {

    boolean existsByProbName(String probName);

    boolean existsByProbNameAndIdNot(String probName, Integer id);
}
