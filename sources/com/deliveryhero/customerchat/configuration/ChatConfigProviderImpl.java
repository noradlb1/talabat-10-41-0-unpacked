package com.deliveryhero.customerchat.configuration;

import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.configuration.PersistableChatConfiguration;
import com.deliveryhero.contract.datastore.ChatConfigurationDataStoreHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/deliveryhero/customerchat/configuration/ChatConfigProviderImpl;", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "chatConfiguration", "Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "chatConfigurationDataStoreHelper", "Lcom/deliveryhero/contract/datastore/ChatConfigurationDataStoreHelper;", "(Lcom/deliveryhero/contract/configuration/ChatConfiguration;Lcom/deliveryhero/contract/datastore/ChatConfigurationDataStoreHelper;)V", "getChatConfiguration", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatConfigProviderImpl implements ChatConfigProvider {
    @NotNull
    private final ChatConfiguration chatConfiguration;
    @NotNull
    private final ChatConfigurationDataStoreHelper chatConfigurationDataStoreHelper;

    public ChatConfigProviderImpl(@NotNull ChatConfiguration chatConfiguration2, @NotNull ChatConfigurationDataStoreHelper chatConfigurationDataStoreHelper2) {
        Intrinsics.checkNotNullParameter(chatConfiguration2, "chatConfiguration");
        Intrinsics.checkNotNullParameter(chatConfigurationDataStoreHelper2, "chatConfigurationDataStoreHelper");
        this.chatConfiguration = chatConfiguration2;
        this.chatConfigurationDataStoreHelper = chatConfigurationDataStoreHelper2;
    }

    @Nullable
    public ChatConfiguration getChatConfiguration() {
        if (!Intrinsics.areEqual((Object) this.chatConfiguration, (Object) ChatConfiguration.Companion.getDEFAULT_CHAT_CONFIGURATION$customerchat_basicRelease())) {
            return this.chatConfiguration;
        }
        PersistableChatConfiguration latestChatConfiguration = this.chatConfigurationDataStoreHelper.getLatestChatConfiguration();
        if (latestChatConfiguration != null) {
            return latestChatConfiguration.toChatConfiguration();
        }
        return null;
    }
}
