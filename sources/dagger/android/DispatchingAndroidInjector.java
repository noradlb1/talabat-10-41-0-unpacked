package dagger.android;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dagger.android.AndroidInjector;
import dagger.internal.DaggerCollections;
import dagger.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

public final class DispatchingAndroidInjector<T> implements AndroidInjector<T> {
    private static final String NO_SUPERTYPES_BOUND_FORMAT = "No injector factory bound for Class<%s>";
    private static final String SUPERTYPES_BOUND_FORMAT = "No injector factory bound for Class<%1$s>. Injector factories were bound for supertypes of %1$s: %2$s. Did you mean to bind an injector factory for the subtype?";
    private final Map<String, Provider<AndroidInjector.Factory<?>>> injectorFactories;

    public static final class InvalidInjectorBindingException extends RuntimeException {
        public InvalidInjectorBindingException(String str, ClassCastException classCastException) {
            super(str, classCastException);
        }
    }

    @Inject
    public DispatchingAndroidInjector(Map<Class<?>, Provider<AndroidInjector.Factory<?>>> map, Map<String, Provider<AndroidInjector.Factory<?>>> map2) {
        this.injectorFactories = merge(map, map2);
    }

    private String errorMessageSuggestions(T t11) {
        ArrayList arrayList = new ArrayList();
        for (Class cls = t11.getClass(); cls != null; cls = cls.getSuperclass()) {
            if (this.injectorFactories.containsKey(cls.getCanonicalName())) {
                arrayList.add(cls.getCanonicalName());
            }
        }
        if (arrayList.isEmpty()) {
            return String.format(NO_SUPERTYPES_BOUND_FORMAT, new Object[]{t11.getClass().getCanonicalName()});
        }
        return String.format(SUPERTYPES_BOUND_FORMAT, new Object[]{t11.getClass().getCanonicalName(), arrayList});
    }

    private static <C, V> Map<String, Provider<AndroidInjector.Factory<?>>> merge(Map<Class<? extends C>, V> map, Map<String, V> map2) {
        if (map.isEmpty()) {
            return map2;
        }
        LinkedHashMap newLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(map.size() + map2.size());
        newLinkedHashMapWithExpectedSize.putAll(map2);
        for (Map.Entry next : map.entrySet()) {
            newLinkedHashMapWithExpectedSize.put(((Class) next.getKey()).getName(), next.getValue());
        }
        return Collections.unmodifiableMap(newLinkedHashMapWithExpectedSize);
    }

    public void inject(T t11) {
        if (!maybeInject(t11)) {
            throw new IllegalArgumentException(errorMessageSuggestions(t11));
        }
    }

    @CanIgnoreReturnValue
    public boolean maybeInject(T t11) {
        Provider provider = this.injectorFactories.get(t11.getClass().getName());
        if (provider == null) {
            return false;
        }
        AndroidInjector.Factory factory = (AndroidInjector.Factory) provider.get();
        try {
            ((AndroidInjector) Preconditions.checkNotNull(factory.create(t11), "%s.create(I) should not return null.", factory.getClass())).inject(t11);
            return true;
        } catch (ClassCastException e11) {
            throw new InvalidInjectorBindingException(String.format("%s does not implement AndroidInjector.Factory<%s>", new Object[]{factory.getClass().getCanonicalName(), t11.getClass().getCanonicalName()}), e11);
        }
    }
}
