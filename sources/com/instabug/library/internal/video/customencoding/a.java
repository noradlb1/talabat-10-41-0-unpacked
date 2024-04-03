package com.instabug.library.internal.video.customencoding;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@TargetApi(21)
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f51150a = "OMX.google.aac.encoder";

    public int a() {
        return 2;
    }

    public int b() {
        return 44100;
    }

    public MediaFormat c() {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(MimeTypes.AUDIO_AAC, 44100, 2);
        createAudioFormat.setInteger("aac-profile", 1);
        createAudioFormat.setInteger("bitrate", Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND);
        return createAudioFormat;
    }

    public String toString() {
        return "AudioEncodeConfig{codecName='" + this.f51150a + '\'' + ", mimeType='" + MimeTypes.AUDIO_AAC + '\'' + ", bitRate=" + Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND + ", sampleRate=" + 44100 + ", channelCount=" + 2 + ", profile=" + 1 + AbstractJsonLexerKt.END_OBJ;
    }
}
