package e00;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.ArrayList;

public final /* synthetic */ class a0 {
    @NonNull
    public static MessageCodec<Object> a() {
        return new StandardMessageCodec();
    }

    public static /* synthetic */ void b(GeneratedAndroidWebView.JavaScriptChannelHostApi javaScriptChannelHostApi, Object obj, BasicMessageChannel.Reply reply) {
        Long l11;
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        Number number = (Number) arrayList2.get(0);
        String str = (String) arrayList2.get(1);
        if (number == null) {
            l11 = null;
        } else {
            try {
                l11 = Long.valueOf(number.longValue());
            } catch (Throwable th2) {
                arrayList = GeneratedAndroidWebView.a(th2);
            }
        }
        javaScriptChannelHostApi.create(l11, str);
        arrayList.add(0, (Object) null);
        reply.reply(arrayList);
    }

    public static void c(@NonNull BinaryMessenger binaryMessenger, @Nullable GeneratedAndroidWebView.JavaScriptChannelHostApi javaScriptChannelHostApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannelHostApi.create", a());
        if (javaScriptChannelHostApi != null) {
            basicMessageChannel.setMessageHandler(new z(javaScriptChannelHostApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
