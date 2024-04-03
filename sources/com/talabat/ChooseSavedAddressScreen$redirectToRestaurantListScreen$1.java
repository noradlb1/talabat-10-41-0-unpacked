package com.talabat;

import com.talabat.ChooseSavedAddressScreen;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/talabat/ChooseSavedAddressScreen$redirectToRestaurantListScreen$1", "Lcom/talabat/ChooseSavedAddressScreen$SlideAnimationListener;", "onAnimationFinish", "", "onAnimationStart", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChooseSavedAddressScreen$redirectToRestaurantListScreen$1 implements ChooseSavedAddressScreen.SlideAnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChooseSavedAddressScreen f54011a;

    public ChooseSavedAddressScreen$redirectToRestaurantListScreen$1(ChooseSavedAddressScreen chooseSavedAddressScreen) {
        this.f54011a = chooseSavedAddressScreen;
    }

    public void onAnimationFinish() {
        this.f54011a.setResult(-1);
        this.f54011a.finish();
    }

    public void onAnimationStart() {
    }
}
