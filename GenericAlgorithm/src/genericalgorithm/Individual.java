package genericalgorithm;

import java.util.List;
import java.util.Random;

class Individual {

    int fitness = 0;
    int[] genes = new int[5];
    int geneLength = 5;

    public Individual(int[][] registration, List<Integer> roomCapacity, int totalExamDays, int maxSlots) {
        Random rn = new Random();
        
        Room[] rooms = new Room[roomCapacity.size()];
        for (int i=0;i<roomCapacity.size();i++)
        {
            rooms[i].setRoomNumber(i);
            rooms[i].setCapacity(roomCapacity.get(i));
        }
        
        Solution[] sol = new Solution[100];
        for (int i=0;i<15;i++)
        {
            
            for (int j=0;j<100;j++)
            {
                sol[i].setStudentNumber(i);
                //jth student is enrolled in ith course
                if (registration[i][j] == 1)
                {
                    //pick a random room
                    Boolean flag = false;
                    while(!flag)
                    {
                        int r = rn.nextInt(rooms.length + 1);
                        //if room has sufficent space then proceed
                        if (rooms[r].getStudentsAllocatedToRoom()<rooms[r].getCapacity())
                        {
                            flag = true;
                            rooms[r].setStudentsAllocatedToRoom(rooms[r].getStudentsAllocatedToRoom()+1);
                    }
                    
                    //pick a random day
                    int day = rn.nextInt((totalExamDays - 1) + 1) + 1;      //day 1 is minimum
                    
                    //pick a random slot
                    int slot = rn.nextInt((maxSlots - 1) + 1) + 1;        //1 is starting slot number
                    
                    //add the exam schedule of a particular course to the solution of jth student
                    ExamSchedule randomExamSchedule = new ExamSchedule(rooms[r], j, day, slot);
                    sol[j].getExamSchedules().add(randomExamSchedule);
                }
            }
        }
        //Set genes randomly for each individual
        for (int i = 0; i < genes.length; i++) {
            genes[i] = Math.abs(rn.nextInt() % 2);
        }

        fitness = 0;
    }

    //Calculate fitness
    public void calcFitness() {

        fitness = 0;
        for (int i = 0; i < 5; i++) {
            if (genes[i] == 1) {
                ++fitness;
            }
        }
    }

}
