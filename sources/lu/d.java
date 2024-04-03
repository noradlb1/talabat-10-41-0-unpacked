package lu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsFragment;
import java.util.List;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuggestionsFragment f62283a;

    public /* synthetic */ d(SuggestionsFragment suggestionsFragment) {
        this.f62283a = suggestionsFragment;
    }

    public final void onChanged(Object obj) {
        SuggestionsFragment.m10845onActivityCreated$lambda4(this.f62283a, (List) obj);
    }
}
