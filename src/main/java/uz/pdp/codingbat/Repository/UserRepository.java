package uz.pdp.codingbat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.codingbat.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
}
