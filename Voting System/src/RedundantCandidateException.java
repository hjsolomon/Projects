/**
 * Exception thrown when a candidate is added to the ballot a second time.
 */
public class RedundantCandidateException extends Exception{
    private String name;
    public RedundantCandidateException(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
