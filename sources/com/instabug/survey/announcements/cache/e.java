package com.instabug.survey.announcements.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.survey.announcements.models.a;
import java.util.Iterator;
import java.util.List;

@WorkerThread
public abstract class e {
    public static long a(long j11, long j12, String str) {
        return a.a(j11, j12, str);
    }

    @Nullable
    public static a a(long j11) {
        return f.b(j11);
    }

    @Nullable
    public static String a(long j11, long j12) {
        return a.a(j11, j12);
    }

    public static List a(int i11) {
        return f.a(i11);
    }

    public static void a() {
        a.a();
    }

    public static void a(long j11, int i11) {
        f.a(j11, i11);
    }

    public static void a(a aVar) {
        f.b(aVar);
    }

    public static void a(a aVar, boolean z11, boolean z12) {
        PoolProvider.postIOTask(new b(aVar, z11, z12));
    }

    public static void a(String str) {
        f.a(str);
    }

    public static void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).w();
        }
        f.b(list);
    }

    public static List b() {
        return f.b();
    }

    public static void b(a aVar) {
        PoolProvider.postIOTask(new c(aVar));
    }

    public static void b(List list) {
        PoolProvider.postIOTask(new d(list));
    }

    public static boolean b(long j11) {
        return f.a(j11);
    }

    public static List c() {
        return f.c();
    }
}
