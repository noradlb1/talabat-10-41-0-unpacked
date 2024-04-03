package fr;

import android.content.DialogInterface;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragment;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BurnOptionsDetailsFragment f62064b;

    public /* synthetic */ a(BurnOptionsDetailsFragment burnOptionsDetailsFragment) {
        this.f62064b = burnOptionsDetailsFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        BurnOptionsDetailsFragment.m10600showAreYouSureDialog$lambda7$lambda5(this.f62064b, dialogInterface, i11);
    }
}
