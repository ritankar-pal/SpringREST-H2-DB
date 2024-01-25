package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IStudentDAO;
import in.ineuron.exception.StudentRecordNotFoundException;
import in.ineuron.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDAO dao;

	@Override
	public String saveStudent(Student student) {
		Student res = dao.save(student);
		return "Student saved with ID: " + res.getSid();
	}

	@Override
	public List<Student> findAllStudents() {
		return dao.findAll();
	}

	@Override
	public Student findById(Integer id) {
		Optional<Student> optional = dao.findById(id);

		if(optional.isPresent()) {
			return optional.get();
		}

		throw new StudentRecordNotFoundException("Student with ID: " + id + " not found.");
	}

	
	@Override
	public String updateStudent(Student student) {
		Student res = dao.save(student);
		return "Student Updated with ID: " + res.getSid();
	}

	
	@Override
	public String deleteById(Integer id) {

		Optional<Student> optional = dao.findById(id);

		if(optional.isPresent()) {
			dao.deleteById(id);
			return "Student deleted with ID: " + id;
		}
		throw new StudentRecordNotFoundException("Student with ID: " + id + " not found.");
	}

}
