package com.deliveryhero.contract.configuration;

import com.deliveryhero.contract.model.UserInfo;
import com.deliveryhero.customerchat.commons.UserNotRegisteredException;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.telephony.repository.ChatDataRepository;
import com.deliveryhero.customerchat.telephony.util.logging.TelephonyLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0011\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/contract/configuration/ChatDataRepositoryImpl;", "Lcom/deliveryhero/customerchat/telephony/repository/ChatDataRepository;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "chatFeatureCallbacks", "Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;", "featureFlagProvider", "Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "(Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;)V", "logger", "Lcom/deliveryhero/customerchat/telephony/util/logging/TelephonyLogger;", "getLogger", "()Lcom/deliveryhero/customerchat/telephony/util/logging/TelephonyLogger;", "getTelephonyLogger", "getUserID", "", "shouldClearVOIPCache", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatDataRepositoryImpl implements ChatDataRepository {
    @NotNull
    private final ChatConfigProvider chatConfigProvider;
    /* access modifiers changed from: private */
    @NotNull
    public final ChatFeatureCallbacks chatFeatureCallbacks;
    @NotNull
    private final FeatureFlagProvider featureFlagProvider;
    @NotNull
    private final TelephonyLogger logger = new ChatDataRepositoryImpl$logger$1(this);

    public ChatDataRepositoryImpl(@NotNull ChatConfigProvider chatConfigProvider2, @NotNull ChatFeatureCallbacks chatFeatureCallbacks2, @NotNull FeatureFlagProvider featureFlagProvider2) {
        Intrinsics.checkNotNullParameter(chatConfigProvider2, "chatConfigProvider");
        Intrinsics.checkNotNullParameter(chatFeatureCallbacks2, "chatFeatureCallbacks");
        Intrinsics.checkNotNullParameter(featureFlagProvider2, "featureFlagProvider");
        this.chatConfigProvider = chatConfigProvider2;
        this.chatFeatureCallbacks = chatFeatureCallbacks2;
        this.featureFlagProvider = featureFlagProvider2;
    }

    @NotNull
    public final TelephonyLogger getLogger() {
        return this.logger;
    }

    @NotNull
    public TelephonyLogger getTelephonyLogger() {
        return this.logger;
    }

    @NotNull
    public String getUserID() {
        UserInfo userInfo;
        String id2;
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration != null && (userInfo = chatConfiguration.getUserInfo()) != null && (id2 = userInfo.getId()) != null) {
            return id2;
        }
        throw new UserNotRegisteredException((String) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object shouldClearVOIPCache(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.deliveryhero.contract.configuration.ChatDataRepositoryImpl$shouldClearVOIPCache$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.deliveryhero.contract.configuration.ChatDataRepositoryImpl$shouldClearVOIPCache$1 r0 = (com.deliveryhero.contract.configuration.ChatDataRepositoryImpl$shouldClearVOIPCache$1) r0
            int r1 = r0.f29712j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f29712j = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.contract.configuration.ChatDataRepositoryImpl$shouldClearVOIPCache$1 r0 = new com.deliveryhero.contract.configuration.ChatDataRepositoryImpl$shouldClearVOIPCache$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f29710h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f29712j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r5 = r4.featureFlagProvider
            r0.f29712j = r3
            java.lang.Object r5 = r5.getUserFeatureFlags(r0)
            if (r5 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r5 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r5
            r0 = 0
            if (r5 == 0) goto L_0x004b
            boolean r5 = r5.isVOIPCacheClearingEnabled()
            if (r5 != r3) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r3 = r0
        L_0x004c:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.contract.configuration.ChatDataRepositoryImpl.shouldClearVOIPCache(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
