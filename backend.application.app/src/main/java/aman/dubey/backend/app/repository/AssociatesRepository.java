package aman.dubey.backend.app.repository;

import aman.dubey.backend.app.model.Associates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociatesRepository extends JpaRepository<Associates, Long> {
}
