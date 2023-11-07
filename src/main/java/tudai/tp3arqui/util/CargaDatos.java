package tudai.tp3arqui.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import tudai.tp3arqui.model.Carrera;
import tudai.tp3arqui.model.Estudiante;
import tudai.tp3arqui.model.Matricula;
import tudai.tp3arqui.repository.CarreraRepository;
import tudai.tp3arqui.repository.EstudianteRepository;
import tudai.tp3arqui.repository.MatriculaRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@Component
public class CargaDatos {

    @Autowired
    CarreraRepository carreraRepository;
    @Autowired
    MatriculaRepository matriculaRepository;
    @Autowired
    EstudianteRepository estudianteRepository;


    public void cargarDatosDesdeCSV()throws Exception, IOException {
        cargarDatosCarreras();
        cargarDatosEstudiantes();
        cargarDatosMatriculaciones();
    }


    public  void cargarDatosCarreras()throws IOException {
        File carrerasCSV = ResourceUtils.getFile("src/main/resources/csv/carreras.csv");

        try(FileReader reader = new FileReader(carrerasCSV);
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)){

            for(CSVRecord csvRecord : csvParser){
                Carrera carrera = new Carrera();
                carrera.setNombre(csvRecord.get("carrera"));
                carrera.setDuracion(Integer.parseInt(csvRecord.get("duracion")));
                carrera.setIdCarrera(Long.parseLong(csvRecord.get("id_carrera")));

                this.carreraRepository.save(carrera);
            }
        }
    }

    public void  cargarDatosEstudiantes()throws  IOException{
        File estudianteCSV = ResourceUtils.getFile("src/main/resources/csv/estudiantes.csv");

        try(FileReader reader = new FileReader(estudianteCSV);
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)){

            for(CSVRecord csvRecord : csvParser){
                Estudiante estudiante = new Estudiante();
                estudiante.setDni(Long.parseLong(csvRecord.get("DNI")));
                estudiante.setLu(Integer.parseInt(csvRecord.get("LU")));
                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                estudiante.setApellido(csvRecord.get("apellido"));
                estudiante.setNombre(csvRecord.get("nombre"));
                estudiante.setGenero(csvRecord.get("genero"));
                estudiante.setDireccion(csvRecord.get("ciudad"));

                this.estudianteRepository.save(estudiante);
            }
        }
    }

    public void cargarDatosMatriculaciones()throws IOException{

        File matriculacionCSV = ResourceUtils.getFile("src/main/resources/csv/estudianteCarrera.csv");

        try(FileReader reader = new FileReader(matriculacionCSV);
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for(CSVRecord csvRecord : csvParser){
                Matricula matriculacion = new Matricula();

                //Agrega Estudiante a Matriculacion
                Estudiante estudianteAgregar = new Estudiante();
                estudianteAgregar.setDni(Long.parseLong(csvRecord.get("id_estudiante")));
                matriculacion.setEstudiante(estudianteAgregar);

                //Agrega Carrera a Matriculación
                Carrera  carreraElegida = new Carrera();
                carreraElegida.setIdCarrera(Long.parseLong(csvRecord.get("id_carrera")));
                matriculacion.setCarrera(carreraElegida);

                matriculacion.setId(Long.parseLong(csvRecord.get("id")));
                matriculacion.setInscripcion(Integer.parseInt(csvRecord.get("inscripcion")));
                matriculacion.setGraduacion(Integer.parseInt(csvRecord.get("graduacion")));
                matriculacion.setAntiguedad(Integer.parseInt(csvRecord.get("antiguedad")));

                matriculaRepository.save(matriculacion);
            }
        }
    }
}
