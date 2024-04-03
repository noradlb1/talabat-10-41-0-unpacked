package e00;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.ArrayList;

public final /* synthetic */ class l {
    @NonNull
    public static MessageCodec<Object> a() {
        return new StandardMessageCodec();
    }

    public static /* synthetic */ void b(GeneratedAndroidWebView.DownloadListenerHostApi downloadListenerHostApi, Object obj, BasicMessageChannel.Reply reply) {
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
        downloadListenerHostApi.create(l11);
        arrayList.add(0, (Object) null);
        reply.reply(arrayList);
    }

    public static void c(@NonNull BinaryMessenger binaryMessenger, @Nullable GeneratedAndroidWebView.DownloadListenerHostApi downloadListenerHostApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.DownloadListenerHostApi.create", a());
        if (downloadListenerHostApi != null) {
            basicMessageChannel.setMessageHandler(new k(downloadListenerHostApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
