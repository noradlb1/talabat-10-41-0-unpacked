package com.apptimize;

import android.widget.AbsListView;
import android.widget.AbsSpinner;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import com.apptimize.bq;
import com.apptimize.gn;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class gs {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42805a = "gs";

    /* renamed from: b  reason: collision with root package name */
    private final Map<Adapter, List<gt>> f42806b = new WeakHashMap();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public hg f42807c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public gp f42808d;

    /* renamed from: e  reason: collision with root package name */
    private au f42809e;

    public class a extends gk {
        private a() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            if (obj instanceof AdapterView) {
                AdapterView adapterView = (AdapterView) obj;
                hf b11 = gs.this.f42807c.b(adapterView);
                if (b11 == null) {
                    String a11 = gs.f42805a;
                    bo.a(a11, "No node for " + adapterView);
                } else if (!(b11 instanceof gt)) {
                    bo.e(gs.f42805a, String.format("Unexpected view node %s for adapter view %s", new Object[]{b11, adapterView}));
                } else {
                    final gt gtVar = (gt) b11;
                    gs.this.f42808d.a((fi) new fi() {
                        public void run() {
                            gtVar.f();
                        }
                    });
                }
            }
        }
    }

    public gs(hg hgVar, au auVar) {
        this.f42807c = hgVar;
        this.f42808d = hgVar.b();
        this.f42809e = auVar;
        Class<ListAdapter> cls = ListAdapter.class;
        a(AbsListView.class, cls);
        a(ListView.class, cls);
        a(GridView.class, cls);
        a(AbsSpinner.class, SpinnerAdapter.class);
        a(AdapterViewAnimator.class, Adapter.class);
        b();
    }

    private void b() {
        Class<Gallery> cls = Gallery.class;
        Class<GridView> cls2 = GridView.class;
        Class<ListView> cls3 = ListView.class;
        if (gn.w()) {
            try {
                Class cls4 = Integer.TYPE;
                Method declaredMethod = cls3.getDeclaredMethod("fillUp", new Class[]{cls4, cls4});
                a aVar = new a();
                gn.b bVar = gn.b.f42666d;
                gn.c(declaredMethod, aVar, bVar);
                gn.c(cls3.getDeclaredMethod("fillDown", new Class[]{cls4, cls4}), new a(), bVar);
                gn.c(cls3.getDeclaredMethod("fillSpecific", new Class[]{cls4, cls4}), new a(), bVar);
                gn.c(cls3.getDeclaredMethod("onMeasure", new Class[]{cls4, cls4}), new a(), bVar);
                gn.c(cls2.getDeclaredMethod("fillUp", new Class[]{cls4, cls4}), new a(), bVar);
                gn.c(cls2.getDeclaredMethod("fillDown", new Class[]{cls4, cls4}), new a(), bVar);
                gn.c(cls2.getDeclaredMethod("onMeasure", new Class[]{cls4, cls4}), new a(), bVar);
                gn.c(cls.getDeclaredMethod("fillToGalleryLeft", new Class[0]), new a(), bVar);
                gn.c(cls.getDeclaredMethod("fillToGalleryRight", new Class[0]), new a(), bVar);
            } catch (NoSuchMethodException e11) {
                this.f42809e.a().a(bq.b.UnexpectedException, (Exception) e11);
                bo.b(f42805a, "Could not find method: ", e11);
            } catch (Throwable th2) {
                gn.x();
                throw th2;
            }
            gn.x();
        }
    }

    public <T extends Adapter> void a(Class<? extends AdapterView<T>> cls, Class<T> cls2) {
        try {
            gn.c(cls.getMethod("setAdapter", new Class[]{cls2}), new gk() {
                public void a(Method method, Object obj, Object[] objArr) {
                    if (obj instanceof AdapterView) {
                        AdapterView adapterView = (AdapterView) obj;
                        hf b11 = gs.this.f42807c.b(adapterView);
                        if (b11 == null) {
                            String a11 = gs.f42805a;
                            bo.a(a11, "No node for " + adapterView);
                        } else if (!(b11 instanceof gt)) {
                            bo.e(gs.f42805a, String.format("Unexpected view node %s for adapter view %s", new Object[]{b11, adapterView}));
                        } else {
                            final gt gtVar = (gt) b11;
                            gs.this.a(adapterView, gtVar);
                            gs.this.f42808d.a((fi) new fi() {
                                public void run() {
                                    gtVar.f();
                                }
                            });
                        }
                    }
                }
            }, gn.b.f42666d);
        } catch (NoSuchMethodException e11) {
            bo.b(f42805a, "No such method", e11);
        }
    }

    public synchronized void a(AdapterView adapterView, gt gtVar) {
        Adapter adapter = adapterView.getAdapter();
        if (adapter != null) {
            List list = this.f42806b.get(adapter);
            if (list == null) {
                list = new ArrayList();
                this.f42806b.put(adapter, list);
            }
            list.add(gtVar);
        }
    }
}
