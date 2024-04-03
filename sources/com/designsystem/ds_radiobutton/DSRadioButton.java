package com.designsystem.ds_radiobutton;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.designsystem.ds_bottom_sheet.DSBottomSheetContentsKt;
import com.designsystem.extensions.ContextExtensionsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0002¨\u0006\u000f"}, d2 = {"Lcom/designsystem/ds_radiobutton/DSRadioButton;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setEnabled", "", "enabled", "", "setRadioButtonTheme", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This class has been replaced by 'com.designsystem.ds_radio_button.DSRadioButton'", replaceWith = @ReplaceWith(expression = "DSRadioButton", imports = {"com.designsystem.ds_radio_button.DSRadioButton"}))
public final class DSRadioButton extends AppCompatRadioButton {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TEXT_PADDING = 15;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/designsystem/ds_radiobutton/DSRadioButton$Companion;", "", "()V", "TEXT_PADDING", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSRadioButton(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSRadioButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSRadioButton(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.radioButtonStyle : i11);
    }

    private final void setRadioButtonTheme() {
        int i11;
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(com.designsystem.marshmallow.R.dimen.ds_m);
        if (isEnabled()) {
            i11 = com.designsystem.marshmallow.R.drawable.ds_radiobutton_enabled;
        } else {
            i11 = com.designsystem.marshmallow.R.drawable.ds_radiobutton_disabled;
        }
        Drawable drawable = ContextCompat.getDrawable(getContext(), i11);
        if (drawable == null) {
            drawable = null;
        } else {
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        if (isEnabled()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setTextColor(ContextExtensionsKt.getColorCompat(context, com.designsystem.marshmallow.R.color.ds_neutral_100));
            return;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        setTextColor(ContextExtensionsKt.getColorCompat(context2, com.designsystem.marshmallow.R.color.ds_neutral_35));
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        setRadioButtonTheme();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSRadioButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        setRadioButtonTheme();
        setTextAppearance(context, com.designsystem.marshmallow.R.style.DSTextAppearance_Button);
        int i12 = 0;
        setAllCaps(false);
        CharSequence text = getText();
        setCompoundDrawablePadding(!(text == null || text.length() == 0) ? DSBottomSheetContentsKt.dpToPx(15, getResources()) : i12);
        setButtonDrawable((Drawable) null);
        setBackground((Drawable) null);
    }
}
