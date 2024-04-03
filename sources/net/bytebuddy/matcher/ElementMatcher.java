package net.bytebuddy.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

public interface ElementMatcher<T> {

    public interface Junction<S> extends ElementMatcher<S> {

        public static abstract class AbstractBase<V> implements Junction<V> {
            public <U extends V> Junction<U> and(ElementMatcher<? super U> elementMatcher) {
                return new Conjunction((ElementMatcher<? super W>[]) new ElementMatcher[]{this, elementMatcher});
            }

            public <U extends V> Junction<U> or(ElementMatcher<? super U> elementMatcher) {
                return new Disjunction((ElementMatcher<? super W>[]) new ElementMatcher[]{this, elementMatcher});
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Conjunction<W> extends AbstractBase<W> {
            private final List<ElementMatcher<? super W>> matchers;

            public Conjunction(ElementMatcher<? super W>... elementMatcherArr) {
                this(Arrays.asList(elementMatcherArr));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Conjunction) obj).matchers);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.matchers.hashCode();
            }

            public boolean matches(W w11) {
                for (ElementMatcher<? super W> matches : this.matchers) {
                    if (!matches.matches(w11)) {
                        return false;
                    }
                }
                return true;
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder("(");
                boolean z11 = true;
                for (ElementMatcher next : this.matchers) {
                    if (z11) {
                        z11 = false;
                    } else {
                        sb2.append(" and ");
                    }
                    sb2.append(next);
                }
                sb2.append(")");
                return sb2.toString();
            }

            public Conjunction(List<ElementMatcher<? super W>> list) {
                this.matchers = new ArrayList(list.size());
                for (ElementMatcher next : list) {
                    if (next instanceof Conjunction) {
                        this.matchers.addAll(((Conjunction) next).matchers);
                    } else {
                        this.matchers.add(next);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Disjunction<W> extends AbstractBase<W> {
            private final List<ElementMatcher<? super W>> matchers;

            public Disjunction(ElementMatcher<? super W>... elementMatcherArr) {
                this(Arrays.asList(elementMatcherArr));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Disjunction) obj).matchers);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.matchers.hashCode();
            }

            public boolean matches(W w11) {
                for (ElementMatcher<? super W> matches : this.matchers) {
                    if (matches.matches(w11)) {
                        return true;
                    }
                }
                return false;
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder("(");
                boolean z11 = true;
                for (ElementMatcher next : this.matchers) {
                    if (z11) {
                        z11 = false;
                    } else {
                        sb2.append(" or ");
                    }
                    sb2.append(next);
                }
                sb2.append(")");
                return sb2.toString();
            }

            public Disjunction(List<ElementMatcher<? super W>> list) {
                this.matchers = new ArrayList(list.size());
                for (ElementMatcher next : list) {
                    if (next instanceof Disjunction) {
                        this.matchers.addAll(((Disjunction) next).matchers);
                    } else {
                        this.matchers.add(next);
                    }
                }
            }
        }

        <U extends S> Junction<U> and(ElementMatcher<? super U> elementMatcher);

        <U extends S> Junction<U> or(ElementMatcher<? super U> elementMatcher);
    }

    boolean matches(T t11);
}
