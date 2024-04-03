package com.talabat.helpers;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.compose.DialogNavigator;
import com.talabat.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import zr.g0;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0007¨\u0006\u000f"}, d2 = {"Lcom/talabat/helpers/UnableToValidateDetailsDialogFactory;", "", "()V", "createDialog", "Landroidx/appcompat/app/AlertDialog;", "context", "Landroid/content/Context;", "title", "", "message", "positiveButtonText", "onPositiveButtonClick", "Lkotlin/Function1;", "Landroid/content/DialogInterface;", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnableToValidateDetailsDialogFactory {
    @NotNull
    public static final UnableToValidateDetailsDialogFactory INSTANCE = new UnableToValidateDetailsDialogFactory();

    private UnableToValidateDetailsDialogFactory() {
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final AlertDialog createDialog(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "positiveButtonText");
        Intrinsics.checkNotNullParameter(function1, "onPositiveButtonClick");
        AlertDialog create = new AlertDialog.Builder(context, R.style.AlertDialogTheme).setTitle((CharSequence) str).setMessage((CharSequence) str2).setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) new g0(function1)).create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(context, com.tal…alog) }\n        .create()");
        return create;
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final AlertDialog createDialog(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(function1, "onPositiveButtonClick");
        return createDialog$default(context, str, str2, (String) null, function1, 8, (Object) null);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final AlertDialog createDialog(@NotNull Context context, @NotNull String str, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(function1, "onPositiveButtonClick");
        return createDialog$default(context, (String) null, str, (String) null, function1, 10, (Object) null);
    }

    public static /* synthetic */ AlertDialog createDialog$default(Context context, String str, String str2, String str3, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = context.getString(R.string.we_couldnt_validate_your_details);
            Intrinsics.checkNotNullExpressionValue(str, "context.getString(com.ta…nt_validate_your_details)");
        }
        if ((i11 & 8) != 0) {
            str3 = context.getString(R.string.try_again);
            Intrinsics.checkNotNullExpressionValue(str3, "context.getString(com.ta…ation.R.string.try_again)");
        }
        return createDialog(context, str, str2, str3, function1);
    }

    /* access modifiers changed from: private */
    /* renamed from: createDialog$lambda-0  reason: not valid java name */
    public static final void m10629createDialog$lambda0(Function1 function1, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(function1, "$onPositiveButtonClick");
        Intrinsics.checkNotNullExpressionValue(dialogInterface, DialogNavigator.NAME);
        function1.invoke(dialogInterface);
    }
}
