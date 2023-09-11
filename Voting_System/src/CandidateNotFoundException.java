/**
 * Exception thrown when a candidate not present in the ballot is chosen.
 */
public class CandidateNotFoundException extends Exception{
    private String name;
    public CandidateNotFoundException(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
