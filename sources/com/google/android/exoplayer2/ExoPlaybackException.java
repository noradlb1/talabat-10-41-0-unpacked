package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import g7.i;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class ExoPlaybackException extends PlaybackException {
    public static final Bundleable.Creator<ExoPlaybackException> CREATOR = new i();
    private static final String FIELD_IS_RECOVERABLE = Util.intToStringMaxRadix(1006);
    private static final String FIELD_RENDERER_FORMAT = Util.intToStringMaxRadix(1004);
    private static final String FIELD_RENDERER_FORMAT_SUPPORT = Util.intToStringMaxRadix(1005);
    private static final String FIELD_RENDERER_INDEX = Util.intToStringMaxRadix(1003);
    private static final String FIELD_RENDERER_NAME = Util.intToStringMaxRadix(1002);
    private static final String FIELD_TYPE = Util.intToStringMaxRadix(1001);
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    final boolean isRecoverable;
    @Nullable
    public final MediaPeriodId mediaPeriodId;
    @Nullable
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    @Nullable
    public final String rendererName;
    public final int type;

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private ExoPlaybackException(int i11, Throwable th2, int i12) {
        this(i11, th2, (String) null, i12, (String) null, -1, (Format) null, 4, false);
    }

    public static /* synthetic */ ExoPlaybackException a(Bundle bundle) {
        return new ExoPlaybackException(bundle);
    }

    public static ExoPlaybackException createForRemote(String str) {
        return new ExoPlaybackException(3, (Throwable) null, str, 1001, (String) null, -1, (Format) null, 4, false);
    }

    public static ExoPlaybackException createForRenderer(Throwable th2, String str, int i11, @Nullable Format format, int i12, boolean z11, int i13) {
        int i14;
        if (format == null) {
            i14 = 4;
        } else {
            i14 = i12;
        }
        return new ExoPlaybackException(1, th2, (String) null, i13, str, i11, format, i14, z11);
    }

    public static ExoPlaybackException createForSource(IOException iOException, int i11) {
        return new ExoPlaybackException(0, iOException, i11);
    }

    @Deprecated
    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return createForUnexpected(runtimeException, 1000);
    }

    private static String deriveMessage(int i11, @Nullable String str, @Nullable String str2, int i12, @Nullable Format format, int i13) {
        String str3;
        if (i11 == 0) {
            str3 = "Source error";
        } else if (i11 == 1) {
            str3 = str2 + " error, index=" + i12 + ", format=" + format + ", format_supported=" + Util.getFormatSupportString(i13);
        } else if (i11 != 3) {
            str3 = "Unexpected runtime error";
        } else {
            str3 = "Remote error";
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    @CheckResult
    public ExoPlaybackException copyWithMediaPeriodId(@Nullable MediaPeriodId mediaPeriodId2) {
        return new ExoPlaybackException((String) Util.castNonNull(getMessage()), getCause(), this.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, mediaPeriodId2, this.timestampMs, this.isRecoverable);
    }

    public boolean errorInfoEquals(@Nullable PlaybackException playbackException) {
        if (!super.errorInfoEquals(playbackException)) {
            return false;
        }
        ExoPlaybackException exoPlaybackException = (ExoPlaybackException) Util.castNonNull(playbackException);
        if (this.type == exoPlaybackException.type && Util.areEqual(this.rendererName, exoPlaybackException.rendererName) && this.rendererIndex == exoPlaybackException.rendererIndex && Util.areEqual(this.rendererFormat, exoPlaybackException.rendererFormat) && this.rendererFormatSupport == exoPlaybackException.rendererFormatSupport && Util.areEqual(this.mediaPeriodId, exoPlaybackException.mediaPeriodId) && this.isRecoverable == exoPlaybackException.isRecoverable) {
            return true;
        }
        return false;
    }

    public Exception getRendererException() {
        boolean z11 = true;
        if (this.type != 1) {
            z11 = false;
        }
        Assertions.checkState(z11);
        return (Exception) Assertions.checkNotNull(getCause());
    }

    public IOException getSourceException() {
        boolean z11;
        if (this.type == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        return (IOException) Assertions.checkNotNull(getCause());
    }

    public RuntimeException getUnexpectedException() {
        boolean z11;
        if (this.type == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        return (RuntimeException) Assertions.checkNotNull(getCause());
    }

    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putInt(FIELD_TYPE, this.type);
        bundle.putString(FIELD_RENDERER_NAME, this.rendererName);
        bundle.putInt(FIELD_RENDERER_INDEX, this.rendererIndex);
        Format format = this.rendererFormat;
        if (format != null) {
            bundle.putBundle(FIELD_RENDERER_FORMAT, format.toBundle());
        }
        bundle.putInt(FIELD_RENDERER_FORMAT_SUPPORT, this.rendererFormatSupport);
        bundle.putBoolean(FIELD_IS_RECOVERABLE, this.isRecoverable);
        return bundle;
    }

    private ExoPlaybackException(int i11, @Nullable Throwable th2, @Nullable String str, int i12, @Nullable String str2, int i13, @Nullable Format format, int i14, boolean z11) {
        this(deriveMessage(i11, str, str2, i13, format, i14), th2, i12, i11, str2, i13, format, i14, (MediaPeriodId) null, SystemClock.elapsedRealtime(), z11);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException, int i11) {
        return new ExoPlaybackException(2, runtimeException, i11);
    }

    private ExoPlaybackException(Bundle bundle) {
        super(bundle);
        Format format;
        this.type = bundle.getInt(FIELD_TYPE, 2);
        this.rendererName = bundle.getString(FIELD_RENDERER_NAME);
        this.rendererIndex = bundle.getInt(FIELD_RENDERER_INDEX, -1);
        Bundle bundle2 = bundle.getBundle(FIELD_RENDERER_FORMAT);
        if (bundle2 == null) {
            format = null;
        } else {
            format = Format.CREATOR.fromBundle(bundle2);
        }
        this.rendererFormat = format;
        this.rendererFormatSupport = bundle.getInt(FIELD_RENDERER_FORMAT_SUPPORT, 4);
        this.isRecoverable = bundle.getBoolean(FIELD_IS_RECOVERABLE, false);
        this.mediaPeriodId = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ExoPlaybackException(String str, @Nullable Throwable th2, int i11, int i12, @Nullable String str2, int i13, @Nullable Format format, int i14, @Nullable MediaPeriodId mediaPeriodId2, long j11, boolean z11) {
        super(str, th2, i11, j11);
        int i15 = i12;
        boolean z12 = z11;
        boolean z13 = false;
        Assertions.checkArgument(!z12 || i15 == 1);
        Assertions.checkArgument((th2 != null || i15 == 3) ? true : z13);
        this.type = i15;
        this.rendererName = str2;
        this.rendererIndex = i13;
        this.rendererFormat = format;
        this.rendererFormatSupport = i14;
        this.mediaPeriodId = mediaPeriodId2;
        this.isRecoverable = z12;
    }
}
