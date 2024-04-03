package com.talabat.helpers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AlertDialog;
import com.talabat.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import zr.f;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/helpers/HelpCenterScreenUtils;", "", "()V", "startCall", "", "context", "Landroid/content/Context;", "contactNo", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterScreenUtils {
    @NotNull
    public static final HelpCenterScreenUtils INSTANCE = new HelpCenterScreenUtils();

    private HelpCenterScreenUtils() {
    }

    /* access modifiers changed from: private */
    /* renamed from: startCall$lambda-0  reason: not valid java name */
    public static final void m10624startCall$lambda0(String str, Context context, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(str, "$contactNo");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        context.startActivity(intent);
    }

    public final void startCall(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "contactNo");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle((int) R.string.call_us_dialog_title);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((int) R.string.call_us_dialog_call, (DialogInterface.OnClickListener) new f(str, context));
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }
}
