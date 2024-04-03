package d2;

import androidx.lifecycle.DispatchQueue;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DispatchQueue f44271b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f44272c;

    public /* synthetic */ b(DispatchQueue dispatchQueue, Runnable runnable) {
        this.f44271b = dispatchQueue;
        this.f44272c = runnable;
    }

    public final void run() {
        DispatchQueue.m9089dispatchAndEnqueue$lambda2$lambda1(this.f44271b, this.f44272c);
    }
}
