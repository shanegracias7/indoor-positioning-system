package dspanah.sensor_based_har;

import android.content.Context;

import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

public class HARClassifier {
    static {
        System.loadLibrary("tensorflow_inference");
    }

    private TensorFlowInferenceInterface inferenceInterface;
   // private static final String MODEL_FILE = "file:///android_asset/frozen_model.pb";
    private static final String MODEL_FILE = "file:///android_asset/frozen_harActivity200.pb";
    //private static final String MODEL_FILE = "file:///android_asset/frozen_harO.pb";
    private static final String INPUT_NODE = "input";
    private static final String[] OUTPUT_NODES = {"y_"};
    private static final String OUTPUT_NODE = "y_";
    private static final long[] INPUT_SIZE = {1, 200, 3};
    private static final int OUTPUT_SIZE = 3;

    public HARClassifier(final Context context) {
        inferenceInterface = new TensorFlowInferenceInterface(context.getAssets(), MODEL_FILE);
    }

    public float[] predictProbabilities(float[] data) {
        float[] result = new float[OUTPUT_SIZE];
        inferenceInterface.feed(INPUT_NODE, data, INPUT_SIZE);
        inferenceInterface.run(OUTPUT_NODES);
        inferenceInterface.fetch(OUTPUT_NODE, result);

        //Biking   Downstairs	 Jogging	  Sitting	Standing	Upstairs	Walking
        return result;
    }

}
