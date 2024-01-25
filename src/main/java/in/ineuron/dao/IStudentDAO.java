package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Student;

public interface IStudentDAO extends JpaRepository<Student, Integer> {
}
