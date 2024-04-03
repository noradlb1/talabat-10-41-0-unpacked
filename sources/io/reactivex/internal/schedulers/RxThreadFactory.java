package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;

    /* renamed from: b  reason: collision with root package name */
    public final String f18513b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18514c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f18515d;

    public static final class RxCustomThread extends Thread implements NonBlockingThread {
        public RxCustomThread(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public Thread newThread(Runnable runnable) {
        Thread thread;
        String str = this.f18513b + SignatureVisitor.SUPER + incrementAndGet();
        if (this.f18515d) {
            thread = new RxCustomThread(runnable, str);
        } else {
            thread = new Thread(runnable, str);
        }
        thread.setPriority(this.f18514c);
        thread.setDaemon(true);
        return thread;
    }

    public String toString() {
        return "RxThreadFactory[" + this.f18513b + "]";
    }

    public RxThreadFactory(String str, int i11) {
        this(str, i11, false);
    }

    public RxThreadFactory(String str, int i11, boolean z11) {
        this.f18513b = str;
        this.f18514c = i11;
        this.f18515d = z11;
    }
}
