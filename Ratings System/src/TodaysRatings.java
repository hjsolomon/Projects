import sun.awt.image.ImageWatched;

import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * A compilation of the data from today's surveys.
 */
public class TodaysRatings {
    private GregorianCalendar date;
    private LinkedList<Integer> rankingsList;
    private LinkedList<Integer> downloadsList;

    public TodaysRatings(GregorianCalendar date, LinkedList<Integer> rankingsList, LinkedList<Integer> downloadsList){
        this.date = date;
        this.rankingsList = rankingsList;
        this.downloadsList = downloadsList;
    }


    /**
     * Checks the month and year of this TodaysRating, seeing if they are the same as the parameters.
     * @param month The month in question.
     * @param year The year in question.
     * @return A boolean representing whether the TodaysRatings passed is within the given month/year.
     */
    public boolean sameMonth(int month, int year){
        return (this.date.get(GregorianCalendar.MONTH) == month
                && this.date.get(GregorianCalendar.YEAR) == year);
    }

    /**
     * Loops through all of today's rankings, storing the lowest value.
     * @return An int representing the best rank for today.
     */
    public int bestRankForToday(){
        int bestRank = Integer.MAX_VALUE;
        for(Integer i : rankingsList){
            if (i < bestRank) {
                bestRank = i;
            }
        }
        return bestRank;
    }

    /**
     * Loops through all of today's downloads, summing them together.
     * @return An int representing the total number of downloads for today.
     */
    public int sumTodaysDownloads(){
        int total = 0;
        for(Integer i : downloadsList){
            total = total + i;
        }
        return total;
    }




}
