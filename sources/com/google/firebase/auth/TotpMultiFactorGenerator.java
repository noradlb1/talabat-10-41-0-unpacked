package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzag;

public final class TotpMultiFactorGenerator {
    @NonNull
    public static final String FACTOR_ID = "totp";

    private TotpMultiFactorGenerator() {
    }

    @NonNull
    public static Task<TotpSecret> generateSecret(@NonNull MultiFactorSession multiFactorSession) {
        Preconditions.checkNotNull(multiFactorSession);
        zzag zzag = (zzag) multiFactorSession;
        return FirebaseAuth.getInstance(zzag.zza().zza()).zzn(zzag);
    }

    @NonNull
    public static TotpMultiFactorAssertion getAssertionForEnrollment(@NonNull TotpSecret totpSecret, @NonNull String str) {
        return new TotpMultiFactorAssertion((String) Preconditions.checkNotNull(str), (TotpSecret) Preconditions.checkNotNull(totpSecret), (String) null);
    }

    @NonNull
    public static TotpMultiFactorAssertion getAssertionForSignIn(@NonNull String str, @NonNull String str2) {
        return new TotpMultiFactorAssertion((String) Preconditions.checkNotNull(str2), (TotpSecret) null, (String) Preconditions.checkNotNull(str));
    }
}
