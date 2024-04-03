package fa;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.FirebaseMessaging;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f50629b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f50630c;

    public /* synthetic */ j(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f50629b = firebaseMessaging;
        this.f50630c = taskCompletionSource;
    }

    public final void run() {
        this.f50629b.lambda$deleteToken$6(this.f50630c);
    }
}
