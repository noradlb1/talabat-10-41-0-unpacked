package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import com.google.android.gms.internal.gtm.zzrc.zza;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class zzrc<MessageType extends zzrc<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzpl<MessageType, BuilderType> {
    private static Map<Object, zzrc<?, ?>> zzbam = new ConcurrentHashMap();
    protected zzts zzbak = zzts.zzrj();
    private int zzbal = -1;

    public static class zzb<T extends zzrc<T, ?>> extends zzpn<T> {
        private final T zzban;

        public zzb(T t11) {
            this.zzban = t11;
        }

        public final /* synthetic */ Object zza(zzqe zzqe, zzqp zzqp) throws zzrk {
            return zzrc.zza(this.zzban, zzqe, zzqp);
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzrc<MessageType, BuilderType> implements zzsm {
        protected zzqt<Object> zzbaq = zzqt.zzov();
    }

    public static class zzd<ContainingType extends zzsk, Type> extends zzqn<ContainingType, Type> {
    }

    /* 'enum' modifier removed */
    public static final class zze {
        public static final int zzbar = 1;
        public static final int zzbas = 2;
        public static final int zzbat = 3;
        public static final int zzbau = 4;
        public static final int zzbav = 5;
        public static final int zzbaw = 6;
        public static final int zzbax = 7;
        private static final /* synthetic */ int[] zzbay = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzbaz = 1;
        public static final int zzbba = 2;
        private static final /* synthetic */ int[] zzbbb = {1, 2};
        public static final int zzbbc = 1;
        public static final int zzbbd = 2;
        private static final /* synthetic */ int[] zzbbe = {1, 2};

        public static int[] zzpn() {
            return (int[]) zzbay.clone();
        }
    }

    public static <T extends zzrc<?, ?>> void zza(Class<T> cls, T t11) {
        zzbam.put(cls, t11);
    }

    public static <T extends zzrc<?, ?>> T zzg(Class<T> cls) {
        T t11 = (zzrc) zzbam.get(cls);
        if (t11 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t11 = (zzrc) zzbam.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (t11 == null) {
            t11 = (zzrc) ((zzrc) zztx.zzk(cls)).zza(zze.zzbaw, (Object) null, (Object) null);
            if (t11 != null) {
                zzbam.put(cls, t11);
            } else {
                throw new IllegalStateException();
            }
        }
        return t11;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.gtm.zzrd, com.google.android.gms.internal.gtm.zzri] */
    public static zzri zzpf() {
        return zzrd.zzpo();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzrc) zza(zze.zzbaw, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzsw.zzqs().zzaf(this).equals(this, (zzrc) obj);
    }

    public int hashCode() {
        int i11 = this.zzavp;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = zzsw.zzqs().zzaf(this).hashCode(this);
        this.zzavp = hashCode;
        return hashCode;
    }

    public final boolean isInitialized() {
        return zza(this, true);
    }

    public String toString() {
        return zzsn.zza(this, super.toString());
    }

    public abstract Object zza(int i11, Object obj, Object obj2);

    public final void zzag(int i11) {
        this.zzbal = i11;
    }

    public final void zzb(zzqj zzqj) throws IOException {
        zzsw.zzqs().zzi(getClass()).zza(this, zzql.zza(zzqj));
    }

    public final void zzmi() {
        zzsw.zzqs().zzaf(this).zzt(this);
    }

    public final int zzmw() {
        return this.zzbal;
    }

    public final BuilderType zzpd() {
        BuilderType buildertype = (zza) zza(zze.zzbav, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    public final int zzpe() {
        if (this.zzbal == -1) {
            this.zzbal = zzsw.zzqs().zzaf(this).zzad(this);
        }
        return this.zzbal;
    }

    public final /* synthetic */ zzsl zzpg() {
        zza zza2 = (zza) zza(zze.zzbav, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzsl zzph() {
        return (zza) zza(zze.zzbav, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzsk zzpi() {
        return (zzrc) zza(zze.zzbaw, (Object) null, (Object) null);
    }

    public static Object zza(zzsk zzsk, String str, Object[] objArr) {
        return new zzsx(zzsk, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
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

    public static abstract class zza<MessageType extends zzrc<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzpm<MessageType, BuilderType> {
        private final MessageType zzban;
        private MessageType zzbao;
        private boolean zzbap = false;

        public zza(MessageType messagetype) {
            this.zzban = messagetype;
            this.zzbao = (zzrc) messagetype.zza(zze.zzbau, (Object) null, (Object) null);
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzban.zza(zze.zzbav, (Object) null, (Object) null);
            zza.zza((zzrc) zzpl());
            return zza;
        }

        public final boolean isInitialized() {
            return zzrc.zza(this.zzbao, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzbap) {
                MessageType messagetype2 = (zzrc) this.zzbao.zza(zze.zzbau, (Object) null, (Object) null);
                zza(messagetype2, this.zzbao);
                this.zzbao = messagetype2;
                this.zzbap = false;
            }
            zza(this.zzbao, messagetype);
            return this;
        }

        public final /* synthetic */ zzpm zzmx() {
            return (zza) clone();
        }

        public final /* synthetic */ zzsk zzpi() {
            return this.zzban;
        }

        /* renamed from: zzpj */
        public MessageType zzpl() {
            if (this.zzbap) {
                return this.zzbao;
            }
            this.zzbao.zzmi();
            this.zzbap = true;
            return this.zzbao;
        }

        /* renamed from: zzpk */
        public final MessageType zzpm() {
            MessageType messagetype = (zzrc) zzpl();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zztq(messagetype);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzsw.zzqs().zzaf(messagetype).zzd(messagetype, messagetype2);
        }
    }

    public static final <T extends zzrc<T, ?>> boolean zza(T t11, boolean z11) {
        byte byteValue = ((Byte) t11.zza(zze.zzbar, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzae = zzsw.zzqs().zzaf(t11).zzae(t11);
        if (z11) {
            t11.zza(zze.zzbas, (Object) zzae ? t11 : null, (Object) null);
        }
        return zzae;
    }

    public static <T extends zzrc<T, ?>> T zza(T t11, zzqe zzqe, zzqp zzqp) throws zzrk {
        T t12 = (zzrc) t11.zza(zze.zzbau, (Object) null, (Object) null);
        try {
            zzsw.zzqs().zzaf(t12).zza(t12, zzqh.zza(zzqe), zzqp);
            t12.zzmi();
            return t12;
        } catch (IOException e11) {
            if (e11.getCause() instanceof zzrk) {
                throw ((zzrk) e11.getCause());
            }
            throw new zzrk(e11.getMessage()).zzg(t12);
        } catch (RuntimeException e12) {
            if (e12.getCause() instanceof zzrk) {
                throw ((zzrk) e12.getCause());
            }
            throw e12;
        }
    }
}
