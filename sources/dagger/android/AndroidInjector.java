package dagger.android;

import dagger.BindsInstance;

public interface AndroidInjector<T> {

    @Deprecated
    public static abstract class Builder<T> implements Factory<T> {
        public abstract AndroidInjector<T> build();

        public final AndroidInjector<T> create(T t11) {
            seedInstance(t11);
            return build();
        }

        @BindsInstance
        public abstract void seedInstance(T t11);
    }

    public interface Factory<T> {
        AndroidInjector<T> create(@BindsInstance T t11);
    }

    void inject(T t11);
}
