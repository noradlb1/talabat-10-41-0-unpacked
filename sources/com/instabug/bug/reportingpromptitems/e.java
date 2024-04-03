package com.instabug.bug.reportingpromptitems;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.bug.R;
import com.instabug.bug.model.ReportCategory;
import com.instabug.bug.n;
import com.instabug.bug.p;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.invocation.invocationdialog.InstabugDialogActivity;
import com.instabug.library.invocation.invocationdialog.InstabugDialogItem;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;
import java.util.ArrayList;

public class e extends c {
    public PluginPromptOption a(Context context) {
        PluginPromptOption pluginPromptOption = new PluginPromptOption();
        pluginPromptOption.setOrder(0);
        pluginPromptOption.setInvocationMode(1);
        pluginPromptOption.setIcon(R.drawable.ibg_core_ic_report_bug);
        pluginPromptOption.setPromptOptionIdentifier(0);
        pluginPromptOption.setTitle(i(context));
        pluginPromptOption.setDescription(h(context));
        pluginPromptOption.setOnInvocationListener(new d(this, context));
        pluginPromptOption.setInitialScreenshotRequired(true);
        pluginPromptOption.setSubOptions(b("bug"));
        return pluginPromptOption;
    }

    public PluginPromptOption a(ReportCategory reportCategory, @Nullable PluginPromptOption pluginPromptOption, String str, int i11) {
        PluginPromptOption a11 = super.a(reportCategory, pluginPromptOption, str, i11);
        a11.setInvocationMode(1);
        a11.setPromptOptionIdentifier(0);
        return a11;
    }

    public void d(Context context) {
        context.startActivity(p.b(context));
    }

    public void g(Context context, @Nullable Uri uri, String... strArr) {
        c.d();
        InstabugSDKLogger.v("IBG-BR", "Handle invocation request new bug");
        c.e(uri);
        if (n.e().c() != null) {
            n.e().c().a(new ArrayList());
            n.e().c().a("Report a problem");
            for (String a11 : strArr) {
                n.e().c().a(a11);
            }
        }
        c.f();
        context.startActivity(InstabugDialogActivity.getIntent(context, (String) null, (Uri) null, (ArrayList<InstabugDialogItem>) null, true));
        d(context);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String h(Context context) {
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.REPORT_BUG_DESCRIPTION, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), R.string.ib_bug_report_bug_description, context));
    }

    @VisibleForTesting
    @NonNull
    public String i(Context context) {
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.REPORT_BUG, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), R.string.IBGPromptOptionsReportBug, context));
    }
}
