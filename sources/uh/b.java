package uh;

import android.view.View;
import com.talabat.cuisines.presentation.CuisinesFragmentMultipleSelection;
import com.talabat.cuisines.presentation.CuisinesScreenKt;
import com.talabat.cuisines.presentation.CuisinesViewModel;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CuisinesFragmentMultipleSelection f57870b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CuisinesViewModel f57871c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f57872d;

    public /* synthetic */ b(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel, boolean z11) {
        this.f57870b = cuisinesFragmentMultipleSelection;
        this.f57871c = cuisinesViewModel;
        this.f57872d = z11;
    }

    public final void onClick(View view) {
        CuisinesScreenKt.m9617bindApplyClick$lambda13(this.f57870b, this.f57871c, this.f57872d, view);
    }
}
