package com.google.android.exoplayer2.audio;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;

public interface AudioSink {
    public static final long CURRENT_POSITION_NOT_SET = Long.MIN_VALUE;
    public static final int SINK_FORMAT_SUPPORTED_DIRECTLY = 2;
    public static final int SINK_FORMAT_SUPPORTED_WITH_TRANSCODING = 1;
    public static final int SINK_FORMAT_UNSUPPORTED = 0;

    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final Format format;
        public final boolean isRecoverable;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InitializationException(int r4, int r5, int r6, int r7, com.google.android.exoplayer2.Format r8, boolean r9, @androidx.annotation.Nullable java.lang.Exception r10) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "AudioTrack init failed "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = " "
                r0.append(r1)
                java.lang.String r2 = "Config("
                r0.append(r2)
                r0.append(r5)
                java.lang.String r5 = ", "
                r0.append(r5)
                r0.append(r6)
                r0.append(r5)
                r0.append(r7)
                java.lang.String r5 = ")"
                r0.append(r5)
                r0.append(r1)
                r0.append(r8)
                if (r9 == 0) goto L_0x0038
                java.lang.String r5 = " (recoverable)"
                goto L_0x003a
            L_0x0038:
                java.lang.String r5 = ""
            L_0x003a:
                r0.append(r5)
                java.lang.String r5 = r0.toString()
                r3.<init>(r5, r10)
                r3.audioTrackState = r4
                r3.isRecoverable = r9
                r3.format = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioSink.InitializationException.<init>(int, int, int, int, com.google.android.exoplayer2.Format, boolean, java.lang.Exception):void");
        }
    }

    public interface Listener {
        void onAudioSinkError(Exception exc);

        void onOffloadBufferEmptying();

        void onOffloadBufferFull();

        void onPositionAdvancing(long j11);

        void onPositionDiscontinuity();

        void onSkipSilenceEnabledChanged(boolean z11);

        void onUnderrun(int i11, long j11, long j12);
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SinkFormatSupport {
    }

    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        public UnexpectedDiscontinuityException(long j11, long j12) {
            super("Unexpected audio track timestamp discontinuity: expected " + j12 + ", got " + j11);
            this.actualPresentationTimeUs = j11;
            this.expectedPresentationTimeUs = j12;
        }
    }

    public static final class WriteException extends Exception {
        public final int errorCode;
        public final Format format;
        public final boolean isRecoverable;

        public WriteException(int i11, Format format2, boolean z11) {
            super("AudioTrack write failed: " + i11);
            this.isRecoverable = z11;
            this.errorCode = i11;
            this.format = format2;
        }
    }

    void configure(Format format, int i11, @Nullable int[] iArr) throws ConfigurationException;

    void disableTunneling();

    void enableTunnelingV21();

    void experimentalFlushWithoutAudioTrackRelease();

    void flush();

    @Nullable
    AudioAttributes getAudioAttributes();

    long getCurrentPositionUs(boolean z11);

    int getFormatSupport(Format format);

    PlaybackParameters getPlaybackParameters();

    boolean getSkipSilenceEnabled();

    boolean handleBuffer(ByteBuffer byteBuffer, long j11, int i11) throws InitializationException, WriteException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void reset();

    void setAudioAttributes(AudioAttributes audioAttributes);

    void setAudioSessionId(int i11);

    void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

    void setListener(Listener listener);

    void setOutputStreamOffsetUs(long j11);

    void setPlaybackParameters(PlaybackParameters playbackParameters);

    void setPlayerId(@Nullable PlayerId playerId);

    @RequiresApi(23)
    void setPreferredDevice(@Nullable AudioDeviceInfo audioDeviceInfo);

    void setSkipSilenceEnabled(boolean z11);

    void setVolume(float f11);

    boolean supportsFormat(Format format);

    public static final class ConfigurationException extends Exception {
        public final Format format;

        public ConfigurationException(Throwable th2, Format format2) {
            super(th2);
            this.format = format2;
        }

        public ConfigurationException(String str, Format format2) {
            super(str);
            this.format = format2;
        }
    }
}
