package androidx.transition;

import android.os.IBinder;

class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).mToken.equals(this.mToken);
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }
}
