package com.talabat.feature.helpcenter.presentation;

import androidx.fragment.app.FragmentActivity;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"KEY_CANCELLATION_POLICY_CONTENT", "", "KEY_CANCELLATION_POLICY_TITLE", "showCancellationBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "activity", "Landroidx/fragment/app/FragmentActivity;", "content", "Ljava/util/ArrayList;", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyItemDisplayModel;", "Lkotlin/collections/ArrayList;", "title", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyBottomSheetKt {
    @NotNull
    public static final String KEY_CANCELLATION_POLICY_CONTENT = "bottom_sheet_content";
    @NotNull
    public static final String KEY_CANCELLATION_POLICY_TITLE = "bottom_sheet_title";

    @NotNull
    public static final DSBottomSheet showCancellationBottomSheet(@NotNull FragmentActivity fragmentActivity, @NotNull ArrayList<CancellationPolicyItemDisplayModel> arrayList, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(arrayList, "content");
        Intrinsics.checkNotNullParameter(str, "title");
        DSBottomSheet dSBottomSheet = new DSBottomSheet();
        dSBottomSheet.setBody(CancellationPolicyBottomSheet.Companion.getInstance(arrayList, str, dSBottomSheet));
        dSBottomSheet.show(fragmentActivity.getSupportFragmentManager(), CancellationPolicyBottomSheet.TAG);
        return dSBottomSheet;
    }
}
