package z3;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper;

public final /* synthetic */ class d implements OnApplyWindowInsetsListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f44457b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DefaultInAppMessageViewWrapper f44458c;

    public /* synthetic */ d(View view, DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper) {
        this.f44457b = view;
        this.f44458c = defaultInAppMessageViewWrapper;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return DefaultInAppMessageViewWrapper.m9210addInAppMessageViewToViewGroup$lambda1(this.f44457b, this.f44458c, view, windowInsetsCompat);
    }
}
