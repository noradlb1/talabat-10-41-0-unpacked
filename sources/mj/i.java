package mj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.search.PreSearchAdapter;
import java.util.List;

public final /* synthetic */ class i implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreSearchAdapter f57037a;

    public /* synthetic */ i(PreSearchAdapter preSearchAdapter) {
        this.f57037a = preSearchAdapter;
    }

    public final void onChanged(Object obj) {
        this.f57037a.submitList((List) obj);
    }
}
