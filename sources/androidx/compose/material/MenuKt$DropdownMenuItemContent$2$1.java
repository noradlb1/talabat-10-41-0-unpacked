package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class MenuKt$DropdownMenuItemContent$2$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4682g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f4683h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RowScope f4684i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4685j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4686k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuKt$DropdownMenuItemContent$2$1(boolean z11, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, RowScope rowScope, int i11, int i12) {
        super(2);
        this.f4682g = z11;
        this.f4683h = function3;
        this.f4684i = rowScope;
        this.f4685j = i11;
        this.f4686k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        float f11;
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (this.f4682g) {
                composer.startReplaceableGroup(-1945695285);
                f11 = ContentAlpha.INSTANCE.getHigh(composer, 6);
            } else {
                composer.startReplaceableGroup(-1945695262);
                f11 = ContentAlpha.INSTANCE.getDisabled(composer, 6);
            }
            composer.endReplaceableGroup();
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(f11))};
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.f4683h;
            final RowScope rowScope = this.f4684i;
            final int i12 = this.f4685j;
            final int i13 = this.f4686k;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -1705995688, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        function3.invoke(rowScope, composer, Integer.valueOf((i12 & 14) | ((i13 >> 12) & 112)));
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
