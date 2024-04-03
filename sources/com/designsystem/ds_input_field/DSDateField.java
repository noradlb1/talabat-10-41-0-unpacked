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
import androidx.fragment.app.FragmentManager;
import com.designsystem.marshmallow.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010L\u001a\u00020>H\u0017¢\u0006\u0002\u0010MJ\u0010\u0010N\u001a\u00020>2\u0006\u0010O\u001a\u00020+H\u0016R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R/\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R/\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0011\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R/\u0010'\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R+\u0010,\u001a\u00020+2\u0006\u0010\t\u001a\u00020+8B@BX\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0011\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R/\u00101\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0011\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR;\u00107\u001a\n 6*\u0004\u0018\u000105052\u000e\u0010\t\u001a\n 6*\u0004\u0018\u000105058F@FX\u0002¢\u0006\u0012\n\u0004\b<\u0010\u0011\u001a\u0004\b8\u00109\"\u0004\b:\u0010;RG\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020>\u0018\u00010=8F@FX\u0002¢\u0006\u0012\n\u0004\bD\u0010\u0011\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR+\u0010F\u001a\u00020E2\u0006\u0010\t\u001a\u00020E8F@FX\u0002¢\u0006\u0012\n\u0004\bK\u0010\u0011\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006P"}, d2 = {"Lcom/designsystem/ds_input_field/DSDateField;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "date", "getDate", "()Ljava/lang/Long;", "setDate", "(Ljava/lang/Long;)V", "date$delegate", "Landroidx/compose/runtime/MutableState;", "", "dateFormat", "getDateFormat", "()Ljava/lang/String;", "setDateFormat", "(Ljava/lang/String;)V", "dateFormat$delegate", "firstDate", "getFirstDate", "setFirstDate", "firstDate$delegate", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "helperText", "getHelperText", "setHelperText", "helperText$delegate", "hint", "getHint", "setHint", "hint$delegate", "", "isTextFieldEnabled", "()Z", "setTextFieldEnabled", "(Z)V", "isTextFieldEnabled$delegate", "lastDate", "getLastDate", "setLastDate", "lastDate$delegate", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "locale", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "locale$delegate", "Lkotlin/Function1;", "", "onDateChange", "getOnDateChange", "()Lkotlin/jvm/functions/Function1;", "setOnDateChange", "(Lkotlin/jvm/functions/Function1;)V", "onDateChange$delegate", "Lcom/designsystem/ds_input_field/DSInputFieldState;", "state", "getState", "()Lcom/designsystem/ds_input_field/DSInputFieldState;", "setState", "(Lcom/designsystem/ds_input_field/DSInputFieldState;)V", "state$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "setEnabled", "enabled", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSDateField extends AbstractComposeView {
    public static final int $stable = 8;
    @NotNull
    private final MutableState date$delegate;
    @NotNull
    private final MutableState dateFormat$delegate;
    @NotNull
    private final MutableState firstDate$delegate;
    @Nullable
    private FragmentManager fragmentManager;
    @NotNull
    private final MutableState helperText$delegate;
    @NotNull
    private final MutableState hint$delegate;
    @NotNull
    private final MutableState isTextFieldEnabled$delegate;
    @NotNull
    private final MutableState lastDate$delegate;
    @NotNull
    private final MutableState locale$delegate;
    @NotNull
    private final MutableState onDateChange$delegate;
    @NotNull
    private final MutableState state$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSDateField(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSDateField(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSDateField(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final boolean isTextFieldEnabled() {
        return ((Boolean) this.isTextFieldEnabled$delegate.getValue()).booleanValue();
    }

    private final void setTextFieldEnabled(boolean z11) {
        this.isTextFieldEnabled$delegate.setValue(Boolean.valueOf(z11));
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(1493870408);
        Modifier.Companion companion = Modifier.Companion;
        Long date = getDate();
        String dateFormat = getDateFormat();
        String hint = getHint();
        String helperText = getHelperText();
        DSDateField$Content$1 dSDateField$Content$1 = new DSDateField$Content$1(this);
        boolean isTextFieldEnabled = isTextFieldEnabled();
        DSInputFieldState state = getState();
        FragmentManager fragmentManager2 = this.fragmentManager;
        if (fragmentManager2 != null) {
            Locale locale = getLocale();
            Intrinsics.checkNotNullExpressionValue(locale, "locale");
            DSDateFieldKt.DSDateField(companion, date, dateFormat, hint, helperText, dSDateField$Content$1, isTextFieldEnabled, state, fragmentManager2, locale, getFirstDate(), getLastDate(), startRestartGroup, 1207959558, 0, 0);
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new DSDateField$Content$3(this, i11));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FragmentManager is required and cannot be null!".toString());
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final Long getDate() {
        return (Long) this.date$delegate.getValue();
    }

    @NotNull
    public final String getDateFormat() {
        return (String) this.dateFormat$delegate.getValue();
    }

    @Nullable
    public final Long getFirstDate() {
        return (Long) this.firstDate$delegate.getValue();
    }

    @Nullable
    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    @Nullable
    public final String getHelperText() {
        return (String) this.helperText$delegate.getValue();
    }

    @Nullable
    public final String getHint() {
        return (String) this.hint$delegate.getValue();
    }

    @Nullable
    public final Long getLastDate() {
        return (Long) this.lastDate$delegate.getValue();
    }

    public final Locale getLocale() {
        return (Locale) this.locale$delegate.getValue();
    }

    @Nullable
    public final Function1<Long, Unit> getOnDateChange() {
        return (Function1) this.onDateChange$delegate.getValue();
    }

    @NotNull
    public final DSInputFieldState getState() {
        return (DSInputFieldState) this.state$delegate.getValue();
    }

    public final void setDate(@Nullable Long l11) {
        this.date$delegate.setValue(l11);
    }

    public final void setDateFormat(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dateFormat$delegate.setValue(str);
    }

    public void setEnabled(boolean z11) {
        setTextFieldEnabled(z11);
        super.setEnabled(z11);
    }

    public final void setFirstDate(@Nullable Long l11) {
        this.firstDate$delegate.setValue(l11);
    }

    public final void setFragmentManager(@Nullable FragmentManager fragmentManager2) {
        this.fragmentManager = fragmentManager2;
    }

    public final void setHelperText(@Nullable String str) {
        this.helperText$delegate.setValue(str);
    }

    public final void setHint(@Nullable String str) {
        this.hint$delegate.setValue(str);
    }

    public final void setLastDate(@Nullable Long l11) {
        this.lastDate$delegate.setValue(l11);
    }

    public final void setLocale(Locale locale) {
        this.locale$delegate.setValue(locale);
    }

    public final void setOnDateChange(@Nullable Function1<? super Long, Unit> function1) {
        this.onDateChange$delegate.setValue(function1);
    }

    public final void setState(@NotNull DSInputFieldState dSInputFieldState) {
        Intrinsics.checkNotNullParameter(dSInputFieldState, "<set-?>");
        this.state$delegate.setValue(dSInputFieldState);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSDateField(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.date$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        String str = DateInputField.DefaultDateFormat;
        this.dateFormat$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.hint$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.helperText$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onDateChange$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        DSInputFieldState dSInputFieldState = DSInputFieldState.Normal;
        this.state$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(dSInputFieldState, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isTextFieldEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.locale$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Locale.getDefault(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.firstDate$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.lastDate$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSDateField, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…leable.DSDateField, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSDateField_df_date_format);
            setDateFormat(string != null ? string : str);
            setHint(obtainStyledAttributes.getString(R.styleable.DSDateField_df_hint));
            setHelperText(obtainStyledAttributes.getString(R.styleable.DSDateField_df_helperText));
            int i12 = obtainStyledAttributes.getInt(R.styleable.DSDateField_df_state, -1);
            setState(i12 >= 0 ? DSInputFieldState.values()[i12] : dSInputFieldState);
            setEnabled(obtainStyledAttributes.getBoolean(R.styleable.DSDateField_df_is_enabled, true));
            obtainStyledAttributes.recycle();
        }
    }
}
