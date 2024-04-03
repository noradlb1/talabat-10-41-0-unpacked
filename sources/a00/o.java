package a00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.googlesignin.Messages;
import java.util.ArrayList;

public final /* synthetic */ class o implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.GoogleSignInApi f11656a;

    public /* synthetic */ o(Messages.GoogleSignInApi googleSignInApi) {
        this.f11656a = googleSignInApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        this.f11656a.disconnect(new Messages.Result<Void>(new ArrayList(), reply) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ArrayList f14356a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BasicMessageChannel.Reply f14357b;

            {
                this.f14356a = r1;
                this.f14357b = r2;
            }

            public void error(Throwable th2) {
                this.f14357b.reply(Messages.a(th2));
            }

            public void success(Void voidR) {
                this.f14356a.add(0, (Object) null);
                this.f14357b.reply(this.f14356a);
            }
        });
    }
}
