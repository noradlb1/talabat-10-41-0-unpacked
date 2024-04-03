package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaErrorCode;
import com.google.android.recaptcha.RecaptchaException;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class zzh extends Exception {
    @NotNull
    public static final zzg zza = new zzg((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Map zzb;
    @NotNull
    private final zzf zzc;
    @NotNull
    private final zzd zzd;
    @NotNull
    private final Map zze = MapsKt__MapsKt.mapOf(TuplesKt.to(zzf.zze, new RecaptchaException(RecaptchaErrorCode.NETWORK_ERROR, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzf.zzf, new RecaptchaException(RecaptchaErrorCode.INVALID_SITEKEY, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzf.zzg, new RecaptchaException(RecaptchaErrorCode.INVALID_KEYTYPE, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzf.zzh, new RecaptchaException(RecaptchaErrorCode.INVALID_PACKAGE_NAME, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzf.zzi, new RecaptchaException(RecaptchaErrorCode.INVALID_ACTION, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzf.zzc, new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, (String) null, 2, (DefaultConstructorMarker) null)));

    static {
        zzmw zzmw = zzmw.JS_INTERNAL_ERROR;
        zzf zzf = zzf.zzc;
        zzb = MapsKt__MapsKt.mapOf(TuplesKt.to(zzmw.JS_NETWORK_ERROR, new zzh(zzf.zze, zzd.zzm)), TuplesKt.to(zzmw, new zzh(zzf, zzd.zzk)), TuplesKt.to(zzmw.JS_INVALID_SITE_KEY, new zzh(zzf.zzf, zzd.zzn)), TuplesKt.to(zzmw.JS_INVALID_SITE_KEY_TYPE, new zzh(zzf.zzg, zzd.zzo)), TuplesKt.to(zzmw.JS_THIRD_PARTY_APP_PACKAGE_NAME_NOT_ALLOWED, new zzh(zzf.zzh, zzd.zzp)), TuplesKt.to(zzmw.JS_INVALID_ACTION, new zzh(zzf.zzi, zzd.zzq)), TuplesKt.to(zzmw.JS_PROGRAM_ERROR, new zzh(zzf, zzd.zzv)));
    }

    public zzh(@NotNull zzf zzf, @NotNull zzd zzd2) {
        this.zzc = zzf;
        this.zzd = zzd2;
    }

    @NotNull
    public final zzd zza() {
        return this.zzd;
    }

    @NotNull
    public final zzf zzb() {
        return this.zzc;
    }

    @NotNull
    public final RecaptchaException zzc() {
        RecaptchaException recaptchaException = (RecaptchaException) this.zze.get(this.zzc);
        if (recaptchaException == null) {
            return new RecaptchaException(RecaptchaErrorCode.UNKNOWN_ERROR, (String) null, 2, (DefaultConstructorMarker) null);
        }
        return recaptchaException;
    }
}
