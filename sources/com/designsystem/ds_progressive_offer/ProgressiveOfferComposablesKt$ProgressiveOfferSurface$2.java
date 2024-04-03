package com.designsystem.ds_progressive_offer;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt$ProgressiveOfferSurface$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32512g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32513h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Long f32514i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f32515j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f32516k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f32517l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableState<Long> f32518m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableState<String> f32519n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ State<Float> f32520o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MutableState<String> f32521p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$ProgressiveOfferSurface$2(Modifier modifier, boolean z11, Long l11, Integer num, float f11, int i11, MutableState<Long> mutableState, MutableState<String> mutableState2, State<Float> state, MutableState<String> mutableState3) {
        super(2);
        this.f32512g = modifier;
        this.f32513h = z11;
        this.f32514i = l11;
        this.f32515j = num;
        this.f32516k = f11;
        this.f32517l = i11;
        this.f32518m = mutableState;
        this.f32519n = mutableState2;
        this.f32520o = state;
        this.f32521p = mutableState3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        MutableState<String> mutableState;
        boolean z11;
        State<Float> state;
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier testTag = TestTagKt.testTag(this.f32512g, ProgressiveOffer.ProgressiveOfferTestTag);
            boolean z12 = this.f32513h;
            Long l11 = this.f32514i;
            Integer num = this.f32515j;
            float f11 = this.f32516k;
            int i12 = this.f32517l;
            MutableState<Long> mutableState2 = this.f32518m;
            MutableState<String> mutableState3 = this.f32519n;
            State<Float> state2 = this.f32520o;
            MutableState<String> mutableState4 = this.f32521p;
            composer2.startReplaceableGroup(-1113031299);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            composer2.startReplaceableGroup(1376089335);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(testTag);
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
            Composer r02 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r02, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r02, density, companion.getSetDensity());
            Updater.m2543setimpl(r02, layoutDirection, companion.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(276693241);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (z12) {
                composer2.startReplaceableGroup(-1399353684);
                z11 = false;
                mutableState = mutableState4;
                state = state2;
                ProgressiveOfferComposablesKt.OfferTier(l11 != null, ProgressiveOfferComposablesKt.m8533ProgressiveOfferSurface$lambda3(mutableState2), ProgressiveOfferComposablesKt.m8530ProgressiveOfferSurface$lambda22(mutableState3), num, ProgressiveOfferComposablesKt.m8532ProgressiveOfferSurface$lambda24(state2), f11, f11 == 1.0f, composer, ((i12 >> 3) & 7168) | ((i12 << 9) & Opcodes.ASM7), 0);
                composer.endReplaceableGroup();
            } else {
                z11 = false;
                mutableState = mutableState4;
                state = state2;
                composer2.startReplaceableGroup(-1399353239);
                composer.endReplaceableGroup();
            }
            ProgressiveOfferComposablesKt.OfferProgress(f11, composer2, (i12 >> 6) & 14);
            String r12 = ProgressiveOfferComposablesKt.m8528ProgressiveOfferSurface$lambda19(mutableState);
            if (r12 == null) {
                composer2.startReplaceableGroup(-430273294);
            } else {
                composer2.startReplaceableGroup(-1399353105);
                ProgressiveOfferComposablesKt.OfferDescriptor(r12, z12, ProgressiveOfferComposablesKt.m8532ProgressiveOfferSurface$lambda24(state), f11 == 1.0f ? true : z11, composer, (i12 >> 15) & 112);
            }
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
