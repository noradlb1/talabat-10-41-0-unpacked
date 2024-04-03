package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
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
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
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
public final class TabKt$LeadingIconTab$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f8504g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f8505h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8506i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Indication f8507j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f8508k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8509l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8510m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f8511n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8512o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$LeadingIconTab$2(Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z12, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, int i11, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.f8504g = modifier;
        this.f8505h = z11;
        this.f8506i = mutableInteractionSource;
        this.f8507j = indication;
        this.f8508k = z12;
        this.f8509l = function0;
        this.f8510m = function2;
        this.f8511n = i11;
        this.f8512o = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        int i12 = i11;
        if ((i12 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-429037564, i12, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:170)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m488paddingVpY3zN4$default(SelectableKt.m782selectableO2vRcR0(SizeKt.m544height3ABfNKs(this.f8504g, TabKt.SmallTabHeight), this.f8505h, this.f8506i, this.f8507j, this.f8508k, Role.m4904boximpl(Role.Companion.m4916getTabo7Vup1c()), this.f8509l), TabKt.HorizontalTextPadding, 0.0f, 2, (Object) null), 0.0f, 1, (Object) null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Function2<Composer, Integer, Unit> function2 = this.f8510m;
            int i13 = this.f8511n;
            Function2<Composer, Integer, Unit> function22 = this.f8512o;
            composer2.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxWidth$default);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r11 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r11, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r11, density, companion.getSetDensity());
            Updater.m2543setimpl(r11, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r11, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(-501504408);
            function2.invoke(composer2, Integer.valueOf((i13 >> 9) & 14));
            SpacerKt.Spacer(SizeKt.m555requiredWidth3ABfNKs(Modifier.Companion, TabKt.TextDistanceFromLeadingIcon), composer2, 6);
            TextKt.ProvideTextStyle(TextStyle.m5046copyHL5avdY$default(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont()), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, TextAlign.m5359boximpl(TextAlign.Companion.m5366getCentere0LSkKk()), (TextDirection) null, 0, (TextIndent) null, 245759, (Object) null), function22, composer2, (i13 >> 3) & 112);
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
