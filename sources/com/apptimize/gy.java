package com.apptimize;

import android.app.Dialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.apptimize.bq;
import com.apptimize.gn;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class gy {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42864a = "gy";

    /* renamed from: b  reason: collision with root package name */
    private au f42865b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<b> f42866c = new ArrayList();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Object f42871a;

        public Object a() {
            return this.f42871a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f42871a.equals(((a) obj).f42871a);
        }

        public int hashCode() {
            return this.f42871a.hashCode();
        }

        private a(Object obj) {
            this.f42871a = obj;
        }
    }

    public interface b {
        void a(a aVar);

        void a(a aVar, View view);
    }

    public gy(gp gpVar, au auVar) {
        this.f42865b = auVar;
        b();
        c();
    }

    private void b() {
        Class<PopupWindow> cls = PopupWindow.class;
        if (gn.w()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("invokePopup", new Class[]{WindowManager.LayoutParams.class});
                AnonymousClass1 r22 = new gk() {
                    public void a(Method method, Object obj, Object[] objArr) {
                        if (!(obj instanceof PopupWindow)) {
                            bo.e(gy.f42864a, String.format("Unexpected %s; expecting PopupWindow", new Object[]{obj}));
                            return;
                        }
                        View a11 = js.a(obj);
                        for (b a12 : gy.this.f42866c) {
                            a12.a(new a(obj), a11);
                        }
                    }
                };
                gn.b bVar = gn.b.f42666d;
                gn.c(declaredMethod, r22, bVar);
                gn.c(cls.getDeclaredMethod("dismiss", new Class[0]), new gk() {
                    public void a(Method method, Object obj, Object[] objArr) {
                        if (!(obj instanceof PopupWindow)) {
                            bo.e(gy.f42864a, String.format("Unexpected %s; expecting PopupWindow", new Object[]{obj}));
                            return;
                        }
                        for (b a11 : gy.this.f42866c) {
                            a11.a(new a(obj));
                        }
                    }
                }, bVar);
            } catch (NoSuchMethodException e11) {
                this.f42865b.a().a(bq.b.UnexpectedException, (Exception) e11);
                bo.b(f42864a, "Could not find method: ", e11);
            } catch (Throwable th2) {
                gn.x();
                throw th2;
            }
            gn.x();
        }
    }

    private void c() {
        Class<Dialog> cls = Dialog.class;
        if (gn.w()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("show", new Class[0]);
                AnonymousClass3 r32 = new gk() {
                    public void a(Method method, Object obj, Object[] objArr) {
                        if (!(obj instanceof Dialog)) {
                            bo.e(gy.f42864a, String.format("Unexpected %s; expecting PopupWindow", new Object[]{obj}));
                            return;
                        }
                        View a11 = js.a(obj);
                        for (b a12 : gy.this.f42866c) {
                            a12.a(new a(obj), a11);
                        }
                    }
                };
                gn.b bVar = gn.b.f42666d;
                gn.c(declaredMethod, r32, bVar);
                gn.c(cls.getDeclaredMethod("dismissDialog", new Class[0]), new gk() {
                    public void a(Method method, Object obj, Object[] objArr) {
                        if (!(obj instanceof Dialog)) {
                            bo.e(gy.f42864a, String.format("Unexpected %s; expecting PopupWindow", new Object[]{obj}));
                            return;
                        }
                        for (b a11 : gy.this.f42866c) {
                            a11.a(new a(obj));
                        }
                    }
                }, bVar);
            } catch (NoSuchMethodException e11) {
                this.f42865b.a().a(bq.b.UnexpectedException, (Exception) e11);
                bo.b(f42864a, "Could not find method: ", e11);
            } catch (Throwable th2) {
                gn.x();
                throw th2;
            }
            gn.x();
        }
    }

    public void a(b bVar) {
        this.f42866c.add(bVar);
    }
}
