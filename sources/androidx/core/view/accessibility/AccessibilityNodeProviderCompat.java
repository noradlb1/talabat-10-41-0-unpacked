package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;
    @Nullable
    private final Object mProvider;

    @RequiresApi(16)
    public static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        public final AccessibilityNodeProviderCompat f11542a;

        public AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.f11542a = accessibilityNodeProviderCompat;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i11) {
            AccessibilityNodeInfoCompat createAccessibilityNodeInfo = this.f11542a.createAccessibilityNodeInfo(i11);
            if (createAccessibilityNodeInfo == null) {
                return null;
            }
            return createAccessibilityNodeInfo.unwrap();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i11) {
            List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText = this.f11542a.findAccessibilityNodeInfosByText(str, i11);
            if (findAccessibilityNodeInfosByText == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = findAccessibilityNodeInfosByText.size();
            for (int i12 = 0; i12 < size; i12++) {
                arrayList.add(findAccessibilityNodeInfosByText.get(i12).unwrap());
            }
            return arrayList;
        }

        public boolean performAction(int i11, int i12, Bundle bundle) {
            return this.f11542a.performAction(i11, i12, bundle);
        }
    }

    @RequiresApi(19)
    public static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        public AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        public AccessibilityNodeInfo findFocus(int i11) {
            AccessibilityNodeInfoCompat findFocus = this.f11542a.findFocus(i11);
            if (findFocus == null) {
                return null;
            }
            return findFocus.unwrap();
        }
    }

    @RequiresApi(26)
    public static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        public AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i11, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f11542a.addExtraDataToAccessibilityNodeInfo(i11, AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mProvider = new AccessibilityNodeProviderApi26(this);
        } else {
            this.mProvider = new AccessibilityNodeProviderApi19(this);
        }
    }

    public void addExtraDataToAccessibilityNodeInfo(int i11, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @NonNull String str, @Nullable Bundle bundle) {
    }

    @Nullable
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i11) {
        return null;
    }

    @Nullable
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(@NonNull String str, int i11) {
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat findFocus(int i11) {
        return null;
    }

    @Nullable
    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int i11, int i12, @Nullable Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(@Nullable Object obj) {
        this.mProvider = obj;
    }
}
