package com.talabat.talabatcommon.feature.pickupToggle.domain;

import buisnessmodels.Customer;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListExperimentsKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/feature/pickupToggle/domain/ShowTabBarUseCase;", "", "shouldShowTabBar", "", "experiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "customer", "Lbuisnessmodels/Customer;", "(ZLcom/talabat/core/experiment/domain/ITalabatExperiment;Lbuisnessmodels/Customer;)V", "getCustomer", "()Lbuisnessmodels/Customer;", "getExperiment", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "isRevampedTabBar", "isRevampedTabBarWithIcon", "revampedToggleExperiment", "", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShowTabBarUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXP_DESIGN_TYPE_ORIGINAL = "Control";
    @NotNull
    public static final String EXP_DESIGN_TYPE_REVAMP_WITH_ICON = "Variation2";
    @NotNull
    private final Customer customer;
    @NotNull
    private final ITalabatExperiment experiment;
    private final boolean shouldShowTabBar;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/feature/pickupToggle/domain/ShowTabBarUseCase$Companion;", "", "()V", "EXP_DESIGN_TYPE_ORIGINAL", "", "EXP_DESIGN_TYPE_REVAMP_WITH_ICON", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShowTabBarUseCase(boolean z11, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull Customer customer2) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT);
        Intrinsics.checkNotNullParameter(customer2, "customer");
        this.shouldShowTabBar = z11;
        this.experiment = iTalabatExperiment;
        this.customer = customer2;
    }

    private final String revampedToggleExperiment() {
        return this.experiment.getStringVariant(VendorListExperimentsKeys.PICKUP_TOGGLE_REVAMP, "Control", TalabatExperimentDataSourceStrategy.FWF);
    }

    @NotNull
    public final Customer getCustomer() {
        return this.customer;
    }

    @NotNull
    public final ITalabatExperiment getExperiment() {
        return this.experiment;
    }

    public final boolean isRevampedTabBar() {
        return !Intrinsics.areEqual((Object) revampedToggleExperiment(), (Object) "Control");
    }

    public final boolean isRevampedTabBarWithIcon() {
        return Intrinsics.areEqual((Object) revampedToggleExperiment(), (Object) "Variation2");
    }

    public final boolean shouldShowTabBar() {
        return this.customer.isLoggedIn() && this.shouldShowTabBar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShowTabBarUseCase(boolean r1, com.talabat.core.experiment.domain.ITalabatExperiment r2, buisnessmodels.Customer r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 4
            if (r4 == 0) goto L_0x000d
            buisnessmodels.Customer r3 = buisnessmodels.Customer.getInstance()
            java.lang.String r4 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L_0x000d:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.pickupToggle.domain.ShowTabBarUseCase.<init>(boolean, com.talabat.core.experiment.domain.ITalabatExperiment, buisnessmodels.Customer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
