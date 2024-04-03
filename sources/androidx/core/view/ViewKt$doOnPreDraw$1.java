package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class ViewKt$doOnPreDraw$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<View, Unit> f11493b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f11494c;

    public ViewKt$doOnPreDraw$1(Function1<? super View, Unit> function1, View view) {
        this.f11493b = function1;
        this.f11494c = view;
    }

    public final void run() {
        this.f11493b.invoke(this.f11494c);
    }
}
