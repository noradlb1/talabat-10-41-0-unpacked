package fa;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.EnhancedIntentService;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f50615b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Intent f50616c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f50617d;

    public /* synthetic */ a(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.f50615b = enhancedIntentService;
        this.f50616c = intent;
        this.f50617d = taskCompletionSource;
    }

    public final void run() {
        this.f50615b.lambda$processIntent$0(this.f50616c, this.f50617d);
    }
}
