package com.instabug.bug;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.bug.view.reporting.ReportingContainerActivity;
import com.instabug.library.invocation.invocationdialog.InstabugDialogActivity;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class p {
    public static Intent a(Context context) {
        Intent intent = new Intent(context, ReportingContainerActivity.class);
        intent.putExtra("com.instabug.library.process", Opcodes.IF_ICMPGT);
        intent.setFlags(268435456);
        intent.addFlags(65536);
        return intent;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static Intent a(Context context, @Nullable Uri uri) {
        Intent d11 = d(context);
        d11.putExtra(InstabugDialogActivity.KEY_SCREENSHOT_URI, uri);
        return d11;
    }

    public static Intent b(Context context) {
        Intent intent = new Intent(context, ReportingContainerActivity.class);
        intent.putExtra("com.instabug.library.process", Opcodes.IF_ICMPGE);
        intent.setFlags(268435456);
        intent.addFlags(65536);
        return intent;
    }

    public static Intent c(Context context) {
        Intent intent = new Intent(context, ReportingContainerActivity.class);
        intent.putExtra("com.instabug.library.process", Opcodes.IF_ICMPLT);
        intent.setFlags(268435456);
        intent.addFlags(65536);
        return intent;
    }

    public static Intent d(Context context) {
        Intent intent = new Intent(context, ReportingContainerActivity.class);
        intent.putExtra("com.instabug.library.process", Opcodes.GOTO);
        intent.addFlags(65536);
        intent.addFlags(268435456);
        return intent;
    }
}
