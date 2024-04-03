package com.talabat.cuisines.presentation.bottomsheet;

import android.content.Intent;
import com.talabat.cuisines.domain.SelectableCuisine;
import com.talabat.cuisines.presentation.CuisinesAdapterKt;
import com.talabat.cuisines.presentation.CuisinesViewModel;
import com.talabat.cuisines.presentation.CuisinesViewModelKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "intent", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisinesDSBottomSheetKt$registerToCuisineClickWithPopular$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CuisinesDSBottomSheetBodyFragment f56083g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CuisinesViewModel f56084h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisinesDSBottomSheetKt$registerToCuisineClickWithPopular$1(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, CuisinesViewModel cuisinesViewModel) {
        super(1);
        this.f56083g = cuisinesDSBottomSheetBodyFragment;
        this.f56084h = cuisinesViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Intent intent) {
        Serializable serializableExtra;
        if (!(intent == null || (serializableExtra = intent.getSerializableExtra(CuisinesAdapterKt.EXTRA_CUISINE)) == null)) {
            if (!(serializableExtra instanceof SelectableCuisine)) {
                serializableExtra = null;
            }
            if (serializableExtra != null) {
                SelectableCuisine selectableCuisine = (SelectableCuisine) serializableExtra;
                CuisinesViewModelKt.selectMultipleCuisinesWithPopular(this.f56084h, selectableCuisine);
                CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment = this.f56083g;
                CuisinesViewModel cuisinesViewModel = this.f56084h;
                if (selectableCuisine.isOn()) {
                    AppTracker.onRestaurantsCuisineSelection(cuisinesDSBottomSheetBodyFragment.getContext(), cuisinesViewModel.getShopCategorySelected().invoke(), false);
                }
            }
        }
        CuisinesDSBottomSheetKt.filterCuisines(this.f56083g);
    }
}
