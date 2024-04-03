package ue;

import android.view.View;
import com.talabat.RestaurantMenuScreenR;

public final /* synthetic */ class td implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR.MenuCategoryAdapter f57761b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57762c;

    public /* synthetic */ td(RestaurantMenuScreenR.MenuCategoryAdapter menuCategoryAdapter, int i11) {
        this.f57761b = menuCategoryAdapter;
        this.f57762c = i11;
    }

    public final void onClick(View view) {
        this.f57761b.lambda$onBindViewHolder$0(this.f57762c, view);
    }
}
