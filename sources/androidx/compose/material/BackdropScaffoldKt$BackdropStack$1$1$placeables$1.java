package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldKt$BackdropStack$1$1$placeables$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function4<Constraints, Float, Composer, Integer, Unit> f4021g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f4022h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f4023i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4024j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackdropStack$1$1$placeables$1(Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, long j11, float f11, int i11) {
        super(2);
        this.f4021g = function4;
        this.f4022h = j11;
        this.f4023i = f11;
        this.f4024j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            this.f4021g.invoke(Constraints.m5410boximpl(this.f4022h), Float.valueOf(this.f4023i), composer, Integer.valueOf((this.f4024j >> 3) & 896));
        } else {
            composer.skipToGroupEnd();
        }
    }
}
