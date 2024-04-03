package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import com.google.android.gms.internal.places.zzbc.zzb;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class zzbc<MessageType extends zzbc<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzm<MessageType, BuilderType> {
    private static Map<Object, zzbc<?, ?>> zzij = new ConcurrentHashMap();
    protected zzdr zzih = zzdr.zzdh();
    private int zzii = -1;

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzbc<MessageType, BuilderType> implements zzcm {
        protected zzav<Object> zzik = zzav.zzau();

        public final zzav<Object> zzbm() {
            if (this.zzik.isImmutable()) {
                this.zzik = (zzav) this.zzik.clone();
            }
            return this.zzik;
        }
    }

    public static class zzd<T extends zzbc<T, ?>> extends zzn<T> {
        private final T zzie;

        public zzd(T t11) {
            this.zzie = t11;
        }
    }

    /* 'enum' modifier removed */
    public static final class zze {
        public static final int zzil = 1;
        public static final int zzim = 2;
        public static final int zzin = 3;
        public static final int zzio = 4;
        public static final int zzip = 5;
        public static final int zziq = 6;
        public static final int zzir = 7;
        private static final /* synthetic */ int[] zzis = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzit = 1;
        public static final int zziu = 2;
        private static final /* synthetic */ int[] zziv = {1, 2};
        public static final int zziw = 1;
        public static final int zzix = 2;
        private static final /* synthetic */ int[] zziy = {1, 2};

        public static int[] zzbn() {
            return (int[]) zzis.clone();
        }
    }

    public static class zzf<ContainingType extends zzck, Type> extends zzan<ContainingType, Type> {
    }

    public static <T extends zzbc<?, ?>> void zzb(Class<T> cls, T t11) {
        zzij.put(cls, t11);
    }

    public static zzbi zzbi() {
        return zzbe.zzbo();
    }

    public static <E> zzbh<E> zzbj() {
        return zzcy.zzct();
    }

    public static <T extends zzbc<?, ?>> T zzd(Class<T> cls) {
        T t11 = (zzbc) zzij.get(cls);
        if (t11 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t11 = (zzbc) zzij.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (t11 == null) {
            t11 = (zzbc) ((zzbc) zzdy.zzh(cls)).zzb(zze.zziq, (Object) null, (Object) null);
            if (t11 != null) {
                zzij.put(cls, t11);
            } else {
                throw new IllegalStateException();
            }
        }
        return t11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzbc) zzb(zze.zziq, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzcv.zzcq().zzq(this).equals(this, (zzbc) obj);
    }

    public int hashCode() {
        int i11 = this.zzdt;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = zzcv.zzcq().zzq(this).hashCode(this);
        this.zzdt = hashCode;
        return hashCode;
    }

    public final boolean isInitialized() {
        return zzb(this, true);
    }

    public String toString() {
        return zzcl.zzb(this, super.toString());
    }

    public final void zzab() {
        zzcv.zzcq().zzq(this).zzd(this);
    }

    public abstract Object zzb(int i11, Object obj, Object obj2);

    public final /* synthetic */ zzck zzbg() {
        return (zzbc) zzb(zze.zziq, (Object) null, (Object) null);
    }

    public final int zzbh() {
        if (this.zzii == -1) {
            this.zzii = zzcv.zzcq().zzq(this).zzn(this);
        }
        return this.zzii;
    }

    public final /* synthetic */ zzcj zzbk() {
        zzb zzb2 = (zzb) zzb(zze.zzip, (Object) null, (Object) null);
        zzb2.zzb(this);
        return zzb2;
    }

    public final /* synthetic */ zzcj zzbl() {
        return (zzb) zzb(zze.zzip, (Object) null, (Object) null);
    }

    public final void zzc(zzaj zzaj) throws IOException {
        zzcv.zzcq().zzf(getClass()).zzb(this, zzam.zzb(zzaj));
    }

    /* access modifiers changed from: package-private */
    public final void zze(int i11) {
        this.zzii = i11;
    }

    /* access modifiers changed from: package-private */
    public final int zzw() {
        return this.zzii;
    }

    public static Object zzb(zzck zzck, String str, Object[] objArr) {
        return new zzcx(zzck, str, objArr);
    }

    public static Object zzb(Method method, Object obj, Object... objArr) {
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

    public static abstract class zzb<MessageType extends zzbc<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzo<MessageType, BuilderType> {
        private final MessageType zzie;
        private MessageType zzif;
        private boolean zzig = false;

        public zzb(MessageType messagetype) {
            this.zzie = messagetype;
            this.zzif = (zzbc) messagetype.zzb(zze.zzio, (Object) null, (Object) null);
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb = (zzb) this.zzie.zzb(zze.zzip, (Object) null, (Object) null);
            zzb.zzb((zzbc) zzbe());
            return zzb;
        }

        public final boolean isInitialized() {
            return zzbc.zzb(this.zzif, false);
        }

        public final BuilderType zzb(MessageType messagetype) {
            if (this.zzig) {
                MessageType messagetype2 = (zzbc) this.zzif.zzb(zze.zzio, (Object) null, (Object) null);
                zzb(messagetype2, this.zzif);
                this.zzif = messagetype2;
                this.zzig = false;
            }
            zzb(this.zzif, messagetype);
            return this;
        }

        /* renamed from: zzbc */
        public MessageType zzbe() {
            if (this.zzig) {
                return this.zzif;
            }
            this.zzif.zzab();
            this.zzig = true;
            return this.zzif;
        }

        /* renamed from: zzbd */
        public final MessageType zzbf() {
            MessageType messagetype = (zzbc) zzbe();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzdp(messagetype);
        }

        public final /* synthetic */ zzck zzbg() {
            return this.zzie;
        }

        public final /* synthetic */ zzo zzx() {
            return (zzb) clone();
        }

        private static void zzb(MessageType messagetype, MessageType messagetype2) {
            zzcv.zzcq().zzq(messagetype).zzd(messagetype, messagetype2);
        }
    }

    public static final <T extends zzbc<T, ?>> boolean zzb(T t11, boolean z11) {
        byte byteValue = ((Byte) t11.zzb(zze.zzil, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzp = zzcv.zzcq().zzq(t11).zzp(t11);
        if (z11) {
            t11.zzb(zze.zzim, (Object) zzp ? t11 : null, (Object) null);
        }
        return zzp;
    }

    private static <T extends zzbc<T, ?>> T zzb(T t11, byte[] bArr, int i11, int i12, zzap zzap) throws zzbk {
        T t12 = (zzbc) t11.zzb(zze.zzio, (Object) null, (Object) null);
        try {
            zzcv.zzcq().zzq(t12).zzb(t12, bArr, 0, i12, new zzr(zzap));
            t12.zzab();
            if (t12.zzdt == 0) {
                return t12;
            }
            throw new RuntimeException();
        } catch (IOException e11) {
            if (e11.getCause() instanceof zzbk) {
                throw ((zzbk) e11.getCause());
            }
            throw new zzbk(e11.getMessage()).zzh(t12);
        } catch (IndexOutOfBoundsException unused) {
            throw zzbk.zzbp().zzh(t12);
        }
    }

    public static <T extends zzbc<T, ?>> T zzb(T t11, byte[] bArr) throws zzbk {
        T zzb2 = zzb(t11, bArr, 0, bArr.length, zzap.zzao());
        if (zzb2 == null || zzb2.isInitialized()) {
            return zzb2;
        }
        throw new zzbk(new zzdp(zzb2).getMessage()).zzh(zzb2);
    }
}
