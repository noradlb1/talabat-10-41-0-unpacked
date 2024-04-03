package com.designsystem.ds_button;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.designsystem.marshmallow.R;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020!H\u0002R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00178F@FX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/designsystem/ds_button/DSTertiaryButton;", "Lcom/designsystem/ds_button/DSButton;", "Lcom/designsystem/ds_button/DSButtonDataSource;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "centerText", "getCenterText", "()Ljava/lang/String;", "setCenterText", "(Ljava/lang/String;)V", "", "dsIsEnabled", "getDsIsEnabled", "()Z", "setDsIsEnabled", "(Z)V", "Landroid/graphics/drawable/Drawable;", "icon", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "getTheme", "Lcom/designsystem/ds_button/AttributedButton;", "isActive", "setupViewsVisibility", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This class has been replaced by 'com.designsystem.ds_button_v2.DSTertiaryButton'", replaceWith = @ReplaceWith(expression = "DSTertiaryButton", imports = {"com.designsystem.ds_button_v2.DSTertiaryButton"}))
public final class DSTertiaryButton extends DSButton implements DSButtonDataSource {
    public static final int $stable = 0;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTertiaryButton(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTertiaryButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSTertiaryButton(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void setupViewsVisibility() {
        int i11;
        ImageView imageView = (ImageView) findViewById(R.id.iconImageView);
        int i12 = 0;
        if (getIcon() != null) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        imageView.setVisibility(i11);
        TextView textView = (TextView) findViewById(R.id.centerTextView);
        if (!(!StringsKt__StringsJVMKt.isBlank(getCenterText()))) {
            i12 = 8;
        }
        textView.setVisibility(i12);
    }

    public void _$_clearFindViewByIdCache() {
    }

    @NotNull
    public final String getCenterText() {
        return ((TextView) findViewById(R.id.centerTextView)).getText().toString();
    }

    public final boolean getDsIsEnabled() {
        return isEnabled();
    }

    @Nullable
    public final Drawable getIcon() {
        return ((ImageView) findViewById(R.id.iconImageView)).getDrawable();
    }

    @NotNull
    public AttributedButton getTheme(boolean z11) {
        DSButtonTheme dSButtonTheme;
        if (isLoading()) {
            dSButtonTheme = DSButtonTheme.tertiaryLoading;
        } else if (!getDsIsEnabled()) {
            dSButtonTheme = DSButtonTheme.tertiaryDisabled;
        } else if (z11) {
            dSButtonTheme = DSButtonTheme.tertiaryActive;
        } else {
            dSButtonTheme = DSButtonTheme.tertiaryPressed;
        }
        return dSButtonTheme.getValue();
    }

    public final void setCenterText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) findViewById(R.id.centerTextView)).setText(str);
        setupViewsVisibility();
    }

    public final void setDsIsEnabled(boolean z11) {
        setEnabled(z11);
        setupTheme(getTheme(getDsIsEnabled()));
    }

    public final void setIcon(@Nullable Drawable drawable) {
        ((ImageView) findViewById(R.id.iconImageView)).setImageDrawable(drawable);
        setupViewsVisibility();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTertiaryButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        setDataSource(this);
        setIcon(getAttrIcon());
        setCenterText(getAttrCenterText());
        setDsIsEnabled(getAttrIsEnabled());
        setupViewsVisibility();
        setupTheme(getTheme(getDsIsEnabled()));
        setupTouchHandler();
    }
}
