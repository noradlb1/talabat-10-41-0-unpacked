package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f4221g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f4222h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4223i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1(Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, float f11, int i11) {
        super(2);
        this.f4221g = function3;
        this.f4222h = f11;
        this.f4223i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            this.f4221g.invoke(PaddingKt.m483PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, this.f4222h, 7, (Object) null), composer, Integer.valueOf(this.f4223i & 112));
        } else {
            composer.skipToGroupEnd();
        }
    }
}
