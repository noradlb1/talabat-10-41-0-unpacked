package p00;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.ThreadPoolDispatcherKt;

public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f28127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f28128c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f28129d;

    public /* synthetic */ a(int i11, String str, AtomicInteger atomicInteger) {
        this.f28127b = i11;
        this.f28128c = str;
        this.f28129d = atomicInteger;
    }

    public final Thread newThread(Runnable runnable) {
        return ThreadPoolDispatcherKt.m7783newFixedThreadPoolContext$lambda1(this.f28127b, this.f28128c, this.f28129d, runnable);
    }
}
