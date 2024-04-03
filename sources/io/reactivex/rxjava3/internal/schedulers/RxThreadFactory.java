package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;

    /* renamed from: b  reason: collision with root package name */
    public final String f23072b;

    /* renamed from: c  reason: collision with root package name */
    public final int f23073c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f23074d;

    public static final class RxCustomThread extends Thread implements NonBlockingThread {
        public RxCustomThread(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public Thread newThread(@NonNull Runnable runnable) {
        Thread thread;
        String str = this.f23072b + SignatureVisitor.SUPER + incrementAndGet();
        if (this.f23074d) {
            thread = new RxCustomThread(runnable, str);
        } else {
            thread = new Thread(runnable, str);
        }
        thread.setPriority(this.f23073c);
        thread.setDaemon(true);
        return thread;
    }

    public String toString() {
        return "RxThreadFactory[" + this.f23072b + "]";
    }

    public RxThreadFactory(String str, int i11) {
        this(str, i11, false);
    }

    public RxThreadFactory(String str, int i11, boolean z11) {
        this.f23072b = str;
        this.f23073c = i11;
        this.f23074d = z11;
    }
}
