package uh;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.talabat.cuisines.presentation.CuisinesScreenKt;
import com.talabat.cuisines.presentation.PopularCuisinesAdapter;
import java.util.List;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopularCuisinesAdapter f57880a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f57881b;

    public /* synthetic */ h(PopularCuisinesAdapter popularCuisinesAdapter, Fragment fragment) {
        this.f57880a = popularCuisinesAdapter;
        this.f57881b = fragment;
    }

    public final void onChanged(Object obj) {
        CuisinesScreenKt.m9622bindCuisinesAdapterWithPopular$lambda3(this.f57880a, this.f57881b, (List) obj);
    }
}
