package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5", f = "AndroidPopup.android.kt", i = {0}, l = {299}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
public final class AndroidPopup_androidKt$Popup$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f10376h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f10377i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidPopup_androidKt$Popup$5(PopupLayout popupLayout, Continuation<? super AndroidPopup_androidKt$Popup$5> continuation) {
        super(2, continuation);
        this.f10377i = popupLayout;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AndroidPopup_androidKt$Popup$5 androidPopup_androidKt$Popup$5 = new AndroidPopup_androidKt$Popup$5(this.f10377i, continuation);
        androidPopup_androidKt$Popup$5.L$0 = obj;
        return androidPopup_androidKt$Popup$5;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AndroidPopup_androidKt$Popup$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f10376h
            r2 = 1
            if (r1 == 0) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            java.lang.Object r1 = r4.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r5)
            r5 = r4
            goto L_0x0038
        L_0x0014:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Object r5 = r4.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            r1 = r5
            r5 = r4
        L_0x0025:
            boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
            if (r3 == 0) goto L_0x003e
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1 r3 = androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5.AnonymousClass1.INSTANCE
            r5.L$0 = r1
            r5.f10376h = r2
            java.lang.Object r3 = androidx.compose.ui.platform.InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(r3, r5)
            if (r3 != r0) goto L_0x0038
            return r0
        L_0x0038:
            androidx.compose.ui.window.PopupLayout r3 = r5.f10377i
            r3.pollForLocationOnScreenChange()
            goto L_0x0025
        L_0x003e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
