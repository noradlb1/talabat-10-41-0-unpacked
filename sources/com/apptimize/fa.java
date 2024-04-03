package com.apptimize;

import com.apptimize.bq;
import java.lang.reflect.InvocationTargetException;

public class fa {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42394a = "fa";

    public static Class<?> a() throws ClassNotFoundException {
        return Class.forName("android.os.Debug");
    }

    public static boolean b() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return ((Boolean) a().getMethod("isDebuggerConnected", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
    }

    public static void a(au auVar) {
        try {
            if (b()) {
                auVar.a().a(bq.b.B);
            }
        } catch (ClassNotFoundException e11) {
            bo.h(f42394a, "ClassNotFoundException", e11);
        } catch (NoSuchMethodException e12) {
            bo.h(f42394a, "NoSuchMethodException", e12);
        } catch (IllegalAccessException e13) {
            bo.h(f42394a, "IllegalAccessException", e13);
        } catch (InvocationTargetException e14) {
            bo.h(f42394a, "InvocationTargetException", e14);
        }
    }
}
