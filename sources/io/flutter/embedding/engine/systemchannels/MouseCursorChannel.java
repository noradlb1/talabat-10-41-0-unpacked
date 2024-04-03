package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;

public class MouseCursorChannel {
    private static final String TAG = "MouseCursorChannel";
    @NonNull
    public final MethodChannel channel;
    /* access modifiers changed from: private */
    @Nullable
    public MouseCursorMethodHandler mouseCursorMethodHandler;
    @NonNull
    private final MethodChannel.MethodCallHandler parsingMethodCallHandler;

    public interface MouseCursorMethodHandler {
        void activateSystemCursor(@NonNull String str);
    }

    public MouseCursorChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            /* JADX WARNING: Removed duplicated region for block: B:13:0x0040 A[Catch:{ Exception -> 0x0076 }] */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0041 A[Catch:{ Exception -> 0x0076 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r6, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r7) {
                /*
                    r5 = this;
                    java.lang.String r0 = "error"
                    io.flutter.embedding.engine.systemchannels.MouseCursorChannel r1 = io.flutter.embedding.engine.systemchannels.MouseCursorChannel.this
                    io.flutter.embedding.engine.systemchannels.MouseCursorChannel$MouseCursorMethodHandler r1 = r1.mouseCursorMethodHandler
                    if (r1 != 0) goto L_0x000b
                    return
                L_0x000b:
                    java.lang.String r1 = r6.method
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Received '"
                    r2.append(r3)
                    r2.append(r1)
                    java.lang.String r3 = "' message."
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    java.lang.String r3 = "MouseCursorChannel"
                    io.flutter.Log.v(r3, r2)
                    r2 = 0
                    int r3 = r1.hashCode()     // Catch:{ Exception -> 0x0076 }
                    r4 = -1307105544(0xffffffffb21726f8, float:-8.798217E-9)
                    if (r3 == r4) goto L_0x0033
                    goto L_0x003d
                L_0x0033:
                    java.lang.String r3 = "activateSystemCursor"
                    boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0076 }
                    if (r1 == 0) goto L_0x003d
                    r1 = 0
                    goto L_0x003e
                L_0x003d:
                    r1 = -1
                L_0x003e:
                    if (r1 == 0) goto L_0x0041
                    goto L_0x008f
                L_0x0041:
                    java.lang.Object r6 = r6.arguments     // Catch:{ Exception -> 0x0076 }
                    java.util.HashMap r6 = (java.util.HashMap) r6     // Catch:{ Exception -> 0x0076 }
                    java.lang.String r1 = "kind"
                    java.lang.Object r6 = r6.get(r1)     // Catch:{ Exception -> 0x0076 }
                    java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0076 }
                    io.flutter.embedding.engine.systemchannels.MouseCursorChannel r1 = io.flutter.embedding.engine.systemchannels.MouseCursorChannel.this     // Catch:{ Exception -> 0x005c }
                    io.flutter.embedding.engine.systemchannels.MouseCursorChannel$MouseCursorMethodHandler r1 = r1.mouseCursorMethodHandler     // Catch:{ Exception -> 0x005c }
                    r1.activateSystemCursor(r6)     // Catch:{ Exception -> 0x005c }
                    java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0076 }
                    r7.success(r6)     // Catch:{ Exception -> 0x0076 }
                    goto L_0x008f
                L_0x005c:
                    r6 = move-exception
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0076 }
                    r1.<init>()     // Catch:{ Exception -> 0x0076 }
                    java.lang.String r3 = "Error when setting cursors: "
                    r1.append(r3)     // Catch:{ Exception -> 0x0076 }
                    java.lang.String r6 = r6.getMessage()     // Catch:{ Exception -> 0x0076 }
                    r1.append(r6)     // Catch:{ Exception -> 0x0076 }
                    java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x0076 }
                    r7.error(r0, r6, r2)     // Catch:{ Exception -> 0x0076 }
                    goto L_0x008f
                L_0x0076:
                    r6 = move-exception
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r3 = "Unhandled error: "
                    r1.append(r3)
                    java.lang.String r6 = r6.getMessage()
                    r1.append(r6)
                    java.lang.String r6 = r1.toString()
                    r7.error(r0, r6, r2)
                L_0x008f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.MouseCursorChannel.AnonymousClass1.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
            }
        };
        this.parsingMethodCallHandler = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/mousecursor", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    public void setMethodHandler(@Nullable MouseCursorMethodHandler mouseCursorMethodHandler2) {
        this.mouseCursorMethodHandler = mouseCursorMethodHandler2;
    }

    @VisibleForTesting
    public void synthesizeMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        this.parsingMethodCallHandler.onMethodCall(methodCall, result);
    }
}
