package androidx.compose.ui.window;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidDialog_androidKt$Dialog$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DialogWrapper f10340g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f10341h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DialogProperties f10342i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LayoutDirection f10343j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidDialog_androidKt$Dialog$2(DialogWrapper dialogWrapper, Function0<Unit> function0, DialogProperties dialogProperties, LayoutDirection layoutDirection) {
        super(0);
        this.f10340g = dialogWrapper;
        this.f10341h = function0;
        this.f10342i = dialogProperties;
        this.f10343j = layoutDirection;
    }

    public final void invoke() {
        this.f10340g.updateParameters(this.f10341h, this.f10342i, this.f10343j);
    }
}
