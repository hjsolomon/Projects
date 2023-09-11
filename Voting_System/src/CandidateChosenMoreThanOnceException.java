/**
 * Exception thrown when the same candidate is chosen more than once during a vote.
 */
public class CandidateChosenMoreThanOnceException extends Exception{
    private String name;
    public CandidateChosenMoreThanOnceException(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
