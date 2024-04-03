package ue;

import androidx.lifecycle.Observer;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.ChooseSavedAddressScreen;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class l5 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f57630a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseSavedAddressScreen f57631b;

    public /* synthetic */ l5(Ref.ObjectRef objectRef, ChooseSavedAddressScreen chooseSavedAddressScreen) {
        this.f57630a = objectRef;
        this.f57631b = chooseSavedAddressScreen;
    }

    public final void onChanged(Object obj) {
        ChooseSavedAddressScreen.m9418listenForCurrentLocation$lambda6(this.f57630a, this.f57631b, (LatLng) obj);
    }
}
