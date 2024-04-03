package com.designsystem.ds_bottom_sheet_v2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"findDSBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "Landroidx/fragment/app/FragmentManager;", "tag", "", "findDSFullScreenBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSFullScreenBottomSheet;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSFragmentManagerExtensionsKt {
    @Nullable
    public static final DSBottomSheet findDSBottomSheet(@NotNull FragmentManager fragmentManager, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag instanceof DSBottomSheet) {
            return (DSBottomSheet) findFragmentByTag;
        }
        return null;
    }

    public static /* synthetic */ DSBottomSheet findDSBottomSheet$default(FragmentManager fragmentManager, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = BottomSheet.Companion.getDSBottomSheetDefaultContentFragmentTag$marshmallow_release();
        }
        return findDSBottomSheet(fragmentManager, str);
    }

    @Nullable
    public static final DSFullScreenBottomSheet findDSFullScreenBottomSheet(@NotNull FragmentManager fragmentManager, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag instanceof DSFullScreenBottomSheet) {
            return (DSFullScreenBottomSheet) findFragmentByTag;
        }
        return null;
    }

    public static /* synthetic */ DSFullScreenBottomSheet findDSFullScreenBottomSheet$default(FragmentManager fragmentManager, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = BottomSheet.Companion.getDSBottomSheetDefaultContentFragmentTag$marshmallow_release();
        }
        return findDSFullScreenBottomSheet(fragmentManager, str);
    }
}
