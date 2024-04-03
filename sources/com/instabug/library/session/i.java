package com.instabug.library.session;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.instabug.library.internal.data.b;
import com.instabug.library.internal.data.c;
import com.instabug.library.k0;
import com.instabug.library.model.session.CoreSession;
import com.instabug.library.model.session.SessionMapper;
import com.instabug.library.model.session.SessionsBatchDTO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

abstract class i {
    @NonNull
    public static SessionsBatchDTO a(@Size(min = 2) List list) {
        Map a11 = a((CoreSession) list.get(0), list.subList(1, list.size()));
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CoreSession coreSession = (CoreSession) it.next();
            arrayList.add(SessionMapper.toRemoteEntity(coreSession.getId(), a(coreSession, a11.keySet())));
        }
        return SessionMapper.toDTO(a11, arrayList);
    }

    @NonNull
    private static Map a(@NonNull CoreSession coreSession, @NonNull Set set) {
        Object a11;
        HashMap hashMap = new HashMap();
        for (Field field : coreSession.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (a(field)) {
                String a12 = a(field, coreSession.isUsersPageEnabled());
                if (!set.contains(a12) && (a11 = a(field, coreSession)) != null) {
                    hashMap.put(a12, a11);
                }
            }
        }
        return hashMap;
    }

    @NonNull
    private static Map a(@NonNull CoreSession coreSession, @NonNull List list) {
        HashMap hashMap = new HashMap();
        for (Field field : coreSession.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (a(field) && a(coreSession, field, list)) {
                String a11 = a(field, coreSession.isUsersPageEnabled());
                Object a12 = a(field, coreSession);
                if (a12 != null) {
                    hashMap.put(a11, a12);
                }
            }
        }
        return hashMap;
    }

    private static boolean a(@NonNull Field field) {
        return field.getAnnotation(b.class) != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(@androidx.annotation.NonNull com.instabug.library.model.session.CoreSession r4, @androidx.annotation.NonNull java.lang.reflect.Field r5, @androidx.annotation.NonNull java.util.List r6) {
        /*
            java.util.Iterator r6 = r6.iterator()
        L_0x0004:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0031
            java.lang.Object r0 = r6.next()
            com.instabug.library.model.session.CoreSession r0 = (com.instabug.library.model.session.CoreSession) r0
            java.lang.Class r1 = r0.getClass()
            java.lang.String r2 = r5.getName()
            java.lang.reflect.Field r1 = com.instabug.library.k0.a((java.lang.Class) r1, (java.lang.String) r2)
            r2 = 0
            if (r1 != 0) goto L_0x0020
            return r2
        L_0x0020:
            java.lang.Object r3 = com.instabug.library.k0.a((java.lang.reflect.Field) r5, (java.lang.Object) r4)
            java.lang.Object r0 = com.instabug.library.k0.a((java.lang.reflect.Field) r1, (java.lang.Object) r0)
            if (r3 == 0) goto L_0x0030
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0004
        L_0x0030:
            return r2
        L_0x0031:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.session.i.a(com.instabug.library.model.session.CoreSession, java.lang.reflect.Field, java.util.List):boolean");
    }

    @NonNull
    private static String a(@NonNull Field field, boolean z11) {
        c cVar = (c) field.getAnnotation(c.class);
        if (cVar == null) {
            return field.getName();
        }
        if (z11) {
            return cVar.name();
        }
        return cVar.alternate().isEmpty() ? cVar.name() : cVar.alternate();
    }

    @Nullable
    private static Object a(@NonNull Field field, @NonNull CoreSession coreSession) {
        return k0.a(field, (Object) coreSession);
    }
}
