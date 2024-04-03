package u6;

import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f34725b;

    public /* synthetic */ k(TaskCompletionSource taskCompletionSource) {
        this.f34725b = taskCompletionSource;
    }

    public final void run() {
        Task.Companion.m8942delay$lambda0(this.f34725b);
    }
}
