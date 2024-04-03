package com.talabat.feature.darkstorescarrierbag.presentation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent;", "", "()V", "ContinueToCheckout", "HideBottomSheet", "OnOptionSelected", "ShowBottomSheet", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent$ShowBottomSheet;", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent$OnOptionSelected;", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent$HideBottomSheet;", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent$ContinueToCheckout;", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DarkstoresCarrierBagEvent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent$ContinueToCheckout;", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent;", "()V", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ContinueToCheckout extends DarkstoresCarrierBagEvent {
        @NotNull
        public static final ContinueToCheckout INSTANCE = new ContinueToCheckout();

        private ContinueToCheckout() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent$HideBottomSheet;", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent;", "()V", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HideBottomSheet extends DarkstoresCarrierBagEvent {
        @NotNull
        public static final HideBottomSheet INSTANCE = new HideBottomSheet();

        private HideBottomSheet() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent$OnOptionSelected;", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent;", "option", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/CarrierBagOption;", "(Lcom/talabat/feature/darkstorescarrierbag/presentation/model/CarrierBagOption;)V", "getOption", "()Lcom/talabat/feature/darkstorescarrierbag/presentation/model/CarrierBagOption;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OnOptionSelected extends DarkstoresCarrierBagEvent {
        @NotNull
        private final CarrierBagOption option;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnOptionSelected(@NotNull CarrierBagOption carrierBagOption) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(carrierBagOption, "option");
            this.option = carrierBagOption;
        }

        public static /* synthetic */ OnOptionSelected copy$default(OnOptionSelected onOptionSelected, CarrierBagOption carrierBagOption, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                carrierBagOption = onOptionSelected.option;
            }
            return onOptionSelected.copy(carrierBagOption);
        }

        @NotNull
        public final CarrierBagOption component1() {
            return this.option;
        }

        @NotNull
        public final OnOptionSelected copy(@NotNull CarrierBagOption carrierBagOption) {
            Intrinsics.checkNotNullParameter(carrierBagOption, "option");
            return new OnOptionSelected(carrierBagOption);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnOptionSelected) && this.option == ((OnOptionSelected) obj).option;
        }

        @NotNull
        public final CarrierBagOption getOption() {
            return this.option;
        }

        public int hashCode() {
            return this.option.hashCode();
        }

        @NotNull
        public String toString() {
            CarrierBagOption carrierBagOption = this.option;
            return "OnOptionSelected(option=" + carrierBagOption + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent$ShowBottomSheet;", "Lcom/talabat/feature/darkstorescarrierbag/presentation/model/DarkstoresCarrierBagEvent;", "()V", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowBottomSheet extends DarkstoresCarrierBagEvent {
        @NotNull
        public static final ShowBottomSheet INSTANCE = new ShowBottomSheet();

        private ShowBottomSheet() {
            super((DefaultConstructorMarker) null);
        }
    }

    private DarkstoresCarrierBagEvent() {
    }

    public /* synthetic */ DarkstoresCarrierBagEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
