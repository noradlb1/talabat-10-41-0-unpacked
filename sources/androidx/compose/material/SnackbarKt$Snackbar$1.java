package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SnackbarKt$Snackbar$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5412g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5413h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f5414i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5415j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$Snackbar$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11, boolean z11) {
        super(2);
        this.f5412g = function2;
        this.f5413h = function22;
        this.f5414i = i11;
        this.f5415j = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer, 6)))};
            final Function2<Composer, Integer, Unit> function2 = this.f5412g;
            final Function2<Composer, Integer, Unit> function22 = this.f5413h;
            final int i12 = this.f5414i;
            final boolean z11 = this.f5415j;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 1939362236, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2();
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final Function2<Composer, Integer, Unit> function22 = function22;
                        final int i12 = i12;
                        final boolean z11 = z11;
                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer, 225114541, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                if ((i11 & 11) == 2 && composer.getSkipping()) {
                                    composer.skipToGroupEnd();
                                } else if (function2 == null) {
                                    composer.startReplaceableGroup(59708346);
                                    SnackbarKt.TextOnlySnackbar(function22, composer, (i12 >> 21) & 14);
                                    composer.endReplaceableGroup();
                                } else if (z11) {
                                    composer.startReplaceableGroup(59708411);
                                    Function2<Composer, Integer, Unit> function2 = function22;
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    int i12 = i12;
                                    SnackbarKt.NewLineButtonSnackbar(function2, function22, composer, (i12 & 112) | ((i12 >> 21) & 14));
                                    composer.endReplaceableGroup();
                                } else {
                                    composer.startReplaceableGroup(59708478);
                                    Function2<Composer, Integer, Unit> function23 = function22;
                                    Function2<Composer, Integer, Unit> function24 = function2;
                                    int i13 = i12;
                                    SnackbarKt.OneRowSnackbar(function23, function24, composer, (i13 & 112) | ((i13 >> 21) & 14));
                                    composer.endReplaceableGroup();
                                }
                            }
                        }), composer, 48);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
