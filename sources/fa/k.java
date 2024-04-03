package fa;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.FirebaseMessaging;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f50631b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f50632c;

    public /* synthetic */ k(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f50631b = firebaseMessaging;
        this.f50632c = taskCompletionSource;
    }

    public final void run() {
        this.f50631b.lambda$getToken$4(this.f50632c);
    }
}
