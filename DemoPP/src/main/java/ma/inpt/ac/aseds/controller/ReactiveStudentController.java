package ma.inpt.ac.aseds.controller;

import org.springframework.web.bind.annotation.*;
import ma.inpt.ac.aseds.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive/students")
public class ReactiveStudentController {
    
    @GetMapping
    public Flux<Student> getAllStudents() {
        return Flux.just(
            new Student().setId(1L).setName("John").setEmail("john@example.com"),
            new Student().setId(2L).setName("Jane").setEmail("jane@example.com")
        );
    }

    @PostMapping
    public Mono<Student> createStudent(@RequestBody Student student) {
        return Mono.just(student)
                   .map(s -> {
                       s.setId(System.currentTimeMillis());
                       return s;
                   });
    }
}
