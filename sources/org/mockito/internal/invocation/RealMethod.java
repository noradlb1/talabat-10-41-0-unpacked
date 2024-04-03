package org.mockito.internal.invocation;

import java.io.Serializable;
import java.util.concurrent.Callable;
import org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter;
import org.mockito.invocation.InvocationFactory;

public interface RealMethod extends Serializable {

    public static class FromBehavior implements RealMethod {
        private final InvocationFactory.RealMethodBehavior<?> behavior;

        public FromBehavior(InvocationFactory.RealMethodBehavior<?> realMethodBehavior) {
            this.behavior = realMethodBehavior;
        }

        public Object invoke() throws Throwable {
            try {
                return this.behavior.call();
            } catch (Throwable th2) {
                new ConditionalStackTraceFilter().filter(th2);
                throw th2;
            }
        }

        public boolean isInvokable() {
            return true;
        }
    }

    public static class FromCallable extends FromBehavior {
        public FromCallable(final Callable<?> callable) {
            super(new InvocationFactory.RealMethodBehavior() {
                public Object call() throws Throwable {
                    return callable.call();
                }
            });
        }
    }

    public enum IsIllegal implements RealMethod {
        INSTANCE;

        public Object invoke() {
            throw new IllegalStateException();
        }

        public boolean isInvokable() {
            return false;
        }
    }

    Object invoke() throws Throwable;

    boolean isInvokable();
}
