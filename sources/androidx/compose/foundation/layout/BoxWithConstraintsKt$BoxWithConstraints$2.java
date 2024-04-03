package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BoxWithConstraintsKt$BoxWithConstraints$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f2471g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Alignment f2472h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f2473i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<BoxWithConstraintsScope, Composer, Integer, Unit> f2474j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f2475k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f2476l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoxWithConstraintsKt$BoxWithConstraints$2(Modifier modifier, Alignment alignment, boolean z11, Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f2471g = modifier;
        this.f2472h = alignment;
        this.f2473i = z11;
        this.f2474j = function3;
        this.f2475k = i11;
        this.f2476l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BoxWithConstraintsKt.BoxWithConstraints(this.f2471g, this.f2472h, this.f2473i, this.f2474j, composer, this.f2475k | 1, this.f2476l);
    }
}
