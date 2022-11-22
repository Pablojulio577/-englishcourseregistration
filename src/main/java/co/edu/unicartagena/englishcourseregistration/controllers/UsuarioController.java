package co.edu.unicartagena.englishcourseregistration.controllers;

import co.edu.unicartagena.englishcourseregistration.models.UsuarioModel;
import co.edu.unicartagena.englishcourseregistration.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/englishcourseregistration/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> guardarUsuario(@RequestBody UsuarioModel usuario){
        return usuarioService.crearusuario(usuario);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<UsuarioModel> actualizarCurso(@PathVariable("codigo") Long codigo, @RequestBody UsuarioModel usuario){
        return usuarioService.actualizarUsuario(codigo, usuario);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorCodigo(@PathVariable("codigo") Long codigo){
        return usuarioService.obtenerUsuarioPorCodigo(codigo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<UsuarioModel> eliminarUsuario(@PathVariable("codigo") Long codigo){
        return usuarioService.eliminarUsuario(codigo);
    }
}
