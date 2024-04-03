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
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_input_field.country.DSCountryModel;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010L\u001a\u00020K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010P\u001a\u00020O¢\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000f\u0010\u0006\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0006\u0010\u0007R/\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fRW\u0010\u001c\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u001c\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRW\u0010 \u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u001c\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158F@FX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR/\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0002¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR+\u0010+\u001a\u00020%2\u0006\u0010\t\u001a\u00020%8F@FX\u0002¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R+\u0010-\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00028D@DX\u0002¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R4\u00107\u001a\u0002012\u0006\u0010\t\u001a\u0002018F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u00104\"\u0004\b5\u00106R/\u0010;\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0002¢\u0006\u0012\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR/\u0010?\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0002¢\u0006\u0012\n\u0004\b<\u0010\u000b\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000fR/\u0010C\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0002¢\u0006\u0012\n\u0004\b@\u0010\u000b\u001a\u0004\bA\u0010\r\"\u0004\bB\u0010\u000fR$\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Lcom/designsystem/ds_input_field/DSPhoneNumberField;", "Landroidx/compose/ui/platform/AbstractComposeView;", "", "enabled", "", "setEnabled", "Content", "(Landroidx/compose/runtime/Composer;I)V", "", "<set-?>", "text$delegate", "Landroidx/compose/runtime/MutableState;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "text", "hint$delegate", "getHint", "setHint", "hint", "Lkotlin/Function2;", "Lcom/designsystem/ds_input_field/country/DSCountryModel;", "onTextChange$delegate", "getOnTextChange", "()Lkotlin/jvm/functions/Function2;", "setOnTextChange", "(Lkotlin/jvm/functions/Function2;)V", "onTextChange", "onKeyboardReturnButtonTap$delegate", "getOnKeyboardReturnButtonTap", "setOnKeyboardReturnButtonTap", "onKeyboardReturnButtonTap", "defaultCountryCode$delegate", "getDefaultCountryCode", "setDefaultCountryCode", "defaultCountryCode", "Lcom/designsystem/ds_input_field/DSInputFieldState;", "state$delegate", "getState", "()Lcom/designsystem/ds_input_field/DSInputFieldState;", "setState", "(Lcom/designsystem/ds_input_field/DSInputFieldState;)V", "state", "isTextFieldEnabled$delegate", "isTextFieldEnabled", "()Z", "setTextFieldEnabled", "(Z)V", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction$delegate", "getImeAction-eUduSuo", "()I", "setImeAction-KlQnJC8", "(I)V", "imeAction", "prefixSearchHint$delegate", "getPrefixSearchHint", "setPrefixSearchHint", "prefixSearchHint", "prefixSearchEmptyStateTitle$delegate", "getPrefixSearchEmptyStateTitle", "setPrefixSearchEmptyStateTitle", "prefixSearchEmptyStateTitle", "prefixSearchEmptyStateDetails$delegate", "getPrefixSearchEmptyStateDetails", "setPrefixSearchEmptyStateDetails", "prefixSearchEmptyStateDetails", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1})
public final class DSPhoneNumberField extends AbstractComposeView {
    public static final int $stable = 8;
    @NotNull
    private final MutableState defaultCountryCode$delegate;
    @Nullable
    private FragmentManager fragmentManager;
    @NotNull
    private final MutableState hint$delegate;
    @NotNull
    private final MutableState imeAction$delegate;
    @NotNull
    private final MutableState isTextFieldEnabled$delegate;
    @NotNull
    private final MutableState onKeyboardReturnButtonTap$delegate;
    @NotNull
    private final MutableState onTextChange$delegate;
    @NotNull
    private final MutableState prefixSearchEmptyStateDetails$delegate;
    @NotNull
    private final MutableState prefixSearchEmptyStateTitle$delegate;
    @NotNull
    private final MutableState prefixSearchHint$delegate;
    @NotNull
    private final MutableState state$delegate;
    @NotNull
    private final MutableState text$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPhoneNumberField(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPhoneNumberField(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSPhoneNumberField(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(886501384);
        Modifier.Companion companion = Modifier.Companion;
        String text = getText();
        String hint = getHint();
        DSPhoneNumberField$Content$1 dSPhoneNumberField$Content$1 = new DSPhoneNumberField$Content$1(this);
        Function2<DSCountryModel, String, Unit> onKeyboardReturnButtonTap = getOnKeyboardReturnButtonTap();
        String defaultCountryCode = getDefaultCountryCode();
        boolean isEnabled = isEnabled();
        DSInputFieldState state = getState();
        int r102 = m8377getImeActioneUduSuo();
        FragmentManager fragmentManager2 = this.fragmentManager;
        if (fragmentManager2 != null) {
            String prefixSearchHint = getPrefixSearchHint();
            if (prefixSearchHint == null) {
                prefixSearchHint = "";
            }
            String prefixSearchEmptyStateTitle = getPrefixSearchEmptyStateTitle();
            if (prefixSearchEmptyStateTitle == null) {
                prefixSearchEmptyStateTitle = "";
            }
            String prefixSearchEmptyStateDetails = getPrefixSearchEmptyStateDetails();
            if (prefixSearchEmptyStateDetails == null) {
                prefixSearchEmptyStateDetails = "";
            }
            DSPhoneNumberFieldKt.m8379DSPhoneNumberFieldMmlCLH8(companion, text, hint, dSPhoneNumberField$Content$1, onKeyboardReturnButtonTap, defaultCountryCode, isEnabled, state, r102, fragmentManager2, prefixSearchHint, prefixSearchEmptyStateTitle, prefixSearchEmptyStateDetails, startRestartGroup, 1207959558, 0, 0);
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new DSPhoneNumberField$Content$3(this, i11));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FragmentManager is required and cannot be null!".toString());
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final String getDefaultCountryCode() {
        return (String) this.defaultCountryCode$delegate.getValue();
    }

    @Nullable
    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    @Nullable
    public final String getHint() {
        return (String) this.hint$delegate.getValue();
    }

    /* renamed from: getImeAction-eUduSuo  reason: not valid java name */
    public final int m8377getImeActioneUduSuo() {
        return ((ImeAction) this.imeAction$delegate.getValue()).m5186unboximpl();
    }

    @Nullable
    public final Function2<DSCountryModel, String, Unit> getOnKeyboardReturnButtonTap() {
        return (Function2) this.onKeyboardReturnButtonTap$delegate.getValue();
    }

    @Nullable
    public final Function2<DSCountryModel, String, Unit> getOnTextChange() {
        return (Function2) this.onTextChange$delegate.getValue();
    }

    @Nullable
    public final String getPrefixSearchEmptyStateDetails() {
        return (String) this.prefixSearchEmptyStateDetails$delegate.getValue();
    }

    @Nullable
    public final String getPrefixSearchEmptyStateTitle() {
        return (String) this.prefixSearchEmptyStateTitle$delegate.getValue();
    }

    @Nullable
    public final String getPrefixSearchHint() {
        return (String) this.prefixSearchHint$delegate.getValue();
    }

    @NotNull
    public final DSInputFieldState getState() {
        return (DSInputFieldState) this.state$delegate.getValue();
    }

    @Nullable
    public final String getText() {
        return (String) this.text$delegate.getValue();
    }

    public final void setDefaultCountryCode(@Nullable String str) {
        this.defaultCountryCode$delegate.setValue(str);
    }

    public void setEnabled(boolean z11) {
        setTextFieldEnabled(z11);
        super.setEnabled(z11);
    }

    public final void setFragmentManager(@Nullable FragmentManager fragmentManager2) {
        this.fragmentManager = fragmentManager2;
    }

    public final void setHint(@Nullable String str) {
        this.hint$delegate.setValue(str);
    }

    /* renamed from: setImeAction-KlQnJC8  reason: not valid java name */
    public final void m8378setImeActionKlQnJC8(int i11) {
        this.imeAction$delegate.setValue(ImeAction.m5180boximpl(i11));
    }

    public final void setOnKeyboardReturnButtonTap(@Nullable Function2<? super DSCountryModel, ? super String, Unit> function2) {
        this.onKeyboardReturnButtonTap$delegate.setValue(function2);
    }

    public final void setOnTextChange(@Nullable Function2<? super DSCountryModel, ? super String, Unit> function2) {
        this.onTextChange$delegate.setValue(function2);
    }

    public final void setPrefixSearchEmptyStateDetails(@Nullable String str) {
        this.prefixSearchEmptyStateDetails$delegate.setValue(str);
    }

    public final void setPrefixSearchEmptyStateTitle(@Nullable String str) {
        this.prefixSearchEmptyStateTitle$delegate.setValue(str);
    }

    public final void setPrefixSearchHint(@Nullable String str) {
        this.prefixSearchHint$delegate.setValue(str);
    }

    public final void setState(@NotNull DSInputFieldState dSInputFieldState) {
        Intrinsics.checkNotNullParameter(dSInputFieldState, "<set-?>");
        this.state$delegate.setValue(dSInputFieldState);
    }

    public final void setText(@Nullable String str) {
        this.text$delegate.setValue(str);
    }

    public final void setTextFieldEnabled(boolean z11) {
        this.isTextFieldEnabled$delegate.setValue(Boolean.valueOf(z11));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPhoneNumberField(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.text$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.hint$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onTextChange$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onKeyboardReturnButtonTap$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.defaultCountryCode$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        DSInputFieldState dSInputFieldState = DSInputFieldState.Normal;
        this.state$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(dSInputFieldState, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isTextFieldEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.imeAction$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ImeAction.m5180boximpl(ImeAction.Companion.m5188getDoneeUduSuo()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.prefixSearchHint$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.prefixSearchEmptyStateTitle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.prefixSearchEmptyStateDetails$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSPhoneNumberField, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…DSPhoneNumberField, 0, 0)");
            setText(obtainStyledAttributes.getString(R.styleable.DSPhoneNumberField_pnf_text));
            setHint(obtainStyledAttributes.getString(R.styleable.DSPhoneNumberField_pnf_hint));
            int i12 = obtainStyledAttributes.getInt(R.styleable.DSPhoneNumberField_pnf_state, -1);
            setState(i12 >= 0 ? DSInputFieldState.values()[i12] : dSInputFieldState);
            setEnabled(obtainStyledAttributes.getBoolean(R.styleable.DSPhoneNumberField_pnf_is_enabled, true));
            setPrefixSearchHint(obtainStyledAttributes.getString(R.styleable.DSPhoneNumberField_pnf_prefix_search_hint));
            setPrefixSearchEmptyStateTitle(obtainStyledAttributes.getString(R.styleable.DSPhoneNumberField_pnf_prefix_search_empty_state_title));
            setPrefixSearchEmptyStateDetails(obtainStyledAttributes.getString(R.styleable.DSPhoneNumberField_pnf_prefix_search_empty_state_details));
            setDefaultCountryCode(obtainStyledAttributes.getString(R.styleable.DSPhoneNumberField_pnf_default_country_code));
            obtainStyledAttributes.recycle();
        }
    }
}
