package vh;

import androidx.lifecycle.Observer;
import com.talabat.cuisines.presentation.bottomsheet.CuisinesDSBottomSheetBodyFragment;
import com.talabat.cuisines.presentation.bottomsheet.CuisinesDSBottomSheetKt;
import com.talabat.cuisines.presentation.bottomsheet.PopularCuisinesDSBottomSheetAdapter;
import java.util.List;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopularCuisinesDSBottomSheetAdapter f57902a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CuisinesDSBottomSheetBodyFragment f57903b;

    public /* synthetic */ b(PopularCuisinesDSBottomSheetAdapter popularCuisinesDSBottomSheetAdapter, CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment) {
        this.f57902a = popularCuisinesDSBottomSheetAdapter;
        this.f57903b = cuisinesDSBottomSheetBodyFragment;
    }

    public final void onChanged(Object obj) {
        CuisinesDSBottomSheetKt.m9627bindCuisinesAdapterWithPopular$lambda5(this.f57902a, this.f57903b, (List) obj);
    }
}
