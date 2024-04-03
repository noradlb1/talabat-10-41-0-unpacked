package com.talabat.feature.rating.presentation.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.designsystem.ds_dialog.DSDialog;
import com.designsystem.ds_dialog.DSDialogPrimaryAction;
import com.designsystem.ds_dialog.DSDialogPrimaryActionType;
import com.talabat.feature.rating.presentation.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/rating/presentation/ui/RatingErrorDialog;", "", "()V", "showErrorDialog", "", "rootView", "Landroid/view/ViewGroup;", "activity", "Landroid/app/Activity;", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingErrorDialog {
    @NotNull
    public static final RatingErrorDialog INSTANCE = new RatingErrorDialog();

    private RatingErrorDialog() {
    }

    public final void showErrorDialog(@NotNull ViewGroup viewGroup, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (viewGroup.getContext() != null) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            DSDialog dSDialog = new DSDialog(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            dSDialog.setContent(viewGroup.getContext().getString(R.string.generic_error));
            String string = viewGroup.getContext().getString(R.string.f58688ok);
            Intrinsics.checkNotNullExpressionValue(string, "rootView.context.getStri…ring.ok\n                )");
            dSDialog.setPrimaryAction(new DSDialogPrimaryAction(string, new RatingErrorDialog$showErrorDialog$1(dSDialog, activity), (DSDialogPrimaryActionType) null, 4, (DefaultConstructorMarker) null));
            dSDialog.show(viewGroup);
        }
    }
}
