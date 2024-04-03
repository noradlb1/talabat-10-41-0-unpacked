package com.talabat.helpcenter.data.datasources.remote.impl;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.helpcenter.data.datasources.remote.ChatMessagesDataSource;
import com.talabat.helpcenter.data.datasources.remote.dto.UnreadChatMessagesCountResponse;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/helpcenter/data/datasources/remote/impl/ChatMessagesDataSourceImpl;", "Lcom/talabat/helpcenter/data/datasources/remote/ChatMessagesDataSource;", "chatMessageApi", "Lcom/talabat/helpcenter/data/datasources/remote/impl/ChatMessageApi;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/helpcenter/data/datasources/remote/impl/ChatMessageApi;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "getUnreadMessagesCount", "Lcom/talabat/helpcenter/data/datasources/remote/dto/UnreadChatMessagesCountResponse;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatMessagesDataSourceImpl implements ChatMessagesDataSource {
    @NotNull
    private final ChatMessageApi chatMessageApi;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;

    public ChatMessagesDataSourceImpl(@NotNull ChatMessageApi chatMessageApi2, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(chatMessageApi2, "chatMessageApi");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.chatMessageApi = chatMessageApi2;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @Nullable
    public Object getUnreadMessagesCount(@NotNull String str, @NotNull Continuation<? super UnreadChatMessagesCountResponse> continuation) {
        ChatMessageApi chatMessageApi2 = this.chatMessageApi;
        String str2 = "Bearer " + str;
        String upperCase = this.configurationLocalRepository.selectedCountry().getTwoLetterCode().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return chatMessageApi2.getUnreadChatMessages(str2, "TB_" + upperCase, continuation);
    }
}
