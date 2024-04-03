package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;

public class CustomTabsSessionToken {
    private static final String TAG = "CustomTabsSessionToken";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final ICustomTabsCallback f1004a;
    @Nullable
    private final CustomTabsCallback mCallback;
    @Nullable
    private final PendingIntent mSessionId;

    public static class MockCallback extends ICustomTabsCallback.Stub {
        public IBinder asBinder() {
            return this;
        }

        public void extraCallback(String str, Bundle bundle) {
        }

        public Bundle extraCallbackWithResult(String str, Bundle bundle) {
            return null;
        }

        public void onActivityResized(int i11, int i12, Bundle bundle) {
        }

        public void onMessageChannelReady(Bundle bundle) {
        }

        public void onNavigationEvent(int i11, Bundle bundle) {
        }

        public void onPostMessage(String str, Bundle bundle) {
        }

        public void onRelationshipValidationResult(int i11, Uri uri, boolean z11, Bundle bundle) {
        }
    }

    public CustomTabsSessionToken(@Nullable ICustomTabsCallback iCustomTabsCallback, @Nullable PendingIntent pendingIntent) {
        AnonymousClass1 r12;
        if (iCustomTabsCallback == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f1004a = iCustomTabsCallback;
        this.mSessionId = pendingIntent;
        if (iCustomTabsCallback == null) {
            r12 = null;
        } else {
            r12 = new CustomTabsCallback() {
                public void extraCallback(@NonNull String str, @Nullable Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.f1004a.extraCallback(str, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                @NonNull
                public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) {
                    try {
                        return CustomTabsSessionToken.this.f1004a.extraCallbackWithResult(str, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                        return null;
                    }
                }

                public void onActivityResized(int i11, int i12, @NonNull Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.f1004a.onActivityResized(i11, i12, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onMessageChannelReady(@Nullable Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.f1004a.onMessageChannelReady(bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onNavigationEvent(int i11, @Nullable Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.f1004a.onNavigationEvent(i11, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.f1004a.onPostMessage(str, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onRelationshipValidationResult(int i11, @NonNull Uri uri, boolean z11, @Nullable Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.f1004a.onRelationshipValidationResult(i11, uri, z11, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }
            };
        }
        this.mCallback = r12;
    }

    @NonNull
    public static CustomTabsSessionToken createMockSessionTokenForTesting() {
        return new CustomTabsSessionToken(new MockCallback(), (PendingIntent) null);
    }

    private IBinder getCallbackBinderAssertNotNull() {
        ICustomTabsCallback iCustomTabsCallback = this.f1004a;
        if (iCustomTabsCallback != null) {
            return iCustomTabsCallback.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    @Nullable
    public static CustomTabsSessionToken getSessionTokenFromIntent(@NonNull Intent intent) {
        Bundle extras = intent.getExtras();
        ICustomTabsCallback iCustomTabsCallback = null;
        if (extras == null) {
            return null;
        }
        IBinder binder = BundleCompat.getBinder(extras, CustomTabsIntent.EXTRA_SESSION);
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(CustomTabsIntent.EXTRA_SESSION_ID);
        if (binder == null && pendingIntent == null) {
            return null;
        }
        if (binder != null) {
            iCustomTabsCallback = ICustomTabsCallback.Stub.asInterface(binder);
        }
        return new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent);
    }

    @Nullable
    public IBinder a() {
        ICustomTabsCallback iCustomTabsCallback = this.f1004a;
        if (iCustomTabsCallback == null) {
            return null;
        }
        return iCustomTabsCallback.asBinder();
    }

    @Nullable
    public PendingIntent b() {
        return this.mSessionId;
    }

    public boolean equals(Object obj) {
        boolean z11;
        if (!(obj instanceof CustomTabsSessionToken)) {
            return false;
        }
        CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) obj;
        PendingIntent b11 = customTabsSessionToken.b();
        PendingIntent pendingIntent = this.mSessionId;
        boolean z12 = true;
        if (pendingIntent == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (b11 != null) {
            z12 = false;
        }
        if (z11 != z12) {
            return false;
        }
        if (pendingIntent != null) {
            return pendingIntent.equals(b11);
        }
        return getCallbackBinderAssertNotNull().equals(customTabsSessionToken.getCallbackBinderAssertNotNull());
    }

    @Nullable
    public CustomTabsCallback getCallback() {
        return this.mCallback;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasCallback() {
        return this.f1004a != null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasId() {
        return this.mSessionId != null;
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.mSessionId;
        if (pendingIntent != null) {
            return pendingIntent.hashCode();
        }
        return getCallbackBinderAssertNotNull().hashCode();
    }

    public boolean isAssociatedWith(@NonNull CustomTabsSession customTabsSession) {
        return customTabsSession.a().equals(this.f1004a);
    }
}
