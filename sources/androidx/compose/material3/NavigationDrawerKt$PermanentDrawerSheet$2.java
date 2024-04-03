package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$PermanentDrawerSheet$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f7526g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f7527h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f7528i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7529j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f7530k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7531l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f7532m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7533n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7534o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$PermanentDrawerSheet$2(Modifier modifier, Shape shape, long j11, long j12, float f11, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f7526g = modifier;
        this.f7527h = shape;
        this.f7528i = j11;
        this.f7529j = j12;
        this.f7530k = f11;
        this.f7531l = windowInsets;
        this.f7532m = function3;
        this.f7533n = i11;
        this.f7534o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationDrawerKt.m1767PermanentDrawerSheetafqeVBk(this.f7526g, this.f7527h, this.f7528i, this.f7529j, this.f7530k, this.f7531l, this.f7532m, composer, this.f7533n | 1, this.f7534o);
    }
}
