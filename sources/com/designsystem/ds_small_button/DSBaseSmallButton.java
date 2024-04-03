package com.designsystem.ds_small_button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AbstractComposeView;
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u0019\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128G@GX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R+\u0010\u001d\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R9\u0010!\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b 2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b 8F@FX\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0011\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R7\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020(0'8F@FX\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0011\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000f¨\u00063"}, d2 = {"Lcom/designsystem/ds_small_button/DSBaseSmallButton;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "buttonTitle", "getButtonTitle", "()Ljava/lang/String;", "setButtonTitle", "(Ljava/lang/String;)V", "buttonTitle$delegate", "Landroidx/compose/runtime/MutableState;", "", "forceMM2", "getForceMM2", "()Z", "setForceMM2", "(Z)V", "forceMM2$delegate", "isEnabled", "isButtonEnabled", "setButtonEnabled", "isEnabled$delegate", "isLoading", "setLoading", "isLoading$delegate", "Landroidx/annotation/DrawableRes;", "leadingIcon", "getLeadingIcon", "()Ljava/lang/Integer;", "setLeadingIcon", "(Ljava/lang/Integer;)V", "leadingIcon$delegate", "Lkotlin/Function0;", "", "onTap", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "setOnTap", "(Lkotlin/jvm/functions/Function0;)V", "onTap$delegate", "value", "title", "getTitle", "setTitle", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DSBaseSmallButton extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState buttonTitle$delegate;
    @NotNull
    private final MutableState forceMM2$delegate;
    @NotNull
    private final MutableState isEnabled$delegate;
    @NotNull
    private final MutableState isLoading$delegate;
    @NotNull
    private final MutableState leadingIcon$delegate;
    @NotNull
    private final MutableState onTap$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBaseSmallButton(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBaseSmallButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSBaseSmallButton(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final String getButtonTitle() {
        return (String) this.buttonTitle$delegate.getValue();
    }

    private final void setButtonTitle(String str) {
        this.buttonTitle$delegate.setValue(str);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final boolean getForceMM2() {
        return ((Boolean) this.forceMM2$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final Integer getLeadingIcon() {
        return (Integer) this.leadingIcon$delegate.getValue();
    }

    @NotNull
    public final Function0<Unit> getOnTap() {
        return (Function0) this.onTap$delegate.getValue();
    }

    @NotNull
    public final String getTitle() {
        getButtonTitle();
        String buttonTitle = getButtonTitle();
        if (buttonTitle == null) {
            return "";
        }
        return buttonTitle;
    }

    @JvmName(name = "isButtonEnabled")
    public final boolean isButtonEnabled() {
        return ((Boolean) this.isEnabled$delegate.getValue()).booleanValue();
    }

    public final boolean isLoading() {
        return ((Boolean) this.isLoading$delegate.getValue()).booleanValue();
    }

    @JvmName(name = "setButtonEnabled")
    public final void setButtonEnabled(boolean z11) {
        this.isEnabled$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setForceMM2(boolean z11) {
        this.forceMM2$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setLeadingIcon(@Nullable Integer num) {
        this.leadingIcon$delegate.setValue(num);
    }

    public final void setLoading(boolean z11) {
        this.isLoading$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setOnTap(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onTap$delegate.setValue(function0);
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        setButtonTitle(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBaseSmallButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.buttonTitle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.leadingIcon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        Boolean bool = Boolean.FALSE;
        this.isLoading$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.forceMM2$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onTap$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DSBaseSmallButton$onTap$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSBaseSmallButton, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….DSBaseSmallButton, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSBaseSmallButton_sbt_title);
            setTitle(string == null ? "" : string);
            setLeadingIcon(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSBaseSmallButton_sbt_leading_icon));
            setButtonEnabled(obtainStyledAttributes.getBoolean(R.styleable.DSBaseSmallButton_sbt_is_enabled, true));
            setLoading(obtainStyledAttributes.getBoolean(R.styleable.DSBaseSmallButton_sbt_is_loading, false));
            setForceMM2(obtainStyledAttributes.getBoolean(R.styleable.DSBaseSmallButton_sbt_force_mm2, false));
            obtainStyledAttributes.recycle();
        }
    }
}
