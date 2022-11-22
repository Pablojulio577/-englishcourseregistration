package co.edu.unicartagena.englishcourseregistration.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cursos")
public class CursoModel implements Serializable {

    @Id
    private Long codigo;
    private Integer nivel;
    private String profesor;
    private String horario;
    private String aula;
    private Long capacidad;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Long getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Long capacidad) {
        this.capacidad = capacidad;
    }
}
