package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.ChatSdk;
import com.deliveryhero.chatsdk.domain.model.TokenType;
import com.deliveryhero.chatsdk.domain.model.UserInfo;
import com.deliveryhero.chatsdk.factory.ChatSdkFactory;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.DhEnvironment;
import com.deliveryhero.customerchat.commons.ExtensionsUtilsKt;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/repository/gccchat/ChatProvider;", "", "()V", "country", "", "deviceUUID", "environment", "Lcom/deliveryhero/contract/model/DhEnvironment;", "tokenType", "Lcom/deliveryhero/chatsdk/domain/model/TokenType;", "userInfo", "Lcom/deliveryhero/chatsdk/domain/model/UserInfo;", "versionName", "init", "", "clientConfig", "Lcom/deliveryhero/contract/model/ClientConfig;", "provideChatSDK", "Lcom/deliveryhero/chatsdk/ChatSdk;", "requiredMessage", "field", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatProvider {
    @Nullable
    private String country;
    @Nullable
    private String deviceUUID;
    @Nullable
    private DhEnvironment environment;
    @Nullable
    private TokenType tokenType;
    @Nullable
    private UserInfo userInfo;
    @Nullable
    private String versionName;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.deliveryhero.contract.model.TokenType.values().length];
            iArr[com.deliveryhero.contract.model.TokenType.HUAWEI.ordinal()] = 1;
            iArr[com.deliveryhero.contract.model.TokenType.GOOGLE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public final String requiredMessage(String str) {
        return "Field " + str + " is required for chat sdk initialization";
    }

    public final void init(@NotNull ClientConfig clientConfig, @NotNull String str, @NotNull String str2) {
        TokenType tokenType2;
        Intrinsics.checkNotNullParameter(clientConfig, "clientConfig");
        Intrinsics.checkNotNullParameter(str, "versionName");
        Intrinsics.checkNotNullParameter(str2, "deviceUUID");
        this.country = clientConfig.getCountry();
        this.versionName = str;
        int i11 = WhenMappings.$EnumSwitchMapping$0[clientConfig.getPushNotificationsTokenType().ordinal()];
        if (i11 == 1) {
            tokenType2 = TokenType.HUAWEI;
        } else if (i11 != 2) {
            tokenType2 = TokenType.GOOGLE;
        } else {
            tokenType2 = TokenType.GOOGLE;
        }
        this.tokenType = tokenType2;
        this.environment = clientConfig.getDhEnvironment();
        this.deviceUUID = str2;
    }

    @NotNull
    public final ChatSdk provideChatSDK(@NotNull UserInfo userInfo2) {
        Intrinsics.checkNotNullParameter(userInfo2, "userInfo");
        this.userInfo = userInfo2;
        String requireNotNullOrEmpty = ExtensionsUtilsKt.requireNotNullOrEmpty(this.country, new ChatProvider$provideChatSDK$country$1(this));
        String requireNotNullOrEmpty2 = ExtensionsUtilsKt.requireNotNullOrEmpty(this.versionName, new ChatProvider$provideChatSDK$versionName$1(this));
        DhEnvironment dhEnvironment = this.environment;
        if (dhEnvironment != null) {
            TokenType tokenType2 = this.tokenType;
            if (tokenType2 != null) {
                return ChatSdkFactory.INSTANCE.createSdk(userInfo2, requireNotNullOrEmpty, tokenType2, dhEnvironment, requireNotNullOrEmpty2, ExtensionsUtilsKt.requireNotNullOrEmpty(this.deviceUUID, new ChatProvider$provideChatSDK$deviceUUID$1(this)));
            }
            throw new IllegalArgumentException(requiredMessage("tokenType").toString());
        }
        throw new IllegalArgumentException(requiredMessage(Profile.ENVIRONMENT).toString());
    }
}
