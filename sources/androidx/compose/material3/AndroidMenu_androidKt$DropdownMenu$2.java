package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidMenu_androidKt$DropdownMenu$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f6347g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6348h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6349i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f6350j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PopupProperties f6351k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f6352l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f6353m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6354n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidMenu_androidKt$DropdownMenu$2(boolean z11, Function0<Unit> function0, Modifier modifier, long j11, PopupProperties popupProperties, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6347g = z11;
        this.f6348h = function0;
        this.f6349i = modifier;
        this.f6350j = j11;
        this.f6351k = popupProperties;
        this.f6352l = function3;
        this.f6353m = i11;
        this.f6354n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidMenu_androidKt.m1497DropdownMenuILWXrKs(this.f6347g, this.f6348h, this.f6349i, this.f6350j, this.f6351k, this.f6352l, composer, this.f6353m | 1, this.f6354n);
    }
}
