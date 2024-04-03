package e00;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.ArrayList;

public final /* synthetic */ class u1 {
    @NonNull
    public static MessageCodec<Object> a() {
        return new StandardMessageCodec();
    }

    public static /* synthetic */ void b(GeneratedAndroidWebView.WebViewClientHostApi webViewClientHostApi, Object obj, BasicMessageChannel.Reply reply) {
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
        webViewClientHostApi.create(l11);
        arrayList.add(0, (Object) null);
        reply.reply(arrayList);
    }

    public static /* synthetic */ void c(GeneratedAndroidWebView.WebViewClientHostApi webViewClientHostApi, Object obj, BasicMessageChannel.Reply reply) {
        Long l11;
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        Number number = (Number) arrayList2.get(0);
        Boolean bool = (Boolean) arrayList2.get(1);
        if (number == null) {
            l11 = null;
        } else {
            try {
                l11 = Long.valueOf(number.longValue());
            } catch (Throwable th2) {
                arrayList = GeneratedAndroidWebView.a(th2);
            }
        }
        webViewClientHostApi.setSynchronousReturnValueForShouldOverrideUrlLoading(l11, bool);
        arrayList.add(0, (Object) null);
        reply.reply(arrayList);
    }

    public static void d(@NonNull BinaryMessenger binaryMessenger, @Nullable GeneratedAndroidWebView.WebViewClientHostApi webViewClientHostApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientHostApi.create", a());
        if (webViewClientHostApi != null) {
            basicMessageChannel.setMessageHandler(new s1(webViewClientHostApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientHostApi.setSynchronousReturnValueForShouldOverrideUrlLoading", a());
        if (webViewClientHostApi != null) {
            basicMessageChannel2.setMessageHandler(new t1(webViewClientHostApi));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
