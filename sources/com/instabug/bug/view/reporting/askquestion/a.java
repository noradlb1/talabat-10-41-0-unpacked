package com.instabug.bug.view.reporting.askquestion;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.instabug.bug.R;
import com.instabug.bug.view.reporting.h0;
import com.instabug.bug.view.reporting.x;
import com.instabug.library.util.InstabugSDKLogger;

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
        return R.string.ibg_question_send_content_description;
    }

    public String j() {
        if (isAdded()) {
            return getLocalizedString(R.string.IBGAskQuestionHint);
        }
        InstabugSDKLogger.v("IBG-BR", "failed to provideDefaultHintMessage, fragment not attached yet");
        return "";
    }

    public String v() {
        if (isAdded()) {
            return getLocalizedString(R.string.askAQuestionHeader);
        }
        InstabugSDKLogger.v("IBG-BR", "failed to provideDefaultTitle, fragment not attached yet");
        return "";
    }

    public h0 w0() {
        return new b(this);
    }

    public int z0() {
        return R.string.ibg_core_ic_close_ask_question_content_description;
    }
}
