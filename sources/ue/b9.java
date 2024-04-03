package ue;

import android.content.DialogInterface;
import com.talabat.HomeScreenMap;

public final /* synthetic */ class b9 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f57453b;

    public /* synthetic */ b9(HomeScreenMap homeScreenMap) {
        this.f57453b = homeScreenMap;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        HomeScreenMap.m9479locationError$lambda19(this.f57453b, dialogInterface, i11);
    }
}
