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

public class g extends c {
    private void d(Context context) {
        context.startActivity(p.c(context));
    }

    public PluginPromptOption a(Context context) {
        PluginPromptOption pluginPromptOption = new PluginPromptOption();
        pluginPromptOption.setOrder(1);
        pluginPromptOption.setInvocationMode(2);
        pluginPromptOption.setPromptOptionIdentifier(1);
        pluginPromptOption.setIcon(R.drawable.ibg_core_ic_suggest_improvment);
        pluginPromptOption.setTitle(i(context));
        pluginPromptOption.setDescription(h(context));
        pluginPromptOption.setOnInvocationListener(new f(this, context));
        pluginPromptOption.setInitialScreenshotRequired(true);
        pluginPromptOption.setSubOptions(b("feedback"));
        return pluginPromptOption;
    }

    public PluginPromptOption a(ReportCategory reportCategory, @Nullable PluginPromptOption pluginPromptOption, String str, int i11) {
        PluginPromptOption a11 = super.a(reportCategory, pluginPromptOption, str, i11);
        a11.setInvocationMode(2);
        a11.setPromptOptionIdentifier(1);
        return a11;
    }

    public void g(Context context, @Nullable Uri uri, String... strArr) {
        c.d();
        InstabugSDKLogger.v("IBG-BR", "Handle invocation request new feedback");
        c.e(uri);
        if (n.e().c() != null) {
            n.e().c().a(new ArrayList());
            n.e().c().a("Suggest an Improvement");
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
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.REPORT_FEEDBACK_DESCRIPTION, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), R.string.ib_bug_report_feedback_description, context));
    }

    @VisibleForTesting
    @NonNull
    public String i(Context context) {
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.REPORT_FEEDBACK, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), R.string.instabug_str_feedback_header, context));
    }
}
