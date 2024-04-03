package com.instabug.chat;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.invocation.invocationdialog.InstabugDialogActivity;
import com.instabug.library.invocation.invocationdialog.InstabugDialogItem;
import java.util.ArrayList;

class a implements PluginPromptOption.OnInvocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f46003a;

    public a(Context context) {
        this.f46003a = context;
    }

    public void onInvoke(@Nullable Uri uri, String... strArr) {
        this.f46003a.startActivity(InstabugDialogActivity.getIntent(this.f46003a, (String) null, (Uri) null, (ArrayList<InstabugDialogItem>) null, true));
        f.e();
    }
}
