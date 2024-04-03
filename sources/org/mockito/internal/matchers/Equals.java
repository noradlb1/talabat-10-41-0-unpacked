package org.mockito.internal.matchers;

import java.io.Serializable;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.matchers.text.ValuePrinter;

public class Equals implements ArgumentMatcher<Object>, ContainsExtraTypeInfo, Serializable {
    private final Object wanted;

    public Equals(Object obj) {
        this.wanted = obj;
    }

    private String describe(Object obj) {
        return ValuePrinter.print(obj);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Equals)) {
            return false;
        }
        Equals equals = (Equals) obj;
        Object obj2 = this.wanted;
        if ((obj2 != null || equals.wanted != null) && (obj2 == null || !obj2.equals(equals.wanted))) {
            return false;
        }
        return true;
    }

    public final Object getWanted() {
        return this.wanted;
    }

    public int hashCode() {
        return 1;
    }

    public boolean matches(Object obj) {
        return Equality.areEqual(this.wanted, obj);
    }

    public String toString() {
        return describe(this.wanted);
    }

    public String toStringWithType(String str) {
        return "(" + str + ") " + describe(this.wanted);
    }

    public boolean typeMatches(Object obj) {
        return (this.wanted == null || obj == null || obj.getClass() != this.wanted.getClass()) ? false : true;
    }
}
