package e00;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.ArrayList;

public final /* synthetic */ class p {
    @NonNull
    public static MessageCodec<Object> a() {
        return new StandardMessageCodec();
    }

    public static /* synthetic */ void b(GeneratedAndroidWebView.FlutterAssetManagerHostApi flutterAssetManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, flutterAssetManagerHostApi.list((String) ((ArrayList) obj).get(0)));
        } catch (Throwable th2) {
            arrayList = GeneratedAndroidWebView.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void c(GeneratedAndroidWebView.FlutterAssetManagerHostApi flutterAssetManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, flutterAssetManagerHostApi.getAssetFilePathByName((String) ((ArrayList) obj).get(0)));
        } catch (Throwable th2) {
            arrayList = GeneratedAndroidWebView.a(th2);
        }
        reply.reply(arrayList);
    }

    public static void d(@NonNull BinaryMessenger binaryMessenger, @Nullable GeneratedAndroidWebView.FlutterAssetManagerHostApi flutterAssetManagerHostApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManagerHostApi.list", a());
        if (flutterAssetManagerHostApi != null) {
            basicMessageChannel.setMessageHandler(new n(flutterAssetManagerHostApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManagerHostApi.getAssetFilePathByName", a());
        if (flutterAssetManagerHostApi != null) {
            basicMessageChannel2.setMessageHandler(new o(flutterAssetManagerHostApi));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
