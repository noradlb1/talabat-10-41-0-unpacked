package vh;

import androidx.lifecycle.Observer;
import com.talabat.cuisines.presentation.bottomsheet.CuisinesDSBottomSheetKt;
import com.talabat.cuisines.presentation.bottomsheet.PopularCuisinesDSBottomSheetAdapter;
import java.util.List;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopularCuisinesDSBottomSheetAdapter f57901a;

    public /* synthetic */ a(PopularCuisinesDSBottomSheetAdapter popularCuisinesDSBottomSheetAdapter) {
        this.f57901a = popularCuisinesDSBottomSheetAdapter;
    }

    public final void onChanged(Object obj) {
        CuisinesDSBottomSheetKt.m9626bindCuisinesAdapterWithPopular$lambda4(this.f57901a, (List) obj);
    }
}
