import sun.awt.image.ImageWatched;

import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * A Radio station with a current date and a list of daily ratings.
 */
public class RadioStation {
    private IRating dailyRatings;
    private GregorianCalendar curDate;

    public RadioStation(IRating dailyRatings, GregorianCalendar curDate){
        this.dailyRatings = dailyRatings;
        this.curDate = curDate;
    }

    /**
     * Loops through all TodaysRatings in the IRating with the current month, keeping track of the lowest rank.
     * @return the smallest rank for the current month.
     */
    public int bestRankThisMonth() {
        int curMonth = curDate.get(GregorianCalendar.MONTH);
        int curYear = curDate.get(GregorianCalendar.YEAR);
    return dailyRatings.bestRank(curMonth, curYear);
    }


    /**
     * Loops through all TodaysRatings in the IRating within the given timeframe, summing all of their downloads.
     * @param month The month of interest.
     * @param year The year of interest.
     * @return The total number of song downloads for the given month/year.
     */
    public int totalSongDownloads(int month, int year){
        return dailyRatings.sumDownloads(month, year);
    }

    /**
     * Adds all data from today's surveys to their respective lists, creates/adds a TodaysRating object with those lists and advances the day one forward.
     * @param listOfSurvey The surveys for the current day.
     */
    public void addTodaysSurveys(LinkedList<Survey> listOfSurvey){
        GregorianCalendar newDate = new GregorianCalendar(curDate.get(GregorianCalendar.YEAR), curDate.get(GregorianCalendar.MONTH), curDate.get(GregorianCalendar.DAY_OF_MONTH));
        LinkedList<Integer> rankings = new LinkedList<>();
        LinkedList<Integer> downloads = new LinkedList<>();
        for(Survey s: listOfSurvey){
        rankings.add(s.getRank());
        downloads.add(s.getNumDownloads());
        }
        TodaysRatings tr = new TodaysRatings(newDate, rankings, downloads);
        this.dailyRatings.addResults(tr);
        curDate.add(GregorianCalendar.DAY_OF_YEAR, 1);
    }
}










