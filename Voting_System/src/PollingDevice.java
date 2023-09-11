import java.util.Scanner;

/**
 * A polling device.
 */
public class PollingDevice {
    VotingData votingData;
    Scanner keyboard = new Scanner(System.in);

    public PollingDevice(){
        votingData = new VotingData();
    }

    /**
     * Prints out all candidates in the ballot.
     */
    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : votingData.getBallot()) {
            System.out.println(s);
        }
    }

    /**
     * The voting screen.
     */
    public void screen() {
        this.printBallot();
        System.out.println("Who do you want to vote for first?");
        String candidate1 = keyboard.next();
        System.out.println("Who do you want to vote for second?");
        String candidate2 = keyboard.next();
        System.out.println("Who do you want to vote for third?");
        String candidate3 = keyboard.next();
        try{
            votingData.submitVote(candidate1, candidate2, candidate3);
            System.out.println("You voted for ");
            System.out.println(candidate1);
            System.out.println(candidate2);
            System.out.println(candidate3);
        }
        catch(CandidateNotFoundException c){
            System.out.println("Would you like to add " + c.getName() + " to the ballot? Type Y for yes or N for no.");
            String yesOrNo = keyboard.next();
            if(yesOrNo.equals("Y") || yesOrNo.equals("y")){
                this.addWriteIn(c.getName());
                this.screen();
            }
            else{
                System.out.println("Try again.");
                this.screen();
            }

        }
        catch(CandidateChosenMoreThanOnceException c){
            System.out.println("You cannot vote for the same candidate twice. Please try again.");
            this.screen();
        }


    }

    /**
     * Adds a candidate's name to the ballot if they are not already present.
     * @param name The name of the candidate being added
     */
    public void addWriteIn(String name){
        try{
            votingData.nominateCandidate(name);
        }
        catch(RedundantCandidateException c){
            System.out.println("This candidate already exists within the ballot.");
        }
        System.out.println("The candidate was added successfully");
    }



}
