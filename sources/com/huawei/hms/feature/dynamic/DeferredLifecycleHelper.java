package com.huawei.hms.feature.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    public static final int STATUS_ONCREATED = 1;
    public static final int STATUS_ONCREATEVIEW = 2;
    public static final int STATUS_ONINFLATE = 0;
    public static final int STATUS_ONRESUME = 5;
    public static final int STATUS_ONSTART = 4;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f48686a = "DeferredLifecycleHelper";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public T f48687b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Bundle f48688c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<g> f48689d;

    /* renamed from: e  reason: collision with root package name */
    private OnDelegateCreatedListener<T> f48690e = new a();

    public class a implements OnDelegateCreatedListener<T> {
        public a() {
        }

        public void onDelegateCreated(T t11) {
            LifecycleDelegate unused = DeferredLifecycleHelper.this.f48687b = t11;
            Iterator it = DeferredLifecycleHelper.this.f48689d.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(DeferredLifecycleHelper.this.f48687b);
            }
            DeferredLifecycleHelper.this.f48689d.clear();
            Bundle unused2 = DeferredLifecycleHelper.this.f48688c = null;
        }
    }

    public class b implements g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f48692a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bundle f48693b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f48694c;

        public b(Activity activity, Bundle bundle, Bundle bundle2) {
            this.f48692a = activity;
            this.f48693b = bundle;
            this.f48694c = bundle2;
        }

        public int a() {
            return 0;
        }

        public void a(LifecycleDelegate lifecycleDelegate) {
            DeferredLifecycleHelper.this.f48687b.onInflate(this.f48692a, this.f48693b, this.f48694c);
        }
    }

    public class c implements g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f48696a;

        public c(Bundle bundle) {
            this.f48696a = bundle;
        }

        public int a() {
            return 1;
        }

        public void a(LifecycleDelegate lifecycleDelegate) {
            String unused = DeferredLifecycleHelper.f48686a;
            lifecycleDelegate.onCreate(this.f48696a);
        }
    }

    public class d implements g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f48698a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LayoutInflater f48699b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f48700c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f48701d;

        public d(FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f48698a = frameLayout;
            this.f48699b = layoutInflater;
            this.f48700c = viewGroup;
            this.f48701d = bundle;
        }

        public int a() {
            return 2;
        }

        public void a(LifecycleDelegate lifecycleDelegate) {
            this.f48698a.removeAllViews();
            this.f48698a.addView(DeferredLifecycleHelper.this.f48687b.onCreateView(this.f48699b, this.f48700c, this.f48701d));
        }
    }

    public class e implements g {
        public e() {
        }

        public int a() {
            return 4;
        }

        public void a(LifecycleDelegate lifecycleDelegate) {
            String unused = DeferredLifecycleHelper.f48686a;
            lifecycleDelegate.onStart();
        }
    }

    public class f implements g {
        public f() {
        }

        public int a() {
            return 5;
        }

        public void a(LifecycleDelegate lifecycleDelegate) {
            String unused = DeferredLifecycleHelper.f48686a;
            lifecycleDelegate.onResume();
        }
    }

    public interface g {
        int a();

        void a(LifecycleDelegate lifecycleDelegate);
    }

    private void a(int i11) {
        while (!this.f48689d.isEmpty() && this.f48689d.getLast().a() >= i11) {
            this.f48689d.removeLast();
        }
    }

    private void a(Bundle bundle, g gVar) {
        T t11 = this.f48687b;
        if (t11 != null) {
            gVar.a(t11);
            return;
        }
        if (this.f48689d == null) {
            this.f48689d = new LinkedList<>();
        }
        this.f48689d.add(gVar);
        if (bundle != null) {
            Bundle bundle2 = this.f48688c;
            if (bundle2 == null) {
                Object clone = bundle.clone();
                if (clone != null && (clone instanceof Bundle)) {
                    this.f48688c = (Bundle) clone;
                }
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.f48690e);
    }

    public abstract void createDelegate(OnDelegateCreatedListener<T> onDelegateCreatedListener);

    public T getDelegate() {
        return this.f48687b;
    }

    public void onCreate(Bundle bundle) {
        a(bundle, (g) new c(bundle));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, (g) new d(frameLayout, layoutInflater, viewGroup, bundle));
        return frameLayout;
    }

    public void onDestroy() {
        T t11 = this.f48687b;
        if (t11 != null) {
            t11.onDestroy();
        } else {
            a(0);
        }
    }

    public void onDestroyView() {
        T t11 = this.f48687b;
        if (t11 != null) {
            t11.onDestroyView();
        } else {
            a(1);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        a(bundle2, (g) new b(activity, bundle, bundle2));
    }

    public void onLowMemory() {
        T t11 = this.f48687b;
        if (t11 != null) {
            t11.onLowMemory();
        }
    }

    public void onPause() {
        T t11 = this.f48687b;
        if (t11 != null) {
            t11.onPause();
        } else {
            a(5);
        }
    }

    public void onResume() {
        a((Bundle) null, (g) new f());
    }

    public void onSaveInstanceState(Bundle bundle) {
        T t11 = this.f48687b;
        if (t11 != null) {
            t11.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.f48688c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void onStart() {
        a((Bundle) null, (g) new e());
    }

    public void onStop() {
        T t11 = this.f48687b;
        if (t11 != null) {
            t11.onStop();
        } else {
            a(4);
        }
    }
}
