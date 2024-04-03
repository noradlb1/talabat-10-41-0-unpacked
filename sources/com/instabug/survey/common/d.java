package com.instabug.survey.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.PresentationManager;
import com.instabug.survey.announcements.models.a;
import com.instabug.survey.cache.l;
import com.instabug.survey.models.Survey;

public class d {

    /* renamed from: c  reason: collision with root package name */
    private static d f52320c;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public Runnable f52321a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Runnable f52322b;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f52320c == null) {
                f52320c = new d();
            }
            dVar = f52320c;
        }
        return dVar;
    }

    /* access modifiers changed from: private */
    public boolean a(long j11) {
        Survey b11 = l.b(j11);
        return b11 != null && b11.shouldShow();
    }

    public void a(a aVar) {
        this.f52321a = new a(this, aVar);
        PresentationManager.getInstance().show(this.f52321a);
    }

    public void a(@NonNull Survey survey) {
        this.f52322b = new c(this, survey);
        PresentationManager.getInstance().show(this.f52322b);
    }

    public void a(boolean z11) {
    }

    public void b() {
        this.f52322b = null;
        this.f52321a = null;
    }

    public void b(boolean z11) {
    }
}
