package com.deliveryhero.chatui.view.chatroom;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/TextMessage;", "", "visibility", "", "message", "", "(ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getVisibility", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextMessage {
    @NotNull
    private final String message;
    private final int visibility;

    public TextMessage() {
        this(0, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public TextMessage(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.visibility = i11;
        this.message = str;
    }

    public static /* synthetic */ TextMessage copy$default(TextMessage textMessage, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = textMessage.visibility;
        }
        if ((i12 & 2) != 0) {
            str = textMessage.message;
        }
        return textMessage.copy(i11, str);
    }

    public final int component1() {
        return this.visibility;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final TextMessage copy(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new TextMessage(i11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextMessage)) {
            return false;
        }
        TextMessage textMessage = (TextMessage) obj;
        return this.visibility == textMessage.visibility && Intrinsics.areEqual((Object) this.message, (Object) textMessage.message);
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final int getVisibility() {
        return this.visibility;
    }

    public int hashCode() {
        return (this.visibility * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        return "TextMessage(visibility=" + this.visibility + ", message=" + this.message + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextMessage(int i11, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, (i12 & 2) != 0 ? "" : str);
    }
}
