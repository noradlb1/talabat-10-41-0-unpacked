package com.talabat.feature.rewards.presentation;

import android.os.Bundle;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.designsystem.ds_bottom_sheet_v2.BottomSheet;
import com.designsystem.marshmallow.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\"\u0010\r\u001a\u00020\f8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/rewards/presentation/DSBottomSheetFragmentWithoutPadding;", "Lcom/designsystem/ds_bottom_sheet_v2/BottomSheet;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "Landroid/view/View;", "view", "onViewCreated", "Landroidx/fragment/app/Fragment;", "newContentFragment", "changeContentFragmentWithoutBackStack", "", "maxBottomSheetHeightRatio", "D", "i0", "()D", "setMaxBottomSheetHeightRatio", "(D)V", "", "isFullScreen", "Z", "j0", "()Z", "setFullScreen", "(Z)V", "<init>", "()V", "Companion", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0})
public final class DSBottomSheetFragmentWithoutPadding extends BottomSheet {
    public static final int $stable = 8;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static final String TAG = Reflection.getOrCreateKotlinClass(DSBottomSheetFragmentWithoutPadding.class).getSimpleName();
    private boolean isFullScreen;
    private double maxBottomSheetHeightRatio = 1.0d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/rewards/presentation/DSBottomSheetFragmentWithoutPadding$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final String getTAG() {
            return DSBottomSheetFragmentWithoutPadding.TAG;
        }
    }

    public final void changeContentFragmentWithoutBackStack(@NotNull Fragment fragment) {
        View view;
        Intrinsics.checkNotNullParameter(fragment, "newContentFragment");
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        Fragment fragment2 = (Fragment) CollectionsKt___CollectionsKt.getOrNull(fragments, 0);
        if (fragment2 != null) {
            view = fragment2.getView();
        } else {
            view = null;
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        if (view != null) {
            beginTransaction.addSharedElement(view, view.getTransitionName());
        }
        beginTransaction.setReorderingAllowed(true);
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beg…ngAllowed(true)\n        }");
        beginTransaction.replace(R.id.dsBottomSheetBodyFragmentContainer, fragment).commit();
    }

    public double i0() {
        return this.maxBottomSheetHeightRatio;
    }

    public boolean j0() {
        return this.isFullScreen;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.DynamicBottomSheetDialogTheme);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.dsBottomSheetContentContainer);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<FrameL…tomSheetContentContainer)");
        findViewById.setPadding(0, 0, 0, 0);
    }
}
