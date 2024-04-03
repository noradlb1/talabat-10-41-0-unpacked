package com.instabug.survey.announcements.ui.fragment.versionupdate;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.survey.announcements.models.a;
import com.instabug.survey.announcements.models.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class f extends BasePresenter {
    public f(a aVar) {
        super(aVar);
    }

    private void a(a aVar) {
        if (aVar.c() != null) {
            Iterator it = aVar.c().iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.f() != null) {
                    cVar.a((String) cVar.f().get(0));
                }
            }
        }
    }

    public void a(c cVar) {
        a aVar;
        String g11 = cVar.g();
        String c11 = cVar.c();
        if (cVar.f() != null && cVar.f().size() > 0) {
            String str = (String) cVar.f().get(0);
            WeakReference<V> weakReference = this.f34200f;
            if (weakReference != null && (aVar = (a) weakReference.get()) != null) {
                aVar.a(g11, c11, str);
            }
        }
    }

    public void a(c cVar, a aVar) {
        a aVar2;
        a aVar3;
        if (c(cVar)) {
            WeakReference<V> weakReference = this.f34200f;
            if (!(weakReference == null || (aVar3 = (a) weakReference.get()) == null || cVar.a() == null || cVar.a().a() == null || cVar.a().a().a() == null)) {
                aVar3.a(cVar.a().a().a());
            }
        } else {
            WeakReference<V> weakReference2 = this.f34200f;
            if (!(weakReference2 == null || (aVar2 = (a) weakReference2.get()) == null)) {
                aVar2.d();
            }
        }
        a(aVar);
    }

    public void b(c cVar) {
        a aVar;
        String g11 = cVar.g();
        String c11 = cVar.c();
        if (cVar.f() != null && cVar.f().size() > 1) {
            String str = (String) cVar.f().get(0);
            String str2 = (String) cVar.f().get(1);
            WeakReference<V> weakReference = this.f34200f;
            if (weakReference != null && (aVar = (a) weakReference.get()) != null) {
                aVar.c(g11, c11, str, str2);
            }
        }
    }

    @VisibleForTesting
    public boolean c(c cVar) {
        return (cVar.a() == null || cVar.a().a() == null || cVar.a().a().a() == null || cVar.a().a().a().isEmpty()) ? false : true;
    }

    public void d(c cVar) {
        if (cVar.f() != null) {
            if (cVar.f().size() < 2) {
                a(cVar);
            } else {
                b(cVar);
            }
        }
    }
}
