package com.instabug.library.ui.onboarding;

import androidx.annotation.StringRes;
import com.instabug.library.core.ui.BaseContract;
import java.util.List;

public interface b extends BaseContract.View {
    void a();

    void a(List list);

    void c();

    void dismiss();

    String getLocalizedString(@StringRes int i11);
}
