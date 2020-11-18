package pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students_table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private Integer studentId;
	@Column(length = 20)
	private String name;//basic value type
	@Column(length = 20,unique = true)
	private String email;
	//many to one asso between entities
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_id") //To supply name of FK column
	private Course selectedCourse;
	//one to one bi dir asso between student 1<---->1 Address
	@OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
	private Address adr;
	//add a property : AdharCard : embedded composite value type
	@Embedded //optional
	private AdharCard card;
	//add a property to specify student hobbies.
	@ElementCollection //mandatory
	@CollectionTable(name="hobbies_tbl",joinColumns = @JoinColumn(name="stud_id"))
	@Column(name="hobby",length = 20)
	private List<String> hobbies;
	public Student() {
		System.out.println("in student ctor");
	}
	
	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	//all setters  n getters
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Course getSelectedCourse() {
		return selectedCourse;
	}
	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	
	public Address getAdr() {
		return adr;
	}

	public void setAdr(Address adr) {
		this.adr = adr;
	}
	//add 2 helper(convenience) methods for managing bi-dir asso
	public void addAdress(Address a)
	{
		//p --> c
		this.setAdr(a);
		//c ---> 
		a.setStudent(this);
		
	}
	public void removeAdress(Address a)
	{
		this.setAdr(null);
		a.setStudent(null);
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + "]";
	}
	
	

}
