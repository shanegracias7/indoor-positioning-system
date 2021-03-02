package dspanah.sensor_based_har;

public class ActivityClassifier {

    public int getActivity(float[] results)
    {
        if(results[0] > 0.50) //run
            return 2; //step length in cms
        else if (results[2] > 0.50) //walk
            return 2;
        return 1;
    }

}
