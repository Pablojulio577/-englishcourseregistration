package co.edu.unicartagena.englishcourseregistration.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "inscripciones")
public class InscripcionModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigoAlumno;
    private Long codigoCurso;
    private LocalDateTime fechaInscripcion;

    public Long getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(Long codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public Long getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Long codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
