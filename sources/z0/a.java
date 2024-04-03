package z0;

import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewTransition f11633b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View[] f11634c;

    public /* synthetic */ a(ViewTransition viewTransition, View[] viewArr) {
        this.f11633b = viewTransition;
        this.f11634c = viewArr;
    }

    public final void run() {
        this.f11633b.lambda$applyTransition$0(this.f11634c);
    }
}
