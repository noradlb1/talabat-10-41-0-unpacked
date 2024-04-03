package com.talabat.feature.tpro.presentation.model;

import com.talabat.feature.subscriptions.domain.exception.SubscriptionsErrorMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/tpro/presentation/model/SubscriptionsErrorDisplayModel;", "", "errorMessage", "Lcom/talabat/feature/subscriptions/domain/exception/SubscriptionsErrorMessage;", "shouldClose", "", "(Lcom/talabat/feature/subscriptions/domain/exception/SubscriptionsErrorMessage;Z)V", "getErrorMessage", "()Lcom/talabat/feature/subscriptions/domain/exception/SubscriptionsErrorMessage;", "getShouldClose", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionsErrorDisplayModel {
    @NotNull
    private final SubscriptionsErrorMessage errorMessage;
    private final boolean shouldClose;

    public SubscriptionsErrorDisplayModel(@NotNull SubscriptionsErrorMessage subscriptionsErrorMessage, boolean z11) {
        Intrinsics.checkNotNullParameter(subscriptionsErrorMessage, "errorMessage");
        this.errorMessage = subscriptionsErrorMessage;
        this.shouldClose = z11;
    }

    public static /* synthetic */ SubscriptionsErrorDisplayModel copy$default(SubscriptionsErrorDisplayModel subscriptionsErrorDisplayModel, SubscriptionsErrorMessage subscriptionsErrorMessage, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriptionsErrorMessage = subscriptionsErrorDisplayModel.errorMessage;
        }
        if ((i11 & 2) != 0) {
            z11 = subscriptionsErrorDisplayModel.shouldClose;
        }
        return subscriptionsErrorDisplayModel.copy(subscriptionsErrorMessage, z11);
    }

    @NotNull
    public final SubscriptionsErrorMessage component1() {
        return this.errorMessage;
    }

    public final boolean component2() {
        return this.shouldClose;
    }

    @NotNull
    public final SubscriptionsErrorDisplayModel copy(@NotNull SubscriptionsErrorMessage subscriptionsErrorMessage, boolean z11) {
        Intrinsics.checkNotNullParameter(subscriptionsErrorMessage, "errorMessage");
        return new SubscriptionsErrorDisplayModel(subscriptionsErrorMessage, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionsErrorDisplayModel)) {
            return false;
        }
        SubscriptionsErrorDisplayModel subscriptionsErrorDisplayModel = (SubscriptionsErrorDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.errorMessage, (Object) subscriptionsErrorDisplayModel.errorMessage) && this.shouldClose == subscriptionsErrorDisplayModel.shouldClose;
    }

    @NotNull
    public final SubscriptionsErrorMessage getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getShouldClose() {
        return this.shouldClose;
    }

    public int hashCode() {
        int hashCode = this.errorMessage.hashCode() * 31;
        boolean z11 = this.shouldClose;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        SubscriptionsErrorMessage subscriptionsErrorMessage = this.errorMessage;
        boolean z11 = this.shouldClose;
        return "SubscriptionsErrorDisplayModel(errorMessage=" + subscriptionsErrorMessage + ", shouldClose=" + z11 + ")";
    }
}
