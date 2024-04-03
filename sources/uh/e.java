package uh;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.talabat.cuisines.presentation.CuisinesAdapter;
import com.talabat.cuisines.presentation.CuisinesScreenKt;
import java.util.List;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CuisinesAdapter f57875a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f57876b;

    public /* synthetic */ e(CuisinesAdapter cuisinesAdapter, Fragment fragment) {
        this.f57875a = cuisinesAdapter;
        this.f57876b = fragment;
    }

    public final void onChanged(Object obj) {
        CuisinesScreenKt.m9620bindCuisinesAdapter$lambda0(this.f57875a, this.f57876b, (List) obj);
    }
}
