package com.iab.omid.library.deliveryhero3.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.deliveryhero3.processor.a;
import com.iab.omid.library.deliveryhero3.utils.f;
import com.iab.omid.library.deliveryhero3.utils.h;
import com.iab.omid.library.deliveryhero3.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements a.C0050a {

    /* renamed from: i  reason: collision with root package name */
    private static TreeWalker f45005i = new TreeWalker();

    /* renamed from: j  reason: collision with root package name */
    private static Handler f45006j = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static Handler f45007k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Runnable f45008l = new b();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Runnable f45009m = new c();

    /* renamed from: a  reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f45010a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f45011b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45012c = false;

    /* renamed from: d  reason: collision with root package name */
    private final List<com.iab.omid.library.deliveryhero3.weakreference.a> f45013d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private com.iab.omid.library.deliveryhero3.processor.b f45014e = new com.iab.omid.library.deliveryhero3.processor.b();

    /* renamed from: f  reason: collision with root package name */
    private a f45015f = new a();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f45016g = new b(new com.iab.omid.library.deliveryhero3.walking.async.c());

    /* renamed from: h  reason: collision with root package name */
    private long f45017h;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i11, long j11);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i11, long j11);
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            TreeWalker.this.f45016g.b();
        }
    }

    public class b implements Runnable {
        public void run() {
            TreeWalker.getInstance().l();
        }
    }

    public class c implements Runnable {
        public void run() {
            if (TreeWalker.f45007k != null) {
                TreeWalker.f45007k.post(TreeWalker.f45008l);
                TreeWalker.f45007k.postDelayed(TreeWalker.f45009m, 200);
            }
        }
    }

    private void a(long j11) {
        if (this.f45010a.size() > 0) {
            for (TreeWalkerTimeLogger next : this.f45010a) {
                next.onTreeProcessed(this.f45011b, TimeUnit.NANOSECONDS.toMillis(j11));
                if (next instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) next).onTreeProcessedNano(this.f45011b, j11);
                }
            }
        }
    }

    private void a(View view, com.iab.omid.library.deliveryhero3.processor.a aVar, JSONObject jSONObject, c cVar, boolean z11) {
        aVar.a(view, jSONObject, this, cVar == c.PARENT_VIEW, z11);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.deliveryhero3.processor.a b11 = this.f45014e.b();
        String b12 = this.f45015f.b(str);
        if (b12 != null) {
            JSONObject a11 = b11.a(view);
            com.iab.omid.library.deliveryhero3.utils.c.a(a11, str);
            com.iab.omid.library.deliveryhero3.utils.c.b(a11, b12);
            com.iab.omid.library.deliveryhero3.utils.c.a(jSONObject, a11);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        a.C0052a c11 = this.f45015f.c(view);
        if (c11 == null) {
            return false;
        }
        com.iab.omid.library.deliveryhero3.utils.c.a(jSONObject, c11);
        return true;
    }

    private boolean b(View view, JSONObject jSONObject) {
        String d11 = this.f45015f.d(view);
        if (d11 == null) {
            return false;
        }
        com.iab.omid.library.deliveryhero3.utils.c.a(jSONObject, d11);
        com.iab.omid.library.deliveryhero3.utils.c.a(jSONObject, Boolean.valueOf(this.f45015f.f(view)));
        this.f45015f.d();
        return true;
    }

    private void d() {
        a(f.b() - this.f45017h);
    }

    private void e() {
        this.f45011b = 0;
        this.f45013d.clear();
        this.f45012c = false;
        Iterator<com.iab.omid.library.deliveryhero3.adsession.a> it = com.iab.omid.library.deliveryhero3.internal.c.c().a().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().e()) {
                    this.f45012c = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.f45017h = f.b();
    }

    public static TreeWalker getInstance() {
        return f45005i;
    }

    private void i() {
        if (f45007k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f45007k = handler;
            handler.post(f45008l);
            f45007k.postDelayed(f45009m, 200);
        }
    }

    private void k() {
        Handler handler = f45007k;
        if (handler != null) {
            handler.removeCallbacks(f45009m);
            f45007k = null;
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        e();
        m();
        d();
    }

    public void a(View view, com.iab.omid.library.deliveryhero3.processor.a aVar, JSONObject jSONObject, boolean z11) {
        c e11;
        if (h.d(view) && (e11 = this.f45015f.e(view)) != c.UNDERLYING_VIEW) {
            JSONObject a11 = aVar.a(view);
            com.iab.omid.library.deliveryhero3.utils.c.a(jSONObject, a11);
            if (!b(view, a11)) {
                boolean z12 = z11 || a(view, a11);
                if (this.f45012c && e11 == c.OBSTRUCTION_VIEW && !z12) {
                    this.f45013d.add(new com.iab.omid.library.deliveryhero3.weakreference.a(view));
                }
                a(view, aVar, a11, e11, z12);
            }
            this.f45011b++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (!this.f45010a.contains(treeWalkerTimeLogger)) {
            this.f45010a.add(treeWalkerTimeLogger);
        }
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f45010a.clear();
        f45006j.post(new a());
    }

    @VisibleForTesting
    public void m() {
        this.f45015f.e();
        long b11 = f.b();
        com.iab.omid.library.deliveryhero3.processor.a a11 = this.f45014e.a();
        if (this.f45015f.b().size() > 0) {
            Iterator<String> it = this.f45015f.b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a12 = a11.a((View) null);
                a(next, this.f45015f.a(next), a12);
                com.iab.omid.library.deliveryhero3.utils.c.b(a12);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.f45016g.a(a12, hashSet, b11);
            }
        }
        if (this.f45015f.c().size() > 0) {
            JSONObject a13 = a11.a((View) null);
            a((View) null, a11, a13, c.PARENT_VIEW, false);
            com.iab.omid.library.deliveryhero3.utils.c.b(a13);
            this.f45016g.b(a13, this.f45015f.c(), b11);
            if (this.f45012c) {
                for (com.iab.omid.library.deliveryhero3.adsession.a a14 : com.iab.omid.library.deliveryhero3.internal.c.c().a()) {
                    a14.a(this.f45013d);
                }
            }
        } else {
            this.f45016g.b();
        }
        this.f45015f.a();
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f45010a.contains(treeWalkerTimeLogger)) {
            this.f45010a.remove(treeWalkerTimeLogger);
        }
    }
}
