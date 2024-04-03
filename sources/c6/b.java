package c6;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.designsystem.ds_header.DSHeaderView;

public final /* synthetic */ class b implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f29364b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DSHeaderView f29365c;

    public /* synthetic */ b(TextView textView, DSHeaderView dSHeaderView) {
        this.f29364b = textView;
        this.f29365c = dSHeaderView;
    }

    public final void onScrollChanged() {
        DSHeaderView.m8352setAnimatedTitle$lambda4(this.f29364b, this.f29365c);
    }
}
