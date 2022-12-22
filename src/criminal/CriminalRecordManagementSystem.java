package criminal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CriminalRecordManagementSystem {

    private static final List<Criminal> criminals = new ArrayList<>();

    private static final Scanner input = new Scanner(System.in);

    private static final File file = new File("records.txt");

    public static void main(String[] args) throws IOException, InterruptedException {

        do {
            System.out.println("Welcome to the Criminal Record Management System");
            System.out.println("Please select an option:");
            System.out.println("1. Add a new criminal record");
            System.out.println("2. View existing criminal record");
            System.out.println("3. Update a criminal record");
            System.out.println("4. Delete a criminal record");
            System.out.println("5. Exit the program");
            System.out.print(">>: ");

            String selection = input.nextLine().trim();

            switch (selection) {
                case "1":
                    addCriminalRecord();
                    break;
                case "2":
                    viewCriminalRecord();
                    break;
                case "3":
                    updateCriminalRecord();
                    break;
                case "4":
                    deleteCriminalRecord();
                    break;
                case "5":
                    System.exit(0);
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (true);

    }

    public static void addCriminalRecord() throws IOException, InterruptedException {

        System.out.println("Please enter the following information for the new criminal record:");
        System.out.print("Name: ");
        String name = input.nextLine().trim();

        System.out.print("Age: ");
        String age = input.nextLine().trim();

        System.out.print("Gender: ");
        String gender = input.nextLine();

        System.out.print("Address: ");
        String address = input.nextLine();

        System.out.print("Crime committed: ");
        String crime = input.nextLine();

        System.out.println(": Assigned police officer: ");
        System.out.print("Police ID: ");
        String policeId = input.nextLine().trim();

        System.out.print("Police Rank: ");
        String policeRank = input.nextLine();

        System.out.println(": Detained Station: ");

        System.out.print("Station: ");
        String station = input.nextLine();

        System.out.print("Length of imprisonment: ");
        String imprisonmentLength = input.nextLine().trim();

        System.out.print("Will be detained?: ");
        String tinype = input.nextLine().trim();
        boolean willBeDetained = tinype.equalsIgnoreCase("Y") || tinype.equalsIgnoreCase("T");
        Criminal newCriminal = new Criminal(
                name,
                age,
                gender,
                address,
                crime,
                policeId,
                policeRank,
                station,
                imprisonmentLength,
                willBeDetained
        );

        criminals.add(newCriminal);

        writeToATextFile(newCriminal.toString(), file, true);

        System.out.println("Successfully added new criminal record for " + newCriminal.getName());
    }

    public static void viewCriminalRecord() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the name of the criminal whose record you would like to view: ");
        String name = input.nextLine();

        Criminal criminal = findCriminal(name);

        if (criminal == null) {
            System.out.println("No criminal record found for " + name);
        } else {
            System.out.println(criminal);
        }
    }

    public static void updateCriminalRecord() {

        System.out.print("Please enter the name of the criminal whose record you would like to update: ");
        String name = input.nextLine();

        Criminal criminal = findCriminal(name);

        if (criminal == null) {
            System.out.println("No criminal record found for " + name);
        } else {
            System.out.println("What would you like to update?");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Gender");
            System.out.println("4. Address");
            System.out.println("5. Crime committed");
            System.out.println("6. Assigned police officer");
            System.out.println("7. Station");
            System.out.println("8. Length of imprisonment");
            System.out.println("9. Status if detained");
            System.out.println("10. Cancel");
            System.out.print(">>: ");

            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter new name: ");
                    criminal.setName(input.nextLine().trim());
                    break;
                case "2":
                    System.out.print("Enter new age: ");
                    criminal.setAge(input.nextLine().trim());
                    break;
                case "3":
                    System.out.print("Enter new gender: ");
                    criminal.setGender(input.nextLine().trim());
                    break;
                case "4":
                    System.out.print("Enter new address: ");
                    criminal.setAddress(input.nextLine().trim());
                    break;
                case "5":
                    System.out.print("Enter new crime committed: ");
                    criminal.setCrimeCommitted(input.nextLine().trim());
                    break;
                case "6":
                    System.out.println(": Enter new assigned police officer :");
                    System.out.print("Enter Police ID: ");
                    criminal.setPoliceId(input.nextLine().trim());
                    System.out.print("Enter Police Rank: ");
                    criminal.setPoliceRank(input.nextLine().trim());
                    break;
                case "7":
                    System.out.print("Enter new station: ");
                    criminal.setDetainedStation(input.nextLine().trim());
                    break;
                case "8":
                    System.out.print("Enter new length of imprisonment: ");
                    criminal.setLengthOfImprisonment(input.nextLine().trim());
                    break;
                case "9":
                    System.out.print("Is the criminal still detained?: ");
                    criminal.setDetained(input.nextLine().trim().equalsIgnoreCase("T"));
                    break;
                case "10":
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
            if (!choice.equals("10")) System.out.println("Successfully updated criminal record for " + name);
        }
    }

    public static void deleteCriminalRecord() throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the name of the criminal whose record you would like to delete: ");
        String name = input.nextLine();

        Criminal criminal = findCriminal(name);

        if (criminal == null) {
            System.out.println("No criminal record found for " + name);
        } else {
            deleteCriminal(name);
            writeToATextFile("", file, false); // remove lahat ng nasa file
            for (Criminal value : criminals) {
                writeToATextFile(value.toString(), file, true);
            }
            System.out.println("Successfully deleted criminal record for " + name);
        }
    }

    public static Criminal findCriminal(String name) {
        // Method to search for a criminal record by name and return the Criminal object if found
        // Return null if no record is found

        for (Criminal criminal : criminals) {
            if (criminal.getName().equals(name)) return criminal;
        }

        return null;
        
    }

    public static void deleteCriminal(String name) {
        criminals.removeIf(criminal -> criminal.getName().equals(name));
    }

    public static void writeToATextFile(String whatToWrite, File fileToWrite, boolean writeToBottom) throws IOException, InterruptedException {
        Thread thread = new Thread(
                () -> {
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToWrite, writeToBottom));
                        bufferedWriter.write(whatToWrite);
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        thread.join();
        thread.start();
    }
}