package androidx.core.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class ViewKt$postDelayed$runnable$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f11495b;

    public ViewKt$postDelayed$runnable$1(Function0<Unit> function0) {
        this.f11495b = function0;
    }

    public final void run() {
        this.f11495b.invoke();
    }
}
