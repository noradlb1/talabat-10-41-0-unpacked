package e00;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.ArrayList;

public final /* synthetic */ class k1 {
    @NonNull
    public static MessageCodec<Object> a() {
        return new StandardMessageCodec();
    }

    public static /* synthetic */ void b(GeneratedAndroidWebView.WebStorageHostApi webStorageHostApi, Object obj, BasicMessageChannel.Reply reply) {
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
        webStorageHostApi.create(l11);
        arrayList.add(0, (Object) null);
        reply.reply(arrayList);
    }

    public static /* synthetic */ void c(GeneratedAndroidWebView.WebStorageHostApi webStorageHostApi, Object obj, BasicMessageChannel.Reply reply) {
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
        webStorageHostApi.deleteAllData(l11);
        arrayList.add(0, (Object) null);
        reply.reply(arrayList);
    }

    public static void d(@NonNull BinaryMessenger binaryMessenger, @Nullable GeneratedAndroidWebView.WebStorageHostApi webStorageHostApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebStorageHostApi.create", a());
        if (webStorageHostApi != null) {
            basicMessageChannel.setMessageHandler(new i1(webStorageHostApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebStorageHostApi.deleteAllData", a());
        if (webStorageHostApi != null) {
            basicMessageChannel2.setMessageHandler(new j1(webStorageHostApi));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
