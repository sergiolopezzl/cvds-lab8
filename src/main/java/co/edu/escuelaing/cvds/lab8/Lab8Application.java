package co.edu.escuelaing.cvds.lab8;
import co.edu.escuelaing.cvds.lab8.model.Configuration;
import co.edu.escuelaing.cvds.lab8.model.Employee;
import co.edu.escuelaing.cvds.lab8.service.EmployeeService;
import co.edu.escuelaing.cvds.lab8.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab8Application {
	final
	ConfigurationService configurationService;
	EmployeeService employeeService;

	public Lab8Application(ConfigurationService configurationService) {
		this.configurationService = configurationService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab8Application.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {
			//employeeService.agregarEmpleado(new Employee("1","sergio"));
			System.out.println("Adding Configurations....");
			configurationService.addConfiguration(new Configuration("premio", "800000"));

			System.out.println("\nGetting all configurations....");
			configurationService.getAllConfigurations().forEach(configuration -> System.out.println(configuration));
		};
	}

}
