package genericalgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

//Main class
public class GenericAlgorithm {

    Population population = new Population();
    Individual fittest;
    Individual secondFittest;
    int generationCount = 0;

    //assume 15 courses are being offered and total students are 100
    static int[][] registration = new int[15][100];
    static List<Integer> roomCapacity = new ArrayList<Integer>();
    static int totalExamDays;
    static int maxSlots;
    
    //read data from input files
    public static void readRoomData(String fileName){
        try {                                                       
            Scanner scanner = new Scanner(new File(fileName));      
            while (scanner.hasNextLine()) {
                roomCapacity.add(Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();    //close file
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	}
    }
    
    public static void readExamData(String fileName){
        try {                                                       
            Scanner scanner = new Scanner(new File(fileName));      
            totalExamDays = Integer.parseInt(scanner.nextLine());
            maxSlots = Integer.parseInt(scanner.nextLine());
            scanner.close();    //close file
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	}
    }
       
    public static void readRegistrationData(String fileName){
        try {                                                       
            Scanner scanner = new Scanner(new File(fileName));     
            while (scanner.hasNextLine()) {
                for (int i=0; i<registration.length; i++) 
                {
                    String[] line = scanner.nextLine().trim().split(" ");
                    for (int j=0; j<line.length; j++) 
                    {
                        registration[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
            scanner.close();    //close file
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	}
    }
    
    public static void main(String[] args) {

        Random rn = new Random();

        GenericAlgorithm demo = new GenericAlgorithm();

        //Initialize population
        demo.population.initializePopulation(10);

        //Calculate fitness of each individual
        demo.population.calculateFitness();

        System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);

        //While population gets an individual with maximum fitness
        while (demo.population.fittest < 5) {
            ++demo.generationCount;

            //Do selection
            demo.selection();

            //Do crossover
            demo.crossover();

            //Do mutation under a random probability
            if (rn.nextInt()%7 < 5) {
                demo.mutation();
            }

            //Add fittest offspring to population
            demo.addFittestOffspring();

            //Calculate new fitness value
            demo.population.calculateFitness();

            System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);
        }

        System.out.println("\nSolution found in generation " + demo.generationCount);
        System.out.println("Fitness: "+demo.population.getFittest().fitness);
        System.out.print("Genes: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(demo.population.getFittest().genes[i]);
        }

        System.out.println("");

    }

    //Selection
    void selection() {

        //Select the most fittest individual
        fittest = population.getFittest();

        //Select the second most fittest individual
        secondFittest = population.getSecondFittest();
    }

    //Crossover
    void crossover() {
        Random rn = new Random();

        //Select a random crossover point
        int crossOverPoint = rn.nextInt(population.individuals[0].geneLength);

        //Swap values among parents
        for (int i = 0; i < crossOverPoint; i++) {
            int temp = fittest.genes[i];
            fittest.genes[i] = secondFittest.genes[i];
            secondFittest.genes[i] = temp;

        }

    }

    //Mutation
    void mutation() {
        Random rn = new Random();

        //Select a random mutation point
        int mutationPoint = rn.nextInt(population.individuals[0].geneLength);

        //Flip values at the mutation point
        if (fittest.genes[mutationPoint] == 0) {
            fittest.genes[mutationPoint] = 1;
        } else {
            fittest.genes[mutationPoint] = 0;
        }

        mutationPoint = rn.nextInt(population.individuals[0].geneLength);

        if (secondFittest.genes[mutationPoint] == 0) {
            secondFittest.genes[mutationPoint] = 1;
        } else {
            secondFittest.genes[mutationPoint] = 0;
        }
    }

    //Get fittest offspring
    Individual getFittestOffspring() {
        if (fittest.fitness > secondFittest.fitness) {
            return fittest;
        }
        return secondFittest;
    }


    //Replace least fittest individual with fittest offspring
    void addFittestOffspring() {

        //Update fitness values of offspring
        fittest.calcFitness();
        secondFittest.calcFitness();

        //Get index of least fit individual
        int leastFittestIndex = population.getLeastFittestIndex();

        //Replace least fittest individual from most fittest offspring
        population.individuals[leastFittestIndex] = getFittestOffspring();
    }

}


