import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface IRating {
    public int bestRank(int month, int year);
    public int sumDownloads(int month, int year);

    public void addResults(TodaysRatings tr);
    }

