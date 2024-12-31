package ma.inpt.ac.aseds.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ma.inpt.ac.aseds.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentWebClient {
    
    private final WebClient webClient;
    
    public StudentWebClient(WebClient webClient) {
        this.webClient = webClient;
    }
    
    public Flux<Student> getAllStudents() {
        return webClient.get()
                       .uri("/reactive/students")
                       .retrieve()
                       .bodyToFlux(Student.class);
    }
    
    public Mono<Student> createStudent(Student student) {
        return webClient.post()
                       .uri("/reactive/students")
                       .bodyValue(student)
                       .retrieve()
                       .bodyToMono(Student.class);
    }
}
