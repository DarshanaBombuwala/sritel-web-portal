package sritel_web_portal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sritel_web_portal.demo.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
