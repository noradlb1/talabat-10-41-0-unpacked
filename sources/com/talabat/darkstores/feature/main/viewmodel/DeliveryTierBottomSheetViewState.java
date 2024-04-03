package com.talabat.darkstores.feature.main.viewmodel;

import com.talabat.darkstores.feature.cart.model.ScreenTrackingInfo;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewState;", "", "bottomSheetViewState", "Lcom/talabat/darkstores/feature/main/viewmodel/BottomSheetViewState;", "clickOrigin", "Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierClickOrigin;", "screenTrackingInfo", "Lcom/talabat/darkstores/feature/cart/model/ScreenTrackingInfo;", "(Lcom/talabat/darkstores/feature/main/viewmodel/BottomSheetViewState;Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierClickOrigin;Lcom/talabat/darkstores/feature/cart/model/ScreenTrackingInfo;)V", "getBottomSheetViewState", "()Lcom/talabat/darkstores/feature/main/viewmodel/BottomSheetViewState;", "getClickOrigin", "()Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierClickOrigin;", "getScreenTrackingInfo", "()Lcom/talabat/darkstores/feature/cart/model/ScreenTrackingInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryTierBottomSheetViewState {
    @NotNull
    private final BottomSheetViewState bottomSheetViewState;
    @NotNull
    private final DeliveryTierClickOrigin clickOrigin;
    @NotNull
    private final ScreenTrackingInfo screenTrackingInfo;

    public DeliveryTierBottomSheetViewState(@NotNull BottomSheetViewState bottomSheetViewState2, @NotNull DeliveryTierClickOrigin deliveryTierClickOrigin, @NotNull ScreenTrackingInfo screenTrackingInfo2) {
        Intrinsics.checkNotNullParameter(bottomSheetViewState2, "bottomSheetViewState");
        Intrinsics.checkNotNullParameter(deliveryTierClickOrigin, ConstantsKt.CLICK_CLICK_ORIGIN);
        Intrinsics.checkNotNullParameter(screenTrackingInfo2, "screenTrackingInfo");
        this.bottomSheetViewState = bottomSheetViewState2;
        this.clickOrigin = deliveryTierClickOrigin;
        this.screenTrackingInfo = screenTrackingInfo2;
    }

    public static /* synthetic */ DeliveryTierBottomSheetViewState copy$default(DeliveryTierBottomSheetViewState deliveryTierBottomSheetViewState, BottomSheetViewState bottomSheetViewState2, DeliveryTierClickOrigin deliveryTierClickOrigin, ScreenTrackingInfo screenTrackingInfo2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bottomSheetViewState2 = deliveryTierBottomSheetViewState.bottomSheetViewState;
        }
        if ((i11 & 2) != 0) {
            deliveryTierClickOrigin = deliveryTierBottomSheetViewState.clickOrigin;
        }
        if ((i11 & 4) != 0) {
            screenTrackingInfo2 = deliveryTierBottomSheetViewState.screenTrackingInfo;
        }
        return deliveryTierBottomSheetViewState.copy(bottomSheetViewState2, deliveryTierClickOrigin, screenTrackingInfo2);
    }

    @NotNull
    public final BottomSheetViewState component1() {
        return this.bottomSheetViewState;
    }

    @NotNull
    public final DeliveryTierClickOrigin component2() {
        return this.clickOrigin;
    }

    @NotNull
    public final ScreenTrackingInfo component3() {
        return this.screenTrackingInfo;
    }

    @NotNull
    public final DeliveryTierBottomSheetViewState copy(@NotNull BottomSheetViewState bottomSheetViewState2, @NotNull DeliveryTierClickOrigin deliveryTierClickOrigin, @NotNull ScreenTrackingInfo screenTrackingInfo2) {
        Intrinsics.checkNotNullParameter(bottomSheetViewState2, "bottomSheetViewState");
        Intrinsics.checkNotNullParameter(deliveryTierClickOrigin, ConstantsKt.CLICK_CLICK_ORIGIN);
        Intrinsics.checkNotNullParameter(screenTrackingInfo2, "screenTrackingInfo");
        return new DeliveryTierBottomSheetViewState(bottomSheetViewState2, deliveryTierClickOrigin, screenTrackingInfo2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliveryTierBottomSheetViewState)) {
            return false;
        }
        DeliveryTierBottomSheetViewState deliveryTierBottomSheetViewState = (DeliveryTierBottomSheetViewState) obj;
        return this.bottomSheetViewState == deliveryTierBottomSheetViewState.bottomSheetViewState && this.clickOrigin == deliveryTierBottomSheetViewState.clickOrigin && Intrinsics.areEqual((Object) this.screenTrackingInfo, (Object) deliveryTierBottomSheetViewState.screenTrackingInfo);
    }

    @NotNull
    public final BottomSheetViewState getBottomSheetViewState() {
        return this.bottomSheetViewState;
    }

    @NotNull
    public final DeliveryTierClickOrigin getClickOrigin() {
        return this.clickOrigin;
    }

    @NotNull
    public final ScreenTrackingInfo getScreenTrackingInfo() {
        return this.screenTrackingInfo;
    }

    public int hashCode() {
        return (((this.bottomSheetViewState.hashCode() * 31) + this.clickOrigin.hashCode()) * 31) + this.screenTrackingInfo.hashCode();
    }

    @NotNull
    public String toString() {
        BottomSheetViewState bottomSheetViewState2 = this.bottomSheetViewState;
        DeliveryTierClickOrigin deliveryTierClickOrigin = this.clickOrigin;
        ScreenTrackingInfo screenTrackingInfo2 = this.screenTrackingInfo;
        return "DeliveryTierBottomSheetViewState(bottomSheetViewState=" + bottomSheetViewState2 + ", clickOrigin=" + deliveryTierClickOrigin + ", screenTrackingInfo=" + screenTrackingInfo2 + ")";
    }
}
