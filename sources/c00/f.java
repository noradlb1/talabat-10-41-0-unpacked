package c00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.Messages;

public final /* synthetic */ class f implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.SharedPreferencesApi f11700a;

    public /* synthetic */ f(Messages.SharedPreferencesApi sharedPreferencesApi) {
        this.f11700a = sharedPreferencesApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        i.g(this.f11700a, obj, reply);
    }
}
