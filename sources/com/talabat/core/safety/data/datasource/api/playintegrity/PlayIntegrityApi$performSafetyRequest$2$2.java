package com.talabat.core.safety.data.datasource.api.playintegrity;

import com.google.android.gms.tasks.OnFailureListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "exception", "Ljava/lang/Exception;", "onFailure"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PlayIntegrityApi$performSafetyRequest$2$2 implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Continuation<String> f55966a;

    public PlayIntegrityApi$performSafetyRequest$2$2(Continuation<? super String> continuation) {
        this.f55966a = continuation;
    }

    public final void onFailure(@NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "exception");
        Continuation<String> continuation = this.f55966a;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(exc)));
    }
}
