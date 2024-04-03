package com.talabat.chat.api;

import com.talabat.chat.domain.ChatDeliveryInfo;
import com.talabat.chat.domain.ChatException;
import com.talabat.chat.domain.ChatPushData;
import com.talabat.chat.domain.ChatUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\fj\b\u0012\u0004\u0012\u00020\t`\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0000H&J\u001e\u0010\u0011\u001a\u00020\u000f2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013H&J\u001e\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0013H&J6\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\t2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u001bH&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\u001e\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H&J\u0016\u0010 \u001a\u00020\u00032\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H&J.\u0010\"\u001a\u00020\u00032\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u001bH&¨\u0006#"}, d2 = {"Lcom/talabat/chat/api/ChatApi;", "", "configureChat", "", "chatUser", "Lcom/talabat/chat/domain/ChatUser;", "chatDeliveryInfo", "Lcom/talabat/chat/domain/ChatDeliveryInfo;", "chatChannel", "", "preferredLanguage", "supportedTranslations", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "enableTranslation", "", "init", "isChatMessage", "data", "", "parseChatMessage", "Lcom/talabat/chat/domain/ChatPushData;", "registerToken", "token", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "", "startChat", "subscribeCallEvent", "callEventHandler", "subscribeChatOpenedEvent", "chatOpenedEventHandler", "unregisterToken", "com_talabat_core_chat_chat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChatApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ ChatPushData parseChatMessage$default(ChatApi chatApi, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    map = new HashMap();
                }
                return chatApi.parseChatMessage(map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parseChatMessage");
        }

        public static /* synthetic */ void registerToken$default(ChatApi chatApi, String str, Function0 function0, Function1 function1, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    function0 = ChatApi$registerToken$1.INSTANCE;
                }
                if ((i11 & 4) != 0) {
                    function1 = ChatApi$registerToken$2.INSTANCE;
                }
                chatApi.registerToken(str, function0, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerToken");
        }

        public static /* synthetic */ void unregisterToken$default(ChatApi chatApi, Function0 function0, Function1 function1, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    function0 = ChatApi$unregisterToken$1.INSTANCE;
                }
                if ((i11 & 2) != 0) {
                    function1 = ChatApi$unregisterToken$2.INSTANCE;
                }
                chatApi.unregisterToken(function0, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unregisterToken");
        }
    }

    void configureChat(@NotNull ChatUser chatUser, @NotNull ChatDeliveryInfo chatDeliveryInfo, @NotNull String str, @NotNull String str2, @NotNull ArrayList<String> arrayList, boolean z11);

    @NotNull
    ChatApi init();

    boolean isChatMessage(@Nullable Map<String, String> map);

    @NotNull
    ChatPushData parseChatMessage(@NotNull Map<String, String> map);

    void registerToken(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1);

    void startChat(@NotNull ChatDeliveryInfo chatDeliveryInfo, @NotNull String str) throws ChatException;

    void subscribeCallEvent(@NotNull Function0<Unit> function0);

    void subscribeChatOpenedEvent(@NotNull Function0<Unit> function0);

    void unregisterToken(@NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1);
}
