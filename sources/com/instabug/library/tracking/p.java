package com.instabug.library.tracking;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.instabug.library.util.s;
import com.instabug.library.visualusersteps.a;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class p {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Map f51944a = new HashMap();

    @NonNull
    private View a(@NonNull Activity activity) {
        return activity.getWindow().getDecorView();
    }

    public void b(@NonNull Activity activity) {
        a(activity.getClass().getName());
    }

    public void c(@NonNull Fragment fragment) {
        a(fragment.getClass().getName());
    }

    public void d(@NonNull Activity activity) {
        List a11 = a(a(activity));
        if (a11 != null && a11.size() > 0) {
            a(a11, activity.getClass().getName());
        }
    }

    public void e(@NonNull Fragment fragment) {
        List a11;
        View a12 = a(fragment);
        if (a12 != null && (a11 = a(a12)) != null && a11.size() > 0) {
            a(a11, fragment.getClass().getName());
        }
    }

    @Nullable
    private View a(@NonNull Fragment fragment) {
        return fragment.getView();
    }

    @Nullable
    private List a(@Nullable View view) {
        List a11;
        ArrayList arrayList = new ArrayList();
        if (view instanceof TabLayout) {
            arrayList.add((TabLayout) view);
            return arrayList;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt instanceof TabLayout) {
                    arrayList.add((TabLayout) childAt);
                } else if ((childAt instanceof ViewGroup) && (a11 = a(childAt)) != null) {
                    arrayList.addAll(a11);
                }
            }
            return arrayList;
        }
    }

    private void a(@NonNull List list, @NonNull String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TabLayout tabLayout = (TabLayout) it.next();
            if (!a(tabLayout)) {
                a aVar = new a(str.substring(str.lastIndexOf(RealDiscoveryConfigurationRepository.VERSION_DELIMETER) + 1));
                tabLayout.addOnTabSelectedListener((TabLayout.BaseOnTabSelectedListener) aVar);
                List list2 = (List) this.f51944a.get(str);
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new s(tabLayout, aVar));
                    this.f51944a.put(str, arrayList);
                } else {
                    list2.add(new s(tabLayout, aVar));
                }
            }
        }
    }

    private void a(@NonNull String str) {
        List<s> list = (List) this.f51944a.get(str);
        if (list != null && list.size() > 0) {
            for (s sVar : list) {
                Object obj = sVar.first;
                if (!(obj == null || sVar.second == null)) {
                    TabLayout tabLayout = (TabLayout) ((WeakReference) obj).get();
                    a aVar = (a) ((WeakReference) sVar.second).get();
                    if (!(tabLayout == null || aVar == null)) {
                        tabLayout.removeOnTabSelectedListener((TabLayout.BaseOnTabSelectedListener) aVar);
                    }
                }
            }
        }
    }

    private boolean a(@NonNull TabLayout tabLayout) {
        for (List it : this.f51944a.values()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    TabLayout tabLayout2 = (TabLayout) ((WeakReference) ((s) it2.next()).first).get();
                    if (tabLayout2 != null && tabLayout2.equals(tabLayout)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
