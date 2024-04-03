package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.bitmap.BitmapReferenceCounter;
import coil.target.Target;
import coil.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0019\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcoil/memory/InvalidatableTargetDelegate;", "Lcoil/memory/TargetDelegate;", "target", "Lcoil/target/Target;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "eventListener", "Lcoil/EventListener;", "logger", "Lcoil/util/Logger;", "(Lcoil/target/Target;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/EventListener;Lcoil/util/Logger;)V", "getTarget", "()Lcoil/target/Target;", "error", "", "result", "Lcoil/request/ErrorResult;", "(Lcoil/request/ErrorResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "placeholder", "Landroid/graphics/drawable/Drawable;", "cached", "Landroid/graphics/Bitmap;", "success", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InvalidatableTargetDelegate extends TargetDelegate {
    @NotNull
    private final EventListener eventListener;
    @Nullable
    private final Logger logger;
    @NotNull
    private final BitmapReferenceCounter referenceCounter;
    @NotNull
    private final Target target;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidatableTargetDelegate(@NotNull Target target2, @NotNull BitmapReferenceCounter bitmapReferenceCounter, @NotNull EventListener eventListener2, @Nullable Logger logger2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(target2, "target");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        Intrinsics.checkNotNullParameter(eventListener2, "eventListener");
        this.target = target2;
        this.referenceCounter = bitmapReferenceCounter;
        this.eventListener = eventListener2;
        this.logger = logger2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object error(@org.jetbrains.annotations.NotNull coil.request.ErrorResult r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof coil.memory.InvalidatableTargetDelegate$error$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            coil.memory.InvalidatableTargetDelegate$error$1 r0 = (coil.memory.InvalidatableTargetDelegate$error$1) r0
            int r1 = r0.f39762l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39762l = r1
            goto L_0x0018
        L_0x0013:
            coil.memory.InvalidatableTargetDelegate$error$1 r0 = new coil.memory.InvalidatableTargetDelegate$error$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f39760j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f39762l
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r8 = r0.f39759i
            coil.EventListener r8 = (coil.EventListener) r8
            java.lang.Object r0 = r0.f39758h
            coil.request.ErrorResult r0 = (coil.request.ErrorResult) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00b9
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r9)
            coil.target.Target r9 = r7.getTarget()
            coil.EventListener r2 = r7.eventListener
            coil.util.Logger r4 = r7.logger
            coil.request.ImageRequest r5 = r8.getRequest()
            coil.transition.Transition r5 = r5.getTransition()
            coil.transition.Transition r6 = coil.transition.Transition.NONE
            if (r5 != r6) goto L_0x0059
            android.graphics.drawable.Drawable r8 = r8.getDrawable()
            r9.onError(r8)
            goto L_0x00c0
        L_0x0059:
            boolean r6 = r9 instanceof coil.transition.TransitionTarget
            if (r6 != 0) goto L_0x00a1
            coil.request.ImageRequest r0 = r8.getRequest()
            coil.request.DefinedRequestOptions r0 = r0.getDefined()
            coil.transition.Transition r0 = r0.getTransition()
            if (r0 == 0) goto L_0x0099
            if (r4 != 0) goto L_0x006e
            goto L_0x0099
        L_0x006e:
            int r0 = r4.getLevel()
            r1 = 3
            if (r0 > r1) goto L_0x0099
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Ignoring '"
            r0.append(r2)
            r0.append(r5)
            java.lang.String r2 = "' as '"
            r0.append(r2)
            r0.append(r9)
            java.lang.String r2 = "' does not implement coil.transition.TransitionTarget."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 0
            java.lang.String r3 = "TargetDelegate"
            r4.log(r3, r1, r0, r2)
        L_0x0099:
            android.graphics.drawable.Drawable r8 = r8.getDrawable()
            r9.onError(r8)
            goto L_0x00c0
        L_0x00a1:
            coil.request.ImageRequest r4 = r8.getRequest()
            r2.transitionStart(r4)
            coil.transition.TransitionTarget r9 = (coil.transition.TransitionTarget) r9
            r0.f39758h = r8
            r0.f39759i = r2
            r0.f39762l = r3
            java.lang.Object r9 = r5.transition(r9, r8, r0)
            if (r9 != r1) goto L_0x00b7
            return r1
        L_0x00b7:
            r0 = r8
            r8 = r2
        L_0x00b9:
            coil.request.ImageRequest r9 = r0.getRequest()
            r8.transitionEnd(r9)
        L_0x00c0:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.InvalidatableTargetDelegate.error(coil.request.ErrorResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public Target getTarget() {
        return this.target;
    }

    public void start(@Nullable Drawable drawable, @Nullable Bitmap bitmap) {
        BitmapReferenceCounter bitmapReferenceCounter = this.referenceCounter;
        if (bitmap != null) {
            bitmapReferenceCounter.setValid(bitmap, false);
        }
        getTarget().onStart(drawable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object success(@org.jetbrains.annotations.NotNull coil.request.SuccessResult r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof coil.memory.InvalidatableTargetDelegate$success$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            coil.memory.InvalidatableTargetDelegate$success$1 r0 = (coil.memory.InvalidatableTargetDelegate$success$1) r0
            int r1 = r0.f39767l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39767l = r1
            goto L_0x0018
        L_0x0013:
            coil.memory.InvalidatableTargetDelegate$success$1 r0 = new coil.memory.InvalidatableTargetDelegate$success$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f39765j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f39767l
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r9 = r0.f39764i
            coil.EventListener r9 = (coil.EventListener) r9
            java.lang.Object r0 = r0.f39763h
            coil.request.SuccessResult r0 = (coil.request.SuccessResult) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00d5
        L_0x0032:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r10)
            coil.bitmap.BitmapReferenceCounter r10 = r8.referenceCounter
            android.graphics.drawable.Drawable r2 = r9.getDrawable()
            boolean r4 = r2 instanceof android.graphics.drawable.BitmapDrawable
            r5 = 0
            if (r4 == 0) goto L_0x004b
            android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2
            goto L_0x004c
        L_0x004b:
            r2 = r5
        L_0x004c:
            if (r2 != 0) goto L_0x0050
            r2 = r5
            goto L_0x0054
        L_0x0050:
            android.graphics.Bitmap r2 = r2.getBitmap()
        L_0x0054:
            if (r2 == 0) goto L_0x005a
            r4 = 0
            r10.setValid(r2, r4)
        L_0x005a:
            coil.target.Target r10 = r8.getTarget()
            coil.EventListener r2 = r8.eventListener
            coil.util.Logger r4 = r8.logger
            coil.request.ImageRequest r6 = r9.getRequest()
            coil.transition.Transition r6 = r6.getTransition()
            coil.transition.Transition r7 = coil.transition.Transition.NONE
            if (r6 != r7) goto L_0x0076
            android.graphics.drawable.Drawable r9 = r9.getDrawable()
            r10.onSuccess(r9)
            goto L_0x00dc
        L_0x0076:
            boolean r7 = r10 instanceof coil.transition.TransitionTarget
            if (r7 != 0) goto L_0x00bd
            coil.request.ImageRequest r0 = r9.getRequest()
            coil.request.DefinedRequestOptions r0 = r0.getDefined()
            coil.transition.Transition r0 = r0.getTransition()
            if (r0 == 0) goto L_0x00b5
            if (r4 != 0) goto L_0x008b
            goto L_0x00b5
        L_0x008b:
            int r0 = r4.getLevel()
            r1 = 3
            if (r0 > r1) goto L_0x00b5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Ignoring '"
            r0.append(r2)
            r0.append(r6)
            java.lang.String r2 = "' as '"
            r0.append(r2)
            r0.append(r10)
            java.lang.String r2 = "' does not implement coil.transition.TransitionTarget."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "TargetDelegate"
            r4.log(r2, r1, r0, r5)
        L_0x00b5:
            android.graphics.drawable.Drawable r9 = r9.getDrawable()
            r10.onSuccess(r9)
            goto L_0x00dc
        L_0x00bd:
            coil.request.ImageRequest r4 = r9.getRequest()
            r2.transitionStart(r4)
            coil.transition.TransitionTarget r10 = (coil.transition.TransitionTarget) r10
            r0.f39763h = r9
            r0.f39764i = r2
            r0.f39767l = r3
            java.lang.Object r10 = r6.transition(r10, r9, r0)
            if (r10 != r1) goto L_0x00d3
            return r1
        L_0x00d3:
            r0 = r9
            r9 = r2
        L_0x00d5:
            coil.request.ImageRequest r10 = r0.getRequest()
            r9.transitionEnd(r10)
        L_0x00dc:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.InvalidatableTargetDelegate.success(coil.request.SuccessResult, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
