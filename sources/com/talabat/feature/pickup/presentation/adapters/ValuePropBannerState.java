package com.talabat.feature.pickup.presentation.adapters;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerState;", "", "()V", "Banner", "Hidden", "Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerState$Hidden;", "Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerState$Banner;", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ValuePropBannerState {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerState$Banner;", "Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerState;", "title", "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Banner extends ValuePropBannerState {
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Banner(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerState$Hidden;", "Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerState;", "()V", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends ValuePropBannerState {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    private ValuePropBannerState() {
    }

    public /* synthetic */ ValuePropBannerState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
