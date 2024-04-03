package androidx.compose.foundation.text;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import f0.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldCursorKt$cursor$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Brush f3553g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3554h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3555i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ OffsetMapping f3556j;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1", f = "TextFieldCursor.kt", i = {}, l = {50, 52}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f3557h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(animatable, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f3557h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable<Float, AnimationVector1D> animatable = animatable;
                Float boxFloat = Boxing.boxFloat(1.0f);
                this.f3557h = 1;
                if (animatable.snapTo(boxFloat, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i11 == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Animatable<Float, AnimationVector1D> animatable2 = animatable;
            Float boxFloat2 = Boxing.boxFloat(0.0f);
            AnimationSpec access$getCursorAnimationSpec$p = TextFieldCursorKt.cursorAnimationSpec;
            this.f3557h = 2;
            if (Animatable.animateTo$default(animatable2, boxFloat2, access$getCursorAnimationSpec$p, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldCursorKt$cursor$1(Brush brush, TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        super(3);
        this.f3553g = brush;
        this.f3554h = textFieldState;
        this.f3555i = textFieldValue;
        this.f3556j = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1634330012);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1634330012, i11, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:43)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final Animatable animatable = (Animatable) rememberedValue;
        Brush brush = this.f3553g;
        boolean z11 = true;
        if (brush instanceof SolidColor) {
            if (((SolidColor) brush).m3235getValue0d7_KjU() == Color.Companion.m2955getUnspecified0d7_KjU()) {
                z11 = false;
            }
        }
        if (!this.f3554h.getHasFocus() || !TextRange.m5032getCollapsedimpl(this.f3555i.m5234getSelectiond9O1mEE()) || !z11) {
            modifier2 = Modifier.Companion;
        } else {
            EffectsKt.LaunchedEffect(this.f3555i.getAnnotatedString(), TextRange.m5026boximpl(this.f3555i.m5234getSelectiond9O1mEE()), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), composer, 512);
            final OffsetMapping offsetMapping = this.f3556j;
            final TextFieldValue textFieldValue = this.f3555i;
            final TextFieldState textFieldState = this.f3554h;
            final Brush brush2 = this.f3553g;
            modifier2 = DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ContentDrawScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
                    Rect rect;
                    TextLayoutResult value;
                    ContentDrawScope contentDrawScope2 = contentDrawScope;
                    Intrinsics.checkNotNullParameter(contentDrawScope2, "$this$drawWithContent");
                    contentDrawScope.drawContent();
                    float coerceIn = RangesKt___RangesKt.coerceIn(animatable.getValue().floatValue(), 0.0f, 1.0f);
                    if (!(coerceIn == 0.0f)) {
                        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m5038getStartimpl(textFieldValue.m5234getSelectiond9O1mEE()));
                        TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                        if (layoutResult == null || (value = layoutResult.getValue()) == null || (rect = value.getCursorRect(originalToTransformed)) == null) {
                            rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                        }
                        float r72 = contentDrawScope2.m5447toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
                        float f11 = r72 / ((float) 2);
                        float coerceAtMost = RangesKt___RangesKt.coerceAtMost(rect.getLeft() + f11, Size.m2745getWidthimpl(contentDrawScope.m3425getSizeNHjbRc()) - f11);
                        b.B(contentDrawScope, brush2, OffsetKt.Offset(coerceAtMost, rect.getTop()), OffsetKt.Offset(coerceAtMost, rect.getBottom()), r72, 0, (PathEffect) null, coerceIn, (ColorFilter) null, 0, 432, (Object) null);
                    }
                }
            });
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifier2;
    }
}
