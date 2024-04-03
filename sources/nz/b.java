package nz;

import creativemaybeno.wakelock.Messages;
import creativemaybeno.wakelock.a;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class b implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.WakelockApi f24023a;

    public /* synthetic */ b(Messages.WakelockApi wakelockApi) {
        this.f24023a = wakelockApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        a.c(this.f24023a, obj, reply);
    }
}
