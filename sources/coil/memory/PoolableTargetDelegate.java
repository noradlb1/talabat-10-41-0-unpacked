package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.bitmap.BitmapReferenceCounter;
import coil.bitmap.EmptyBitmapReferenceCounter;
import coil.target.PoolableViewTarget;
import coil.util.Extensions;
import coil.util.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0019\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J0\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u001b\u0010\u0018\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u000e0\u0019¢\u0006\u0002\b\u001aH\bJ\u001c\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0016J\u0019\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcoil/memory/PoolableTargetDelegate;", "Lcoil/memory/TargetDelegate;", "target", "Lcoil/target/PoolableViewTarget;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "eventListener", "Lcoil/EventListener;", "logger", "Lcoil/util/Logger;", "(Lcoil/target/PoolableViewTarget;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/EventListener;Lcoil/util/Logger;)V", "getTarget", "()Lcoil/target/PoolableViewTarget;", "clear", "", "decrement", "bitmap", "Landroid/graphics/Bitmap;", "error", "result", "Lcoil/request/ErrorResult;", "(Lcoil/request/ErrorResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "increment", "replace", "update", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "start", "placeholder", "Landroid/graphics/drawable/Drawable;", "cached", "success", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PoolableTargetDelegate extends TargetDelegate {
    @NotNull
    private final EventListener eventListener;
    @Nullable
    private final Logger logger;
    /* access modifiers changed from: private */
    @NotNull
    public final BitmapReferenceCounter referenceCounter;
    @NotNull
    private final PoolableViewTarget<?> target;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PoolableTargetDelegate(@NotNull PoolableViewTarget<?> poolableViewTarget, @NotNull BitmapReferenceCounter bitmapReferenceCounter, @NotNull EventListener eventListener2, @Nullable Logger logger2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(poolableViewTarget, "target");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        Intrinsics.checkNotNullParameter(eventListener2, "eventListener");
        this.target = poolableViewTarget;
        this.referenceCounter = bitmapReferenceCounter;
        this.eventListener = eventListener2;
        this.logger = logger2;
    }

    /* access modifiers changed from: private */
    public final void decrement(Bitmap bitmap) {
        Bitmap put = Extensions.getRequestManager(getTarget().getView()).put(this, bitmap);
        if (put != null) {
            this.referenceCounter.decrement(put);
        }
    }

    /* access modifiers changed from: private */
    public final void increment(Bitmap bitmap) {
        if (bitmap != null) {
            this.referenceCounter.increment(bitmap);
        }
    }

    private final void replace(Bitmap bitmap, Function1<? super PoolableViewTarget<?>, Unit> function1) {
        if (this.referenceCounter instanceof EmptyBitmapReferenceCounter) {
            function1.invoke(getTarget());
            return;
        }
        increment(bitmap);
        function1.invoke(getTarget());
        decrement(bitmap);
    }

    public void clear() {
        if (this.referenceCounter instanceof EmptyBitmapReferenceCounter) {
            getTarget().onClear();
            return;
        }
        increment((Bitmap) null);
        getTarget().onClear();
        decrement((Bitmap) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object error(@org.jetbrains.annotations.NotNull coil.request.ErrorResult r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof coil.memory.PoolableTargetDelegate$error$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            coil.memory.PoolableTargetDelegate$error$1 r0 = (coil.memory.PoolableTargetDelegate$error$1) r0
            int r1 = r0.f39773m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39773m = r1
            goto L_0x0018
        L_0x0013:
            coil.memory.PoolableTargetDelegate$error$1 r0 = new coil.memory.PoolableTargetDelegate$error$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f39771k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f39773m
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004f
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r14 = r0.f39770j
            coil.EventListener r14 = (coil.EventListener) r14
            java.lang.Object r1 = r0.f39769i
            coil.memory.PoolableTargetDelegate r1 = (coil.memory.PoolableTargetDelegate) r1
            java.lang.Object r0 = r0.f39768h
            coil.request.ErrorResult r0 = (coil.request.ErrorResult) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0159
        L_0x003a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0042:
            java.lang.Object r14 = r0.f39769i
            coil.EventListener r14 = (coil.EventListener) r14
            java.lang.Object r0 = r0.f39768h
            coil.request.ErrorResult r0 = (coil.request.ErrorResult) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00d7
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r15)
            coil.bitmap.BitmapReferenceCounter r15 = r13.referenceCounter
            boolean r15 = r15 instanceof coil.bitmap.EmptyBitmapReferenceCounter
            java.lang.String r2 = "' does not implement coil.transition.TransitionTarget."
            java.lang.String r6 = "' as '"
            java.lang.String r7 = "Ignoring '"
            r8 = 3
            java.lang.String r9 = "TargetDelegate"
            if (r15 == 0) goto L_0x00e0
            coil.target.PoolableViewTarget r15 = r13.getTarget()
            coil.EventListener r3 = r13.eventListener
            coil.util.Logger r10 = r13.logger
            coil.request.ImageRequest r11 = r14.getRequest()
            coil.transition.Transition r11 = r11.getTransition()
            coil.transition.Transition r12 = coil.transition.Transition.NONE
            if (r11 != r12) goto L_0x0080
            android.graphics.drawable.Drawable r14 = r14.getDrawable()
            r15.onError(r14)
            goto L_0x0163
        L_0x0080:
            boolean r12 = r15 instanceof coil.transition.TransitionTarget
            if (r12 != 0) goto L_0x00bf
            coil.request.ImageRequest r0 = r14.getRequest()
            coil.request.DefinedRequestOptions r0 = r0.getDefined()
            coil.transition.Transition r0 = r0.getTransition()
            if (r0 == 0) goto L_0x00b6
            if (r10 != 0) goto L_0x0095
            goto L_0x00b6
        L_0x0095:
            int r0 = r10.getLevel()
            if (r0 > r8) goto L_0x00b6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r11)
            r0.append(r6)
            r0.append(r15)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r10.log(r9, r8, r0, r5)
        L_0x00b6:
            android.graphics.drawable.Drawable r14 = r14.getDrawable()
            r15.onError(r14)
            goto L_0x0163
        L_0x00bf:
            coil.request.ImageRequest r2 = r14.getRequest()
            r3.transitionStart(r2)
            coil.transition.TransitionTarget r15 = (coil.transition.TransitionTarget) r15
            r0.f39768h = r14
            r0.f39769i = r3
            r0.f39773m = r4
            java.lang.Object r15 = r11.transition(r15, r14, r0)
            if (r15 != r1) goto L_0x00d5
            return r1
        L_0x00d5:
            r0 = r14
            r14 = r3
        L_0x00d7:
            coil.request.ImageRequest r15 = r0.getRequest()
            r14.transitionEnd(r15)
            goto L_0x0163
        L_0x00e0:
            r13.increment(r5)
            coil.target.PoolableViewTarget r15 = r13.getTarget()
            coil.EventListener r4 = r13.eventListener
            coil.util.Logger r10 = r13.logger
            coil.request.ImageRequest r11 = r14.getRequest()
            coil.transition.Transition r11 = r11.getTransition()
            coil.transition.Transition r12 = coil.transition.Transition.NONE
            if (r11 != r12) goto L_0x00ff
            android.graphics.drawable.Drawable r14 = r14.getDrawable()
            r15.onError(r14)
            goto L_0x013c
        L_0x00ff:
            boolean r12 = r15 instanceof coil.transition.TransitionTarget
            if (r12 != 0) goto L_0x013e
            coil.request.ImageRequest r0 = r14.getRequest()
            coil.request.DefinedRequestOptions r0 = r0.getDefined()
            coil.transition.Transition r0 = r0.getTransition()
            if (r0 == 0) goto L_0x0135
            if (r10 != 0) goto L_0x0114
            goto L_0x0135
        L_0x0114:
            int r0 = r10.getLevel()
            if (r0 > r8) goto L_0x0135
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r11)
            r0.append(r6)
            r0.append(r15)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r10.log(r9, r8, r0, r5)
        L_0x0135:
            android.graphics.drawable.Drawable r14 = r14.getDrawable()
            r15.onError(r14)
        L_0x013c:
            r1 = r13
            goto L_0x0160
        L_0x013e:
            coil.request.ImageRequest r2 = r14.getRequest()
            r4.transitionStart(r2)
            coil.transition.TransitionTarget r15 = (coil.transition.TransitionTarget) r15
            r0.f39768h = r14
            r0.f39769i = r13
            r0.f39770j = r4
            r0.f39773m = r3
            java.lang.Object r15 = r11.transition(r15, r14, r0)
            if (r15 != r1) goto L_0x0156
            return r1
        L_0x0156:
            r1 = r13
            r0 = r14
            r14 = r4
        L_0x0159:
            coil.request.ImageRequest r15 = r0.getRequest()
            r14.transitionEnd(r15)
        L_0x0160:
            r1.decrement(r5)
        L_0x0163:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.PoolableTargetDelegate.error(coil.request.ErrorResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void start(@Nullable Drawable drawable, @Nullable Bitmap bitmap) {
        if (this.referenceCounter instanceof EmptyBitmapReferenceCounter) {
            getTarget().onStart(drawable);
            return;
        }
        increment(bitmap);
        getTarget().onStart(drawable);
        decrement(bitmap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object success(@org.jetbrains.annotations.NotNull coil.request.SuccessResult r17, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r2 instanceof coil.memory.PoolableTargetDelegate$success$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            coil.memory.PoolableTargetDelegate$success$1 r3 = (coil.memory.PoolableTargetDelegate$success$1) r3
            int r4 = r3.f39780n
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f39780n = r4
            goto L_0x001e
        L_0x0019:
            coil.memory.PoolableTargetDelegate$success$1 r3 = new coil.memory.PoolableTargetDelegate$success$1
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f39778l
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.f39780n
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L_0x005c
            if (r5 == r7) goto L_0x004d
            if (r5 != r6) goto L_0x0045
            java.lang.Object r1 = r3.f39777k
            coil.EventListener r1 = (coil.EventListener) r1
            java.lang.Object r4 = r3.f39776j
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            java.lang.Object r5 = r3.f39775i
            coil.memory.PoolableTargetDelegate r5 = (coil.memory.PoolableTargetDelegate) r5
            java.lang.Object r3 = r3.f39774h
            coil.request.SuccessResult r3 = (coil.request.SuccessResult) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r7 = r1
            r1 = r3
            goto L_0x017b
        L_0x0045:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004d:
            java.lang.Object r1 = r3.f39775i
            coil.EventListener r1 = (coil.EventListener) r1
            java.lang.Object r3 = r3.f39774h
            coil.request.SuccessResult r3 = (coil.request.SuccessResult) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r5 = r1
            r1 = r3
            goto L_0x00f7
        L_0x005c:
            kotlin.ResultKt.throwOnFailure(r2)
            android.graphics.drawable.Drawable r2 = r17.getDrawable()
            boolean r5 = r2 instanceof android.graphics.drawable.BitmapDrawable
            r8 = 0
            if (r5 == 0) goto L_0x006b
            android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2
            goto L_0x006c
        L_0x006b:
            r2 = r8
        L_0x006c:
            if (r2 != 0) goto L_0x0070
            r2 = r8
            goto L_0x0074
        L_0x0070:
            android.graphics.Bitmap r2 = r2.getBitmap()
        L_0x0074:
            coil.bitmap.BitmapReferenceCounter r5 = r16.referenceCounter
            boolean r5 = r5 instanceof coil.bitmap.EmptyBitmapReferenceCounter
            java.lang.String r9 = "' does not implement coil.transition.TransitionTarget."
            java.lang.String r10 = "' as '"
            java.lang.String r11 = "Ignoring '"
            r12 = 3
            java.lang.String r13 = "TargetDelegate"
            if (r5 == 0) goto L_0x0100
            coil.target.PoolableViewTarget r2 = r16.getTarget()
            coil.EventListener r5 = r0.eventListener
            coil.util.Logger r6 = r0.logger
            coil.request.ImageRequest r14 = r17.getRequest()
            coil.transition.Transition r14 = r14.getTransition()
            coil.transition.Transition r15 = coil.transition.Transition.NONE
            if (r14 != r15) goto L_0x00a2
            android.graphics.drawable.Drawable r1 = r17.getDrawable()
            r2.onSuccess(r1)
            goto L_0x0186
        L_0x00a2:
            boolean r15 = r2 instanceof coil.transition.TransitionTarget
            if (r15 != 0) goto L_0x00e1
            coil.request.ImageRequest r3 = r17.getRequest()
            coil.request.DefinedRequestOptions r3 = r3.getDefined()
            coil.transition.Transition r3 = r3.getTransition()
            if (r3 == 0) goto L_0x00d8
            if (r6 != 0) goto L_0x00b7
            goto L_0x00d8
        L_0x00b7:
            int r3 = r6.getLevel()
            if (r3 > r12) goto L_0x00d8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            r3.append(r14)
            r3.append(r10)
            r3.append(r2)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            r6.log(r13, r12, r3, r8)
        L_0x00d8:
            android.graphics.drawable.Drawable r1 = r17.getDrawable()
            r2.onSuccess(r1)
            goto L_0x0186
        L_0x00e1:
            coil.request.ImageRequest r6 = r17.getRequest()
            r5.transitionStart(r6)
            coil.transition.TransitionTarget r2 = (coil.transition.TransitionTarget) r2
            r3.f39774h = r1
            r3.f39775i = r5
            r3.f39780n = r7
            java.lang.Object r2 = r14.transition(r2, r1, r3)
            if (r2 != r4) goto L_0x00f7
            return r4
        L_0x00f7:
            coil.request.ImageRequest r1 = r1.getRequest()
            r5.transitionEnd(r1)
            goto L_0x0186
        L_0x0100:
            r0.increment(r2)
            coil.target.PoolableViewTarget r5 = r16.getTarget()
            coil.EventListener r7 = r0.eventListener
            coil.util.Logger r14 = r0.logger
            coil.request.ImageRequest r15 = r17.getRequest()
            coil.transition.Transition r15 = r15.getTransition()
            coil.transition.Transition r6 = coil.transition.Transition.NONE
            if (r15 != r6) goto L_0x011f
            android.graphics.drawable.Drawable r1 = r17.getDrawable()
            r5.onSuccess(r1)
            goto L_0x015c
        L_0x011f:
            boolean r6 = r5 instanceof coil.transition.TransitionTarget
            if (r6 != 0) goto L_0x015e
            coil.request.ImageRequest r3 = r17.getRequest()
            coil.request.DefinedRequestOptions r3 = r3.getDefined()
            coil.transition.Transition r3 = r3.getTransition()
            if (r3 == 0) goto L_0x0155
            if (r14 != 0) goto L_0x0134
            goto L_0x0155
        L_0x0134:
            int r3 = r14.getLevel()
            if (r3 > r12) goto L_0x0155
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            r3.append(r15)
            r3.append(r10)
            r3.append(r5)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            r14.log(r13, r12, r3, r8)
        L_0x0155:
            android.graphics.drawable.Drawable r1 = r17.getDrawable()
            r5.onSuccess(r1)
        L_0x015c:
            r5 = r0
            goto L_0x0183
        L_0x015e:
            coil.request.ImageRequest r6 = r17.getRequest()
            r7.transitionStart(r6)
            coil.transition.TransitionTarget r5 = (coil.transition.TransitionTarget) r5
            r3.f39774h = r1
            r3.f39775i = r0
            r3.f39776j = r2
            r3.f39777k = r7
            r6 = 2
            r3.f39780n = r6
            java.lang.Object r3 = r15.transition(r5, r1, r3)
            if (r3 != r4) goto L_0x0179
            return r4
        L_0x0179:
            r5 = r0
            r4 = r2
        L_0x017b:
            coil.request.ImageRequest r1 = r1.getRequest()
            r7.transitionEnd(r1)
            r2 = r4
        L_0x0183:
            r5.decrement(r2)
        L_0x0186:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.PoolableTargetDelegate.success(coil.request.SuccessResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public PoolableViewTarget<?> getTarget() {
        return this.target;
    }
}
