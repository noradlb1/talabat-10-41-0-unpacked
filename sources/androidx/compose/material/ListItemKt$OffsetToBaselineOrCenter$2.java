package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ListItemKt$OffsetToBaselineOrCenter$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f4647g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4648h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4649i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4650j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4651k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$OffsetToBaselineOrCenter$2(float f11, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f4647g = f11;
        this.f4648h = modifier;
        this.f4649i = function2;
        this.f4650j = i11;
        this.f4651k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ListItemKt.m1281OffsetToBaselineOrCenterKz89ssw(this.f4647g, this.f4648h, this.f4649i, composer, this.f4650j | 1, this.f4651k);
    }
}
