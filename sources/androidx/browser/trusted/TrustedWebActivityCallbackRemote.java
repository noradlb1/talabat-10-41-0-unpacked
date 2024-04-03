package androidx.browser.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TrustedWebActivityCallbackRemote {
    private final ITrustedWebActivityCallback mCallbackBinder;

    private TrustedWebActivityCallbackRemote(@NonNull ITrustedWebActivityCallback iTrustedWebActivityCallback) {
        this.mCallbackBinder = iTrustedWebActivityCallback;
    }

    @Nullable
    public static TrustedWebActivityCallbackRemote a(@Nullable IBinder iBinder) {
        ITrustedWebActivityCallback iTrustedWebActivityCallback;
        if (iBinder == null) {
            iTrustedWebActivityCallback = null;
        } else {
            iTrustedWebActivityCallback = ITrustedWebActivityCallback.Stub.asInterface(iBinder);
        }
        if (iTrustedWebActivityCallback == null) {
            return null;
        }
        return new TrustedWebActivityCallbackRemote(iTrustedWebActivityCallback);
    }

    public void runExtraCallback(@NonNull String str, @NonNull Bundle bundle) throws RemoteException {
        this.mCallbackBinder.onExtraCallback(str, bundle);
    }
}
