package ue;

import android.view.View;
import com.talabat.GroceryMenuScreen;

public final /* synthetic */ class b8 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.MenuCategoryAdapter f57451b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57452c;

    public /* synthetic */ b8(GroceryMenuScreen.MenuCategoryAdapter menuCategoryAdapter, int i11) {
        this.f57451b = menuCategoryAdapter;
        this.f57452c = i11;
    }

    public final void onClick(View view) {
        this.f57451b.lambda$onBindViewHolder$0(this.f57452c, view);
    }
}
