package yz;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;

public final /* synthetic */ class o implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseCoreHostApi f24244a;

    public /* synthetic */ o(GeneratedAndroidFirebaseCore.FirebaseCoreHostApi firebaseCoreHostApi) {
        this.f24244a = firebaseCoreHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.CC.c(this.f24244a, obj, reply);
    }
}
