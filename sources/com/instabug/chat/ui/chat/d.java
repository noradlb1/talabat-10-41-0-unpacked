package com.instabug.chat.ui.chat;

import android.content.Intent;
import android.net.Uri;
import com.instabug.chat.model.a;
import com.instabug.chat.model.k;
import com.instabug.library.core.ui.BaseContract;
import java.util.List;

interface d extends BaseContract.Presenter {
    a a(Uri uri, String str);

    k a(String str, a aVar);

    k a(String str, String str2);

    List a(List list);

    void a();

    void a(int i11, int i12, Intent intent);

    void a(Intent intent);

    void a(a aVar);

    void a(k kVar);

    void b(String str);

    void c();

    com.instabug.chat.model.d d();

    void e();

    void h();

    void j();
}
