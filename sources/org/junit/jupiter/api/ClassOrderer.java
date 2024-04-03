package org.junit.jupiter.api;

import j$.util.Comparator;
import j$.util.List;
import j$.util.Optional;
import java.util.Collections;
import java.util.Comparator;
import org.apiguardian.api.API;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import x20.f;
import x20.g;
import x20.h;
import x20.i;
import x20.j;
import x20.k;
import x20.l;
import x20.m;

@API(since = "5.8", status = API.Status.EXPERIMENTAL)
public interface ClassOrderer {
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_ORDER_PROPERTY_NAME = "junit.jupiter.testclass.order.default";

    public static class ClassName implements ClassOrderer {
        private static final Comparator<ClassDescriptor> comparator = Comparator.CC.comparing(new f());

        public void orderClasses(ClassOrdererContext classOrdererContext) {
            List.EL.sort(classOrdererContext.getClassDescriptors(), comparator);
        }
    }

    public static class DisplayName implements ClassOrderer {
        private static final java.util.Comparator<ClassDescriptor> comparator = Comparator.CC.comparing(new g());

        public void orderClasses(ClassOrdererContext classOrdererContext) {
            List.EL.sort(classOrdererContext.getClassDescriptors(), comparator);
        }
    }

    public static class OrderAnnotation implements ClassOrderer {
        /* access modifiers changed from: private */
        public static int getOrder(ClassDescriptor classDescriptor) {
            return ((Integer) classDescriptor.findAnnotation(Order.class).map(new i()).orElse(1073741823)).intValue();
        }

        public void orderClasses(ClassOrdererContext classOrdererContext) {
            List.EL.sort(classOrdererContext.getClassDescriptors(), Comparator.CC.comparingInt(new h()));
        }
    }

    public static class Random implements ClassOrderer {
        private static final long DEFAULT_SEED = System.nanoTime();
        public static final String RANDOM_SEED_PROPERTY_NAME = "junit.jupiter.execution.order.random.seed";
        private static final Logger logger;

        static {
            Logger logger2 = LoggerFactory.getLogger(Random.class);
            logger = logger2;
            logger2.config(new k());
        }

        private Optional<Long> getCustomSeed(ClassOrdererContext classOrdererContext) {
            return classOrdererContext.getConfigurationParameter("junit.jupiter.execution.order.random.seed").map(new j());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Long lambda$getCustomSeed$3(String str) {
            Long l11;
            try {
                l11 = Long.valueOf(str);
                try {
                    logger.config(new l(str));
                } catch (NumberFormatException e11) {
                    e = e11;
                }
            } catch (NumberFormatException e12) {
                e = e12;
                l11 = null;
                logger.warn(e, new m(str));
                return l11;
            }
            return l11;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ String lambda$static$0() {
            return "ClassOrderer.Random default seed: " + DEFAULT_SEED;
        }

        public void orderClasses(ClassOrdererContext classOrdererContext) {
            Collections.shuffle(classOrdererContext.getClassDescriptors(), new java.util.Random(getCustomSeed(classOrdererContext).orElse(Long.valueOf(DEFAULT_SEED)).longValue()));
        }
    }

    void orderClasses(ClassOrdererContext classOrdererContext);
}
