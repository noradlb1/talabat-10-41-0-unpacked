package ue;

import android.content.DialogInterface;
import com.talabat.GroceryMenuSearchActivity;
import datamodels.CartMenuItem;
import datamodels.Restaurant;

public final /* synthetic */ class e8 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchActivity f57506b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f57507c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CartMenuItem f57508d;

    public /* synthetic */ e8(GroceryMenuSearchActivity groceryMenuSearchActivity, Restaurant restaurant, CartMenuItem cartMenuItem) {
        this.f57506b = groceryMenuSearchActivity;
        this.f57507c = restaurant;
        this.f57508d = cartMenuItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.f57506b.lambda$showRestaurantChangePopup$2(this.f57507c, this.f57508d, dialogInterface, i11);
    }
}
