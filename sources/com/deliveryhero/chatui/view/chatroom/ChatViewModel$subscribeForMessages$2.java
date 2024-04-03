package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.contract.model.GroupChannel;
import com.deliveryhero.contract.model.Receipt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "groupChannel", "Lcom/deliveryhero/contract/model/GroupChannel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatViewModel$subscribeForMessages$2 extends Lambda implements Function1<GroupChannel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29591g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$subscribeForMessages$2(ChatViewModel chatViewModel) {
        super(1);
        this.f29591g = chatViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GroupChannel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GroupChannel groupChannel) {
        Intrinsics.checkNotNullParameter(groupChannel, "groupChannel");
        List list = (List) this.f29591g._messagesLiveData.getValue();
        if (list != null) {
            ChatViewModel chatViewModel = this.f29591g;
            Iterable<ChatMessageViewModel> iterable = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (ChatMessageViewModel chatMessageViewModel : iterable) {
                if (chatMessageViewModel.getSendByMe() && chatMessageViewModel.getReceiptState() == Receipt.SENT) {
                    chatMessageViewModel = chatViewModel.updateReceiptIfNeeds(groupChannel, chatMessageViewModel);
                }
                arrayList.add(chatMessageViewModel);
            }
            chatViewModel._messagesLiveData.setValue(arrayList);
        }
    }
}
