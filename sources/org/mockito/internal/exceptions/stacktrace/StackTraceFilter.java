package org.mockito.internal.exceptions.stacktrace;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.mockito.exceptions.stacktrace.StackTraceCleaner;
import org.mockito.internal.configuration.plugins.Plugins;

public class StackTraceFilter implements Serializable {
    private static final StackTraceCleaner CLEANER = Plugins.getStackTraceCleanerProvider().getStackTraceCleaner(new DefaultStackTraceCleaner());
    private static Method GET_STACK_TRACE_ELEMENT = null;
    private static Object JAVA_LANG_ACCESS = null;
    static final long serialVersionUID = -5499819791513105700L;

    static {
        try {
            JAVA_LANG_ACCESS = Class.forName("sun.misc.SharedSecrets").getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
            GET_STACK_TRACE_ELEMENT = Class.forName("sun.misc.JavaLangAccess").getMethod("getStackTraceElement", new Class[]{Throwable.class, Integer.TYPE});
        } catch (Exception unused) {
        }
    }

    public StackTraceElement[] filter(StackTraceElement[] stackTraceElementArr, boolean z11) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (CLEANER.isIn(stackTraceElement)) {
                arrayList.add(stackTraceElement);
            }
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    public StackTraceElement filterFirst(Throwable th2, boolean z11) {
        if (GET_STACK_TRACE_ELEMENT != null) {
            int i11 = 0;
            while (true) {
                try {
                    StackTraceElement stackTraceElement = (StackTraceElement) GET_STACK_TRACE_ELEMENT.invoke(JAVA_LANG_ACCESS, new Object[]{th2, Integer.valueOf(i11)});
                    if (CLEANER.isIn(stackTraceElement)) {
                        if (!z11) {
                            return stackTraceElement;
                        }
                        z11 = false;
                    }
                    i11++;
                } catch (Exception unused) {
                }
            }
        }
        for (StackTraceElement stackTraceElement2 : th2.getStackTrace()) {
            if (CLEANER.isIn(stackTraceElement2)) {
                if (!z11) {
                    return stackTraceElement2;
                }
                z11 = false;
            }
        }
        return null;
    }

    public String findSourceFile(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (CLEANER.isIn(stackTraceElement)) {
                return stackTraceElement.getFileName();
            }
        }
        return str;
    }
}
