package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.net.Uri;
import android.provider.Settings;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Arrays;

public final class AudioCapabilities {
    /* access modifiers changed from: private */
    public static final ImmutableMap<Integer, Integer> ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS = new ImmutableMap.Builder().put(5, 6).put(17, 6).put(7, 6).put(18, 6).put(6, 8).put(8, 8).put(14, 8).buildOrThrow();
    public static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = new AudioCapabilities(new int[]{2}, 8);
    private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
    private static final int DEFAULT_SAMPLE_RATE_HZ = 48000;
    private static final AudioCapabilities EXTERNAL_SURROUND_SOUND_CAPABILITIES = new AudioCapabilities(new int[]{2, 5, 6}, 8);
    private static final String EXTERNAL_SURROUND_SOUND_KEY = "external_surround_sound_enabled";
    private final int maxChannelCount;
    private final int[] supportedEncodings;

    @RequiresApi(29)
    public static final class Api29 {
        private static final AudioAttributes DEFAULT_AUDIO_ATTRIBUTES = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        private Api29() {
        }

        @DoNotInline
        public static int[] getDirectPlaybackSupportedEncodings() {
            ImmutableList.Builder builder = ImmutableList.builder();
            UnmodifiableIterator it = AudioCapabilities.ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS.keySet().iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), DEFAULT_AUDIO_ATTRIBUTES)) {
                    builder.add((Object) Integer.valueOf(intValue));
                }
            }
            builder.add((Object) 2);
            return Ints.toArray(builder.build());
        }

        @DoNotInline
        public static int getMaxSupportedChannelCountForPassthrough(int i11, int i12) {
            for (int i13 = 8; i13 > 0; i13--) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i11).setSampleRate(i12).setChannelMask(Util.getAudioTrackChannelConfig(i13)).build(), DEFAULT_AUDIO_ATTRIBUTES)) {
                    return i13;
                }
            }
            return 0;
        }
    }

    public AudioCapabilities(@Nullable int[] iArr, int i11) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.supportedEncodings = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.supportedEncodings = new int[0];
        }
        this.maxChannelCount = i11;
    }

    private static boolean deviceMaySetExternalSurroundSoundGlobalSetting() {
        if (Util.SDK_INT >= 17) {
            String str = Util.MANUFACTURER;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static AudioCapabilities getCapabilities(Context context) {
        return getCapabilities(context, context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    private static int getChannelConfigForPassthrough(int i11) {
        int i12 = Util.SDK_INT;
        if (i12 <= 28) {
            if (i11 == 7) {
                i11 = 8;
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                i11 = 6;
            }
        }
        if (i12 <= 26 && "fugu".equals(Util.DEVICE) && i11 == 1) {
            i11 = 2;
        }
        return Util.getAudioTrackChannelConfig(i11);
    }

    @Nullable
    public static Uri getExternalSurroundSoundGlobalSettingUri() {
        if (deviceMaySetExternalSurroundSoundGlobalSetting()) {
            return Settings.Global.getUriFor(EXTERNAL_SURROUND_SOUND_KEY);
        }
        return null;
    }

    private static int getMaxSupportedChannelCountForPassthrough(int i11, int i12) {
        if (Util.SDK_INT >= 29) {
            return Api29.getMaxSupportedChannelCountForPassthrough(i11, i12);
        }
        return ((Integer) Assertions.checkNotNull(ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS.getOrDefault(Integer.valueOf(i11), 0))).intValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        if (!Arrays.equals(this.supportedEncodings, audioCapabilities.supportedEncodings) || this.maxChannelCount != audioCapabilities.maxChannelCount) {
            return false;
        }
        return true;
    }

    @Nullable
    public Pair<Integer, Integer> getEncodingAndChannelConfigForPassthrough(Format format) {
        int encoding = MimeTypes.getEncoding((String) Assertions.checkNotNull(format.sampleMimeType), format.codecs);
        if (!ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS.containsKey(Integer.valueOf(encoding))) {
            return null;
        }
        if (encoding == 18 && !supportsEncoding(18)) {
            encoding = 6;
        } else if (encoding == 8 && !supportsEncoding(8)) {
            encoding = 7;
        }
        if (!supportsEncoding(encoding)) {
            return null;
        }
        int i11 = format.channelCount;
        if (i11 == -1 || encoding == 18) {
            int i12 = format.sampleRate;
            if (i12 == -1) {
                i12 = 48000;
            }
            i11 = getMaxSupportedChannelCountForPassthrough(encoding, i12);
        } else if (i11 > this.maxChannelCount) {
            return null;
        }
        int channelConfigForPassthrough = getChannelConfigForPassthrough(i11);
        if (channelConfigForPassthrough == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(encoding), Integer.valueOf(channelConfigForPassthrough));
    }

    public int getMaxChannelCount() {
        return this.maxChannelCount;
    }

    public int hashCode() {
        return this.maxChannelCount + (Arrays.hashCode(this.supportedEncodings) * 31);
    }

    public boolean isPassthroughPlaybackSupported(Format format) {
        return getEncodingAndChannelConfigForPassthrough(format) != null;
    }

    public boolean supportsEncoding(int i11) {
        return Arrays.binarySearch(this.supportedEncodings, i11) >= 0;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", supportedEncodings=" + Arrays.toString(this.supportedEncodings) + "]";
    }

    @SuppressLint({"InlinedApi"})
    public static AudioCapabilities getCapabilities(Context context, @Nullable Intent intent) {
        if (deviceMaySetExternalSurroundSoundGlobalSetting() && Settings.Global.getInt(context.getContentResolver(), EXTERNAL_SURROUND_SOUND_KEY, 0) == 1) {
            return EXTERNAL_SURROUND_SOUND_CAPABILITIES;
        }
        if (Util.SDK_INT >= 29 && (Util.isTv(context) || Util.isAutomotive(context))) {
            return new AudioCapabilities(Api29.getDirectPlaybackSupportedEncodings(), 8);
        }
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return DEFAULT_AUDIO_CAPABILITIES;
        }
        return new AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }
}
