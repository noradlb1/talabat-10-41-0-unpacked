package com.instabug.bug.view.reporting.bugreporting;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.instabug.bug.R;
import com.instabug.bug.view.reporting.h0;
import com.instabug.bug.view.reporting.x;

public class a extends x {
    public static final String E = "a";

    public static a h(@Nullable String str) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("bug_message", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    public int A0() {
        return R.string.ibg_report_send_content_description;
    }

    public String j() {
        return getLocalizedString(R.string.IBGReportBugHint);
    }

    public String v() {
        return getLocalizedString(R.string.IBGPromptOptionsReportBug);
    }

    public h0 w0() {
        return new b(this);
    }

    public int z0() {
        return R.string.ibg_core_ic_close_bug_report_content_description;
    }
}
