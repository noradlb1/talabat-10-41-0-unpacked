package ue;

import android.content.DialogInterface;
import com.talabat.GroceryDetailsViewScreen;
import datamodels.CartMenuItem;
import datamodels.Restaurant;

public final /* synthetic */ class s6 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f57735b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f57736c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CartMenuItem f57737d;

    public /* synthetic */ s6(GroceryDetailsViewScreen groceryDetailsViewScreen, Restaurant restaurant, CartMenuItem cartMenuItem) {
        this.f57735b = groceryDetailsViewScreen;
        this.f57736c = restaurant;
        this.f57737d = cartMenuItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        GroceryDetailsViewScreen.m9449showRestaurantChangePopup$lambda27(this.f57735b, this.f57736c, this.f57737d, dialogInterface, i11);
    }
}
