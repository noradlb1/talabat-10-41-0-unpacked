package c00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.Messages;

public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.SharedPreferencesApi f11695a;

    public /* synthetic */ a(Messages.SharedPreferencesApi sharedPreferencesApi) {
        this.f11695a = sharedPreferencesApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        i.b(this.f11695a, obj, reply);
    }
}
