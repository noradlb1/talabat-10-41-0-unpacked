package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.zae;

@KeepForSdk
public class SignInClientImpl extends GmsClient<zaf> implements zae {
    public static final /* synthetic */ int zaa = 0;
    private final boolean zab = true;
    private final ClientSettings zac;
    private final Bundle zad;
    @Nullable
    private final Integer zae;

    public SignInClientImpl(@NonNull Context context, @NonNull Looper looper, boolean z11, @NonNull ClientSettings clientSettings, @NonNull Bundle bundle, @NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zac = clientSettings;
        this.zad = bundle;
        this.zae = clientSettings.zab();
    }

    @NonNull
    @KeepForSdk
    public static Bundle createBundleFromClientSettings(@NonNull ClientSettings clientSettings) {
        clientSettings.zaa();
        Integer zab2 = clientSettings.zab();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", clientSettings.getAccount());
        if (zab2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zab2.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String) null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @NonNull
    public final /* synthetic */ IInterface createServiceInterface(@NonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof zaf) {
            return (zaf) queryLocalInterface;
        }
        return new zaf(iBinder);
    }

    @NonNull
    public final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.zac.getRealClientPackageName())) {
            this.zad.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zac.getRealClientPackageName());
        }
        return this.zad;
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @NonNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @NonNull
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    public final boolean requiresSignIn() {
        return this.zab;
    }

    public final void zaa() {
        try {
            ((zaf) getService()).zae(((Integer) Preconditions.checkNotNull(this.zae)).intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public final void zab() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter());
    }

    public final void zac(@NonNull IAccountAccessor iAccountAccessor, boolean z11) {
        try {
            ((zaf) getService()).zaf(iAccountAccessor, ((Integer) Preconditions.checkNotNull(this.zae)).intValue(), z11);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public final void zad(zae zae2) {
        GoogleSignInAccount googleSignInAccount;
        Preconditions.checkNotNull(zae2, "Expecting a valid ISignInCallbacks");
        try {
            Account accountOrDefault = this.zac.getAccountOrDefault();
            if ("<<default account>>".equals(accountOrDefault.name)) {
                googleSignInAccount = Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount();
            } else {
                googleSignInAccount = null;
            }
            ((zaf) getService()).zag(new zai(1, new zat(accountOrDefault, ((Integer) Preconditions.checkNotNull(this.zae)).intValue(), googleSignInAccount)), zae2);
        } catch (RemoteException e11) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zae2.zab(new zak(1, new ConnectionResult(8, (PendingIntent) null), (zav) null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e11);
            }
        }
    }
}
