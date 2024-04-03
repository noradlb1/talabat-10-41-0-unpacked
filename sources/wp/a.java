package wp;

import android.view.View;
import com.talabat.filters.presentation.FiltersFragment;
import com.talabat.filters.presentation.FiltersViewModel;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f62989b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f62990c;

    public /* synthetic */ a(FiltersFragment filtersFragment, FiltersViewModel filtersViewModel) {
        this.f62989b = filtersFragment;
        this.f62990c = filtersViewModel;
    }

    public final void onClick(View view) {
        FiltersFragment.m10435bindButtons$lambda1(this.f62989b, this.f62990c, view);
    }
}
