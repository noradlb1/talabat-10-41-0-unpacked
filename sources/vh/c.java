package vh;

import androidx.lifecycle.Observer;
import com.talabat.cuisines.presentation.bottomsheet.CuisinesDSBottomSheetAdapter;
import com.talabat.cuisines.presentation.bottomsheet.CuisinesDSBottomSheetBodyFragment;
import com.talabat.cuisines.presentation.bottomsheet.CuisinesDSBottomSheetKt;
import java.util.List;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CuisinesDSBottomSheetAdapter f57904a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CuisinesDSBottomSheetBodyFragment f57905b;

    public /* synthetic */ c(CuisinesDSBottomSheetAdapter cuisinesDSBottomSheetAdapter, CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment) {
        this.f57904a = cuisinesDSBottomSheetAdapter;
        this.f57905b = cuisinesDSBottomSheetBodyFragment;
    }

    public final void onChanged(Object obj) {
        CuisinesDSBottomSheetKt.m9625bindCuisinesAdapter$lambda6(this.f57904a, this.f57905b, (List) obj);
    }
}
