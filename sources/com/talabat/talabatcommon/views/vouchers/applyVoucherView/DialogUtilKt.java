package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import com.talabat.talabatcommon.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sv.c;
import sv.d;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\b\b\u0001\u0010\r\u001a\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¨\u0006\u000f"}, d2 = {"showAlertDialog", "", "context", "Landroid/content/Context;", "themeResId", "", "title", "", "message", "", "positiveButtonTitleResId", "positiveButtonAction", "Lkotlin/Function0;", "negativeButtonTitleResId", "negativeButtonAction", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DialogUtilKt {
    public static final void showAlertDialog(@NotNull Context context, @StyleRes int i11, @NotNull String str, @NotNull CharSequence charSequence, @StringRes int i12, @Nullable Function0<Unit> function0, @StringRes int i13, @Nullable Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(charSequence, "message");
        new AlertDialog.Builder(context, i11).setTitle((CharSequence) str).setMessage(charSequence).setCancelable(true).setPositiveButton(i12, (DialogInterface.OnClickListener) new c(function0)).setNegativeButton(i13, (DialogInterface.OnClickListener) new d(function02)).show();
    }

    public static /* synthetic */ void showAlertDialog$default(Context context, int i11, String str, CharSequence charSequence, int i12, Function0 function0, int i13, Function0 function02, int i14, Object obj) {
        int i15;
        String str2;
        CharSequence charSequence2;
        Function0 function03;
        Function0 function04;
        int i16 = i14;
        if ((i16 & 2) != 0) {
            i15 = R.style.GreenAlertDialog;
        } else {
            i15 = i11;
        }
        if ((i16 & 4) != 0) {
            str2 = "";
        } else {
            str2 = str;
        }
        if ((i16 & 8) != 0) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence;
        }
        if ((i16 & 32) != 0) {
            function03 = null;
        } else {
            function03 = function0;
        }
        if ((i16 & 128) != 0) {
            function04 = null;
        } else {
            function04 = function02;
        }
        showAlertDialog(context, i15, str2, charSequence2, i12, function03, i13, function04);
    }

    /* access modifiers changed from: private */
    /* renamed from: showAlertDialog$lambda-0  reason: not valid java name */
    public static final void m5779showAlertDialog$lambda0(Function0 function0, DialogInterface dialogInterface, int i11) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showAlertDialog$lambda-1  reason: not valid java name */
    public static final void m5780showAlertDialog$lambda1(Function0 function0, DialogInterface dialogInterface, int i11) {
        if (function0 != null) {
            function0.invoke();
        }
    }
}
