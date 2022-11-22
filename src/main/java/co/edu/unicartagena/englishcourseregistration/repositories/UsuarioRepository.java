package co.edu.unicartagena.englishcourseregistration.repositories;

import co.edu.unicartagena.englishcourseregistration.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
}
