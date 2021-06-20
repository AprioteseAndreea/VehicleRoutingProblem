import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int locations;
    private static int cars;
    private static int capacity;
    private static ArrayList<Deposit> deposits = new ArrayList<>();

    public static void readFromFile() {
        File file = new File("resources/date.txt");

        try {
            Scanner sc = new Scanner(file);

            locations = sc.nextInt();
            cars = sc.nextInt();
            capacity = sc.nextInt();

            while (sc.hasNextLine()) {
                Deposit currentDeposit;
                int id = sc.nextInt();
                int currentX = sc.nextInt();
                int currentY = sc.nextInt();
                int currentRequires = sc.nextInt();
                currentDeposit = new Deposit(id, currentX, currentY, currentRequires);
                deposits.add(currentDeposit);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static float distance(int firstCordX, int firstCordY, int secondCordX, int secondCordY) {
        return (float) Math.sqrt((secondCordX - firstCordX) * (secondCordX - firstCordX) - ((secondCordY - firstCordY) * (secondCordY - firstCordY)));

    }

    private static ArrayList<Deposit> sortArrayList(int currentCordX, int currentCordY, ArrayList<Deposit> freeDeposits) {

        //TO DO
        return freeDeposits;

    }

    private static void findPath() {
        ArrayList<Deposit> freeDeposits = new ArrayList<>(deposits);
        int totalRoutesDistance = 0;
        for (int i = 0; i < cars; i++) {
            //sortez pentru fiecare masina vectorul de depozite ramase in functie de distanta de la depozitul actual la depozitele ramase
            freeDeposits = sortArrayList(0, 0, freeDeposits);

            int currentCapacity = 0;
            int totalDistance = 0;
            ArrayList<Integer> route = new ArrayList<>();

            //parcurg cu un for vectorul sortat
            for (int j = 0; j < freeDeposits.size(); j++) {
                //pana cand gasesc un depozit a carui cantitate ceruta + cantitatea de pana cum nu depaseste capacitatea masinii
                if (currentCapacity + freeDeposits.get(j).getRequires() < capacity) {
                    route.add(freeDeposits.get(j).getId());
                    freeDeposits.remove(freeDeposits.get(j));
                    //TO DO : de adaugat si distanta de la nodul curent la urmatorul depozit
                }
            }

            //la urma printez pentru masina actuala traseul;
            System.out.print("For cars no: " + i + " the route is: ");
            for (Integer r : route) {
                System.out.print(" -> " + r);
            }
            System.out.println("Distance of route: " + totalDistance);
            System.out.println("Total distance of all routes: " + totalRoutesDistance);
        }
    }

    public static void main(String args[]) {
        readFromFile();
        findPath();

    }

}
