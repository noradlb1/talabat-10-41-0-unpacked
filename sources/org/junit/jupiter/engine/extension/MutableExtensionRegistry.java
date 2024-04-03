package org.junit.jupiter.engine.extension;

import com.google.android.gms.common.internal.ImagesContract;
import g30.a;
import g30.b;
import g30.c;
import g30.d;
import g30.e;
import g30.f;
import g30.g;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.stream.Stream;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.ClassLoaderUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;

@API(since = "5.5", status = API.Status.INTERNAL)
public class MutableExtensionRegistry implements ExtensionRegistry, ExtensionRegistrar {
    private static final List<Extension> DEFAULT_STATELESS_EXTENSIONS = Collections.unmodifiableList(Arrays.asList(new Extension[]{new DisabledCondition(), new TimeoutExtension(), new RepeatedTestExtension(), new TestInfoParameterResolver(), new TestReporterParameterResolver()}));
    private static final Logger logger = LoggerFactory.getLogger(MutableExtensionRegistry.class);
    private final MutableExtensionRegistry parent;
    private final Set<Class<? extends Extension>> registeredExtensionTypes = new LinkedHashSet();
    private final List<Extension> registeredExtensions = new ArrayList();

    private MutableExtensionRegistry(MutableExtensionRegistry mutableExtensionRegistry) {
        this.parent = mutableExtensionRegistry;
    }

    private String buildSourceInfo(Object obj) {
        String str;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Member) {
            Member member = (Member) obj;
            if (member instanceof Method) {
                str = "method";
            } else {
                str = "field";
            }
            obj = String.format("%s %s.%s", new Object[]{str, member.getDeclaringClass().getName(), member.getName()});
        }
        return " from source [" + obj + "]";
    }

    public static MutableExtensionRegistry createRegistryFrom(MutableExtensionRegistry mutableExtensionRegistry, Stream<Class<? extends Extension>> stream) {
        Preconditions.notNull(mutableExtensionRegistry, "parentRegistry must not be null");
        MutableExtensionRegistry mutableExtensionRegistry2 = new MutableExtensionRegistry(mutableExtensionRegistry);
        stream.forEach(new c(mutableExtensionRegistry2));
        return mutableExtensionRegistry2;
    }

    public static MutableExtensionRegistry createRegistryWithDefaultExtensions(JupiterConfiguration jupiterConfiguration) {
        MutableExtensionRegistry mutableExtensionRegistry = new MutableExtensionRegistry((MutableExtensionRegistry) null);
        Iterable.EL.forEach(DEFAULT_STATELESS_EXTENSIONS, new g(mutableExtensionRegistry));
        mutableExtensionRegistry.registerDefaultExtension(new TempDirectory(jupiterConfiguration));
        if (jupiterConfiguration.isExtensionAutoDetectionEnabled()) {
            registerAutoDetectedExtensions(mutableExtensionRegistry);
        }
        return mutableExtensionRegistry;
    }

    private boolean isAlreadyRegistered(Class<? extends Extension> cls) {
        MutableExtensionRegistry mutableExtensionRegistry;
        if (this.registeredExtensionTypes.contains(cls) || ((mutableExtensionRegistry = this.parent) != null && mutableExtensionRegistry.isAlreadyRegistered(cls))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$registerExtension$0(String str, Extension extension, Object obj) {
        return String.format("Registering %s extension [%s]%s", new Object[]{str, extension, buildSourceInfo(obj)});
    }

    /* access modifiers changed from: private */
    public void registerAutoDetectedExtension(Extension extension) {
        registerExtension("auto-detected", extension);
    }

    private static void registerAutoDetectedExtensions(MutableExtensionRegistry mutableExtensionRegistry) {
        ServiceLoader<S> load = ServiceLoader.load(Extension.class, ClassLoaderUtils.getDefaultClassLoader());
        Objects.requireNonNull(mutableExtensionRegistry);
        Iterable.EL.forEach(load, new d(mutableExtensionRegistry));
    }

    /* access modifiers changed from: private */
    public void registerDefaultExtension(Extension extension) {
        registerExtension("default", extension);
    }

    private void registerLocalExtension(Extension extension) {
        registerExtension(ImagesContract.LOCAL, extension);
    }

    private <E extends Extension> Stream<E> streamLocal(Class<E> cls) {
        Stream stream = Collection.EL.stream(this.registeredExtensions);
        Objects.requireNonNull(cls);
        return stream.filter(new e(cls)).map(new f(cls));
    }

    public /* synthetic */ List getExtensions(Class cls) {
        return a.a(this, cls);
    }

    public /* synthetic */ List getReversedExtensions(Class cls) {
        return a.b(this, cls);
    }

    public void registerExtension(Class<? extends Extension> cls) {
        if (!isAlreadyRegistered(cls)) {
            registerLocalExtension((Extension) ReflectionUtils.newInstance(cls, new Object[0]));
        }
    }

    public void registerSyntheticExtension(Extension extension, Object obj) {
        registerExtension("synthetic", extension, obj);
    }

    public <E extends Extension> Stream<E> stream(Class<E> cls) {
        MutableExtensionRegistry mutableExtensionRegistry = this.parent;
        if (mutableExtensionRegistry == null) {
            return streamLocal(cls);
        }
        return Stream.CC.concat(mutableExtensionRegistry.stream(cls), streamLocal(cls));
    }

    public void registerExtension(Extension extension, Object obj) {
        Preconditions.notNull(obj, "source must not be null");
        registerExtension(ImagesContract.LOCAL, extension, obj);
    }

    private void registerExtension(String str, Extension extension) {
        registerExtension(str, extension, (Object) null);
    }

    private void registerExtension(String str, Extension extension, Object obj) {
        Preconditions.notBlank(str, "category must not be null or blank");
        Preconditions.notNull(extension, "Extension must not be null");
        logger.trace(new b(this, str, extension, obj));
        this.registeredExtensions.add(extension);
        this.registeredExtensionTypes.add(extension.getClass());
    }
}
