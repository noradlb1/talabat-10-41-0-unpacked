package org.junit.experimental.theories.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class ParameterizedAssertionError extends AssertionError {
    private static final long serialVersionUID = 1;

    public ParameterizedAssertionError(Throwable th2, String str, Object... objArr) {
        super(String.format("%s(%s)", new Object[]{str, join((String) IndicativeSentencesGeneration.DEFAULT_SEPARATOR, objArr)}));
        initCause(th2);
    }

    public static String join(String str, Object... objArr) {
        return join(str, (Collection<Object>) Arrays.asList(objArr));
    }

    private static String stringValueOf(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Throwable unused) {
            return "[toString failed]";
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedAssertionError) && toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public static String join(String str, Collection<Object> collection) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<Object> it = collection.iterator();
        while (it.hasNext()) {
            sb2.append(stringValueOf(it.next()));
            if (it.hasNext()) {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }
}
