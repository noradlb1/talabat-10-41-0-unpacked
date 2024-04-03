package com.airbnb.lottie.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010 \u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005H\u0000¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020#2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b'R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@RX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000f\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00108VX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00108VX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0016\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u00108VX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0018\u0010\u0011R/\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00058V@RX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionResultImpl;", "Lcom/airbnb/lottie/compose/LottieCompositionResult;", "()V", "compositionDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/airbnb/lottie/LottieComposition;", "<set-?>", "", "error", "getError", "()Ljava/lang/Throwable;", "setError", "(Ljava/lang/Throwable;)V", "error$delegate", "Landroidx/compose/runtime/MutableState;", "isComplete", "", "()Z", "isComplete$delegate", "Landroidx/compose/runtime/State;", "isFailure", "isFailure$delegate", "isLoading", "isLoading$delegate", "isSuccess", "isSuccess$delegate", "value", "getValue", "()Lcom/airbnb/lottie/LottieComposition;", "setValue", "(Lcom/airbnb/lottie/LottieComposition;)V", "value$delegate", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "", "composition", "complete$lottie_compose_release", "completeExceptionally", "completeExceptionally$lottie_compose_release", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Stable
public final class LottieCompositionResultImpl implements LottieCompositionResult {
    @NotNull
    private final CompletableDeferred<LottieComposition> compositionDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    @NotNull
    private final MutableState error$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final State isComplete$delegate = SnapshotStateKt.derivedStateOf(new LottieCompositionResultImpl$isComplete$2(this));
    @NotNull
    private final State isFailure$delegate = SnapshotStateKt.derivedStateOf(new LottieCompositionResultImpl$isFailure$2(this));
    @NotNull
    private final State isLoading$delegate = SnapshotStateKt.derivedStateOf(new LottieCompositionResultImpl$isLoading$2(this));
    @NotNull
    private final State isSuccess$delegate = SnapshotStateKt.derivedStateOf(new LottieCompositionResultImpl$isSuccess$2(this));
    @NotNull
    private final MutableState value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    private void setError(Throwable th2) {
        this.error$delegate.setValue(th2);
    }

    private void setValue(LottieComposition lottieComposition) {
        this.value$delegate.setValue(lottieComposition);
    }

    @Nullable
    public Object await(@NotNull Continuation<? super LottieComposition> continuation) {
        return this.compositionDeferred.await(continuation);
    }

    public final synchronized void complete$lottie_compose_release(@NotNull LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(lottieComposition, "composition");
        if (!isComplete()) {
            setValue(lottieComposition);
            this.compositionDeferred.complete(lottieComposition);
        }
    }

    public final synchronized void completeExceptionally$lottie_compose_release(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "error");
        if (!isComplete()) {
            setError(th2);
            this.compositionDeferred.completeExceptionally(th2);
        }
    }

    @Nullable
    public Throwable getError() {
        return (Throwable) this.error$delegate.getValue();
    }

    public boolean isComplete() {
        return ((Boolean) this.isComplete$delegate.getValue()).booleanValue();
    }

    public boolean isFailure() {
        return ((Boolean) this.isFailure$delegate.getValue()).booleanValue();
    }

    public boolean isLoading() {
        return ((Boolean) this.isLoading$delegate.getValue()).booleanValue();
    }

    public boolean isSuccess() {
        return ((Boolean) this.isSuccess$delegate.getValue()).booleanValue();
    }

    @Nullable
    public LottieComposition getValue() {
        return (LottieComposition) this.value$delegate.getValue();
    }
}
