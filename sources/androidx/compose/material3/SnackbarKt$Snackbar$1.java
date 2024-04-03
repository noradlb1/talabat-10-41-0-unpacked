package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarKt$Snackbar$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8282g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8283h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8284i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f8285j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f8286k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f8287l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f8288m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$Snackbar$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, long j11, long j12, int i11, boolean z11) {
        super(2);
        this.f8282g = function2;
        this.f8283h = function22;
        this.f8284i = function23;
        this.f8285j = j11;
        this.f8286k = j12;
        this.f8287l = i11;
        this.f8288m = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1829663446, i11, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:109)");
            }
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            Typography typography = materialTheme.getTypography(composer, 6);
            SnackbarTokens snackbarTokens = SnackbarTokens.INSTANCE;
            TextStyle fromToken = TypographyKt.fromToken(typography, snackbarTokens.getSupportingTextFont());
            final TextStyle fromToken2 = TypographyKt.fromToken(materialTheme.getTypography(composer, 6), snackbarTokens.getActionLabelTextFont());
            ProvidedValue[] providedValueArr = {TextKt.getLocalTextStyle().provides(fromToken)};
            final Function2<Composer, Integer, Unit> function2 = this.f8282g;
            final Function2<Composer, Integer, Unit> function22 = this.f8283h;
            final Function2<Composer, Integer, Unit> function23 = this.f8284i;
            final long j11 = this.f8285j;
            final long j12 = this.f8286k;
            final int i12 = this.f8287l;
            final boolean z11 = this.f8288m;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 835891690, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(835891690, i11, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:112)");
                        }
                        if (function2 == null) {
                            composer.startReplaceableGroup(-2104362770);
                            Function2<Composer, Integer, Unit> function2 = function22;
                            Function2<Composer, Integer, Unit> function22 = function23;
                            TextStyle textStyle = fromToken2;
                            long j11 = j11;
                            long j12 = j12;
                            int i12 = i12;
                            Composer composer2 = composer;
                            SnackbarKt.m1826OneRowSnackbarkKq0p4A(function2, (Function2<? super Composer, ? super Integer, Unit>) null, function22, textStyle, j11, j12, composer2, (57344 & (i12 >> 9)) | ((i12 >> 27) & 14) | 48 | (i12 & 896) | ((i12 >> 9) & Opcodes.ASM7));
                            composer.endReplaceableGroup();
                        } else if (z11) {
                            composer.startReplaceableGroup(-2104362456);
                            Function2<Composer, Integer, Unit> function23 = function22;
                            Function2<Composer, Integer, Unit> function24 = function2;
                            Function2<Composer, Integer, Unit> function25 = function23;
                            TextStyle textStyle2 = fromToken2;
                            long j13 = j11;
                            long j14 = j12;
                            int i13 = i12;
                            Composer composer3 = composer;
                            SnackbarKt.m1825NewLineButtonSnackbarkKq0p4A(function23, function24, function25, textStyle2, j13, j14, composer3, (57344 & (i13 >> 9)) | ((i13 >> 27) & 14) | (i13 & 112) | (i13 & 896) | ((i13 >> 9) & Opcodes.ASM7));
                            composer.endReplaceableGroup();
                        } else {
                            composer.startReplaceableGroup(-2104362176);
                            Function2<Composer, Integer, Unit> function26 = function22;
                            Function2<Composer, Integer, Unit> function27 = function2;
                            Function2<Composer, Integer, Unit> function28 = function23;
                            TextStyle textStyle3 = fromToken2;
                            long j15 = j11;
                            long j16 = j12;
                            int i14 = i12;
                            Composer composer4 = composer;
                            SnackbarKt.m1826OneRowSnackbarkKq0p4A(function26, function27, function28, textStyle3, j15, j16, composer4, (57344 & (i14 >> 9)) | ((i14 >> 27) & 14) | (i14 & 112) | (i14 & 896) | ((i14 >> 9) & Opcodes.ASM7));
                            composer.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
