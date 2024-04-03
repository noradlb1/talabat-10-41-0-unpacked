package org.threeten.bp.zone;

import i.b;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ZoneRulesInitializer {
    public static final ZoneRulesInitializer DO_NOTHING = new DoNothingZoneRulesInitializer();
    private static final AtomicBoolean INITIALIZED = new AtomicBoolean(false);
    private static final AtomicReference<ZoneRulesInitializer> INITIALIZER = new AtomicReference<>();

    public static class DoNothingZoneRulesInitializer extends ZoneRulesInitializer {
        public void b() {
        }
    }

    public static class ServiceLoaderZoneRulesInitializer extends ZoneRulesInitializer {
        public void b() {
            Class<ZoneRulesProvider> cls = ZoneRulesProvider.class;
            Iterator<S> it = ServiceLoader.load(cls, cls.getClassLoader()).iterator();
            while (it.hasNext()) {
                try {
                    ZoneRulesProvider.registerProvider((ZoneRulesProvider) it.next());
                } catch (ServiceConfigurationError e11) {
                    if (!(e11.getCause() instanceof SecurityException)) {
                        throw e11;
                    }
                }
            }
        }
    }

    public static void a() {
        if (!INITIALIZED.getAndSet(true)) {
            AtomicReference<ZoneRulesInitializer> atomicReference = INITIALIZER;
            b.a(atomicReference, (Object) null, new ServiceLoaderZoneRulesInitializer());
            atomicReference.get().b();
            return;
        }
        throw new IllegalStateException("Already initialized");
    }

    public static void setInitializer(ZoneRulesInitializer zoneRulesInitializer) {
        if (INITIALIZED.get()) {
            throw new IllegalStateException("Already initialized");
        } else if (!b.a(INITIALIZER, (Object) null, zoneRulesInitializer)) {
            throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
        }
    }

    public abstract void b();
}
