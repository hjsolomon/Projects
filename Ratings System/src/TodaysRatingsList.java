import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * A compilation of ratings for a given number of days.
 */

 public class TodaysRatingsList implements IRating{
        private LinkedList<TodaysRatings> ratingsList;

        public TodaysRatingsList(LinkedList<TodaysRatings> ratingsList){
            this.ratingsList = ratingsList;
        }

     /**
      *
      * @param month The month in question.
      * @param year The year in question.
      * @return An int representing the lowest rank in the given time span.
      */
        public int bestRank(int month, int year){
            int bestRankForMonth = Integer.MAX_VALUE;
            for (TodaysRatings t : ratingsList) {
                if (t.sameMonth(month, year)) {
                    if(t.bestRankForToday() < bestRankForMonth) bestRankForMonth = t.bestRankForToday();
                }
            }
            return bestRankForMonth;
        }

     /**
      * Loops through the list of TodaysRatings, summing their number of downloads.
      * @param month The month in question.
      * @param year The year in question.
      * @return An int representing the total number of downloads within the given time span.
      */
        public int sumDownloads(int month, int year){
            int total = 0;
            for (TodaysRatings t : ratingsList){
                if (t.sameMonth(month, year)) {
                    total = total + t.sumTodaysDownloads();
                }
            }
            return total;
        }

    /**
     * Adds a TodaysRating object to the list of ratings.
     * @param tr The TodaysRatings object that's being added to the list of ratings.
     */
        public void addResults(TodaysRatings tr){
            this.ratingsList.add(tr);
        }
    }
