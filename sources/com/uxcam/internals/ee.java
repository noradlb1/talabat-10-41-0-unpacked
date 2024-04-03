package com.uxcam.internals;

import com.uxcam.datamodel.UXCamBlur;
import com.uxcam.datamodel.UXCamOccludeAllTextFields;
import com.uxcam.datamodel.UXCamOcclusion;
import com.uxcam.datamodel.UXCamOverlay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ee {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f13253a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Map f13254b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final Map f13255c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public static final Map f13256d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Map f13257e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static final Map f13258f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public static final Map f13259g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public static final List f13260h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public static UXCamOcclusion f13261i = null;

    /* renamed from: j  reason: collision with root package name */
    public static UXCamOcclusion f13262j = null;

    /* renamed from: k  reason: collision with root package name */
    public static UXCamOverlay f13263k = null;

    /* renamed from: l  reason: collision with root package name */
    public static UXCamBlur f13264l = null;

    /* renamed from: m  reason: collision with root package name */
    public static UXCamOccludeAllTextFields f13265m = null;

    /* renamed from: n  reason: collision with root package name */
    public static UXCamOccludeAllTextFields f13266n = null;

    /* renamed from: o  reason: collision with root package name */
    public static UXCamOccludeAllTextFields f13267o = null;

    public static void a(UXCamOcclusion uXCamOcclusion) {
        Class<UXCamOccludeAllTextFields> cls = UXCamOccludeAllTextFields.class;
        if (uXCamOcclusion.getExcludeMentionedScreens()) {
            if (uXCamOcclusion.getClass() == cls) {
                ((ArrayList) f13260h).addAll(uXCamOcclusion.getScreens());
                f13266n = (UXCamOccludeAllTextFields) uXCamOcclusion;
                return;
            }
            for (String put : uXCamOcclusion.getScreens()) {
                ((HashMap) f13259g).put(put, uXCamOcclusion);
            }
            f13262j = uXCamOcclusion;
        } else if (uXCamOcclusion.getScreens() != null) {
            for (String str : uXCamOcclusion.getScreens()) {
                if (uXCamOcclusion.getClass() == UXCamOverlay.class) {
                    ((HashMap) f13256d).put(str, (UXCamOverlay) uXCamOcclusion);
                } else if (uXCamOcclusion.getClass() == UXCamBlur.class) {
                    ((HashMap) f13257e).put(str, (UXCamBlur) uXCamOcclusion);
                } else if (uXCamOcclusion.getClass() == cls) {
                    ((HashMap) f13258f).put(str, (UXCamOccludeAllTextFields) uXCamOcclusion);
                }
            }
        } else if (uXCamOcclusion.getClass() == cls) {
            f13266n = (UXCamOccludeAllTextFields) uXCamOcclusion;
        }
    }

    public static void b(UXCamOcclusion uXCamOcclusion) {
        if (uXCamOcclusion != null) {
            Class<UXCamBlur> cls = UXCamBlur.class;
            Class<UXCamOverlay> cls2 = UXCamOverlay.class;
            Class<UXCamOccludeAllTextFields> cls3 = UXCamOccludeAllTextFields.class;
            if (uXCamOcclusion.getScreens() == null) {
                UXCamOcclusion uXCamOcclusion2 = f13261i;
                if (uXCamOcclusion2 == null || uXCamOcclusion2.getClass() != cls2 || uXCamOcclusion.getClass() != cls) {
                    if (uXCamOcclusion.getClass() == cls3) {
                        f13265m = (UXCamOccludeAllTextFields) uXCamOcclusion;
                    } else {
                        f13261i = uXCamOcclusion;
                    }
                }
            } else if (!uXCamOcclusion.getExcludeMentionedScreens()) {
                for (String str : uXCamOcclusion.getScreens()) {
                    if (uXCamOcclusion.getClass() == cls2) {
                        ((HashMap) f13253a).put(str, (UXCamOverlay) uXCamOcclusion);
                    } else if (uXCamOcclusion.getClass() == cls) {
                        ((HashMap) f13254b).put(str, (UXCamBlur) uXCamOcclusion);
                    } else if (uXCamOcclusion.getClass() == cls3) {
                        ((HashMap) f13255c).put(str, (UXCamOccludeAllTextFields) uXCamOcclusion);
                    }
                }
            } else if (uXCamOcclusion.getClass() == cls2) {
                f13263k = (UXCamOverlay) uXCamOcclusion;
            } else if (uXCamOcclusion.getClass() == cls) {
                f13264l = (UXCamBlur) uXCamOcclusion;
            } else if (uXCamOcclusion.getClass() == cls3) {
                f13267o = (UXCamOccludeAllTextFields) uXCamOcclusion;
            }
        }
    }

    public static void c(UXCamOcclusion uXCamOcclusion) {
        Class<UXCamOccludeAllTextFields> cls = UXCamOccludeAllTextFields.class;
        if (uXCamOcclusion.getScreens() != null) {
            Class<UXCamBlur> cls2 = UXCamBlur.class;
            Class<UXCamOverlay> cls3 = UXCamOverlay.class;
            if (!uXCamOcclusion.getExcludeMentionedScreens()) {
                for (String str : uXCamOcclusion.getScreens()) {
                    if (uXCamOcclusion.getClass() == cls3) {
                        ((HashMap) f13253a).remove(str);
                    } else if (uXCamOcclusion.getClass() == cls2) {
                        ((HashMap) f13254b).remove(str);
                    } else if (uXCamOcclusion.getClass() == cls) {
                        ((HashMap) f13255c).remove(str);
                    }
                }
            } else if (uXCamOcclusion.getClass() == cls3) {
                f13263k = null;
            } else if (uXCamOcclusion.getClass() == cls2) {
                f13264l = null;
            } else if (uXCamOcclusion.getClass() == cls) {
                f13267o = null;
            }
        } else if (uXCamOcclusion.getClass() == cls) {
            f13265m = null;
        } else {
            f13261i = null;
        }
    }

    public static boolean c(String str) {
        if (f13261i != null) {
            return true;
        }
        UXCamOverlay uXCamOverlay = f13263k;
        if (uXCamOverlay != null && !uXCamOverlay.f12939c.contains(str)) {
            return true;
        }
        UXCamBlur uXCamBlur = f13264l;
        if ((uXCamBlur != null && !uXCamBlur.f12933c.contains(str)) || ((HashMap) f13253a).containsKey(str) || ((HashMap) f13254b).containsKey(str)) {
            return true;
        }
        if ((f13262j == null || ((HashMap) f13259g).containsKey(str)) && !((HashMap) f13256d).containsKey(str)) {
            return ((HashMap) f13257e).containsKey(str);
        }
        return true;
    }

    public static UXCamOccludeAllTextFields a(String str) {
        if (f13266n != null && !((ArrayList) f13260h).contains(str)) {
            return f13266n;
        }
        HashMap hashMap = (HashMap) f13258f;
        if (hashMap.containsKey(str)) {
            return (UXCamOccludeAllTextFields) hashMap.get(str);
        }
        UXCamOccludeAllTextFields uXCamOccludeAllTextFields = f13265m;
        if (uXCamOccludeAllTextFields != null) {
            return uXCamOccludeAllTextFields;
        }
        UXCamOccludeAllTextFields uXCamOccludeAllTextFields2 = f13267o;
        if (uXCamOccludeAllTextFields2 != null && !uXCamOccludeAllTextFields2.f12935a.contains(str)) {
            return f13267o;
        }
        HashMap hashMap2 = (HashMap) f13255c;
        if (hashMap2.containsKey(str)) {
            return (UXCamOccludeAllTextFields) hashMap2.get(str);
        }
        return null;
    }

    public static UXCamOcclusion b(String str) {
        if (!c(str)) {
            return null;
        }
        if (f13262j != null && !((HashMap) f13259g).containsKey(str)) {
            return f13262j;
        }
        HashMap hashMap = (HashMap) f13256d;
        if (hashMap.containsKey(str)) {
            return (UXCamOcclusion) hashMap.get(str);
        }
        HashMap hashMap2 = (HashMap) f13257e;
        if (hashMap2.containsKey(str)) {
            return (UXCamOcclusion) hashMap2.get(str);
        }
        UXCamOcclusion uXCamOcclusion = f13261i;
        if (uXCamOcclusion != null) {
            return uXCamOcclusion;
        }
        UXCamOverlay uXCamOverlay = f13263k;
        if (uXCamOverlay != null && !uXCamOverlay.f12939c.contains(str)) {
            return f13263k;
        }
        UXCamBlur uXCamBlur = f13264l;
        if (uXCamBlur != null && !uXCamBlur.f12933c.contains(str)) {
            return f13264l;
        }
        HashMap hashMap3 = (HashMap) f13253a;
        if (hashMap3.containsKey(str)) {
            return (UXCamOcclusion) hashMap3.get(str);
        }
        HashMap hashMap4 = (HashMap) f13254b;
        if (hashMap4.containsKey(str)) {
            return (UXCamOcclusion) hashMap4.get(str);
        }
        return null;
    }
}
