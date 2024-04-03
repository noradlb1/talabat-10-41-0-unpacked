package ue;

import android.content.DialogInterface;
import com.talabat.HomeScreenMap;

public final /* synthetic */ class y8 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f57843b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57844c;

    public /* synthetic */ y8(HomeScreenMap homeScreenMap, int i11) {
        this.f57843b = homeScreenMap;
        this.f57844c = i11;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        HomeScreenMap.m9462changeCountryAlert$lambda27(this.f57843b, this.f57844c, dialogInterface, i11);
    }
}
