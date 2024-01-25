package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Student;
import in.ineuron.service.IStudentService;


@RestController
@RequestMapping(value = "/api/student")
public class StudentRestController {
	
	@Autowired
	private IStudentService service;
	
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		String body = service.saveStudent(student);
		return new ResponseEntity<String>(body, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<?> displayStudents(){
		List<Student> students = service.findAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	
	@GetMapping(value = "/find/{id}")
	public ResponseEntity<?> displayStudentById(@PathVariable(value = "id") Integer id){
		Student student = service.findById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	
	@PutMapping(value = "/modify")
	public ResponseEntity<String> updateStudent(@RequestBody Student student){
		String updatedStudent = service.updateStudent(student);
		return new ResponseEntity<String>(updatedStudent, HttpStatus.OK);
	}

	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteStudentByID(@PathVariable(value = "id") Integer id){
		String body = service.deleteById(id);
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
	
}
