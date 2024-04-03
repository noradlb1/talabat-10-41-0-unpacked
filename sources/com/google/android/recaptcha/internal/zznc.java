package com.google.android.recaptcha.internal;

public final class zznc extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zznc zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;
    private int zzg;
    private zzmo zzh;
    private int zzi;
    private zzml zzj;

    static {
        zznc zznc = new zznc();
        zzb = zznc;
        zzhf.zzC(zznc.class, zznc);
    }

    private zznc() {
    }

    public static /* synthetic */ void zzG(zznc zznc, int i11) {
        if (i11 != 1) {
            zznc.zzd = i11 - 2;
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static /* synthetic */ void zzH(zznc zznc, int i11) {
        if (i11 != 1) {
            zznc.zzf = i11 - 2;
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zznb zzf() {
        return (zznb) zzb.zzp();
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\f\u0002\u000b\u0003\f\u0004\f\u0005\t\u0006\u000b\u0007\t", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i12 == 3) {
            return new zznc();
        } else {
            if (i12 == 4) {
                return new zznb((zzmm) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final int zzj() {
        int i11;
        switch (this.zzf) {
            case 0:
                i11 = 2;
                break;
            case 1:
                i11 = 3;
                break;
            case 2:
                i11 = 4;
                break;
            case 3:
                i11 = 5;
                break;
            case 4:
                i11 = 6;
                break;
            case 5:
                i11 = 7;
                break;
            case 6:
                i11 = 8;
                break;
            case 7:
                i11 = 9;
                break;
            case 8:
                i11 = 10;
                break;
            case 9:
                i11 = 11;
                break;
            case 10:
                i11 = 12;
                break;
            case 11:
                i11 = 13;
                break;
            case 12:
                i11 = 14;
                break;
            case 13:
                i11 = 15;
                break;
            case 14:
                i11 = 16;
                break;
            case 15:
                i11 = 17;
                break;
            case 16:
                i11 = 18;
                break;
            case 17:
                i11 = 19;
                break;
            case 18:
                i11 = 20;
                break;
            case 19:
                i11 = 21;
                break;
            case 20:
                i11 = 22;
                break;
            case 21:
                i11 = 23;
                break;
            case 22:
                i11 = 24;
                break;
            case 23:
                i11 = 25;
                break;
            case 24:
                i11 = 26;
                break;
            case 25:
                i11 = 27;
                break;
            case 26:
                i11 = 28;
                break;
            case 27:
                i11 = 29;
                break;
            case 28:
                i11 = 30;
                break;
            case 29:
                i11 = 31;
                break;
            case 30:
                i11 = 32;
                break;
            case 31:
                i11 = 33;
                break;
            case 32:
                i11 = 34;
                break;
            case 33:
                i11 = 35;
                break;
            case 34:
                i11 = 36;
                break;
            case 35:
                i11 = 37;
                break;
            case 36:
                i11 = 38;
                break;
            case 37:
                i11 = 39;
                break;
            case 38:
                i11 = 40;
                break;
            case 39:
                i11 = 41;
                break;
            case 40:
                i11 = 42;
                break;
            case 41:
                i11 = 43;
                break;
            case 42:
                i11 = 44;
                break;
            case 43:
                i11 = 45;
                break;
            case 44:
                i11 = 46;
                break;
            case 45:
                i11 = 47;
                break;
            case 46:
                i11 = 48;
                break;
            case 47:
                i11 = 49;
                break;
            default:
                i11 = 0;
                break;
        }
        if (i11 == 0) {
            return 1;
        }
        return i11;
    }

    public final int zzk() {
        int i11;
        switch (this.zzd) {
            case 0:
                i11 = 2;
                break;
            case 1:
                i11 = 3;
                break;
            case 2:
                i11 = 4;
                break;
            case 3:
                i11 = 5;
                break;
            case 4:
                i11 = 6;
                break;
            case 5:
                i11 = 7;
                break;
            case 6:
                i11 = 8;
                break;
            case 7:
                i11 = 9;
                break;
            case 8:
                i11 = 10;
                break;
            case 9:
                i11 = 11;
                break;
            case 10:
                i11 = 12;
                break;
            case 11:
                i11 = 13;
                break;
            default:
                i11 = 0;
                break;
        }
        if (i11 == 0) {
            return 1;
        }
        return i11;
    }
}
