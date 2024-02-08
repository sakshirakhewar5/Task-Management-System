package Task.Management.System.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Task.Management.System.example.Repository.TaskRepository;

@SpringBootApplication
public class TaskManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementSystemApplication.class, args);
		System.out.println("Task Mangement System Run...");
	}
	@Autowired
	private TaskRepository taskRepository;
	
	public void run(String... args) throws Exception {
		/*
		
		 Student student1 = new Student("Ramesh", "Fadatare", "ramesh@gmail.com");
		 studentRepository.save(student1);
		 
		  
		*/
	}

}
