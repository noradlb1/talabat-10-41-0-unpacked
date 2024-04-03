package ue;

import com.talabat.RestaurantMenuScreenR;

public final /* synthetic */ class jd implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR f57599b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57600c;

    public /* synthetic */ jd(RestaurantMenuScreenR restaurantMenuScreenR, int i11) {
        this.f57599b = restaurantMenuScreenR;
        this.f57600c = i11;
    }

    public final void run() {
        this.f57599b.lambda$scrollRecyclerviewToPosition$14(this.f57600c);
    }
}
