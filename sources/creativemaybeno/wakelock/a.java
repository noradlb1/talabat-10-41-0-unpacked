package creativemaybeno.wakelock;

import creativemaybeno.wakelock.Messages;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.ArrayList;
import java.util.HashMap;
import nz.b;

public final /* synthetic */ class a {
    public static MessageCodec<Object> a() {
        return Messages.WakelockApiCodec.INSTANCE;
    }

    public static /* synthetic */ void b(Messages.WakelockApi wakelockApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Messages.ToggleMessage toggleMessage = (Messages.ToggleMessage) ((ArrayList) obj).get(0);
            if (toggleMessage != null) {
                wakelockApi.toggle(toggleMessage);
                hashMap.put("result", (Object) null);
                reply.reply(hashMap);
                return;
            }
            throw new NullPointerException("msgArg unexpectedly null.");
        } catch (Error | RuntimeException e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
    }

    public static /* synthetic */ void c(Messages.WakelockApi wakelockApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", wakelockApi.isEnabled());
        } catch (Error | RuntimeException e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static void d(BinaryMessenger binaryMessenger, Messages.WakelockApi wakelockApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WakelockApi.toggle", a());
        if (wakelockApi != null) {
            basicMessageChannel.setMessageHandler(new nz.a(wakelockApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WakelockApi.isEnabled", a());
        if (wakelockApi != null) {
            basicMessageChannel2.setMessageHandler(new b(wakelockApi));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
