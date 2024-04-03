package yz;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;

public final /* synthetic */ class m implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseAppHostApi f24242a;

    public /* synthetic */ m(GeneratedAndroidFirebaseCore.FirebaseAppHostApi firebaseAppHostApi) {
        this.f24242a = firebaseAppHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidFirebaseCore.FirebaseAppHostApi.CC.d(this.f24242a, obj, reply);
    }
}
