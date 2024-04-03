package com.google.android.recaptcha.internal;

import android.content.Context;
import com.newrelic.agent.android.payload.PayloadController;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class zzao implements zzaj {
    @NotNull
    public static final zzak zza = new zzak((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static Timer zzb;
    @NotNull
    private final zzap zzc;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineScope zzd;
    /* access modifiers changed from: private */
    @NotNull
    public final zzad zze;

    public /* synthetic */ zzao(Context context, zzap zzap, CoroutineScope coroutineScope, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        CoroutineScope zza2 = zzp.zza();
        this.zzc = zzap;
        this.zzd = zza2;
        zzad zzc2 = zzad.zzc;
        zzc2 = zzc2 == null ? new zzad(context, (DefaultConstructorMarker) null) : zzc2;
        zzad.zzc = zzc2;
        this.zze = zzc2;
        zzh();
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        for (List<zzae> it : CollectionsKt___CollectionsKt.windowed(this.zze.zzd(), 20, 20, true)) {
            zzlq zzi = zzlr.zzi();
            ArrayList arrayList = new ArrayList();
            for (zzae zzae : it) {
                try {
                    zzmy zzk = zzmy.zzk(zzek.zzg().zzj(zzae.zzc()));
                    int zzH = zzk.zzH();
                    int i11 = zzH - 1;
                    if (zzH != 0) {
                        if (i11 == 0) {
                            zzi.zzp(zzk.zzf());
                        } else if (i11 == 1) {
                            zzi.zzq(zzk.zzg());
                        }
                        arrayList.add(zzae);
                    } else {
                        throw null;
                    }
                } catch (Exception unused) {
                    this.zze.zzf(zzae);
                }
            }
            if (zzi.zzd() + zzi.zze() != 0) {
                if (this.zzc.zza(((zzlr) zzi.zzj()).zzd())) {
                    this.zze.zza(arrayList);
                }
            }
        }
    }

    private final void zzh() {
        if (zzb == null) {
            Timer timer = new Timer();
            zzb = timer;
            timer.schedule(new zzal(this), PayloadController.PAYLOAD_REQUEUE_PERIOD_MS, PayloadController.PAYLOAD_REQUEUE_PERIOD_MS);
        }
    }

    public final void zzf(@NotNull zzmy zzmy) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.zzd, (CoroutineContext) null, (CoroutineStart) null, new zzan(zzmy, this, (Continuation) null), 3, (Object) null);
        zzh();
    }
}
