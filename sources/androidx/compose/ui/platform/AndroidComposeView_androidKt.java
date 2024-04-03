package androidx.compose.ui.platform;

import android.content.res.Configuration;
import androidx.annotation.RestrictTo;
import androidx.compose.ui.InternalComposeUiApi;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a5\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0014H\u0002\u001a!\u0010\u001b\u001a\u00020\u001c*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\"0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00018\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"textInputServiceFactory", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputServiceFactory$annotations", "()V", "getTextInputServiceFactory", "()Lkotlin/jvm/functions/Function1;", "setTextInputServiceFactory", "(Lkotlin/jvm/functions/Function1;)V", "localeLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroid/content/res/Configuration;", "getLocaleLayoutDirection", "(Landroid/content/res/Configuration;)Landroidx/compose/ui/unit/LayoutDirection;", "dot", "", "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "layoutDirectionFromInt", "layoutDirection", "preTransform", "", "other", "preTransform-JiSxe2E", "([F[F)V", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidComposeView_androidKt {
    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static Function1<? super PlatformTextInputService, ? extends TextInputService> textInputServiceFactory = AndroidComposeView_androidKt$textInputServiceFactory$1.INSTANCE;

    /* renamed from: dot-p89u6pk  reason: not valid java name */
    private static final float m4816dotp89u6pk(float[] fArr, int i11, float[] fArr2, int i12) {
        int i13 = i11 * 4;
        return (fArr[i13 + 0] * fArr2[0 + i12]) + (fArr[i13 + 1] * fArr2[4 + i12]) + (fArr[i13 + 2] * fArr2[8 + i12]) + (fArr[i13 + 3] * fArr2[12 + i12]);
    }

    @NotNull
    public static final LayoutDirection getLocaleLayoutDirection(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        return layoutDirectionFromInt(configuration.getLayoutDirection());
    }

    @NotNull
    public static final Function1<PlatformTextInputService, TextInputService> getTextInputServiceFactory() {
        return textInputServiceFactory;
    }

    @InternalComposeUiApi
    public static /* synthetic */ void getTextInputServiceFactory$annotations() {
    }

    /* access modifiers changed from: private */
    public static final LayoutDirection layoutDirectionFromInt(int i11) {
        if (i11 == 0) {
            return LayoutDirection.Ltr;
        }
        if (i11 != 1) {
            return LayoutDirection.Ltr;
        }
        return LayoutDirection.Rtl;
    }

    /* access modifiers changed from: private */
    /* renamed from: preTransform-JiSxe2E  reason: not valid java name */
    public static final void m4817preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        float r32 = m4816dotp89u6pk(fArr4, 0, fArr3, 0);
        float r52 = m4816dotp89u6pk(fArr4, 0, fArr3, 1);
        float r72 = m4816dotp89u6pk(fArr4, 0, fArr3, 2);
        float r92 = m4816dotp89u6pk(fArr4, 0, fArr3, 3);
        float r102 = m4816dotp89u6pk(fArr4, 1, fArr3, 0);
        float r11 = m4816dotp89u6pk(fArr4, 1, fArr3, 1);
        float r12 = m4816dotp89u6pk(fArr4, 1, fArr3, 2);
        float r13 = m4816dotp89u6pk(fArr4, 1, fArr3, 3);
        float r14 = m4816dotp89u6pk(fArr4, 2, fArr3, 0);
        float r15 = m4816dotp89u6pk(fArr4, 2, fArr3, 1);
        float r16 = m4816dotp89u6pk(fArr4, 2, fArr3, 2);
        float r17 = m4816dotp89u6pk(fArr4, 2, fArr3, 3);
        float r18 = m4816dotp89u6pk(fArr4, 3, fArr3, 0);
        float r19 = m4816dotp89u6pk(fArr4, 3, fArr3, 1);
        float r202 = m4816dotp89u6pk(fArr4, 3, fArr3, 2);
        float r110 = m4816dotp89u6pk(fArr4, 3, fArr3, 3);
        fArr3[0] = r32;
        fArr3[1] = r52;
        fArr3[2] = r72;
        fArr3[3] = r92;
        fArr3[4] = r102;
        fArr3[5] = r11;
        fArr3[6] = r12;
        fArr3[7] = r13;
        fArr3[8] = r14;
        fArr3[9] = r15;
        fArr3[10] = r16;
        fArr3[11] = r17;
        fArr3[12] = r18;
        fArr3[13] = r19;
        fArr3[14] = r202;
        fArr3[15] = r110;
    }

    public static final void setTextInputServiceFactory(@NotNull Function1<? super PlatformTextInputService, ? extends TextInputService> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        textInputServiceFactory = function1;
    }
}
