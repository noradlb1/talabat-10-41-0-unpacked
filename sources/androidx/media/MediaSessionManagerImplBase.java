package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import com.facebook.internal.security.CertificateUtil;

class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {
    private static final boolean DEBUG = MediaSessionManager.f36281b;
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final String PERMISSION_MEDIA_CONTENT_CONTROL = "android.permission.MEDIA_CONTENT_CONTROL";
    private static final String PERMISSION_STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
    private static final String TAG = "MediaSessionManager";

    /* renamed from: a  reason: collision with root package name */
    public Context f36286a;

    /* renamed from: b  reason: collision with root package name */
    public ContentResolver f36287b;

    public static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {
        private String mPackageName;
        private int mPid;
        private int mUid;

        public RemoteUserInfoImplBase(String str, int i11, int i12) {
            this.mPackageName = str;
            this.mPid = i11;
            this.mUid = i12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfoImplBase)) {
                return false;
            }
            RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
            if (TextUtils.equals(this.mPackageName, remoteUserInfoImplBase.mPackageName) && this.mPid == remoteUserInfoImplBase.mPid && this.mUid == remoteUserInfoImplBase.mUid) {
                return true;
            }
            return false;
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public int getPid() {
            return this.mPid;
        }

        public int getUid() {
            return this.mUid;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mPackageName, Integer.valueOf(this.mPid), Integer.valueOf(this.mUid));
        }
    }

    public MediaSessionManagerImplBase(Context context) {
        this.f36286a = context;
        this.f36287b = context.getContentResolver();
    }

    private boolean isPermissionGranted(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl, String str) {
        if (remoteUserInfoImpl.getPid() < 0) {
            if (this.f36286a.getPackageManager().checkPermission(str, remoteUserInfoImpl.getPackageName()) == 0) {
                return true;
            }
            return false;
        } else if (this.f36286a.checkPermission(str, remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean a(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        String string = Settings.Secure.getString(this.f36287b, ENABLED_NOTIFICATION_LISTENERS);
        if (string != null) {
            String[] split = string.split(CertificateUtil.DELIMITER);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null && unflattenFromString2.getPackageName().equals(remoteUserInfoImpl.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Context getContext() {
        return this.f36286a;
    }

    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        try {
            if (this.f36286a.getPackageManager().getApplicationInfo(remoteUserInfoImpl.getPackageName(), 0).uid != remoteUserInfoImpl.getUid()) {
                if (DEBUG) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Package name ");
                    sb2.append(remoteUserInfoImpl.getPackageName());
                    sb2.append(" doesn't match with the uid ");
                    sb2.append(remoteUserInfoImpl.getUid());
                }
                return false;
            } else if (isPermissionGranted(remoteUserInfoImpl, PERMISSION_STATUS_BAR_SERVICE) || isPermissionGranted(remoteUserInfoImpl, PERMISSION_MEDIA_CONTENT_CONTROL) || remoteUserInfoImpl.getUid() == 1000 || a(remoteUserInfoImpl)) {
                return true;
            } else {
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            if (DEBUG) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Package ");
                sb3.append(remoteUserInfoImpl.getPackageName());
                sb3.append(" doesn't exist");
            }
            return false;
        }
    }
}
