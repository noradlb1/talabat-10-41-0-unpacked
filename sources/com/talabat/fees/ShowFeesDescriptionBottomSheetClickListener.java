package com.talabat.fees;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.talabat.feature.fees.domain.model.FeeDescription;
import com.talabat.feature.fees.presentation.displaymodel.FeesDescriptionsDisplayModel;
import com.talabat.talabatcommon.views.bottomsheet.FeesDescriptionBottomSheetFragment;
import com.talabat.talabatcommon.views.bottomsheet.FeesDescriptionDisplayModel;
import com.talabat.talabatcommon.views.bottomsheet.MultipleFeesDescriptionBottomSheetDialog;
import com.talabat.talabatcommon.views.bottomsheet.MultipleFeesDescriptionDisplayModel;
import com.talabat.talabatcommon.views.bottomsheet.OldMultipleFeesDescriptionBottomSheetDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/fees/ShowFeesDescriptionBottomSheetClickListener;", "Landroid/view/View$OnClickListener;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "feesDescriptions", "Lcom/talabat/feature/fees/presentation/displaymodel/FeesDescriptionsDisplayModel;", "useOldBottomSheet", "", "(Landroidx/fragment/app/FragmentManager;Lcom/talabat/feature/fees/presentation/displaymodel/FeesDescriptionsDisplayModel;Z)V", "createFeesDescriptionDisplayModel", "Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionDisplayModel;", "feeDescription", "Lcom/talabat/feature/fees/domain/model/FeeDescription;", "onClick", "", "v", "Landroid/view/View;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShowFeesDescriptionBottomSheetClickListener implements View.OnClickListener {
    @NotNull
    private final FeesDescriptionsDisplayModel feesDescriptions;
    @NotNull
    private final FragmentManager fragmentManager;
    private final boolean useOldBottomSheet;

    public ShowFeesDescriptionBottomSheetClickListener(@NotNull FragmentManager fragmentManager2, @NotNull FeesDescriptionsDisplayModel feesDescriptionsDisplayModel, boolean z11) {
        Intrinsics.checkNotNullParameter(fragmentManager2, "fragmentManager");
        Intrinsics.checkNotNullParameter(feesDescriptionsDisplayModel, "feesDescriptions");
        this.fragmentManager = fragmentManager2;
        this.feesDescriptions = feesDescriptionsDisplayModel;
        this.useOldBottomSheet = z11;
    }

    private final FeesDescriptionDisplayModel createFeesDescriptionDisplayModel(FeeDescription feeDescription) {
        if (feeDescription == null) {
            return null;
        }
        return new FeesDescriptionDisplayModel((Integer) null, feeDescription.getName(), feeDescription.getDescription(), feeDescription.getUrl());
    }

    public void onClick(@Nullable View view) {
        Fragment fragment;
        FeesDescriptionDisplayModel createFeesDescriptionDisplayModel = createFeesDescriptionDisplayModel(this.feesDescriptions.getHowFeesWork());
        if (createFeesDescriptionDisplayModel != null) {
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            if (this.useOldBottomSheet) {
                fragment = OldMultipleFeesDescriptionBottomSheetDialog.Companion.newInstance(new MultipleFeesDescriptionDisplayModel(createFeesDescriptionDisplayModel, createFeesDescriptionDisplayModel(this.feesDescriptions.getDeliveryFee()), createFeesDescriptionDisplayModel(this.feesDescriptions.getServiceFee()), (FeesDescriptionDisplayModel) null, 8, (DefaultConstructorMarker) null));
            } else {
                fragment = MultipleFeesDescriptionBottomSheetDialog.Companion.newInstance(new MultipleFeesDescriptionDisplayModel(createFeesDescriptionDisplayModel, createFeesDescriptionDisplayModel(this.feesDescriptions.getDeliveryFee()), createFeesDescriptionDisplayModel(this.feesDescriptions.getServiceFee()), createFeesDescriptionDisplayModel(this.feesDescriptions.getSmallOrderFee())));
            }
            dSBottomSheet.setBody(fragment);
            dSBottomSheet.show(this.fragmentManager, FeesDescriptionBottomSheetFragment.TAG);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShowFeesDescriptionBottomSheetClickListener(FragmentManager fragmentManager2, FeesDescriptionsDisplayModel feesDescriptionsDisplayModel, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentManager2, feesDescriptionsDisplayModel, (i11 & 4) != 0 ? false : z11);
    }
}
