package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ListItemKt$ListItem$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f4635g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4636h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4637i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4638j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4639k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4640l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4641m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f4642n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f4643o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$ListItem$1(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z11, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, int i11, int i12) {
        super(2);
        this.f4635g = modifier;
        this.f4636h = function2;
        this.f4637i = function22;
        this.f4638j = z11;
        this.f4639k = function23;
        this.f4640l = function24;
        this.f4641m = function25;
        this.f4642n = i11;
        this.f4643o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ListItemKt.ListItem(this.f4635g, this.f4636h, this.f4637i, this.f4638j, this.f4639k, this.f4640l, this.f4641m, composer, this.f4642n | 1, this.f4643o);
    }
}
