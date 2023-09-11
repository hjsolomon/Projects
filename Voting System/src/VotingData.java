import java.util.HashMap;
import java.util.LinkedList;

/**
 * The voting data for the polling machine.
 */
public class VotingData {

    private LinkedList<String> ballot;
    private HashMap<String, Integer> firstChoiceVotes;
    private HashMap<String, Integer> secondChoiceVotes;
    private HashMap<String, Integer> thirdChoiceVotes;



    VotingData() {
        firstChoiceVotes = new HashMap<String, Integer>();
        secondChoiceVotes = new HashMap<String, Integer>();
        thirdChoiceVotes = new HashMap<String, Integer>();
        ballot = new LinkedList<>();
    }


    /**
     * Adds one to the candidate's votes.
     * @param first The name of the voters first choice candidate.
     * @param second The name of the voters second choice candidate.
     * @param third The name of the voters third choice candidate.
     * @throws CandidateChosenMoreThanOnceException when the same candidate is chosen for two separate votes.
     * @throws CandidateNotFoundException when a candidate is not present in the ballot.
     */
    public void submitVote(String first, String second, String third) throws CandidateChosenMoreThanOnceException, CandidateNotFoundException {
        if (!ballot.contains(first)) {
            throw new CandidateNotFoundException(first);
        }
        if (!ballot.contains(second)) {
            throw new CandidateNotFoundException(second);
        }
        if (!ballot.contains(third)) {
            throw new CandidateNotFoundException(third);
        }
        if (first.equals(second) || first.equals(third)) {
            throw new CandidateChosenMoreThanOnceException(first);
        }
        if (second.equals(third)) {
            throw new CandidateChosenMoreThanOnceException(second);
        }

        firstChoiceVotes.replace(first, firstChoiceVotes.get(first) + 1);
        secondChoiceVotes.replace(second, secondChoiceVotes.get(second) + 1);
        thirdChoiceVotes.replace(third, thirdChoiceVotes.get(third) + 1);
    }

    /**
     * Adds a candidate to the ballot.
     * @param candidateName The name of the candidate being nominated.
     * @throws RedundantCandidateException when the candidate is already in the ballot.
     */
    public void nominateCandidate(String candidateName) throws RedundantCandidateException {
        if (ballot.contains(candidateName)) {
            throw new RedundantCandidateException(candidateName);
        } else {
            firstChoiceVotes.put(candidateName, 0);
            secondChoiceVotes.put(candidateName, 0);
            thirdChoiceVotes.put(candidateName, 0);
            ballot.add(candidateName);
        }
    }

    /**
     * Compares the number of firstChoiceVotes for every candidate.
     * @return The candidate with more than 50% of the total first votes.
     */
    public String pickWinnerMostFirstChoice() {
        int total = 0;
        int numVotes = 0;
        String currentWinner = "";

        for (String s : firstChoiceVotes.keySet()) {
            int currVotes = firstChoiceVotes.get(s);
            total = total + currVotes;
            if (currVotes > numVotes) {
                numVotes = currVotes;
                currentWinner = s;
            }
        }
        if (numVotes >= total / 2) {
            return currentWinner;
        }
        return "*Requires Runoff Poll*";
    }

    /**
     * Calculates which candidate has the highest number of first, second, or third choice votes.
     * @return The candidate with the most "points".
     */
    public String pickWinnerMostAgreeable() {
        String currentWinner = "";
        int currentPoints = 0;
        int mostPoints = 0;
        for (String s : firstChoiceVotes.keySet()) {
            if(firstChoiceVotes.get(s) >= secondChoiceVotes.get(s) && firstChoiceVotes.get(s) >= thirdChoiceVotes.get(s)){ currentPoints = firstChoiceVotes.get(s);}
            if(secondChoiceVotes.get(s) >= firstChoiceVotes.get(s) && secondChoiceVotes.get(s) >= thirdChoiceVotes.get(s)){ currentPoints = secondChoiceVotes.get(s);}
            if(thirdChoiceVotes.get(s) >= secondChoiceVotes.get(s) && thirdChoiceVotes.get(s) >= firstChoiceVotes.get(s)){ currentPoints = thirdChoiceVotes.get(s);}
            if(currentPoints >= mostPoints){
            currentWinner = s;
            mostPoints = currentPoints;
            }
        }
    return currentWinner;
    }

    public LinkedList<String> getBallot(){
        return this.ballot;
    }
}

