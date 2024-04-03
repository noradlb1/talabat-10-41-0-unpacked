package com.talabat.feature.tpro.presentation.multiplan;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.designsystem.ds_radiobutton.DSRadioButton;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.feature.tpro.presentation.databinding.ItemPlanSelectionBinding;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/tpro/presentation/multiplan/PlanSelectionItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "inflater", "Landroid/view/LayoutInflater;", "planDisplayModel", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "(Landroid/content/Context;Landroid/view/LayoutInflater;Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;)V", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemPlanSelectionBinding;", "rbSelection", "Lcom/designsystem/ds_radiobutton/DSRadioButton;", "tvPlanName", "Landroid/widget/TextView;", "tvPlanPricing", "tvPlanPricingDescription", "getInitialLayoutParams", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "setInitialAttributes", "", "setSelected", "selected", "", "updateUI", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlanSelectionItemView extends ConstraintLayout {
    @NotNull
    private final ItemPlanSelectionBinding binding;
    @NotNull
    private final DSRadioButton rbSelection;
    @NotNull
    private final TextView tvPlanName;
    @NotNull
    private final TextView tvPlanPricing;
    @NotNull
    private final TextView tvPlanPricingDescription;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlanSelectionItemView(@NotNull Context context, @NotNull LayoutInflater layoutInflater, @NotNull TProPlanDisplayModel tProPlanDisplayModel) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(tProPlanDisplayModel, "planDisplayModel");
        ItemPlanSelectionBinding inflate = ItemPlanSelectionBinding.inflate(layoutInflater, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, this)");
        this.binding = inflate;
        TextView textView = inflate.tvPlanName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvPlanName");
        this.tvPlanName = textView;
        TextView textView2 = inflate.tvPlanPricing;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvPlanPricing");
        this.tvPlanPricing = textView2;
        TextView textView3 = inflate.tvPlanPricingDescription;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvPlanPricingDescription");
        this.tvPlanPricingDescription = textView3;
        DSRadioButton dSRadioButton = inflate.rbPlanSelection;
        Intrinsics.checkNotNullExpressionValue(dSRadioButton, "binding.rbPlanSelection");
        this.rbSelection = dSRadioButton;
        layoutInflater.inflate(R.layout.item_plan_selection, this);
        textView.setText(tProPlanDisplayModel.getPlanPeriod());
        textView2.setText(tProPlanDisplayModel.getPeriodPrice());
        textView3.setText(tProPlanDisplayModel.getBillingCycle());
        setInitialAttributes();
    }

    private final ConstraintLayout.LayoutParams getInitialLayoutParams() {
        if (getLayoutParams() == null) {
            return new ConstraintLayout.LayoutParams(-1, -2);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            return (ConstraintLayout.LayoutParams) layoutParams;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    private final void setInitialAttributes() {
        ConstraintLayout.LayoutParams initialLayoutParams = getInitialLayoutParams();
        Resources resources = getResources();
        int i11 = com.designsystem.marshmallow.R.dimen.ds_s;
        initialLayoutParams.topMargin = (int) resources.getDimension(i11);
        setLayoutParams(initialLayoutParams);
        setBackground(getResources().getDrawable(R.drawable.bg_selectable_border, (Resources.Theme) null));
        int dimension = (int) getResources().getDimension(i11);
        setPadding(dimension, dimension, dimension, dimension);
    }

    private final void updateUI() {
        int i11;
        Resources resources = getResources();
        if (isSelected()) {
            i11 = R.drawable.bg_selectable_border_selected;
        } else {
            i11 = R.drawable.bg_selectable_border;
        }
        setBackground(resources.getDrawable(i11, (Resources.Theme) null));
        this.rbSelection.setChecked(isSelected());
    }

    public void setSelected(boolean z11) {
        super.setSelected(z11);
        updateUI();
    }
}
