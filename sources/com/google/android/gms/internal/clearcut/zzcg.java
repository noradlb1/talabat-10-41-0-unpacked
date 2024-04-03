package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg.zza;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class zzcg<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzas<MessageType, BuilderType> {
    private static Map<Object, zzcg<?, ?>> zzjr = new ConcurrentHashMap();
    protected zzey zzjp = zzey.zzea();
    private int zzjq = -1;

    public static abstract class zza<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzat<MessageType, BuilderType> {
        private final MessageType zzjs;
        protected MessageType zzjt;
        protected boolean zzju = false;

        public zza(MessageType messagetype) {
            this.zzjs = messagetype;
            this.zzjt = (zzcg) messagetype.zza(zzg.zzkg, (Object) null, (Object) null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzea.zzcm().zzp(messagetype).zzc(messagetype, messagetype2);
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzjs.zza(zzg.zzkh, (Object) null, (Object) null);
            zza.zza((zzcg) zzbi());
            return zza;
        }

        public final boolean isInitialized() {
            return zzcg.zza(this.zzjt, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzbf();
            zza(this.zzjt, messagetype);
            return this;
        }

        public final /* synthetic */ zzdo zzbe() {
            return this.zzjs;
        }

        public void zzbf() {
            if (this.zzju) {
                MessageType messagetype = (zzcg) this.zzjt.zza(zzg.zzkg, (Object) null, (Object) null);
                zza(messagetype, this.zzjt);
                this.zzjt = messagetype;
                this.zzju = false;
            }
        }

        /* renamed from: zzbg */
        public MessageType zzbi() {
            if (this.zzju) {
                return this.zzjt;
            }
            MessageType messagetype = this.zzjt;
            zzea.zzcm().zzp(messagetype).zzc(messagetype);
            this.zzju = true;
            return this.zzjt;
        }

        public final MessageType zzbh() {
            MessageType messagetype = (zzcg) zzbi();
            byte byteValue = ((Byte) messagetype.zza(zzg.zzkd, (Object) null, (Object) null)).byteValue();
            boolean z11 = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z11 = false;
                } else {
                    z11 = zzea.zzcm().zzp(messagetype).zzo(messagetype);
                    messagetype.zza(zzg.zzke, (Object) z11 ? messagetype : null, (Object) null);
                }
            }
            if (z11) {
                return messagetype;
            }
            throw new zzew(messagetype);
        }

        public final /* synthetic */ zzdo zzbj() {
            zzcg zzcg = (zzcg) zzbi();
            byte byteValue = ((Byte) zzcg.zza(zzg.zzkd, (Object) null, (Object) null)).byteValue();
            boolean z11 = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z11 = false;
                } else {
                    z11 = zzea.zzcm().zzp(zzcg).zzo(zzcg);
                    zzcg.zza(zzg.zzke, (Object) z11 ? zzcg : null, (Object) null);
                }
            }
            if (z11) {
                return zzcg;
            }
            throw new zzew(zzcg);
        }

        public final /* synthetic */ zzat zzt() {
            return (zza) clone();
        }
    }

    public static class zzb<T extends zzcg<T, ?>> extends zzau<T> {
        private T zzjs;

        public zzb(T t11) {
            this.zzjs = t11;
        }
    }

    public static abstract class zzc<MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzdq {
        public zzc(MessageType messagetype) {
            super(messagetype);
        }

        public final void zzbf() {
            if (this.zzju) {
                super.zzbf();
                MessageType messagetype = this.zzjt;
                ((zzd) messagetype).zzjv = (zzby) ((zzd) messagetype).zzjv.clone();
            }
        }

        public final /* synthetic */ zzcg zzbg() {
            return (zzd) zzbi();
        }

        public final /* synthetic */ zzdo zzbi() {
            MessageType zzbg;
            if (this.zzju) {
                zzbg = this.zzjt;
            } else {
                ((zzd) this.zzjt).zzjv.zzv();
                zzbg = super.zzbi();
            }
            return (zzd) zzbg;
        }
    }

    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>> extends zzcg<MessageType, BuilderType> implements zzdq {
        protected zzby<zze> zzjv = zzby.zzar();
    }

    public static final class zze implements zzca<zze> {
        final int number = 66321687;
        private final zzck<?> zzjw = null;
        final zzfl zzjx;
        final boolean zzjy;
        final boolean zzjz;

        public zze(zzck<?> zzck, int i11, zzfl zzfl, boolean z11, boolean z12) {
            this.zzjx = zzfl;
            this.zzjy = false;
            this.zzjz = false;
        }

        public final /* synthetic */ int compareTo(Object obj) {
            return this.number - ((zze) obj).number;
        }

        public final zzdp zza(zzdp zzdp, zzdo zzdo) {
            return ((zza) zzdp).zza((zzcg) zzdo);
        }

        public final zzdv zza(zzdv zzdv, zzdv zzdv2) {
            throw new UnsupportedOperationException();
        }

        public final zzfl zzau() {
            return this.zzjx;
        }

        public final zzfq zzav() {
            return this.zzjx.zzek();
        }

        public final boolean zzaw() {
            return false;
        }

        public final boolean zzax() {
            return false;
        }

        public final int zzc() {
            return this.number;
        }
    }

    public static class zzf<ContainingType extends zzdo, Type> extends zzbr<ContainingType, Type> {
        private final Type zzdu;
        private final ContainingType zzka;
        private final zzdo zzkb;
        private final zze zzkc;

        public zzf(ContainingType containingtype, Type type, zzdo zzdo, zze zze, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (zze.zzjx == zzfl.MESSAGE && zzdo == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.zzka = containingtype;
                this.zzdu = type;
                this.zzkb = zzdo;
                this.zzkc = zze;
            }
        }
    }

    /* 'enum' modifier removed */
    public static final class zzg {
        public static final int zzkd = 1;
        public static final int zzke = 2;
        public static final int zzkf = 3;
        public static final int zzkg = 4;
        public static final int zzkh = 5;
        public static final int zzki = 6;
        public static final int zzkj = 7;
        private static final /* synthetic */ int[] zzkk = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzkl = 1;
        public static final int zzkm = 2;
        private static final /* synthetic */ int[] zzkn = {1, 2};
        public static final int zzko = 1;
        public static final int zzkp = 2;
        private static final /* synthetic */ int[] zzkq = {1, 2};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzkk.clone();
        }
    }

    public static <ContainingType extends zzdo, Type> zzf<ContainingType, Type> zza(ContainingType containingtype, Type type, zzdo zzdo, zzck<?> zzck, int i11, zzfl zzfl, Class cls) {
        return new zzf(containingtype, type, zzdo, new zze((zzck<?>) null, 66321687, zzfl, false, false), cls);
    }

    private static <T extends zzcg<T, ?>> T zza(T t11, byte[] bArr) throws zzco {
        T t12 = (zzcg) t11.zza(zzg.zzkg, (Object) null, (Object) null);
        try {
            zzea.zzcm().zzp(t12).zza(t12, bArr, 0, bArr.length, new zzay());
            zzea.zzcm().zzp(t12).zzc(t12);
            if (t12.zzex == 0) {
                return t12;
            }
            throw new RuntimeException();
        } catch (IOException e11) {
            if (e11.getCause() instanceof zzco) {
                throw ((zzco) e11.getCause());
            }
            throw new zzco(e11.getMessage()).zzg(t12);
        } catch (IndexOutOfBoundsException unused) {
            throw zzco.zzbl().zzg(t12);
        }
    }

    public static Object zza(zzdo zzdo, String str, Object[] objArr) {
        return new zzec(zzdo, str, objArr);
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

    public static <T extends zzcg<?, ?>> void zza(Class<T> cls, T t11) {
        zzjr.put(cls, t11);
    }

    public static final <T extends zzcg<T, ?>> boolean zza(T t11, boolean z11) {
        byte byteValue = ((Byte) t11.zza(zzg.zzkd, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return zzea.zzcm().zzp(t11).zzo(t11);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.clearcut.zzch, com.google.android.gms.internal.clearcut.zzcl] */
    public static zzcl zzaz() {
        return zzch.zzbk();
    }

    public static <T extends zzcg<T, ?>> T zzb(T t11, byte[] bArr) throws zzco {
        T zza2 = zza(t11, bArr);
        if (zza2 != null) {
            byte byteValue = ((Byte) zza2.zza(zzg.zzkd, (Object) null, (Object) null)).byteValue();
            boolean z11 = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z11 = false;
                } else {
                    z11 = zzea.zzcm().zzp(zza2).zzo(zza2);
                    zza2.zza(zzg.zzke, (Object) z11 ? zza2 : null, (Object) null);
                }
            }
            if (!z11) {
                throw new zzco(new zzew(zza2).getMessage()).zzg(zza2);
            }
        }
        return zza2;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.clearcut.zzcm, com.google.android.gms.internal.clearcut.zzdc] */
    public static zzcm zzba() {
        return zzdc.zzbx();
    }

    public static <E> zzcn<E> zzbb() {
        return zzeb.zzcn();
    }

    public static <T extends zzcg<?, ?>> T zzc(Class<T> cls) {
        T t11 = (zzcg) zzjr.get(cls);
        if (t11 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t11 = (zzcg) zzjr.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (t11 != null) {
            return t11;
        }
        String name2 = cls.getName();
        throw new IllegalStateException(name2.length() != 0 ? "Unable to get default instance for: ".concat(name2) : new String("Unable to get default instance for: "));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzcg) zza(zzg.zzki, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzea.zzcm().zzp(this).equals(this, (zzcg) obj);
    }

    public int hashCode() {
        int i11 = this.zzex;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = zzea.zzcm().zzp(this).hashCode(this);
        this.zzex = hashCode;
        return hashCode;
    }

    public final boolean isInitialized() {
        byte byteValue = ((Byte) zza(zzg.zzkd, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzo = zzea.zzcm().zzp(this).zzo(this);
        zza(zzg.zzke, (Object) zzo ? this : null, (Object) null);
        return zzo;
    }

    public String toString() {
        return zzdr.zza(this, super.toString());
    }

    public abstract Object zza(int i11, Object obj, Object obj2);

    public final int zzas() {
        if (this.zzjq == -1) {
            this.zzjq = zzea.zzcm().zzp(this).zzm(this);
        }
        return this.zzjq;
    }

    public final void zzb(zzbn zzbn) throws IOException {
        zzea.zzcm().zze(getClass()).zza(this, zzbp.zza(zzbn));
    }

    public final /* synthetic */ zzdp zzbc() {
        zza zza2 = (zza) zza(zzg.zzkh, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzdp zzbd() {
        return (zza) zza(zzg.zzkh, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzdo zzbe() {
        return (zzcg) zza(zzg.zzki, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(int i11) {
        this.zzjq = i11;
    }

    /* access modifiers changed from: package-private */
    public final int zzs() {
        return this.zzjq;
    }
}
