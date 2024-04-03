package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AlertDialogKt$AlertDialogContent$1$1$2$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ColumnScope f6262g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6263h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6264i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6265j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogContent$1$1$2$1(ColumnScope columnScope, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11) {
        super(2);
        this.f6262g = columnScope;
        this.f6263h = function2;
        this.f6264i = function22;
        this.f6265j = i11;
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
                ComposerKt.traceEventStart(1845262876, i11, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:75)");
            }
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), DialogTokens.INSTANCE.getHeadlineFont());
            final ColumnScope columnScope = this.f6262g;
            final Function2<Composer, Integer, Unit> function2 = this.f6263h;
            final Function2<Composer, Integer, Unit> function22 = this.f6264i;
            final int i12 = this.f6265j;
            TextKt.ProvideTextStyle(fromToken, ComposableLambdaKt.composableLambda(composer, 483464909, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    Alignment.Horizontal horizontal;
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(483464909, i11, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:77)");
                        }
                        ColumnScope columnScope = columnScope;
                        Modifier padding = PaddingKt.padding(Modifier.Companion, AlertDialogKt.TitlePadding);
                        if (function2 == null) {
                            horizontal = Alignment.Companion.getStart();
                        } else {
                            horizontal = Alignment.Companion.getCenterHorizontally();
                        }
                        Modifier align = columnScope.align(padding, horizontal);
                        Function2<Composer, Integer, Unit> function2 = function22;
                        int i12 = i12;
                        composer.startReplaceableGroup(733328855);
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
                        composer.startReplaceableGroup(-1323940314);
                        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(align);
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(constructor);
                        } else {
                            composer.useNode();
                        }
                        composer.disableReusing();
                        Composer r82 = Updater.m2536constructorimpl(composer);
                        Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                        Updater.m2543setimpl(r82, density, companion.getSetDensity());
                        Updater.m2543setimpl(r82, layoutDirection, companion.getSetLayoutDirection());
                        Updater.m2543setimpl(r82, viewConfiguration, companion.getSetViewConfiguration());
                        composer.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
                        composer.startReplaceableGroup(2058660585);
                        composer.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer.startReplaceableGroup(1708709843);
                        function2.invoke(composer, Integer.valueOf((i12 >> 9) & 14));
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
