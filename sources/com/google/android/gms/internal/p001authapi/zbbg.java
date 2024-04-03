package com.google.android.gms.internal.p001authapi;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.identity.zbu;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbbg  reason: invalid package */
public final class zbbg extends GoogleApi implements SignInClient {
    private static final Api.ClientKey zba;
    private static final Api.AbstractClientBuilder zbb;
    private static final Api zbc;
    private final String zbd = zbbj.zba();

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        zbbb zbbb = new zbbb();
        zbb = zbbb;
        zbc = new Api("Auth.Api.Identity.SignIn.API", zbbb, clientKey);
    }

    public zbbg(@NonNull Activity activity, @NonNull zbu zbu) {
        super(activity, zbc, zbu, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task<BeginSignInResult> beginSignIn(@NonNull BeginSignInRequest beginSignInRequest) {
        Preconditions.checkNotNull(beginSignInRequest);
        BeginSignInRequest.Builder zba2 = BeginSignInRequest.zba(beginSignInRequest);
        zba2.zba(this.zbd);
        BeginSignInRequest build = zba2.build();
        return doRead(TaskApiCall.builder().setFeatures(zbbi.zba).run(new zbax(this, build)).setAutoResolveMissingFeatures(false).setMethodKey(1553).build());
    }

    public final String getPhoneNumberFromIntent(@Nullable Intent intent) throws ApiException {
        if (intent != null) {
            Status status = (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "status", Status.CREATOR);
            if (status == null) {
                throw new ApiException(Status.RESULT_CANCELED);
            } else if (status.isSuccess()) {
                String stringExtra = intent.getStringExtra("phone_number_hint_result");
                if (stringExtra != null) {
                    return stringExtra;
                }
                throw new ApiException(Status.RESULT_INTERNAL_ERROR);
            } else {
                throw new ApiException(status);
            }
        } else {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
    }

    public final Task<PendingIntent> getPhoneNumberHintIntent(@NonNull GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest) {
        Preconditions.checkNotNull(getPhoneNumberHintIntentRequest);
        return doRead(TaskApiCall.builder().setFeatures(zbbi.zbh).run(new zbba(this, getPhoneNumberHintIntentRequest)).setMethodKey(1653).build());
    }

    public final SignInCredential getSignInCredentialFromIntent(@Nullable Intent intent) throws ApiException {
        if (intent != null) {
            Status status = (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "status", Status.CREATOR);
            if (status == null) {
                throw new ApiException(Status.RESULT_CANCELED);
            } else if (status.isSuccess()) {
                SignInCredential signInCredential = (SignInCredential) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "sign_in_credential", SignInCredential.CREATOR);
                if (signInCredential != null) {
                    return signInCredential;
                }
                throw new ApiException(Status.RESULT_INTERNAL_ERROR);
            } else {
                throw new ApiException(status);
            }
        } else {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
    }

    public final Task<PendingIntent> getSignInIntent(@NonNull GetSignInIntentRequest getSignInIntentRequest) {
        Preconditions.checkNotNull(getSignInIntentRequest);
        GetSignInIntentRequest.Builder zba2 = GetSignInIntentRequest.zba(getSignInIntentRequest);
        zba2.zba(this.zbd);
        GetSignInIntentRequest build = zba2.build();
        return doRead(TaskApiCall.builder().setFeatures(zbbi.zbf).run(new zbay(this, build)).setMethodKey(1555).build());
    }

    public final Task<Void> signOut() {
        getApplicationContext().getSharedPreferences("com.google.android.gms.signin", 0).edit().clear().apply();
        for (GoogleApiClient maybeSignOut : GoogleApiClient.getAllClients()) {
            maybeSignOut.maybeSignOut();
        }
        GoogleApiManager.reportSignOut();
        return doWrite(TaskApiCall.builder().setFeatures(zbbi.zbb).run(new zbaz(this)).setAutoResolveMissingFeatures(false).setMethodKey(1554).build());
    }

    public final /* synthetic */ void zba(GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest, zbbh zbbh, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zbam) zbbh.getService()).zbd(new zbbf(this, taskCompletionSource), getPhoneNumberHintIntentRequest, this.zbd);
    }

    public final /* synthetic */ void zbb(zbbh zbbh, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zbam) zbbh.getService()).zbf(new zbbd(this, taskCompletionSource), this.zbd);
    }

    public zbbg(@NonNull Context context, @NonNull zbu zbu) {
        super(context, zbc, zbu, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
