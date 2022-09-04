package uz.pdp.codingbat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.codingbat.Entity.ProblemCategory;

@Repository
public interface ProblemCategoryRepository extends JpaRepository<ProblemCategory, Integer> {
    boolean existsByCategoryName(String categoryName);

    boolean existsByCategoryNameAndIdNot(String categoryName, Integer id);

}
