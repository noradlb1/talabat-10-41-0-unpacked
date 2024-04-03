package com.instabug.featuresrequest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.featuresrequest.ui.FeaturesRequestActivity;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.invocation.invocationdialog.InstabugDialogActivity;
import com.instabug.library.invocation.invocationdialog.InstabugDialogItem;
import java.util.ArrayList;

class b implements PluginPromptOption.OnInvocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f46516a;

    public b(Context context) {
        this.f46516a = context;
    }

    public void onInvoke(@Nullable Uri uri, String... strArr) {
        this.f46516a.startActivity(InstabugDialogActivity.getIntent(this.f46516a, (String) null, (Uri) null, (ArrayList<InstabugDialogItem>) null, true));
        Intent intent = new Intent(this.f46516a, FeaturesRequestActivity.class);
        intent.addFlags(268435456);
        this.f46516a.startActivity(intent);
    }
}
