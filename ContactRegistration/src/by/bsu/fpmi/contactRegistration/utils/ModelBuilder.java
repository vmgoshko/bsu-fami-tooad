package by.bsu.fpmi.contactRegistration.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ModelBuilder {
    public static Map<String, Object> build(Map<String, String[]> parameters){
        Map<String, Object> model = new HashMap<String, Object>();
        for (String key : parameters.keySet()){
            model.put(key, Arrays.toString(parameters.get(key)).replace("[", "").replace("]", ""));
        }

        return model;
    }
}
