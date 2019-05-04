package Assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jeremy Santorelli
 */
public class StartUp {

    public static void main(String[] args) {

        //With Integers
        Integer[] intArr = {4, 7, 2, 9, 7, 5, 0};

        TaskSort<Integer> task = new TaskSort<>(intArr, "array");
        task.getData("ascending");
        task.setAlgorithm("bubble");
        task.setComparator(Integer::compareTo);
        System.out.println(Arrays.toString((Integer[]) task.sort()));
        System.out.println("\nEx Time: " + task.getExecutionTime()
                + "ns\n");

        //With Courses
        Course[] courses = {new Course("2", "Art"),
            new Course("3", "Science"),
            new Course("1", "Math")};

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("208", "Linear Algebra"));
        courseList.add(new Course("450", "Capstone"));
        courseList.add(new Course("341", "Soft Design"));
        courseList.add(new Course("400", "CCS"));

        //Array DataStructure
        TaskSort<Course> task1 = new TaskSort<>(courses, "array");
        task1.getData("ascending");
        task1.setAlgorithm("bubble");
        task1.setComparator(Course::compareTo);

        System.out.println(Arrays.toString((Course[]) task1.sort()));

        System.out.println("\nEx Time: " + task1.getExecutionTime()
                + "ns\n");

        //List DataStructure
        task1 = new TaskSort<>(courseList, "arraylist");
        task1.getData("ascending");
        task1.setAlgorithm("bubble");
        task1.setComparator(Course::compareTo);

        System.out.println(task1.sort());

        System.out.println("\nEx Time: " + task1.getExecutionTime()
                + "ns\n");
    }
}
