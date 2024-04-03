package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkh;
import com.google.android.gms.internal.ads.zzgkl;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class zzgkl<MessageType extends zzgkl<MessageType, BuilderType>, BuilderType extends zzgkh<MessageType, BuilderType>> extends zzgin<MessageType, BuilderType> {
    private static final Map<Object, zzgkl<?, ?>> zzb = new ConcurrentHashMap();
    protected zzgng zzc = zzgng.zzc();
    protected int zzd = -1;

    private static <T extends zzgkl<T, ?>> T zza(T t11) throws zzgkx {
        if (t11 == null || t11.zzaM()) {
            return t11;
        }
        zzgkx zzgkx = new zzgkx(new zzgne(t11).getMessage());
        zzgkx.zzh(t11);
        throw zzgkx;
    }

    public static <T extends zzgkl<T, ?>> T zzaA(T t11, byte[] bArr, int i11, int i12, zzgjx zzgjx) throws zzgkx {
        T t12 = (zzgkl) t11.zzb(4, (Object) null, (Object) null);
        try {
            zzgmo<?> zzb2 = zzgmd.zza().zzb(t12.getClass());
            zzb2.zzi(t12, bArr, 0, i12, new zzgiq(zzgjx));
            zzb2.zzf(t12);
            if (t12.zza == 0) {
                return t12;
            }
            throw new RuntimeException();
        } catch (zzgkx e11) {
            e = e11;
            if (e.zzl()) {
                e = new zzgkx((IOException) e);
            }
            e.zzh(t12);
            throw e;
        } catch (IOException e12) {
            if (e12.getCause() instanceof zzgkx) {
                throw ((zzgkx) e12.getCause());
            }
            zzgkx zzgkx = new zzgkx(e12);
            zzgkx.zzh(t12);
            throw zzgkx;
        } catch (IndexOutOfBoundsException unused) {
            zzgkx zzj = zzgkx.zzj();
            zzj.zzh(t12);
            throw zzj;
        }
    }

    public static zzgkq zzaB() {
        return zzgkm.zzf();
    }

    public static zzgkq zzaC(zzgkq zzgkq) {
        int i11;
        int size = zzgkq.size();
        if (size == 0) {
            i11 = 10;
        } else {
            i11 = size + size;
        }
        return zzgkq.zzg(i11);
    }

    public static zzgkt zzaD() {
        return zzglk.zzf();
    }

    public static <E> zzgku<E> zzaE() {
        return zzgme.zze();
    }

    public static <E> zzgku<E> zzaF(zzgku<E> zzgku) {
        int i11;
        int size = zzgku.size();
        if (size == 0) {
            i11 = 10;
        } else {
            i11 = size + size;
        }
        return zzgku.zzd(i11);
    }

    public static Object zzaI(Method method, Object obj, Object... objArr) {
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

    public static Object zzaJ(zzglv zzglv, String str, Object[] objArr) {
        return new zzgmf(zzglv, str, objArr);
    }

    public static <T extends zzgkl> void zzaK(Class<T> cls, T t11) {
        zzb.put(cls, t11);
    }

    public static <T extends zzgkl> T zzav(Class<T> cls) {
        Map<Object, zzgkl<?, ?>> map = zzb;
        T t11 = (zzgkl) map.get(cls);
        if (t11 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t11 = (zzgkl) map.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (t11 == null) {
            t11 = (zzgkl) ((zzgkl) zzgnp.zzg(cls)).zzb(6, (Object) null, (Object) null);
            if (t11 != null) {
                map.put(cls, t11);
            } else {
                throw new IllegalStateException();
            }
        }
        return t11;
    }

    public static <T extends zzgkl<T, ?>> T zzaw(T t11, zzgjf zzgjf) throws zzgkx {
        T t12;
        zzgjx zza = zzgjx.zza();
        try {
            zzgjn zzl = zzgjf.zzl();
            t12 = (zzgkl) t11.zzb(4, (Object) null, (Object) null);
            zzgmo<?> zzb2 = zzgmd.zza().zzb(t12.getClass());
            zzb2.zzh(t12, zzgjo.zzq(zzl), zza);
            zzb2.zzf(t12);
            zzl.zzz(0);
            zza(t12);
            zza(t12);
            return t12;
        } catch (zzgkx e11) {
            e = e11;
            if (e.zzl()) {
                e = new zzgkx((IOException) e);
            }
            e.zzh(t12);
            throw e;
        } catch (IOException e12) {
            if (e12.getCause() instanceof zzgkx) {
                throw ((zzgkx) e12.getCause());
            }
            zzgkx zzgkx = new zzgkx(e12);
            zzgkx.zzh(t12);
            throw zzgkx;
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof zzgkx) {
                throw ((zzgkx) e13.getCause());
            }
            throw e13;
        } catch (zzgkx e14) {
            e14.zzh(t12);
            throw e14;
        } catch (zzgkx e15) {
            throw e15;
        }
    }

    public static <T extends zzgkl<T, ?>> T zzax(T t11, byte[] bArr) throws zzgkx {
        T zzaA = zzaA(t11, bArr, 0, bArr.length, zzgjx.zza());
        zza(zzaA);
        return zzaA;
    }

    public static <T extends zzgkl<T, ?>> T zzay(T t11, zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        T t12;
        try {
            zzgjn zzl = zzgjf.zzl();
            t12 = (zzgkl) t11.zzb(4, (Object) null, (Object) null);
            zzgmo<?> zzb2 = zzgmd.zza().zzb(t12.getClass());
            zzb2.zzh(t12, zzgjo.zzq(zzl), zzgjx);
            zzb2.zzf(t12);
            zzl.zzz(0);
            zza(t12);
            return t12;
        } catch (zzgkx e11) {
            e = e11;
            if (e.zzl()) {
                e = new zzgkx((IOException) e);
            }
            e.zzh(t12);
            throw e;
        } catch (IOException e12) {
            if (e12.getCause() instanceof zzgkx) {
                throw ((zzgkx) e12.getCause());
            }
            zzgkx zzgkx = new zzgkx(e12);
            zzgkx.zzh(t12);
            throw zzgkx;
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof zzgkx) {
                throw ((zzgkx) e13.getCause());
            }
            throw e13;
        } catch (zzgkx e14) {
            e14.zzh(t12);
            throw e14;
        } catch (zzgkx e15) {
            throw e15;
        }
    }

    public static <T extends zzgkl<T, ?>> T zzaz(T t11, byte[] bArr, zzgjx zzgjx) throws zzgkx {
        T zzaA = zzaA(t11, bArr, 0, bArr.length, zzgjx);
        zza(zzaA);
        return zzaA;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzgmd.zza().zzb(getClass()).zzj(this, (zzgkl) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zza;
        if (i11 != 0) {
            return i11;
        }
        int zzb2 = zzgmd.zza().zzb(getClass()).zzb(this);
        this.zza = zzb2;
        return zzb2;
    }

    public final String toString() {
        return zzglx.zza(this, super.toString());
    }

    public final /* synthetic */ zzglu zzaG() {
        return (zzgkh) zzb(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzglu zzaH() {
        zzgkh zzgkh = (zzgkh) zzb(5, (Object) null, (Object) null);
        zzgkh.zzaf(this);
        return zzgkh;
    }

    public final void zzaL(zzgjs zzgjs) throws IOException {
        zzgmd.zza().zzb(getClass()).zzn(this, zzgjt.zza(zzgjs));
    }

    public final boolean zzaM() {
        zzgkl zzgkl;
        byte byteValue = ((Byte) zzb(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzgmd.zza().zzb(getClass()).zzk(this);
        if (true != zzk) {
            zzgkl = null;
        } else {
            zzgkl = this;
        }
        zzb(2, zzgkl, (Object) null);
        return zzk;
    }

    public final int zzan() {
        return this.zzd;
    }

    public final void zzaq(int i11) {
        this.zzd = i11;
    }

    public final int zzas() {
        int i11 = this.zzd;
        if (i11 != -1) {
            return i11;
        }
        int zza = zzgmd.zza().zzb(getClass()).zza(this);
        this.zzd = zza;
        return zza;
    }

    public final <MessageType extends zzgkl<MessageType, BuilderType>, BuilderType extends zzgkh<MessageType, BuilderType>> BuilderType zzat() {
        return (zzgkh) zzb(5, (Object) null, (Object) null);
    }

    public final BuilderType zzau() {
        BuilderType buildertype = (zzgkh) zzb(5, (Object) null, (Object) null);
        buildertype.zzaf(this);
        return buildertype;
    }

    public abstract Object zzb(int i11, Object obj, Object obj2);

    public final /* synthetic */ zzglv zzbp() {
        return (zzgkl) zzb(6, (Object) null, (Object) null);
    }
}
