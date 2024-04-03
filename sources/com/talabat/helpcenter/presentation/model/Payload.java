package com.talabat.helpcenter.presentation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/helpcenter/presentation/model/Payload;", "", "chatId", "", "(Ljava/lang/String;)V", "getChatId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Payload {
    @NotNull
    private final String chatId;

    public Payload(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "chatId");
        this.chatId = str;
    }

    public static /* synthetic */ Payload copy$default(Payload payload, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = payload.chatId;
        }
        return payload.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.chatId;
    }

    @NotNull
    public final Payload copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "chatId");
        return new Payload(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Payload) && Intrinsics.areEqual((Object) this.chatId, (Object) ((Payload) obj).chatId);
    }

    @NotNull
    public final String getChatId() {
        return this.chatId;
    }

    public int hashCode() {
        return this.chatId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.chatId;
        return "Payload(chatId=" + str + ")";
    }
}
