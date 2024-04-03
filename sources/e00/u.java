package e00;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.ArrayList;

public final /* synthetic */ class u {
    @NonNull
    public static MessageCodec<Object> a() {
        return new StandardMessageCodec();
    }

    public static /* synthetic */ void b(GeneratedAndroidWebView.InstanceManagerHostApi instanceManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            instanceManagerHostApi.clear();
            arrayList.add(0, (Object) null);
        } catch (Throwable th2) {
            arrayList = GeneratedAndroidWebView.a(th2);
        }
        reply.reply(arrayList);
    }

    public static void c(@NonNull BinaryMessenger binaryMessenger, @Nullable GeneratedAndroidWebView.InstanceManagerHostApi instanceManagerHostApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.InstanceManagerHostApi.clear", a());
        if (instanceManagerHostApi != null) {
            basicMessageChannel.setMessageHandler(new t(instanceManagerHostApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
