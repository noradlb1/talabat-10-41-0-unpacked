package org.hamcrest;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.text.Typography;
import org.hamcrest.internal.ArrayIterator;
import org.hamcrest.internal.SelfDescribingValueIterator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class BaseDescription implements Description {
    private String descriptionOf(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception unused) {
            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
        }
    }

    private void toJavaSyntax(String str) {
        a('\"');
        for (int i11 = 0; i11 < str.length(); i11++) {
            toJavaSyntax(str.charAt(i11));
        }
        a('\"');
    }

    public abstract void a(char c11);

    public Description appendDescriptionOf(SelfDescribing selfDescribing) {
        selfDescribing.describeTo(this);
        return this;
    }

    public Description appendList(String str, String str2, String str3, Iterable<? extends SelfDescribing> iterable) {
        return appendList(str, str2, str3, iterable.iterator());
    }

    public Description appendText(String str) {
        b(str);
        return this;
    }

    public Description appendValue(Object obj) {
        if (obj == null) {
            b("null");
        } else if (obj instanceof String) {
            toJavaSyntax((String) obj);
        } else if (obj instanceof Character) {
            a('\"');
            toJavaSyntax(((Character) obj).charValue());
            a('\"');
        } else if (obj instanceof Short) {
            a(Typography.less);
            b(descriptionOf(obj));
            b("s>");
        } else if (obj instanceof Long) {
            a(Typography.less);
            b(descriptionOf(obj));
            b("L>");
        } else if (obj instanceof Float) {
            a(Typography.less);
            b(descriptionOf(obj));
            b("F>");
        } else if (obj.getClass().isArray()) {
            appendValueList("[", IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "]", new ArrayIterator(obj));
        } else {
            a(Typography.less);
            b(descriptionOf(obj));
            a(Typography.greater);
        }
        return this;
    }

    public <T> Description appendValueList(String str, String str2, String str3, T... tArr) {
        return appendValueList(str, str2, str3, Arrays.asList(tArr));
    }

    public void b(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            a(str.charAt(i11));
        }
    }

    private Description appendList(String str, String str2, String str3, Iterator<? extends SelfDescribing> it) {
        b(str);
        boolean z11 = false;
        while (it.hasNext()) {
            if (z11) {
                b(str2);
            }
            appendDescriptionOf((SelfDescribing) it.next());
            z11 = true;
        }
        b(str3);
        return this;
    }

    public <T> Description appendValueList(String str, String str2, String str3, Iterable<T> iterable) {
        return appendValueList(str, str2, str3, iterable.iterator());
    }

    private <T> Description appendValueList(String str, String str2, String str3, Iterator<T> it) {
        return appendList(str, str2, str3, (Iterator<? extends SelfDescribing>) new SelfDescribingValueIterator(it));
    }

    private void toJavaSyntax(char c11) {
        if (c11 == 9) {
            b("\\t");
        } else if (c11 == 10) {
            b("\\n");
        } else if (c11 == 13) {
            b("\\r");
        } else if (c11 != '\"') {
            a(c11);
        } else {
            b("\\\"");
        }
    }
}
