package com.google.android.gms.internal.gtm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.VisibleForTesting;
import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Random;
import org.apache.commons.lang3.time.DateUtils;

@ShowFirstParty
public final class zzdz {
    private final String zzaec;
    private final Random zzafj;
    private final Context zzrm;

    public zzdz(Context context, String str) {
        this(context, str, new Random());
    }

    private final long zza(long j11, long j12) {
        SharedPreferences zzhp = zzhp();
        long max = Math.max(0, zzhp.getLong("FORBIDDEN_COUNT", 0));
        return (long) (this.zzafj.nextFloat() * ((float) (j11 + ((long) ((((float) max) / ((float) ((max + Math.max(0, zzhp.getLong("SUCCESSFUL_COUNT", 0))) + 1))) * ((float) (j12 - j11)))))));
    }

    private final SharedPreferences zzhp() {
        Context context = this.zzrm;
        String valueOf = String.valueOf(this.zzaec);
        return context.getSharedPreferences(valueOf.length() != 0 ? "v5_gtmContainerRefreshPolicy_".concat(valueOf) : new String("v5_gtmContainerRefreshPolicy_"), 0);
    }

    public final long zzhl() {
        return zza(7200000, 259200000) + 43200000;
    }

    public final long zzhm() {
        return zza(AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED, 86400000) + DateUtils.MILLIS_PER_HOUR;
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzhn() {
        long j11;
        SharedPreferences zzhp = zzhp();
        long j12 = zzhp.getLong("FORBIDDEN_COUNT", 0);
        long j13 = zzhp.getLong("SUCCESSFUL_COUNT", 0);
        SharedPreferences.Editor edit = zzhp.edit();
        if (j12 == 0) {
            j11 = 3;
        } else {
            j11 = Math.min(10, j12 + 1);
        }
        long max = Math.max(0, Math.min(j13, 10 - j11));
        edit.putLong("FORBIDDEN_COUNT", j11);
        edit.putLong("SUCCESSFUL_COUNT", max);
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzho() {
        SharedPreferences zzhp = zzhp();
        long j11 = zzhp.getLong("SUCCESSFUL_COUNT", 0);
        long j12 = zzhp.getLong("FORBIDDEN_COUNT", 0);
        long min = Math.min(10, j11 + 1);
        long max = Math.max(0, Math.min(j12, 10 - min));
        SharedPreferences.Editor edit = zzhp.edit();
        edit.putLong("SUCCESSFUL_COUNT", min);
        edit.putLong("FORBIDDEN_COUNT", max);
        edit.apply();
    }

    public final long zzkd() {
        if (Math.max(0, zzhp().getLong("FORBIDDEN_COUNT", 0)) == 0) {
            return 0;
        }
        return zza(10000, AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED) + 10000;
    }

    public final boolean zzke() {
        if (Math.max(0, zzhp().getLong("FORBIDDEN_COUNT", 0)) > 0) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    private zzdz(Context context, String str, Random random) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
        this.zzaec = (String) Preconditions.checkNotNull(str);
        this.zzafj = random;
    }
}
