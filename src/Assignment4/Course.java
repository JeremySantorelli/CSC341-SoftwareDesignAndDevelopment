package Assignment4;

import java.util.Objects;

/**
 *
 * @author Jeremy Santorelli
 */
public class Course implements Comparable {

    private final String courseNum;
    private final String coruseName;
    private final Course course = null;

    public Course(String courseNum, String coruseName) {
        this.courseNum = courseNum;
        this.coruseName = coruseName;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public String getCoruseName() {
        return coruseName;
    }

    @Override
    public String toString() {
        return "Course{" + "courseNum=" + courseNum
                + ", coruseName=" + coruseName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.courseNum);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.courseNum, other.courseNum)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        final Course other = (Course) o;
        int ret;
        if (this.equals(other)) {
            ret = 0;
        } else {
            int thisB = Integer.parseInt(this.getCourseNum());
            int oB = Integer.parseInt(other.getCourseNum());
            ret = thisB - oB;
        }
        return ret;
    }

}
