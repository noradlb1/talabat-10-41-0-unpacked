package com.uxcam.internals;

import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.lang.reflect.Field;

public class ex {
    public static Object a(String str, Object obj) {
        try {
            Field a11 = a(str, (Class) obj.getClass());
            a11.setAccessible(true);
            return a11.get(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Field a(String str, Class cls) {
        for (Class cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            for (Field field : cls2.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
                if (gm.I && str.equals("flutterRenderer") && field.getType().getName().equalsIgnoreCase(FlutterRenderer.class.getName())) {
                    return field;
                }
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found for class " + cls);
    }
}
