package com.google.android.gms.internal.gtm;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

@VisibleForTesting
final class zzmq extends zzmn {
    private final zzmp zzasr;
    private final List<Integer> zzass;
    private final int zzast;
    private final /* synthetic */ zzmo zzasu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzmq(zzmo zzmo, int i11, zzmw zzmw, zzms zzms, List<Integer> list, int i12, @Nullable zzmp zzmp, zzdz zzdz) {
        super(i11, zzmw, zzms, zzdz);
        this.zzasu = zzmo;
        this.zzasr = zzmp;
        this.zzass = list;
        this.zzast = i12;
    }

    public final void zza(zzmx zzmx) {
        String str;
        String str2;
        String str3;
        boolean z11 = false;
        if (zzmx.getStatus() == Status.RESULT_SUCCESS) {
            String valueOf = String.valueOf(zzmx.zzln());
            if (valueOf.length() != 0) {
                str3 = "Container resource successfully loaded from ".concat(valueOf);
            } else {
                str3 = new String("Container resource successfully loaded from ");
            }
            zzev.zzab(str3);
            if (zzmx.getSource() == 0) {
                zzmy zzll = zzmx.zzll();
                if (!zzll.zzlp().zzlg()) {
                    this.zzasu.zza(zzmx.getStatus(), zzll);
                    if (zzll.zzlo() != null && zzll.zzlo().length > 0) {
                        this.zzasu.zzaso.zza(zzll.zzlp().zzlf(), zzll.zzlo());
                    }
                }
            }
            z11 = true;
        }
        if (z11) {
            this.zzasr.zza(zzmx);
            return;
        }
        String zzln = zzmx.zzln();
        if (zzmx.getStatus().isSuccess()) {
            str = "SUCCESS";
        } else {
            str = "FAILURE";
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzln).length() + 54 + str.length());
        sb2.append("Cannot fetch a valid resource from ");
        sb2.append(zzln);
        sb2.append(". Response status: ");
        sb2.append(str);
        zzev.zzab(sb2.toString());
        if (zzmx.getStatus().isSuccess()) {
            String valueOf2 = String.valueOf(zzmx.zzln());
            if (valueOf2.length() != 0) {
                str2 = "Response source: ".concat(valueOf2);
            } else {
                str2 = new String("Response source: ");
            }
            zzev.zzab(str2);
            int length = zzmx.zzll().zzlo().length;
            StringBuilder sb3 = new StringBuilder(26);
            sb3.append("Response size: ");
            sb3.append(length);
            zzev.zzab(sb3.toString());
        }
        this.zzasu.zza(this.zzask, this.zzass, this.zzast + 1, this.zzasr, this.zzasn);
    }
}
