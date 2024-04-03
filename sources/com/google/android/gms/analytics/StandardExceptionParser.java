package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

@VisibleForTesting
public class StandardExceptionParser implements ExceptionParser {
    private final TreeSet<String> zzta = new TreeSet<>();

    public StandardExceptionParser(Context context, Collection<String> collection) {
        setIncludedPackages(context, collection);
    }

    public StackTraceElement getBestStackTraceElement(Throwable th2) {
        StackTraceElement[] stackTrace = th2.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator<String> it = this.zzta.iterator();
            while (it.hasNext()) {
                if (className.startsWith(it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }

    public Throwable getCause(Throwable th2) {
        while (th2.getCause() != null) {
            th2 = th2.getCause();
        }
        return th2;
    }

    public String getDescription(Throwable th2, StackTraceElement stackTraceElement, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(th2.getClass().getSimpleName());
        if (stackTraceElement != null) {
            String[] split = stackTraceElement.getClassName().split("\\.");
            sb2.append(String.format(" (@%s:%s:%s)", new Object[]{(split == null || split.length <= 0) ? "unknown" : split[split.length - 1], stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())}));
        }
        if (str != null) {
            sb2.append(String.format(" {%s}", new Object[]{str}));
        }
        return sb2.toString();
    }

    public void setIncludedPackages(Context context, Collection<String> collection) {
        this.zzta.clear();
        HashSet<String> hashSet = new HashSet<>();
        if (collection != null) {
            hashSet.addAll(collection);
        }
        if (context != null) {
            hashSet.add(context.getApplicationContext().getPackageName());
        }
        for (String str : hashSet) {
            Iterator<String> it = this.zzta.iterator();
            boolean z11 = true;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (str.startsWith(next)) {
                    z11 = false;
                } else if (next.startsWith(str)) {
                    this.zzta.remove(next);
                }
            }
            if (z11) {
                this.zzta.add(str);
            }
        }
    }

    public String getDescription(String str, Throwable th2) {
        return getDescription(getCause(th2), getBestStackTraceElement(getCause(th2)), str);
    }
}
