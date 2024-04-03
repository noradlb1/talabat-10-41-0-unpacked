package com.instabug.survey.ui.popup;

import androidx.annotation.Nullable;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.survey.models.Survey;

public interface m extends BaseContract.View {
    void a(Survey survey);

    void a(@Nullable String str, @Nullable String str2, String str3, String str4);

    void b(Survey survey);

    void b(@Nullable String str, @Nullable String str2, String str3, String str4);

    void c(Survey survey);

    void d(Survey survey);

    void e(Survey survey);

    void g(Survey survey);
}
