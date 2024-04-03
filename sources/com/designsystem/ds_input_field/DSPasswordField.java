package com.designsystem.ds_input_field;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.text.input.ImeAction;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u00104\u001a\u00020\u001eH\u0017¢\u0006\u0002\u00105R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR4\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRG\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8F@FX\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RG\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8F@FX\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0011\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R+\u0010*\u001a\u00020)2\u0006\u0010\t\u001a\u00020)8F@FX\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0011\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R+\u00100\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b3\u0010\u0011\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Lcom/designsystem/ds_input_field/DSPasswordField;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "helperText", "getHelperText", "()Ljava/lang/String;", "setHelperText", "(Ljava/lang/String;)V", "helperText$delegate", "Landroidx/compose/runtime/MutableState;", "hint", "getHint", "setHint", "hint$delegate", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "getImeAction-eUduSuo", "()I", "setImeAction-KlQnJC8", "(I)V", "imeAction$delegate", "Lkotlin/Function1;", "", "onKeyboardReturnButtonTap", "getOnKeyboardReturnButtonTap", "()Lkotlin/jvm/functions/Function1;", "setOnKeyboardReturnButtonTap", "(Lkotlin/jvm/functions/Function1;)V", "onKeyboardReturnButtonTap$delegate", "onTextChange", "getOnTextChange", "setOnTextChange", "onTextChange$delegate", "Lcom/designsystem/ds_input_field/DSInputFieldState;", "state", "getState", "()Lcom/designsystem/ds_input_field/DSInputFieldState;", "setState", "(Lcom/designsystem/ds_input_field/DSInputFieldState;)V", "state$delegate", "text", "getText", "setText", "text$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSPasswordField extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState helperText$delegate;
    @NotNull
    private final MutableState hint$delegate;
    @NotNull
    private final MutableState imeAction$delegate;
    @NotNull
    private final MutableState onKeyboardReturnButtonTap$delegate;
    @NotNull
    private final MutableState onTextChange$delegate;
    @NotNull
    private final MutableState state$delegate;
    @NotNull
    private final MutableState text$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPasswordField(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPasswordField(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSPasswordField(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1593863455);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            Modifier.Companion companion = Modifier.Companion;
            String text = getText();
            String hint = getHint();
            String helperText = getHelperText();
            startRestartGroup.startReplaceableGroup(-3686930);
            boolean changed = startRestartGroup.changed((Object) this);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DSPasswordField$Content$1$1(this);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            DSPasswordFieldKt.m8376DSPasswordFieldt0ssOgc(companion, text, hint, helperText, (Function1) rememberedValue, getOnKeyboardReturnButtonTap(), getState(), m8374getImeActioneUduSuo(), startRestartGroup, 16777222, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSPasswordField$Content$2(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final String getHelperText() {
        return (String) this.helperText$delegate.getValue();
    }

    @Nullable
    public final String getHint() {
        return (String) this.hint$delegate.getValue();
    }

    /* renamed from: getImeAction-eUduSuo  reason: not valid java name */
    public final int m8374getImeActioneUduSuo() {
        return ((ImeAction) this.imeAction$delegate.getValue()).m5186unboximpl();
    }

    @Nullable
    public final Function1<String, Unit> getOnKeyboardReturnButtonTap() {
        return (Function1) this.onKeyboardReturnButtonTap$delegate.getValue();
    }

    @Nullable
    public final Function1<String, Unit> getOnTextChange() {
        return (Function1) this.onTextChange$delegate.getValue();
    }

    @NotNull
    public final DSInputFieldState getState() {
        return (DSInputFieldState) this.state$delegate.getValue();
    }

    @NotNull
    public final String getText() {
        return (String) this.text$delegate.getValue();
    }

    public final void setHelperText(@Nullable String str) {
        this.helperText$delegate.setValue(str);
    }

    public final void setHint(@Nullable String str) {
        this.hint$delegate.setValue(str);
    }

    /* renamed from: setImeAction-KlQnJC8  reason: not valid java name */
    public final void m8375setImeActionKlQnJC8(int i11) {
        this.imeAction$delegate.setValue(ImeAction.m5180boximpl(i11));
    }

    public final void setOnKeyboardReturnButtonTap(@Nullable Function1<? super String, Unit> function1) {
        this.onKeyboardReturnButtonTap$delegate.setValue(function1);
    }

    public final void setOnTextChange(@Nullable Function1<? super String, Unit> function1) {
        this.onTextChange$delegate.setValue(function1);
    }

    public final void setState(@NotNull DSInputFieldState dSInputFieldState) {
        Intrinsics.checkNotNullParameter(dSInputFieldState, "<set-?>");
        this.state$delegate.setValue(dSInputFieldState);
    }

    public final void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text$delegate.setValue(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPasswordField(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "";
        this.text$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.hint$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.helperText$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onTextChange$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onKeyboardReturnButtonTap$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        DSInputFieldState dSInputFieldState = DSInputFieldState.Normal;
        this.state$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(dSInputFieldState, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.imeAction$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ImeAction.m5180boximpl(ImeAction.Companion.m5188getDoneeUduSuo()), (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSPasswordField, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…le.DSPasswordField, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSPasswordField_pf_text);
            setText(string != null ? string : str);
            setHint(obtainStyledAttributes.getString(R.styleable.DSPasswordField_pf_hint));
            setHelperText(obtainStyledAttributes.getString(R.styleable.DSPasswordField_pf_helperText));
            int i12 = obtainStyledAttributes.getInt(R.styleable.DSPasswordField_pf_state, -1);
            setState(i12 >= 0 ? DSInputFieldState.values()[i12] : dSInputFieldState);
            obtainStyledAttributes.recycle();
        }
    }
}
