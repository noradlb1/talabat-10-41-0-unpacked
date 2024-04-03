package com.talabat.darkstores.feature.cart.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/cart/model/BottomCartViewState;", "", "()V", "HideBottomCartViewState", "ShowBottomCartViewState", "Lcom/talabat/darkstores/feature/cart/model/BottomCartViewState$ShowBottomCartViewState;", "Lcom/talabat/darkstores/feature/cart/model/BottomCartViewState$HideBottomCartViewState;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BottomCartViewState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/cart/model/BottomCartViewState$HideBottomCartViewState;", "Lcom/talabat/darkstores/feature/cart/model/BottomCartViewState;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HideBottomCartViewState extends BottomCartViewState {
        @NotNull
        public static final HideBottomCartViewState INSTANCE = new HideBottomCartViewState();

        private HideBottomCartViewState() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/cart/model/BottomCartViewState$ShowBottomCartViewState;", "Lcom/talabat/darkstores/feature/cart/model/BottomCartViewState;", "screenTrackingInfo", "Lcom/talabat/darkstores/feature/cart/model/ScreenTrackingInfo;", "(Lcom/talabat/darkstores/feature/cart/model/ScreenTrackingInfo;)V", "getScreenTrackingInfo", "()Lcom/talabat/darkstores/feature/cart/model/ScreenTrackingInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowBottomCartViewState extends BottomCartViewState {
        @NotNull
        private final ScreenTrackingInfo screenTrackingInfo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowBottomCartViewState(@NotNull ScreenTrackingInfo screenTrackingInfo2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(screenTrackingInfo2, "screenTrackingInfo");
            this.screenTrackingInfo = screenTrackingInfo2;
        }

        public static /* synthetic */ ShowBottomCartViewState copy$default(ShowBottomCartViewState showBottomCartViewState, ScreenTrackingInfo screenTrackingInfo2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                screenTrackingInfo2 = showBottomCartViewState.screenTrackingInfo;
            }
            return showBottomCartViewState.copy(screenTrackingInfo2);
        }

        @NotNull
        public final ScreenTrackingInfo component1() {
            return this.screenTrackingInfo;
        }

        @NotNull
        public final ShowBottomCartViewState copy(@NotNull ScreenTrackingInfo screenTrackingInfo2) {
            Intrinsics.checkNotNullParameter(screenTrackingInfo2, "screenTrackingInfo");
            return new ShowBottomCartViewState(screenTrackingInfo2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowBottomCartViewState) && Intrinsics.areEqual((Object) this.screenTrackingInfo, (Object) ((ShowBottomCartViewState) obj).screenTrackingInfo);
        }

        @NotNull
        public final ScreenTrackingInfo getScreenTrackingInfo() {
            return this.screenTrackingInfo;
        }

        public int hashCode() {
            return this.screenTrackingInfo.hashCode();
        }

        @NotNull
        public String toString() {
            ScreenTrackingInfo screenTrackingInfo2 = this.screenTrackingInfo;
            return "ShowBottomCartViewState(screenTrackingInfo=" + screenTrackingInfo2 + ")";
        }
    }

    private BottomCartViewState() {
    }

    public /* synthetic */ BottomCartViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
