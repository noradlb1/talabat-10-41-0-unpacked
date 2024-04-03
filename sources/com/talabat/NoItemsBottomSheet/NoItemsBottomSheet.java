package com.talabat.NoItemsBottomSheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.compose.DialogNavigator;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_empty_state.DSEmptyState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.talabat.R;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import datamodels.Restaurant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.b;
import we.c;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0011J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006#"}, d2 = {"Lcom/talabat/NoItemsBottomSheet/NoItemsBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "()V", "restaurant", "Ldatamodels/Restaurant;", "getRestaurant", "()Ldatamodels/Restaurant;", "setRestaurant", "(Ldatamodels/Restaurant;)V", "closeBottomSheetFromDialog", "", "getShopMenu", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "setBottomSheetHeight", "setup", "showDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NoItemsBottomSheet extends BottomSheetDialogFragment implements AnimationHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_BRAND_ID = "branchId";
    @NotNull
    public static final String EXTRA_RESTAURANT = "restaurant";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Restaurant restaurant;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0006\u001a\u00070\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/NoItemsBottomSheet/NoItemsBottomSheet$Companion;", "", "()V", "EXTRA_BRAND_ID", "", "EXTRA_RESTAURANT", "newInstance", "Lcom/talabat/NoItemsBottomSheet/NoItemsBottomSheet;", "Lorg/jetbrains/annotations/NotNull;", "restaurant", "Ldatamodels/Restaurant;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NoItemsBottomSheet newInstance(@NotNull Restaurant restaurant) {
            Intrinsics.checkNotNullParameter(restaurant, "restaurant");
            NoItemsBottomSheet noItemsBottomSheet = new NoItemsBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putParcelable("restaurant", restaurant);
            noItemsBottomSheet.setArguments(bundle);
            return noItemsBottomSheet;
        }
    }

    private final void closeBottomSheetFromDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            int i11 = R.id.no_items_bottom_sheet;
            RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "it.no_items_bottom_sheet");
            adjustViewHeight(relativeLayout, ((RelativeLayout) dialog.findViewById(i11)).getHeight(), 0, AnimationSpeed.NORMAL);
            dialog.dismiss();
        }
    }

    private final void getShopMenu() {
        Context context = getContext();
        if (context != null) {
            GlobalDataModel.SELECTED.updateRestaurant(getRestaurant());
            Navigator.Companion.navigate(context, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, getRestaurant().branchId, getRestaurant().shopType, getRestaurant().isGlrEnabled, getRestaurant().isDarkStore, getRestaurant().isMigrated, false, (String) null, (Bundle) null, 224, (Object) null));
            closeBottomSheetFromDialog();
        }
    }

    private final void setBottomSheetHeight(View view) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new a(view));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setBottomSheetHeight$lambda-4  reason: not valid java name */
    public static final void m9488setBottomSheetHeight$lambda4(View view, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(view, "$view");
        if (dialogInterface != null) {
            FrameLayout frameLayout = (FrameLayout) ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet);
            if (frameLayout != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                Intrinsics.checkNotNullExpressionValue(from, "from(bottomSheet)");
                from.setPeekHeight(((ViewGroup) view.findViewById(R.id.no_items_bottom_sheet)).getHeight());
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    /* access modifiers changed from: private */
    /* renamed from: setup$lambda-1  reason: not valid java name */
    public static final void m9489setup$lambda1(NoItemsBottomSheet noItemsBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(noItemsBottomSheet, "this$0");
        noItemsBottomSheet.closeBottomSheetFromDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: setup$lambda-2  reason: not valid java name */
    public static final void m9490setup$lambda2(NoItemsBottomSheet noItemsBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(noItemsBottomSheet, "this$0");
        noItemsBottomSheet.getShopMenu();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    @NotNull
    public final Restaurant getRestaurant() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("restaurant");
        return null;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.VoucherBottomSheetDialogTheme);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.no_items_bottomsheet, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, DialogNavigator.NAME);
        super.onDismiss(dialogInterface);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Parcelable parcelable = arguments.getParcelable("restaurant");
            Intrinsics.checkNotNull(parcelable);
            setRestaurant((Restaurant) parcelable);
        }
        setup(view);
    }

    public final void setRestaurant(@NotNull Restaurant restaurant2) {
        Intrinsics.checkNotNullParameter(restaurant2, "<set-?>");
        this.restaurant = restaurant2;
    }

    public final void setup(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        setBottomSheetHeight(view);
        String string = getResources().getString(R.string.restaurant_might_have_updated);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…urant_might_have_updated)");
        String str = getRestaurant().f13873name;
        Intrinsics.checkNotNullExpressionValue(str, "restaurant.name");
        ((DSEmptyState) _$_findCachedViewById(R.id.design_system_empty_state)).setDetails(StringsKt__StringsJVMKt.replace$default(string, RichContentLoadTimeRecorder.DELIMETER, str, false, 4, (Object) null));
        ((ImageView) _$_findCachedViewById(R.id.close_bottomsheet)).setOnClickListener(new b(this));
        ((DSPrimaryButton) _$_findCachedViewById(R.id.go_to_menu)).setOnClickListener(new c(this));
    }

    public final void showDialog(@NotNull FragmentManager fragmentManager, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (!isVisible()) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag).commitNow();
            }
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitNow();
        }
    }
}
