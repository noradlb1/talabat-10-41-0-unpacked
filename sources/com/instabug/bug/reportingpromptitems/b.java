package com.instabug.bug.reportingpromptitems;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.bug.model.ReportCategory;
import com.instabug.bug.n;
import com.instabug.bug.p;
import com.instabug.chat.R;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.invocation.invocationdialog.InstabugDialogActivity;
import com.instabug.library.invocation.invocationdialog.InstabugDialogItem;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;
import java.util.ArrayList;

public class b extends c {
    public PluginPromptOption a(Context context) {
        PluginPromptOption pluginPromptOption = new PluginPromptOption();
        pluginPromptOption.setOrder(2);
        pluginPromptOption.setInvocationMode(3);
        pluginPromptOption.setInitialScreenshotRequired(true);
        pluginPromptOption.setIcon(R.drawable.ibg_core_ic_question);
        pluginPromptOption.setPromptOptionIdentifier(3);
        pluginPromptOption.setTitle(i(context));
        pluginPromptOption.setDescription(h(context));
        pluginPromptOption.setOnInvocationListener(new a(this, context));
        pluginPromptOption.setSubOptions(b("ask a question"));
        return pluginPromptOption;
    }

    public PluginPromptOption a(ReportCategory reportCategory, @Nullable PluginPromptOption pluginPromptOption, String str, int i11) {
        PluginPromptOption a11 = super.a(reportCategory, pluginPromptOption, str, i11);
        a11.setInvocationMode(3);
        a11.setPromptOptionIdentifier(3);
        return a11;
    }

    public void d(Context context) {
        context.startActivity(p.a(context));
    }

    public void g(Context context, @Nullable Uri uri, String... strArr) {
        c.d();
        InstabugSDKLogger.v("IBG-BR", "Handle invocation ask a question ");
        c.e(uri);
        if (n.e().c() != null) {
            n.e().c().a(new ArrayList());
            n.e().c().a("Ask a Question");
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
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.REPORT_QUESTION_DESCRIPTION, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), com.instabug.library.R.string.ib_bug_report_question_description, context));
    }

    @VisibleForTesting
    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String i(Context context) {
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.REPORT_QUESTION, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), com.instabug.library.R.string.askAQuestionHeader, context));
    }
}
