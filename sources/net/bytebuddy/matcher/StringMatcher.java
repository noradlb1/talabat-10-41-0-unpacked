package net.bytebuddy.matcher;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class StringMatcher extends ElementMatcher.Junction.AbstractBase<String> {
    private final Mode mode;
    private final String value;

    public enum Mode {
        EQUALS_FULLY("equals") {
            public boolean b(String str, String str2) {
                return str2.equals(str);
            }
        },
        EQUALS_FULLY_IGNORE_CASE("equalsIgnoreCase") {
            public boolean b(String str, String str2) {
                return str2.equalsIgnoreCase(str);
            }
        },
        STARTS_WITH("startsWith") {
            public boolean b(String str, String str2) {
                return str2.startsWith(str);
            }
        },
        STARTS_WITH_IGNORE_CASE("startsWithIgnoreCase") {
            @SuppressFBWarnings(justification = "Both strings are transformed by the default locale", value = {"DM_CONVERT_CASE"})
            public boolean b(String str, String str2) {
                return str2.toLowerCase().startsWith(str.toLowerCase());
            }
        },
        ENDS_WITH("endsWith") {
            public boolean b(String str, String str2) {
                return str2.endsWith(str);
            }
        },
        ENDS_WITH_IGNORE_CASE("endsWithIgnoreCase") {
            @SuppressFBWarnings(justification = "Both strings are transformed by the default locale", value = {"DM_CONVERT_CASE"})
            public boolean b(String str, String str2) {
                return str2.toLowerCase().endsWith(str.toLowerCase());
            }
        },
        CONTAINS("contains") {
            public boolean b(String str, String str2) {
                return str2.contains(str);
            }
        },
        CONTAINS_IGNORE_CASE("containsIgnoreCase") {
            @SuppressFBWarnings(justification = "Both strings are transformed by the default locale", value = {"DM_CONVERT_CASE"})
            public boolean b(String str, String str2) {
                return str2.toLowerCase().contains(str.toLowerCase());
            }
        },
        MATCHES("matches") {
            public boolean b(String str, String str2) {
                return str2.matches(str);
            }
        };
        
        private final String description;

        public String a() {
            return this.description;
        }

        public abstract boolean b(String str, String str2);

        private Mode(String str) {
            this.description = str;
        }
    }

    public StringMatcher(String str, Mode mode2) {
        this.value = str;
        this.mode = mode2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StringMatcher stringMatcher = (StringMatcher) obj;
        return this.mode.equals(stringMatcher.mode) && this.value.equals(stringMatcher.value);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.value.hashCode()) * 31) + this.mode.hashCode();
    }

    public String toString() {
        return this.mode.a() + '(' + this.value + ')';
    }

    public boolean matches(String str) {
        return this.mode.b(this.value, str);
    }
}
