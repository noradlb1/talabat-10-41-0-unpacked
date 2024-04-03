package a00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.googlesignin.Messages;
import java.util.ArrayList;
import java.util.List;

public final /* synthetic */ class r implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.GoogleSignInApi f11659a;

    public /* synthetic */ r(Messages.GoogleSignInApi googleSignInApi) {
        this.f11659a = googleSignInApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        this.f11659a.requestScopes((List) ((ArrayList) obj).get(0), new Messages.Result<Boolean>(new ArrayList(), reply) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ArrayList f14360a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BasicMessageChannel.Reply f14361b;

            {
                this.f14360a = r1;
                this.f14361b = r2;
            }

            public void error(Throwable th2) {
                this.f14361b.reply(Messages.a(th2));
            }

            public void success(Boolean bool) {
                this.f14360a.add(0, bool);
                this.f14361b.reply(this.f14360a);
            }
        });
    }
}
