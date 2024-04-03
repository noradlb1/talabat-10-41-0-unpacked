package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class DrmUtil {
    public static final int ERROR_SOURCE_EXO_MEDIA_DRM = 1;
    public static final int ERROR_SOURCE_LICENSE_ACQUISITION = 2;
    public static final int ERROR_SOURCE_PROVISIONING = 3;

    @RequiresApi(18)
    public static final class Api18 {
        private Api18() {
        }

        @DoNotInline
        public static boolean isDeniedByServerException(@Nullable Throwable th2) {
            return th2 instanceof DeniedByServerException;
        }

        @DoNotInline
        public static boolean isNotProvisionedException(@Nullable Throwable th2) {
            return th2 instanceof NotProvisionedException;
        }
    }

    @RequiresApi(21)
    public static final class Api21 {
        private Api21() {
        }

        @DoNotInline
        public static boolean isMediaDrmStateException(@Nullable Throwable th2) {
            return th2 instanceof MediaDrm.MediaDrmStateException;
        }

        @DoNotInline
        public static int mediaDrmStateExceptionToErrorCode(Throwable th2) {
            return Util.getErrorCodeForMediaDrmErrorCode(Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo()));
        }
    }

    @RequiresApi(23)
    public static final class Api23 {
        private Api23() {
        }

        @DoNotInline
        public static boolean isMediaDrmResetException(@Nullable Throwable th2) {
            return th2 instanceof MediaDrmResetException;
        }
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorSource {
    }

    private DrmUtil() {
    }

    public static int getErrorCodeForMediaDrmException(Exception exc, int i11) {
        int i12 = Util.SDK_INT;
        if (i12 >= 21 && Api21.isMediaDrmStateException(exc)) {
            return Api21.mediaDrmStateExceptionToErrorCode(exc);
        }
        if (i12 >= 23 && Api23.isMediaDrmResetException(exc)) {
            return 6006;
        }
        if (i12 >= 18 && Api18.isNotProvisionedException(exc)) {
            return 6002;
        }
        if (i12 >= 18 && Api18.isDeniedByServerException(exc)) {
            return PlaybackException.ERROR_CODE_DRM_DEVICE_REVOKED;
        }
        if (exc instanceof UnsupportedDrmException) {
            return 6001;
        }
        if (exc instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
            return 6003;
        }
        if (exc instanceof KeysExpiredException) {
            return PlaybackException.ERROR_CODE_DRM_LICENSE_EXPIRED;
        }
        if (i11 == 1) {
            return 6006;
        }
        if (i11 == 2) {
            return 6004;
        }
        if (i11 == 3) {
            return 6002;
        }
        throw new IllegalArgumentException();
    }
}
