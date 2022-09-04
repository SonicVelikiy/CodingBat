package uz.pdp.codingbat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.codingbat.Entity.Helper;

@Repository
public interface HelperRepository extends JpaRepository<Helper, Integer> {
}
