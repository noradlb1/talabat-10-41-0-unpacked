package com.deliveryhero.chatui.view.chatroom;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$init$2", f = "ChatViewModel.kt", i = {}, l = {187, 189}, m = "invokeSuspend", n = {}, s = {})
public final class ChatViewModel$init$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29512h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f29513i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29514j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$init$2(boolean z11, ChatViewModel chatViewModel, Continuation<? super ChatViewModel$init$2> continuation) {
        super(2, continuation);
        this.f29513i = z11;
        this.f29514j = chatViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatViewModel$init$2(this.f29513i, this.f29514j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatViewModel$init$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.f29512h
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0043
        L_0x0012:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0034
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r12)
            boolean r12 = r11.f29513i
            if (r12 == 0) goto L_0x0034
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r12 = r11.f29514j
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r12 = r12.featureFlagProvider
            r11.f29512h = r3
            java.lang.Object r12 = r12.determineUserFeatures(r11)
            if (r12 != r0) goto L_0x0034
            return r0
        L_0x0034:
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r12 = r11.f29514j
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r12 = r12.featureFlagProvider
            r11.f29512h = r2
            java.lang.Object r12 = r12.getUserFeatureFlags(r11)
            if (r12 != r0) goto L_0x0043
            return r0
        L_0x0043:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r12 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r12
            if (r12 != 0) goto L_0x0058
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r12 = new com.deliveryhero.customerchat.fwf.UserFeatureFlags
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 255(0xff, float:3.57E-43)
            r10 = 0
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x0058:
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r0 = r11.f29514j
            r0.populateAttachmentSelector(r12)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.view.chatroom.ChatViewModel$init$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
