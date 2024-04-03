package uh;

import android.view.View;
import com.talabat.cuisines.domain.SelectableCuisine;
import com.talabat.cuisines.presentation.CuisineMultipleSelectionViewHolder;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelectableCuisine f57869b;

    public /* synthetic */ a(SelectableCuisine selectableCuisine) {
        this.f57869b = selectableCuisine;
    }

    public final void onClick(View view) {
        CuisineMultipleSelectionViewHolder.m9616bind$lambda1$lambda0(this.f57869b, view);
    }
}
