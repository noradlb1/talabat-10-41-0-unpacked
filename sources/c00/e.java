package c00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.Messages;

public final /* synthetic */ class e implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.SharedPreferencesApi f11699a;

    public /* synthetic */ e(Messages.SharedPreferencesApi sharedPreferencesApi) {
        this.f11699a = sharedPreferencesApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        i.f(this.f11699a, obj, reply);
    }
}
