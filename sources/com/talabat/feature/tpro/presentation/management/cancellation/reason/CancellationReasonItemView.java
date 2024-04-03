package com.talabat.feature.tpro.presentation.management.cancellation.reason;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.designsystem.ds_radiobutton.DSRadioButton;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationReason;
import com.talabat.feature.tpro.presentation.databinding.ItemCancellationReasonBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/CancellationReasonItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "inflater", "Landroid/view/LayoutInflater;", "cancellationReason", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationReason;", "(Landroid/content/Context;Landroid/view/LayoutInflater;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationReason;)V", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemCancellationReasonBinding;", "rbSelection", "Lcom/designsystem/ds_radiobutton/DSRadioButton;", "tvReason", "Landroid/widget/TextView;", "setSelected", "", "selected", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationReasonItemView extends ConstraintLayout {
    @NotNull
    private final ItemCancellationReasonBinding binding;
    @NotNull
    private final DSRadioButton rbSelection;
    @NotNull
    private final TextView tvReason;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancellationReasonItemView(@NotNull Context context, @NotNull LayoutInflater layoutInflater, @NotNull SubscriptionCancellationReason subscriptionCancellationReason) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(subscriptionCancellationReason, "cancellationReason");
        ItemCancellationReasonBinding inflate = ItemCancellationReasonBinding.inflate(layoutInflater, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, this)");
        this.binding = inflate;
        TextView textView = inflate.tvReasonText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvReasonText");
        this.tvReason = textView;
        DSRadioButton dSRadioButton = inflate.rbCancellationReason;
        Intrinsics.checkNotNullExpressionValue(dSRadioButton, "binding.rbCancellationReason");
        this.rbSelection = dSRadioButton;
        textView.setText(subscriptionCancellationReason.getTitle());
    }

    public void setSelected(boolean z11) {
        super.setSelected(z11);
        this.rbSelection.setChecked(isSelected());
    }
}
