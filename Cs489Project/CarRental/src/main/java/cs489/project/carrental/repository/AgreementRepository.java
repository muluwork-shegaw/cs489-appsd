package cs489.project.carrental.repository;

import cs489.project.carrental.model.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, String> {
    // Methods to manage agreements can be defined here.
}
