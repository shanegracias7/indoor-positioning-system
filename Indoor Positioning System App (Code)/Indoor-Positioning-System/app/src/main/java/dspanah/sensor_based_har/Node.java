package dspanah.sensor_based_har;

public class Node {

    public float x;
    public float y;
    int neighbours[];
  //  public boolean deadEnd;

    public Node(float x,float y,int ...neighbours)
    {
        this.x = x;
        this.y = y;
        this.neighbours = neighbours;
    }
}
