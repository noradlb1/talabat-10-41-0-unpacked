package com.apptimize;

import android.os.Looper;
import datamodels.TypesAliasesKt;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class fr {

    /* renamed from: a  reason: collision with root package name */
    private static Comparator<Thread> f42464a = new Comparator<Thread>() {
        /* renamed from: a */
        public int compare(Thread thread, Thread thread2) {
            return fr.b(thread).compareTo(fr.b(thread2));
        }
    };

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f42465a;

        /* renamed from: b  reason: collision with root package name */
        public int f42466b;

        /* renamed from: c  reason: collision with root package name */
        public String f42467c;

        /* renamed from: d  reason: collision with root package name */
        public int f42468d;

        public a(String str, int i11, String str2, int i12) {
            this.f42465a = str;
            this.f42466b = i11;
            this.f42467c = str2;
            this.f42468d = i12;
        }
    }

    /* access modifiers changed from: private */
    public static String b(Thread thread) {
        return "Thread: " + thread.getName() + " " + thread.getState();
    }

    public static a a(Set<Long> set, Set<String> set2) {
        if (set2 == null) {
            set2 = new HashSet<>();
        }
        Thread thread = Looper.getMainLooper() != null ? Looper.getMainLooper().getThread() : null;
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (thread != null && !allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        TreeMap treeMap = new TreeMap(f42464a);
        TreeMap treeMap2 = new TreeMap(f42464a);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (Map.Entry next : allStackTraces.entrySet()) {
            if (next.getValue() != null && ((StackTraceElement[]) next.getValue()).length > 0) {
                String a11 = a((StackTraceElement[]) next.getValue(), set2, atomicBoolean);
                if (set.contains(Long.valueOf(((Thread) next.getKey()).getId())) || atomicBoolean.get()) {
                    treeMap.put(next.getKey(), a11);
                } else {
                    treeMap2.put(next.getKey(), a11);
                }
            }
        }
        return new a(a((Map<Thread, String>) treeMap, thread), treeMap.size(), a((Map<Thread, String>) treeMap2, thread), treeMap2.size());
    }

    private static String a(Map<Thread, String> map, Thread thread) {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() != null && ((String) next.getValue()).length() > 0) {
                if (next.getKey() == thread) {
                    sb2.append("*");
                }
                sb2.append(b((Thread) next.getKey()));
                sb2.append(TypesAliasesKt.separator);
                sb2.append((String) next.getValue());
                sb2.append(TypesAliasesKt.separator);
            }
        }
        return sb2.toString();
    }

    private static String a(StackTraceElement[] stackTraceElementArr, Set<String> set, AtomicBoolean atomicBoolean) {
        atomicBoolean.set(false);
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (sb2.length() > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            if (set.contains(stackTraceElement.getClassName())) {
                atomicBoolean.set(true);
            }
            sb2.append(stackTraceElement.toString());
        }
        return sb2.toString();
    }
}
