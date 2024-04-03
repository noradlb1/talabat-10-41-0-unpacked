package com.huawei.hms.dtm.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Fa extends Y {
    private Class<?> a(String str) throws V {
        if (str != null) {
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1325958191:
                    if (str.equals("double")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 104431:
                    if (str.equals("int")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3039496:
                    if (str.equals("byte")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3052374:
                    if (str.equals("char")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 3327612:
                    if (str.equals(Constants.LONG)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 64711720:
                    if (str.equals(TypedValues.Custom.S_BOOLEAN)) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 97526364:
                    if (str.equals(TypedValues.Custom.S_FLOAT)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 109413500:
                    if (str.equals("short")) {
                        c11 = 7;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    return Double.TYPE;
                case 1:
                    return Integer.TYPE;
                case 2:
                    return Byte.TYPE;
                case 3:
                    return Character.TYPE;
                case 4:
                    return Long.TYPE;
                case 5:
                    return Boolean.TYPE;
                case 6:
                    return Float.TYPE;
                case 7:
                    return Short.TYPE;
                default:
                    try {
                        return Class.forName(str);
                    } catch (ClassNotFoundException unused) {
                        throw new V("__invoke#wrong class name");
                    }
            }
        } else {
            throw new V("__invoke#wrong class name");
        }
    }

    private Object a(Class<?> cls, Object obj) {
        try {
            if (cls != Integer.TYPE) {
                if (cls != Integer.class) {
                    if (cls != Short.TYPE) {
                        if (cls != Short.class) {
                            if (cls != Byte.TYPE) {
                                if (cls != Byte.class) {
                                    if (cls != Float.TYPE) {
                                        if (cls != Float.class) {
                                            if (cls != Double.TYPE) {
                                                if (cls != Double.class) {
                                                    if (cls != Long.TYPE) {
                                                        if (cls != Long.class) {
                                                            return obj;
                                                        }
                                                    }
                                                    return Long.valueOf(Long.parseLong(String.valueOf(obj)));
                                                }
                                            }
                                            return Double.valueOf(Double.parseDouble(String.valueOf(obj)));
                                        }
                                    }
                                    return Float.valueOf(Float.parseFloat(String.valueOf(obj)));
                                }
                            }
                            return Byte.valueOf(Byte.parseByte(String.valueOf(obj)));
                        }
                    }
                    return Short.valueOf(Short.parseShort(String.valueOf(obj)));
                }
            }
            return Integer.valueOf(Integer.parseInt(String.valueOf(obj)));
        } catch (NumberFormatException unused) {
            throw new V("__invoke#param type error");
        }
    }

    private Object[] a(List<C0435sc<?>> list, Class<?>[] clsArr) {
        Object[] objArr = new Object[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            objArr[i11] = b(clsArr[i11], list.get(i11).value());
        }
        return objArr;
    }

    private Object b(Class<?> cls, Object obj) {
        Object a11 = a(cls, obj);
        return (cls == Boolean.TYPE || cls == Boolean.class) ? Boolean.valueOf(Boolean.parseBoolean(String.valueOf(a11))) : a11;
    }

    private void b(X x11, List<C0435sc<?>> list) {
        if (x11 == null || list == null || list.size() != 5) {
            throw new V("__invoke#params error");
        } else if (list.get(1) == null || list.get(2) == null || list.get(3) == null || list.get(4) == null) {
            throw new V("__invoke#params error");
        } else if (list.get(0) instanceof Ec) {
            throw new V("__invoke#params error");
        }
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        Object obj;
        b(x11, list);
        int i11 = 0;
        try {
            Object value = list.get(0) instanceof C0470zc ? null : list.get(0).value();
            String scVar = list.get(1).toString();
            String scVar2 = list.get(2).toString();
            C0435sc scVar3 = list.get(3);
            C0435sc scVar4 = list.get(4);
            if (scVar3 instanceof C0455wc) {
                if (scVar4 instanceof C0455wc) {
                    List<C0435sc> value2 = ((C0455wc) scVar3).value();
                    List value3 = ((C0455wc) scVar4).value();
                    if (value2.size() == value3.size()) {
                        Class[] clsArr = new Class[value2.size()];
                        for (C0435sc valueOf : value2) {
                            clsArr[i11] = a(String.valueOf(valueOf));
                            i11++;
                        }
                        Object[] a11 = a((List<C0435sc<?>>) value3, (Class<?>[]) clsArr);
                        Class<?> a12 = a(scVar);
                        if ("new".equals(scVar2)) {
                            Constructor<?> declaredConstructor = a12.getDeclaredConstructor(clsArr);
                            declaredConstructor.setAccessible(true);
                            obj = declaredConstructor.newInstance(a11);
                        } else {
                            obj = a12.getDeclaredMethod(scVar2, clsArr).invoke(value, a11);
                        }
                        if (scVar.contains("firebase")) {
                            C0391jd.a().a(DynamicTagManager.getInstance().getConfigurationID()).e("firebase").c("200").b();
                        }
                        return obj == null ? Ec.f48288a : new Ac(obj);
                    }
                    throw new V("__invoke#params error");
                }
            }
            throw new V("__invoke#params error");
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e11) {
            C0391jd.a().a(DynamicTagManager.getInstance().getConfigurationID()).e("firebase").c(ObservableAttributesNames.DEFAULT_RESPONSE_CODE).b(e11.getMessage()).b();
            throw new V("__invoke#exception occur.");
        }
    }

    public String a() {
        return "__invoke";
    }
}
