package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SubcomposeLayoutKt$SubcomposeLayout$4 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcomposeLayoutState f9885g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcomposeLayoutKt$SubcomposeLayout$4(SubcomposeLayoutState subcomposeLayoutState) {
        super(0);
        this.f9885g = subcomposeLayoutState;
    }

    public final void invoke() {
        this.f9885g.forceRecomposeChildren$ui_release();
    }
}
