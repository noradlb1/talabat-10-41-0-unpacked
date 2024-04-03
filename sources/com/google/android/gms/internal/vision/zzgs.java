package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzgs.zza;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class zzgs<MessageType extends zzgs<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzet<MessageType, BuilderType> {
    private static Map<Object, zzgs<?, ?>> zzwf = new ConcurrentHashMap();
    protected zzjm zzwd = zzjm.zzig();
    private int zzwe = -1;

    public static abstract class zzb<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzie {
        public zzb(MessageType messagetype) {
            super(messagetype);
        }

        public void zzfy() {
            super.zzfy();
            MessageType messagetype = this.zzwb;
            ((zze) messagetype).zzwk = (zzgi) ((zze) messagetype).zzwk.clone();
        }

        public /* synthetic */ zzgs zzfz() {
            return (zze) zzgb();
        }

        public /* synthetic */ zzic zzgb() {
            if (this.zzwc) {
                return (zze) this.zzwb;
            }
            ((zze) this.zzwb).zzwk.zzdp();
            return (zze) super.zzgb();
        }
    }

    public static class zzc<T extends zzgs<T, ?>> extends zzey<T> {
        private final T zzwa;

        public zzc(T t11) {
            this.zzwa = t11;
        }
    }

    public static final class zzd implements zzgk<zzd> {
        final int number = 202056002;
        final zzgv<?> zzwg = null;
        final zzka zzwh;
        final boolean zzwi;
        final boolean zzwj;

        public zzd(zzgv<?> zzgv, int i11, zzka zzka, boolean z11, boolean z12) {
            this.zzwh = zzka;
            this.zzwi = true;
            this.zzwj = false;
        }

        public final /* synthetic */ int compareTo(Object obj) {
            return this.number - ((zzd) obj).number;
        }

        public final zzib zza(zzib zzib, zzic zzic) {
            return ((zza) zzib).zza((zzgs) zzic);
        }

        public final int zzag() {
            return this.number;
        }

        public final zzka zzfs() {
            return this.zzwh;
        }

        public final zzkd zzft() {
            return this.zzwh.zzip();
        }

        public final boolean zzfu() {
            return this.zzwi;
        }

        public final boolean zzfv() {
            return this.zzwj;
        }

        public final zzih zza(zzih zzih, zzih zzih2) {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgs<MessageType, BuilderType> implements zzie {
        protected zzgi<zzd> zzwk = zzgi.zzfn();

        public final <Type> Type zzc(zzge<MessageType, Type> zzge) {
            zzg zzb = zzgs.zza(zzge);
            if (zzb.zzwz == ((zzgs) zzgd())) {
                Type zza = this.zzwk.zza(zzb.zzxb);
                if (zza == null) {
                    return zzb.zzgc;
                }
                zzd zzd = zzb.zzxb;
                if (!zzd.zzwi) {
                    return zzb.zzi(zza);
                }
                if (zzd.zzwh.zzip() != zzkd.ENUM) {
                    return zza;
                }
                Type arrayList = new ArrayList();
                for (Object zzi : (List) zza) {
                    arrayList.add(zzb.zzi(zzi));
                }
                return arrayList;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        public final zzgi<zzd> zzgk() {
            if (this.zzwk.isImmutable()) {
                this.zzwk = (zzgi) this.zzwk.clone();
            }
            return this.zzwk;
        }
    }

    /* 'enum' modifier removed */
    public static final class zzf {
        public static final int zzwl = 1;
        public static final int zzwm = 2;
        public static final int zzwn = 3;
        public static final int zzwo = 4;
        public static final int zzwp = 5;
        public static final int zzwq = 6;
        public static final int zzwr = 7;
        private static final /* synthetic */ int[] zzws = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzwt = 1;
        public static final int zzwu = 2;
        private static final /* synthetic */ int[] zzwv = {1, 2};
        public static final int zzww = 1;
        public static final int zzwx = 2;
        private static final /* synthetic */ int[] zzwy = {1, 2};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzws.clone();
        }
    }

    public static class zzg<ContainingType extends zzic, Type> extends zzge<ContainingType, Type> {
        final Type zzgc;
        final ContainingType zzwz;
        final zzic zzxa;
        final zzd zzxb;

        public zzg(ContainingType containingtype, Type type, zzic zzic, zzd zzd, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (zzd.zzwh == zzka.MESSAGE && zzic == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.zzwz = containingtype;
                this.zzgc = type;
                this.zzxa = zzic;
                this.zzxb = zzd;
            }
        }

        public final Object zzi(Object obj) {
            if (this.zzxb.zzwh.zzip() == zzkd.ENUM) {
                return this.zzxb.zzwg.zzg(((Integer) obj).intValue());
            }
            return obj;
        }
    }

    public static <T extends zzgs<?, ?>> void zza(Class<T> cls, T t11) {
        zzwf.put(cls, t11);
    }

    public static <T extends zzgs<?, ?>> T zzd(Class<T> cls) {
        T t11 = (zzgs) zzwf.get(cls);
        if (t11 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t11 = (zzgs) zzwf.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (t11 == null) {
            t11 = (zzgs) ((zzgs) zzjp.zzh(cls)).zza(zzf.zzwq, (Object) null, (Object) null);
            if (t11 != null) {
                zzwf.put(cls, t11);
            } else {
                throw new IllegalStateException();
            }
        }
        return t11;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzgx, com.google.android.gms.internal.vision.zzgu] */
    public static zzgx zzgg() {
        return zzgu.zzgl();
    }

    public static <E> zzgz<E> zzgh() {
        return zziq.zzhr();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzgs) zza(zzf.zzwq, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzin.zzho().zzu(this).equals(this, (zzgs) obj);
    }

    public int hashCode() {
        int i11 = this.zzri;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = zzin.zzho().zzu(this).hashCode(this);
        this.zzri = hashCode;
        return hashCode;
    }

    public final boolean isInitialized() {
        return zza(this, true);
    }

    public String toString() {
        return zzid.zza(this, super.toString());
    }

    public abstract Object zza(int i11, Object obj, Object obj2);

    public final void zzad(int i11) {
        this.zzwe = i11;
    }

    public final void zzb(zzga zzga) throws IOException {
        zzin.zzho().zzu(this).zza(this, zzgc.zza(zzga));
    }

    public final int zzdl() {
        return this.zzwe;
    }

    public final /* synthetic */ zzic zzgd() {
        return (zzgs) zza(zzf.zzwq, (Object) null, (Object) null);
    }

    public final <MessageType extends zzgs<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzge() {
        return (zza) zza(zzf.zzwp, (Object) null, (Object) null);
    }

    public final int zzgf() {
        if (this.zzwe == -1) {
            this.zzwe = zzin.zzho().zzu(this).zzr(this);
        }
        return this.zzwe;
    }

    public final /* synthetic */ zzib zzgi() {
        zza zza2 = (zza) zza(zzf.zzwp, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzib zzgj() {
        return (zza) zza(zzf.zzwp, (Object) null, (Object) null);
    }

    public static Object zza(zzic zzic, String str, Object[] objArr) {
        return new zzip(zzic, str, objArr);
    }

    public static <ContainingType extends zzic, Type> zzg<ContainingType, Type> zza(ContainingType containingtype, zzic zzic, zzgv<?> zzgv, int i11, zzka zzka, boolean z11, Class cls) {
        return new zzg(containingtype, Collections.emptyList(), zzic, new zzd((zzgv<?>) null, 202056002, zzka, true, false), cls);
    }

    public static abstract class zza<MessageType extends zzgs<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzew<MessageType, BuilderType> {
        private final MessageType zzwa;
        protected MessageType zzwb;
        protected boolean zzwc = false;

        public zza(MessageType messagetype) {
            this.zzwa = messagetype;
            this.zzwb = (zzgs) messagetype.zza(zzf.zzwo, (Object) null, (Object) null);
        }

        private final BuilderType zzb(byte[] bArr, int i11, int i12, zzgd zzgd) throws zzhc {
            if (this.zzwc) {
                zzfy();
                this.zzwc = false;
            }
            try {
                zzin.zzho().zzu(this.zzwb).zza(this.zzwb, bArr, 0, i12 + 0, new zzfb(zzgd));
                return this;
            } catch (zzhc e11) {
                throw e11;
            } catch (IndexOutOfBoundsException unused) {
                throw zzhc.zzgm();
            } catch (IOException e12) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e12);
            }
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzwa.zza(zzf.zzwp, (Object) null, (Object) null);
            zza.zza((zzgs) zzgb());
            return zza;
        }

        public final boolean isInitialized() {
            return zzgs.zza(this.zzwb, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzwc) {
                zzfy();
                this.zzwc = false;
            }
            zza(this.zzwb, messagetype);
            return this;
        }

        public final /* synthetic */ zzew zzdn() {
            return (zza) clone();
        }

        public void zzfy() {
            MessageType messagetype = (zzgs) this.zzwb.zza(zzf.zzwo, (Object) null, (Object) null);
            zza(messagetype, this.zzwb);
            this.zzwb = messagetype;
        }

        /* renamed from: zzfz */
        public MessageType zzgb() {
            if (this.zzwc) {
                return this.zzwb;
            }
            MessageType messagetype = this.zzwb;
            zzin.zzho().zzu(messagetype).zzg(messagetype);
            this.zzwc = true;
            return this.zzwb;
        }

        /* renamed from: zzga */
        public final MessageType zzgc() {
            MessageType messagetype = (zzgs) zzgb();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzjk(messagetype);
        }

        public final /* synthetic */ zzic zzgd() {
            return this.zzwa;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzin.zzho().zzu(messagetype).zzd(messagetype, messagetype2);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzft zzft, zzgd zzgd) throws IOException {
            if (this.zzwc) {
                zzfy();
                this.zzwc = false;
            }
            try {
                zzin.zzho().zzu(this.zzwb).zza(this.zzwb, zzfy.zza(zzft), zzgd);
                return this;
            } catch (RuntimeException e11) {
                if (e11.getCause() instanceof IOException) {
                    throw ((IOException) e11.getCause());
                }
                throw e11;
            }
        }

        public final /* synthetic */ zzew zza(byte[] bArr, int i11, int i12, zzgd zzgd) throws zzhc {
            return zzb(bArr, 0, i12, zzgd);
        }
    }

    private static <T extends zzgs<T, ?>> T zzb(T t11) throws zzhc {
        if (t11 == null || t11.isInitialized()) {
            return t11;
        }
        throw new zzhc(new zzjk(t11).getMessage()).zzg(t11);
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

    /* access modifiers changed from: private */
    public static <MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>, T> zzg<MessageType, T> zza(zzge<MessageType, T> zzge) {
        return (zzg) zzge;
    }

    public static final <T extends zzgs<T, ?>> boolean zza(T t11, boolean z11) {
        byte byteValue = ((Byte) t11.zza(zzf.zzwl, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzt = zzin.zzho().zzu(t11).zzt(t11);
        if (z11) {
            t11.zza(zzf.zzwm, (Object) zzt ? t11 : null, (Object) null);
        }
        return zzt;
    }

    public static <E> zzgz<E> zza(zzgz<E> zzgz) {
        int size = zzgz.size();
        return zzgz.zzag(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzgs<T, ?>> T zza(T t11, byte[] bArr, int i11, int i12, zzgd zzgd) throws zzhc {
        T t12 = (zzgs) t11.zza(zzf.zzwo, (Object) null, (Object) null);
        try {
            zzir zzu = zzin.zzho().zzu(t12);
            zzu.zza(t12, bArr, 0, i12, new zzfb(zzgd));
            zzu.zzg(t12);
            if (t12.zzri == 0) {
                return t12;
            }
            throw new RuntimeException();
        } catch (IOException e11) {
            if (e11.getCause() instanceof zzhc) {
                throw ((zzhc) e11.getCause());
            }
            throw new zzhc(e11.getMessage()).zzg(t12);
        } catch (IndexOutOfBoundsException unused) {
            throw zzhc.zzgm().zzg(t12);
        }
    }

    public static <T extends zzgs<T, ?>> T zza(T t11, byte[] bArr) throws zzhc {
        return zzb(zza(t11, bArr, 0, bArr.length, zzgd.zzfl()));
    }

    public static <T extends zzgs<T, ?>> T zza(T t11, byte[] bArr, zzgd zzgd) throws zzhc {
        return zzb(zza(t11, bArr, 0, bArr.length, zzgd));
    }
}
