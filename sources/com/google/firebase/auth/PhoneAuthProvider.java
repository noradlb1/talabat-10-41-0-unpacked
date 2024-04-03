package com.google.firebase.auth;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthOptions;
import java.util.concurrent.TimeUnit;

public class PhoneAuthProvider {
    @NonNull
    public static final String PHONE_SIGN_IN_METHOD = "phone";
    @NonNull
    public static final String PROVIDER_ID = "phone";
    private final FirebaseAuth zza;

    @SafeParcelable.Class(creator = "DefaultForceResendingTokenCreator")
    public static class ForceResendingToken extends AbstractSafeParcelable {
        @NonNull
        public static final Parcelable.Creator<ForceResendingToken> CREATOR = new zzd();

        @NonNull
        public static ForceResendingToken zza() {
            return new ForceResendingToken();
        }

        public final void writeToParcel(@NonNull Parcel parcel, int i11) {
            SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
        }
    }

    public static abstract class OnVerificationStateChangedCallbacks {
        private static final Logger zza = new Logger("PhoneAuthProvider", new String[0]);

        public void onCodeAutoRetrievalTimeOut(@NonNull String str) {
            zza.i("Sms auto retrieval timed-out.", new Object[0]);
        }

        public void onCodeSent(@NonNull String str, @NonNull ForceResendingToken forceResendingToken) {
        }

        public abstract void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential);

        public abstract void onVerificationFailed(@NonNull FirebaseException firebaseException);
    }

    private PhoneAuthProvider(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @NonNull
    public static PhoneAuthCredential getCredential(@NonNull String str, @NonNull String str2) {
        return PhoneAuthCredential.zzc(str, str2);
    }

    @NonNull
    @Deprecated
    public static PhoneAuthProvider getInstance() {
        return new PhoneAuthProvider(FirebaseAuth.getInstance(FirebaseApp.getInstance()));
    }

    @NonNull
    @Deprecated
    public static PhoneAuthProvider getInstance(@NonNull FirebaseAuth firebaseAuth) {
        return new PhoneAuthProvider(firebaseAuth);
    }

    public static void verifyPhoneNumber(@NonNull PhoneAuthOptions phoneAuthOptions) {
        Preconditions.checkNotNull(phoneAuthOptions);
        phoneAuthOptions.zzb().zzU(phoneAuthOptions);
    }

    @Deprecated
    public void verifyPhoneNumber(@NonNull String str, long j11, @NonNull TimeUnit timeUnit, @NonNull Activity activity, @NonNull OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        PhoneAuthOptions.Builder newBuilder = PhoneAuthOptions.newBuilder(this.zza);
        newBuilder.setPhoneNumber(str);
        newBuilder.setTimeout(Long.valueOf(j11), timeUnit);
        newBuilder.setActivity(activity);
        newBuilder.setCallbacks(onVerificationStateChangedCallbacks);
        verifyPhoneNumber(newBuilder.build());
    }

    @Deprecated
    public void verifyPhoneNumber(@NonNull String str, long j11, @NonNull TimeUnit timeUnit, @NonNull Activity activity, @NonNull OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable ForceResendingToken forceResendingToken) {
        PhoneAuthOptions.Builder newBuilder = PhoneAuthOptions.newBuilder(this.zza);
        newBuilder.setPhoneNumber(str);
        newBuilder.setTimeout(Long.valueOf(j11), timeUnit);
        newBuilder.setActivity(activity);
        newBuilder.setCallbacks(onVerificationStateChangedCallbacks);
        if (forceResendingToken != null) {
            newBuilder.setForceResendingToken(forceResendingToken);
        }
        verifyPhoneNumber(newBuilder.build());
    }
}
