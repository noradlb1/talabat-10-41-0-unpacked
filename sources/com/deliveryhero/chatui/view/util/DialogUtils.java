package com.deliveryhero.chatui.view.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import v4.a;
import v4.b;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J^\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/chatui/view/util/DialogUtils;", "", "()V", "DEFAULT_DIALOG_HEIGHT", "", "DEFAULT_DIALOG_WIDTH", "showDialog", "", "context", "Landroid/content/Context;", "title", "", "message", "positiveButtonTitle", "negativeButtonTitle", "positiveButtonClick", "Lkotlin/Function0;", "negativeButtonClick", "isCancelable", "", "shouldDismissOnNegativeAction", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogUtils {
    public static final int DEFAULT_DIALOG_HEIGHT = 400;
    public static final int DEFAULT_DIALOG_WIDTH = 600;
    @NotNull
    public static final DialogUtils INSTANCE = new DialogUtils();

    private DialogUtils() {
    }

    public static /* synthetic */ void showDialog$default(DialogUtils dialogUtils, Context context, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, boolean z11, boolean z12, int i11, Object obj) {
        int i12 = i11;
        dialogUtils.showDialog(context, str, str2, str3, str4, function0, function02, (i12 & 128) != 0 ? false : z11, (i12 & 256) != 0 ? true : z12);
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-0  reason: not valid java name */
    public static final void m8172showDialog$lambda0(Function0 function0, boolean z11, AlertDialog alertDialog, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(function0, "$negativeButtonClick");
        Intrinsics.checkNotNullParameter(alertDialog, "$alertDialog");
        function0.invoke();
        if (z11) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-1  reason: not valid java name */
    public static final void m8173showDialog$lambda1(Function0 function0, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(function0, "$positiveButtonClick");
        function0.invoke();
    }

    public final void showDialog(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "positiveButtonTitle");
        Intrinsics.checkNotNullParameter(str4, "negativeButtonTitle");
        Intrinsics.checkNotNullParameter(function0, "positiveButtonClick");
        Intrinsics.checkNotNullParameter(function02, "negativeButtonClick");
        AlertDialog create = new AlertDialog.Builder(context).create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(context)\n            .create()");
        create.setTitle(str);
        create.setMessage(str2);
        create.setCancelable(z11);
        create.setButton(-2, str4, new a(function02, z12, create));
        create.setButton(-1, str3, new b(function0));
        create.show();
    }
}
