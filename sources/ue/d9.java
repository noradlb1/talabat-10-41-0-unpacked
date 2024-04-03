package ue;

import android.content.DialogInterface;
import com.talabat.HomeScreenMap;

public final /* synthetic */ class d9 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f57489b;

    public /* synthetic */ d9(HomeScreenMap homeScreenMap) {
        this.f57489b = homeScreenMap;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        HomeScreenMap.m9464clearCart$lambda18(this.f57489b, dialogInterface, i11);
    }
}
