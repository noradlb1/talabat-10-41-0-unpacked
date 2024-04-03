package com.deliveryhero.chatui.view.chatroom;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"getHideAdminMessagesEnabled", "", "Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "(Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ChatViewModelKt {
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getHideAdminMessagesEnabled(com.deliveryhero.customerchat.fwf.FeatureFlagProvider r4, kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            boolean r0 = r5 instanceof com.deliveryhero.chatui.view.chatroom.ChatViewModelKt$getHideAdminMessagesEnabled$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.deliveryhero.chatui.view.chatroom.ChatViewModelKt$getHideAdminMessagesEnabled$1 r0 = (com.deliveryhero.chatui.view.chatroom.ChatViewModelKt$getHideAdminMessagesEnabled$1) r0
            int r1 = r0.f29626i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f29626i = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.chatui.view.chatroom.ChatViewModelKt$getHideAdminMessagesEnabled$1 r0 = new com.deliveryhero.chatui.view.chatroom.ChatViewModelKt$getHideAdminMessagesEnabled$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.f29625h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f29626i
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.f29626i = r3
            java.lang.Object r5 = r4.getUserFeatureFlags(r0)
            if (r5 != r1) goto L_0x003d
            return r1
        L_0x003d:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r5 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r5
            if (r5 == 0) goto L_0x0046
            boolean r4 = r5.isHideAdminMessagesEnabled()
            goto L_0x0047
        L_0x0046:
            r4 = 0
        L_0x0047:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.view.chatroom.ChatViewModelKt.getHideAdminMessagesEnabled(com.deliveryhero.customerchat.fwf.FeatureFlagProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
