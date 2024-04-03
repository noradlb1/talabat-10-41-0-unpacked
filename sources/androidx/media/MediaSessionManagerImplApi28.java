package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

@RequiresApi(28)
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {

    /* renamed from: c  reason: collision with root package name */
    public MediaSessionManager f36284c;

    public MediaSessionManagerImplApi28(Context context) {
        super(context);
        this.f36284c = (MediaSessionManager) context.getSystemService("media_session");
    }

    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        if (remoteUserInfoImpl instanceof RemoteUserInfoImplApi28) {
            return this.f36284c.isTrustedForMediaControl(((RemoteUserInfoImplApi28) remoteUserInfoImpl).f36285a);
        }
        return false;
    }

    public static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {

        /* renamed from: a  reason: collision with root package name */
        public final MediaSessionManager.RemoteUserInfo f36285a;

        public RemoteUserInfoImplApi28(String str, int i11, int i12) {
            this.f36285a = new MediaSessionManager.RemoteUserInfo(str, i11, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfoImplApi28)) {
                return false;
            }
            return this.f36285a.equals(((RemoteUserInfoImplApi28) obj).f36285a);
        }

        public String getPackageName() {
            return this.f36285a.getPackageName();
        }

        public int getPid() {
            return this.f36285a.getPid();
        }

        public int getUid() {
            return this.f36285a.getUid();
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f36285a);
        }

        public RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f36285a = remoteUserInfo;
        }
    }
}
