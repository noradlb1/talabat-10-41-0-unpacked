package com.instabug.bug.view.reporting;

import android.app.Activity;
import android.content.Context;
import android.text.Spanned;
import androidx.annotation.StringRes;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.model.Attachment;
import java.util.List;

public interface i0 extends BaseContract.View {
    void C();

    void a();

    void a(Spanned spanned);

    void a(Spanned spanned, String str);

    void a(Attachment attachment);

    void a(List list);

    void b();

    void b(String str);

    void b(boolean z11);

    Activity c();

    void c(String str);

    void d();

    void d(String str);

    void e();

    void e(String str);

    void f();

    Context getContext();

    String getLocalizedString(@StringRes int i11);

    String j();

    String k();

    void p();

    String s();

    void t();

    void u();

    String v();

    void x();

    void z();
}
