package com.talabat.token_secure_storage;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.authentication.token.data.local.impl.TokenLocalDataSourceImpl;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/token_secure_storage/TokenSecureStoragePlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "sharedPreferences", "Landroid/content/SharedPreferences;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "token_secure_storage_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TokenSecureStoragePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    @NotNull
    @Deprecated
    private static final String ACCESS_TOKEN = "accessToken";
    @NotNull
    @Deprecated
    private static final String CLEAR_DEVICE_TOKEN = "clearDeviceToken";
    @NotNull
    @Deprecated
    private static final String CLEAR_TOKEN = "clearToken";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String DEVICE_ID_KEY = "deviceIdkey";
    @NotNull
    @Deprecated
    private static final String DEVICE_TOKEN = "device_token";
    @NotNull
    @Deprecated
    private static final String EXPIRES_IN = "expiresIn";
    @NotNull
    @Deprecated
    private static final String FETCH_ACCESS_TOKEN = "fetchAccessToken";
    @NotNull
    @Deprecated
    private static final String FETCH_DEVICE_TOKEN = "fetchDeviceToken";
    @NotNull
    @Deprecated
    private static final String REFRESH_TOKEN = "refreshToken";
    @NotNull
    @Deprecated
    private static final String SAVE_ACCESS_TOKEN = "saveAccessToken";
    @NotNull
    @Deprecated
    private static final String SAVE_DEVICE_TOKEN = "saveDeviceToken";
    @NotNull
    @Deprecated
    private static final String SCOPE = "scope";
    @NotNull
    @Deprecated
    private static final String TIME_DIFFERENCE = "timeDifference";
    @NotNull
    @Deprecated
    private static final String TKN_KEY = "tknkey";
    @NotNull
    @Deprecated
    private static final String TOKEN_TYPE = "tokenType";
    private MethodChannel channel;
    private SharedPreferences sharedPreferences;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/token_secure_storage/TokenSecureStoragePlugin$Companion;", "", "()V", "ACCESS_TOKEN", "", "CLEAR_DEVICE_TOKEN", "CLEAR_TOKEN", "DEVICE_ID_KEY", "DEVICE_TOKEN", "EXPIRES_IN", "FETCH_ACCESS_TOKEN", "FETCH_DEVICE_TOKEN", "REFRESH_TOKEN", "SAVE_ACCESS_TOKEN", "SAVE_DEVICE_TOKEN", "SCOPE", "TIME_DIFFERENCE", "TKN_KEY", "TOKEN_TYPE", "token_secure_storage_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "token_secure_storage");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        SharedPreferences create = EncryptedSharedPreferences.create(TokenLocalDataSourceImpl.PREFERENCE, MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC), flutterPluginBinding.getApplicationContext(), EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            \"tkn…heme.AES256_GCM\n        )");
        this.sharedPreferences = create;
    }

    public void onDetachedFromEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        SharedPreferences sharedPreferences2;
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        Intrinsics.checkNotNullParameter(methodCall2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result2, "result");
        String str = methodCall2.method;
        if (str != null) {
            SharedPreferences sharedPreferences3 = null;
            switch (str.hashCode()) {
                case -743113812:
                    if (str.equals(CLEAR_TOKEN)) {
                        SharedPreferences sharedPreferences4 = this.sharedPreferences;
                        if (sharedPreferences4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                            sharedPreferences2 = null;
                        } else {
                            sharedPreferences2 = sharedPreferences4;
                        }
                        sharedPreferences2.edit().remove("tknkey").apply();
                        return;
                    }
                    break;
                case -219465850:
                    if (str.equals(SAVE_DEVICE_TOKEN)) {
                        try {
                            String str2 = (String) methodCall2.argument("device_token");
                            SharedPreferences sharedPreferences5 = this.sharedPreferences;
                            if (sharedPreferences5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                                sharedPreferences5 = null;
                            }
                            sharedPreferences5.edit().putString("deviceIdkey", str2).apply();
                            result2.success((Object) null);
                            return;
                        } catch (Exception e11) {
                            result2.error("(Save Error) -> (Device Token)", "Device token can't be saved properly to the EncryptedSharedPreferences", e11.toString());
                            return;
                        }
                    }
                    break;
                case 266025513:
                    if (str.equals(FETCH_DEVICE_TOKEN)) {
                        SharedPreferences sharedPreferences6 = this.sharedPreferences;
                        if (sharedPreferences6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                            sharedPreferences6 = null;
                        }
                        result2.success(sharedPreferences6.getString("deviceIdkey", (String) null));
                        return;
                    }
                    break;
                case 291035448:
                    if (str.equals(SAVE_ACCESS_TOKEN)) {
                        try {
                            String str3 = (String) methodCall2.argument(ACCESS_TOKEN);
                            String str4 = (String) methodCall2.argument(REFRESH_TOKEN);
                            Integer num = (Integer) methodCall2.argument(EXPIRES_IN);
                            String str5 = (String) methodCall2.argument("tokenType");
                            Integer num2 = (Integer) methodCall2.argument(TIME_DIFFERENCE);
                            String str6 = (String) methodCall2.argument("scope");
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(ACCESS_TOKEN, (Object) str3);
                                jSONObject.put(REFRESH_TOKEN, (Object) str4);
                                jSONObject.put(EXPIRES_IN, (Object) num);
                                jSONObject.put("tokenType", (Object) str5);
                                jSONObject.put(TIME_DIFFERENCE, (Object) num2);
                                jSONObject.put("scope", (Object) str6);
                                SharedPreferences sharedPreferences7 = this.sharedPreferences;
                                if (sharedPreferences7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                                    sharedPreferences7 = null;
                                }
                                sharedPreferences7.edit().putString("tknkey", JSONObjectInstrumentation.toString(jSONObject)).apply();
                                result2 = result;
                                result2.success((Object) null);
                                return;
                            } catch (Exception e12) {
                                e = e12;
                                result2 = result;
                                result2.error("(Save Error) -> (Access Token)", "Access token can't be saved properly to the EncryptedSharedPreferences", e.toString());
                                return;
                            }
                        } catch (Exception e13) {
                            e = e13;
                        }
                    }
                    break;
                case 336666806:
                    if (str.equals(CLEAR_DEVICE_TOKEN)) {
                        SharedPreferences sharedPreferences8 = this.sharedPreferences;
                        if (sharedPreferences8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                        } else {
                            sharedPreferences3 = sharedPreferences8;
                        }
                        sharedPreferences3.edit().remove("deviceIdkey").apply();
                        return;
                    }
                    break;
                case 776526811:
                    if (str.equals(FETCH_ACCESS_TOKEN)) {
                        try {
                            SharedPreferences sharedPreferences9 = this.sharedPreferences;
                            if (sharedPreferences9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                                sharedPreferences9 = null;
                            }
                            String string = sharedPreferences9.getString("tknkey", (String) null);
                            if (string != null) {
                                JSONObject jSONObject2 = new JSONObject(string);
                                result2.success(MapsKt__MapsKt.mapOf(TuplesKt.to(ACCESS_TOKEN, jSONObject2.getString(ACCESS_TOKEN)), TuplesKt.to(REFRESH_TOKEN, jSONObject2.getString(REFRESH_TOKEN)), TuplesKt.to(EXPIRES_IN, Long.valueOf(jSONObject2.getLong(EXPIRES_IN))), TuplesKt.to("tokenType", jSONObject2.getString("tokenType")), TuplesKt.to(TIME_DIFFERENCE, Integer.valueOf(jSONObject2.getInt(TIME_DIFFERENCE))), TuplesKt.to("scope", jSONObject2.getString("scope"))));
                                return;
                            }
                            result2.success((Object) null);
                            return;
                        } catch (Exception unused) {
                            result2.error("(Fetch Error) -> (Access Token)", "Access token can't be fetched properly from EncryptedSharedPreferences ", (Object) null);
                            return;
                        }
                    }
                    break;
            }
        }
        result.notImplemented();
    }
}
