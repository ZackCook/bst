package main;

public class Golfer implements Comparable<Golfer>{

    private String lastName;
    private int numberOfRounds;
    private double avgScore;
    private int handicap;

    public Golfer(String l, int r, double a, int h){
        this.lastName = l;
        this.numberOfRounds = r;
        this.avgScore = a;
        this.handicap = h;
    }

    public Golfer(String l){
        this.lastName = l;
        this.numberOfRounds = -1;
        this.avgScore = -1;
        this.handicap = -1;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public int getHandicap() {
        return handicap;
    }

    /**
     * Adds a new score to a players log and updates their
     * average score and rounds played attributes
     *
     * @param s
     *  the new score being added to the golfer's log
     **/
    public void updateStats(int s){
        this.incrementRounds();
        double newAvg = (this.avgScore + s)/this.numberOfRounds;
        this.avgScore = newAvg;
    }

    /**
     * Increments the numberOfRounds attribute of this Golfer object
     *
     * @precondition
     *      this Golfer object is non null
     * @postcondition
     *      this Golfer's numberOfRounds attribute has been increased by 1
     */
    public void incrementRounds(){
        this.numberOfRounds ++;
    }

    /*
        comparisons based alphabetically on last name
     */
    @Override
    public int compareTo(Golfer o) {
        int result = 0;
        String oName = o.getLastName().toLowerCase();
        String thisName = this.getLastName().toLowerCase();

        if (thisName.compareTo(oName) < 0) {
            result = -1;
        } else if (thisName.compareTo(oName) > 0) {
            result = 1;
        }
        return result;
    }

    @Override
    public String toString() {
        return this.lastName +
                " {Rounds played: " + this.numberOfRounds +
                ", Handicap: " + this.handicap +
                ", Average Score: " + this.avgScore
                +"}";
    }

    public static void main(String[] args){
        Golfer g = new Golfer("a");
        Golfer g2 = new Golfer("b");
        g.setNumberOfRounds(5);
        g.setAvgScore(10.2);
        g.setHandicap(2);

        System.out.println(g.toString());
        g.updateStats(52);
        System.out.println(g.toString());

        System.out.println(g2.toString());
        g2.setLastName("Cook");
        System.out.println(g2.toString());

        System.out.println(g.compareTo(g2));
    }


}//end class
