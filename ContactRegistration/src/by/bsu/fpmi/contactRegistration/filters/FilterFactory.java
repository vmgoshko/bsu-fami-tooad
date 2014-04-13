package by.bsu.fpmi.contactRegistration.filters;

import java.util.ArrayList;
import java.util.List;

public class FilterFactory {
    public List<Filter> createFilters() {
        List<Filter> urlFilters = new ArrayList<Filter>();
        urlFilters.add(new FormFilter());
        return urlFilters;
    }

}
