package dspanah.sensor_based_har;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DistanceEstimator {

    private static List<Integer> bufferX = new ArrayList<>();
    private static List<Integer> bufferY = new ArrayList<>();
    private Integer unitValue;
    private int bufferSize = 3;

    public float getStepLengthX(int activity, int unit)
    {
        if (activity == 0) //run
        {
            bufferX.add(unit);
            unitValue = mode(bufferX);
            System.out.println(bufferX);
            System.out.println(unitValue);

            if(bufferX.size() == bufferSize)
                bufferX.remove(0);

            return 75;
        }
        else if (activity == 2) //walk
        {
            bufferX.add(unit);
            unitValue = mode(bufferX);
            System.out.println(bufferX);
            System.out.println(unitValue);


            if(bufferX.size() == bufferSize)
                bufferX.remove(0);

            if(unitValue == 0) //ls
            {
                if(bufferX.contains(3))
                    return 59.24f; //ls pixel value
                else
                    return 39.5f;
            }
            else if(unitValue == 1) //ns
            {
                if(bufferX.contains(3))
                    return 52.66f; //ns pixel value
                else
                    return 35.11f;
            }
            else //ss
            {
                if(bufferX.contains(3))
                    return 47.4f; //ss pixel value
                else
                    return 31.6f;
            }
        }
        return 0;
    }
    public float getStepLengthY(int activity, int unit)
    {

        if (activity == 0) //run
        {
            bufferY.add(unit);
            unitValue = mode(bufferY);
            System.out.println(bufferY);
            System.out.println(unitValue);

            if(bufferY.size() == bufferSize)
                bufferY.remove(0);

            return 87;
        }
        else if (activity == 2) //walk
        {
            bufferY.add(unit);
            unitValue = mode(bufferY);
            System.out.println(bufferY);
            System.out.println(unitValue);

            if(bufferY.size() == bufferSize)
                bufferY.remove(0);

            if(unitValue == 0) //ls
            {
                if(bufferY.contains(3))
                    return 59.125f; //ls pixel value
                else
                    return 39.417f;
            }
            else if(unitValue == 1) //ns
            {
                if(bufferY.contains(3))
                    return 52.48f; //ns pixel value
                else
                    return 34.99f;
            }
            else //ss
            {
                if(bufferY.contains(3))
                    return 47.3f; //ss pixel value
                else
                    return 31.53f;
            }
        }
        return 0;
    }

    private static Integer mode(List<Integer> list) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i< list.size(); i++) {

            Integer frequency = map.get(list.get(i));
            if(frequency == null) {
                map.put(list.get(i), 1);
            } else {
                map.put(list.get(i), frequency+1);
            }
        }

        Integer mostCommonKey = null;
        int maxValue = -1;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {

            if(entry.getValue() > maxValue) {
                mostCommonKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        return mostCommonKey;
    }
}
