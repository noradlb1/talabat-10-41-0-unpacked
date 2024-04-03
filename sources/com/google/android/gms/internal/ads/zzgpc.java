package com.google.android.gms.internal.ads;

import datamodels.TypesAliasesKt;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzgpc implements Iterator<zzaif>, Closeable, zzaig, j$.util.Iterator {
    private static final zzaif zza = new zzgpb("eof ");
    private static final zzgpj zzb = zzgpj.zzb(zzgpc.class);
    protected zzaic zzc;
    protected zzgpd zzd;
    zzaif zze = null;
    long zzf = 0;
    long zzg = 0;
    private final List<zzaif> zzh = new ArrayList();

    public void close() throws IOException {
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        zzaif zzaif = this.zze;
        if (zzaif == zza) {
            return false;
        }
        if (zzaif != null) {
            return true;
        }
        try {
            this.zze = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zze = zza;
            return false;
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("[");
        for (int i11 = 0; i11 < this.zzh.size(); i11++) {
            if (i11 > 0) {
                sb2.append(TypesAliasesKt.separator);
            }
            sb2.append(this.zzh.get(i11).toString());
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* renamed from: zzd */
    public final zzaif next() {
        zzaif zzb2;
        zzaif zzaif = this.zze;
        if (zzaif == null || zzaif == zza) {
            zzgpd zzgpd = this.zzd;
            if (zzgpd == null || this.zzf >= this.zzg) {
                this.zze = zza;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzgpd) {
                    this.zzd.zze(this.zzf);
                    zzb2 = this.zzc.zzb(this.zzd, this);
                    this.zzf = this.zzd.zzb();
                }
                return zzb2;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zze = null;
            return zzaif;
        }
    }

    public final List<zzaif> zze() {
        return (this.zzd == null || this.zze == zza) ? this.zzh : new zzgpi(this.zzh, this);
    }

    public final void zzf(zzgpd zzgpd, long j11, zzaic zzaic) throws IOException {
        this.zzd = zzgpd;
        this.zzf = zzgpd.zzb();
        zzgpd.zze(zzgpd.zzb() + j11);
        this.zzg = zzgpd.zzb();
        this.zzc = zzaic;
    }
}
