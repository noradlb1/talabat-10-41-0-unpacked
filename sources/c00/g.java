package c00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.Messages;

public final /* synthetic */ class g implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.SharedPreferencesApi f11701a;

    public /* synthetic */ g(Messages.SharedPreferencesApi sharedPreferencesApi) {
        this.f11701a = sharedPreferencesApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        i.h(this.f11701a, obj, reply);
    }
}
