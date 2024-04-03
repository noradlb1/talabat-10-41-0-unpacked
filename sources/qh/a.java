package qh;

import androidx.lifecycle.Observer;
import com.talabat.core.ui.lifecycle.SingleLiveEvent;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SingleLiveEvent f57195a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f57196b;

    public /* synthetic */ a(SingleLiveEvent singleLiveEvent, Observer observer) {
        this.f57195a = singleLiveEvent;
        this.f57196b = observer;
    }

    public final void onChanged(Object obj) {
        this.f57195a.lambda$observe$0(this.f57196b, obj);
    }
}
