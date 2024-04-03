package coil.transition;

import coil.annotation.ExperimentalCoilApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0002B\u0011\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcoil/transition/CrossfadeTransition;", "Lcoil/transition/Transition;", "()V", "durationMillis", "", "(I)V", "preferExactIntrinsicSize", "", "(IZ)V", "getDurationMillis", "()I", "getPreferExactIntrinsicSize", "()Z", "equals", "other", "", "hashCode", "toString", "", "transition", "", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ExperimentalCoilApi
public final class CrossfadeTransition implements Transition {
    private final int durationMillis;
    private final boolean preferExactIntrinsicSize;

    public CrossfadeTransition(int i11, boolean z11) {
        this.durationMillis = i11;
        this.preferExactIntrinsicSize = z11;
        if (!(i11 > 0)) {
            throw new IllegalArgumentException("durationMillis must be > 0.".toString());
        }
    }

    public boolean equals(@Nullable Object obj) {
        return this == obj || ((obj instanceof CrossfadeTransition) && this.durationMillis == ((CrossfadeTransition) obj).durationMillis);
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    public int hashCode() {
        return this.durationMillis;
    }

    @NotNull
    public String toString() {
        return "CrossfadeTransition(durationMillis=" + this.durationMillis + ')';
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object transition(@org.jetbrains.annotations.NotNull coil.transition.TransitionTarget r13, @org.jetbrains.annotations.NotNull coil.request.ImageResult r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof coil.transition.CrossfadeTransition$transition$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            coil.transition.CrossfadeTransition$transition$1 r0 = (coil.transition.CrossfadeTransition$transition$1) r0
            int r1 = r0.f39811n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39811n = r1
            goto L_0x0018
        L_0x0013:
            coil.transition.CrossfadeTransition$transition$1 r0 = new coil.transition.CrossfadeTransition$transition$1
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f39809l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f39811n
            r3 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r13 = r0.f39808k
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r0.f39807j
            coil.request.ImageResult r14 = (coil.request.ImageResult) r14
            java.lang.Object r14 = r0.f39806i
            coil.transition.TransitionTarget r14 = (coil.transition.TransitionTarget) r14
            java.lang.Object r14 = r0.f39805h
            coil.transition.CrossfadeTransition r14 = (coil.transition.CrossfadeTransition) r14
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x003a }
            goto L_0x0112
        L_0x003a:
            r14 = move-exception
            goto L_0x0117
        L_0x003d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r15)
            boolean r15 = r14 instanceof coil.request.SuccessResult
            if (r15 == 0) goto L_0x0065
            r2 = r14
            coil.request.SuccessResult r2 = (coil.request.SuccessResult) r2
            coil.request.ImageResult$Metadata r4 = r2.getMetadata()
            coil.decode.DataSource r4 = r4.getDataSource()
            coil.decode.DataSource r5 = coil.decode.DataSource.MEMORY_CACHE
            if (r4 != r5) goto L_0x0065
            android.graphics.drawable.Drawable r14 = r2.getDrawable()
            r13.onSuccess(r14)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0065:
            android.view.View r2 = r13.getView()
            boolean r2 = r2.isShown()
            if (r2 != 0) goto L_0x0089
            if (r15 == 0) goto L_0x007b
            coil.request.SuccessResult r14 = (coil.request.SuccessResult) r14
            android.graphics.drawable.Drawable r14 = r14.getDrawable()
            r13.onSuccess(r14)
            goto L_0x0086
        L_0x007b:
            boolean r15 = r14 instanceof coil.request.ErrorResult
            if (r15 == 0) goto L_0x0086
            android.graphics.drawable.Drawable r14 = r14.getDrawable()
            r13.onError(r14)
        L_0x0086:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0089:
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            r0.f39805h = r12     // Catch:{ all -> 0x0115 }
            r0.f39806i = r13     // Catch:{ all -> 0x0115 }
            r0.f39807j = r14     // Catch:{ all -> 0x0115 }
            r0.f39808k = r15     // Catch:{ all -> 0x0115 }
            r0.f39811n = r3     // Catch:{ all -> 0x0115 }
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x0115 }
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)     // Catch:{ all -> 0x0115 }
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0115 }
            r2.initCancellability()     // Catch:{ all -> 0x0115 }
            coil.drawable.CrossfadeDrawable r4 = new coil.drawable.CrossfadeDrawable     // Catch:{ all -> 0x0115 }
            android.graphics.drawable.Drawable r6 = r13.getDrawable()     // Catch:{ all -> 0x0115 }
            android.graphics.drawable.Drawable r7 = r14.getDrawable()     // Catch:{ all -> 0x0115 }
            android.view.View r5 = r13.getView()     // Catch:{ all -> 0x0115 }
            boolean r8 = r5 instanceof android.widget.ImageView     // Catch:{ all -> 0x0115 }
            r9 = 0
            if (r8 == 0) goto L_0x00ba
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch:{ all -> 0x0115 }
            goto L_0x00bb
        L_0x00ba:
            r5 = r9
        L_0x00bb:
            if (r5 != 0) goto L_0x00be
            goto L_0x00c2
        L_0x00be:
            coil.size.Scale r9 = coil.util.Extensions.getScale(r5)     // Catch:{ all -> 0x0115 }
        L_0x00c2:
            if (r9 != 0) goto L_0x00c8
            coil.size.Scale r5 = coil.size.Scale.FILL     // Catch:{ all -> 0x0115 }
            r8 = r5
            goto L_0x00c9
        L_0x00c8:
            r8 = r9
        L_0x00c9:
            int r9 = r12.getDurationMillis()     // Catch:{ all -> 0x0115 }
            boolean r5 = r14 instanceof coil.request.SuccessResult     // Catch:{ all -> 0x0115 }
            if (r5 == 0) goto L_0x00e0
            r5 = r14
            coil.request.SuccessResult r5 = (coil.request.SuccessResult) r5     // Catch:{ all -> 0x0115 }
            coil.request.ImageResult$Metadata r5 = r5.getMetadata()     // Catch:{ all -> 0x0115 }
            boolean r5 = r5.isPlaceholderMemoryCacheKeyPresent()     // Catch:{ all -> 0x0115 }
            if (r5 != 0) goto L_0x00df
            goto L_0x00e0
        L_0x00df:
            r3 = 0
        L_0x00e0:
            r10 = r3
            boolean r11 = r12.getPreferExactIntrinsicSize()     // Catch:{ all -> 0x0115 }
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0115 }
            r15.element = r4     // Catch:{ all -> 0x0115 }
            coil.transition.CrossfadeTransition$transition$2$1 r3 = new coil.transition.CrossfadeTransition$transition$2$1     // Catch:{ all -> 0x0115 }
            r3.<init>(r4, r2)     // Catch:{ all -> 0x0115 }
            r4.registerAnimationCallback(r3)     // Catch:{ all -> 0x0115 }
            boolean r3 = r14 instanceof coil.request.SuccessResult     // Catch:{ all -> 0x0115 }
            if (r3 == 0) goto L_0x00fb
            r13.onSuccess(r4)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00fb:
            boolean r14 = r14 instanceof coil.request.ErrorResult     // Catch:{ all -> 0x0115 }
            if (r14 == 0) goto L_0x0102
            r13.onError(r4)     // Catch:{ all -> 0x0115 }
        L_0x0102:
            java.lang.Object r13 = r2.getResult()     // Catch:{ all -> 0x0115 }
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x0115 }
            if (r13 != r14) goto L_0x010f
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x0115 }
        L_0x010f:
            if (r13 != r1) goto L_0x0112
            return r1
        L_0x0112:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0115:
            r14 = move-exception
            r13 = r15
        L_0x0117:
            T r13 = r13.element
            coil.drawable.CrossfadeDrawable r13 = (coil.drawable.CrossfadeDrawable) r13
            if (r13 != 0) goto L_0x011e
            goto L_0x0121
        L_0x011e:
            r13.stop()
        L_0x0121:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.transition.CrossfadeTransition.transition(coil.transition.TransitionTarget, coil.request.ImageResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CrossfadeTransition(int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 100 : i11, (i12 & 2) != 0 ? false : z11);
    }

    @SinceKotlin(version = "999.9")
    public CrossfadeTransition() {
        this(0, false, 3, (DefaultConstructorMarker) null);
    }

    @SinceKotlin(version = "999.9")
    public CrossfadeTransition(int i11) {
        this(i11, false, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CrossfadeTransition(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 100 : i11);
    }
}
