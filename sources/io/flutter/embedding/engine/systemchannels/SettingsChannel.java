package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;

public class SettingsChannel {
    private static final String ALWAYS_USE_24_HOUR_FORMAT = "alwaysUse24HourFormat";
    private static final String BRIEFLY_SHOW_PASSWORD = "brieflyShowPassword";
    public static final String CHANNEL_NAME = "flutter/settings";
    private static final String NATIVE_SPELL_CHECK_SERVICE_DEFINED = "nativeSpellCheckServiceDefined";
    private static final String PLATFORM_BRIGHTNESS = "platformBrightness";
    private static final String TAG = "SettingsChannel";
    private static final String TEXT_SCALE_FACTOR = "textScaleFactor";
    @NonNull
    public final BasicMessageChannel<Object> channel;

    public static class MessageBuilder {
        @NonNull
        private final BasicMessageChannel<Object> channel;
        @NonNull
        private Map<String, Object> message = new HashMap();

        public MessageBuilder(@NonNull BasicMessageChannel<Object> basicMessageChannel) {
            this.channel = basicMessageChannel;
        }

        public void send() {
            Log.v(SettingsChannel.TAG, "Sending message: \ntextScaleFactor: " + this.message.get(SettingsChannel.TEXT_SCALE_FACTOR) + "\nalwaysUse24HourFormat: " + this.message.get(SettingsChannel.ALWAYS_USE_24_HOUR_FORMAT) + "\nplatformBrightness: " + this.message.get(SettingsChannel.PLATFORM_BRIGHTNESS));
            this.channel.send(this.message);
        }

        @NonNull
        public MessageBuilder setBrieflyShowPassword(@NonNull boolean z11) {
            this.message.put(SettingsChannel.BRIEFLY_SHOW_PASSWORD, Boolean.valueOf(z11));
            return this;
        }

        @NonNull
        public MessageBuilder setNativeSpellCheckServiceDefined(boolean z11) {
            this.message.put(SettingsChannel.NATIVE_SPELL_CHECK_SERVICE_DEFINED, Boolean.valueOf(z11));
            return this;
        }

        @NonNull
        public MessageBuilder setPlatformBrightness(@NonNull PlatformBrightness platformBrightness) {
            this.message.put(SettingsChannel.PLATFORM_BRIGHTNESS, platformBrightness.f14223name);
            return this;
        }

        @NonNull
        public MessageBuilder setTextScaleFactor(float f11) {
            this.message.put(SettingsChannel.TEXT_SCALE_FACTOR, Float.valueOf(f11));
            return this;
        }

        @NonNull
        public MessageBuilder setUse24HourFormat(boolean z11) {
            this.message.put(SettingsChannel.ALWAYS_USE_24_HOUR_FORMAT, Boolean.valueOf(z11));
            return this;
        }
    }

    public enum PlatformBrightness {
        light("light"),
        dark("dark");
        
        @NonNull

        /* renamed from: name  reason: collision with root package name */
        public String f14223name;

        private PlatformBrightness(@NonNull String str) {
            this.f14223name = str;
        }
    }

    public SettingsChannel(@NonNull DartExecutor dartExecutor) {
        this.channel = new BasicMessageChannel<>(dartExecutor, CHANNEL_NAME, JSONMessageCodec.INSTANCE);
    }

    @NonNull
    public MessageBuilder startMessage() {
        return new MessageBuilder(this.channel);
    }
}
