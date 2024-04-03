package com.talabat.core.safety.data.datasource.api.playintegrity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "attestationResponse", "Lcom/google/android/play/core/integrity/IntegrityTokenResponse;", "kotlin.jvm.PlatformType", "onSuccess"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PlayIntegrityApi$performSafetyRequest$2$1<TResult> implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Continuation<String> f55965a;

    public PlayIntegrityApi$performSafetyRequest$2$1(Continuation<? super String> continuation) {
        this.f55965a = continuation;
    }

    public final void onSuccess(IntegrityTokenResponse integrityTokenResponse) {
        Continuation<String> continuation = this.f55965a;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(integrityTokenResponse != null ? integrityTokenResponse.token() : null));
    }
}
