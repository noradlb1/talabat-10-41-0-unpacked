package com.deliveryhero.chatui.view.chatroom;

import androidx.lifecycle.ViewModelKt;
import com.deliveryhero.chatui.view.chatroom.ImageMessage;
import com.deliveryhero.chatui.view.chatroom.LocationMessage;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.customerchat.commons.ExtensionsUtilsKt;
import com.deliveryhero.customerchat.eventTracking.data.MessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.MessageType;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a&\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0000¨\u0006\u000b"}, d2 = {"trackMessageDeliveredEvent", "", "Lcom/deliveryhero/chatui/view/chatroom/ChatViewModel;", "message", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "trackMessageEvent", "messageText", "", "isQuickReply", "", "correlationId", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ChatViewModelEventsHelperKt {
    public static final void trackMessageDeliveredEvent(@NotNull ChatViewModel chatViewModel, @NotNull ChatMessageViewModel chatMessageViewModel) {
        MessageType messageType;
        MessageMetadata messageMetadata;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(chatViewModel, "<this>");
        Intrinsics.checkNotNullParameter(chatMessageViewModel, "message");
        boolean z11 = false;
        if (!Intrinsics.areEqual((Object) chatMessageViewModel.getLocationMessage(), (Object) LocationMessage.Hidden.INSTANCE)) {
            messageType = MessageType.LOCATION;
        } else if (!Intrinsics.areEqual((Object) chatMessageViewModel.getImageMessage(), (Object) new ImageMessage.Hidden(0, 1, (DefaultConstructorMarker) null))) {
            messageType = MessageType.IMAGE;
        } else {
            messageType = MessageType.TEXT;
        }
        MessageType messageType2 = messageType;
        if (messageType2 == MessageType.TEXT) {
            List value = chatViewModel.getQuickReplies().getValue();
            if (value != null) {
                z11 = value.contains(chatMessageViewModel.getOriginalMessage().getMessage());
            }
            int countCharacters = ExtensionsUtilsKt.countCharacters(chatMessageViewModel.getOriginalMessage().getMessage());
            int countWords = ExtensionsUtilsKt.countWords(chatMessageViewModel.getOriginalMessage().getMessage());
            String preferredLanguage$customerchat_basicRelease = chatViewModel.preferredLanguage$customerchat_basicRelease();
            BaseMessage chatMessage = chatMessageViewModel.getChatMessage();
            if (chatMessage != null) {
                str2 = chatMessage.getCorrelationId();
            } else {
                str2 = null;
            }
            if (z11) {
                str3 = chatMessageViewModel.getOriginalMessage().getMessage();
            } else {
                str3 = null;
            }
            messageMetadata = new MessageMetadata(str2, messageType2, countCharacters, countWords, preferredLanguage$customerchat_basicRelease, Boolean.valueOf(z11), str3);
        } else {
            BaseMessage chatMessage2 = chatMessageViewModel.getChatMessage();
            if (chatMessage2 != null) {
                str = chatMessage2.getCorrelationId();
            } else {
                str = null;
            }
            messageMetadata = new MessageMetadata(str, messageType2, 0, 0, (String) null, (Boolean) null, (String) null, 124, (DefaultConstructorMarker) null);
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(chatViewModel), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModelEventsHelperKt$trackMessageDeliveredEvent$1(chatViewModel, messageMetadata, (Continuation<? super ChatViewModelEventsHelperKt$trackMessageDeliveredEvent$1>) null), 3, (Object) null);
    }

    public static final void trackMessageEvent(@NotNull ChatViewModel chatViewModel, @NotNull String str, boolean z11, @Nullable String str2) {
        String str3;
        ChatViewModel chatViewModel2 = chatViewModel;
        boolean z12 = z11;
        Intrinsics.checkNotNullParameter(chatViewModel2, "<this>");
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "messageText");
        MessageType messageType = MessageType.TEXT;
        int countCharacters = ExtensionsUtilsKt.countCharacters(str);
        int countWords = ExtensionsUtilsKt.countWords(str);
        String preferredLanguage$customerchat_basicRelease = chatViewModel.preferredLanguage$customerchat_basicRelease();
        if (z12) {
            str3 = str4;
        } else {
            str3 = null;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(chatViewModel), (CoroutineContext) null, (CoroutineStart) null, new ChatViewModelEventsHelperKt$trackMessageEvent$1(chatViewModel2, new MessageMetadata(str2, messageType, countCharacters, countWords, preferredLanguage$customerchat_basicRelease, Boolean.valueOf(z11), str3), z12, (Continuation<? super ChatViewModelEventsHelperKt$trackMessageEvent$1>) null), 3, (Object) null);
    }
}
