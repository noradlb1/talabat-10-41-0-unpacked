package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B°\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001e\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020#H\u0016J.\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0017ø\u0001\u0000¢\u0006\u0002\u0010'J.\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0017ø\u0001\u0000¢\u0006\u0002\u0010'J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010*J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0017ø\u0001\u0000¢\u0006\u0002\u0010*R\u0019\u0010\u0011\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0014\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0017\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0015\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0010\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0016\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0013\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/material/DefaultTextFieldColors;", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "cursorColor", "errorCursorColor", "focusedIndicatorColor", "unfocusedIndicatorColor", "errorIndicatorColor", "disabledIndicatorColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "backgroundColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "(JJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "isError", "equals", "other", "", "hashCode", "", "indicatorColor", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "labelColor", "error", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DefaultTextFieldColors implements TextFieldColors {
    private final long backgroundColor;
    private final long cursorColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorTrailingIconColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long leadingIconColor;
    private final long placeholderColor;
    private final long textColor;
    private final long trailingIconColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;

    private DefaultTextFieldColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33) {
        this.textColor = j11;
        this.disabledTextColor = j12;
        this.cursorColor = j13;
        this.errorCursorColor = j14;
        this.focusedIndicatorColor = j15;
        this.unfocusedIndicatorColor = j16;
        this.errorIndicatorColor = j17;
        this.disabledIndicatorColor = j18;
        this.leadingIconColor = j19;
        this.disabledLeadingIconColor = j21;
        this.errorLeadingIconColor = j22;
        this.trailingIconColor = j23;
        this.disabledTrailingIconColor = j24;
        this.errorTrailingIconColor = j25;
        this.backgroundColor = j26;
        this.focusedLabelColor = j27;
        this.unfocusedLabelColor = j28;
        this.disabledLabelColor = j29;
        this.errorLabelColor = j31;
        this.placeholderColor = j32;
        this.disabledPlaceholderColor = j33;
    }

    public /* synthetic */ DefaultTextFieldColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, j24, j25, j26, j27, j28, j29, j31, j32, j33);
    }

    /* renamed from: indicatorColor$lambda-0  reason: not valid java name */
    private static final boolean m1214indicatorColor$lambda0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* renamed from: labelColor$lambda-1  reason: not valid java name */
    private static final boolean m1215labelColor$lambda1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    @NotNull
    @Composable
    public State<Color> backgroundColor(boolean z11, @Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1423938813);
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(this.backgroundColor), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public State<Color> cursorColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-1446422485);
        if (z11) {
            j11 = this.errorCursorColor;
        } else {
            j11 = this.cursorColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(DefaultTextFieldColors.class), (Object) Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        DefaultTextFieldColors defaultTextFieldColors = (DefaultTextFieldColors) obj;
        if (Color.m2920equalsimpl0(this.textColor, defaultTextFieldColors.textColor) && Color.m2920equalsimpl0(this.disabledTextColor, defaultTextFieldColors.disabledTextColor) && Color.m2920equalsimpl0(this.cursorColor, defaultTextFieldColors.cursorColor) && Color.m2920equalsimpl0(this.errorCursorColor, defaultTextFieldColors.errorCursorColor) && Color.m2920equalsimpl0(this.focusedIndicatorColor, defaultTextFieldColors.focusedIndicatorColor) && Color.m2920equalsimpl0(this.unfocusedIndicatorColor, defaultTextFieldColors.unfocusedIndicatorColor) && Color.m2920equalsimpl0(this.errorIndicatorColor, defaultTextFieldColors.errorIndicatorColor) && Color.m2920equalsimpl0(this.disabledIndicatorColor, defaultTextFieldColors.disabledIndicatorColor) && Color.m2920equalsimpl0(this.leadingIconColor, defaultTextFieldColors.leadingIconColor) && Color.m2920equalsimpl0(this.disabledLeadingIconColor, defaultTextFieldColors.disabledLeadingIconColor) && Color.m2920equalsimpl0(this.errorLeadingIconColor, defaultTextFieldColors.errorLeadingIconColor) && Color.m2920equalsimpl0(this.trailingIconColor, defaultTextFieldColors.trailingIconColor) && Color.m2920equalsimpl0(this.disabledTrailingIconColor, defaultTextFieldColors.disabledTrailingIconColor) && Color.m2920equalsimpl0(this.errorTrailingIconColor, defaultTextFieldColors.errorTrailingIconColor) && Color.m2920equalsimpl0(this.backgroundColor, defaultTextFieldColors.backgroundColor) && Color.m2920equalsimpl0(this.focusedLabelColor, defaultTextFieldColors.focusedLabelColor) && Color.m2920equalsimpl0(this.unfocusedLabelColor, defaultTextFieldColors.unfocusedLabelColor) && Color.m2920equalsimpl0(this.disabledLabelColor, defaultTextFieldColors.disabledLabelColor) && Color.m2920equalsimpl0(this.errorLabelColor, defaultTextFieldColors.errorLabelColor) && Color.m2920equalsimpl0(this.placeholderColor, defaultTextFieldColors.placeholderColor) && Color.m2920equalsimpl0(this.disabledPlaceholderColor, defaultTextFieldColors.disabledPlaceholderColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((Color.m2926hashCodeimpl(this.textColor) * 31) + Color.m2926hashCodeimpl(this.disabledTextColor)) * 31) + Color.m2926hashCodeimpl(this.cursorColor)) * 31) + Color.m2926hashCodeimpl(this.errorCursorColor)) * 31) + Color.m2926hashCodeimpl(this.focusedIndicatorColor)) * 31) + Color.m2926hashCodeimpl(this.unfocusedIndicatorColor)) * 31) + Color.m2926hashCodeimpl(this.errorIndicatorColor)) * 31) + Color.m2926hashCodeimpl(this.disabledIndicatorColor)) * 31) + Color.m2926hashCodeimpl(this.leadingIconColor)) * 31) + Color.m2926hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m2926hashCodeimpl(this.errorLeadingIconColor)) * 31) + Color.m2926hashCodeimpl(this.trailingIconColor)) * 31) + Color.m2926hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m2926hashCodeimpl(this.errorTrailingIconColor)) * 31) + Color.m2926hashCodeimpl(this.backgroundColor)) * 31) + Color.m2926hashCodeimpl(this.focusedLabelColor)) * 31) + Color.m2926hashCodeimpl(this.unfocusedLabelColor)) * 31) + Color.m2926hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m2926hashCodeimpl(this.errorLabelColor)) * 31) + Color.m2926hashCodeimpl(this.placeholderColor)) * 31) + Color.m2926hashCodeimpl(this.disabledPlaceholderColor);
    }

    @NotNull
    @Composable
    public State<Color> indicatorColor(boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        long j11;
        State<Color> state;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(998675979);
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i11 >> 6) & 14);
        if (!z11) {
            j11 = this.disabledIndicatorColor;
        } else if (z12) {
            j11 = this.errorIndicatorColor;
        } else if (m1214indicatorColor$lambda0(collectIsFocusedAsState)) {
            j11 = this.focusedIndicatorColor;
        } else {
            j11 = this.unfocusedIndicatorColor;
        }
        long j12 = j11;
        if (z11) {
            composer.startReplaceableGroup(-2054190426);
            state = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j12, AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (Function1<? super Color, Unit>) null, composer, 48, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-2054190321);
            state = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j12), composer, 0);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return state;
    }

    @NotNull
    @Composable
    public State<Color> labelColor(boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        long j11;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(727091888);
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i11 >> 6) & 14);
        if (!z11) {
            j11 = this.disabledLabelColor;
        } else if (z12) {
            j11 = this.errorLabelColor;
        } else if (m1215labelColor$lambda1(collectIsFocusedAsState)) {
            j11 = this.focusedLabelColor;
        } else {
            j11 = this.unfocusedLabelColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public State<Color> leadingIconColor(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(1016171324);
        if (!z11) {
            j11 = this.disabledLeadingIconColor;
        } else if (z12) {
            j11 = this.errorLeadingIconColor;
        } else {
            j11 = this.leadingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public State<Color> placeholderColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(264799724);
        if (z11) {
            j11 = this.placeholderColor;
        } else {
            j11 = this.disabledPlaceholderColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public State<Color> textColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(9804418);
        if (z11) {
            j11 = this.textColor;
        } else {
            j11 = this.disabledTextColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public State<Color> trailingIconColor(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(225259054);
        if (!z11) {
            j11 = this.disabledTrailingIconColor;
        } else if (z12) {
            j11 = this.errorTrailingIconColor;
        } else {
            j11 = this.trailingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
