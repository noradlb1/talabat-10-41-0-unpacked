package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1 extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f8769g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8770h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8771i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8772j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8773k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f8774l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1(float f11, TextFieldColors textFieldColors, boolean z11, int i11, Function2<? super Composer, ? super Integer, Unit> function2, int i12) {
        super(3);
        this.f8769g = f11;
        this.f8770h = textFieldColors;
        this.f8771i = z11;
        this.f8772j = i11;
        this.f8773k = function2;
        this.f8774l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        if ((i11 & 14) == 0) {
            i12 = (composer.changed((Object) modifier) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1472145357, i11, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:129)");
            }
            Modifier alpha = AlphaKt.alpha(modifier, this.f8769g);
            TextFieldColors textFieldColors = this.f8770h;
            boolean z11 = this.f8771i;
            int i13 = this.f8772j;
            Function2<Composer, Integer, Unit> function2 = this.f8773k;
            int i14 = this.f8774l;
            composer.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(alpha);
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
            Composer r102 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r102, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r102, density, companion.getSetDensity());
            Updater.m2543setimpl(r102, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r102, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer.startReplaceableGroup(828149203);
            TextFieldImplKt.m1923DecorationKTwxG1Y(textFieldColors.placeholderColor$material3_release(z11, composer, (i13 & 14) | ((i13 >> 9) & 112)).getValue().m2929unboximpl(), MaterialTheme.INSTANCE.getTypography(composer, 6).getBodyLarge(), function2, composer, (i14 >> 9) & 896, 0);
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
}
