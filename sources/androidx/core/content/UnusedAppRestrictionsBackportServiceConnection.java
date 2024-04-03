package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {
    @VisibleForTesting
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public IUnusedAppRestrictionsBackportService f11236b = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public ResolvableFuture<Integer> f11237c;
    private final Context mContext;
    private boolean mHasBoundService = false;

    public UnusedAppRestrictionsBackportServiceConnection(@NonNull Context context) {
        this.mContext = context;
    }

    private IUnusedAppRestrictionsBackportCallback getBackportCallback() {
        return new IUnusedAppRestrictionsBackportCallback.Stub() {
            public void onIsPermissionRevocationEnabledForAppResult(boolean z11, boolean z12) throws RemoteException {
                if (!z11) {
                    UnusedAppRestrictionsBackportServiceConnection.this.f11237c.set(0);
                    Log.e(PackageManagerCompat.LOG_TAG, "Unable to retrieve the permission revocation setting from the backport");
                } else if (z12) {
                    UnusedAppRestrictionsBackportServiceConnection.this.f11237c.set(3);
                } else {
                    UnusedAppRestrictionsBackportServiceConnection.this.f11237c.set(2);
                }
            }
        };
    }

    public void connectAndFetchResult(@NonNull ResolvableFuture<Integer> resolvableFuture) {
        if (!this.mHasBoundService) {
            this.mHasBoundService = true;
            this.f11237c = resolvableFuture;
            this.mContext.bindService(new Intent(UnusedAppRestrictionsBackportService.ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION).setPackage(PackageManagerCompat.getPermissionRevocationVerifierApp(this.mContext.getPackageManager())), this, 1);
            return;
        }
        throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
    }

    public void disconnectFromService() {
        if (this.mHasBoundService) {
            this.mHasBoundService = false;
            this.mContext.unbindService(this);
            return;
        }
        throw new IllegalStateException("bindService must be called before unbind");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IUnusedAppRestrictionsBackportService asInterface = IUnusedAppRestrictionsBackportService.Stub.asInterface(iBinder);
        this.f11236b = asInterface;
        try {
            asInterface.isPermissionRevocationEnabledForApp(getBackportCallback());
        } catch (RemoteException unused) {
            this.f11237c.set(0);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f11236b = null;
    }
}
