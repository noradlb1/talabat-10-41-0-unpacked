package uh;

import android.view.View;
import com.talabat.cuisines.presentation.CuisinesFragmentMultipleSelection;
import com.talabat.cuisines.presentation.CuisinesScreenKt;
import com.talabat.cuisines.presentation.CuisinesViewModel;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CuisinesFragmentMultipleSelection f57877b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CuisinesViewModel f57878c;

    public /* synthetic */ f(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel) {
        this.f57877b = cuisinesFragmentMultipleSelection;
        this.f57878c = cuisinesViewModel;
    }

    public final void onClick(View view) {
        CuisinesScreenKt.m9618bindCancelClick$lambda9(this.f57877b, this.f57878c, view);
    }
}
