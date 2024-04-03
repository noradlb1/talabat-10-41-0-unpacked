package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgjx;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzgkf<T extends zzgjx> {
    private static final Logger zza = Logger.getLogger(zzgjs.class.getName());
    private static final String zzb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    public static <T extends zzgjx> T zzb(Class<T> cls) {
        String str;
        String str2;
        Class<zzgkf> cls2 = zzgkf.class;
        ClassLoader classLoader = cls2.getClassLoader();
        if (cls.equals(zzgjx.class)) {
            str = zzb;
        } else if (cls.getPackage().equals(cls2.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            return (zzgjx) cls.cast(((zzgkf) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zza());
        } catch (NoSuchMethodException e11) {
            throw new IllegalStateException(e11);
        } catch (InstantiationException e12) {
            throw new IllegalStateException(e12);
        } catch (IllegalAccessException e13) {
            throw new IllegalStateException(e13);
        } catch (InvocationTargetException e14) {
            throw new IllegalStateException(e14);
        } catch (ClassNotFoundException unused) {
            Iterator<S> it = ServiceLoader.load(cls2, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((zzgkf) it.next()).zza()));
                } catch (ServiceConfigurationError e15) {
                    ServiceConfigurationError serviceConfigurationError = e15;
                    Logger logger = zza;
                    Level level = Level.SEVERE;
                    String simpleName = cls.getSimpleName();
                    if (simpleName.length() != 0) {
                        str2 = "Unable to load ".concat(simpleName);
                    } else {
                        str2 = new String("Unable to load ");
                    }
                    logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", str2, serviceConfigurationError);
                }
            }
            if (arrayList.size() == 1) {
                return (zzgjx) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzgjx) cls.getMethod("combine", new Class[]{Collection.class}).invoke((Object) null, new Object[]{arrayList});
            } catch (NoSuchMethodException e16) {
                throw new IllegalStateException(e16);
            } catch (IllegalAccessException e17) {
                throw new IllegalStateException(e17);
            } catch (InvocationTargetException e18) {
                throw new IllegalStateException(e18);
            }
        }
    }

    public abstract T zza();
}
