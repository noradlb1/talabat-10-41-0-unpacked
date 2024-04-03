package com.instabug.chat.ui;

import androidx.annotation.Nullable;
import com.instabug.chat.model.a;
import com.instabug.library.core.ui.BaseContract;

interface c extends BaseContract.View {
    void a(String str, a aVar);

    void c(String str);

    void i();

    @Nullable
    a m();

    @Nullable
    String q();
}
