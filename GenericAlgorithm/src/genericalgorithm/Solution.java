package genericalgorithm;

import java.util.*;

//unique for every student
public class Solution {
    private int studentNumber;
    private List<ExamSchedule> examSchedules = new ArrayList<ExamSchedule>();

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public List<ExamSchedule> getExamSchedules() {
        return examSchedules;
    }

    public void setExamSchedules(List<ExamSchedule> examSchedules) {
        this.examSchedules = examSchedules;
    }
    
    
}
