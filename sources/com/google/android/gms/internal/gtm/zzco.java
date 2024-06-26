package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.UUID;

public final class zzco {

    /* renamed from: name  reason: collision with root package name */
    private final String f35097name;
    private final long zzabz;
    private final /* synthetic */ zzcm zzaca;

    private zzco(zzcm zzcm, String str, long j11) {
        this.zzaca = zzcm;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j11 > 0);
        this.f35097name = str;
        this.zzabz = j11;
    }

    private final void zzgb() {
        long currentTimeMillis = this.zzaca.zzcn().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzaca.zzabv.edit();
        edit.remove(zzgf());
        edit.remove(zzgg());
        edit.putLong(zzge(), currentTimeMillis);
        edit.commit();
    }

    private final long zzgd() {
        return this.zzaca.zzabv.getLong(zzge(), 0);
    }

    private final String zzge() {
        return String.valueOf(this.f35097name).concat(":start");
    }

    private final String zzgf() {
        return String.valueOf(this.f35097name).concat(":count");
    }

    @VisibleForTesting
    private final String zzgg() {
        return String.valueOf(this.f35097name).concat(":value");
    }

    public final void zzae(String str) {
        boolean z11;
        if (zzgd() == 0) {
            zzgb();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j11 = this.zzaca.zzabv.getLong(zzgf(), 0);
            if (j11 <= 0) {
                SharedPreferences.Editor edit = this.zzaca.zzabv.edit();
                edit.putString(zzgg(), str);
                edit.putLong(zzgf(), 1);
                edit.apply();
                return;
            }
            long j12 = j11 + 1;
            if ((UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / j12) {
                z11 = true;
            } else {
                z11 = false;
            }
            SharedPreferences.Editor edit2 = this.zzaca.zzabv.edit();
            if (z11) {
                edit2.putString(zzgg(), str);
            }
            edit2.putLong(zzgf(), j12);
            edit2.apply();
        }
    }

    public final Pair<String, Long> zzgc() {
        long j11;
        long zzgd = zzgd();
        if (zzgd == 0) {
            j11 = 0;
        } else {
            j11 = Math.abs(zzgd - this.zzaca.zzcn().currentTimeMillis());
        }
        long j12 = this.zzabz;
        if (j11 < j12) {
            return null;
        }
        if (j11 > (j12 << 1)) {
            zzgb();
            return null;
        }
        String string = this.zzaca.zzabv.getString(zzgg(), (String) null);
        long j13 = this.zzaca.zzabv.getLong(zzgf(), 0);
        zzgb();
        if (string == null || j13 <= 0) {
            return null;
        }
        return new Pair<>(string, Long.valueOf(j13));
    }
}
