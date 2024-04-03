package ue;

import android.content.DialogInterface;
import com.talabat.ListingMenuBridgeActivity;

public final /* synthetic */ class r9 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListingMenuBridgeActivity f57723b;

    public /* synthetic */ r9(ListingMenuBridgeActivity listingMenuBridgeActivity) {
        this.f57723b = listingMenuBridgeActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.f57723b.lambda$onEmptyMenuReceived$1(dialogInterface, i11);
    }
}
