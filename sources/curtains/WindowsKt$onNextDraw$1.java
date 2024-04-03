package curtains;

import android.view.View;
import curtains.internal.NextDrawListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "decorView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class WindowsKt$onNextDraw$1 extends Lambda implements Function1<View, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0 f13800g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowsKt$onNextDraw$1(Function0 function0) {
        super(1);
        this.f13800g = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "decorView");
        NextDrawListener.Companion.onNextDraw(view, this.f13800g);
    }
}
