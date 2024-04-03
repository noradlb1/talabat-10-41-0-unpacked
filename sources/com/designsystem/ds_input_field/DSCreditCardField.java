package com.designsystem.ds_input_field;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.VisualTransformation;
import com.designsystem.extensions.TypedArrayExtensionsKt;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010K\u001a\u000205H\u0017¢\u0006\u0002\u0010LJ\u0010\u0010M\u001a\u0002052\u0006\u0010N\u001a\u00020$H\u0016R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R/\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R4\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001d8F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010%\u001a\u00020$2\u0006\u0010\t\u001a\u00020$8D@DX\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0011\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R+\u0010*\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0011\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R/\u0010.\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b3\u0010\u0011\u001a\u0004\b/\u00100\"\u0004\b1\u00102RG\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000205\u0018\u0001042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000205\u0018\u0001048F@FX\u0002¢\u0006\u0012\n\u0004\b;\u0010\u0011\u001a\u0004\b7\u00108\"\u0004\b9\u0010:RG\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000205\u0018\u0001042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000205\u0018\u0001048F@FX\u0002¢\u0006\u0012\n\u0004\b?\u0010\u0011\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R+\u0010A\u001a\u00020@2\u0006\u0010\t\u001a\u00020@8F@FX\u0002¢\u0006\u0012\n\u0004\bF\u0010\u0011\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER+\u0010G\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\bJ\u0010\u0011\u001a\u0004\bH\u0010\u0015\"\u0004\bI\u0010\u0017\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006O"}, d2 = {"Lcom/designsystem/ds_input_field/DSCreditCardField;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Landroidx/compose/ui/text/input/VisualTransformation;", "formatter", "getFormatter", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setFormatter", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "formatter$delegate", "Landroidx/compose/runtime/MutableState;", "", "helperText", "getHelperText", "()Ljava/lang/String;", "setHelperText", "(Ljava/lang/String;)V", "helperText$delegate", "hint", "getHint", "setHint", "hint$delegate", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "getImeAction-eUduSuo", "()I", "setImeAction-KlQnJC8", "(I)V", "imeAction$delegate", "", "isTextFieldEnabled", "()Z", "setTextFieldEnabled", "(Z)V", "isTextFieldEnabled$delegate", "leadingIcon", "getLeadingIcon", "setLeadingIcon", "leadingIcon$delegate", "maxNumberOfCharacters", "getMaxNumberOfCharacters", "()Ljava/lang/Integer;", "setMaxNumberOfCharacters", "(Ljava/lang/Integer;)V", "maxNumberOfCharacters$delegate", "Lkotlin/Function1;", "", "onKeyboardReturnButtonTap", "getOnKeyboardReturnButtonTap", "()Lkotlin/jvm/functions/Function1;", "setOnKeyboardReturnButtonTap", "(Lkotlin/jvm/functions/Function1;)V", "onKeyboardReturnButtonTap$delegate", "onTextChange", "getOnTextChange", "setOnTextChange", "onTextChange$delegate", "Lcom/designsystem/ds_input_field/DSInputFieldState;", "state", "getState", "()Lcom/designsystem/ds_input_field/DSInputFieldState;", "setState", "(Lcom/designsystem/ds_input_field/DSInputFieldState;)V", "state$delegate", "text", "getText", "setText", "text$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "setEnabled", "enabled", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSCreditCardField extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState formatter$delegate;
    @NotNull
    private final MutableState helperText$delegate;
    @NotNull
    private final MutableState hint$delegate;
    @NotNull
    private final MutableState imeAction$delegate;
    @NotNull
    private final MutableState isTextFieldEnabled$delegate;
    @NotNull
    private final MutableState leadingIcon$delegate;
    @NotNull
    private final MutableState maxNumberOfCharacters$delegate;
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
    public DSCreditCardField(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSCreditCardField(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSCreditCardField(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Content(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r20, int r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            r2 = 1541486140(0x5be1363c, float:1.26783002E17)
            r3 = r20
            androidx.compose.runtime.Composer r2 = r3.startRestartGroup(r2)
            r3 = r1 & 14
            r4 = 2
            if (r3 != 0) goto L_0x001d
            boolean r3 = r2.changed((java.lang.Object) r0)
            if (r3 == 0) goto L_0x001a
            r3 = 4
            goto L_0x001b
        L_0x001a:
            r3 = r4
        L_0x001b:
            r3 = r3 | r1
            goto L_0x001e
        L_0x001d:
            r3 = r1
        L_0x001e:
            r3 = r3 & 11
            r3 = r3 ^ r4
            if (r3 != 0) goto L_0x002e
            boolean r3 = r2.getSkipping()
            if (r3 != 0) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            r2.skipToGroupEnd()
            goto L_0x0089
        L_0x002e:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            java.lang.String r4 = r19.getText()
            java.lang.String r5 = r19.getHint()
            java.lang.String r6 = r19.getHelperText()
            r7 = -3686930(0xffffffffffc7bdee, float:NaN)
            r2.startReplaceableGroup(r7)
            boolean r7 = r2.changed((java.lang.Object) r0)
            java.lang.Object r8 = r2.rememberedValue()
            if (r7 != 0) goto L_0x0054
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x005c
        L_0x0054:
            com.designsystem.ds_input_field.DSCreditCardField$Content$1$1 r8 = new com.designsystem.ds_input_field.DSCreditCardField$Content$1$1
            r8.<init>(r0)
            r2.updateRememberedValue(r8)
        L_0x005c:
            r2.endReplaceableGroup()
            r7 = r8
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            kotlin.jvm.functions.Function1 r8 = r19.getOnKeyboardReturnButtonTap()
            boolean r9 = r19.isTextFieldEnabled()
            com.designsystem.ds_input_field.DSInputFieldState r10 = r19.getState()
            int r11 = r19.getLeadingIcon()
            int r12 = r19.m8369getImeActioneUduSuo()
            androidx.compose.ui.text.input.VisualTransformation r13 = r19.getFormatter()
            java.lang.Integer r14 = r19.getMaxNumberOfCharacters()
            r16 = 1073741830(0x40000006, float:2.0000014)
            r17 = 0
            r18 = 0
            r15 = r2
            com.designsystem.ds_input_field.DSCreditCardFieldKt.m8371DSCreditCardFieldk7ZECbw(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
        L_0x0089:
            androidx.compose.runtime.ScopeUpdateScope r2 = r2.endRestartGroup()
            if (r2 != 0) goto L_0x0090
            goto L_0x0098
        L_0x0090:
            com.designsystem.ds_input_field.DSCreditCardField$Content$2 r3 = new com.designsystem.ds_input_field.DSCreditCardField$Content$2
            r3.<init>(r0, r1)
            r2.updateScope(r3)
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.DSCreditCardField.Content(androidx.compose.runtime.Composer, int):void");
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final VisualTransformation getFormatter() {
        return (VisualTransformation) this.formatter$delegate.getValue();
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
    public final int m8369getImeActioneUduSuo() {
        return ((ImeAction) this.imeAction$delegate.getValue()).m5186unboximpl();
    }

    public final int getLeadingIcon() {
        return ((Number) this.leadingIcon$delegate.getValue()).intValue();
    }

    @Nullable
    public final Integer getMaxNumberOfCharacters() {
        return (Integer) this.maxNumberOfCharacters$delegate.getValue();
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

    public final boolean isTextFieldEnabled() {
        return ((Boolean) this.isTextFieldEnabled$delegate.getValue()).booleanValue();
    }

    public void setEnabled(boolean z11) {
        setTextFieldEnabled(z11);
        super.setEnabled(z11);
    }

    public final void setFormatter(@Nullable VisualTransformation visualTransformation) {
        this.formatter$delegate.setValue(visualTransformation);
    }

    public final void setHelperText(@Nullable String str) {
        this.helperText$delegate.setValue(str);
    }

    public final void setHint(@Nullable String str) {
        this.hint$delegate.setValue(str);
    }

    /* renamed from: setImeAction-KlQnJC8  reason: not valid java name */
    public final void m8370setImeActionKlQnJC8(int i11) {
        this.imeAction$delegate.setValue(ImeAction.m5180boximpl(i11));
    }

    public final void setLeadingIcon(int i11) {
        this.leadingIcon$delegate.setValue(Integer.valueOf(i11));
    }

    public final void setMaxNumberOfCharacters(@Nullable Integer num) {
        this.maxNumberOfCharacters$delegate.setValue(num);
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

    public final void setTextFieldEnabled(boolean z11) {
        this.isTextFieldEnabled$delegate.setValue(Boolean.valueOf(z11));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSCreditCardField(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
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
        int i12 = R.drawable.ds_credit_card;
        this.leadingIcon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i12), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isTextFieldEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.imeAction$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ImeAction.m5180boximpl(ImeAction.Companion.m5188getDoneeUduSuo()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.formatter$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.maxNumberOfCharacters$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSCreditCardField, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….DSCreditCardField, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSCreditCardField_ccf_text);
            setText(string != null ? string : str);
            setHint(obtainStyledAttributes.getString(R.styleable.DSCreditCardField_ccf_hint));
            setHelperText(obtainStyledAttributes.getString(R.styleable.DSCreditCardField_ccf_helperText));
            int i13 = obtainStyledAttributes.getInt(R.styleable.DSCreditCardField_ccf_state, -1);
            setState(i13 >= 0 ? DSInputFieldState.values()[i13] : dSInputFieldState);
            setEnabled(obtainStyledAttributes.getBoolean(R.styleable.DSCreditCardField_ccf_is_enabled, true));
            Integer resourceIdOrNull = TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSCreditCardField_ccf_leading_icon);
            setLeadingIcon(resourceIdOrNull != null ? resourceIdOrNull.intValue() : i12);
            setMaxNumberOfCharacters(TypedArrayExtensionsKt.getIntOrNull(obtainStyledAttributes, R.styleable.DSCreditCardField_ccf_max_number_of_characters));
            obtainStyledAttributes.recycle();
        }
    }
}
