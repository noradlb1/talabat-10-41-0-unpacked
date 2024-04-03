package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

public final class MediaSessionManager {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f36281b = Log.isLoggable("MediaSessionManager", 3);
    private static final Object sLock = new Object();
    private static volatile MediaSessionManager sSessionManager;

    /* renamed from: a  reason: collision with root package name */
    public MediaSessionManagerImpl f36282a;

    public interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl);
    }

    public interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    private MediaSessionManager(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f36282a = new MediaSessionManagerImplApi28(context);
        } else {
            this.f36282a = new MediaSessionManagerImplApi21(context);
        }
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context context) {
        MediaSessionManager mediaSessionManager = sSessionManager;
        if (mediaSessionManager == null) {
            synchronized (sLock) {
                mediaSessionManager = sSessionManager;
                if (mediaSessionManager == null) {
                    sSessionManager = new MediaSessionManager(context.getApplicationContext());
                    mediaSessionManager = sSessionManager;
                }
            }
        }
        return mediaSessionManager;
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.f36282a.isTrustedForMediaControl(remoteUserInfo.f36283a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";

        /* renamed from: a  reason: collision with root package name */
        public RemoteUserInfoImpl f36283a;

        public RemoteUserInfo(@NonNull String str, int i11, int i12) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f36283a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i11, i12);
            } else {
                this.f36283a = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(str, i11, i12);
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfo)) {
                return false;
            }
            return this.f36283a.equals(((RemoteUserInfo) obj).f36283a);
        }

        @NonNull
        public String getPackageName() {
            return this.f36283a.getPackageName();
        }

        public int getPid() {
            return this.f36283a.getPid();
        }

        public int getUid() {
            return this.f36283a.getUid();
        }

        public int hashCode() {
            return this.f36283a.hashCode();
        }

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f36283a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
        }
    }
}
