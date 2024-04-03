package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalizationChannel {
    private static final String TAG = "LocalizationChannel";
    @NonNull
    public final MethodChannel channel;
    @VisibleForTesting
    @NonNull
    public final MethodChannel.MethodCallHandler handler;
    /* access modifiers changed from: private */
    @Nullable
    public LocalizationMessageHandler localizationMessageHandler;

    public interface LocalizationMessageHandler {
        @NonNull
        String getStringResource(@NonNull String str, @NonNull String str2);
    }

    public LocalizationChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                String str;
                if (LocalizationChannel.this.localizationMessageHandler != null) {
                    String str2 = methodCall.method;
                    str2.hashCode();
                    if (!str2.equals("Localization.getStringResource")) {
                        result.notImplemented();
                        return;
                    }
                    JSONObject jSONObject = (JSONObject) methodCall.arguments();
                    try {
                        String string = jSONObject.getString("key");
                        if (jSONObject.has("locale")) {
                            str = jSONObject.getString("locale");
                        } else {
                            str = null;
                        }
                        result.success(LocalizationChannel.this.localizationMessageHandler.getStringResource(string, str));
                    } catch (JSONException e11) {
                        result.error("error", e11.getMessage(), (Object) null);
                    }
                }
            }
        };
        this.handler = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/localization", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    public void sendLocales(@NonNull List<Locale> list) {
        Log.v(TAG, "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale next : list) {
            Log.v(TAG, "Locale (Language: " + next.getLanguage() + ", Country: " + next.getCountry() + ", Variant: " + next.getVariant() + ")");
            arrayList.add(next.getLanguage());
            arrayList.add(next.getCountry());
            arrayList.add(next.getScript());
            arrayList.add(next.getVariant());
        }
        this.channel.invokeMethod("setLocale", arrayList);
    }

    public void setLocalizationMessageHandler(@Nullable LocalizationMessageHandler localizationMessageHandler2) {
        this.localizationMessageHandler = localizationMessageHandler2;
    }
}
