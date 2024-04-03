package e00;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.ArrayList;

public final /* synthetic */ class x {
    @NonNull
    public static MessageCodec<Object> a() {
        return new StandardMessageCodec();
    }

    public static /* synthetic */ void b(GeneratedAndroidWebView.JavaObjectHostApi javaObjectHostApi, Object obj, BasicMessageChannel.Reply reply) {
        Long l11;
        ArrayList<Object> arrayList = new ArrayList<>();
        Number number = (Number) ((ArrayList) obj).get(0);
        if (number == null) {
            l11 = null;
        } else {
            try {
                l11 = Long.valueOf(number.longValue());
            } catch (Throwable th2) {
                arrayList = GeneratedAndroidWebView.a(th2);
            }
        }
        javaObjectHostApi.dispose(l11);
        arrayList.add(0, (Object) null);
        reply.reply(arrayList);
    }

    public static void c(@NonNull BinaryMessenger binaryMessenger, @Nullable GeneratedAndroidWebView.JavaObjectHostApi javaObjectHostApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.JavaObjectHostApi.dispose", a());
        if (javaObjectHostApi != null) {
            basicMessageChannel.setMessageHandler(new w(javaObjectHostApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
