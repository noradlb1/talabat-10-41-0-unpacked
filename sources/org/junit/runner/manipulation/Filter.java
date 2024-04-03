package org.junit.runner.manipulation;

import java.util.Iterator;
import org.junit.runner.Description;

public abstract class Filter {
    public static final Filter ALL = new Filter() {
        public void apply(Object obj) throws NoTestsRemainException {
        }

        public String describe() {
            return "all tests";
        }

        public Filter intersect(Filter filter) {
            return filter;
        }

        public boolean shouldRun(Description description) {
            return true;
        }
    };

    public static Filter matchMethodDescription(final Description description) {
        return new Filter() {
            public String describe() {
                return String.format("Method %s", new Object[]{description.getDisplayName()});
            }

            public boolean shouldRun(Description description) {
                if (description.isTest()) {
                    return description.equals(description);
                }
                Iterator<Description> it = description.getChildren().iterator();
                while (it.hasNext()) {
                    if (shouldRun(it.next())) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    public void apply(Object obj) throws NoTestsRemainException {
        if (obj instanceof Filterable) {
            ((Filterable) obj).filter(this);
        }
    }

    public abstract String describe();

    public Filter intersect(final Filter filter) {
        if (filter == this || filter == ALL) {
            return this;
        }
        return new Filter() {
            public String describe() {
                return this.describe() + " and " + filter.describe();
            }

            public boolean shouldRun(Description description) {
                return this.shouldRun(description) && filter.shouldRun(description);
            }
        };
    }

    public abstract boolean shouldRun(Description description);
}
