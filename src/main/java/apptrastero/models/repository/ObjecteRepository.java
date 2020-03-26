package apptrastero.models.repository;


import apptrastero.models.entity.Objecte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjecteRepository extends CrudRepository<Objecte, Long> {
}
