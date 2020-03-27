package genericalgorithm;

public class ExamSchedule {
    private Room room;
    private int courseNumber;
    private int dayNumber;
    private int slotNumber;

    public ExamSchedule(){
        
    }
    
    public ExamSchedule(Room room, int courseNumber, int dayNumber, int slotNumber) {
        this.room = room;
        this.courseNumber = courseNumber;
        this.dayNumber = dayNumber;
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoomNumber(Room room) {
        this.room = room;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }
    
    
}
