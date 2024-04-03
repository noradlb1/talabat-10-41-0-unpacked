package com.talabat.riderinfo.domain.usecase;

import com.talabat.chat.api.ChatApi;
import com.talabat.chat.domain.ChatException;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.riderinfo.domain.entity.RiderInfo;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/riderinfo/domain/usecase/StartRiderChat;", "", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "chatApi", "Lcom/talabat/chat/api/ChatApi;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/chat/api/ChatApi;)V", "invoke", "", "riderInfo", "Lcom/talabat/riderinfo/domain/entity/RiderInfo;", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StartRiderChat {
    /* access modifiers changed from: private */
    @NotNull
    public final ChatApi chatApi;
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;

    public StartRiderChat(@NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull ChatApi chatApi2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(chatApi2, "chatApi");
        this.configurationLocalRepository = configurationLocalRepository2;
        this.chatApi = chatApi2;
    }

    public final void invoke(@NotNull RiderInfo riderInfo) throws ChatException {
        Intrinsics.checkNotNullParameter(riderInfo, "riderInfo");
        if (((Unit) SafeLetKt.safeLet(riderInfo.getCustomerId(), riderInfo.getSessionToken(), riderInfo.getChannel(), new StartRiderChat$invoke$1(this))) == null) {
            throw new ChatException("Invalid chat data " + riderInfo);
        }
    }
}
