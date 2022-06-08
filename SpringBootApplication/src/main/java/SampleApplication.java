import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aa.socialmedia.model.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleApplication {

	public static void main(String[] args) {
		List<Student> lt = createList();
		lt.stream().forEach(x -> System.out.println(x));
		List<Integer> numberList = Arrays.asList(1, 27, 9, 12);
		String inputString = "Suyash has idea";
		System.out.println("Printing max Element " + numberList.stream().max(Integer::compare).get());
		numberList.stream().sorted().forEach(System.out::println);
		numberList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		lt.stream().sorted(Comparator.comparingInt(Student::getId).reversed()).forEach(System.out::println);
		Optional.ofNullable(numberList).orElseGet(Collections::emptyList).stream().forEach(System.out::println);
		System.out.println("Space count " + inputString.chars().filter(x -> x == (int) ' ').count());

		// Map<Integer, String> result = convertListAfterJava8(lt);
		// result.entrySet().forEach(System.out::println);
	}

	static List<Student> createList() {
		List<Student> lt = new ArrayList<Student>();
		lt.add(new Student(1, "ABC", "Test", "Geeks"));
		lt.add(new Student(2, "Suyash", "Test", "For"));
		lt.add(new Student(3, "XYZ", "Test", "Geeks"));
		return lt;

	}

	public static Map<Integer, String> convertListAfterJava8(List<Student> list) {
		return list.stream().collect(Collectors.toMap(Student::getId, Student::getStudentName));

	}

}
