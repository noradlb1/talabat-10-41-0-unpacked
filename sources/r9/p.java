package r9;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.Utils;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f50770b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f50771c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f50772d;

    public /* synthetic */ p(Callable callable, Executor executor, TaskCompletionSource taskCompletionSource) {
        this.f50770b = callable;
        this.f50771c = executor;
        this.f50772d = taskCompletionSource;
    }

    public final void run() {
        Utils.lambda$callTask$3(this.f50770b, this.f50771c, this.f50772d);
    }
}
