package com.talabat.core.safety.data.datasource.api.playintegrity;

import android.content.Context;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.safety.data.datasource.api.SafetyApi;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/core/safety/data/datasource/api/playintegrity/PlayIntegrityApi;", "Lcom/talabat/core/safety/data/datasource/api/SafetyApi;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "integrityManager", "Lcom/google/android/play/core/integrity/IntegrityManager;", "performSafetyRequest", "", "nonce", "googleApiKey", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlayIntegrityApi implements SafetyApi {
    @NotNull
    private final Context context;
    @NotNull
    private final IntegrityManager integrityManager;

    @Inject
    public PlayIntegrityApi(@NotNull @ApplicationContext Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        IntegrityManager create = IntegrityManagerFactory.create(context2);
        Intrinsics.checkNotNullExpressionValue(create, "create(context)");
        this.integrityManager = create;
    }

    @Nullable
    public Object performSafetyRequest(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super String> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.integrityManager.requestIntegrityToken(IntegrityTokenRequest.builder().setNonce(str).build()).addOnSuccessListener(new PlayIntegrityApi$performSafetyRequest$2$1(safeContinuation)).addOnFailureListener(new PlayIntegrityApi$performSafetyRequest$2$2(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
