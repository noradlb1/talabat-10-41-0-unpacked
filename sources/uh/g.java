package uh;

import androidx.lifecycle.Observer;
import com.talabat.cuisines.presentation.CuisinesScreenKt;
import com.talabat.cuisines.presentation.PopularCuisinesAdapter;
import java.util.List;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopularCuisinesAdapter f57879a;

    public /* synthetic */ g(PopularCuisinesAdapter popularCuisinesAdapter) {
        this.f57879a = popularCuisinesAdapter;
    }

    public final void onChanged(Object obj) {
        CuisinesScreenKt.m9621bindCuisinesAdapterWithPopular$lambda2(this.f57879a, (List) obj);
    }
}
