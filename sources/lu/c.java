package lu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsFragment;
import java.util.List;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuggestionsFragment f62282a;

    public /* synthetic */ c(SuggestionsFragment suggestionsFragment) {
        this.f62282a = suggestionsFragment;
    }

    public final void onChanged(Object obj) {
        SuggestionsFragment.m10844onActivityCreated$lambda3(this.f62282a, (List) obj);
    }
}
