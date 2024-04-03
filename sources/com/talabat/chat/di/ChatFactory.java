package com.talabat.chat.di;

import androidx.annotation.VisibleForTesting;
import com.talabat.chat.api.ChatApi;
import com.talabat.chat.api.impl.RiderChatApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/chat/di/ChatFactory;", "", "chatApi", "Lcom/talabat/chat/api/ChatApi;", "(Lcom/talabat/chat/api/ChatApi;)V", "initializeChatProvider", "Companion", "com_talabat_core_chat_chat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatFactory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static ChatFactory instance;
    @NotNull
    private final ChatApi chatApi;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/chat/di/ChatFactory$Companion;", "", "()V", "instance", "Lcom/talabat/chat/di/ChatFactory;", "getInstance", "chatApi", "Lcom/talabat/chat/api/ChatApi;", "reset", "", "com_talabat_core_chat_chat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ChatFactory getInstance$default(Companion companion, ChatApi chatApi, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                chatApi = RiderChatApi.Companion.getInstance();
            }
            return companion.getInstance(chatApi);
        }

        @NotNull
        public final synchronized ChatFactory getInstance(@NotNull ChatApi chatApi) {
            ChatFactory access$getInstance$cp;
            Intrinsics.checkNotNullParameter(chatApi, "chatApi");
            if (ChatFactory.instance == null) {
                ChatFactory.instance = new ChatFactory(chatApi, (DefaultConstructorMarker) null);
            }
            access$getInstance$cp = ChatFactory.instance;
            if (access$getInstance$cp == null) {
                access$getInstance$cp = new ChatFactory(chatApi, (DefaultConstructorMarker) null);
            }
            return access$getInstance$cp;
        }

        @VisibleForTesting
        public final void reset() {
            ChatFactory.instance = null;
        }
    }

    private ChatFactory(ChatApi chatApi2) {
        this.chatApi = chatApi2;
    }

    public /* synthetic */ ChatFactory(ChatApi chatApi2, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatApi2);
    }

    @NotNull
    public final ChatApi initializeChatProvider() {
        return this.chatApi.init();
    }
}
