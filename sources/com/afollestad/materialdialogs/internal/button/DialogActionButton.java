package com.afollestad.materialdialogs.internal.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatButton;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.ThemeKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J%\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "disabledColor", "", "enabledColor", "setEnabled", "", "enabled", "", "update", "baseContext", "appContext", "stacked", "update$com_afollestad_material_dialogs_core", "updateTextColor", "color", "Companion", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
public final class DialogActionButton extends AppCompatButton {
    private static final int CASING_UPPER = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int disabledColor;
    private int enabledColor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/afollestad/materialdialogs/internal/button/DialogActionButton$Companion;", "", "()V", "CASING_UPPER", "", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DialogActionButton(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public void setEnabled(boolean z11) {
        int i11;
        super.setEnabled(z11);
        if (z11) {
            i11 = this.enabledColor;
        } else {
            i11 = this.disabledColor;
        }
        setTextColor(i11);
    }

    public final void update$com_afollestad_material_dialogs_core(@NotNull Context context, @NotNull Context context2, boolean z11) {
        int i11;
        int resolveColor$default;
        Intrinsics.checkParameterIsNotNull(context, "baseContext");
        Intrinsics.checkParameterIsNotNull(context2, "appContext");
        MDUtil mDUtil = MDUtil.INSTANCE;
        boolean z12 = true;
        if (mDUtil.resolveInt(context2, R.attr.md_button_casing, 1) != 1) {
            z12 = false;
        }
        setSupportAllCaps(z12);
        boolean inferThemeIsLight = ThemeKt.inferThemeIsLight(context2);
        this.enabledColor = MDUtil.resolveColor$default(mDUtil, context2, (Integer) null, Integer.valueOf(R.attr.md_color_button_text), new DialogActionButton$update$1(context2), 2, (Object) null);
        if (inferThemeIsLight) {
            i11 = R.color.md_disabled_text_light_theme;
        } else {
            i11 = R.color.md_disabled_text_dark_theme;
        }
        Context context3 = context;
        this.disabledColor = MDUtil.resolveColor$default(mDUtil, context3, Integer.valueOf(i11), (Integer) null, (Function0) null, 12, (Object) null);
        setTextColor(this.enabledColor);
        Drawable resolveDrawable$default = MDUtil.resolveDrawable$default(mDUtil, context3, (Integer) null, Integer.valueOf(R.attr.md_button_selector), (Drawable) null, 10, (Object) null);
        if ((resolveDrawable$default instanceof RippleDrawable) && (resolveColor$default = MDUtil.resolveColor$default(mDUtil, context, (Integer) null, Integer.valueOf(R.attr.md_ripple_color), new DialogActionButton$update$2(context2), 2, (Object) null)) != 0) {
            ((RippleDrawable) resolveDrawable$default).setColor(ColorStateList.valueOf(resolveColor$default));
        }
        setBackground(resolveDrawable$default);
        if (z11) {
            ViewsKt.setGravityEndCompat(this);
        } else {
            setGravity(17);
        }
        setEnabled(isEnabled());
    }

    public final void updateTextColor(@ColorInt int i11) {
        this.enabledColor = i11;
        setEnabled(isEnabled());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogActionButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setClickable(true);
        setFocusable(true);
    }
}
