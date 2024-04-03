package wf;

import android.view.View;
import com.talabat.collectiondetails.ui.quickfilter.SubscribeCollectionActivity;
import datamodels.QuickFilter;

public final /* synthetic */ class e0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscribeCollectionActivity f57927b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57928c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ QuickFilter f57929d;

    public /* synthetic */ e0(SubscribeCollectionActivity subscribeCollectionActivity, String str, QuickFilter quickFilter) {
        this.f57927b = subscribeCollectionActivity;
        this.f57928c = str;
        this.f57929d = quickFilter;
    }

    public final void onClick(View view) {
        SubscribeCollectionActivity.m9568buildHeader$lambda3(this.f57927b, this.f57928c, this.f57929d, view);
    }
}
