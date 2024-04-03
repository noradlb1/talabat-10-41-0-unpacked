package com.instabug.bug.view.reporting.feedback;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.instabug.bug.R;
import com.instabug.bug.view.reporting.h0;
import com.instabug.bug.view.reporting.x;

public class a extends x {
    @Nullable
    public static final String E = "com.instabug.bug.view.reporting.feedback.a";

    public static a h(@Nullable String str) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("bug_message", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    public int A0() {
        return R.string.ibg_suggestion_send_content_description;
    }

    public String j() {
        return getLocalizedString(R.string.IBGSuggestImprovementHint);
    }

    public String v() {
        return getLocalizedString(R.string.instabug_str_feedback_header);
    }

    public h0 w0() {
        return new b(this);
    }

    public int z0() {
        return R.string.ibg_core_ic_close_suggest_improvement_content_description;
    }
}
