package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldImplKt$Decoration$colorAndEmphasis$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f6002g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Float f6003h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6004i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6005j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$Decoration$colorAndEmphasis$1(long j11, Float f11, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f6002g = j11;
        this.f6003h = f11;
        this.f6004i = function2;
        this.f6005j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(this.f6002g))};
            final Float f11 = this.f6003h;
            final Function2<Composer, Integer, Unit> function2 = this.f6004i;
            final int i12 = this.f6005j;
            final long j11 = this.f6002g;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -1132188434, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                    } else if (f11 != null) {
                        composer.startReplaceableGroup(-452622131);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(f11)}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ((i12 >> 6) & 112) | 8);
                        composer.endReplaceableGroup();
                    } else {
                        composer.startReplaceableGroup(-452621951);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2921getAlphaimpl(j11)))}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ((i12 >> 6) & 112) | 8);
                        composer.endReplaceableGroup();
                    }
                }
            }), composer, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
