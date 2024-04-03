package com.google.android.recaptcha.internal;

public final class zzlo extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzlo zzb;
    private int zzd = 0;
    private Object zze;
    /* access modifiers changed from: private */
    public int zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    /* access modifiers changed from: private */
    public long zzk;
    private zzgn zzl;
    /* access modifiers changed from: private */
    public int zzm;
    /* access modifiers changed from: private */
    public zzla zzn;
    private zzma zzo;
    /* access modifiers changed from: private */
    public String zzp = "";
    private zzju zzq;
    private zzgn zzr;

    static {
        zzlo zzlo = new zzlo();
        zzb = zzlo;
        zzhf.zzC(zzlo.class, zzlo);
    }

    private zzlo() {
    }

    public static zzlo zzG() {
        return zzb;
    }

    public static /* synthetic */ void zzJ(zzlo zzlo, String str) {
        str.getClass();
        zzlo.zzi = str;
    }

    public static /* synthetic */ void zzM(zzlo zzlo, zzma zzma) {
        zzma.getClass();
        zzlo.zzo = zzma;
    }

    public static /* synthetic */ void zzP(zzlo zzlo, zzku zzku) {
        zzku.getClass();
        zzlo.zze = zzku;
        zzlo.zzd = 15;
    }

    public static /* synthetic */ void zzQ(zzlo zzlo, String str) {
        str.getClass();
        zzlo.zzg = str;
    }

    public static /* synthetic */ void zzR(zzlo zzlo, String str) {
        str.getClass();
        zzlo.zzh = str;
    }

    public static zzll zzi() {
        return (zzll) zzb.zzp();
    }

    public final String zzH() {
        return this.zzh;
    }

    public final String zzI() {
        return this.zzi;
    }

    public final boolean zzS() {
        return this.zzn != null;
    }

    public final int zzT() {
        int i11 = this.zzm;
        int i12 = 2;
        if (i11 != 0) {
            i12 = i11 != 1 ? i11 != 2 ? 0 : 4 : 3;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    @Deprecated
    public final long zzf() {
        return this.zzk;
    }

    public final zzla zzg() {
        zzla zzla = this.zzn;
        return zzla == null ? zzla.zzj() : zzla;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u000e\u0001\u0000\u0001\u000f\u000e\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003\u0003\u0004\f\u0005\t\u0006\t\u0007Ȉ\bȈ\tȈ\n\t\u000b\t\r\t\u000eȈ\u000f<\u0000", new Object[]{"zze", "zzd", "zzf", "zzh", "zzk", "zzm", "zzn", "zzo", "zzp", "zzi", "zzj", "zzl", "zzq", "zzr", "zzg", zzku.class});
        } else if (i12 == 3) {
            return new zzlo();
        } else {
            if (i12 == 4) {
                return new zzll((zzlk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzln zzj() {
        zzln zzln;
        int i11 = this.zzf;
        zzln zzln2 = zzln.UNKNOWN;
        switch (i11) {
            case 0:
                zzln = zzln.UNKNOWN;
                break;
            case 1:
                zzln = zzln.INIT_NATIVE;
                break;
            case 2:
                zzln = zzln.INIT_NETWORK;
                break;
            case 3:
                zzln = zzln.INIT_JS;
                break;
            case 4:
                zzln = zzln.INIT_TOTAL;
                break;
            case 5:
                zzln = zzln.EXECUTE_NATIVE;
                break;
            case 6:
                zzln = zzln.EXECUTE_JS;
                break;
            case 7:
                zzln = zzln.EXECUTE_TOTAL;
                break;
            case 8:
                zzln = zzln.CHALLENGE_ACCOUNT_NATIVE;
                break;
            case 9:
                zzln = zzln.CHALLENGE_ACCOUNT_JS;
                break;
            case 10:
                zzln = zzln.CHALLENGE_ACCOUNT_TOTAL;
                break;
            case 11:
                zzln = zzln.VERIFY_PIN_NATIVE;
                break;
            case 12:
                zzln = zzln.VERIFY_PIN_JS;
                break;
            case 13:
                zzln = zzln.VERIFY_PIN_TOTAL;
                break;
            case 14:
                zzln = zzln.RUN_PROGRAM;
                break;
            case 15:
                zzln = zzln.FETCH_ALLOWLIST;
                break;
            case 16:
                zzln = zzln.JS_LOAD;
                break;
            case 17:
                zzln = zzln.WEB_VIEW_RELOAD_JS;
                break;
            default:
                zzln = null;
                break;
        }
        return zzln == null ? zzln.UNRECOGNIZED : zzln;
    }
}
