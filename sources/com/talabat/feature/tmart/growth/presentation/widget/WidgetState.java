package com.talabat.feature.tmart.growth.presentation.widget;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState;", "", "()V", "Hidden", "Loading", "Success", "Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState$Loading;", "Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState$Hidden;", "Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState$Success;", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WidgetState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState$Hidden;", "Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState;", "()V", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends WidgetState {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState$Loading;", "Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState;", "()V", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends WidgetState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState$Success;", "Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState;", "model", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "(Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;)V", "getModel", "()Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Success extends WidgetState {
        @NotNull
        private final TMartGrowthClaimDisplayModel model;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(tMartGrowthClaimDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            this.model = tMartGrowthClaimDisplayModel;
        }

        public static /* synthetic */ Success copy$default(Success success, TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                tMartGrowthClaimDisplayModel = success.model;
            }
            return success.copy(tMartGrowthClaimDisplayModel);
        }

        @NotNull
        public final TMartGrowthClaimDisplayModel component1() {
            return this.model;
        }

        @NotNull
        public final Success copy(@NotNull TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel) {
            Intrinsics.checkNotNullParameter(tMartGrowthClaimDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            return new Success(tMartGrowthClaimDisplayModel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.model, (Object) ((Success) obj).model);
        }

        @NotNull
        public final TMartGrowthClaimDisplayModel getModel() {
            return this.model;
        }

        public int hashCode() {
            return this.model.hashCode();
        }

        @NotNull
        public String toString() {
            TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel = this.model;
            return "Success(model=" + tMartGrowthClaimDisplayModel + ")";
        }
    }

    private WidgetState() {
    }

    public /* synthetic */ WidgetState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
