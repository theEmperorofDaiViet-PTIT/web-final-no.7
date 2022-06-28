package De7.entity;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.Data;


@Data
@Entity
@Table(name="Students")
public class Student {
	
	@Id
	@NotNull
	@NotBlank(message="Id is required!")
	private String id;
	
	@NotNull
	@NotBlank(message="Name is required!")
	private String name;
	
	private Date dob;
	
	@NotNull
	@NotBlank(message="Department is required!")
	private String department;
	
	@NotNull
	private int approved = 0;
	
	public Student() {
		
	}
	
	
	public void setDob(String dob) throws ParseException {
		Date DOB = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
		
		this.dob = DOB;
	}
	
	public Student(String id, String name, Date dob, String department, int approved) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.department = department;
		this.approved = approved;
	}
}
