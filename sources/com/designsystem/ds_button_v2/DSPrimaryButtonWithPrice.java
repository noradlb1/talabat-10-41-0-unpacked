package com.designsystem.ds_button_v2;

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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u00109\u001a\u00020%H\u0017¢\u0006\u0002\u0010:R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168F@FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010\u001d\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168G@GX\u0002¢\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR+\u0010!\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168F@FX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR7\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020%0$8F@FX\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0011\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR/\u00100\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0011\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000f¨\u0006;"}, d2 = {"Lcom/designsystem/ds_button_v2/DSPrimaryButtonWithPrice;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "buttonPrice", "getButtonPrice", "()Ljava/lang/String;", "setButtonPrice", "(Ljava/lang/String;)V", "buttonPrice$delegate", "Landroidx/compose/runtime/MutableState;", "buttonTitle", "getButtonTitle", "setButtonTitle", "buttonTitle$delegate", "", "forceMM2", "getForceMM2", "()Z", "setForceMM2", "(Z)V", "forceMM2$delegate", "isEnabled", "isButtonEnabled", "setButtonEnabled", "isEnabled$delegate", "isLoading", "setLoading", "isLoading$delegate", "Lkotlin/Function0;", "", "onTap", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "setOnTap", "(Lkotlin/jvm/functions/Function0;)V", "onTap$delegate", "value", "price", "getPrice", "setPrice", "quantity", "getQuantity", "()Ljava/lang/Integer;", "setQuantity", "(Ljava/lang/Integer;)V", "quantity$delegate", "title", "getTitle", "setTitle", "Content", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSPrimaryButtonWithPrice extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState buttonPrice$delegate;
    @NotNull
    private final MutableState buttonTitle$delegate;
    @NotNull
    private final MutableState forceMM2$delegate;
    @NotNull
    private final MutableState isEnabled$delegate;
    @NotNull
    private final MutableState isLoading$delegate;
    @NotNull
    private final MutableState onTap$delegate;
    @NotNull
    private final MutableState quantity$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPrimaryButtonWithPrice(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPrimaryButtonWithPrice(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSPrimaryButtonWithPrice(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final String getButtonPrice() {
        return (String) this.buttonPrice$delegate.getValue();
    }

    private final String getButtonTitle() {
        return (String) this.buttonTitle$delegate.getValue();
    }

    private final void setButtonPrice(String str) {
        this.buttonPrice$delegate.setValue(str);
    }

    private final void setButtonTitle(String str) {
        this.buttonTitle$delegate.setValue(str);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1773290173);
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
            DSPrimaryButtonWithPriceKt.DSPrimaryButtonWithPrice(getTitle(), getPrice(), (Modifier) null, getQuantity(), isButtonEnabled(), isLoading(), getForceMM2(), getOnTap(), startRestartGroup, 0, 4);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSPrimaryButtonWithPrice$Content$1(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final boolean getForceMM2() {
        return ((Boolean) this.forceMM2$delegate.getValue()).booleanValue();
    }

    @NotNull
    public final Function0<Unit> getOnTap() {
        return (Function0) this.onTap$delegate.getValue();
    }

    @NotNull
    public final String getPrice() {
        getButtonPrice();
        String buttonPrice = getButtonPrice();
        if (buttonPrice == null) {
            return "";
        }
        return buttonPrice;
    }

    @Nullable
    public final Integer getQuantity() {
        return (Integer) this.quantity$delegate.getValue();
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

    public final void setLoading(boolean z11) {
        this.isLoading$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setOnTap(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onTap$delegate.setValue(function0);
    }

    public final void setPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        setButtonPrice(str);
    }

    public final void setQuantity(@Nullable Integer num) {
        this.quantity$delegate.setValue(num);
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        setButtonTitle(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPrimaryButtonWithPrice(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.buttonTitle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.buttonPrice$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.quantity$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onTap$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DSPrimaryButtonWithPrice$onTap$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        Boolean bool = Boolean.FALSE;
        this.isLoading$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.forceMM2$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSPrimaryButtonWithPrice, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…aryButtonWithPrice, 0, 0)");
            setButtonTitle(obtainStyledAttributes.getString(R.styleable.DSPrimaryButtonWithPrice_pbt_title));
            setButtonPrice(obtainStyledAttributes.getString(R.styleable.DSPrimaryButtonWithPrice_pbt_price));
            setQuantity(TypedArrayExtensionsKt.getIntOrNull(obtainStyledAttributes, R.styleable.DSPrimaryButtonWithPrice_pbt_quantity));
            setButtonEnabled(obtainStyledAttributes.getBoolean(R.styleable.DSPrimaryButtonWithPrice_pbt_is_enabled, true));
            setLoading(obtainStyledAttributes.getBoolean(R.styleable.DSPrimaryButtonWithPrice_pbt_is_loading, false));
            setForceMM2(obtainStyledAttributes.getBoolean(R.styleable.DSPrimaryButtonWithPrice_pbt_force_mm2, false));
            obtainStyledAttributes.recycle();
        }
    }
}
