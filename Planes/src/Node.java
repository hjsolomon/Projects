public class Node {
    private int id;
    private String data;
    double cost;


   private double departureTime;
    private double arrivalTime;

    public Node(int id, String data){
        this.id = id;
        this.data = data;

    }

    public void setDepartureTime(double newDepartureTime){
        this.departureTime = newDepartureTime;
    }

    public void setArrivalTime(double newArrivalTime){
        this.arrivalTime = newArrivalTime;
    }

    public String getData(){
        return this.data;
    }

    public void setCost(double newCost){
        this.cost = newCost;
    }

}
