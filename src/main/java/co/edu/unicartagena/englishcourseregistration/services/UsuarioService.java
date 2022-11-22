package co.edu.unicartagena.englishcourseregistration.services;

import co.edu.unicartagena.englishcourseregistration.models.UsuarioModel;
import co.edu.unicartagena.englishcourseregistration.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ResponseEntity<List<UsuarioModel>> obtenerUsuarios(){
        return new ResponseEntity(usuarioRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<UsuarioModel> crearusuario(UsuarioModel usuario){
        Optional<UsuarioModel> usuarioAux = usuarioRepository.findById(usuario.getCodigo());

        if (!usuarioAux.isEmpty())
            return new ResponseEntity("Ya existe un usuario con el codigo "+ usuario.getCodigo(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity(usuarioRepository.save(usuario), HttpStatus.OK);
    }

    public ResponseEntity<UsuarioModel> actualizarUsuario(Long codigo, UsuarioModel nuevoUsuario) {

        Optional<UsuarioModel> usuario = usuarioRepository.findById(codigo);

        if (usuario.isEmpty())
            return new ResponseEntity("No se encontraron registros para el código "+ codigo, HttpStatus.BAD_REQUEST);

        nuevoUsuario.setCodigo(usuario.get().getCodigo());
        nuevoUsuario.setNombre(nuevoUsuario.getNombre() == null ? usuario.get().getNombre(): nuevoUsuario.getNombre());
        nuevoUsuario.setCorreo(nuevoUsuario.getCorreo() == null ? usuario.get().getCorreo(): nuevoUsuario.getCorreo());
        nuevoUsuario.setTelefono(nuevoUsuario.getTelefono() == null ? usuario.get().getTelefono(): nuevoUsuario.getTelefono());
        nuevoUsuario.setContrasena(nuevoUsuario.getContrasena() == null ? usuario.get().getContrasena(): nuevoUsuario.getContrasena());
        nuevoUsuario.setRol(nuevoUsuario.getRol() == null ? usuario.get().getRol(): nuevoUsuario.getRol());

        return new ResponseEntity(usuarioRepository.save(nuevoUsuario), HttpStatus.OK);
    }

    public ResponseEntity<UsuarioModel> obtenerUsuarioPorCodigo(Long codigo){
        Optional<UsuarioModel> usuario = usuarioRepository.findById(codigo);

        return usuario.isEmpty()
                ? new ResponseEntity("No se encontraron registros para el código "+ codigo, HttpStatus.BAD_REQUEST)
                : new ResponseEntity(usuario, HttpStatus.OK);
    }

    public ResponseEntity<UsuarioModel> eliminarUsuario(Long codigo){
        Optional<UsuarioModel> usuario = usuarioRepository.findById(codigo);

        if(usuario.isEmpty())
            return new ResponseEntity("No se encontraron registros para el código "+ codigo, HttpStatus.BAD_REQUEST);

        usuarioRepository.deleteById(codigo);

        return new ResponseEntity("Se eliminó el usuario con código "+ codigo, HttpStatus.OK);
    }
}
