/**
 * A survey.
 */
public class Survey {

    private int rank;
    private int numDownloads;

    public Survey(int rank, int numDownloads){
        this.rank = rank;
        this.numDownloads = numDownloads;
    }

    public int getRank(){
        return this.rank;
    }

    public int getNumDownloads(){
        return this.numDownloads;
    }

}
