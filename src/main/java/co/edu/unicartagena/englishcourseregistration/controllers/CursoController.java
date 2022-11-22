package co.edu.unicartagena.englishcourseregistration.controllers;

import co.edu.unicartagena.englishcourseregistration.models.CursoModel;
import co.edu.unicartagena.englishcourseregistration.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/englishcourseregistration/cursos")
@CrossOrigin(origins = "*")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoModel>> obtenerCursos(){
        return cursoService.obtenerCursos();
    }

    @PostMapping
    public ResponseEntity<CursoModel> guardarCurso(@RequestBody CursoModel curso){
        return cursoService.crearCurso(curso);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<CursoModel> actualizarCurso(@PathVariable("codigo") Long codigo, @RequestBody CursoModel curso){
        return cursoService.actualizarCurso(codigo, curso);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<CursoModel> obtenerCursoPorCodigo(@PathVariable("codigo") Long codigo){
        return cursoService.obtenerCursoPorCodigo(codigo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<CursoModel> eliminarCurso(@PathVariable("codigo") Long codigo){
        return cursoService.eliminarCurso(codigo);
    }
}
