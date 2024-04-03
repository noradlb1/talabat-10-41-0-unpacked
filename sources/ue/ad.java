package ue;

import com.talabat.RestaurantMenuScreenR;

public final /* synthetic */ class ad implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR f57439b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57440c;

    public /* synthetic */ ad(RestaurantMenuScreenR restaurantMenuScreenR, int i11) {
        this.f57439b = restaurantMenuScreenR;
        this.f57440c = i11;
    }

    public final void run() {
        this.f57439b.lambda$scrollTabToPosition$13(this.f57440c);
    }
}
