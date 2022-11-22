package co.edu.unicartagena.englishcourseregistration.services;

import co.edu.unicartagena.englishcourseregistration.models.CursoModel;
import co.edu.unicartagena.englishcourseregistration.models.InscripcionModel;
import co.edu.unicartagena.englishcourseregistration.models.UsuarioModel;
import co.edu.unicartagena.englishcourseregistration.repositories.CursoRepository;
import co.edu.unicartagena.englishcourseregistration.repositories.InscripcionRepository;
import co.edu.unicartagena.englishcourseregistration.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    @Autowired
    InscripcionRepository inscripcionRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

    public ResponseEntity<List<InscripcionModel>> obtenerInscripciones(){
        return new ResponseEntity(inscripcionRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<InscripcionModel> guardarInscripcion(InscripcionModel inscripcion){
        Optional<UsuarioModel> usuario = usuarioRepository.findById(inscripcion.getCodigoAlumno());
        Optional<CursoModel> curso = cursoRepository.findById(inscripcion.getCodigoCurso());

        if(usuario.isEmpty())
            return new ResponseEntity("No existe un usuario con código " + inscripcion.getCodigoAlumno(), HttpStatus.BAD_REQUEST);

        if(curso.isEmpty())
            return new ResponseEntity("No existe un curso con código " + inscripcion.getCodigoCurso(), HttpStatus.BAD_REQUEST);


        inscripcion.setCodigoAlumno(usuario.get().getCodigo());
        inscripcion.setCodigoCurso(curso.get().getCodigo());
        inscripcion.setFechaInscripcion(inscripcion.getFechaInscripcion() == null ? LocalDateTime.now(): inscripcion.getFechaInscripcion());

        return new ResponseEntity(inscripcionRepository.save(inscripcion), HttpStatus.OK);
    }

    public ResponseEntity<InscripcionModel> eliminarinscripcion(Long id){
        Optional<InscripcionModel> inscripcion = inscripcionRepository.findById(id);

        if(inscripcion.isEmpty())
            return new ResponseEntity("No se encontraron registros para el ID "+ id, HttpStatus.BAD_REQUEST);

        inscripcionRepository.deleteById(id);

        return new ResponseEntity("Se eliminó el registro con ID "+ id, HttpStatus.OK);
    }
}
