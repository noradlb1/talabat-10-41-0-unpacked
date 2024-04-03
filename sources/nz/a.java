package nz;

import creativemaybeno.wakelock.Messages;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.WakelockApi f24022a;

    public /* synthetic */ a(Messages.WakelockApi wakelockApi) {
        this.f24022a = wakelockApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        creativemaybeno.wakelock.a.b(this.f24022a, obj, reply);
    }
}
