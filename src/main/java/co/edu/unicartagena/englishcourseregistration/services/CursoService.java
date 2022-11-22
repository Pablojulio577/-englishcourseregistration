package co.edu.unicartagena.englishcourseregistration.services;

import co.edu.unicartagena.englishcourseregistration.models.CursoModel;
import co.edu.unicartagena.englishcourseregistration.models.UsuarioModel;
import co.edu.unicartagena.englishcourseregistration.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public ResponseEntity<List<CursoModel>> obtenerCursos(){
        return new ResponseEntity(cursoRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<CursoModel> crearCurso(CursoModel curso){

        Optional<CursoModel> cursoAux = cursoRepository.findById(curso.getCodigo());

        if (!cursoAux.isEmpty())
            return new ResponseEntity("Ya existe un curso con el codigo "+ curso.getCodigo(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity(cursoRepository.save(curso), HttpStatus.OK);
    }

    public ResponseEntity<CursoModel> actualizarCurso(Long codigo, CursoModel nuevoCurso) {

        Optional<CursoModel> curso = cursoRepository.findById(codigo);

        if (curso.isEmpty())
            return new ResponseEntity("No se encontraron registros para el código "+ codigo, HttpStatus.BAD_REQUEST);

        nuevoCurso.setCodigo(curso.get().getCodigo());
        nuevoCurso.setNivel(nuevoCurso.getNivel() == null ? curso.get().getNivel(): nuevoCurso.getNivel());
        nuevoCurso.setProfesor(nuevoCurso.getProfesor() == null ? curso.get().getProfesor(): nuevoCurso.getProfesor());
        nuevoCurso.setHorario(nuevoCurso.getHorario() == null ? curso.get().getHorario(): nuevoCurso.getHorario());
        nuevoCurso.setAula(nuevoCurso.getAula() == null ? curso.get().getAula(): nuevoCurso.getAula());
        nuevoCurso.setCapacidad(nuevoCurso.getCapacidad() == null ? curso.get().getCapacidad(): nuevoCurso.getCapacidad());


        return new ResponseEntity(cursoRepository.save(nuevoCurso), HttpStatus.OK);
    }

    public ResponseEntity<CursoModel> obtenerCursoPorCodigo(Long codigo){
        Optional<CursoModel> curso = cursoRepository.findById(codigo);

        return curso.isEmpty()
                ? new ResponseEntity("No se encontraron cursos con el código "+ codigo, HttpStatus.BAD_REQUEST)
                : new ResponseEntity(curso, HttpStatus.OK);
    }

    public ResponseEntity<CursoModel> eliminarCurso(Long codigo){
        Optional<CursoModel> curso = cursoRepository.findById(codigo);

        if(curso.isEmpty())
            return new ResponseEntity("No se encontraron cursos con el código "+ codigo, HttpStatus.BAD_REQUEST);

        cursoRepository.deleteById(codigo);

        return new ResponseEntity("Se eliminó el curso con código "+ codigo, HttpStatus.OK);
    }
}
