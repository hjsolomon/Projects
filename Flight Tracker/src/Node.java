public class Node {
    private int id;
    private String data;
    double cost;




    public Node(int id, String data){
        this.id = id;
        this.data = data;

    }



    public String getData(){
        return this.data;
    }

    public void setCost(double newCost){
        this.cost = newCost;
    }

}
