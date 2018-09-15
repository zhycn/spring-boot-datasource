package xbird.datasource.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xbird.datasource.jpa.domain.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer> {

}
