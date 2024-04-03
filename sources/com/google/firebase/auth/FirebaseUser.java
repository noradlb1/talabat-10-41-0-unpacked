package com.google.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    @NonNull
    public Task<Void> delete() {
        return FirebaseAuth.getInstance(zza()).zza(this);
    }

    @Nullable
    public abstract String getDisplayName();

    @Nullable
    public abstract String getEmail();

    @NonNull
    public Task<GetTokenResult> getIdToken(boolean z11) {
        return FirebaseAuth.getInstance(zza()).zzc(this, z11);
    }

    @Nullable
    public abstract FirebaseUserMetadata getMetadata();

    @NonNull
    public abstract MultiFactor getMultiFactor();

    @Nullable
    public abstract String getPhoneNumber();

    @Nullable
    public abstract Uri getPhotoUrl();

    @NonNull
    public abstract List<? extends UserInfo> getProviderData();

    @NonNull
    public abstract String getProviderId();

    @Nullable
    public abstract String getTenantId();

    @NonNull
    public abstract String getUid();

    public abstract boolean isAnonymous();

    @NonNull
    public Task<AuthResult> linkWithCredential(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zzf(this, authCredential);
    }

    @NonNull
    public Task<Void> reauthenticate(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zzg(this, authCredential);
    }

    @NonNull
    public Task<AuthResult> reauthenticateAndRetrieveData(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zzh(this, authCredential);
    }

    @NonNull
    public Task<Void> reload() {
        FirebaseAuth instance = FirebaseAuth.getInstance(zza());
        return instance.zzi(this, new zzad(instance));
    }

    @NonNull
    public Task<Void> sendEmailVerification() {
        return FirebaseAuth.getInstance(zza()).zzc(this, false).continueWithTask(new zzai(this));
    }

    @NonNull
    public Task<AuthResult> startActivityForLinkWithProvider(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zza()).zzl(activity, federatedAuthProvider, this);
    }

    @NonNull
    public Task<AuthResult> startActivityForReauthenticateWithProvider(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zza()).zzm(activity, federatedAuthProvider, this);
    }

    @NonNull
    public Task<AuthResult> unlink(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzp(this, str);
    }

    @NonNull
    public Task<Void> updateEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzq(this, str);
    }

    @NonNull
    public Task<Void> updatePassword(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzr(this, str);
    }

    @NonNull
    public Task<Void> updatePhoneNumber(@NonNull PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zza()).zzs(this, phoneAuthCredential);
    }

    @NonNull
    public Task<Void> updateProfile(@NonNull UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(userProfileChangeRequest);
        return FirebaseAuth.getInstance(zza()).zzt(this, userProfileChangeRequest);
    }

    @NonNull
    public Task<Void> verifyBeforeUpdateEmail(@NonNull String str) {
        return verifyBeforeUpdateEmail(str, (ActionCodeSettings) null);
    }

    @NonNull
    public abstract FirebaseApp zza();

    @NonNull
    public abstract FirebaseUser zzb();

    @NonNull
    public abstract FirebaseUser zzc(@NonNull List list);

    @NonNull
    public abstract zzadr zzd();

    @NonNull
    public abstract String zze();

    @NonNull
    public abstract String zzf();

    @Nullable
    public abstract List zzg();

    public abstract void zzh(@NonNull zzadr zzadr);

    public abstract void zzi(@NonNull List list);

    @NonNull
    public Task<Void> verifyBeforeUpdateEmail(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zza()).zzc(this, false).continueWithTask(new zzak(this, str, actionCodeSettings));
    }

    @NonNull
    public Task<Void> sendEmailVerification(@NonNull ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zza()).zzc(this, false).continueWithTask(new zzaj(this, actionCodeSettings));
    }
}
