package uh;

import androidx.lifecycle.Observer;
import com.talabat.cuisines.presentation.CuisinesScreenKt;
import com.talabat.cuisines.presentation.CuisinesViewModel;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CuisinesViewModel f57874a;

    public /* synthetic */ d(CuisinesViewModel cuisinesViewModel) {
        this.f57874a = cuisinesViewModel;
    }

    public final void onChanged(Object obj) {
        CuisinesScreenKt.m9623bindErrors$lambda8(this.f57874a, (Throwable) obj);
    }
}
