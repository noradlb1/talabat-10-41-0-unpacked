package wp;

import android.view.View;
import com.talabat.filters.presentation.FiltersFragment;
import com.talabat.filters.presentation.FiltersViewModel;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f62992b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f62993c;

    public /* synthetic */ c(FiltersFragment filtersFragment, FiltersViewModel filtersViewModel) {
        this.f62992b = filtersFragment;
        this.f62993c = filtersViewModel;
    }

    public final void onClick(View view) {
        FiltersFragment.m10437bindButtons$lambda3(this.f62992b, this.f62993c, view);
    }
}
