package a00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.googlesignin.Messages;
import java.util.ArrayList;

public final /* synthetic */ class l implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.GoogleSignInApi f11653a;

    public /* synthetic */ l(Messages.GoogleSignInApi googleSignInApi) {
        this.f11653a = googleSignInApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        this.f11653a.signIn(new Messages.Result<Messages.UserData>(new ArrayList(), reply) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ArrayList f14350a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BasicMessageChannel.Reply f14351b;

            {
                this.f14350a = r1;
                this.f14351b = r2;
            }

            public void error(Throwable th2) {
                this.f14351b.reply(Messages.a(th2));
            }

            public void success(UserData userData) {
                this.f14350a.add(0, userData);
                this.f14351b.reply(this.f14350a);
            }
        });
    }
}
