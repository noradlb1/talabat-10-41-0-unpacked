package com.instabug.crash.cache;

import androidx.annotation.WorkerThread;
import com.instabug.crash.settings.b;
import com.instabug.library.Instabug;
import java.util.List;

public abstract class a {
    @WorkerThread
    public static void a() {
        b.a();
        b.a().a(false);
    }

    @WorkerThread
    public static void b() {
        if (Instabug.getApplicationContext() != null) {
            List a11 = b.a(Instabug.getApplicationContext());
            while (a11.size() > 100) {
                com.instabug.crash.models.a aVar = (com.instabug.crash.models.a) a11.get(0);
                if (!(aVar.h() == null || aVar.h().getUri() == null)) {
                    com.instabug.crash.utils.a.a(aVar.h().getUri());
                }
                com.instabug.crash.utils.a.a(aVar);
                if (aVar.e() != null) {
                    b.a(aVar.e());
                }
                a11.remove(0);
            }
        }
    }
}
