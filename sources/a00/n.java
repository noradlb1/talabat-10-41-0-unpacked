package a00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.googlesignin.Messages;
import java.util.ArrayList;

public final /* synthetic */ class n implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.GoogleSignInApi f11655a;

    public /* synthetic */ n(Messages.GoogleSignInApi googleSignInApi) {
        this.f11655a = googleSignInApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        this.f11655a.signOut(new Messages.Result<Void>(new ArrayList(), reply) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ArrayList f14354a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BasicMessageChannel.Reply f14355b;

            {
                this.f14354a = r1;
                this.f14355b = r2;
            }

            public void error(Throwable th2) {
                this.f14355b.reply(Messages.a(th2));
            }

            public void success(Void voidR) {
                this.f14354a.add(0, (Object) null);
                this.f14355b.reply(this.f14354a);
            }
        });
    }
}
