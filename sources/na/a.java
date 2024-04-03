package na;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.firebase.perf.util.FirstDrawDoneListener;

public final /* synthetic */ class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirstDrawDoneListener f50689b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f50690c;

    public /* synthetic */ a(FirstDrawDoneListener firstDrawDoneListener, View view) {
        this.f50689b = firstDrawDoneListener;
        this.f50690c = view;
    }

    public final void onGlobalLayout() {
        this.f50689b.lambda$onDraw$0(this.f50690c);
    }
}
