package tudai.tp3arqui;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tudai.tp3arqui.util.CargaDatos;
import java.io.IOException;

@SpringBootApplication
public class Tp3arquiApplication {


	@Autowired
	CargaDatos cargarDatos;

	public static void main(String[] args) {
		SpringApplication.run(Tp3arquiApplication.class, args);
	}


	@PostConstruct
	public void init() throws Exception, IOException {
		cargarDatos.cargarDatosDesdeCSV();
	}
}
