package ma.inpt.ac.aseds.model;

public class Student {
    private Long id;
    private String name;
    private String email;
    
    public Long getId() {
        return id;
    }
    public Student setId(Long id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }
    // public Student setName(String name) {
    //     this.name = name;
    //     return this;
    // }
    public String getEmail() {
        return email;
    }
    // public Student setEmail(String email) {
    //     this.email = email;
    //     return this;
    // }

    // public Student setId(Long id) {
    //     this.id = id;
    //     return this;
    // }
    
    public Student setName(String name) {
        this.name = name;
        return this;
    }
    
    public Student setEmail(String email) {
        this.email = email;
        return this;
    }
}
