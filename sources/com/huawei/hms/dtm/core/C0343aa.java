package com.huawei.hms.dtm.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.util.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.aa  reason: case insensitive filesystem */
public class C0343aa {
    private static Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj != null) {
                    if (a(obj)) {
                        bundle2.putSerializable(next, (Serializable) obj);
                    } else if (obj instanceof Bundle) {
                        bundle2.putParcelable(next, a((Bundle) obj));
                    } else if (obj instanceof ArrayList) {
                        bundle.putParcelableArrayList(next, (ArrayList) obj);
                    }
                }
            }
        }
        return bundle2;
    }

    public static Bundle a(Map<String, Object> map) {
        String str;
        if (map == null) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            String str2 = (String) next.getKey();
            if (value instanceof C0455wc) {
                bundle.putParcelableArrayList(str2, a((List<C0435sc<?>>) ((C0455wc) value).value()));
            } else {
                if (value instanceof C0435sc) {
                    C0435sc scVar = (C0435sc) value;
                    Object value2 = scVar.value();
                    if (value2 instanceof Bundle) {
                        bundle.putBundle(str2, (Bundle) value2);
                    } else if (a(value2)) {
                        bundle.putSerializable(str2, (Serializable) value2);
                    } else {
                        try {
                            str = scVar.a();
                        } catch (V e11) {
                            Logger.warn("DTM-Execute", e11.toString());
                        }
                    }
                } else {
                    str = value == null ? "" : value.toString();
                }
                bundle.putString(str2, str);
            }
        }
        return bundle;
    }

    public static C0435sc<?> a(X x11, Bc bc2) throws V {
        String value = bc2.value();
        if (!TextUtils.isEmpty(value)) {
            C0348ba executable = DynamicTagManager.getInstance().getExecutable(value);
            if (executable != null) {
                return executable.a(x11, bc2.e());
            }
            throw new V("No such executable: " + value);
        }
        throw new V("executable name empty");
    }

    public static C0435sc<?> a(X x11, C0435sc<?> scVar) throws V {
        return scVar instanceof Bc ? a(x11, (Bc) scVar) : scVar instanceof C0455wc ? a(x11, (List<C0435sc<?>>) ((C0455wc) scVar).value()) : scVar;
    }

    public static C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        C0435sc<?> scVar = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            scVar = list.get(i11);
            if (scVar instanceof Bc) {
                scVar = a(x11, (Bc) scVar);
            }
            if (scVar instanceof C0445uc) {
                return scVar == C0445uc.f48608b ? Ec.f48288a : scVar;
            }
        }
        return scVar == null ? Ec.f48288a : scVar;
    }

    private static ArrayList<?> a(List<C0435sc<?>> list) {
        ArrayList<?> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object value = list.get(i11).value();
            if (value instanceof Bundle) {
                value = a((Bundle) value);
            } else if (!a(value)) {
            }
            arrayList.add(value);
        }
        return arrayList;
    }

    public static boolean a(Object obj) {
        return (obj instanceof Number) || (obj instanceof String) || (obj instanceof Character) || (obj instanceof Boolean);
    }
}
