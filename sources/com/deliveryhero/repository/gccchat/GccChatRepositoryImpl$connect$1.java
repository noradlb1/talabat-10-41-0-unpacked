package com.deliveryhero.repository.gccchat;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$connect$1 extends Lambda implements Function1<Result<? extends Unit>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30439g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30440h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f30441i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$connect$1(GccChatRepositoryImpl gccChatRepositoryImpl, Function0<Unit> function0, Function1<? super Throwable, Unit> function1) {
        super(1);
        this.f30439g = gccChatRepositoryImpl;
        this.f30440h = function0;
        this.f30441i = function1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.deliveryhero.chatsdk.domain.model.UserInfo} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v3, types: [com.deliveryhero.chatsdk.ChatSdk] */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            com.deliveryhero.repository.gccchat.GccChatRepositoryImpl r0 = r8.f30439g
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r8.f30440h
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r2 = r8.f30441i
            java.lang.Throwable r3 = kotlin.Result.m6332exceptionOrNullimpl(r9)
            java.lang.String r4 = "gccUserInfo"
            java.lang.String r5 = "USER_ID"
            java.lang.String r6 = "GCC_CONNECTION_EVENT"
            r7 = 0
            if (r3 != 0) goto L_0x0065
            kotlin.Unit r9 = (kotlin.Unit) r9
            com.deliveryhero.contract.configuration.ChatFeatureCallbacks r9 = r0.chatFeatureCallbacks
            com.deliveryhero.contract.ChatLogger r9 = r9.getChatLogger()
            if (r9 == 0) goto L_0x0038
            com.deliveryhero.chatsdk.domain.model.UserInfo r2 = r0.gccUserInfo
            if (r2 != 0) goto L_0x0029
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r2 = r7
        L_0x0029:
            java.lang.String r2 = r2.getUserId()
            kotlin.Pair r2 = kotlin.TuplesKt.to(r5, r2)
            java.util.Map r2 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(r2)
            r9.log(r6, r2)
        L_0x0038:
            com.deliveryhero.customerchat.telephony.repository.PushConfigRepository r9 = r0.pushConfigRepository
            java.lang.String r9 = r9.getToken()
            if (r9 == 0) goto L_0x0061
            com.deliveryhero.chatsdk.ChatSdk r2 = r0.chatSdk
            if (r2 != 0) goto L_0x004e
            java.lang.String r2 = "chatSdk"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x004f
        L_0x004e:
            r7 = r2
        L_0x004f:
            android.app.Application r0 = r0.appContext
            java.lang.String r0 = r0.getPackageName()
            java.lang.String r2 = "appContext.packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.deliveryhero.repository.gccchat.GccChatRepositoryImpl$connect$1$1$1$1 r2 = com.deliveryhero.repository.gccchat.GccChatRepositoryImpl$connect$1$1$1$1.INSTANCE
            r7.registerDevicePushToken(r9, r0, r2)
        L_0x0061:
            r1.invoke()
            goto L_0x008c
        L_0x0065:
            com.deliveryhero.contract.configuration.ChatFeatureCallbacks r9 = r0.chatFeatureCallbacks
            com.deliveryhero.contract.ChatLogger r9 = r9.getChatLogger()
            if (r9 == 0) goto L_0x0089
            com.deliveryhero.chatsdk.domain.model.UserInfo r0 = r0.gccUserInfo
            if (r0 != 0) goto L_0x0079
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x007a
        L_0x0079:
            r7 = r0
        L_0x007a:
            java.lang.String r0 = r7.getUserId()
            kotlin.Pair r0 = kotlin.TuplesKt.to(r5, r0)
            java.util.Map r0 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(r0)
            r9.log(r6, r0, r3)
        L_0x0089:
            r2.invoke(r3)
        L_0x008c:
            com.deliveryhero.repository.gccchat.GccChatRepositoryImpl r9 = r8.f30439g
            com.deliveryhero.contract.idling.ChatIdlingResource r9 = r9.chatIdlingResource
            if (r9 == 0) goto L_0x0097
            r9.decrement()
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.repository.gccchat.GccChatRepositoryImpl$connect$1.invoke(java.lang.Object):void");
    }
}
