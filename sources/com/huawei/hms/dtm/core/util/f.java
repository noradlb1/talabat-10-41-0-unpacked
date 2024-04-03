package com.huawei.hms.dtm.core.util;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f {
    public static int a(View view) {
        float alpha = view.getAlpha();
        Drawable background = view.getBackground();
        return (int) (alpha * ((float) (background != null ? background.getAlpha() : 0)));
    }

    private static int a(View view, View view2) {
        Class<RecyclerView> cls = RecyclerView.class;
        try {
            int i11 = RecyclerView.HORIZONTAL;
            Method declaredMethod = cls.getDeclaredMethod("getChildAdapterPosition", new Class[]{View.class});
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(view, new Object[]{view2})).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            Logger.warn("DTM-AutoTrace", "getAndroidXRvItemPosition#" + e11.toString());
            return -1;
        }
    }

    private static int a(View view, View view2, String str, boolean z11) {
        ViewGroup viewGroup;
        List<View> c11;
        if (!(view instanceof ViewGroup) || TextUtils.isEmpty(str) || (c11 = c(viewGroup)) == null || c11.isEmpty()) {
            return -1;
        }
        return (!z11 || c11.size() < 2) ? a((viewGroup = (ViewGroup) view), str) : a(c11, view, view2, str);
    }

    private static int a(View view, View view2, boolean z11) {
        int a11 = a(view, view2, "androidx.viewpager.widget.ViewPager", z11);
        return a11 == -1 ? a(view, view2, "android.support.v4.view.ViewPager", z11) : a11;
    }

    public static int a(ViewGroup viewGroup, View view, int i11) {
        if (viewGroup instanceof AdapterView) {
            return ((AdapterView) viewGroup).getPositionForView(view);
        }
        if (a(viewGroup)) {
            return c((View) viewGroup, view);
        }
        if (l(viewGroup)) {
            return a((View) viewGroup, view, true);
        }
        if (m(viewGroup)) {
            return 0;
        }
        return i11;
    }

    private static int a(ViewGroup viewGroup, String str) {
        if (viewGroup == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod("getCurrentItem", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(viewGroup, new Object[0])).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            Logger.warn("DTM-AutoTrace", "getCurrentItemByVp#" + e11.toString());
            return -1;
        }
    }

    private static int a(List<View> list, View view, View view2, String str) {
        if (b(list, view, view2, str)) {
            return -1;
        }
        Collections.sort(list, new d());
        int left = list.get(1).getLeft() - list.get(0).getLeft();
        if (left == 0) {
            return a((ViewGroup) view, str);
        }
        int left2 = view2.getLeft() / left;
        int b11 = b((ViewGroup) view, str);
        return b11 > 0 ? left2 % b11 : left2;
    }

    public static Activity a() {
        try {
            for (Object next : b()) {
                Class<?> cls = next.getClass();
                Field declaredField = cls.getDeclaredField("paused");
                declaredField.setAccessible(true);
                if (!declaredField.getBoolean(next)) {
                    Field declaredField2 = cls.getDeclaredField("activity");
                    declaredField2.setAccessible(true);
                    Object obj = declaredField2.get(next);
                    if (obj instanceof Activity) {
                        return (Activity) obj;
                    }
                }
            }
            return null;
        } catch (IllegalAccessException | NoSuchFieldException e11) {
            Logger.warn("HMS-DTM", "getTopActivity#" + e11.getMessage());
            return null;
        }
    }

    public static View a(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        return activity.getWindow().getDecorView();
    }

    public static View a(ViewGroup viewGroup, int i11) {
        if (viewGroup == null) {
            return null;
        }
        if (viewGroup instanceof AdapterView) {
            return a((AdapterView) viewGroup, i11);
        }
        if (a(viewGroup)) {
            return b(viewGroup, i11);
        }
        if (l(viewGroup)) {
            return c(viewGroup, i11);
        }
        if (m(viewGroup)) {
            return b(viewGroup);
        }
        int childCount = viewGroup.getChildCount();
        if (i11 < 0 || i11 > childCount - 1) {
            return null;
        }
        return viewGroup.getChildAt(i11);
    }

    private static View a(ViewGroup viewGroup, String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod("getLayoutManager", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(viewGroup, new Object[0]);
            if (invoke == null) {
                return null;
            }
            Method a11 = m.a(invoke, "findViewByPosition", Integer.TYPE);
            if (a11 == null) {
                return null;
            }
            a11.setAccessible(true);
            return (View) a11.invoke(invoke, new Object[]{Integer.valueOf(i11)});
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            Logger.warn("DTM-AutoTrace", "getItemByRlv#" + e11.toString());
            return null;
        }
    }

    public static View a(ViewGroup viewGroup, String str, String str2) {
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            String b11 = b(childAt);
            if (!TextUtils.isEmpty(b11) && b11.equals(str2) && childAt.getClass().getSimpleName().equals(str)) {
                return childAt;
            }
        }
        return null;
    }

    private static View a(AdapterView adapterView, int i11) {
        if (adapterView == null) {
            return null;
        }
        int firstVisiblePosition = adapterView.getFirstVisiblePosition();
        int childCount = (adapterView.getChildCount() + firstVisiblePosition) - 1;
        if (i11 < firstVisiblePosition || i11 > childCount) {
            return null;
        }
        return adapterView.getChildAt(i11 - firstVisiblePosition);
    }

    private static View a(Object obj) {
        View a11 = a(obj, "androidx.fragment.app.Fragment");
        if (a11 == null) {
            a11 = a(obj, "android.app.Fragment");
        }
        return a11 == null ? a(obj, "android.support.v4.app.Fragment") : a11;
    }

    private static View a(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod("getView", new Class[0]);
            declaredMethod.setAccessible(true);
            return (View) declaredMethod.invoke(obj, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            Logger.warn("DTM-AutoTrace", "getFragmentRootView#" + e11.toString());
            return null;
        }
    }

    private static String a(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        Package packageR = cls.getPackage();
        String name2 = packageR != null ? packageR.getName() : "";
        return TextUtils.isEmpty(name2) ? "" : name2;
    }

    private static void a(View view, List<View> list) {
        if (view != null && list != null) {
            list.add(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    a(viewGroup.getChildAt(i11), list);
                }
            }
        }
    }

    public static void a(String str) {
        Activity b11 = c.a().b();
        if (b11 != null && !TextUtils.isEmpty(str)) {
            b11.runOnUiThread(new e(b11, str));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r2 = r2.getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x000b
            java.lang.String r2 = "HMS-DTM"
            java.lang.String r1 = "isNetworkConnected#context is null"
            com.huawei.hms.dtm.core.util.Logger.info(r2, r1)
            return r0
        L_0x000b:
            java.lang.String r1 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r1)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            if (r2 != 0) goto L_0x0016
            return r0
        L_0x0016:
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()
            if (r2 == 0) goto L_0x002b
            boolean r1 = r2.isConnected()
            if (r1 == 0) goto L_0x002b
            android.net.NetworkInfo$State r2 = r2.getState()
            android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.CONNECTED
            if (r2 != r1) goto L_0x002b
            r0 = 1
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.util.f.a(android.content.Context):boolean");
    }

    private static boolean a(View view, Rect rect) {
        if (view == null || rect == null) {
            return false;
        }
        try {
            return view.getGlobalVisibleRect(rect);
        } catch (Exception e11) {
            Logger.warn("DTM-AutoTrace", "isGlobalVisible#" + e11.getMessage());
            return false;
        }
    }

    private static boolean a(View view, String str) {
        Class<?> cls;
        if ((view instanceof ViewGroup) && !TextUtils.isEmpty(str)) {
            String a11 = a(view.getClass());
            if (!"android.widget".equals(a11) && !"android.view".equals(a11)) {
                try {
                    cls = Class.forName(str);
                } catch (ClassNotFoundException e11) {
                    Logger.warn("DTM-Decode", "Exception in AndroidUtil checkViewType#" + e11.getMessage());
                    cls = null;
                }
                if (cls == null) {
                    return false;
                }
                return cls.isAssignableFrom(((ViewGroup) view).getClass());
            }
        }
        return false;
    }

    public static boolean a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        Class cls = viewGroup.getClass();
        do {
            String canonicalName = cls.getCanonicalName();
            if (canonicalName == null || canonicalName.equals("android.view.ViewGroup")) {
                return false;
            }
            if (canonicalName.equals("androidx.recyclerview.widget.RecyclerView") || canonicalName.equals("android.support.v7.widget.RecyclerView")) {
                return true;
            }
            cls = cls.getSuperclass();
        } while (cls != null);
        return false;
    }

    private static int b(View view, View view2) {
        try {
            Method declaredMethod = Class.forName("android.support.v7.widget.RecyclerView").getDeclaredMethod("getChildPosition", new Class[]{View.class});
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(view, new Object[]{view2})).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            Logger.warn("DTM-AutoTrace", "getPosByChildPosition#" + e11.toString());
            return -1;
        }
    }

    private static int b(ViewGroup viewGroup, String str) {
        if (viewGroup == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod("getAdapter", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(viewGroup, new Object[0]);
            if (invoke == null) {
                return 0;
            }
            Method a11 = m.a(invoke, "getCount", new Class[0]);
            if (a11 == null) {
                return 0;
            }
            a11.setAccessible(true);
            return ((Integer) a11.invoke(invoke, new Object[0])).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            Logger.warn("DTM-AutoTrace", "getViewPagerTotalCount#" + e11.toString());
            return 0;
        }
    }

    private static View b(ViewGroup viewGroup) {
        View view = null;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            view = viewGroup.getChildAt(i11);
            if (!(view instanceof ImageView)) {
                return view;
            }
        }
        return view;
    }

    private static View b(ViewGroup viewGroup, int i11) {
        View a11 = a(viewGroup, "androidx.recyclerview.widget.RecyclerView", i11);
        return a11 == null ? a(viewGroup, "android.support.v7.widget.RecyclerView", i11) : a11;
    }

    private static View b(ViewGroup viewGroup, String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            Method declaredMethod = cls.getDeclaredMethod("infoForPosition", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(viewGroup, new Object[]{Integer.valueOf(i11)});
            if (invoke == null) {
                return null;
            }
            Field declaredField = invoke.getClass().getDeclaredField("object");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(invoke);
            if (obj instanceof View) {
                return (View) obj;
            }
            if (obj != null) {
                return a(obj);
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e11) {
            Logger.warn("DTM-AutoTrace", "getItemByVp#" + e11.toString());
            return null;
        }
    }

    public static String b(View view) {
        if (view == null) {
            return null;
        }
        Object tag = view.getTag(-65536);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    private static Collection b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(invoke);
            return !(obj instanceof Map) ? Collections.emptyList() : ((Map) obj).values();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e11) {
            Logger.warn("HMS-DTM", "getAllActivities#" + e11.getMessage());
            return Collections.emptyList();
        }
    }

    public static boolean b(Activity activity) {
        List<View> e11 = e(a(activity));
        if (e11 == null) {
            return false;
        }
        for (View layerType : e11) {
            if (layerType.getLayerType() == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(List<View> list, View view, View view2, String str) {
        return list == null || list.size() < 2 || view == null || view2 == null || TextUtils.isEmpty(str);
    }

    public static int c(View view) {
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            return -1;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (!i(viewGroup)) {
            return c((View) viewGroup);
        }
        if (parent instanceof AdapterView) {
            return ((AdapterView) parent).getPositionForView(view);
        }
        if (a(viewGroup)) {
            return c((View) viewGroup, view);
        }
        if (l(viewGroup)) {
            return a((View) viewGroup, view, false);
        }
        return -1;
    }

    private static int c(View view, View view2) {
        int a11 = a(view, view2);
        return a11 == -1 ? d(view, view2) : a11;
    }

    private static View c(ViewGroup viewGroup, int i11) {
        View b11 = b(viewGroup, "androidx.viewpager.widget.ViewPager", i11);
        return b11 == null ? b(viewGroup, "android.support.v4.view.ViewPager", i11) : b11;
    }

    private static List<View> c(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (f(childAt) != null) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    public static boolean c(Activity activity) {
        if (activity == null) {
            return false;
        }
        int i11 = Resources.getSystem().getDisplayMetrics().heightPixels;
        Rect rect = new Rect();
        Window window = activity.getWindow();
        if (window == null) {
            return false;
        }
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return (i11 * 2) / 3 > rect.bottom - rect.top;
    }

    private static int d(View view, View view2) {
        try {
            Method declaredMethod = Class.forName("android.support.v7.widget.RecyclerView").getDeclaredMethod("getChildAdapterPosition", new Class[]{View.class});
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(view, new Object[]{view2})).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            Logger.warn("DTM-AutoTrace", "getSupportRvItemPosition#" + e11.toString());
            if (e11 instanceof NoSuchMethodException) {
                return b(view, view2);
            }
            return -1;
        }
    }

    public static String d(View view) {
        if (!(view == null || -1 == view.getId())) {
            try {
                String resourceName = view.getContext().getResources().getResourceName(view.getId());
                if (TextUtils.isEmpty(resourceName)) {
                    return null;
                }
                String[] split = resourceName.split("/");
                return split.length == 2 ? split[1] : resourceName;
            } catch (Resources.NotFoundException e11) {
                Logger.warn("DTM-AutoTrace", "resource not found:" + e11.getMessage());
            }
        }
        return null;
    }

    public static List<View> e(View view) {
        if (view == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        a(view, (List<View>) arrayList);
        return arrayList;
    }

    public static Rect f(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        Rect rect = new Rect();
        if (a(view, rect) && rect.right > rect.left && rect.bottom > rect.top) {
            return rect;
        }
        return null;
    }

    public static List<WebView> g(View view) {
        ArrayList arrayList = new ArrayList();
        if (view == null) {
            return arrayList;
        }
        if (view instanceof WebView) {
            arrayList.add((WebView) view);
            return arrayList;
        }
        if (view instanceof ViewGroup) {
            LinkedList linkedList = new LinkedList();
            linkedList.offer((ViewGroup) view);
            while (!linkedList.isEmpty()) {
                ViewGroup viewGroup = (ViewGroup) linkedList.poll();
                if (viewGroup != null) {
                    for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (childAt instanceof WebView) {
                            arrayList.add((WebView) childAt);
                        } else if (childAt instanceof ViewGroup) {
                            linkedList.offer((ViewGroup) childAt);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean h(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof WebView) {
            return true;
        }
        if (view instanceof ViewGroup) {
            LinkedList linkedList = new LinkedList();
            linkedList.offer((ViewGroup) view);
            while (!linkedList.isEmpty()) {
                ViewGroup viewGroup = (ViewGroup) linkedList.poll();
                if (viewGroup != null) {
                    for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (childAt instanceof WebView) {
                            return true;
                        }
                        if (childAt instanceof ViewGroup) {
                            linkedList.offer((ViewGroup) childAt);
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    public static boolean i(View view) {
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        return (view instanceof AdapterView) || a((ViewGroup) view) || l(view);
    }

    public static boolean j(View view) {
        if (!(view instanceof EditText)) {
            return false;
        }
        int inputType = ((EditText) view).getInputType();
        return inputType == 18 || inputType == 129 || inputType == 145 || inputType == 225;
    }

    public static boolean k(View view) {
        Class cls = SwitchCompat.class;
        try {
            int i11 = SwitchCompat.f892b;
        } catch (ClassNotFoundException e11) {
            Logger.warn("DTM-AutoTrace", "isSwitchCompat#" + e11.getMessage());
            cls = null;
        }
        if (cls == null) {
            try {
                cls = Class.forName("android.support.v7.widget.SwitchCompat");
            } catch (ClassNotFoundException e12) {
                Logger.warn("DTM-AutoTrace", "isSwitchCompat#" + e12.getMessage());
            }
        }
        return cls != null && cls.isInstance(view);
    }

    public static boolean l(View view) {
        boolean a11 = a(view, "androidx.viewpager.widget.ViewPager");
        return !a11 ? a(view, "android.support.v4.view.ViewPager") : a11;
    }

    private static boolean m(View view) {
        boolean a11 = a(view, "androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        return !a11 ? a(view, "android.support.v4.widget.SwipeRefreshLayout") : a11;
    }
}
