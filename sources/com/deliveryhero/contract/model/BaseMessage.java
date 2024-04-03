package com.deliveryhero.contract.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0010R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/contract/model/BaseMessage;", "", "correlationId", "", "getCorrelationId", "()Ljava/lang/String;", "createdAt", "", "getCreatedAt", "()J", "messageId", "getMessageId", "metadata", "Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "getMetadata", "()Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "MetaData", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BaseMessage {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/contract/model/BaseMessage$MetaData;", "", "userCount", "", "(I)V", "getUserCount", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MetaData {
        private final int userCount;

        public MetaData(int i11) {
            this.userCount = i11;
        }

        public static /* synthetic */ MetaData copy$default(MetaData metaData, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = metaData.userCount;
            }
            return metaData.copy(i11);
        }

        public final int component1() {
            return this.userCount;
        }

        @NotNull
        public final MetaData copy(int i11) {
            return new MetaData(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MetaData) && this.userCount == ((MetaData) obj).userCount;
        }

        public final int getUserCount() {
            return this.userCount;
        }

        public int hashCode() {
            return this.userCount;
        }

        @NotNull
        public String toString() {
            return "MetaData(userCount=" + this.userCount + ')';
        }
    }

    @Nullable
    String getCorrelationId();

    long getCreatedAt();

    @NotNull
    String getMessageId();

    @Nullable
    MetaData getMetadata();
}
