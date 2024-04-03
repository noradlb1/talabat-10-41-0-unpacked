package lu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsFragment;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuggestionsFragment f62285a;

    public /* synthetic */ f(SuggestionsFragment suggestionsFragment) {
        this.f62285a = suggestionsFragment;
    }

    public final void onChanged(Object obj) {
        SuggestionsFragment.m10847onActivityCreated$lambda6(this.f62285a, (Boolean) obj);
    }
}
