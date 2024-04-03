package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class MethodSortMatcher<T extends MethodDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final Sort sort;

    public enum Sort {
        METHOD("isMethod()") {
            public boolean c(MethodDescription methodDescription) {
                return methodDescription.isMethod();
            }
        },
        CONSTRUCTOR("isConstructor()") {
            public boolean c(MethodDescription methodDescription) {
                return methodDescription.isConstructor();
            }
        },
        TYPE_INITIALIZER("isTypeInitializer()") {
            public boolean c(MethodDescription methodDescription) {
                return methodDescription.isTypeInitializer();
            }
        },
        VIRTUAL("isVirtual()") {
            public boolean c(MethodDescription methodDescription) {
                return methodDescription.isVirtual();
            }
        },
        DEFAULT_METHOD("isDefaultMethod()") {
            public boolean c(MethodDescription methodDescription) {
                return methodDescription.isDefaultMethod();
            }
        };
        
        private final String description;
        private final MethodSortMatcher<?> matcher;

        public String a() {
            return this.description;
        }

        public MethodSortMatcher<?> b() {
            return this.matcher;
        }

        public abstract boolean c(MethodDescription methodDescription);

        private Sort(String str) {
            this.description = str;
            this.matcher = new MethodSortMatcher<>(this);
        }
    }

    public MethodSortMatcher(Sort sort2) {
        this.sort = sort2;
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> of(Sort sort2) {
        return sort2.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.sort.equals(((MethodSortMatcher) obj).sort);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.sort.hashCode();
    }

    public String toString() {
        return this.sort.a();
    }

    public boolean matches(T t11) {
        return this.sort.c(t11);
    }
}
