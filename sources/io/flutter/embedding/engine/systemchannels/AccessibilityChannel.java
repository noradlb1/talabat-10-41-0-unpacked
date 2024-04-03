package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.AccessibilityBridge;
import java.util.HashMap;

public class AccessibilityChannel {
    private static final String TAG = "AccessibilityChannel";
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public final BasicMessageChannel.MessageHandler<Object> f14207a;
    @NonNull
    public final BasicMessageChannel<Object> channel;
    @NonNull
    public final FlutterJNI flutterJNI;
    /* access modifiers changed from: private */
    @Nullable
    public AccessibilityMessageHandler handler;

    public interface AccessibilityMessageHandler extends FlutterJNI.AccessibilityDelegate {
        void announce(@NonNull String str);

        void onLongPress(int i11);

        void onTap(int i11);

        void onTooltip(@NonNull String str);
    }

    public AccessibilityChannel(@NonNull DartExecutor dartExecutor, @NonNull FlutterJNI flutterJNI2) {
        AnonymousClass1 r02 = new BasicMessageChannel.MessageHandler<Object>() {
            public void onMessage(@Nullable Object obj, @NonNull BasicMessageChannel.Reply<Object> reply) {
                if (AccessibilityChannel.this.handler == null) {
                    reply.reply(null);
                    return;
                }
                HashMap hashMap = (HashMap) obj;
                String str = (String) hashMap.get("type");
                HashMap hashMap2 = (HashMap) hashMap.get("data");
                Log.v(AccessibilityChannel.TAG, "Received " + str + " message.");
                str.hashCode();
                char c11 = 65535;
                switch (str.hashCode()) {
                    case -1140076541:
                        if (str.equals("tooltip")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -649620375:
                        if (str.equals("announce")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 114595:
                        if (str.equals("tap")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 114203431:
                        if (str.equals("longPress")) {
                            c11 = 3;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        String str2 = (String) hashMap2.get("message");
                        if (str2 != null) {
                            AccessibilityChannel.this.handler.onTooltip(str2);
                            break;
                        }
                        break;
                    case 1:
                        String str3 = (String) hashMap2.get("message");
                        if (str3 != null) {
                            AccessibilityChannel.this.handler.announce(str3);
                            break;
                        }
                        break;
                    case 2:
                        Integer num = (Integer) hashMap.get("nodeId");
                        if (num != null) {
                            AccessibilityChannel.this.handler.onTap(num.intValue());
                            break;
                        }
                        break;
                    case 3:
                        Integer num2 = (Integer) hashMap.get("nodeId");
                        if (num2 != null) {
                            AccessibilityChannel.this.handler.onLongPress(num2.intValue());
                            break;
                        }
                        break;
                }
                reply.reply(null);
            }
        };
        this.f14207a = r02;
        BasicMessageChannel<Object> basicMessageChannel = new BasicMessageChannel<>(dartExecutor, "flutter/accessibility", StandardMessageCodec.INSTANCE);
        this.channel = basicMessageChannel;
        basicMessageChannel.setMessageHandler(r02);
        this.flutterJNI = flutterJNI2;
    }

    public void dispatchSemanticsAction(int i11, @NonNull AccessibilityBridge.Action action) {
        this.flutterJNI.dispatchSemanticsAction(i11, action);
    }

    public void onAndroidAccessibilityDisabled() {
        this.flutterJNI.setSemanticsEnabled(false);
    }

    public void onAndroidAccessibilityEnabled() {
        this.flutterJNI.setSemanticsEnabled(true);
    }

    public void setAccessibilityFeatures(int i11) {
        this.flutterJNI.setAccessibilityFeatures(i11);
    }

    public void setAccessibilityMessageHandler(@Nullable AccessibilityMessageHandler accessibilityMessageHandler) {
        this.handler = accessibilityMessageHandler;
        this.flutterJNI.setAccessibilityDelegate(accessibilityMessageHandler);
    }

    public void dispatchSemanticsAction(int i11, @NonNull AccessibilityBridge.Action action, @Nullable Object obj) {
        this.flutterJNI.dispatchSemanticsAction(i11, action, obj);
    }
}
