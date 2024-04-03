package com.google.android.libraries.places.internal;

public final class zzwo extends zzabs<zzwo, zzwn> implements zzada {
    /* access modifiers changed from: private */
    public static final zzwo zzb;
    private int zze;
    private zzabz<String> zzf = zzabs.zzB();
    private int zzg;
    private int zzh;
    private zzxn zzi;

    static {
        zzwo zzwo = new zzwo();
        zzb = zzwo;
        zzabs.zzG(zzwo.class, zzwo);
    }

    private zzwo() {
    }

    public static zzwn zza() {
        return (zzwn) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzwo zzwo, int i11) {
        zzwo.zze |= 2;
        zzwo.zzh = 1;
    }

    public static /* synthetic */ void zze(zzwo zzwo, zzxn zzxn) {
        zzxn.getClass();
        zzwo.zzi = zzxn;
        zzwo.zze |= 4;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001a\u0002ဌ\u0000\u0003ဋ\u0001\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", zzuk.zza, "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzwo();
        } else {
            if (i12 == 4) {
                return new zzwn((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
