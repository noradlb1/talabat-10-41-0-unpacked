package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.Receipt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\b\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0014J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\t\u00108\u001a\u00020\u0010HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0012HÆ\u0003Js\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010;\u001a\u00020\u000e2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\t\u0010>\u001a\u00020\fHÖ\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&¨\u0006?"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "", "index", "", "originalMessage", "Lcom/deliveryhero/chatui/view/chatroom/TextMessage;", "translatedMessage", "imageMessage", "Lcom/deliveryhero/chatui/view/chatroom/ImageMessage;", "locationMessage", "Lcom/deliveryhero/chatui/view/chatroom/LocationMessage;", "date", "", "sendByMe", "", "receiptState", "Lcom/deliveryhero/contract/model/Receipt;", "chatMessage", "Lcom/deliveryhero/contract/model/BaseMessage;", "senderNickName", "(ILcom/deliveryhero/chatui/view/chatroom/TextMessage;Lcom/deliveryhero/chatui/view/chatroom/TextMessage;Lcom/deliveryhero/chatui/view/chatroom/ImageMessage;Lcom/deliveryhero/chatui/view/chatroom/LocationMessage;Ljava/lang/String;ZLcom/deliveryhero/contract/model/Receipt;Lcom/deliveryhero/contract/model/BaseMessage;Ljava/lang/String;)V", "getChatMessage", "()Lcom/deliveryhero/contract/model/BaseMessage;", "getDate", "()Ljava/lang/String;", "getImageMessage", "()Lcom/deliveryhero/chatui/view/chatroom/ImageMessage;", "setImageMessage", "(Lcom/deliveryhero/chatui/view/chatroom/ImageMessage;)V", "getIndex", "()I", "getLocationMessage", "()Lcom/deliveryhero/chatui/view/chatroom/LocationMessage;", "setLocationMessage", "(Lcom/deliveryhero/chatui/view/chatroom/LocationMessage;)V", "getOriginalMessage", "()Lcom/deliveryhero/chatui/view/chatroom/TextMessage;", "setOriginalMessage", "(Lcom/deliveryhero/chatui/view/chatroom/TextMessage;)V", "getReceiptState", "()Lcom/deliveryhero/contract/model/Receipt;", "setReceiptState", "(Lcom/deliveryhero/contract/model/Receipt;)V", "getSendByMe", "()Z", "getSenderNickName", "getTranslatedMessage", "setTranslatedMessage", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatMessageViewModel {
    @Nullable
    private final BaseMessage chatMessage;
    @NotNull
    private final String date;
    @NotNull
    private ImageMessage imageMessage;
    private final int index;
    @NotNull
    private LocationMessage locationMessage;
    @NotNull
    private TextMessage originalMessage;
    @NotNull
    private Receipt receiptState;
    private final boolean sendByMe;
    @Nullable
    private final String senderNickName;
    @Nullable
    private TextMessage translatedMessage;

    public ChatMessageViewModel(int i11, @NotNull TextMessage textMessage, @Nullable TextMessage textMessage2, @NotNull ImageMessage imageMessage2, @NotNull LocationMessage locationMessage2, @NotNull String str, boolean z11, @NotNull Receipt receipt, @Nullable BaseMessage baseMessage, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(textMessage, "originalMessage");
        Intrinsics.checkNotNullParameter(imageMessage2, "imageMessage");
        Intrinsics.checkNotNullParameter(locationMessage2, "locationMessage");
        Intrinsics.checkNotNullParameter(str, "date");
        Intrinsics.checkNotNullParameter(receipt, "receiptState");
        this.index = i11;
        this.originalMessage = textMessage;
        this.translatedMessage = textMessage2;
        this.imageMessage = imageMessage2;
        this.locationMessage = locationMessage2;
        this.date = str;
        this.sendByMe = z11;
        this.receiptState = receipt;
        this.chatMessage = baseMessage;
        this.senderNickName = str2;
    }

    public static /* synthetic */ ChatMessageViewModel copy$default(ChatMessageViewModel chatMessageViewModel, int i11, TextMessage textMessage, TextMessage textMessage2, ImageMessage imageMessage2, LocationMessage locationMessage2, String str, boolean z11, Receipt receipt, BaseMessage baseMessage, String str2, int i12, Object obj) {
        ChatMessageViewModel chatMessageViewModel2 = chatMessageViewModel;
        int i13 = i12;
        return chatMessageViewModel.copy((i13 & 1) != 0 ? chatMessageViewModel2.index : i11, (i13 & 2) != 0 ? chatMessageViewModel2.originalMessage : textMessage, (i13 & 4) != 0 ? chatMessageViewModel2.translatedMessage : textMessage2, (i13 & 8) != 0 ? chatMessageViewModel2.imageMessage : imageMessage2, (i13 & 16) != 0 ? chatMessageViewModel2.locationMessage : locationMessage2, (i13 & 32) != 0 ? chatMessageViewModel2.date : str, (i13 & 64) != 0 ? chatMessageViewModel2.sendByMe : z11, (i13 & 128) != 0 ? chatMessageViewModel2.receiptState : receipt, (i13 & 256) != 0 ? chatMessageViewModel2.chatMessage : baseMessage, (i13 & 512) != 0 ? chatMessageViewModel2.senderNickName : str2);
    }

    public final int component1() {
        return this.index;
    }

    @Nullable
    public final String component10() {
        return this.senderNickName;
    }

    @NotNull
    public final TextMessage component2() {
        return this.originalMessage;
    }

    @Nullable
    public final TextMessage component3() {
        return this.translatedMessage;
    }

    @NotNull
    public final ImageMessage component4() {
        return this.imageMessage;
    }

    @NotNull
    public final LocationMessage component5() {
        return this.locationMessage;
    }

    @NotNull
    public final String component6() {
        return this.date;
    }

    public final boolean component7() {
        return this.sendByMe;
    }

    @NotNull
    public final Receipt component8() {
        return this.receiptState;
    }

    @Nullable
    public final BaseMessage component9() {
        return this.chatMessage;
    }

    @NotNull
    public final ChatMessageViewModel copy(int i11, @NotNull TextMessage textMessage, @Nullable TextMessage textMessage2, @NotNull ImageMessage imageMessage2, @NotNull LocationMessage locationMessage2, @NotNull String str, boolean z11, @NotNull Receipt receipt, @Nullable BaseMessage baseMessage, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(textMessage, "originalMessage");
        ImageMessage imageMessage3 = imageMessage2;
        Intrinsics.checkNotNullParameter(imageMessage3, "imageMessage");
        LocationMessage locationMessage3 = locationMessage2;
        Intrinsics.checkNotNullParameter(locationMessage3, "locationMessage");
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "date");
        Receipt receipt2 = receipt;
        Intrinsics.checkNotNullParameter(receipt2, "receiptState");
        return new ChatMessageViewModel(i11, textMessage, textMessage2, imageMessage3, locationMessage3, str3, z11, receipt2, baseMessage, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMessageViewModel)) {
            return false;
        }
        ChatMessageViewModel chatMessageViewModel = (ChatMessageViewModel) obj;
        return this.index == chatMessageViewModel.index && Intrinsics.areEqual((Object) this.originalMessage, (Object) chatMessageViewModel.originalMessage) && Intrinsics.areEqual((Object) this.translatedMessage, (Object) chatMessageViewModel.translatedMessage) && Intrinsics.areEqual((Object) this.imageMessage, (Object) chatMessageViewModel.imageMessage) && Intrinsics.areEqual((Object) this.locationMessage, (Object) chatMessageViewModel.locationMessage) && Intrinsics.areEqual((Object) this.date, (Object) chatMessageViewModel.date) && this.sendByMe == chatMessageViewModel.sendByMe && this.receiptState == chatMessageViewModel.receiptState && Intrinsics.areEqual((Object) this.chatMessage, (Object) chatMessageViewModel.chatMessage) && Intrinsics.areEqual((Object) this.senderNickName, (Object) chatMessageViewModel.senderNickName);
    }

    @Nullable
    public final BaseMessage getChatMessage() {
        return this.chatMessage;
    }

    @NotNull
    public final String getDate() {
        return this.date;
    }

    @NotNull
    public final ImageMessage getImageMessage() {
        return this.imageMessage;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final LocationMessage getLocationMessage() {
        return this.locationMessage;
    }

    @NotNull
    public final TextMessage getOriginalMessage() {
        return this.originalMessage;
    }

    @NotNull
    public final Receipt getReceiptState() {
        return this.receiptState;
    }

    public final boolean getSendByMe() {
        return this.sendByMe;
    }

    @Nullable
    public final String getSenderNickName() {
        return this.senderNickName;
    }

    @Nullable
    public final TextMessage getTranslatedMessage() {
        return this.translatedMessage;
    }

    public int hashCode() {
        int hashCode = ((this.index * 31) + this.originalMessage.hashCode()) * 31;
        TextMessage textMessage = this.translatedMessage;
        int i11 = 0;
        int hashCode2 = (((((((hashCode + (textMessage == null ? 0 : textMessage.hashCode())) * 31) + this.imageMessage.hashCode()) * 31) + this.locationMessage.hashCode()) * 31) + this.date.hashCode()) * 31;
        boolean z11 = this.sendByMe;
        if (z11) {
            z11 = true;
        }
        int hashCode3 = (((hashCode2 + (z11 ? 1 : 0)) * 31) + this.receiptState.hashCode()) * 31;
        BaseMessage baseMessage = this.chatMessage;
        int hashCode4 = (hashCode3 + (baseMessage == null ? 0 : baseMessage.hashCode())) * 31;
        String str = this.senderNickName;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode4 + i11;
    }

    public final void setImageMessage(@NotNull ImageMessage imageMessage2) {
        Intrinsics.checkNotNullParameter(imageMessage2, "<set-?>");
        this.imageMessage = imageMessage2;
    }

    public final void setLocationMessage(@NotNull LocationMessage locationMessage2) {
        Intrinsics.checkNotNullParameter(locationMessage2, "<set-?>");
        this.locationMessage = locationMessage2;
    }

    public final void setOriginalMessage(@NotNull TextMessage textMessage) {
        Intrinsics.checkNotNullParameter(textMessage, "<set-?>");
        this.originalMessage = textMessage;
    }

    public final void setReceiptState(@NotNull Receipt receipt) {
        Intrinsics.checkNotNullParameter(receipt, "<set-?>");
        this.receiptState = receipt;
    }

    public final void setTranslatedMessage(@Nullable TextMessage textMessage) {
        this.translatedMessage = textMessage;
    }

    @NotNull
    public String toString() {
        return "ChatMessageViewModel(index=" + this.index + ", originalMessage=" + this.originalMessage + ", translatedMessage=" + this.translatedMessage + ", imageMessage=" + this.imageMessage + ", locationMessage=" + this.locationMessage + ", date=" + this.date + ", sendByMe=" + this.sendByMe + ", receiptState=" + this.receiptState + ", chatMessage=" + this.chatMessage + ", senderNickName=" + this.senderNickName + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChatMessageViewModel(int r17, com.deliveryhero.chatui.view.chatroom.TextMessage r18, com.deliveryhero.chatui.view.chatroom.TextMessage r19, com.deliveryhero.chatui.view.chatroom.ImageMessage r20, com.deliveryhero.chatui.view.chatroom.LocationMessage r21, java.lang.String r22, boolean r23, com.deliveryhero.contract.model.Receipt r24, com.deliveryhero.contract.model.BaseMessage r25, java.lang.String r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r16 = this;
            r0 = r27
            r1 = r0 & 2
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x0010
            com.deliveryhero.chatui.view.chatroom.TextMessage r1 = new com.deliveryhero.chatui.view.chatroom.TextMessage
            r4 = 3
            r1.<init>(r2, r3, r4, r3)
            r7 = r1
            goto L_0x0012
        L_0x0010:
            r7 = r18
        L_0x0012:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0018
            r8 = r3
            goto L_0x001a
        L_0x0018:
            r8 = r19
        L_0x001a:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0026
            com.deliveryhero.chatui.view.chatroom.ImageMessage$Hidden r1 = new com.deliveryhero.chatui.view.chatroom.ImageMessage$Hidden
            r4 = 1
            r1.<init>(r2, r4, r3)
            r9 = r1
            goto L_0x0028
        L_0x0026:
            r9 = r20
        L_0x0028:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0030
            com.deliveryhero.chatui.view.chatroom.LocationMessage$Hidden r1 = com.deliveryhero.chatui.view.chatroom.LocationMessage.Hidden.INSTANCE
            r10 = r1
            goto L_0x0032
        L_0x0030:
            r10 = r21
        L_0x0032:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0038
            r14 = r3
            goto L_0x003a
        L_0x0038:
            r14 = r25
        L_0x003a:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0040
            r15 = r3
            goto L_0x0042
        L_0x0040:
            r15 = r26
        L_0x0042:
            r5 = r16
            r6 = r17
            r11 = r22
            r12 = r23
            r13 = r24
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel.<init>(int, com.deliveryhero.chatui.view.chatroom.TextMessage, com.deliveryhero.chatui.view.chatroom.TextMessage, com.deliveryhero.chatui.view.chatroom.ImageMessage, com.deliveryhero.chatui.view.chatroom.LocationMessage, java.lang.String, boolean, com.deliveryhero.contract.model.Receipt, com.deliveryhero.contract.model.BaseMessage, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
