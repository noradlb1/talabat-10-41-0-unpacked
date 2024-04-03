package com.talabat.cuisines.presentation.bottomsheet;

import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.cuisines.presentation.CuisinesViewModel;
import com.talabat.cuisines.presentation.CuisinesViewModelKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisinesDSBottomSheetKt$bindResetClick$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CuisinesDSBottomSheetBodyFragment f56079g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CuisinesViewModel f56080h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisinesDSBottomSheetKt$bindResetClick$1(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment, CuisinesViewModel cuisinesViewModel) {
        super(0);
        this.f56079g = cuisinesDSBottomSheetBodyFragment;
        this.f56080h = cuisinesViewModel;
    }

    public final void invoke() {
        AppTracker.onRestaurantsCuisineClear(this.f56079g.getContext(), this.f56080h.getShopCategorySelected().invoke());
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.CAN_SHOW_POPULAR_CUISNES, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            CuisinesViewModelKt.clearCuisineSelectionWithPopular(this.f56080h);
        } else {
            CuisinesViewModelKt.clearCuisineSelection(this.f56080h);
        }
        CuisinesDSBottomSheetKt.filterCuisines(this.f56079g);
    }
}
