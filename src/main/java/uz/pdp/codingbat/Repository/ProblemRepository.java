package uz.pdp.codingbat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.codingbat.Entity.Problem;
import uz.pdp.codingbat.Entity.ProblemCategory;
import uz.pdp.codingbat.Entity.Users;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {

    boolean existsByProbNameAndUsersAndProblemCategory(String probName, Users users, ProblemCategory problemCategory);

    boolean existsByProbNameAndIdNot(String probName, Integer id);
}
