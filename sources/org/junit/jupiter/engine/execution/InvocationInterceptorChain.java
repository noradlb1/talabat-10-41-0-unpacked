package org.junit.jupiter.engine.execution;

import f30.l;
import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apiguardian.api.API;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.ExceptionUtils;

@API(since = "5.5", status = API.Status.INTERNAL)
public class InvocationInterceptorChain {

    public static class InterceptedInvocation<T> implements InvocationInterceptor.Invocation<T> {
        private final InterceptorCall<T> call;
        private final InvocationInterceptor interceptor;
        private final InvocationInterceptor.Invocation<T> invocation;

        public InterceptedInvocation(InvocationInterceptor.Invocation<T> invocation2, InterceptorCall<T> interceptorCall, InvocationInterceptor invocationInterceptor) {
            this.invocation = invocation2;
            this.call = interceptorCall;
            this.interceptor = invocationInterceptor;
        }

        public T proceed() throws Throwable {
            return this.call.apply(this.interceptor, this.invocation);
        }

        public void skip() {
            this.invocation.skip();
        }
    }

    @FunctionalInterface
    public interface InterceptorCall<T> {
        T apply(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation<T> invocation) throws Throwable;
    }

    public static class ValidatingInvocation<T> implements InvocationInterceptor.Invocation<T> {
        private static final Logger logger = LoggerFactory.getLogger(ValidatingInvocation.class);
        private final InvocationInterceptor.Invocation<T> delegate;
        private final List<InvocationInterceptor> interceptors;
        private final AtomicBoolean invokedOrSkipped = new AtomicBoolean();

        public ValidatingInvocation(InvocationInterceptor.Invocation<T> invocation, List<InvocationInterceptor> list) {
            this.delegate = invocation;
            this.interceptors = list;
        }

        private void fail(String str) {
            throw new JUnitException(str + ": " + ((String) Collection.EL.stream(this.interceptors).map(new e()).map(new l()).collect(Collectors.joining(IndicativeSentencesGeneration.DEFAULT_SEPARATOR))));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ String lambda$skip$0() {
            return "The invocation is skipped";
        }

        private void markInvokedOrSkipped() {
            if (!this.invokedOrSkipped.compareAndSet(false, true)) {
                fail("Chain of InvocationInterceptors called invocation multiple times instead of just once");
            }
        }

        public void c() {
            if (!this.invokedOrSkipped.get()) {
                fail("Chain of InvocationInterceptors never called invocation");
            }
        }

        public T proceed() throws Throwable {
            markInvokedOrSkipped();
            return this.delegate.proceed();
        }

        public void skip() {
            logger.debug(new d());
            markInvokedOrSkipped();
            this.delegate.skip();
        }
    }

    @FunctionalInterface
    public interface VoidInterceptorCall {
        void apply(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation<Void> invocation) throws Throwable;
    }

    private <T> T chainAndInvoke(InvocationInterceptor.Invocation<T> invocation, InterceptorCall<T> interceptorCall, List<InvocationInterceptor> list) {
        ValidatingInvocation validatingInvocation = new ValidatingInvocation(invocation, list);
        T proceed = proceed(chainInterceptors(validatingInvocation, interceptorCall, list));
        validatingInvocation.c();
        return proceed;
    }

    private <T> InvocationInterceptor.Invocation<T> chainInterceptors(InvocationInterceptor.Invocation<T> invocation, InterceptorCall<T> interceptorCall, List<InvocationInterceptor> list) {
        ListIterator<InvocationInterceptor> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            invocation = new InterceptedInvocation<>(invocation, interceptorCall, listIterator.previous());
        }
        return invocation;
    }

    private <T> T proceed(InvocationInterceptor.Invocation<T> invocation) {
        try {
            return invocation.proceed();
        } catch (Throwable th2) {
            throw ExceptionUtils.throwAsUncheckedException(th2);
        }
    }

    public <T> T invoke(InvocationInterceptor.Invocation<T> invocation, ExtensionRegistry extensionRegistry, InterceptorCall<T> interceptorCall) {
        List<E> extensions = extensionRegistry.getExtensions(InvocationInterceptor.class);
        if (extensions.isEmpty()) {
            return proceed(invocation);
        }
        return chainAndInvoke(invocation, interceptorCall, extensions);
    }
}
