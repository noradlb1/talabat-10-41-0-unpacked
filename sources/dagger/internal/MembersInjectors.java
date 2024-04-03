package dagger.internal;

import dagger.MembersInjector;

public final class MembersInjectors {

    public enum NoOpMembersInjector implements MembersInjector<Object> {
        INSTANCE;

        public void injectMembers(Object obj) {
            Preconditions.checkNotNull(obj, "Cannot inject members into a null reference");
        }
    }

    private MembersInjectors() {
    }

    public static <T> MembersInjector<T> noOp() {
        return NoOpMembersInjector.INSTANCE;
    }
}
