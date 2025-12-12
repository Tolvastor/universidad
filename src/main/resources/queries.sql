-- 1
--  Devuelve un listado con el primer apellido, segundo apellido y el nombre de todos los alumnos. El listado deberá estar ordenado alfabéticamente de menor a mayor por el primer apellido, segundo apellido y nombre.
select apellido1, apellido2, nombre from persona where tipo = 'alumno' order by apellido1, apellido2, nombre;
--  2
--  Averigua el nombre y los dos apellidos de los alumnos que no han dado de alta su número de teléfono en la base de datos.
select nombre, apellido1, apellido2 from persona where tipo = 'alumno' and (telefono is null or telefono = '');
--  3
--  Devuelve el listado de los alumnos que nacieron en 1999.
select * from persona where tipo = 'alumno' and YEAR(fecha_nacimiento) = 1999;
--  4
--  Devuelve el listado de profesores que no han dado de alta su número de teléfono en la base de datos y además su nif termina en K.
select * from persona where tipo = 'profesor' and (telefono is null or telefono = '') and nif like '%K';
--  5
--  Devuelve el listado de las asignaturas que se imparten en el primer cuatrimestre, en el tercer curso del grado que tiene el identificador 7.
select * from asignatura where cuatrimestre = 1 and curso = 3 and id_grado = 7;
--  6
--  Devuelve un listado con el nombre de las asignaturas, año de inicio y año de fin del curso escolar del alumno con nif 26902806M.

--  7
--  Devuelve un listado con el nombre de todos los departamentos que tienen profesores que imparten alguna asignatura en el Grado en Ingeniería Informática (Plan 2015).
select * from grado where nombre  like '%Grado en Ingeniería Informática (Plan 2015)%';


--  8
--  Devuelve un listado con todos los alumnos que se han matriculado en alguna asignatura durante el curso escolar 2018/2019.
select * from curso_escolar  where anyo_inicio = 2018 and anyo_fin = 2019;


--  9
--  Devuelve un listado con los profesores que no imparten ninguna asignatura.


--  10
--  Devuelve un listado con las asignaturas que no tienen un profesor asignado.

