package yz;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;

public final /* synthetic */ class l implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseAppHostApi f24241a;

    public /* synthetic */ l(GeneratedAndroidFirebaseCore.FirebaseAppHostApi firebaseAppHostApi) {
        this.f24241a = firebaseAppHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidFirebaseCore.FirebaseAppHostApi.CC.c(this.f24241a, obj, reply);
    }
}
