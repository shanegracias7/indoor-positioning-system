package dspanah.sensor_based_har;

public class UnitClassifier {

    public int getUnit(float[] results)
    {
        if(results[0] > 0.50) //LS
            return 0;
        else if (results[2] > 0.50) //SS
            return 2;
        return 1;
    }

}
