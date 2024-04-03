package com.google.android.recaptcha.internal;

import android.webkit.JavascriptInterface;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class zzdc {
    final /* synthetic */ zzdi zza;
    @Nullable
    private Long zzb;
    @NotNull
    private final zzdt zzc = zzdt.zzb();

    public zzdc(zzdi zzdi) {
        this.zza = zzdi;
    }

    private final void zzb() {
        if (this.zzb == null) {
            this.zzc.zzf();
            this.zzb = Long.valueOf(this.zzc.zza(TimeUnit.MILLISECONDS));
        }
    }

    @Nullable
    public final Long zza() {
        return this.zzb;
    }

    @JavascriptInterface
    public final void zzoed(@NotNull String str) {
        zzb();
        zzmq zzg = zzmq.zzg(zzek.zzh().zzj(str));
        zzg.zzi().name();
        zzg.zzk();
        CancellableContinuation cancellableContinuation = (CancellableContinuation) this.zza.zzk.remove(zzg.zzj());
        String zzk = zzg.zzk();
        if (zzk == null || zzk.length() == 0) {
            zzg.zzi().name();
            zzg zzg2 = zzh.zza;
            zzh zza2 = zzg.zza(zzg.zzi());
            zzg.zzj();
            if (cancellableContinuation != null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(zza2)));
            }
        } else if (cancellableContinuation != null) {
            cancellableContinuation.resumeWith(Result.m6329constructorimpl(zzg.zzk()));
        }
    }

    @JavascriptInterface
    public final void zzoid(@NotNull String str) {
        zzb();
        zzmu zzg = zzmu.zzg(zzek.zzh().zzj(str));
        zzg.zzi().name();
        if (zzg.zzi() == zzmw.JS_CODE_SUCCESS) {
            this.zza.zzm().hashCode();
            if (!this.zza.zzm().complete(Unit.INSTANCE)) {
                this.zza.zzm().hashCode();
                return;
            }
            return;
        }
        zzg.zzi().name();
        zzg zzg2 = zzh.zza;
        zzh zza2 = zzg.zza(zzg.zzi());
        this.zza.zzm().hashCode();
        this.zza.zzm().completeExceptionally(zza2);
    }

    @JavascriptInterface
    public final void zzrp(@NotNull String str) {
        zzb();
        this.zza.zzd().zza(str);
    }
}
