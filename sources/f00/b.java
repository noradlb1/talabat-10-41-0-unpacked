package f00;

import android.view.View;
import io.flutter.util.ViewUtils;

public final /* synthetic */ class b implements ViewUtils.ViewVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class[] f14053a;

    public /* synthetic */ b(Class[] clsArr) {
        this.f14053a = clsArr;
    }

    public final boolean run(View view) {
        return ViewUtils.lambda$hasChildViewOfType$1(this.f14053a, view);
    }
}
