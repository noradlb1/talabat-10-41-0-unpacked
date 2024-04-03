package ue;

import android.view.View;
import com.talabat.GroceryMenuScreen;
import datamodels.MenuSection;

public final /* synthetic */ class a8 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen.GroceryHorizontalAdapter f57432b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuSection f57433c;

    public /* synthetic */ a8(GroceryMenuScreen.GroceryHorizontalAdapter groceryHorizontalAdapter, MenuSection menuSection) {
        this.f57432b = groceryHorizontalAdapter;
        this.f57433c = menuSection;
    }

    public final void onClick(View view) {
        this.f57432b.lambda$onBindViewHolder$0(this.f57433c, view);
    }
}
