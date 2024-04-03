package org.junit.jupiter.api;

import j$.util.function.Supplier;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.StringUtils;
import org.opentest4j.AssertionFailedError;

@API(since = "5.9", status = API.Status.STABLE)
public class AssertionFailureBuilder {
    private Object actual;
    private Throwable cause;
    private Object expected;
    private boolean includeValuesInMessage = true;
    private Object message;
    private boolean mismatch;
    private String reason;

    private AssertionFailureBuilder() {
    }

    public static AssertionFailureBuilder assertionFailure() {
        return new AssertionFailureBuilder();
    }

    private static String buildPrefix(String str) {
        if (!StringUtils.isNotBlank(str)) {
            return "";
        }
        return str + " ==> ";
    }

    private static String formatClassAndValue(Object obj, String str) {
        StringBuilder sb2;
        if (obj == null) {
            return "<null>";
        }
        String str2 = getClassName(obj) + toHash(obj);
        if (obj instanceof Class) {
            sb2 = new StringBuilder();
            sb2.append("<");
            sb2.append(str2);
        } else {
            sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append("<");
            sb2.append(str);
        }
        sb2.append(">");
        return sb2.toString();
    }

    private static String formatValues(Object obj, Object obj2) {
        String assertionFailureBuilder = toString(obj);
        String assertionFailureBuilder2 = toString(obj2);
        if (assertionFailureBuilder.equals(assertionFailureBuilder2)) {
            return String.format("expected: %s but was: %s", new Object[]{formatClassAndValue(obj, assertionFailureBuilder), formatClassAndValue(obj2, assertionFailureBuilder2)});
        }
        return String.format("expected: <%s> but was: <%s>", new Object[]{assertionFailureBuilder, assertionFailureBuilder2});
    }

    private static String getClassName(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof Class) {
            return AssertionUtils.m((Class) obj);
        }
        return obj.getClass().getName();
    }

    private static String nullSafeGet(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Supplier) {
            return StringUtils.nullSafeToString(((Supplier) obj).get());
        }
        return StringUtils.nullSafeToString(obj);
    }

    private static String toHash(Object obj) {
        if (obj == null) {
            return "";
        }
        return "@" + Integer.toHexString(System.identityHashCode(obj));
    }

    private static String toString(Object obj) {
        if (obj instanceof Class) {
            return AssertionUtils.m((Class) obj);
        }
        return StringUtils.nullSafeToString(obj);
    }

    public AssertionFailureBuilder actual(Object obj) {
        this.mismatch = true;
        this.actual = obj;
        return this;
    }

    public AssertionFailedError build() {
        String str;
        String nullSafeGet = nullSafeGet(this.reason);
        if (this.mismatch && this.includeValuesInMessage) {
            StringBuilder sb2 = new StringBuilder();
            if (nullSafeGet == null) {
                str = "";
            } else {
                str = nullSafeGet + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
            }
            sb2.append(str);
            sb2.append(formatValues(this.expected, this.actual));
            nullSafeGet = sb2.toString();
        }
        String nullSafeGet2 = nullSafeGet(this.message);
        if (nullSafeGet != null) {
            nullSafeGet2 = buildPrefix(nullSafeGet2) + nullSafeGet;
        }
        if (this.mismatch) {
            return new AssertionFailedError(nullSafeGet2, this.expected, this.actual, this.cause);
        }
        return new AssertionFailedError(nullSafeGet2, this.cause);
    }

    public void buildAndThrow() throws AssertionFailedError {
        throw build();
    }

    public AssertionFailureBuilder cause(Throwable th2) {
        this.cause = th2;
        return this;
    }

    public AssertionFailureBuilder expected(Object obj) {
        this.mismatch = true;
        this.expected = obj;
        return this;
    }

    public AssertionFailureBuilder includeValuesInMessage(boolean z11) {
        this.includeValuesInMessage = z11;
        return this;
    }

    public AssertionFailureBuilder message(Object obj) {
        this.message = obj;
        return this;
    }

    public AssertionFailureBuilder reason(String str) {
        this.reason = str;
        return this;
    }
}
