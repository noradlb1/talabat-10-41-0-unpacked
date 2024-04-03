package com.deliveryhero.chatsdk.factory;

import com.deliveryhero.chatsdk.ChatSdk;
import com.deliveryhero.chatsdk.domain.HTTPRepository;
import com.deliveryhero.chatsdk.domain.RealChatSdk;
import com.deliveryhero.chatsdk.domain.SocketRepository;
import com.deliveryhero.chatsdk.domain.model.TokenType;
import com.deliveryhero.chatsdk.domain.model.UserInfo;
import com.deliveryhero.chatsdk.network.http.ChatHttpService;
import com.deliveryhero.contract.model.DhEnvironment;
import com.deliveryhero.customerchat.di.MyKoinContext;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.core.Koin;
import org.koin.core.qualifier.Qualifier;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/chatsdk/factory/ChatSdkFactory;", "", "()V", "createSdk", "Lcom/deliveryhero/chatsdk/ChatSdk;", "userInfo", "Lcom/deliveryhero/chatsdk/domain/model/UserInfo;", "country", "", "tokenType", "Lcom/deliveryhero/chatsdk/domain/model/TokenType;", "environment", "Lcom/deliveryhero/contract/model/DhEnvironment;", "componentVersionName", "deviceUUID", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatSdkFactory {
    @NotNull
    public static final ChatSdkFactory INSTANCE = new ChatSdkFactory();

    private ChatSdkFactory() {
    }

    public static /* synthetic */ ChatSdk createSdk$default(ChatSdkFactory chatSdkFactory, UserInfo userInfo, String str, TokenType tokenType, DhEnvironment dhEnvironment, String str2, String str3, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            dhEnvironment = DhEnvironment.PRODUCTION;
        }
        return chatSdkFactory.createSdk(userInfo, str, tokenType, dhEnvironment, str2, str3);
    }

    @NotNull
    public final ChatSdk createSdk(@NotNull UserInfo userInfo, @NotNull String str, @NotNull TokenType tokenType, @NotNull DhEnvironment dhEnvironment, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(tokenType, "tokenType");
        Intrinsics.checkNotNullParameter(dhEnvironment, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(str2, "componentVersionName");
        Intrinsics.checkNotNullParameter(str3, "deviceUUID");
        Koin koin = MyKoinContext.INSTANCE.getKoin();
        ChatSdkFactory$createSdk$retrofit$1$1 chatSdkFactory$createSdk$retrofit$1$1 = new ChatSdkFactory$createSdk$retrofit$1$1(koin);
        return new RealChatSdk(SocketRepository.Companion.getInstance(userInfo, str, dhEnvironment, tokenType, str2, str3), HTTPRepository.Companion.getInstance(userInfo, tokenType, ChatHttpService.Factory.getInstance((Retrofit) koin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(Retrofit.class), (Qualifier) null, chatSdkFactory$createSdk$retrofit$1$1))));
    }
}
