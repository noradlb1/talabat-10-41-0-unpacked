package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.domain.model.UserInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$initGccChatSdk$initSdkAndRegisterUser$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30459g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ UserInfo f30460h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30461i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$initGccChatSdk$initSdkAndRegisterUser$1(GccChatRepositoryImpl gccChatRepositoryImpl, UserInfo userInfo, Function0<Unit> function0) {
        super(0);
        this.f30459g = gccChatRepositoryImpl;
        this.f30460h = userInfo;
        this.f30461i = function0;
    }

    @Nullable
    public final Unit invoke() {
        GccChatRepositoryImpl gccChatRepositoryImpl = this.f30459g;
        gccChatRepositoryImpl.chatSdk = gccChatRepositoryImpl.chatProvider.provideChatSDK(this.f30460h);
        this.f30459g.gccUserInfo = this.f30460h;
        this.f30459g.isChannelDirty = true;
        this.f30459g.isUserRegistered = true;
        Function0<Unit> function0 = this.f30461i;
        if (function0 == null) {
            return null;
        }
        function0.invoke();
        return Unit.INSTANCE;
    }
}
