package yz;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;

public final /* synthetic */ class p implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseCoreHostApi f24245a;

    public /* synthetic */ p(GeneratedAndroidFirebaseCore.FirebaseCoreHostApi firebaseCoreHostApi) {
        this.f24245a = firebaseCoreHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.CC.d(this.f24245a, obj, reply);
    }
}
