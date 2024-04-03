package lu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsFragment;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuggestionsFragment f62280a;

    public /* synthetic */ a(SuggestionsFragment suggestionsFragment) {
        this.f62280a = suggestionsFragment;
    }

    public final void onChanged(Object obj) {
        SuggestionsFragment.m10842onActivityCreated$lambda1(this.f62280a, (Boolean) obj);
    }
}
