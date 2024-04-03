package com.talabat.restaurants.domain;

import buisnessmodels.Customer;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListExperimentsKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/restaurants/domain/ShowTooltipUseCase;", "", "experiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "getExperiment", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "experimentValue", "", "getTooltipExperimentValue", "isControlVariant", "", "isFirstVariant", "isSecondVariant", "shouldShowPickupTooltip", "isTopOfTheRestaurantList", "preferenceManager", "Llibrary/talabat/SharedPreferencesManager;", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShowTooltipUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String HIDE_TOOLTIP = "Control";
    @NotNull
    public static final String SHOW_TEXT_VARIANT_1 = "Variation1";
    @NotNull
    public static final String SHOW_TEXT_VARIANT_2 = "Variation2";
    /* access modifiers changed from: private */
    public static boolean seenInSession;
    @NotNull
    private final ITalabatExperiment experiment;
    @NotNull
    private final String experimentValue = getTooltipExperimentValue();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/talabat/restaurants/domain/ShowTooltipUseCase$Companion;", "", "()V", "HIDE_TOOLTIP", "", "SHOW_TEXT_VARIANT_1", "SHOW_TEXT_VARIANT_2", "seenInSession", "", "getSeenInSession", "()Z", "setSeenInSession", "(Z)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getSeenInSession() {
            return ShowTooltipUseCase.seenInSession;
        }

        public final void setSeenInSession(boolean z11) {
            ShowTooltipUseCase.seenInSession = z11;
        }
    }

    public ShowTooltipUseCase(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT);
        this.experiment = iTalabatExperiment;
        getTooltipExperimentValue();
    }

    private final String getTooltipExperimentValue() {
        return this.experiment.getStringVariant(VendorListExperimentsKeys.PICKUP_TOOL_TIP, "Control", TalabatExperimentDataSourceStrategy.FWF);
    }

    private final boolean isControlVariant() {
        return Intrinsics.areEqual((Object) this.experimentValue, (Object) "Control");
    }

    @NotNull
    public final ITalabatExperiment getExperiment() {
        return this.experiment;
    }

    public final boolean isFirstVariant() {
        return Intrinsics.areEqual((Object) this.experimentValue, (Object) "Variation1");
    }

    public final boolean isSecondVariant() {
        return Intrinsics.areEqual((Object) this.experimentValue, (Object) "Variation2");
    }

    public final boolean shouldShowPickupTooltip(boolean z11, @NotNull SharedPreferencesManager sharedPreferencesManager) {
        Intrinsics.checkNotNullParameter(sharedPreferencesManager, "preferenceManager");
        if (sharedPreferencesManager.didInteractedWithPickupTooltip() || isControlVariant() || !z11 || !Customer.getInstance().isLoggedIn()) {
            return false;
        }
        return true;
    }
}
