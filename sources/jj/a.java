package jj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.product.ProductFragment;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductFragment f56928a;

    public /* synthetic */ a(ProductFragment productFragment) {
        this.f56928a = productFragment;
    }

    public final void onChanged(Object obj) {
        ProductFragment.m10008observeData$lambda6(this.f56928a, (EventWrapper) obj);
    }
}
