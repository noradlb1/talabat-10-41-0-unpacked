package com.deliveryhero.chatsdk.network.websocket.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/MetaDataContent;", "", "userCount", "", "(I)V", "getUserCount", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MetaDataContent {
    private final int userCount;

    public MetaDataContent(@Json(name = "user_count") int i11) {
        this.userCount = i11;
    }

    public static /* synthetic */ MetaDataContent copy$default(MetaDataContent metaDataContent, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = metaDataContent.userCount;
        }
        return metaDataContent.copy(i11);
    }

    public final int component1() {
        return this.userCount;
    }

    @NotNull
    public final MetaDataContent copy(@Json(name = "user_count") int i11) {
        return new MetaDataContent(i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MetaDataContent) && this.userCount == ((MetaDataContent) obj).userCount;
    }

    public final int getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        return this.userCount;
    }

    @NotNull
    public String toString() {
        return "MetaDataContent(userCount=" + this.userCount + ')';
    }
}
