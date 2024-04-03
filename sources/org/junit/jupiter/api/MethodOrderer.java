package org.junit.jupiter.api;

import j$.util.Comparator;
import j$.util.List;
import j$.util.Optional;
import j$.util.function.Function;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import org.apiguardian.api.API;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.ClassUtils;
import x20.d0;
import x20.e0;
import x20.f0;
import x20.g0;
import x20.h0;
import x20.i;
import x20.i0;
import x20.j0;
import x20.k0;
import x20.l0;

@API(since = "5.7", status = API.Status.STABLE)
public interface MethodOrderer {
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_ORDER_PROPERTY_NAME = "junit.jupiter.testmethod.order.default";

    @API(since = "5.7", status = API.Status.DEPRECATED)
    @Deprecated
    public static class Alphanumeric extends MethodName {
    }

    @API(since = "5.7", status = API.Status.EXPERIMENTAL)
    public static class DisplayName implements MethodOrderer {
        private static final Comparator<MethodDescriptor> comparator = Comparator.CC.comparing(new e0());

        public /* synthetic */ Optional getDefaultExecutionMode() {
            return d0.a(this);
        }

        public void orderMethods(MethodOrdererContext methodOrdererContext) {
            List.EL.sort(methodOrdererContext.getMethodDescriptors(), comparator);
        }
    }

    @API(since = "5.7", status = API.Status.EXPERIMENTAL)
    public static class MethodName implements MethodOrderer {
        private static final java.util.Comparator<MethodDescriptor> comparator = Comparator.EL.thenComparing(Comparator.CC.comparing(new f0()), (Function) new g0());

        /* access modifiers changed from: private */
        public static String parameterList(Method method) {
            return ClassUtils.nullSafeToString((Class<?>[]) method.getParameterTypes());
        }

        public /* synthetic */ Optional getDefaultExecutionMode() {
            return d0.a(this);
        }

        public void orderMethods(MethodOrdererContext methodOrdererContext) {
            List.EL.sort(methodOrdererContext.getMethodDescriptors(), comparator);
        }
    }

    public static class OrderAnnotation implements MethodOrderer {
        /* access modifiers changed from: private */
        public static int getOrder(MethodDescriptor methodDescriptor) {
            return ((Integer) methodDescriptor.findAnnotation(Order.class).map(new i()).orElse(1073741823)).intValue();
        }

        public /* synthetic */ Optional getDefaultExecutionMode() {
            return d0.a(this);
        }

        public void orderMethods(MethodOrdererContext methodOrdererContext) {
            List.EL.sort(methodOrdererContext.getMethodDescriptors(), Comparator.CC.comparingInt(new h0()));
        }
    }

    public static class Random implements MethodOrderer {
        private static final long DEFAULT_SEED = System.nanoTime();
        public static final String RANDOM_SEED_PROPERTY_NAME = "junit.jupiter.execution.order.random.seed";
        private static final Logger logger;

        static {
            Logger logger2 = LoggerFactory.getLogger(Random.class);
            logger = logger2;
            logger2.config(new j0());
        }

        private Optional<Long> getCustomSeed(MethodOrdererContext methodOrdererContext) {
            return methodOrdererContext.getConfigurationParameter("junit.jupiter.execution.order.random.seed").map(new i0());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Long lambda$getCustomSeed$3(String str) {
            Long l11;
            try {
                l11 = Long.valueOf(str);
                try {
                    logger.config(new k0(str));
                } catch (NumberFormatException e11) {
                    e = e11;
                }
            } catch (NumberFormatException e12) {
                e = e12;
                l11 = null;
                logger.warn(e, new l0(str));
                return l11;
            }
            return l11;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ String lambda$static$0() {
            return "MethodOrderer.Random default seed: " + DEFAULT_SEED;
        }

        public /* synthetic */ Optional getDefaultExecutionMode() {
            return d0.a(this);
        }

        public void orderMethods(MethodOrdererContext methodOrdererContext) {
            Collections.shuffle(methodOrdererContext.getMethodDescriptors(), new java.util.Random(getCustomSeed(methodOrdererContext).orElse(Long.valueOf(DEFAULT_SEED)).longValue()));
        }
    }

    Optional<ExecutionMode> getDefaultExecutionMode();

    void orderMethods(MethodOrdererContext methodOrdererContext);
}
