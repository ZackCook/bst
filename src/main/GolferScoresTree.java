package main;

import java.io.*;
import java.util.Scanner;

public class GolferScoresTree {

    public static void main(String[] args){
        boolean run = true;

        Scanner cockandballs = new Scanner(System.in);
        int choice = 0;

        TreeBag<Golfer> database = new TreeBag<>();


        //fill database from datafile
        String datafilepath = "C:\\Users\\zackm\\Desktop\\6.006\\otherCode\\algorithms\\projects\\GolferBstDatabase" +
                "\\src\\main\\golfers.txt";
        File datafile = new File(datafilepath);
        FileReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            reader = new FileReader(datafile);
            bufferedReader = new BufferedReader(reader);

            String dataline = bufferedReader.readLine();

            while(dataline != null){
                String[] dataArr = dataline.split(" ");

                //parsed golfer data
                String name = dataArr[0];
                int rounds = Integer.parseInt(dataArr[1]);
                int handicap = Integer.parseInt(dataArr[2]);
                double avgScore = Double.parseDouble(dataArr[3]);

                Golfer g = new Golfer(name,rounds,avgScore,handicap);
                database.add(g);
                dataline = bufferedReader.readLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Database loaded from datafile");



        while(run){
            displayMenu();
            choice = cockandballs.nextInt();

            switch(choice){
                case 1://display list of all golfers.txt ordered by last name
                    //go for final testing
                    database.display();
                    break;

                case 2://display the golfers.txt in tree format
                    //todo rewrite displayAsTree() or create prettyDisplay() in treeBag class
                    database.displayAsTree();
                    break;

                case 3://find and display individual stats

                    /* todo: Display individual stats
                        (go for testing)

                        bug description
                        -If the node being queried is a leaf and it has the same first letter of last name
                        the comparison turns out to be == 0 so the parent node is returned instead,
                        this requires refinement of the golfer.compareTo() method and not the tree.get(), or
                        tree.retrieve() methods.
                     */
                    System.out.println("Input last name of golfer to be retrieved");
                    String name = cockandballs.next();

                    Golfer retrieval = database.get(new Golfer(name));
                    System.out.println(retrieval.toString());

                    break;

                case 4://update individual stats
                    //todo: update individual stats
                    // (go for testing)

                    System.out.println("Input new score");
                    int score = cockandballs.nextInt();

                    //query tree for specific player to upate
                    System.out.println("Input lastname of player to update");
                    String lastname = cockandballs.next();

                    Golfer update = database.get(new Golfer(lastname));
                    update.updateStats(score);
                    System.out.println(update.toString());
                    break;

                case 5://remove a golfer
                    //NOT WORKING
                    //golfer that is entered is not actually removed
                    //todo: removal
                    System.out.println("Input last name of golfer to be removed");
                    String removeName = cockandballs.next();
                    database.remove(database.get(new Golfer(removeName)));
                    break;

                case 6://add new golfer
                        //go for final testing
                    System.out.println("Input last name of golfer to be added.");
                    String newName = cockandballs.next();
                    database.add(new Golfer(newName));
                    break;

                case 7://quit and update datafile
                    //todo: datafile is not updated upon quitting program
                    cockandballs.close();
                    
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    

                    run = false;
                    break;
            }//end switch

        }//end while(run)
    }//end main

    private static void displayMenu(){
        System.out.println("");
        System.out.println("<------------------------------------------------------------->");
        System.out.println("Make a selection");
        System.out.println("<------------------------------------------------------------->");
        System.out.println("1. Display list of all golfers stats");
        System.out.println("2. Display the golfers in current tree format");
        System.out.println("3. Find and display one individual golfers stats");
        System.out.println("4. Update an individual golfers stats");
        System.out.println("5. Remove a golfer from the database");
        System.out.println("6. Add a new golfer to the database");
        System.out.println("7. Quit and update datafile");
        System.out.println("<------------------------------------------------------------>");
        System.out.println("");
    }
}//end class