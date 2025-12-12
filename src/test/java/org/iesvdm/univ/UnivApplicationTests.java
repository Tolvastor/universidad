package org.iesvdm.univ;

import org.iesvdm.univ.modelo.*;
import org.iesvdm.univ.repositorio.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UnivApplicationTests {

    @Autowired
    AlumnoSeMatriculaAsignaturaRepository alumnoSeMatriculaAsignaturaRepository;

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Autowired
    CursoEscolarRepository cursoEscolarRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    GradoRepository gradoRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Test

    void contextLoads() {

        personaRepository.findAll().forEach(System.out::println);

    }


 /*    1
    Devuelve un listado con el primer apellido, segundo apellido y el nombre de todos los alumnos. El listado deberá estar ordenado alfabéticamente de menor a mayor por el primer apellido, segundo apellido y nombre.
*/
@Test
    void tes1() {
   // List<Asignatura> asignaturas = asignaturaRepository.findAll().stream()
     //       .filter()



}

 /* 2
    Averigua el nombre y los dos apellidos de los alumnos que no han dado de alta su número de teléfono en la base de datos.
*/
 @Test
 void  tes2() {
        List<Persona> sinTelefono = personaRepository.findAll().stream()
                .filter(p -> p.getTelefono() == null || p.getTelefono().isEmpty())
                .toList();
        sinTelefono.forEach(p -> System.out.println(p.getNombre() + " " + p.getApellido1() + " " + p.getApellido2()));
 }



 /*3
    Devuelve el listado de los alumnos que nacieron en 1999.
*/
@Test
    void  tes3() {
    List<Persona> nacimiento = personaRepository.findAll().stream()
            .filter(p -> p.getFechaNacimiento().getYear() == 1999)
            .toList();
    nacimiento.forEach(p-> System.out.println(p.getNombre()+" " + p.getFechaNacimiento()));

}


/* 4
    Devuelve el listado de profesores que no han dado de alta su número de teléfono en la base de datos y además su nif termina en K.
*/
    @Test
        void tes4() {
        List<Persona> profesorAlta = personaRepository.findAll().stream()
                .filter(p -> p.getTelefono() != null && p.getNif().endsWith("*K"))
                .toList();
        profesorAlta.forEach(p -> System.out.println(p.getTelefono() + " " + p.getNif()));

    }
    /*
5
 Devuelve el listado de las asignaturas que se imparten en el primer cuatrimestre, en el tercer curso del grado que tiene el identificador 7.

 */
    @Test
    void tes5(){

    }



 /* 6
    Devuelve un listado con el nombre de las asignaturas, año de inicio y año de fin del curso escolar del alumno con nif 26902806M.
*/
    @Test
    void tes6() {
        List<AlumnoSeMatriculaAsignatura> asignaturasAlumno = alumnoSeMatriculaAsignaturaRepository.findAll().stream()
                .filter(a -> a.getIdAlumno().getNif().equals("26902806M"))
                .toList();
        asignaturasAlumno.forEach(a -> System.out.println(a.getIdAsignatura().getNombre() + " " +
                a.getIdCursoEscolar().getAnyoInicio() + " " + a.getIdCursoEscolar().getAnyoFin()));
    }
/*
7
 Devuelve un listado con el nombre de todos los departamentos que tienen profesores que imparten alguna asignatura en el Grado en Ingeniería Informática (Plan 2015).

 */
    @Test
    void tes7(){

    }


   /*  8
    Devuelve un listado con todos los alumnos que se han matriculado en alguna asignatura durante el curso escolar 2018/2019.
    */
    @Test
    void tes8() {
        List<AlumnoSeMatriculaAsignatura> alumnoMatriculado = alumnoSeMatriculaAsignaturaRepository.findAll().stream()
                .filter(a -> a.getIdCursoEscolar().getAnyoInicio() == 2018 && a.getIdCursoEscolar().getAnyoFin() == 2019)
                .toList();
        alumnoMatriculado.forEach(a -> System.out.println(a.getIdAlumno()));

    }
    /* 9
    Devuelve un listado con los profesores que no imparten ninguna asignatura.
    */
    @Test
    void tes9() {

        List<Profesor> profesorNoAsignaturas = profesorRepository.findAll().stream()
                .filter(p -> p.getAsignaturas() == null || p.getAsignaturas().isEmpty())
                .toList();
        profesorNoAsignaturas.forEach(p-> System.out.println(p.getPersona().getNombre()));
    }

    /* 10
    Devuelve un listado con las asignaturas que no tienen un profesor asignado.
        */
    @Test
    void tes10() {
        List<Asignatura> asignaturaNoProfesor = asignaturaRepository.findAll().stream()
                .filter(a -> a.getIdProfesor() == null)
                .toList();

    }

}