package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.RestaurantsSearchActivity;

public final /* synthetic */ class ce implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsSearchActivity f57477b;

    public /* synthetic */ ce(RestaurantsSearchActivity restaurantsSearchActivity) {
        this.f57477b = restaurantsSearchActivity;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57477b.lambda$initSearch$0(textView, i11, keyEvent);
    }
}
