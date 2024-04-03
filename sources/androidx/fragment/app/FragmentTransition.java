package androidx.fragment.app;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.transition.FragmentTransitionSupport;
import java.util.ArrayList;
import java.util.List;

class FragmentTransition {
    static final FragmentTransitionImpl PLATFORM_IMPL = new FragmentTransitionCompat21();
    static final FragmentTransitionImpl SUPPORT_IMPL = resolveSupportImpl();

    private FragmentTransition() {
    }

    public static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z11, ArrayMap<String, View> arrayMap, boolean z12) {
        SharedElementCallback sharedElementCallback;
        int i11;
        if (z11) {
            sharedElementCallback = fragment2.getEnterTransitionCallback();
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (arrayMap == null) {
                i11 = 0;
            } else {
                i11 = arrayMap.size();
            }
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList2.add(arrayMap.keyAt(i12));
                arrayList.add(arrayMap.valueAt(i12));
            }
            if (z12) {
                sharedElementCallback.onSharedElementStart(arrayList2, arrayList, (List<View>) null);
            } else {
                sharedElementCallback.onSharedElementEnd(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    public static String findKeyForValue(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (str.equals(arrayMap.valueAt(i11))) {
                return arrayMap.keyAt(i11);
            }
        }
        return null;
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        try {
            return FragmentTransitionSupport.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void retainValues(@NonNull ArrayMap<String, String> arrayMap, @NonNull ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    public static void setViewVisibility(ArrayList<View> arrayList, int i11) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i11);
            }
        }
    }

    public static boolean supportsTransition() {
        return (PLATFORM_IMPL == null && SUPPORT_IMPL == null) ? false : true;
    }
}
