package unmsm.com.logingooglelap.model;

import java.util.List;

/**
 * Created by Luis on 9/11/2017.
 */

/**
 * Esta clase almacena  los datos personales y academicos del docente; asi tambien su
 * disponibilidad horaria y sus cursos de preferencia
 */


public class Docente {

    private String dni;
    private String nombres;
    private String apellidos;
    private String categoria;
    private String clase;
    private String facultad;
    private String departamentoAcademico;
    private String correo;
    private int num_horas;
    private int intentos;
    private Disponibilidad disponibilidad;
    private List<Curso> cursosPreferencia;
    private List<Curso> cursosSeleccionados;



    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getDepartamentoAcademico() {
        return departamentoAcademico;
    }

    public void setDepartamentoAcademico(String departamentoAcademico) {
        this.departamentoAcademico = departamentoAcademico;
    }

    public int getNum_horas() {
        return num_horas;
    }

    public void setNum_horas(int num_horas) {
        this.num_horas = num_horas;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


    public List<Curso> getCursosPreferencia() {
        return cursosPreferencia;
    }

    public void setCursosPreferencia(List<Curso> cursosPreferencia) {
        this.cursosPreferencia = cursosPreferencia;
    }

    public List<Curso> getCursosSeleccionados() {
        return cursosSeleccionados;
    }

    public void setCursosSeleccionados(List<Curso> cursosSeleccionados) {
        this.cursosSeleccionados = cursosSeleccionados;
    }


    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}
