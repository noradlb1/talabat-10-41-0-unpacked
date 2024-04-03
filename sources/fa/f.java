package fa;

import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.messaging.FirebaseMessaging;

public final /* synthetic */ class f implements FirebaseInstanceIdInternal.NewTokenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f50624a;

    public /* synthetic */ f(FirebaseMessaging firebaseMessaging) {
        this.f50624a = firebaseMessaging;
    }

    public final void onNewToken(String str) {
        this.f50624a.lambda$new$0(str);
    }
}
