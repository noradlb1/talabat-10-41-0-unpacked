package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CrossfadeKt$Crossfade$4$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<T> f1222g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1223h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FiniteAnimationSpec<Float> f1224i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ T f1225j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<T, Composer, Integer, Unit> f1226k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CrossfadeKt$Crossfade$4$1(Transition<T> transition, int i11, FiniteAnimationSpec<Float> finiteAnimationSpec, T t11, Function3<? super T, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.f1222g = transition;
        this.f1223h = i11;
        this.f1224i = finiteAnimationSpec;
        this.f1225j = t11;
        this.f1226k = function3;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final float m45invoke$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            Transition<T> transition = this.f1222g;
            CrossfadeKt$Crossfade$4$1$alpha$2 crossfadeKt$Crossfade$4$1$alpha$2 = new CrossfadeKt$Crossfade$4$1$alpha$2(this.f1224i);
            T t11 = this.f1225j;
            int i12 = this.f1223h & 14;
            composer.startReplaceableGroup(-1338768149);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int i13 = i12 & 14;
            int i14 = i12 << 3;
            int i15 = (i14 & 57344) | i13 | (i14 & 896) | (i14 & 7168);
            composer.startReplaceableGroup(-142660079);
            T currentState = transition.getCurrentState();
            composer.startReplaceableGroup(-438678252);
            float f11 = 1.0f;
            float f12 = Intrinsics.areEqual((Object) currentState, (Object) t11) ? 1.0f : 0.0f;
            composer.endReplaceableGroup();
            Float valueOf = Float.valueOf(f12);
            T targetState = transition.getTargetState();
            composer.startReplaceableGroup(-438678252);
            if (!Intrinsics.areEqual((Object) targetState, (Object) t11)) {
                f11 = 0.0f;
            }
            composer.endReplaceableGroup();
            State<Float> createTransitionAnimation = TransitionKt.createTransitionAnimation(transition, valueOf, Float.valueOf(f11), (FiniteAnimationSpec) crossfadeKt$Crossfade$4$1$alpha$2.invoke(transition.getSegment(), composer, Integer.valueOf((i15 >> 3) & 112)), vectorConverter, "FloatAnimation", composer, (i15 & 14) | (57344 & (i15 << 9)) | ((i15 << 6) & Opcodes.ASM7));
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            Modifier.Companion companion = Modifier.Companion;
            composer.startReplaceableGroup(1157296644);
            boolean changed = composer.changed((Object) createTransitionAnimation);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new CrossfadeKt$Crossfade$4$1$1$1(createTransitionAnimation);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) rememberedValue);
            Function3<T, Composer, Integer, Unit> function3 = this.f1226k;
            T t12 = this.f1225j;
            int i16 = this.f1223h;
            composer.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
            composer.startReplaceableGroup(1376089335);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(graphicsLayer);
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
            Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r82, density, companion2.getSetDensity());
            Updater.m2543setimpl(r82, layoutDirection, companion2.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer.startReplaceableGroup(-222715758);
            function3.invoke(t12, composer, Integer.valueOf((i16 >> 9) & 112));
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }
}
