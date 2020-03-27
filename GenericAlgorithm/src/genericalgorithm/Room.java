package genericalgorithm;

public class Room {
   private int roomNumber;
   private int studentsAllocatedToRoom = 0;
   private int capacity;

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getStudentsAllocatedToRoom() {
        return studentsAllocatedToRoom;
    }

    public void setStudentsAllocatedToRoom(int studentsAllocatedToRoom) {
        this.studentsAllocatedToRoom = studentsAllocatedToRoom;
    }
   
   
}
