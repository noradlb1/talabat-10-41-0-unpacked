package fr;

import android.content.DialogInterface;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragment;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BurnOptionsDetailsFragment f62065b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BurnItemDisplayModel f62066c;

    public /* synthetic */ b(BurnOptionsDetailsFragment burnOptionsDetailsFragment, BurnItemDisplayModel burnItemDisplayModel) {
        this.f62065b = burnOptionsDetailsFragment;
        this.f62066c = burnItemDisplayModel;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        BurnOptionsDetailsFragment.m10601showAreYouSureDialog$lambda7$lambda6(this.f62065b, this.f62066c, dialogInterface, i11);
    }
}
