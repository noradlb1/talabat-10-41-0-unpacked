package c00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.Messages;

public final /* synthetic */ class c implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.SharedPreferencesApi f11697a;

    public /* synthetic */ c(Messages.SharedPreferencesApi sharedPreferencesApi) {
        this.f11697a = sharedPreferencesApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        i.d(this.f11697a, obj, reply);
    }
}
