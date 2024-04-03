package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ListItemKt$BaselinesOffsetColumn$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<Dp> f4630g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4631h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4632i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4633j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4634k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$BaselinesOffsetColumn$2(List<Dp> list, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f4630g = list;
        this.f4631h = modifier;
        this.f4632i = function2;
        this.f4633j = i11;
        this.f4634k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ListItemKt.BaselinesOffsetColumn(this.f4630g, this.f4631h, this.f4632i, composer, this.f4633j | 1, this.f4634k);
    }
}
