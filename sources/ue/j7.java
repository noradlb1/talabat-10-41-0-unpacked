package ue;

import JsonModels.Response.GroceryResponse.GroceryItemsForSectionBrandModel;
import android.widget.CompoundButton;
import com.talabat.GroceryDetailsViewScreen;

public final /* synthetic */ class j7 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen.BrandListAdapter f57593b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroceryItemsForSectionBrandModel f57594c;

    public /* synthetic */ j7(GroceryDetailsViewScreen.BrandListAdapter brandListAdapter, GroceryItemsForSectionBrandModel groceryItemsForSectionBrandModel) {
        this.f57593b = brandListAdapter;
        this.f57594c = groceryItemsForSectionBrandModel;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        GroceryDetailsViewScreen.BrandListAdapter.m9451onBindViewHolder$lambda1(this.f57593b, this.f57594c, compoundButton, z11);
    }
}
