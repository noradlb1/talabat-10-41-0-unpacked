package com.huawei.location.lite.common.plug;

import com.huawei.location.lite.common.log.LogConsole;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PluginServiceLoader<S> {
    private static final String TAG = "PluginServiceLoader";
    private LinkedHashMap<Integer, List<String>> plugins = new LinkedHashMap<>();
    private LinkedHashMap<String, S> providers = new LinkedHashMap<>();

    /* renamed from: service  reason: collision with root package name */
    private final Class<S> f50151service;

    private PluginServiceLoader(Class<S> cls) {
        Objects.requireNonNull(cls, "Service interface cannot be null");
        this.f50151service = cls;
        reload();
    }

    public static <S> PluginServiceLoader<S> load(Class<S> cls) {
        return new PluginServiceLoader<>(cls);
    }

    private S loaderServiceProvider(String str) {
        Class<?> cls;
        StringBuilder sb2;
        String str2;
        S s11 = this.providers.get(str);
        if (s11 != null) {
            return s11;
        }
        S s12 = null;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException unused) {
            LogConsole.e(TAG, "Provider " + str + " not found");
            cls = null;
        }
        if (!this.f50151service.isAssignableFrom(cls)) {
            LogConsole.e(TAG, "Provider " + str + " not a subtype");
        }
        if (cls != null) {
            try {
                s12 = this.f50151service.cast(cls.newInstance());
            } catch (IllegalAccessException unused2) {
                sb2 = new StringBuilder();
                sb2.append("Provider");
                sb2.append(str);
                str2 = " IllegalAccessException ";
                sb2.append(str2);
                LogConsole.e(TAG, sb2.toString());
                this.providers.put(str, s12);
                return s12;
            } catch (InstantiationException unused3) {
                sb2 = new StringBuilder();
                sb2.append("Provider");
                sb2.append(str);
                str2 = " InstantiationException ";
                sb2.append(str2);
                LogConsole.e(TAG, sb2.toString());
                this.providers.put(str, s12);
                return s12;
            }
        }
        this.providers.put(str, s12);
        return s12;
    }

    private List<S> loaderServiceProvider(int i11) {
        ArrayList arrayList = new ArrayList();
        List<String> list = this.plugins.get(Integer.valueOf(i11));
        if (list != null && !list.isEmpty()) {
            for (String loaderServiceProvider : list) {
                arrayList.add(loaderServiceProvider(loaderServiceProvider));
            }
        }
        return arrayList;
    }

    private void parserProductId() {
        if (this.plugins.isEmpty()) {
            Field[] declaredFields = ProductId.class.getDeclaredFields();
            try {
                int length = declaredFields.length;
                int i11 = 0;
                while (i11 < length) {
                    Field field = declaredFields[i11];
                    ProductPlugPath productPlugPath = (ProductPlugPath) field.getAnnotation(ProductPlugPath.class);
                    String name2 = field.getName();
                    if (!(field.get(name2) instanceof Integer)) {
                        return;
                    }
                    if (productPlugPath != null) {
                        String[] paths = productPlugPath.paths();
                        if (paths == null) {
                            return;
                        }
                        if (paths.length != 0) {
                            if (field.get(name2) instanceof Integer) {
                                this.plugins.put((Integer) field.get(name2), Arrays.asList(paths));
                            }
                            i11++;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } catch (IllegalAccessException unused) {
                LogConsole.e(TAG, "parserProductId");
            }
        }
    }

    public Set<Integer> getPlugins() {
        if (this.plugins.isEmpty()) {
            parserProductId();
        }
        return this.plugins.keySet();
    }

    public List<S> loadService(int i11) {
        parserProductId();
        return loaderServiceProvider(i11);
    }

    public final void reload() {
        this.providers.clear();
        this.plugins.clear();
    }
}
