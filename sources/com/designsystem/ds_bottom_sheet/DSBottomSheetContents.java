package com.designsystem.ds_bottom_sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_button.DSSecondaryButton;
import com.designsystem.ds_button.DSSocialButton;
import com.designsystem.ds_button.DSTertiaryButton;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020GH\u0002R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\t\u001a\u0004\u0018\u00010\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010(\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR(\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR(\u0010.\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R(\u00101\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R(\u00104\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R(\u00107\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR(\u0010:\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R$\u0010>\u001a\u00020=2\u0006\u0010\t\u001a\u00020=@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR(\u0010C\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\r\"\u0004\bE\u0010\u000f¨\u0006I"}, d2 = {"Lcom/designsystem/ds_bottom_sheet/DSBottomSheetContents;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "buttonCenterText", "getButtonCenterText", "()Ljava/lang/String;", "setButtonCenterText", "(Ljava/lang/String;)V", "buttonEndText", "getButtonEndText", "setButtonEndText", "Landroid/graphics/drawable/Drawable;", "buttonIcon", "getButtonIcon", "()Landroid/graphics/drawable/Drawable;", "setButtonIcon", "(Landroid/graphics/drawable/Drawable;)V", "buttonStartText", "getButtonStartText", "setButtonStartText", "Lcom/designsystem/ds_bottom_sheet/ButtonType;", "buttonType", "getButtonType", "()Lcom/designsystem/ds_bottom_sheet/ButtonType;", "setButtonType", "(Lcom/designsystem/ds_bottom_sheet/ButtonType;)V", "contentLayout", "getContentLayout", "()Ljava/lang/Integer;", "setContentLayout", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "details", "getDetails", "setDetails", "headerEndText", "getHeaderEndText", "setHeaderEndText", "headerFirstEndIcon", "getHeaderFirstEndIcon", "setHeaderFirstEndIcon", "headerSecondEndIcon", "getHeaderSecondEndIcon", "setHeaderSecondEndIcon", "headerStartIcon", "getHeaderStartIcon", "setHeaderStartIcon", "headerTitle", "getHeaderTitle", "setHeaderTitle", "image", "getImage", "setImage", "", "scrollEnabled", "getScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "title", "getTitle", "setTitle", "setButtonViewAndVisibility", "", "setupViewsVisibility", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This class has been replaced by 'com.designsystem.ds_bottom_sheet_v2.DSBottomSheet'", replaceWith = @ReplaceWith(expression = "DSBottomSheet", imports = {"com.designsystem.ds_bottom_sheet_v2.DSBottomSheet"}))
public final class DSBottomSheetContents extends ConstraintLayout {
    public static final int $stable = 8;
    @Nullable
    private String buttonCenterText;
    @Nullable
    private String buttonEndText;
    @Nullable
    private Drawable buttonIcon;
    @Nullable
    private String buttonStartText;
    @Nullable
    private ButtonType buttonType;
    @Nullable
    private Integer contentLayout;
    @Nullable
    private String details;
    @Nullable
    private String headerEndText;
    @Nullable
    private Drawable headerFirstEndIcon;
    @Nullable
    private Drawable headerSecondEndIcon;
    @Nullable
    private Drawable headerStartIcon;
    @Nullable
    private String headerTitle;
    @Nullable
    private Drawable image;
    private boolean scrollEnabled;
    @Nullable
    private String title;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonType.values().length];
            iArr[ButtonType.Primary.ordinal()] = 1;
            iArr[ButtonType.Secondary.ordinal()] = 2;
            iArr[ButtonType.Tertiary.ordinal()] = 3;
            iArr[ButtonType.Social.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBottomSheetContents(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBottomSheetContents(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSBottomSheetContents(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void setButtonViewAndVisibility() {
        ButtonType buttonType2 = this.buttonType;
        int i11 = buttonType2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[buttonType2.ordinal()];
        String str = "";
        if (i11 == 1) {
            int i12 = R.id.bs_button_primary;
            ((DSPrimaryButton) findViewById(i12)).setVisibility(0);
            ((DSSecondaryButton) findViewById(R.id.bs_button_secondary)).setVisibility(8);
            ((DSTertiaryButton) findViewById(R.id.bs_button_tertiary)).setVisibility(8);
            ((DSSocialButton) findViewById(R.id.bs_button_social)).setVisibility(8);
            DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) findViewById(i12);
            String str2 = this.buttonCenterText;
            if (str2 == null) {
                str2 = str;
            }
            dSPrimaryButton.setCenterText(str2);
            if (this.buttonStartText != null) {
                DSPrimaryButton dSPrimaryButton2 = (DSPrimaryButton) findViewById(i12);
                String str3 = this.buttonStartText;
                if (str3 == null) {
                    str3 = str;
                }
                dSPrimaryButton2.setStartText(str3);
            }
            if (this.buttonEndText != null) {
                DSPrimaryButton dSPrimaryButton3 = (DSPrimaryButton) findViewById(i12);
                String str4 = this.buttonEndText;
                if (str4 != null) {
                    str = str4;
                }
                dSPrimaryButton3.setEndText(str);
            }
            if (this.buttonIcon != null) {
                ((DSPrimaryButton) findViewById(i12)).setIcon(this.buttonIcon);
            }
        } else if (i11 == 2) {
            ((DSPrimaryButton) findViewById(R.id.bs_button_primary)).setVisibility(8);
            int i13 = R.id.bs_button_secondary;
            ((DSSecondaryButton) findViewById(i13)).setVisibility(0);
            ((DSTertiaryButton) findViewById(R.id.bs_button_tertiary)).setVisibility(8);
            ((DSSocialButton) findViewById(R.id.bs_button_social)).setVisibility(8);
            DSSecondaryButton dSSecondaryButton = (DSSecondaryButton) findViewById(i13);
            String str5 = this.buttonCenterText;
            if (str5 == null) {
                str5 = str;
            }
            dSSecondaryButton.setCenterText(str5);
            if (this.buttonStartText != null) {
                DSSecondaryButton dSSecondaryButton2 = (DSSecondaryButton) findViewById(i13);
                String str6 = this.buttonStartText;
                if (str6 == null) {
                    str6 = str;
                }
                dSSecondaryButton2.setStartText(str6);
            }
            if (this.buttonEndText != null) {
                DSSecondaryButton dSSecondaryButton3 = (DSSecondaryButton) findViewById(i13);
                String str7 = this.buttonEndText;
                if (str7 != null) {
                    str = str7;
                }
                dSSecondaryButton3.setEndText(str);
            }
            if (this.buttonIcon != null) {
                ((DSSecondaryButton) findViewById(i13)).setIcon(this.buttonIcon);
            }
        } else if (i11 == 3) {
            ((DSPrimaryButton) findViewById(R.id.bs_button_primary)).setVisibility(8);
            ((DSSecondaryButton) findViewById(R.id.bs_button_secondary)).setVisibility(8);
            int i14 = R.id.bs_button_tertiary;
            ((DSTertiaryButton) findViewById(i14)).setVisibility(0);
            ((DSSocialButton) findViewById(R.id.bs_button_social)).setVisibility(8);
            DSTertiaryButton dSTertiaryButton = (DSTertiaryButton) findViewById(i14);
            String str8 = this.buttonCenterText;
            if (str8 != null) {
                str = str8;
            }
            dSTertiaryButton.setCenterText(str);
            if (this.buttonIcon != null) {
                ((DSTertiaryButton) findViewById(i14)).setIcon(this.buttonIcon);
            }
        } else if (i11 != 4) {
            ((DSSocialButton) findViewById(R.id.bs_button_social)).setVisibility(8);
            ((DSTertiaryButton) findViewById(R.id.bs_button_tertiary)).setVisibility(8);
            ((DSSecondaryButton) findViewById(R.id.bs_button_secondary)).setVisibility(8);
            ((DSPrimaryButton) findViewById(R.id.bs_button_primary)).setVisibility(8);
        } else {
            ((DSPrimaryButton) findViewById(R.id.bs_button_primary)).setVisibility(8);
            ((DSSecondaryButton) findViewById(R.id.bs_button_secondary)).setVisibility(8);
            ((DSTertiaryButton) findViewById(R.id.bs_button_tertiary)).setVisibility(8);
            int i15 = R.id.bs_button_social;
            ((DSSocialButton) findViewById(i15)).setVisibility(0);
            DSSocialButton dSSocialButton = (DSSocialButton) findViewById(i15);
            String str9 = this.buttonCenterText;
            if (str9 != null) {
                str = str9;
            }
            dSSocialButton.setCenterText(str);
            if (this.buttonIcon != null) {
                ((DSSocialButton) findViewById(i15)).setIcon(this.buttonIcon);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0269  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setupViewsVisibility() {
        /*
            r6 = this;
            int r0 = com.designsystem.marshmallow.R.id.bs_scroll_view
            android.view.View r0 = r6.findViewById(r0)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            z5.d r1 = new z5.d
            r1.<init>(r6)
            r0.setOnTouchListener(r1)
            java.lang.String r0 = r6.headerTitle
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001f
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = r2
            goto L_0x0020
        L_0x001f:
            r0 = r1
        L_0x0020:
            r3 = 8
            if (r0 == 0) goto L_0x004c
            java.lang.String r0 = r6.headerEndText
            if (r0 == 0) goto L_0x0031
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)
            if (r0 == 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r0 = r2
            goto L_0x0032
        L_0x0031:
            r0 = r1
        L_0x0032:
            if (r0 == 0) goto L_0x004c
            android.graphics.drawable.Drawable r0 = r6.headerFirstEndIcon
            if (r0 != 0) goto L_0x004c
            android.graphics.drawable.Drawable r0 = r6.headerSecondEndIcon
            if (r0 != 0) goto L_0x004c
            android.graphics.drawable.Drawable r0 = r6.headerStartIcon
            if (r0 != 0) goto L_0x004c
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            r0.setVisibility(r3)
            goto L_0x0057
        L_0x004c:
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            r0.setVisibility(r2)
        L_0x0057:
            java.lang.String r0 = r6.headerTitle
            if (r0 == 0) goto L_0x0064
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)
            if (r0 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r0 = r2
            goto L_0x0065
        L_0x0064:
            r0 = r1
        L_0x0065:
            if (r0 != 0) goto L_0x008c
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r4 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r4 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r4
            int r5 = com.designsystem.marshmallow.R.id.bsh_title
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r2)
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            android.view.View r0 = r0.findViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = r6.headerTitle
            r0.setText(r4)
            goto L_0x009f
        L_0x008c:
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            int r4 = com.designsystem.marshmallow.R.id.bsh_title
            android.view.View r0 = r0.findViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r3)
        L_0x009f:
            android.graphics.drawable.Drawable r0 = r6.headerStartIcon
            if (r0 == 0) goto L_0x00b7
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            int r4 = com.designsystem.marshmallow.R.id.bsh_start_icon
            android.view.View r0 = r0.findViewById(r4)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
            goto L_0x00ca
        L_0x00b7:
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            int r4 = com.designsystem.marshmallow.R.id.bsh_start_icon
            android.view.View r0 = r0.findViewById(r4)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r3)
        L_0x00ca:
            android.graphics.drawable.Drawable r0 = r6.headerFirstEndIcon
            if (r0 == 0) goto L_0x00e2
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            int r4 = com.designsystem.marshmallow.R.id.bsh_end_first_icon
            android.view.View r0 = r0.findViewById(r4)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
            goto L_0x00f5
        L_0x00e2:
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            int r4 = com.designsystem.marshmallow.R.id.bsh_end_first_icon
            android.view.View r0 = r0.findViewById(r4)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r3)
        L_0x00f5:
            android.graphics.drawable.Drawable r0 = r6.headerSecondEndIcon
            if (r0 == 0) goto L_0x010d
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            int r4 = com.designsystem.marshmallow.R.id.bsh_end_second_icon
            android.view.View r0 = r0.findViewById(r4)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
            goto L_0x0120
        L_0x010d:
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            int r4 = com.designsystem.marshmallow.R.id.bsh_end_second_icon
            android.view.View r0 = r0.findViewById(r4)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r3)
        L_0x0120:
            java.lang.String r0 = r6.headerEndText
            if (r0 == 0) goto L_0x012d
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)
            if (r0 == 0) goto L_0x012b
            goto L_0x012d
        L_0x012b:
            r0 = r2
            goto L_0x012e
        L_0x012d:
            r0 = r1
        L_0x012e:
            if (r0 != 0) goto L_0x0155
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r4 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r4 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r4
            int r5 = com.designsystem.marshmallow.R.id.bsh_end_text
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r2)
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            android.view.View r0 = r0.findViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = r6.headerEndText
            r0.setText(r4)
            goto L_0x0168
        L_0x0155:
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            int r4 = com.designsystem.marshmallow.R.id.bsh_end_text
            android.view.View r0 = r0.findViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r3)
        L_0x0168:
            java.lang.String r0 = r6.title
            if (r0 == 0) goto L_0x0175
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)
            if (r0 == 0) goto L_0x0173
            goto L_0x0175
        L_0x0173:
            r0 = r2
            goto L_0x0176
        L_0x0175:
            r0 = r1
        L_0x0176:
            if (r0 != 0) goto L_0x018f
            int r0 = com.designsystem.marshmallow.R.id.bs_title
            android.view.View r4 = r6.findViewById(r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r2)
            android.view.View r0 = r6.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = r6.title
            r0.setText(r4)
            goto L_0x019a
        L_0x018f:
            int r0 = com.designsystem.marshmallow.R.id.bs_title
            android.view.View r0 = r6.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r3)
        L_0x019a:
            java.lang.String r0 = r6.details
            if (r0 == 0) goto L_0x01a6
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)
            if (r0 == 0) goto L_0x01a5
            goto L_0x01a6
        L_0x01a5:
            r1 = r2
        L_0x01a6:
            if (r1 != 0) goto L_0x01bf
            int r0 = com.designsystem.marshmallow.R.id.bs_details
            android.view.View r1 = r6.findViewById(r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setVisibility(r2)
            android.view.View r0 = r6.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r6.details
            r0.setText(r1)
            goto L_0x01ca
        L_0x01bf:
            int r0 = com.designsystem.marshmallow.R.id.bs_details
            android.view.View r0 = r6.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r3)
        L_0x01ca:
            android.graphics.drawable.Drawable r0 = r6.image
            if (r0 == 0) goto L_0x0219
            int r0 = com.designsystem.marshmallow.R.id.bottom_sheet_header
            android.view.View r0 = r6.findViewById(r0)
            com.designsystem.ds_bottom_sheet.DSBottomSheetHeader r0 = (com.designsystem.ds_bottom_sheet.DSBottomSheetHeader) r0
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x01f5
            int r0 = com.designsystem.marshmallow.R.id.bs_image
            android.view.View r0 = r6.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r1 = 281(0x119, float:3.94E-43)
            android.content.res.Resources r4 = r6.getResources()
            int r1 = com.designsystem.ds_bottom_sheet.DSBottomSheetContentsKt.dpToPx(r1, r4)
            r0.height = r1
            goto L_0x020d
        L_0x01f5:
            int r0 = com.designsystem.marshmallow.R.id.bs_image
            android.view.View r0 = r6.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r1 = 160(0xa0, float:2.24E-43)
            android.content.res.Resources r4 = r6.getResources()
            int r1 = com.designsystem.ds_bottom_sheet.DSBottomSheetContentsKt.dpToPx(r1, r4)
            r0.height = r1
        L_0x020d:
            int r0 = com.designsystem.marshmallow.R.id.bs_image
            android.view.View r0 = r6.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
            goto L_0x0224
        L_0x0219:
            int r0 = com.designsystem.marshmallow.R.id.bs_image
            android.view.View r0 = r6.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r3)
        L_0x0224:
            java.lang.Integer r0 = r6.contentLayout
            if (r0 != 0) goto L_0x0229
            goto L_0x0230
        L_0x0229:
            int r0 = r0.intValue()
            r1 = -1
            if (r0 == r1) goto L_0x0269
        L_0x0230:
            java.lang.Integer r0 = r6.contentLayout
            if (r0 == 0) goto L_0x0269
            int r0 = com.designsystem.marshmallow.R.id.bs_contents
            android.view.View r1 = r6.findViewById(r0)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r1.setVisibility(r2)
            android.content.Context r1 = r6.getContext()
            java.lang.Integer r3 = r6.contentLayout
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r3 = r3.intValue()
            r4 = 0
            android.view.View r1 = android.view.View.inflate(r1, r3, r4)
            java.lang.String r3 = "inflate(context, contentLayout!!, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            android.view.View r3 = r6.findViewById(r0)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r3.removeAllViews()
            android.view.View r0 = r6.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r0.addView(r1, r2)
            goto L_0x0274
        L_0x0269:
            int r0 = com.designsystem.marshmallow.R.id.bs_contents
            android.view.View r0 = r6.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r0.setVisibility(r3)
        L_0x0274:
            r6.setButtonViewAndVisibility()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_bottom_sheet.DSBottomSheetContents.setupViewsVisibility():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: setupViewsVisibility$lambda-1  reason: not valid java name */
    public static final boolean m8261setupViewsVisibility$lambda1(DSBottomSheetContents dSBottomSheetContents, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(dSBottomSheetContents, "this$0");
        return !dSBottomSheetContents.getScrollEnabled();
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final String getButtonCenterText() {
        return this.buttonCenterText;
    }

    @Nullable
    public final String getButtonEndText() {
        return this.buttonEndText;
    }

    @Nullable
    public final Drawable getButtonIcon() {
        return this.buttonIcon;
    }

    @Nullable
    public final String getButtonStartText() {
        return this.buttonStartText;
    }

    @Nullable
    public final ButtonType getButtonType() {
        return this.buttonType;
    }

    @Nullable
    public final Integer getContentLayout() {
        return this.contentLayout;
    }

    @Nullable
    public final String getDetails() {
        return this.details;
    }

    @Nullable
    public final String getHeaderEndText() {
        return this.headerEndText;
    }

    @Nullable
    public final Drawable getHeaderFirstEndIcon() {
        return this.headerFirstEndIcon;
    }

    @Nullable
    public final Drawable getHeaderSecondEndIcon() {
        return this.headerSecondEndIcon;
    }

    @Nullable
    public final Drawable getHeaderStartIcon() {
        return this.headerStartIcon;
    }

    @Nullable
    public final String getHeaderTitle() {
        return this.headerTitle;
    }

    @Nullable
    public final Drawable getImage() {
        return this.image;
    }

    public final boolean getScrollEnabled() {
        return this.scrollEnabled;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final void setButtonCenterText(@Nullable String str) {
        this.buttonCenterText = str;
        ((TextView) findViewById(R.id.centerTextView)).setText(str);
        setupViewsVisibility();
    }

    public final void setButtonEndText(@Nullable String str) {
        this.buttonEndText = str;
        ((TextView) findViewById(R.id.endTextView)).setText(str);
        setupViewsVisibility();
    }

    public final void setButtonIcon(@Nullable Drawable drawable) {
        this.buttonIcon = drawable;
        setupViewsVisibility();
    }

    public final void setButtonStartText(@Nullable String str) {
        this.buttonStartText = str;
        ((TextView) findViewById(R.id.startTextView)).setText(str);
        setupViewsVisibility();
    }

    public final void setButtonType(@Nullable ButtonType buttonType2) {
        this.buttonType = buttonType2;
        setButtonViewAndVisibility();
    }

    public final void setContentLayout(@Nullable Integer num) {
        this.contentLayout = num;
        setupViewsVisibility();
    }

    public final void setDetails(@Nullable String str) {
        this.details = str;
        ((TextView) findViewById(R.id.bs_details)).setText(str);
        setupViewsVisibility();
    }

    public final void setHeaderEndText(@Nullable String str) {
        this.headerEndText = str;
        ((TextView) ((DSBottomSheetHeader) findViewById(R.id.bottom_sheet_header)).findViewById(R.id.bsh_end_text)).setText(str);
        setupViewsVisibility();
    }

    public final void setHeaderFirstEndIcon(@Nullable Drawable drawable) {
        this.headerFirstEndIcon = drawable;
        ((ImageView) ((DSBottomSheetHeader) findViewById(R.id.bottom_sheet_header)).findViewById(R.id.bsh_end_first_icon)).setImageDrawable(drawable);
        setupViewsVisibility();
    }

    public final void setHeaderSecondEndIcon(@Nullable Drawable drawable) {
        this.headerSecondEndIcon = drawable;
        ((ImageView) ((DSBottomSheetHeader) findViewById(R.id.bottom_sheet_header)).findViewById(R.id.bsh_end_second_icon)).setImageDrawable(drawable);
        setupViewsVisibility();
    }

    public final void setHeaderStartIcon(@Nullable Drawable drawable) {
        this.headerStartIcon = drawable;
        ((ImageView) ((DSBottomSheetHeader) findViewById(R.id.bottom_sheet_header)).findViewById(R.id.bsh_start_icon)).setImageDrawable(drawable);
        setupViewsVisibility();
    }

    public final void setHeaderTitle(@Nullable String str) {
        this.headerTitle = str;
        ((TextView) ((DSBottomSheetHeader) findViewById(R.id.bottom_sheet_header)).findViewById(R.id.bsh_title)).setText(str);
        setupViewsVisibility();
    }

    public final void setImage(@Nullable Drawable drawable) {
        this.image = drawable;
        ((ImageView) findViewById(R.id.bs_image)).setImageDrawable(drawable);
        setupViewsVisibility();
    }

    public final void setScrollEnabled(boolean z11) {
        this.scrollEnabled = z11;
        setupViewsVisibility();
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
        ((TextView) findViewById(R.id.bs_title)).setText(str);
        setupViewsVisibility();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBottomSheetContents(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scrollEnabled = true;
        LayoutInflater.from(context).inflate(R.layout.ds_bottom_sheet, this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSBottomSheetContents, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…ottomSheetContents, 0, 0)");
            setHeaderStartIcon(obtainStyledAttributes.getDrawable(R.styleable.DSBottomSheetContents_bs_header_start_icon));
            setHeaderTitle(obtainStyledAttributes.getString(R.styleable.DSBottomSheetContents_bs_header_title));
            setHeaderEndText(obtainStyledAttributes.getString(R.styleable.DSBottomSheetContents_bs_header_end_text));
            setHeaderFirstEndIcon(obtainStyledAttributes.getDrawable(R.styleable.DSBottomSheetContents_bs_header_end_first_icon));
            setHeaderSecondEndIcon(obtainStyledAttributes.getDrawable(R.styleable.DSBottomSheetContents_bs_header_end_second_icon));
            setTitle(obtainStyledAttributes.getString(R.styleable.DSBottomSheetContents_bs_title));
            setDetails(obtainStyledAttributes.getString(R.styleable.DSBottomSheetContents_bs_details));
            setImage(obtainStyledAttributes.getDrawable(R.styleable.DSBottomSheetContents_bs_image));
            setButtonEndText(obtainStyledAttributes.getString(R.styleable.DSBottomSheetContents_bs_button_end_text));
            setButtonStartText(obtainStyledAttributes.getString(R.styleable.DSBottomSheetContents_bs_button_start_text));
            setButtonCenterText(obtainStyledAttributes.getString(R.styleable.DSBottomSheetContents_bs_button_center_text));
            setButtonIcon(obtainStyledAttributes.getDrawable(R.styleable.DSBottomSheetContents_bs_button_icon));
            setContentLayout(Integer.valueOf(obtainStyledAttributes.getResourceId(R.styleable.DSBottomSheetContents_bs_content_layout, -1)));
            ButtonType[] values = ButtonType.values();
            String string = obtainStyledAttributes.getString(R.styleable.DSBottomSheetContents_bs_button_type);
            setButtonType(values[string == null ? 4 : Integer.parseInt(string)]);
            setScrollEnabled(obtainStyledAttributes.getBoolean(R.styleable.DSBottomSheetContents_bs_scroll_enabled, true));
            obtainStyledAttributes.recycle();
        }
    }
}
