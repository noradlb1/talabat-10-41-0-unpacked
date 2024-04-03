package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzcx;
import com.google.android.gms.internal.icing.zzda;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class zzda<MessageType extends zzda<MessageType, BuilderType>, BuilderType extends zzcx<MessageType, BuilderType>> extends zzbs<MessageType, BuilderType> {
    private static final Map<Object, zzda<?, ?>> zzb = new ConcurrentHashMap();
    protected zzfe zzc = zzfe.zza();
    protected int zzd = -1;

    public static <T extends zzda> T zzp(Class<T> cls) {
        Map<Object, zzda<?, ?>> map = zzb;
        T t11 = (zzda) map.get(cls);
        if (t11 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t11 = (zzda) map.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (t11 == null) {
            t11 = (zzda) ((zzda) zzfn.zzc(cls)).zzf(6, (Object) null, (Object) null);
            if (t11 != null) {
                map.put(cls, t11);
            } else {
                throw new IllegalStateException();
            }
        }
        return t11;
    }

    public static <T extends zzda> void zzq(Class<T> cls, T t11) {
        zzb.put(cls, t11);
    }

    public static Object zzr(zzee zzee, String str, Object[] objArr) {
        return new zzeo(zzee, str, objArr);
    }

    public static Object zzs(Method method, Object obj, Object... objArr) {
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

    public static zzdf zzt() {
        return zzdt.zzd();
    }

    public static zzdd zzu() {
        return zzco.zzd();
    }

    public static zzdc zzv() {
        return zzbv.zzd();
    }

    public static <E> zzdg<E> zzw() {
        return zzen.zzd();
    }

    public static <E> zzdg<E> zzx(zzdg<E> zzdg) {
        int i11;
        int size = zzdg.size();
        if (size == 0) {
            i11 = 10;
        } else {
            i11 = size + size;
        }
        return zzdg.zze(i11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzem.zza().zzb(getClass()).zza(this, (zzda) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zza;
        if (i11 != 0) {
            return i11;
        }
        int zzb2 = zzem.zza().zzb(getClass()).zzb(this);
        this.zza = zzb2;
        return zzb2;
    }

    public final String toString() {
        return zzeg.zza(this, super.toString());
    }

    public abstract Object zzf(int i11, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public final int zzi() {
        return this.zzd;
    }

    public final void zzj(int i11) {
        this.zzd = i11;
    }

    public final <MessageType extends zzda<MessageType, BuilderType>, BuilderType extends zzcx<MessageType, BuilderType>> BuilderType zzl() {
        return (zzcx) zzf(5, (Object) null, (Object) null);
    }

    public final /* bridge */ /* synthetic */ zzee zzm() {
        return (zzda) zzf(6, (Object) null, (Object) null);
    }

    public final void zzn(zzcm zzcm) throws IOException {
        zzem.zza().zzb(getClass()).zzi(this, zzcn.zza(zzcm));
    }

    public final int zzo() {
        int i11 = this.zzd;
        if (i11 != -1) {
            return i11;
        }
        int zzd2 = zzem.zza().zzb(getClass()).zzd(this);
        this.zzd = zzd2;
        return zzd2;
    }

    public final /* bridge */ /* synthetic */ zzed zzy() {
        zzcx zzcx = (zzcx) zzf(5, (Object) null, (Object) null);
        zzcx.zzk(this);
        return zzcx;
    }
}
