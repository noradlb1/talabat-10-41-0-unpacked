package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001Bê\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010 J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u0010(\u001a\u00020)H\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010.\u001a\u00020/H\u0016J0\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J0\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00105J0\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b9\u00105J \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)H\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010+J0\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b<\u00105J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)H\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010+J0\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b?\u00105R\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0018\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0010\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001e\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0014\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0019\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0011\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0015\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0016\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001c\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001a\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010\"\u001a\u00020\t8AX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0017\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001d\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0013\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/material3/TextFieldColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "textSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "errorIndicatorColor", "disabledIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "selectionColors", "getSelectionColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "Landroidx/compose/runtime/State;", "containerColor$material3_release", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "isError", "", "cursorColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "indicatorColor", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "indicatorColor$material3_release", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "labelColor", "labelColor$material3_release", "leadingIconColor", "leadingIconColor$material3_release", "placeholderColor$material3_release", "supportingTextColor", "supportingTextColor$material3_release", "textColor$material3_release", "trailingIconColor", "trailingIconColor$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextFieldColors {
    private final long containerColor;
    private final long cursorColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorSupportingTextColor;
    private final long errorTrailingIconColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedSupportingTextColor;
    private final long focusedTrailingIconColor;
    private final long placeholderColor;
    private final long textColor;
    @NotNull
    private final TextSelectionColors textSelectionColors;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTrailingIconColor;

    private TextFieldColors(long j11, long j12, long j13, long j14, long j15, TextSelectionColors textSelectionColors2, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39) {
        this.textColor = j11;
        this.disabledTextColor = j12;
        this.containerColor = j13;
        this.cursorColor = j14;
        this.errorCursorColor = j15;
        this.textSelectionColors = textSelectionColors2;
        this.focusedIndicatorColor = j16;
        this.unfocusedIndicatorColor = j17;
        this.errorIndicatorColor = j18;
        this.disabledIndicatorColor = j19;
        this.focusedLeadingIconColor = j21;
        this.unfocusedLeadingIconColor = j22;
        this.disabledLeadingIconColor = j23;
        this.errorLeadingIconColor = j24;
        this.focusedTrailingIconColor = j25;
        this.unfocusedTrailingIconColor = j26;
        this.disabledTrailingIconColor = j27;
        this.errorTrailingIconColor = j28;
        this.focusedLabelColor = j29;
        this.unfocusedLabelColor = j31;
        this.disabledLabelColor = j32;
        this.errorLabelColor = j33;
        this.placeholderColor = j34;
        this.disabledPlaceholderColor = j35;
        this.focusedSupportingTextColor = j36;
        this.unfocusedSupportingTextColor = j37;
        this.disabledSupportingTextColor = j38;
        this.errorSupportingTextColor = j39;
    }

    public /* synthetic */ TextFieldColors(long j11, long j12, long j13, long j14, long j15, TextSelectionColors textSelectionColors2, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, textSelectionColors2, j16, j17, j18, j19, j21, j22, j23, j24, j25, j26, j27, j28, j29, j31, j32, j33, j34, j35, j36, j37, j38, j39);
    }

    /* renamed from: indicatorColor$lambda-2  reason: not valid java name */
    private static final boolean m1898indicatorColor$lambda2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* renamed from: labelColor$lambda-3  reason: not valid java name */
    private static final boolean m1899labelColor$lambda3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* renamed from: leadingIconColor$lambda-0  reason: not valid java name */
    private static final boolean m1900leadingIconColor$lambda0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* renamed from: supportingTextColor$lambda-4  reason: not valid java name */
    private static final boolean m1901supportingTextColor$lambda4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* renamed from: trailingIconColor$lambda-1  reason: not valid java name */
    private static final boolean m1902trailingIconColor$lambda1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    @NotNull
    @Composable
    public final State<Color> containerColor$material3_release(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(954653884);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(954653884, i11, -1, "androidx.compose.material3.TextFieldColors.containerColor (TextFieldDefaults.kt:794)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(this.containerColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> cursorColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-1885422187);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1885422187, i11, -1, "androidx.compose.material3.TextFieldColors.cursorColor (TextFieldDefaults.kt:862)");
        }
        if (z11) {
            j11 = this.errorCursorColor;
        } else {
            j11 = this.cursorColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TextFieldColors)) {
            return false;
        }
        TextFieldColors textFieldColors = (TextFieldColors) obj;
        if (Color.m2920equalsimpl0(this.textColor, textFieldColors.textColor) && Color.m2920equalsimpl0(this.disabledTextColor, textFieldColors.disabledTextColor) && Color.m2920equalsimpl0(this.cursorColor, textFieldColors.cursorColor) && Color.m2920equalsimpl0(this.errorCursorColor, textFieldColors.errorCursorColor) && Intrinsics.areEqual((Object) this.textSelectionColors, (Object) textFieldColors.textSelectionColors) && Color.m2920equalsimpl0(this.focusedIndicatorColor, textFieldColors.focusedIndicatorColor) && Color.m2920equalsimpl0(this.unfocusedIndicatorColor, textFieldColors.unfocusedIndicatorColor) && Color.m2920equalsimpl0(this.errorIndicatorColor, textFieldColors.errorIndicatorColor) && Color.m2920equalsimpl0(this.disabledIndicatorColor, textFieldColors.disabledIndicatorColor) && Color.m2920equalsimpl0(this.focusedLeadingIconColor, textFieldColors.focusedLeadingIconColor) && Color.m2920equalsimpl0(this.unfocusedLeadingIconColor, textFieldColors.unfocusedLeadingIconColor) && Color.m2920equalsimpl0(this.disabledLeadingIconColor, textFieldColors.disabledLeadingIconColor) && Color.m2920equalsimpl0(this.errorLeadingIconColor, textFieldColors.errorLeadingIconColor) && Color.m2920equalsimpl0(this.focusedTrailingIconColor, textFieldColors.focusedTrailingIconColor) && Color.m2920equalsimpl0(this.unfocusedTrailingIconColor, textFieldColors.unfocusedTrailingIconColor) && Color.m2920equalsimpl0(this.disabledTrailingIconColor, textFieldColors.disabledTrailingIconColor) && Color.m2920equalsimpl0(this.errorTrailingIconColor, textFieldColors.errorTrailingIconColor) && Color.m2920equalsimpl0(this.containerColor, textFieldColors.containerColor) && Color.m2920equalsimpl0(this.focusedLabelColor, textFieldColors.focusedLabelColor) && Color.m2920equalsimpl0(this.unfocusedLabelColor, textFieldColors.unfocusedLabelColor) && Color.m2920equalsimpl0(this.disabledLabelColor, textFieldColors.disabledLabelColor) && Color.m2920equalsimpl0(this.errorLabelColor, textFieldColors.errorLabelColor) && Color.m2920equalsimpl0(this.placeholderColor, textFieldColors.placeholderColor) && Color.m2920equalsimpl0(this.disabledPlaceholderColor, textFieldColors.disabledPlaceholderColor) && Color.m2920equalsimpl0(this.focusedSupportingTextColor, textFieldColors.focusedSupportingTextColor) && Color.m2920equalsimpl0(this.unfocusedSupportingTextColor, textFieldColors.unfocusedSupportingTextColor) && Color.m2920equalsimpl0(this.disabledSupportingTextColor, textFieldColors.disabledSupportingTextColor) && Color.m2920equalsimpl0(this.errorSupportingTextColor, textFieldColors.errorSupportingTextColor)) {
            return true;
        }
        return false;
    }

    @NotNull
    @Composable
    @JvmName(name = "getSelectionColors")
    public final TextSelectionColors getSelectionColors(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(997785083);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(997785083, i11, -1, "androidx.compose.material3.TextFieldColors.<get-selectionColors> (TextFieldDefaults.kt:870)");
        }
        TextSelectionColors textSelectionColors2 = this.textSelectionColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSelectionColors2;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((Color.m2926hashCodeimpl(this.textColor) * 31) + Color.m2926hashCodeimpl(this.disabledTextColor)) * 31) + Color.m2926hashCodeimpl(this.cursorColor)) * 31) + Color.m2926hashCodeimpl(this.errorCursorColor)) * 31) + this.textSelectionColors.hashCode()) * 31) + Color.m2926hashCodeimpl(this.focusedIndicatorColor)) * 31) + Color.m2926hashCodeimpl(this.unfocusedIndicatorColor)) * 31) + Color.m2926hashCodeimpl(this.errorIndicatorColor)) * 31) + Color.m2926hashCodeimpl(this.disabledIndicatorColor)) * 31) + Color.m2926hashCodeimpl(this.focusedLeadingIconColor)) * 31) + Color.m2926hashCodeimpl(this.unfocusedLeadingIconColor)) * 31) + Color.m2926hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m2926hashCodeimpl(this.errorLeadingIconColor)) * 31) + Color.m2926hashCodeimpl(this.focusedTrailingIconColor)) * 31) + Color.m2926hashCodeimpl(this.unfocusedTrailingIconColor)) * 31) + Color.m2926hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m2926hashCodeimpl(this.errorTrailingIconColor)) * 31) + Color.m2926hashCodeimpl(this.containerColor)) * 31) + Color.m2926hashCodeimpl(this.focusedLabelColor)) * 31) + Color.m2926hashCodeimpl(this.unfocusedLabelColor)) * 31) + Color.m2926hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m2926hashCodeimpl(this.errorLabelColor)) * 31) + Color.m2926hashCodeimpl(this.placeholderColor)) * 31) + Color.m2926hashCodeimpl(this.disabledPlaceholderColor)) * 31) + Color.m2926hashCodeimpl(this.focusedSupportingTextColor)) * 31) + Color.m2926hashCodeimpl(this.unfocusedSupportingTextColor)) * 31) + Color.m2926hashCodeimpl(this.disabledSupportingTextColor)) * 31) + Color.m2926hashCodeimpl(this.errorSupportingTextColor);
    }

    @NotNull
    @Composable
    public final State<Color> indicatorColor$material3_release(boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        long j11;
        State<Color> state;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(-1877482635);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877482635, i11, -1, "androidx.compose.material3.TextFieldColors.indicatorColor (TextFieldDefaults.kt:770)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i11 >> 6) & 14);
        if (!z11) {
            j11 = this.disabledIndicatorColor;
        } else if (z12) {
            j11 = this.errorIndicatorColor;
        } else if (m1898indicatorColor$lambda2(collectIsFocusedAsState)) {
            j11 = this.focusedIndicatorColor;
        } else {
            j11 = this.unfocusedIndicatorColor;
        }
        long j12 = j11;
        if (z11) {
            composer.startReplaceableGroup(715730990);
            state = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j12, AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (Function1<? super Color, Unit>) null, composer, 48, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(715731095);
            state = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j12), composer, 0);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return state;
    }

    @NotNull
    @Composable
    public final State<Color> labelColor$material3_release(boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        long j11;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(1167161306);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1167161306, i11, -1, "androidx.compose.material3.TextFieldColors.labelColor (TextFieldDefaults.kt:817)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i11 >> 6) & 14);
        if (!z11) {
            j11 = this.disabledLabelColor;
        } else if (z12) {
            j11 = this.errorLabelColor;
        } else if (m1899labelColor$lambda3(collectIsFocusedAsState)) {
            j11 = this.focusedLabelColor;
        } else {
            j11 = this.unfocusedLabelColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> leadingIconColor$material3_release(boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        long j11;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(925127045);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(925127045, i11, -1, "androidx.compose.material3.TextFieldColors.leadingIconColor (TextFieldDefaults.kt:718)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i11 >> 6) & 14);
        if (!z11) {
            j11 = this.disabledLeadingIconColor;
        } else if (z12) {
            j11 = this.errorLeadingIconColor;
        } else if (m1900leadingIconColor$lambda0(collectIsFocusedAsState)) {
            j11 = this.focusedLeadingIconColor;
        } else {
            j11 = this.unfocusedLeadingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> placeholderColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-117469162);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-117469162, i11, -1, "androidx.compose.material3.TextFieldColors.placeholderColor (TextFieldDefaults.kt:804)");
        }
        if (z11) {
            j11 = this.placeholderColor;
        } else {
            j11 = this.disabledPlaceholderColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> supportingTextColor$material3_release(boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        long j11;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(1464709698);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1464709698, i11, -1, "androidx.compose.material3.TextFieldColors.supportingTextColor (TextFieldDefaults.kt:839)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i11 >> 6) & 14);
        if (!z11) {
            j11 = this.disabledSupportingTextColor;
        } else if (z12) {
            j11 = this.errorSupportingTextColor;
        } else if (m1901supportingTextColor$lambda4(collectIsFocusedAsState)) {
            j11 = this.focusedSupportingTextColor;
        } else {
            j11 = this.unfocusedSupportingTextColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> textColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(2080722220);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2080722220, i11, -1, "androidx.compose.material3.TextFieldColors.textColor (TextFieldDefaults.kt:834)");
        }
        if (z11) {
            j11 = this.textColor;
        } else {
            j11 = this.disabledTextColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> trailingIconColor$material3_release(boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i11) {
        long j11;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(-109504137);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-109504137, i11, -1, "androidx.compose.material3.TextFieldColors.trailingIconColor (TextFieldDefaults.kt:744)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i11 >> 6) & 14);
        if (!z11) {
            j11 = this.disabledTrailingIconColor;
        } else if (z12) {
            j11 = this.errorTrailingIconColor;
        } else if (m1902trailingIconColor$lambda1(collectIsFocusedAsState)) {
            j11 = this.focusedTrailingIconColor;
        } else {
            j11 = this.unfocusedTrailingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
