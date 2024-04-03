package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzuq;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzur<M extends zzuq<M>, T> {
    public final int tag;
    private final int type;
    private final zzrc<?, ?> zzban;
    protected final Class<T> zzbhc;
    protected final boolean zzbhd;

    private zzur(int i11, Class<T> cls, int i12, boolean z11) {
        this(11, cls, (zzrc<?, ?>) null, 810, false);
    }

    public static <M extends zzuq<M>, T extends zzuw> zzur<M, T> zza(int i11, Class<T> cls, long j11) {
        return new zzur<>(11, cls, 810, false);
    }

    private final Object zzc(zzun zzun) {
        Class cls;
        if (this.zzbhd) {
            cls = this.zzbhc.getComponentType();
        } else {
            cls = this.zzbhc;
        }
        try {
            int i11 = this.type;
            if (i11 == 10) {
                zzuw zzuw = (zzuw) cls.newInstance();
                zzun.zza(zzuw, this.tag >>> 3);
                return zzuw;
            } else if (i11 == 11) {
                zzuw zzuw2 = (zzuw) cls.newInstance();
                zzun.zza(zzuw2);
                return zzuw2;
            } else {
                int i12 = this.type;
                StringBuilder sb2 = new StringBuilder(24);
                sb2.append("Unknown type ");
                sb2.append(i12);
                throw new IllegalArgumentException(sb2.toString());
            }
        } catch (InstantiationException e11) {
            String valueOf = String.valueOf(cls);
            StringBuilder sb3 = new StringBuilder(valueOf.length() + 33);
            sb3.append("Error creating instance of class ");
            sb3.append(valueOf);
            throw new IllegalArgumentException(sb3.toString(), e11);
        } catch (IllegalAccessException e12) {
            String valueOf2 = String.valueOf(cls);
            StringBuilder sb4 = new StringBuilder(valueOf2.length() + 33);
            sb4.append("Error creating instance of class ");
            sb4.append(valueOf2);
            throw new IllegalArgumentException(sb4.toString(), e12);
        } catch (IOException e13) {
            throw new IllegalArgumentException("Error reading extension field", e13);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzur)) {
            return false;
        }
        zzur zzur = (zzur) obj;
        if (this.type == zzur.type && this.zzbhc == zzur.zzbhc && this.tag == zzur.tag && this.zzbhd == zzur.zzbhd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.type + 1147) * 31) + this.zzbhc.hashCode()) * 31) + this.tag) * 31) + (this.zzbhd ? 1 : 0);
    }

    public final T zzag(List<zzuy> list) {
        if (list == null) {
            return null;
        }
        if (this.zzbhd) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < list.size(); i11++) {
                byte[] bArr = list.get(i11).zzawe;
                if (bArr.length != 0) {
                    arrayList.add(zzc(zzun.zzk(bArr)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            Class<T> cls = this.zzbhc;
            T cast = cls.cast(Array.newInstance(cls.getComponentType(), size));
            for (int i12 = 0; i12 < size; i12++) {
                Array.set(cast, i12, arrayList.get(i12));
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.zzbhc.cast(zzc(zzun.zzk(list.get(list.size() - 1).zzawe)));
        }
    }

    public final int zzaj(Object obj) {
        int i11 = this.tag >>> 3;
        int i12 = this.type;
        if (i12 == 10) {
            return (zzuo.zzbb(i11) << 1) + ((zzuw) obj).zzpe();
        }
        if (i12 == 11) {
            return zzuo.zzb(i11, (zzuw) obj);
        }
        int i13 = this.type;
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("Unknown type ");
        sb2.append(i13);
        throw new IllegalArgumentException(sb2.toString());
    }

    private zzur(int i11, Class<T> cls, zzrc<?, ?> zzrc, int i12, boolean z11) {
        this.type = i11;
        this.zzbhc = cls;
        this.tag = i12;
        this.zzbhd = false;
        this.zzban = null;
    }

    public final void zza(Object obj, zzuo zzuo) {
        try {
            zzuo.zzcb(this.tag);
            int i11 = this.type;
            if (i11 == 10) {
                ((zzuw) obj).zza(zzuo);
                zzuo.zzd(this.tag >>> 3, 4);
            } else if (i11 == 11) {
                zzuo.zzb((zzuw) obj);
            } else {
                int i12 = this.type;
                StringBuilder sb2 = new StringBuilder(24);
                sb2.append("Unknown type ");
                sb2.append(i12);
                throw new IllegalArgumentException(sb2.toString());
            }
        } catch (IOException e11) {
            throw new IllegalStateException(e11);
        }
    }
}
