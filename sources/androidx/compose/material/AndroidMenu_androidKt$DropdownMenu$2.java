package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AndroidMenu_androidKt$DropdownMenu$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f3859g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f3860h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f3861i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f3862j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PopupProperties f3863k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f3864l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f3865m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f3866n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidMenu_androidKt$DropdownMenu$2(boolean z11, Function0<Unit> function0, Modifier modifier, long j11, PopupProperties popupProperties, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f3859g = z11;
        this.f3860h = function0;
        this.f3861i = modifier;
        this.f3862j = j11;
        this.f3863k = popupProperties;
        this.f3864l = function3;
        this.f3865m = i11;
        this.f3866n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidMenu_androidKt.m1081DropdownMenuILWXrKs(this.f3859g, this.f3860h, this.f3861i, this.f3862j, this.f3863k, this.f3864l, composer, this.f3865m | 1, this.f3866n);
    }
}
