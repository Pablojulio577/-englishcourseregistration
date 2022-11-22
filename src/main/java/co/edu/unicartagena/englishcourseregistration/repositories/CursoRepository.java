package co.edu.unicartagena.englishcourseregistration.repositories;

import co.edu.unicartagena.englishcourseregistration.models.CursoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CursoRepository extends CrudRepository<CursoModel, Long> {
}
