package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.internal.zzgz;
import com.google.android.recaptcha.internal.zzhf;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class zzhf<MessageType extends zzhf<MessageType, BuilderType>, BuilderType extends zzgz<MessageType, BuilderType>> extends zzer<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzjx zzc = zzjx.zzc();
    private int zzd = -1;

    public static void zzC(Class cls, zzhf zzhf) {
        zzhf.zzB();
        zzb.put(cls, zzhf);
    }

    public static final boolean zzE(zzhf zzhf, boolean z11) {
        zzhf zzhf2;
        byte byteValue = ((Byte) zzhf.zzh(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zziy.zza().zzb(zzhf.getClass()).zzl(zzhf);
        if (z11) {
            if (true != zzl) {
                zzhf2 = null;
            } else {
                zzhf2 = zzhf;
            }
            zzhf.zzh(2, zzhf2, (Object) null);
        }
        return zzl;
    }

    private final int zzf(zzjc zzjc) {
        if (zzjc != null) {
            return zzjc.zza(this);
        }
        return zziy.zza().zzb(getClass()).zza(this);
    }

    private static zzhf zzg(zzhf zzhf) throws zzhp {
        if (zzhf == null || zzhf.zzo()) {
            return zzhf;
        }
        zzhp zza = new zzjv(zzhf).zza();
        zza.zzh(zzhf);
        throw zza;
    }

    private static zzhf zzi(zzhf zzhf, byte[] bArr, int i11, int i12, zzgq zzgq) throws zzhp {
        zzhf zzs = zzhf.zzs();
        try {
            zzjc zzb2 = zziy.zza().zzb(zzs.getClass());
            zzb2.zzi(zzs, bArr, 0, i12, new zzev(zzgq));
            zzb2.zzf(zzs);
            return zzs;
        } catch (zzhp e11) {
            e = e11;
            if (e.zzl()) {
                e = new zzhp((IOException) e);
            }
            e.zzh(zzs);
            throw e;
        } catch (zzjv e12) {
            zzhp zza = e12.zza();
            zza.zzh(zzs);
            throw zza;
        } catch (IOException e13) {
            if (e13.getCause() instanceof zzhp) {
                throw ((zzhp) e13.getCause());
            }
            zzhp zzhp = new zzhp(e13);
            zzhp.zzh(zzs);
            throw zzhp;
        } catch (IndexOutOfBoundsException unused) {
            zzhp zzj = zzhp.zzj();
            zzj.zzh(zzs);
            throw zzj;
        }
    }

    public static zzhd zzq(zzip zzip, Object obj, zzip zzip2, zzhi zzhi, int i11, zzkm zzkm, Class cls) {
        return new zzhd(zzip, "", (zzip) null, new zzhc((zzhi) null, i11, zzkm, false, false), cls);
    }

    public static zzhf zzr(Class cls) {
        Map map = zzb;
        zzhf zzhf = (zzhf) map.get(cls);
        if (zzhf == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzhf = (zzhf) map.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (zzhf == null) {
            zzhf = (zzhf) ((zzhf) zzkg.zze(cls)).zzh(6, (Object) null, (Object) null);
            if (zzhf != null) {
                map.put(cls, zzhf);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzhf;
    }

    public static zzhf zzt(zzhf zzhf, InputStream inputStream) throws zzhp {
        zzfo zzfo;
        int i11 = zzfo.zzd;
        if (inputStream == null) {
            byte[] bArr = zzhn.zzd;
            int length = bArr.length;
            zzfo = zzfo.zzH(bArr, 0, 0, false);
        } else {
            zzfo = new zzfm(inputStream, 4096, (zzfl) null);
        }
        zzgq zzgq = zzgq.zza;
        zzhf zzs = zzhf.zzs();
        try {
            zzjc zzb2 = zziy.zza().zzb(zzs.getClass());
            zzb2.zzh(zzs, zzfp.zzq(zzfo), zzgq);
            zzb2.zzf(zzs);
            zzg(zzs);
            return zzs;
        } catch (zzhp e11) {
            e = e11;
            if (e.zzl()) {
                e = new zzhp((IOException) e);
            }
            e.zzh(zzs);
            throw e;
        } catch (zzjv e12) {
            zzhp zza = e12.zza();
            zza.zzh(zzs);
            throw zza;
        } catch (IOException e13) {
            if (e13.getCause() instanceof zzhp) {
                throw ((zzhp) e13.getCause());
            }
            zzhp zzhp = new zzhp(e13);
            zzhp.zzh(zzs);
            throw zzhp;
        } catch (RuntimeException e14) {
            if (e14.getCause() instanceof zzhp) {
                throw ((zzhp) e14.getCause());
            }
            throw e14;
        }
    }

    public static zzhf zzu(zzhf zzhf, byte[] bArr) throws zzhp {
        zzhf zzi = zzi(zzhf, bArr, 0, bArr.length, zzgq.zza);
        zzg(zzi);
        return zzi;
    }

    public static zzhk zzv() {
        return zzhg.zzf();
    }

    public static zzhm zzw() {
        return zziz.zze();
    }

    public static zzhm zzx(zzhm zzhm) {
        int i11;
        int size = zzhm.size();
        if (size == 0) {
            i11 = 10;
        } else {
            i11 = size + size;
        }
        return zzhm.zzd(i11);
    }

    public static Object zzy(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e11);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static Object zzz(zzip zzip, String str, Object[] objArr) {
        return new zzja(zzip, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zziy.zza().zzb(getClass()).zzk(this, (zzhf) obj);
    }

    public final int hashCode() {
        if (zzF()) {
            return zzm();
        }
        int i11 = this.zza;
        if (i11 != 0) {
            return i11;
        }
        int zzm = zzm();
        this.zza = zzm;
        return zzm;
    }

    public final String toString() {
        return zzir.zza(this, super.toString());
    }

    public final void zzA() {
        zziy.zza().zzb(getClass()).zzf(this);
        zzB();
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void zzD(int i11) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean zzF() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzio zzV() {
        return (zzgz) zzh(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzio zzW() {
        zzgz zzgz = (zzgz) zzh(5, (Object) null, (Object) null);
        zzgz.zzg(this);
        return zzgz;
    }

    public final /* synthetic */ zzip zzX() {
        return (zzhf) zzh(6, (Object) null, (Object) null);
    }

    public final int zza(zzjc zzjc) {
        if (zzF()) {
            int zzf = zzf(zzjc);
            if (zzf >= 0) {
                return zzf;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzf);
        }
        int i11 = this.zzd & Integer.MAX_VALUE;
        if (i11 != Integer.MAX_VALUE) {
            return i11;
        }
        int zzf2 = zzf(zzjc);
        if (zzf2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zzf2;
            return zzf2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zzf2);
    }

    public final void zze(zzft zzft) throws IOException {
        zziy.zza().zzb(getClass()).zzj(this, zzfu.zza(zzft));
    }

    public abstract Object zzh(int i11, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public final int zzm() {
        return zziy.zza().zzb(getClass()).zzb(this);
    }

    public final int zzn() {
        int i11;
        if (zzF()) {
            i11 = zzf((zzjc) null);
            if (i11 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i11);
            }
        } else {
            i11 = this.zzd & Integer.MAX_VALUE;
            if (i11 == Integer.MAX_VALUE) {
                i11 = zzf((zzjc) null);
                if (i11 >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i11;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i11);
                }
            }
        }
        return i11;
    }

    public final boolean zzo() {
        return zzE(this, true);
    }

    public final zzgz zzp() {
        return (zzgz) zzh(5, (Object) null, (Object) null);
    }

    public final zzhf zzs() {
        return (zzhf) zzh(4, (Object) null, (Object) null);
    }
}
