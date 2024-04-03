package j$.time.zone;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

final class h implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f28536a;

    h(ArrayList arrayList) {
        this.f28536a = arrayList;
    }

    public final Object run() {
        Class<j> cls = j.class;
        String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (property != null) {
            try {
                j cast = cls.cast(Class.forName(property, true, cls.getClassLoader()).newInstance());
                j.d(cast);
                this.f28536a.add(cast);
                return null;
            } catch (Exception e11) {
                throw new Error(e11);
            }
        } else {
            j.d(new i());
            return null;
        }
    }
}
