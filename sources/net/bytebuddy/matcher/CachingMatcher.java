package net.bytebuddy.matcher;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance(permitSubclassEquality = true)
public class CachingMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMap<? super T, Boolean> f27426b;
    private final ElementMatcher<? super T> matcher;

    @SuppressFBWarnings(justification = "Equality does not consider eviction size", value = {"EQ_DOESNT_OVERRIDE_EQUALS"})
    public static class WithInlineEviction<S> extends CachingMatcher<S> {
        private final int evictionSize;

        public WithInlineEviction(ElementMatcher<? super S> elementMatcher, ConcurrentMap<? super S, Boolean> concurrentMap, int i11) {
            super(elementMatcher, concurrentMap);
            this.evictionSize = i11;
        }

        public boolean a(S s11) {
            if (this.f27426b.size() >= this.evictionSize) {
                Iterator<Map.Entry<? super T, Boolean>> it = this.f27426b.entrySet().iterator();
                it.next();
                it.remove();
            }
            return CachingMatcher.super.a(s11);
        }
    }

    public CachingMatcher(ElementMatcher<? super T> elementMatcher, ConcurrentMap<? super T, Boolean> concurrentMap) {
        this.matcher = elementMatcher;
        this.f27426b = concurrentMap;
    }

    public boolean a(T t11) {
        boolean matches = this.matcher.matches(t11);
        this.f27426b.put(t11, Boolean.valueOf(matches));
        return matches;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CachingMatcher) && this.matcher.equals(((CachingMatcher) obj).matcher);
    }

    public int hashCode() {
        return (CachingMatcher.class.hashCode() * 31) + this.matcher.hashCode();
    }

    public boolean matches(T t11) {
        Boolean bool = this.f27426b.get(t11);
        if (bool == null) {
            bool = Boolean.valueOf(a(t11));
        }
        return bool.booleanValue();
    }

    public String toString() {
        return "cached(" + this.matcher + ")";
    }
}
