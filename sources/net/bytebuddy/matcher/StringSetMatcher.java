package net.bytebuddy.matcher;

import java.util.Set;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@HashCodeAndEqualsPlugin.Enhance
public class StringSetMatcher extends ElementMatcher.Junction.AbstractBase<String> {
    private final Set<String> values;

    public StringSetMatcher(Set<String> set) {
        this.values = set;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.values.equals(((StringSetMatcher) obj).values);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("in(");
        boolean z11 = true;
        for (String next : this.values) {
            if (z11) {
                z11 = false;
            } else {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(next);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public boolean matches(String str) {
        return this.values.contains(str);
    }
}
