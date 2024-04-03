package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7878g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SubcomposeMeasureScope f7879h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ List<Placeable> f7880i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7881j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ List<Placeable> f7882k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Integer f7883l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f7884m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7885n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(WindowInsets windowInsets, SubcomposeMeasureScope subcomposeMeasureScope, List<? extends Placeable> list, int i11, List<? extends Placeable> list2, Integer num, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, int i12) {
        super(2);
        this.f7878g = windowInsets;
        this.f7879h = subcomposeMeasureScope;
        this.f7880i = list;
        this.f7881j = i11;
        this.f7882k = list2;
        this.f7883l = num;
        this.f7884m = function3;
        this.f7885n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        float f11;
        float f12;
        Integer num;
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1643221465, i11, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:222)");
            }
            PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(this.f7878g, this.f7879h);
            if (this.f7880i.isEmpty()) {
                f11 = asPaddingValues.m499calculateTopPaddingD9Ej5fM();
            } else {
                f11 = this.f7879h.m5444toDpu2uoSUM(this.f7881j);
            }
            if (this.f7882k.isEmpty() || (num = this.f7883l) == null) {
                f12 = asPaddingValues.m496calculateBottomPaddingD9Ej5fM();
            } else {
                f12 = this.f7879h.m5444toDpu2uoSUM(num.intValue());
            }
            this.f7884m.invoke(PaddingKt.m482PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(asPaddingValues, this.f7879h.getLayoutDirection()), f11, PaddingKt.calculateEndPadding(asPaddingValues, this.f7879h.getLayoutDirection()), f12), composer, Integer.valueOf((this.f7885n >> 3) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
