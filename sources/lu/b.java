package lu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsFragment;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuggestionsFragment f62281a;

    public /* synthetic */ b(SuggestionsFragment suggestionsFragment) {
        this.f62281a = suggestionsFragment;
    }

    public final void onChanged(Object obj) {
        SuggestionsFragment.m10843onActivityCreated$lambda2(this.f62281a, (Boolean) obj);
    }
}
