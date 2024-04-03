package com.instabug.bug.reportingpromptitems;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.bug.BugPlugin;
import com.instabug.bug.model.ReportCategory;
import com.instabug.bug.n;
import com.instabug.bug.screenshot.viewhierarchy.a;
import com.instabug.bug.settings.b;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.memory.MemoryUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class c {
    @SuppressLint({"NULL_DEREFERENCE"})
    public static void d() {
        if (InstabugCore.getOnSdkInvokedCallback() != null) {
            InstabugCore.getOnSdkInvokedCallback().onSdkInvoked();
        }
    }

    public static void e(@Nullable Uri uri) {
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (!(bugPlugin == null || bugPlugin.getAppContext() == null)) {
            n.e().d(bugPlugin.getAppContext());
        }
        if (uri != null && b.f().a().d() && n.e().c() != null) {
            n.e().c().c(uri.getPath());
        }
    }

    public static void f() {
        Activity targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
        if (targetActivity != null && n.e().c() != null && n.e().c().n() && !MemoryUtils.isLowMemory(targetActivity)) {
            a.a(targetActivity);
        }
    }

    public PluginPromptOption a(ReportCategory reportCategory, @Nullable PluginPromptOption pluginPromptOption, String str, int i11) {
        PluginPromptOption pluginPromptOption2 = new PluginPromptOption();
        pluginPromptOption2.setOrder(i11);
        pluginPromptOption2.setTitle(reportCategory.getLabel());
        pluginPromptOption2.setDescription(reportCategory.getDescription());
        pluginPromptOption2.setInitialScreenshotRequired(true);
        pluginPromptOption2.setParent(pluginPromptOption);
        pluginPromptOption2.setSubOptions(c(reportCategory.getSubs(), pluginPromptOption2, str));
        return pluginPromptOption2;
    }

    public ArrayList b(String str) {
        return c(ReportCategory.getSubReportCategories(str), (PluginPromptOption) null, str);
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public ArrayList c(@Nullable List list, @Nullable PluginPromptOption pluginPromptOption, String str) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (true) {
            if (i11 >= (list != null ? list.size() : 0)) {
                return arrayList;
            }
            arrayList.add(a((ReportCategory) list.get(i11), pluginPromptOption, str, i11));
            i11++;
        }
    }
}
