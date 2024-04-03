package com.instabug.survey.ui.popup;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;

public class k extends n {
    public static k h(Survey survey) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_SURVEY_ARGUMENT", survey);
        k kVar = new k();
        kVar.setArguments(bundle);
        return kVar;
    }

    public void a(@Nullable String str, @Nullable String str2, String str3, String str4) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            new e(activity).a(R.layout.instabug_custom_app_rating_feedback).a(str2).c(str3).b(str4).a((f) new i(this)).a();
        }
    }

    public void b(@Nullable String str, @Nullable String str2, String str3, String str4) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            new e(activity).a(R.layout.instabug_custom_store_rating).a(str2).c(str3).b(str4).a((f) new j(this)).a();
        }
    }
}
