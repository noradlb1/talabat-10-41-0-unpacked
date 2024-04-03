package com.talabat.feature.tpro.presentation.multiplan.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0017R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/multiplan/viewmodel/TProPlanSelectionViewModel;", "Landroidx/lifecycle/ViewModel;", "subscriptionsTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;)V", "_selectedItem", "Landroidx/lifecycle/MutableLiveData;", "", "selectedItem", "Landroidx/lifecycle/LiveData;", "getSelectedItem", "()Landroidx/lifecycle/LiveData;", "selectedPlan", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "getSelectedPlan", "()Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "tProPlans", "", "getTProPlans", "()Ljava/util/List;", "setTProPlans", "(Ljava/util/List;)V", "setSelectedIndex", "", "index", "tProPlanChanged", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProPlanSelectionViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TPRO_PLAN_SELECTION_SCREEN_NAME = "tpro plan selection screen";
    @NotNull
    public static final String TPRO_PLAN_SELECTION_SCREEN_TYPE = "plan_selection";
    @NotNull
    private final MutableLiveData<Integer> _selectedItem = new MutableLiveData<>(null);
    @NotNull
    private final ISubscriptionsTracker subscriptionsTracker;
    public List<TProPlanDisplayModel> tProPlans;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/tpro/presentation/multiplan/viewmodel/TProPlanSelectionViewModel$Companion;", "", "()V", "TPRO_PLAN_SELECTION_SCREEN_NAME", "", "TPRO_PLAN_SELECTION_SCREEN_TYPE", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public TProPlanSelectionViewModel(@NotNull ISubscriptionsTracker iSubscriptionsTracker) {
        Intrinsics.checkNotNullParameter(iSubscriptionsTracker, "subscriptionsTracker");
        this.subscriptionsTracker = iSubscriptionsTracker;
    }

    @NotNull
    public final LiveData<Integer> getSelectedItem() {
        return this._selectedItem;
    }

    @Nullable
    public final TProPlanDisplayModel getSelectedPlan() {
        Integer value = this._selectedItem.getValue();
        if (value == null) {
            return null;
        }
        return getTProPlans().get(value.intValue());
    }

    @NotNull
    public final List<TProPlanDisplayModel> getTProPlans() {
        List<TProPlanDisplayModel> list = this.tProPlans;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tProPlans");
        return null;
    }

    public final void setSelectedIndex(int i11) {
        this._selectedItem.postValue(Integer.valueOf(i11));
    }

    public final void setTProPlans(@NotNull List<TProPlanDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tProPlans = list;
    }

    public final void tProPlanChanged() {
        String planId;
        TProPlanDisplayModel selectedPlan = getSelectedPlan();
        if (selectedPlan != null && (planId = selectedPlan.getPlanId()) != null) {
            this.subscriptionsTracker.tProPlanClicked(TPRO_PLAN_SELECTION_SCREEN_TYPE, TPRO_PLAN_SELECTION_SCREEN_NAME, planId);
        }
    }
}
