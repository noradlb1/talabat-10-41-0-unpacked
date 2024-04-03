package net.bytebuddy.matcher;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.Iterable;
import java.util.Collection;
import java.util.Iterator;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class CollectionSizeMatcher<T extends Iterable<?>> extends ElementMatcher.Junction.AbstractBase<T> {
    private final int size;

    public CollectionSizeMatcher(int i11) {
        this.size = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.size == ((CollectionSizeMatcher) obj).size;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.size;
    }

    public String toString() {
        return "ofSize(" + this.size + ')';
    }

    @SuppressFBWarnings(justification = "Iteration required to count size of an iterable", value = {"DLS_DEAD_LOCAL_STORE"})
    public boolean matches(T t11) {
        if (!(t11 instanceof Collection)) {
            Iterator it = t11.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                it.next();
                i11++;
            }
            if (i11 == this.size) {
                return true;
            }
            return false;
        } else if (((Collection) t11).size() == this.size) {
            return true;
        } else {
            return false;
        }
    }
}
