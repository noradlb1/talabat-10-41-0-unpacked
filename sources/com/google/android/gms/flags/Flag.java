package com.google.android.gms.flags;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@Deprecated
public abstract class Flag<T> {
    private final String mKey;
    private final int zze;
    private final T zzf;

    @Deprecated
    public static class BooleanFlag extends Flag<Boolean> {
        public BooleanFlag(int i11, String str, Boolean bool) {
            super(i11, str, bool);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final Boolean zza(zzc zzc) {
            try {
                return Boolean.valueOf(zzc.getBooleanFlagValue(getKey(), ((Boolean) zzb()).booleanValue(), getSource()));
            } catch (RemoteException unused) {
                return (Boolean) zzb();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class IntegerFlag extends Flag<Integer> {
        public IntegerFlag(int i11, String str, Integer num) {
            super(i11, str, num);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzc */
        public final Integer zza(zzc zzc) {
            try {
                return Integer.valueOf(zzc.getIntFlagValue(getKey(), ((Integer) zzb()).intValue(), getSource()));
            } catch (RemoteException unused) {
                return (Integer) zzb();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class LongFlag extends Flag<Long> {
        public LongFlag(int i11, String str, Long l11) {
            super(i11, str, l11);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzd */
        public final Long zza(zzc zzc) {
            try {
                return Long.valueOf(zzc.getLongFlagValue(getKey(), ((Long) zzb()).longValue(), getSource()));
            } catch (RemoteException unused) {
                return (Long) zzb();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class StringFlag extends Flag<String> {
        public StringFlag(int i11, String str, String str2) {
            super(i11, str, str2);
        }

        /* access modifiers changed from: private */
        /* renamed from: zze */
        public final String zza(zzc zzc) {
            try {
                return zzc.getStringFlagValue(getKey(), (String) zzb(), getSource());
            } catch (RemoteException unused) {
                return (String) zzb();
            }
        }
    }

    private Flag(int i11, String str, T t11) {
        this.zze = i11;
        this.mKey = str;
        this.zzf = t11;
        Singletons.flagRegistry().zza(this);
    }

    @KeepForSdk
    @Deprecated
    public static BooleanFlag define(int i11, String str, Boolean bool) {
        return new BooleanFlag(i11, str, bool);
    }

    @KeepForSdk
    public T get() {
        return Singletons.zzd().zzb(this);
    }

    public final String getKey() {
        return this.mKey;
    }

    @Deprecated
    public final int getSource() {
        return this.zze;
    }

    public abstract T zza(zzc zzc);

    public final T zzb() {
        return this.zzf;
    }

    @KeepForSdk
    @Deprecated
    public static IntegerFlag define(int i11, String str, int i12) {
        return new IntegerFlag(i11, str, Integer.valueOf(i12));
    }

    @KeepForSdk
    @Deprecated
    public static LongFlag define(int i11, String str, long j11) {
        return new LongFlag(i11, str, Long.valueOf(j11));
    }

    @KeepForSdk
    @Deprecated
    public static StringFlag define(int i11, String str, String str2) {
        return new StringFlag(i11, str, str2);
    }
}
