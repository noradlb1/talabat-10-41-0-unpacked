package com.google.android.recaptcha.internal;

import android.webkit.WebView;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

public final class zzbb {
    /* access modifiers changed from: private */
    @NotNull
    public final WebView zza;
    @NotNull
    private final CoroutineScope zzb;

    public zzbb(@NotNull WebView webView, @NotNull CoroutineScope coroutineScope) {
        this.zza = webView;
        this.zzb = coroutineScope;
    }

    public final void zzb(@NotNull String str, @NotNull String... strArr) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.zzb, (CoroutineContext) null, (CoroutineStart) null, new zzba(strArr, this, str, (Continuation) null), 3, (Object) null);
    }
}
