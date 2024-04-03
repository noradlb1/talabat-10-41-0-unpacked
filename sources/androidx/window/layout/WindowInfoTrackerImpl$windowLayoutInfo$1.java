package androidx.window.layout;

import android.app.Activity;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/window/layout/WindowLayoutInfo;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", i = {0, 0, 1, 1}, l = {54, 55}, m = "invokeSuspend", n = {"$this$flow", "listener", "$this$flow", "listener"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends SuspendLambda implements Function2<FlowCollector<? super WindowLayoutInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, Continuation<? super WindowInfoTrackerImpl$windowLayoutInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = windowInfoTrackerImpl;
        this.$activity = activity;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m9130invokeSuspend$lambda0(Channel channel, WindowLayoutInfo windowLayoutInfo) {
        Intrinsics.checkNotNullExpressionValue(windowLayoutInfo, CustomerInfoLocalDataSourceImpl.KEY);
        channel.m7820trySendJP2dKIU(windowLayoutInfo);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, continuation);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super WindowLayoutInfo> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073 A[Catch:{ all -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e A[Catch:{ all -> 0x00a1 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x001f
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x00a3 }
            r10 = r5
            goto L_0x0063
        L_0x001f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0027:
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x00a3 }
            r6 = r5
            r5 = r9
            goto L_0x0076
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
            r4 = 4
            r5 = 10
            r6 = 0
            kotlinx.coroutines.channels.Channel r1 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r5, r1, r6, r4, r6)
            androidx.window.layout.a r4 = new androidx.window.layout.a
            r4.<init>(r1)
            androidx.window.layout.WindowInfoTrackerImpl r5 = r9.this$0
            androidx.window.layout.WindowBackend r5 = r5.windowBackend
            android.app.Activity r6 = r9.$activity
            i2.b r7 = new i2.b
            r7.<init>()
            r5.registerLayoutChangeCallback(r6, r7, r4)
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()     // Catch:{ all -> 0x00a3 }
        L_0x0063:
            r5 = r9
        L_0x0064:
            r5.L$0 = r10     // Catch:{ all -> 0x00a1 }
            r5.L$1 = r4     // Catch:{ all -> 0x00a1 }
            r5.L$2 = r1     // Catch:{ all -> 0x00a1 }
            r5.label = r3     // Catch:{ all -> 0x00a1 }
            java.lang.Object r6 = r1.hasNext(r5)     // Catch:{ all -> 0x00a1 }
            if (r6 != r0) goto L_0x0073
            return r0
        L_0x0073:
            r8 = r6
            r6 = r10
            r10 = r8
        L_0x0076:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00a1 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00a1 }
            if (r10 == 0) goto L_0x0095
            java.lang.Object r10 = r1.next()     // Catch:{ all -> 0x00a1 }
            androidx.window.layout.WindowLayoutInfo r10 = (androidx.window.layout.WindowLayoutInfo) r10     // Catch:{ all -> 0x00a1 }
            r5.L$0 = r6     // Catch:{ all -> 0x00a1 }
            r5.L$1 = r4     // Catch:{ all -> 0x00a1 }
            r5.L$2 = r1     // Catch:{ all -> 0x00a1 }
            r5.label = r2     // Catch:{ all -> 0x00a1 }
            java.lang.Object r10 = r6.emit(r10, r5)     // Catch:{ all -> 0x00a1 }
            if (r10 != r0) goto L_0x0093
            return r0
        L_0x0093:
            r10 = r6
            goto L_0x0064
        L_0x0095:
            androidx.window.layout.WindowInfoTrackerImpl r10 = r5.this$0
            androidx.window.layout.WindowBackend r10 = r10.windowBackend
            r10.unregisterLayoutChangeCallback(r4)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00a1:
            r10 = move-exception
            goto L_0x00a5
        L_0x00a3:
            r10 = move-exception
            r5 = r9
        L_0x00a5:
            androidx.window.layout.WindowInfoTrackerImpl r0 = r5.this$0
            androidx.window.layout.WindowBackend r0 = r0.windowBackend
            r0.unregisterLayoutChangeCallback(r4)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
