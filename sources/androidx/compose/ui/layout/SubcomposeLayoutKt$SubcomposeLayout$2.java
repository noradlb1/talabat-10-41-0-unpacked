package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SubcomposeLayoutKt$SubcomposeLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f9881g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<SubcomposeMeasureScope, Constraints, MeasureResult> f9882h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f9883i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f9884j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcomposeLayoutKt$SubcomposeLayout$2(Modifier modifier, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2, int i11, int i12) {
        super(2);
        this.f9881g = modifier;
        this.f9882h = function2;
        this.f9883i = i11;
        this.f9884j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SubcomposeLayoutKt.SubcomposeLayout(this.f9881g, this.f9882h, composer, this.f9883i | 1, this.f9884j);
    }
}
