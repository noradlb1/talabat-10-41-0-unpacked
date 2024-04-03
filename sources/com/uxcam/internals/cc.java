package com.uxcam.internals;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class cc {

    /* renamed from: d  reason: collision with root package name */
    public static final cc f13111d = new cc();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f13112a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final int[] f13113b = new int[2];

    /* renamed from: c  reason: collision with root package name */
    public Object f13114c;

    public static final class aa {
        public aa(Class cls, String str) {
        }
    }

    public final List a(Activity activity) {
        View view;
        Object obj = this.f13114c;
        if (obj == null) {
            obj = a("mGlobal", activity.getWindowManager());
            this.f13114c = obj;
        }
        ArrayList arrayList = (ArrayList) a("mRoots", obj);
        ArrayList arrayList2 = (ArrayList) a("mParams", obj);
        if (arrayList != null) {
            ArrayList arrayList3 = new ArrayList();
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                if (!(((WindowManager.LayoutParams) arrayList2.get(i11)).type == 1) && (view = (View) a("mView", arrayList.get(i11))) != null) {
                    Context context = view.getContext();
                    while (true) {
                        if (context != null) {
                            if (!(context instanceof Activity)) {
                                if (!(context instanceof ContextWrapper)) {
                                    break;
                                }
                                context = ((ContextWrapper) context).getBaseContext();
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    context = null;
                    if (context == activity && view.isShown()) {
                        view.getLocationOnScreen(this.f13113b);
                        int[] iArr = this.f13113b;
                        int i12 = iArr[0];
                        int i13 = iArr[1];
                        arrayList3.add(new cb(view, new Rect(i12, i13, view.getWidth() + i12, view.getHeight() + i13), (WindowManager.LayoutParams) arrayList2.get(i11)));
                    }
                }
            }
            return arrayList3;
        }
        StringBuilder a11 = hl.a("failed to get view roots or params :");
        a11.append(arrayList.toString());
        a11.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        a11.append(arrayList2.toString());
        new IllegalStateException(a11.toString()).getMessage();
        return new ArrayList();
    }

    public final <T> T a(String str, Object obj) {
        Field field;
        aa aaVar = new aa(obj.getClass(), str);
        Field field2 = (Field) this.f13112a.get(aaVar);
        if (field2 == null) {
            Class cls = obj.getClass();
            while (true) {
                if (cls == null) {
                    field = null;
                    break;
                }
                Field[] declaredFields = cls.getDeclaredFields();
                int length = declaredFields.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        field = null;
                        break;
                    }
                    field = declaredFields[i11];
                    if (field.getName().equals(str)) {
                        break;
                    }
                    i11++;
                }
                if (field != null) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            if (field != null) {
                field.setAccessible(true);
                this.f13112a.put(aaVar, field);
                field2 = field;
            }
        }
        try {
            return field2.get(obj);
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
