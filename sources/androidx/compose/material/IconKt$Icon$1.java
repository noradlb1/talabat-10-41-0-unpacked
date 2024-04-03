package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class IconKt$Icon$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Painter f4620g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f4621h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4622i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f4623j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4624k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4625l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconKt$Icon$1(Painter painter, String str, Modifier modifier, long j11, int i11, int i12) {
        super(2);
        this.f4620g = painter;
        this.f4621h = str;
        this.f4622i = modifier;
        this.f4623j = j11;
        this.f4624k = i11;
        this.f4625l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        IconKt.m1278Iconww6aTOc(this.f4620g, this.f4621h, this.f4622i, this.f4623j, composer, this.f4624k | 1, this.f4625l);
    }
}
