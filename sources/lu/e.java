package lu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsFragment;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuggestionsFragment f62284a;

    public /* synthetic */ e(SuggestionsFragment suggestionsFragment) {
        this.f62284a = suggestionsFragment;
    }

    public final void onChanged(Object obj) {
        SuggestionsFragment.m10846onActivityCreated$lambda5(this.f62284a, (Boolean) obj);
    }
}
