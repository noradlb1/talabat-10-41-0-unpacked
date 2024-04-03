package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public final class zzfke extends zzfka {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final zzfkc zzb;
    private final zzfkb zzc;
    private final List<zzfks> zzd = new ArrayList();
    private zzflz zze;
    private zzflc zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private final String zzi;

    public zzfke(zzfkb zzfkb, zzfkc zzfkc) {
        this.zzc = zzfkb;
        this.zzb = zzfkc;
        this.zzi = UUID.randomUUID().toString();
        zzk((View) null);
        if (zzfkc.zzd() == zzfkd.HTML || zzfkc.zzd() == zzfkd.JAVASCRIPT) {
            this.zzf = new zzfld(zzfkc.zza());
        } else {
            this.zzf = new zzflf(zzfkc.zzi(), (String) null);
        }
        this.zzf.zzj();
        zzfkp.zza().zzd(this);
        zzfkv.zza().zzd(this.zzf.zza(), zzfkb.zzb());
    }

    private final void zzk(View view) {
        this.zze = new zzflz(view);
    }

    public final void zzb(View view, zzfkg zzfkg, @Nullable String str) {
        zzfks zzfks;
        if (this.zzh) {
            return;
        }
        if (zza.matcher("Ad overlay").matches()) {
            Iterator<zzfks> it = this.zzd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zzfks = null;
                    break;
                }
                zzfks = it.next();
                if (zzfks.zzb().get() == view) {
                    break;
                }
            }
            if (zzfks == null) {
                this.zzd.add(new zzfks(view, zzfkg, "Ad overlay"));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FriendlyObstruction has improperly formatted detailed reason");
    }

    public final void zzc() {
        if (!this.zzh) {
            this.zze.clear();
            if (!this.zzh) {
                this.zzd.clear();
            }
            this.zzh = true;
            zzfkv.zza().zzc(this.zzf.zza());
            zzfkp.zza().zze(this);
            this.zzf.zzc();
            this.zzf = null;
        }
    }

    public final void zzd(View view) {
        if (!this.zzh && zzf() != view) {
            zzk(view);
            this.zzf.zzb();
            Collection<zzfke> zzc2 = zzfkp.zza().zzc();
            if (zzc2 != null && zzc2.size() > 0) {
                for (zzfke next : zzc2) {
                    if (next != this && next.zzf() == view) {
                        next.zze.clear();
                    }
                }
            }
        }
    }

    public final void zze() {
        if (!this.zzg) {
            this.zzg = true;
            zzfkp.zza().zzf(this);
            this.zzf.zzh(zzfkw.zzb().zza());
            this.zzf.zzf(this, this.zzb);
        }
    }

    public final View zzf() {
        return (View) this.zze.get();
    }

    public final zzflc zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzi;
    }

    public final List<zzfks> zzi() {
        return this.zzd;
    }

    public final boolean zzj() {
        return this.zzg && !this.zzh;
    }
}
