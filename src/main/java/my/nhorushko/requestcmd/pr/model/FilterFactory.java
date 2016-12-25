package my.nhorushko.requestcmd.pr.model;

import my.nhorushko.requestcmd.pr.model.requestfilters.*;

import java.util.List;

/**
 * Created by Nikol on 12/19/2016.
 */
public class FilterFactory {
    private final String NAME_EQUALS = "nameEq";
    private final String NAME_CONSIST = "nameCon";
    private final String DESCRIPTION_EQUALS = "descEq";
    private final String DESCRIPTION_CONSIST = "descCON";
    private final String OPEN_CONDITION = "(";
    private final String CLOSE_CONDITION = ")";

    public List<Request> filter(List<Request> requests, String conditions) {
        Filter filter = new BasicFilter(requests);
        String[] parseString = conditions.split(",");
        for (String s : parseString) {
            String condition = s.substring(s.indexOf(OPEN_CONDITION) + 1, s.indexOf(CLOSE_CONDITION));
            if (s.contains(NAME_EQUALS)) {
                filter = new FilterByNameEquals(filter, condition);
            }
            if (s.contains(NAME_CONSIST)) {
                filter = new FilterByNameConsist(filter, condition);
            }
            if (s.contains(DESCRIPTION_EQUALS)) {
                filter = new FilterByDescriptionEquals(filter, condition);
            }
            if (s.contains(DESCRIPTION_CONSIST)) {
                filter = new FilterByDescriptionConsist(filter, condition);
            }
        }
        return filter.getFilteredList();
    }
}
