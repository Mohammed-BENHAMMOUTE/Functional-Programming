package ma.inpt.ac.aseds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ma.inpt.ac.aseds.client.StudentWebClient;
import ma.inpt.ac.aseds.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoPpApplication implements CommandLineRunner {
	@Autowired
	private StudentWebClient studentWebClient;
	

	public static void main(String[] args) {
		SpringApplication.run(DemoPpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student newStudent = new Student().setEmail("email@EMAIL.com").setName("Mohammed BENHAMMOUTE");
		Mono<Student> studentMono = studentWebClient.createStudent(newStudent);
		studentMono.subscribe(System.out::println);

		Flux<Student> allStudents = studentWebClient.getAllStudents();
		allStudents.subscribe(System.out::println);
	}

}
