package com.talabat.feature.pickup.presentation;

import android.app.Activity;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import com.designsystem.ds_dialog.DSDialog;
import com.designsystem.ds_dialog.DSDialogPrimaryAction;
import com.designsystem.ds_dialog.DSDialogPrimaryActionType;
import com.designsystem.ds_dialog.DSDialogSecondaryAction;
import com.talabat.localization.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/feature/pickup/presentation/PickupConfirmationDialogView;", "", "()V", "Companion", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupConfirmationDialogView {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\n¨\u0006\f"}, d2 = {"Lcom/talabat/feature/pickup/presentation/PickupConfirmationDialogView$Companion;", "", "()V", "showPickupConfirmationDialog", "", "rootView", "Landroid/view/ViewGroup;", "activity", "Landroid/app/Activity;", "onClick", "Lkotlin/Function1;", "", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void showPickupConfirmationDialog(@NotNull ViewGroup viewGroup, @NotNull Activity activity, @NotNull Function1<? super Boolean, Unit> function1) {
            ViewGroup viewGroup2 = viewGroup;
            Activity activity2 = activity;
            Function1<? super Boolean, Unit> function12 = function1;
            Intrinsics.checkNotNullParameter(viewGroup2, "rootView");
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Intrinsics.checkNotNullParameter(function12, "onClick");
            DSDialog dSDialog = new DSDialog(activity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            dSDialog.setProperties(new DialogProperties(false, false, (SecureFlagPolicy) null, 4, (DefaultConstructorMarker) null));
            dSDialog.setTitle(activity2.getString(R.string.pickup_blocking_model_header));
            String string = activity2.getString(R.string.pickup_blocking_model_confirm);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t…p_blocking_model_confirm)");
            dSDialog.setPrimaryAction(new DSDialogPrimaryAction(string, new PickupConfirmationDialogView$Companion$showPickupConfirmationDialog$1(dSDialog, function12), (DSDialogPrimaryActionType) null, 4, (DefaultConstructorMarker) null));
            String string2 = activity2.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(com.t…lization.R.string.cancel)");
            dSDialog.setSecondaryAction(new DSDialogSecondaryAction(string2, new PickupConfirmationDialogView$Companion$showPickupConfirmationDialog$2(dSDialog, function12)));
            dSDialog.show(viewGroup2);
        }
    }
}
