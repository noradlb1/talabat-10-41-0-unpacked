package com.designsystem.ds_loading_indicator;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.CardKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCancellationBehavior;
import com.airbnb.lottie.compose.LottieClipSpec;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSLoadingIndicatorKt$DSLoadingIndicator$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f32372g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32373h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f32374i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSLoadingIndicatorKt$DSLoadingIndicator$1(boolean z11, int i11, Modifier modifier) {
        super(2);
        this.f32372g = z11;
        this.f32373h = i11;
        this.f32374i = modifier;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final LottieComposition m8495invoke$lambda0(LottieCompositionResult lottieCompositionResult) {
        return (LottieComposition) lottieCompositionResult.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final float m8496invoke$lambda1(LottieAnimationState lottieAnimationState) {
        return ((Number) lottieAnimationState.getValue()).floatValue();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m9175boximpl(DSLoadingIndicatorKt.getDSLoadingIndicatorCompositionSpec()), (String) null, (String) null, (String) null, (String) null, (Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object>) null, composer, 8, 62);
            LottieAnimationState animateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(m8495invoke$lambda0(rememberLottieComposition), this.f32372g, false, (LottieClipSpec) null, 0.0f, Integer.MAX_VALUE, (LottieCancellationBehavior) null, false, composer, 196616 | (this.f32373h & 112), 220);
            if (this.f32372g) {
                composer2.startReplaceableGroup(-716355288);
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(this.f32374i, 0.0f, 1, (Object) null);
                Alignment center = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(-1990474327);
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 0);
                composer2.startReplaceableGroup(1376089335);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxSize$default);
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
                Composer r92 = Updater.m2536constructorimpl(composer);
                Updater.m2543setimpl(r92, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2543setimpl(r92, density, companion.getSetDensity());
                Updater.m2543setimpl(r92, layoutDirection, companion.getSetLayoutDirection());
                composer.enableReusing();
                materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-1253629305);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Modifier r22 = SizeKt.m558size3ABfNKs(Modifier.Companion, DSLoadingIndicatorKt.LoadingIndicatorCircleSize);
                RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
                float access$getLoadingIndicatorElevation$p = DSLoadingIndicatorKt.LoadingIndicatorElevation;
                CardKt.m1142CardFjzlyU(r22, circleShape, DSTheme.INSTANCE.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU(), 0, (BorderStroke) null, access$getLoadingIndicatorElevation$p, ComposableLambdaKt.composableLambda(composer2, -819893019, true, new DSLoadingIndicatorKt$DSLoadingIndicator$1$1$1(rememberLottieComposition, animateLottieCompositionAsState)), composer, 1769478, 24);
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                return;
            }
            composer2.startReplaceableGroup(-716354210);
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }
}
