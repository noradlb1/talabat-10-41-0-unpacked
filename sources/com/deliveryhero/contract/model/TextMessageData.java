package com.deliveryhero.contract.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/contract/model/TextMessageData;", "", "message", "", "correlationID", "(Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationID", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextMessageData {
    @NotNull
    private final String correlationID;
    @NotNull
    private final String message;

    public TextMessageData(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "correlationID");
        this.message = str;
        this.correlationID = str2;
    }

    public static /* synthetic */ TextMessageData copy$default(TextMessageData textMessageData, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = textMessageData.message;
        }
        if ((i11 & 2) != 0) {
            str2 = textMessageData.correlationID;
        }
        return textMessageData.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final String component2() {
        return this.correlationID;
    }

    @NotNull
    public final TextMessageData copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "correlationID");
        return new TextMessageData(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextMessageData)) {
            return false;
        }
        TextMessageData textMessageData = (TextMessageData) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) textMessageData.message) && Intrinsics.areEqual((Object) this.correlationID, (Object) textMessageData.correlationID);
    }

    @NotNull
    public final String getCorrelationID() {
        return this.correlationID;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.correlationID.hashCode();
    }

    @NotNull
    public String toString() {
        return "TextMessageData(message=" + this.message + ", correlationID=" + this.correlationID + ')';
    }
}
