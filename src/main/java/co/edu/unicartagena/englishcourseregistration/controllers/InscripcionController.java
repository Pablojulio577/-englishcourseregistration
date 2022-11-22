package co.edu.unicartagena.englishcourseregistration.controllers;

import co.edu.unicartagena.englishcourseregistration.models.InscripcionModel;
import co.edu.unicartagena.englishcourseregistration.services.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/englishcourseregistration/inscripciones")
@CrossOrigin(origins = "*")
public class InscripcionController {

    @Autowired
    InscripcionService inscripcionService;

    @GetMapping
    public ResponseEntity<List<InscripcionModel>> obtenerInscripciones(){
        return inscripcionService.obtenerInscripciones();
    }

    @PostMapping
    public ResponseEntity<InscripcionModel> guardarInscripcion(@RequestBody InscripcionModel curso){
        return inscripcionService.guardarInscripcion(curso);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<InscripcionModel> eliminarInscripcion(@PathVariable("codigo") Long codigo){
        return inscripcionService.eliminarinscripcion(codigo);
    }
}
