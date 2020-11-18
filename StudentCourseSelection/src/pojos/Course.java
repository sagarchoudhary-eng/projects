package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "courses_table")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer courseId;
	@Column(length = 20, unique = true)
	private String title;
	@Column(name = "begin_date")
	private LocalDate beginDate;//basic value type
	@Column(name = "end_date")
	private LocalDate endDate;
	private int capacity;
	private double fees;//basic value type
	// one to many BI-dir association(HAS A) between entities
	@OneToMany(mappedBy = "selectedCourse", cascade = CascadeType.ALL,orphanRemoval = true/* ,fetch = FetchType.EAGER */) // mandatory anno : o.w MappingException
	private List<Student> students = new ArrayList<>();// as per THE founder : init collections @ time of declaration ,
														// to avoid NPExc

	public Course() {
		System.out.println("in course ctor");
	}

	public Course(String title, LocalDate beginDate, LocalDate endDate, int capacity, double fees) {
		super();
		this.title = title;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.capacity = capacity;
		this.fees = fees;
	}

	// all setters n getters
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	//add helper methods : to add a student to a course
	public void addStudent(Student s)
	{
		//bi dir asso
		//course ---> student
		students.add(s);
		//student ---> course
		s.setSelectedCourse(this);
		
	}
	//add helper methods : to remove a student from a course
		public void removeStudent(Student s)
		{
			//bi dir asso
			students.remove(s);
			s.setSelectedCourse(null);
		}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", beginDate=" 
	+ beginDate + ", endDate=" + endDate
				+ ", capacity=" + capacity + ", fees=" + fees + "]";
	}

}
