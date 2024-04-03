package com.deliveryhero.chatui.view.chatroom.mapper;

import com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel;
import com.deliveryhero.contract.model.BaseMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ/\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0003H&\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/mapper/ChatMessageViewModelMapper;", "", "map", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "index", "", "preferredLanguage", "", "chatMessage", "Lcom/deliveryhero/contract/model/BaseMessage;", "error", "", "(ILjava/lang/String;Lcom/deliveryhero/contract/model/BaseMessage;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "list", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "translate", "chatMessageViewModel", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChatMessageViewModelMapper {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object map$default(ChatMessageViewModelMapper chatMessageViewModelMapper, int i11, String str, BaseMessage baseMessage, Throwable th2, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 8) != 0) {
                    th2 = null;
                }
                return chatMessageViewModelMapper.map(i11, str, baseMessage, th2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: map");
        }
    }

    @Nullable
    Object map(int i11, @Nullable String str, @NotNull BaseMessage baseMessage, @Nullable Throwable th2, @NotNull Continuation<? super ChatMessageViewModel> continuation);

    @Nullable
    Object map(@Nullable String str, @NotNull List<? extends BaseMessage> list, @NotNull Continuation<? super List<ChatMessageViewModel>> continuation);

    @NotNull
    ChatMessageViewModel translate(@Nullable String str, @NotNull ChatMessageViewModel chatMessageViewModel);
}
