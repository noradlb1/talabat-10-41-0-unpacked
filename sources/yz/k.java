package yz;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;

public final /* synthetic */ class k implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseAppHostApi f24240a;

    public /* synthetic */ k(GeneratedAndroidFirebaseCore.FirebaseAppHostApi firebaseAppHostApi) {
        this.f24240a = firebaseAppHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidFirebaseCore.FirebaseAppHostApi.CC.b(this.f24240a, obj, reply);
    }
}
