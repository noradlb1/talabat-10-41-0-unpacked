package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", i = {0}, l = {391}, m = "invokeSuspend", n = {"durationScaleJob"}, s = {"L$0"})
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f10083h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> f10084i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Recomposer f10085j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f10086k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 f10087l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ View f10088m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(Ref.ObjectRef<MotionDurationScaleImpl> objectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2, View view, Continuation<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1> continuation) {
        super(2, continuation);
        this.f10084i = objectRef;
        this.f10085j = recomposer;
        this.f10086k = lifecycleOwner;
        this.f10087l = windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2;
        this.f10088m = view;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 = new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.f10084i, this.f10085j, this.f10086k, this.f10087l, this.f10088m, continuation);
        windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.L$0 = obj;
        return windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.f10083h
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r11.L$0
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0014 }
            goto L_0x006c
        L_0x0014:
            r12 = move-exception
            goto L_0x0086
        L_0x0017:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r4 = r12
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.platform.MotionDurationScaleImpl> r12 = r11.f10084i     // Catch:{ all -> 0x0084 }
            T r12 = r12.element     // Catch:{ all -> 0x0084 }
            androidx.compose.ui.platform.MotionDurationScaleImpl r12 = (androidx.compose.ui.platform.MotionDurationScaleImpl) r12     // Catch:{ all -> 0x0084 }
            if (r12 == 0) goto L_0x005d
            android.view.View r1 = r11.f10088m     // Catch:{ all -> 0x0084 }
            android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x0084 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x0084 }
            java.lang.String r5 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)     // Catch:{ all -> 0x0084 }
            kotlinx.coroutines.flow.StateFlow r1 = androidx.compose.ui.platform.WindowRecomposer_androidKt.getAnimationScaleFlowFor(r1)     // Catch:{ all -> 0x0084 }
            java.lang.Object r5 = r1.getValue()     // Catch:{ all -> 0x0084 }
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ all -> 0x0084 }
            float r5 = r5.floatValue()     // Catch:{ all -> 0x0084 }
            r12.setScaleFactor(r5)     // Catch:{ all -> 0x0084 }
            r5 = 0
            r6 = 0
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1 r7 = new androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1     // Catch:{ all -> 0x0084 }
            r7.<init>(r1, r12, r3)     // Catch:{ all -> 0x0084 }
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Job r12 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0084 }
            goto L_0x005e
        L_0x005d:
            r12 = r3
        L_0x005e:
            androidx.compose.runtime.Recomposer r1 = r11.f10085j     // Catch:{ all -> 0x007f }
            r11.L$0 = r12     // Catch:{ all -> 0x007f }
            r11.f10083h = r2     // Catch:{ all -> 0x007f }
            java.lang.Object r1 = r1.runRecomposeAndApplyChanges(r11)     // Catch:{ all -> 0x007f }
            if (r1 != r0) goto L_0x006b
            return r0
        L_0x006b:
            r0 = r12
        L_0x006c:
            if (r0 == 0) goto L_0x0071
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r0, (java.util.concurrent.CancellationException) r3, (int) r2, (java.lang.Object) r3)
        L_0x0071:
            androidx.lifecycle.LifecycleOwner r12 = r11.f10086k
            androidx.lifecycle.Lifecycle r12 = r12.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r0 = r11.f10087l
            r12.removeObserver(r0)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x007f:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L_0x0086
        L_0x0084:
            r12 = move-exception
            r0 = r3
        L_0x0086:
            if (r0 == 0) goto L_0x008b
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r0, (java.util.concurrent.CancellationException) r3, (int) r2, (java.lang.Object) r3)
        L_0x008b:
            androidx.lifecycle.LifecycleOwner r0 = r11.f10086k
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r1 = r11.f10087l
            r0.removeObserver(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
