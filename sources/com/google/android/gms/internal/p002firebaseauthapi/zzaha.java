package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzagw;
import com.google.android.gms.internal.p002firebaseauthapi.zzaha;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaha  reason: invalid package */
public abstract class zzaha<MessageType extends zzaha<MessageType, BuilderType>, BuilderType extends zzagw<MessageType, BuilderType>> extends zzaff<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzajm zzc = zzajm.zzc();
    private int zzd = -1;

    public static zzahf zzA() {
        return zzaio.zze();
    }

    public static zzahf zzB(zzahf zzahf) {
        int i11;
        int size = zzahf.size();
        if (size == 0) {
            i11 = 10;
        } else {
            i11 = size + size;
        }
        return zzahf.zzd(i11);
    }

    public static Object zzD(Method method, Object obj, Object... objArr) {
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

    public static Object zzE(zzaif zzaif, String str, Object[] objArr) {
        return new zzaip(zzaif, str, objArr);
    }

    public static void zzH(Class cls, zzaha zzaha) {
        zzaha.zzG();
        zzb.put(cls, zzaha);
    }

    private final int zza(zzair zzair) {
        return zzain.zza().zzb(getClass()).zza(this);
    }

    private static zzaha zzb(zzaha zzaha) throws zzahi {
        if (zzaha == null || zzaha.zzK()) {
            return zzaha;
        }
        zzahi zza = new zzajk(zzaha).zza();
        zza.zzh(zzaha);
        throw zza;
    }

    private static zzaha zzc(zzaha zzaha, byte[] bArr, int i11, int i12, zzagn zzagn) throws zzahi {
        zzaha zzw = zzaha.zzw();
        try {
            zzair zzb2 = zzain.zza().zzb(zzw.getClass());
            zzb2.zzi(zzw, bArr, 0, i12, new zzafi(zzagn));
            zzb2.zzf(zzw);
            return zzw;
        } catch (zzahi e11) {
            e = e11;
            if (e.zzl()) {
                e = new zzahi((IOException) e);
            }
            e.zzh(zzw);
            throw e;
        } catch (zzajk e12) {
            zzahi zza = e12.zza();
            zza.zzh(zzw);
            throw zza;
        } catch (IOException e13) {
            if (e13.getCause() instanceof zzahi) {
                throw ((zzahi) e13.getCause());
            }
            zzahi zzahi = new zzahi(e13);
            zzahi.zzh(zzw);
            throw zzahi;
        } catch (IndexOutOfBoundsException unused) {
            zzahi zzj = zzahi.zzj();
            zzj.zzh(zzw);
            throw zzj;
        }
    }

    public static zzaha zzv(Class cls) {
        Map map = zzb;
        zzaha zzaha = (zzaha) map.get(cls);
        if (zzaha == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzaha = (zzaha) map.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (zzaha == null) {
            zzaha = (zzaha) ((zzaha) zzajv.zze(cls)).zzj(6, (Object) null, (Object) null);
            if (zzaha != null) {
                map.put(cls, zzaha);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzaha;
    }

    public static zzaha zzx(zzaha zzaha, zzafv zzafv, zzagn zzagn) throws zzahi {
        zzagb zzh = zzafv.zzh();
        zzaha zzw = zzaha.zzw();
        try {
            zzair zzb2 = zzain.zza().zzb(zzw.getClass());
            zzb2.zzh(zzw, zzagc.zzq(zzh), zzagn);
            zzb2.zzf(zzw);
            try {
                zzh.zzz(0);
                zzb(zzw);
                return zzw;
            } catch (zzahi e11) {
                e11.zzh(zzw);
                throw e11;
            }
        } catch (zzahi e12) {
            e = e12;
            if (e.zzl()) {
                e = new zzahi((IOException) e);
            }
            e.zzh(zzw);
            throw e;
        } catch (zzajk e13) {
            zzahi zza = e13.zza();
            zza.zzh(zzw);
            throw zza;
        } catch (IOException e14) {
            if (e14.getCause() instanceof zzahi) {
                throw ((zzahi) e14.getCause());
            }
            zzahi zzahi = new zzahi(e14);
            zzahi.zzh(zzw);
            throw zzahi;
        } catch (RuntimeException e15) {
            if (e15.getCause() instanceof zzahi) {
                throw ((zzahi) e15.getCause());
            }
            throw e15;
        }
    }

    public static zzaha zzy(zzaha zzaha, InputStream inputStream, zzagn zzagn) throws zzahi {
        zzafz zzafz = new zzafz(inputStream, 4096, (zzafy) null);
        zzaha zzw = zzaha.zzw();
        try {
            zzair zzb2 = zzain.zza().zzb(zzw.getClass());
            zzb2.zzh(zzw, zzagc.zzq(zzafz), zzagn);
            zzb2.zzf(zzw);
            zzb(zzw);
            return zzw;
        } catch (zzahi e11) {
            e = e11;
            if (e.zzl()) {
                e = new zzahi((IOException) e);
            }
            e.zzh(zzw);
            throw e;
        } catch (zzajk e12) {
            zzahi zza = e12.zza();
            zza.zzh(zzw);
            throw zza;
        } catch (IOException e13) {
            if (e13.getCause() instanceof zzahi) {
                throw ((zzahi) e13.getCause());
            }
            zzahi zzahi = new zzahi(e13);
            zzahi.zzh(zzw);
            throw zzahi;
        } catch (RuntimeException e14) {
            if (e14.getCause() instanceof zzahi) {
                throw ((zzahi) e14.getCause());
            }
            throw e14;
        }
    }

    public static zzaha zzz(zzaha zzaha, byte[] bArr, zzagn zzagn) throws zzahi {
        zzaha zzc2 = zzc(zzaha, bArr, 0, bArr.length, zzagn);
        zzb(zzc2);
        return zzc2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzain.zza().zzb(getClass()).zzj(this, (zzaha) obj);
    }

    public final int hashCode() {
        if (zzL()) {
            return zzr();
        }
        int i11 = this.zza;
        if (i11 != 0) {
            return i11;
        }
        int zzr = zzr();
        this.zza = zzr;
        return zzr;
    }

    public final String toString() {
        return zzaih.zza(this, super.toString());
    }

    public final /* synthetic */ zzaie zzC() {
        return (zzagw) zzj(5, (Object) null, (Object) null);
    }

    public final void zzF() {
        zzain.zza().zzb(getClass()).zzf(this);
        zzG();
    }

    /* access modifiers changed from: package-private */
    public final void zzG() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void zzI(int i11) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final void zzJ(zzagi zzagi) throws IOException {
        zzain.zza().zzb(getClass()).zzm(this, zzagj.zza(zzagi));
    }

    public final boolean zzK() {
        zzaha zzaha;
        byte byteValue = ((Byte) zzj(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzain.zza().zzb(getClass()).zzk(this);
        if (true != zzk) {
            zzaha = null;
        } else {
            zzaha = this;
        }
        zzj(2, zzaha, (Object) null);
        return zzk;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzL() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzaif zzM() {
        return (zzaha) zzj(6, (Object) null, (Object) null);
    }

    public abstract Object zzj(int i11, Object obj, Object obj2);

    public final int zzn(zzair zzair) {
        if (zzL()) {
            int zza = zzair.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i11 = this.zzd & Integer.MAX_VALUE;
        if (i11 != Integer.MAX_VALUE) {
            return i11;
        }
        int zza2 = zzair.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    /* access modifiers changed from: package-private */
    public final int zzr() {
        return zzain.zza().zzb(getClass()).zzb(this);
    }

    public final int zzs() {
        int i11;
        if (zzL()) {
            i11 = zza((zzair) null);
            if (i11 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i11);
            }
        } else {
            i11 = this.zzd & Integer.MAX_VALUE;
            if (i11 == Integer.MAX_VALUE) {
                i11 = zza((zzair) null);
                if (i11 >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i11;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i11);
                }
            }
        }
        return i11;
    }

    public final zzagw zzt() {
        return (zzagw) zzj(5, (Object) null, (Object) null);
    }

    public final zzagw zzu() {
        zzagw zzagw = (zzagw) zzj(5, (Object) null, (Object) null);
        zzagw.zzh(this);
        return zzagw;
    }

    public final zzaha zzw() {
        return (zzaha) zzj(4, (Object) null, (Object) null);
    }
}
