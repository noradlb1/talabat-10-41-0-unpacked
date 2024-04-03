package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import j0.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$CoreTextField$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f3371g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3372h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3373i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3374j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TextStyle f3375k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextFieldScrollerPosition f3376l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3377m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f3378n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Modifier f3379o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Modifier f3380p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Modifier f3381q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Modifier f3382r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ BringIntoViewRequester f3383s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3384t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ boolean f3385u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ boolean f3386v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f3387w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Density f3388x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$5(Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, int i11, TextFieldState textFieldState, int i12, TextStyle textStyle, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldSelectionManager textFieldSelectionManager, boolean z11, boolean z12, Function1<? super TextLayoutResult, Unit> function1, Density density) {
        super(2);
        this.f3371g = function3;
        this.f3372h = i11;
        this.f3373i = textFieldState;
        this.f3374j = i12;
        this.f3375k = textStyle;
        this.f3376l = textFieldScrollerPosition;
        this.f3377m = textFieldValue;
        this.f3378n = visualTransformation;
        this.f3379o = modifier;
        this.f3380p = modifier2;
        this.f3381q = modifier3;
        this.f3382r = modifier4;
        this.f3383s = bringIntoViewRequester;
        this.f3384t = textFieldSelectionManager;
        this.f3385u = z11;
        this.f3386v = z12;
        this.f3387w = function1;
        this.f3388x = density;
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
                ComposerKt.traceEventStart(-1885146845, i12, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:542)");
            }
            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function3 = this.f3371g;
            final TextFieldState textFieldState = this.f3373i;
            final int i13 = this.f3374j;
            final TextStyle textStyle = this.f3375k;
            final TextFieldScrollerPosition textFieldScrollerPosition = this.f3376l;
            final TextFieldValue textFieldValue = this.f3377m;
            final VisualTransformation visualTransformation = this.f3378n;
            final Modifier modifier = this.f3379o;
            final Modifier modifier2 = this.f3380p;
            final Modifier modifier3 = this.f3381q;
            final Modifier modifier4 = this.f3382r;
            final BringIntoViewRequester bringIntoViewRequester = this.f3383s;
            final TextFieldSelectionManager textFieldSelectionManager = this.f3384t;
            final boolean z11 = this.f3385u;
            final boolean z12 = this.f3386v;
            final Function1<TextLayoutResult, Unit> function1 = this.f3387w;
            final Density density = this.f3388x;
            AnonymousClass1 r32 = new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(207445534, i11, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:543)");
                        }
                        Modifier bringIntoViewRequester = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(MaxLinesHeightModifierKt.maxLinesHeight(SizeKt.m546heightInVpY3zN4$default(Modifier.Companion, textFieldState.m926getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, (Object) null), i13, textStyle), textFieldScrollerPosition, textFieldValue, visualTransformation, new CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1(textFieldState)).then(modifier).then(modifier2), textStyle).then(modifier3).then(modifier4), bringIntoViewRequester);
                        final TextFieldSelectionManager textFieldSelectionManager = textFieldSelectionManager;
                        final TextFieldState textFieldState = textFieldState;
                        final boolean z11 = z11;
                        final boolean z12 = z12;
                        final Function1<TextLayoutResult, Unit> function1 = function1;
                        final Density density = density;
                        final int i12 = i13;
                        SimpleLayoutKt.SimpleLayout(bringIntoViewRequester, ComposableLambdaKt.composableLambda(composer, 19580180, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                if ((i11 & 11) != 2 || !composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(19580180, i11, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:564)");
                                    }
                                    final TextFieldState textFieldState = textFieldState;
                                    final Function1<TextLayoutResult, Unit> function1 = function1;
                                    final Density density = density;
                                    final int i12 = i12;
                                    AnonymousClass2 r92 = new MeasurePolicy() {
                                        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                                            return d.a(this, intrinsicMeasureScope, list, i11);
                                        }

                                        public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
                                            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                                            Intrinsics.checkNotNullParameter(list, "measurables");
                                            textFieldState.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                            return textFieldState.getTextDelegate().getMaxIntrinsicWidth();
                                        }

                                        @NotNull
                                        /* renamed from: measure-3p2s80s  reason: not valid java name */
                                        public MeasureResult m841measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
                                            Snapshot makeCurrent;
                                            TextLayoutResult textLayoutResult;
                                            int i11;
                                            Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
                                            Intrinsics.checkNotNullParameter(list, "measurables");
                                            Snapshot.Companion companion = Snapshot.Companion;
                                            TextFieldState textFieldState = textFieldState;
                                            Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
                                            try {
                                                makeCurrent = createNonObservableSnapshot.makeCurrent();
                                                TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                                                if (layoutResult != null) {
                                                    textLayoutResult = layoutResult.getValue();
                                                } else {
                                                    textLayoutResult = null;
                                                }
                                                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                                createNonObservableSnapshot.dispose();
                                                Triple<Integer, Integer, TextLayoutResult> r102 = TextFieldDelegate.Companion.m910layout_EkL_Y$foundation_release(textFieldState.getTextDelegate(), j11, measureScope.getLayoutDirection(), textLayoutResult);
                                                int intValue = r102.component1().intValue();
                                                int intValue2 = r102.component2().intValue();
                                                TextLayoutResult component3 = r102.component3();
                                                if (!Intrinsics.areEqual((Object) textLayoutResult, (Object) component3)) {
                                                    textFieldState.setLayoutResult(new TextLayoutResultProxy(component3));
                                                    function1.invoke(component3);
                                                }
                                                TextFieldState textFieldState2 = textFieldState;
                                                Density density = density;
                                                if (i12 == 1) {
                                                    i11 = TextDelegateKt.ceilToIntPx(component3.getLineBottom(0));
                                                } else {
                                                    i11 = 0;
                                                }
                                                textFieldState2.m927setMinHeightForSingleLineField0680j_4(density.m5444toDpu2uoSUM(i11));
                                                return measureScope.layout(intValue, intValue2, MapsKt__MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt__MathJVMKt.roundToInt(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt__MathJVMKt.roundToInt(component3.getLastBaseline())))), CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2.INSTANCE);
                                            } catch (Throwable th2) {
                                                createNonObservableSnapshot.dispose();
                                                throw th2;
                                            }
                                        }

                                        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                                            return d.c(this, intrinsicMeasureScope, list, i11);
                                        }

                                        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                                            return d.d(this, intrinsicMeasureScope, list, i11);
                                        }
                                    };
                                    composer.startReplaceableGroup(-1323940314);
                                    Modifier.Companion companion = Modifier.Companion;
                                    Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
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
                                    Composer r52 = Updater.m2536constructorimpl(composer);
                                    Updater.m2543setimpl(r52, r92, companion2.getSetMeasurePolicy());
                                    Updater.m2543setimpl(r52, density2, companion2.getSetDensity());
                                    Updater.m2543setimpl(r52, layoutDirection, companion2.getSetLayoutDirection());
                                    Updater.m2543setimpl(r52, viewConfiguration, companion2.getSetViewConfiguration());
                                    composer.enableReusing();
                                    boolean z11 = false;
                                    materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
                                    composer.startReplaceableGroup(2058660585);
                                    composer.startReplaceableGroup(1714611517);
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    composer.endNode();
                                    composer.endReplaceableGroup();
                                    TextFieldSelectionManager textFieldSelectionManager = textFieldSelectionManager;
                                    if (textFieldState.getHandleState() == HandleState.Selection && textFieldState.getLayoutCoordinates() != null) {
                                        LayoutCoordinates layoutCoordinates = textFieldState.getLayoutCoordinates();
                                        Intrinsics.checkNotNull(layoutCoordinates);
                                        if (layoutCoordinates.isAttached() && z11) {
                                            z11 = true;
                                        }
                                    }
                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager, z11, composer, 8);
                                    if (textFieldState.getHandleState() == HandleState.Cursor && !z12 && z11) {
                                        CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager, composer, 8);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            Composer composer3 = composer;
            function3.invoke(ComposableLambdaKt.composableLambda(composer3, 207445534, true, r32), composer3, Integer.valueOf(((this.f3372h >> 9) & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
