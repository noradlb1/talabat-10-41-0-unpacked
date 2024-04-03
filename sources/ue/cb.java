package ue;

import androidx.lifecycle.Observer;
import com.talabat.MenuSearchActivity;

public final /* synthetic */ class cb implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MenuSearchActivity f57474a;

    public /* synthetic */ cb(MenuSearchActivity menuSearchActivity) {
        this.f57474a = menuSearchActivity;
    }

    public final void onChanged(Object obj) {
        this.f57474a.lambda$initControls$1((Boolean) obj);
    }
}
