import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {
    VotingData setup1() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("gompei");
            vd.nominateCandidate("husky");
            vd.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("gompei", "husky", "ziggy");
            vd.submitVote("gompei", "ziggy", "husky");
            vd.submitVote("husky", "gompei", "ziggy");

        } catch (Exception e) {}

        return(vd);

    }
    VotingData setup2() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("gompei");
            vd.nominateCandidate("husky");
            vd.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("gompei", "husky", "ziggy");
            vd.submitVote("gompei", "ziggy", "husky");


        } catch (Exception e) {}

        return(vd);

    }
    VotingData setup3() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("gompei");
            vd.nominateCandidate("gompei");
            vd.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("gompei", "husky", "ziggy");
            vd.submitVote("gompei", "ziggy", "husky");


        } catch (Exception e) {}

        return(vd);

    }

    VotingData setup4() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("gompei");
            vd.nominateCandidate("husky");
            vd.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("gompei", "gompei", "ziggy");
            vd.submitVote("gompei", "ziggy", "husky");


        } catch (Exception e) {}

        return(vd);

    }

    VotingData setup5() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("gompei");
            vd.nominateCandidate("husky");
            vd.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("gompei", "paul", "ziggy");
            vd.submitVote("gompei", "ziggy", "husky");


        } catch (Exception e) {}

        return(vd);

    }

    // now run a test on a specific election
    @Test
    public void testMostFirstWinner () {
        assertEquals ("gompei", this.setup1().pickWinnerMostFirstChoice());
    }

    @Test
    public void testMostPoints(){
        assertEquals("gompei", this.setup2().pickWinnerMostAgreeable());
    }

    @Test
    public void testRedundant() throws RedundantCandidateException{
        setup3();
    }

    @Test
    public void testChosenMoreThanOnce() throws CandidateChosenMoreThanOnceException{
        setup4();
    }

    @Test public void testNotFound() throws CandidateNotFoundException{
        setup5();
    }
}
