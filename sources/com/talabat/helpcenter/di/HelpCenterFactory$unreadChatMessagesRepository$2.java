package com.talabat.helpcenter.di;

import com.talabat.helpcenter.data.datasources.remote.impl.ChatMessagesDataSourceImpl;
import com.talabat.helpcenter.data.repository.UnreadChatMessagesRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/helpcenter/data/repository/UnreadChatMessagesRepositoryImpl;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterFactory$unreadChatMessagesRepository$2 extends Lambda implements Function0<UnreadChatMessagesRepositoryImpl> {
    public static final HelpCenterFactory$unreadChatMessagesRepository$2 INSTANCE = new HelpCenterFactory$unreadChatMessagesRepository$2();

    public HelpCenterFactory$unreadChatMessagesRepository$2() {
        super(0);
    }

    @NotNull
    public final UnreadChatMessagesRepositoryImpl invoke() {
        HelpCenterFactory helpCenterFactory = HelpCenterFactory.INSTANCE;
        return new UnreadChatMessagesRepositoryImpl(new ChatMessagesDataSourceImpl(helpCenterFactory.getChatMessageApi(), helpCenterFactory.getConfigurationLocalRepository()), 0, (CoroutineDispatcher) null, 6, (DefaultConstructorMarker) null);
    }
}
