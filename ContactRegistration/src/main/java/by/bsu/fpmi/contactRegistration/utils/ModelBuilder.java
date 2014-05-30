package by.bsu.fpmi.contactRegistration.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ModelBuilder {
    public static Map<String, Object> build(HttpServletRequest request){
        Map<String, String[]> parameters = request.getParameterMap();
        Map<String, Object> model = new HashMap<String, Object>();
        for (String key : parameters.keySet()){
            model.put(key, Arrays.toString(parameters.get(key)).replace("[", "").replace("]", ""));
        }
        model.put("lastFormId", request.getSession().getAttribute("lastFormId"));
        model.put("person", request.getSession().getAttribute("person"));

        return model;
    }
}
