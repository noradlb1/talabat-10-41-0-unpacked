package j2;

import androidx.room.InvalidationTracker;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InvalidationTracker f44350b;

    public /* synthetic */ o(InvalidationTracker invalidationTracker) {
        this.f44350b = invalidationTracker;
    }

    public final void run() {
        this.f44350b.c();
    }
}
