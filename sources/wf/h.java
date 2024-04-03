package wf;

import android.app.Dialog;
import android.view.View;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsActivity f57934b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f57935c;

    public /* synthetic */ h(QuickFilterRestaurantsActivity quickFilterRestaurantsActivity, Dialog dialog) {
        this.f57934b = quickFilterRestaurantsActivity;
        this.f57935c = dialog;
    }

    public final void onClick(View view) {
        this.f57934b.lambda$termsResponseSuccess$1(this.f57935c, view);
    }
}
