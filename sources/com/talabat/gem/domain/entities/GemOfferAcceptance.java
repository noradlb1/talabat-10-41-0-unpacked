package com.talabat.gem.domain.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "", "()V", "Accepted", "Failed", "Rejected", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Accepted;", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Rejected;", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Failed;", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class GemOfferAcceptance {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Accepted;", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "()V", "toString", "", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Accepted extends GemOfferAcceptance {
        @NotNull
        public static final Accepted INSTANCE = new Accepted();

        private Accepted() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public String toString() {
            return "Accepted";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Failed;", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "toString", "", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Failed extends GemOfferAcceptance {
        @NotNull
        private final Throwable error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failed(@NotNull Throwable th2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th2, "error");
            this.error = th2;
        }

        @NotNull
        public final Throwable getError() {
            return this.error;
        }

        @NotNull
        public String toString() {
            String message = this.error.getMessage();
            if (message == null) {
                message = this.error.toString();
            }
            return "Failed (" + message + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Rejected;", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "()V", "toString", "", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Rejected extends GemOfferAcceptance {
        @NotNull
        public static final Rejected INSTANCE = new Rejected();

        private Rejected() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public String toString() {
            return "Rejected";
        }
    }

    private GemOfferAcceptance() {
    }

    public /* synthetic */ GemOfferAcceptance(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
