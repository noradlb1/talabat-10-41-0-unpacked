package com.talabat.feature.darkstorestooltip.presentation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewState;", "", "()V", "Hidden", "Shown", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewState$Shown;", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewState$Hidden;", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TooltipViewState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewState$Hidden;", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewState;", "()V", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends TooltipViewState {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewState$Shown;", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewState;", "tooltipData", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipData;", "(Lcom/talabat/feature/darkstorestooltip/presentation/TooltipData;)V", "getTooltipData", "()Lcom/talabat/feature/darkstorestooltip/presentation/TooltipData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Shown extends TooltipViewState {
        @NotNull
        private final TooltipData tooltipData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Shown(@NotNull TooltipData tooltipData2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(tooltipData2, "tooltipData");
            this.tooltipData = tooltipData2;
        }

        public static /* synthetic */ Shown copy$default(Shown shown, TooltipData tooltipData2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                tooltipData2 = shown.tooltipData;
            }
            return shown.copy(tooltipData2);
        }

        @NotNull
        public final TooltipData component1() {
            return this.tooltipData;
        }

        @NotNull
        public final Shown copy(@NotNull TooltipData tooltipData2) {
            Intrinsics.checkNotNullParameter(tooltipData2, "tooltipData");
            return new Shown(tooltipData2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Shown) && Intrinsics.areEqual((Object) this.tooltipData, (Object) ((Shown) obj).tooltipData);
        }

        @NotNull
        public final TooltipData getTooltipData() {
            return this.tooltipData;
        }

        public int hashCode() {
            return this.tooltipData.hashCode();
        }

        @NotNull
        public String toString() {
            TooltipData tooltipData2 = this.tooltipData;
            return "Shown(tooltipData=" + tooltipData2 + ")";
        }
    }

    private TooltipViewState() {
    }

    public /* synthetic */ TooltipViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
