package uh;

import android.view.View;
import com.talabat.cuisines.presentation.CuisinesFragmentMultipleSelection;
import com.talabat.cuisines.presentation.CuisinesScreenKt;
import com.talabat.cuisines.presentation.CuisinesViewModel;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CuisinesFragmentMultipleSelection f57882b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CuisinesViewModel f57883c;

    public /* synthetic */ i(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel) {
        this.f57882b = cuisinesFragmentMultipleSelection;
        this.f57883c = cuisinesViewModel;
    }

    public final void onClick(View view) {
        CuisinesScreenKt.m9624bindResetClick$lambda10(this.f57882b, this.f57883c, view);
    }
}
