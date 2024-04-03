package vs;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.talabat.offering.ui.OfferCollectionActivity;

public final /* synthetic */ class d implements OnApplyWindowInsetsListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionActivity f62972b;

    public /* synthetic */ d(OfferCollectionActivity offerCollectionActivity) {
        this.f62972b = offerCollectionActivity;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return OfferCollectionActivity.m10684configureToolbarAndStatusBar$lambda13(this.f62972b, view, windowInsetsCompat);
    }
}
