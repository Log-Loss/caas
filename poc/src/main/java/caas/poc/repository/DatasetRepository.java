package caas.poc.repository;

import caas.poc.entity.Dataset;
import caas.poc.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasetRepository extends JpaRepository<Dataset, Integer> {

}