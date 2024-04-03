package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1", f = "WindowRecomposer.android.kt", i = {0, 1}, l = {116, 122}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
public final class WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f10093h;

    /* renamed from: i  reason: collision with root package name */
    public int f10094i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ContentResolver f10095j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Uri f10096k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 f10097l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Channel<Unit> f10098m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Context f10099n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(ContentResolver contentResolver, Uri uri, WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1, Channel<Unit> channel, Context context, Continuation<? super WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1> continuation) {
        super(2, continuation);
        this.f10095j = contentResolver;
        this.f10096k = uri;
        this.f10097l = windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1;
        this.f10098m = channel;
        this.f10099n = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(this.f10095j, this.f10096k, this.f10097l, this.f10098m, this.f10099n, continuation);
        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$0 = obj;
        return windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Float> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A[Catch:{ all -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[Catch:{ all -> 0x008f }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f10094i
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r1 = r9.f10093h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0091 }
            r10 = r4
            goto L_0x0048
        L_0x001b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0023:
            java.lang.Object r1 = r9.f10093h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0091 }
            r5 = r4
            r4 = r9
            goto L_0x0059
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            android.content.ContentResolver r1 = r9.f10095j
            android.net.Uri r4 = r9.f10096k
            r5 = 0
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r6 = r9.f10097l
            r1.registerContentObserver(r4, r5, r6)
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r1 = r9.f10098m     // Catch:{ all -> 0x0091 }
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()     // Catch:{ all -> 0x0091 }
        L_0x0048:
            r4 = r9
        L_0x0049:
            r4.L$0 = r10     // Catch:{ all -> 0x008f }
            r4.f10093h = r1     // Catch:{ all -> 0x008f }
            r4.f10094i = r3     // Catch:{ all -> 0x008f }
            java.lang.Object r5 = r1.hasNext(r4)     // Catch:{ all -> 0x008f }
            if (r5 != r0) goto L_0x0056
            return r0
        L_0x0056:
            r8 = r5
            r5 = r10
            r10 = r8
        L_0x0059:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x008f }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x008f }
            if (r10 == 0) goto L_0x0085
            r1.next()     // Catch:{ all -> 0x008f }
            android.content.Context r10 = r4.f10099n     // Catch:{ all -> 0x008f }
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ all -> 0x008f }
            java.lang.String r6 = "animator_duration_scale"
            r7 = 1065353216(0x3f800000, float:1.0)
            float r10 = android.provider.Settings.Global.getFloat(r10, r6, r7)     // Catch:{ all -> 0x008f }
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)     // Catch:{ all -> 0x008f }
            r4.L$0 = r5     // Catch:{ all -> 0x008f }
            r4.f10093h = r1     // Catch:{ all -> 0x008f }
            r4.f10094i = r2     // Catch:{ all -> 0x008f }
            java.lang.Object r10 = r5.emit(r10, r4)     // Catch:{ all -> 0x008f }
            if (r10 != r0) goto L_0x0083
            return r0
        L_0x0083:
            r10 = r5
            goto L_0x0049
        L_0x0085:
            android.content.ContentResolver r10 = r4.f10095j
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r0 = r4.f10097l
            r10.unregisterContentObserver(r0)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x008f:
            r10 = move-exception
            goto L_0x0093
        L_0x0091:
            r10 = move-exception
            r4 = r9
        L_0x0093:
            android.content.ContentResolver r0 = r4.f10095j
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r1 = r4.f10097l
            r0.unregisterContentObserver(r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
