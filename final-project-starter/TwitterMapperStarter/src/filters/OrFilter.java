package filters;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * A filter that represents the logical and of its child filters
 */
public class OrFilter implements Filter {
    private final Filter child1;
    private final Filter child2;

    public OrFilter(Filter child1, Filter child2) {
        this.child1 = child1;
        this.child2 = child2;
    }

    /**
     * A not filter matches when its child doesn't, and vice versa
     * @param s     the tweet to check
     * @return      whether or not it matches
     */
    @Override
    public boolean matches(Status s) {
        return child1.matches(s) || child2.matches(s);
    }

    @Override
    public List<String> terms() {
        List<String> newList = new ArrayList<>(child1.terms());
        for (String s : child2.terms()) {
            if (!child1.terms().contains(s)) {
                newList.add(s);
            }
        }
        return newList;
    }

    public String toString() {
        return "("+child1.toString()+" or "+child2.toString()+")";
    }
}

