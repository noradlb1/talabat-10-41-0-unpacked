package com.talabat.cuisines.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_bottom_sheet_v2.DSFragmentManagerExtensionsKt;
import com.talabat.cuisines.presentation.bottomsheet.CuisinesDSBottomSheetKt;
import d2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/talabat/cuisines/navigation/CuisineView$updateBubbleVisibility$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onResume", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisineView$updateBubbleVisibility$1 implements DefaultLifecycleObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CuisineView f56038b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f56039c;

    public CuisineView$updateBubbleVisibility$1(CuisineView cuisineView, AppCompatActivity appCompatActivity) {
        this.f56038b = cuisineView;
        this.f56039c = appCompatActivity;
    }

    public void onCreate(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        a.a(this, lifecycleOwner);
        FragmentManager supportFragmentManager = this.f56039c.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        StartCuisineViewForResult startCuisineViewForResult = null;
        DSBottomSheet findDSBottomSheet$default = DSFragmentManagerExtensionsKt.findDSBottomSheet$default(supportFragmentManager, (String) null, 1, (Object) null);
        if (findDSBottomSheet$default != null) {
            AppCompatActivity appCompatActivity = this.f56039c;
            CuisineView cuisineView = this.f56038b;
            StartCuisineViewForResult access$getStartCuisineViewForResult$p = cuisineView.startCuisineViewForResult;
            if (access$getStartCuisineViewForResult$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startCuisineViewForResult");
            } else {
                startCuisineViewForResult = access$getStartCuisineViewForResult$p;
            }
            CuisinesDSBottomSheetKt.updateCuisinesDSBottomSheet(appCompatActivity, findDSBottomSheet$default, startCuisineViewForResult, new CuisineView$updateBubbleVisibility$1$onCreate$1$1(cuisineView));
        }
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        a.b(this, lifecycleOwner);
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        a.c(this, lifecycleOwner);
    }

    public void onResume(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        this.f56038b.updateView();
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        a.e(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        a.f(this, lifecycleOwner);
    }
}
