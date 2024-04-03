package lv;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.LookingGlassView;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.LookingGlassDisplayModel;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LookingGlassView f23923a;

    public /* synthetic */ b(LookingGlassView lookingGlassView) {
        this.f23923a = lookingGlassView;
    }

    public final void onChanged(Object obj) {
        LookingGlassView.m5763observatory$lambda1(this.f23923a, (LookingGlassDisplayModel) obj);
    }
}
