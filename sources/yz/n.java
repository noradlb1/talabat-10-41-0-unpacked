package yz;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;

public final /* synthetic */ class n implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseCoreHostApi f24243a;

    public /* synthetic */ n(GeneratedAndroidFirebaseCore.FirebaseCoreHostApi firebaseCoreHostApi) {
        this.f24243a = firebaseCoreHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.CC.b(this.f24243a, obj, reply);
    }
}
