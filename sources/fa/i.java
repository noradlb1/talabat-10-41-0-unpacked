package fa;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.FirebaseMessaging;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f50627b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f50628c;

    public /* synthetic */ i(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f50627b = firebaseMessaging;
        this.f50628c = taskCompletionSource;
    }

    public final void run() {
        this.f50627b.lambda$deleteToken$5(this.f50628c);
    }
}
