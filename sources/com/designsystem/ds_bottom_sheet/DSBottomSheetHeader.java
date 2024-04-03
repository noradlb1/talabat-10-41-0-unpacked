package com.designsystem.ds_bottom_sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001f\u001a\u00020 H\u0002R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u00108B@BX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u00108B@BX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R(\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u00108B@BX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R$\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/designsystem/ds_bottom_sheet/DSBottomSheetHeader;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "endText", "getEndText", "()Ljava/lang/String;", "setEndText", "(Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "firstEndIcon", "getFirstEndIcon", "()Landroid/graphics/drawable/Drawable;", "setFirstEndIcon", "(Landroid/graphics/drawable/Drawable;)V", "secondEndIcon", "getSecondEndIcon", "setSecondEndIcon", "startIcon", "getStartIcon", "setStartIcon", "title", "getTitle", "setTitle", "setupViewsVisibility", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This class has been replaced by 'com.designsystem.ds_bottom_sheet_v2.DSBottomSheet'", replaceWith = @ReplaceWith(expression = "DSBottomSheet", imports = {"com.designsystem.ds_bottom_sheet_v2.DSBottomSheet"}))
public final class DSBottomSheetHeader extends ConstraintLayout {
    public static final int $stable = 0;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBottomSheetHeader(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBottomSheetHeader(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSBottomSheetHeader(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final String getEndText() {
        return ((TextView) findViewById(R.id.bsh_end_text)).getText().toString();
    }

    private final Drawable getFirstEndIcon() {
        return ((ImageView) findViewById(R.id.bsh_end_first_icon)).getDrawable();
    }

    private final Drawable getSecondEndIcon() {
        return ((ImageView) findViewById(R.id.bsh_end_second_icon)).getDrawable();
    }

    private final Drawable getStartIcon() {
        return ((ImageView) findViewById(R.id.bsh_start_icon)).getDrawable();
    }

    private final String getTitle() {
        return ((TextView) findViewById(R.id.bsh_title)).getText().toString();
    }

    private final void setEndText(String str) {
        ((TextView) findViewById(R.id.bsh_end_text)).setText(str);
        setupViewsVisibility();
    }

    private final void setFirstEndIcon(Drawable drawable) {
        ((ImageView) findViewById(R.id.bsh_end_first_icon)).setImageDrawable(drawable);
        setupViewsVisibility();
    }

    private final void setSecondEndIcon(Drawable drawable) {
        ((ImageView) findViewById(R.id.bsh_end_second_icon)).setImageDrawable(drawable);
        setupViewsVisibility();
    }

    private final void setStartIcon(Drawable drawable) {
        ((ImageView) findViewById(R.id.bsh_start_icon)).setImageDrawable(drawable);
        setupViewsVisibility();
    }

    private final void setTitle(String str) {
        ((TextView) findViewById(R.id.bsh_title)).setText(str);
        setupViewsVisibility();
    }

    private final void setupViewsVisibility() {
        if (!StringsKt__StringsJVMKt.isBlank(getTitle())) {
            int i11 = R.id.bsh_title;
            ((TextView) findViewById(i11)).setVisibility(0);
            ((TextView) findViewById(i11)).setText(getTitle());
        } else {
            ((TextView) findViewById(R.id.bsh_title)).setVisibility(8);
        }
        if (getStartIcon() != null) {
            ((ImageView) findViewById(R.id.bsh_start_icon)).setVisibility(0);
        } else {
            ((ImageView) findViewById(R.id.bsh_start_icon)).setVisibility(8);
        }
        if (getFirstEndIcon() != null) {
            ((ImageView) findViewById(R.id.bsh_end_first_icon)).setVisibility(0);
        } else {
            ((ImageView) findViewById(R.id.bsh_end_first_icon)).setVisibility(8);
        }
        if (getSecondEndIcon() != null) {
            ((ImageView) findViewById(R.id.bsh_end_second_icon)).setVisibility(0);
        } else {
            ((ImageView) findViewById(R.id.bsh_end_second_icon)).setVisibility(8);
        }
        if (!StringsKt__StringsJVMKt.isBlank(getEndText())) {
            int i12 = R.id.bsh_end_text;
            ((TextView) findViewById(i12)).setVisibility(0);
            ((TextView) findViewById(i12)).setText(getEndText());
            return;
        }
        ((TextView) findViewById(R.id.bsh_end_text)).setVisibility(8);
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBottomSheetHeader(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.ds_bottom_sheet_header, this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSBottomSheetHeader, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…SBottomSheetHeader, 0, 0)");
            setStartIcon(obtainStyledAttributes.getDrawable(R.styleable.DSBottomSheetHeader_bsh_start_icon));
            String string = obtainStyledAttributes.getString(R.styleable.DSBottomSheetHeader_bsh_title);
            String str = "";
            setTitle(string == null ? str : string);
            String string2 = obtainStyledAttributes.getString(R.styleable.DSBottomSheetHeader_bsh_end_text);
            setEndText(string2 != null ? string2 : str);
            setFirstEndIcon(obtainStyledAttributes.getDrawable(R.styleable.DSBottomSheetHeader_bsh_end_first_icon));
            setSecondEndIcon(obtainStyledAttributes.getDrawable(R.styleable.DSBottomSheetHeader_bsh_end_second_icon));
            setupViewsVisibility();
            obtainStyledAttributes.recycle();
        }
    }
}
