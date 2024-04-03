package com.talabat.configuration.orderexperience;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/talabat/configuration/orderexperience/OrderExperienceConfig;", "", "isGoGreen", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderExperienceConfig {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final OrderExperienceConfig DEFAULT = new OrderExperienceConfig(false);
    private final boolean isGoGreen;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/orderexperience/OrderExperienceConfig$Companion;", "", "()V", "DEFAULT", "Lcom/talabat/configuration/orderexperience/OrderExperienceConfig;", "getDEFAULT", "()Lcom/talabat/configuration/orderexperience/OrderExperienceConfig;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderExperienceConfig getDEFAULT() {
            return OrderExperienceConfig.DEFAULT;
        }
    }

    public OrderExperienceConfig(boolean z11) {
        this.isGoGreen = z11;
    }

    public static /* synthetic */ OrderExperienceConfig copy$default(OrderExperienceConfig orderExperienceConfig, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = orderExperienceConfig.isGoGreen;
        }
        return orderExperienceConfig.copy(z11);
    }

    public final boolean component1() {
        return this.isGoGreen;
    }

    @NotNull
    public final OrderExperienceConfig copy(boolean z11) {
        return new OrderExperienceConfig(z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OrderExperienceConfig) && this.isGoGreen == ((OrderExperienceConfig) obj).isGoGreen;
    }

    public int hashCode() {
        boolean z11 = this.isGoGreen;
        if (z11) {
            return 1;
        }
        return z11 ? 1 : 0;
    }

    public final boolean isGoGreen() {
        return this.isGoGreen;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isGoGreen;
        return "OrderExperienceConfig(isGoGreen=" + z11 + ")";
    }
}
