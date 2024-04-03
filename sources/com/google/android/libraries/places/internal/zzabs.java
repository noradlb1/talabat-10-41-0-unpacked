package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzabp;
import com.google.android.libraries.places.internal.zzabs;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class zzabs<MessageType extends zzabs<MessageType, BuilderType>, BuilderType extends zzabp<MessageType, BuilderType>> extends zzaaj<MessageType, BuilderType> {
    private static final Map<Object, zzabs<?, ?>> zzb = new ConcurrentHashMap();
    protected zzaec zzc = zzaec.zzc();
    protected int zzd = -1;

    public static zzaby zzA() {
        return zzaco.zze();
    }

    public static <E> zzabz<E> zzB() {
        return zzadi.zzd();
    }

    public static <E> zzabz<E> zzC(zzabz<E> zzabz) {
        int i11;
        int size = zzabz.size();
        if (size == 0) {
            i11 = 10;
        } else {
            i11 = size + size;
        }
        return zzabz.zzf(i11);
    }

    public static Object zzE(Method method, Object obj, Object... objArr) {
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

    public static Object zzF(zzacz zzacz, String str, Object[] objArr) {
        return new zzadj(zzacz, str, objArr);
    }

    public static <T extends zzabs> void zzG(Class<T> cls, T t11) {
        zzb.put(cls, t11);
    }

    public static <T extends zzabs> T zzy(Class<T> cls) {
        Map<Object, zzabs<?, ?>> map = zzb;
        T t11 = (zzabs) map.get(cls);
        if (t11 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t11 = (zzabs) map.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (t11 == null) {
            t11 = (zzabs) ((zzabs) zzael.zze(cls)).zzd(6, (Object) null, (Object) null);
            if (t11 != null) {
                map.put(cls, t11);
            } else {
                throw new IllegalStateException();
            }
        }
        return t11;
    }

    public static zzabw zzz() {
        return zzabt.zze();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzadh.zza().zzb(getClass()).zze(this, (zzabs) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zza;
        if (i11 != 0) {
            return i11;
        }
        int zzb2 = zzadh.zza().zzb(getClass()).zzb(this);
        this.zza = zzb2;
        return zzb2;
    }

    public final String toString() {
        return zzadb.zza(this, super.toString());
    }

    public final /* bridge */ /* synthetic */ zzacy zzD() {
        zzabp zzabp = (zzabp) zzd(5, (Object) null, (Object) null);
        zzabp.zzs(this);
        return zzabp;
    }

    public final void zzH(zzabf zzabf) throws IOException {
        zzadh.zza().zzb(getClass()).zzi(this, zzabg.zza(zzabf));
    }

    public abstract Object zzd(int i11, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public final int zzr() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzu(int i11) {
        this.zzd = i11;
    }

    public final int zzv() {
        int i11 = this.zzd;
        if (i11 != -1) {
            return i11;
        }
        int zza = zzadh.zza().zzb(getClass()).zza(this);
        this.zzd = zza;
        return zza;
    }

    public final /* bridge */ /* synthetic */ zzacz zzw() {
        return (zzabs) zzd(6, (Object) null, (Object) null);
    }

    public final <MessageType extends zzabs<MessageType, BuilderType>, BuilderType extends zzabp<MessageType, BuilderType>> BuilderType zzx() {
        return (zzabp) zzd(5, (Object) null, (Object) null);
    }
}
