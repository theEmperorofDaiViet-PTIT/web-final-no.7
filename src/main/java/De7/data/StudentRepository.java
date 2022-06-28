package De7.data;

import org.springframework.data.repository.CrudRepository;

import De7.entity.Student;

public interface StudentRepository extends CrudRepository<Student, String>{
	
	public Student getById(String id);
}
