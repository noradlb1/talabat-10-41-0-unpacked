package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcomposeMeasureScope f5054g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5055h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f5056i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5057j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(SubcomposeMeasureScope subcomposeMeasureScope, int i11, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, int i12) {
        super(2);
        this.f5054g = subcomposeMeasureScope;
        this.f5055h = i11;
        this.f5056i = function3;
        this.f5057j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            this.f5056i.invoke(PaddingKt.m483PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, this.f5054g.m5444toDpu2uoSUM(this.f5055h), 7, (Object) null), composer, Integer.valueOf((this.f5057j >> 6) & 112));
            return;
        }
        composer.skipToGroupEnd();
    }
}
