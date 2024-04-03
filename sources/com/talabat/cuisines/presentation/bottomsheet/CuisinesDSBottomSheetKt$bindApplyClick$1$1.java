package com.talabat.cuisines.presentation.bottomsheet;

import android.content.Context;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_button_v2.DSBaseButton;
import com.google.gson.Gson;
import com.talabat.cuisines.domain.SelectableCuisine;
import com.talabat.cuisines.presentation.CuisinesViewModel;
import com.talabat.talabatcommon.extentions.GsonKt;
import datamodels.Cuisine;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisinesDSBottomSheetKt$bindApplyClick$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSBaseButton f56073g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CuisinesViewModel f56074h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CuisinesDSBottomSheetBodyFragment f56075i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisinesDSBottomSheetKt$bindApplyClick$1$1(DSBaseButton dSBaseButton, CuisinesViewModel cuisinesViewModel, CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment) {
        super(0);
        this.f56073g = dSBaseButton;
        this.f56074h = cuisinesViewModel;
        this.f56075i = cuisinesDSBottomSheetBodyFragment;
    }

    public final void invoke() {
        Object obj;
        Cuisine cuisine;
        Context context = this.f56073g.getContext();
        String invoke = this.f56074h.getShopCategorySelected().invoke();
        FragmentActivity activity = this.f56075i.getActivity();
        String str = null;
        AppTracker.onRestaurantsCuisineApply(context, invoke, !StringsKt__StringsJVMKt.equals$default(activity != null ? activity.getClass().getSimpleName() : null, "PickupActivity", false, 2, (Object) null));
        FragmentManager parentFragmentManager = this.f56075i.getParentFragmentManager();
        Pair[] pairArr = new Pair[2];
        List value = this.f56074h.getCuisines().getValue();
        if (value != null) {
            Iterator it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((SelectableCuisine) obj).isOn()) {
                    break;
                }
            }
            SelectableCuisine selectableCuisine = (SelectableCuisine) obj;
            if (!(selectableCuisine == null || (cuisine = selectableCuisine.getCuisine()) == null)) {
                str = GsonKt.toJson$default(cuisine, (Gson) null, 1, (Object) null);
            }
        }
        pairArr[0] = TuplesKt.to("EXTRA_DS_BOTTOM_SHEET_CUISINE", str);
        pairArr[1] = TuplesKt.to("EXTRA_DS_BOTTOM_SHEET_SHOP_CATEGORY", this.f56074h.getShopCategorySelected().invoke());
        parentFragmentManager.setFragmentResult("EXTRA_DS_BOTTOM_SHEET_SUCCESS", BundleKt.bundleOf(pairArr));
        DSBottomSheet access$parent = CuisinesDSBottomSheetKt.parent(this.f56075i);
        if (access$parent != null) {
            access$parent.dismiss();
        }
    }
}
