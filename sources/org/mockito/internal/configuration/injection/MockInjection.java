package org.mockito.internal.configuration.injection;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.mockito.internal.util.Checks;
import org.mockito.internal.util.collections.Sets;

public final class MockInjection {
    private MockInjection() {
    }

    public static OngoingMockInjection onField(Field field, Object obj) {
        return new OngoingMockInjection(field, obj);
    }

    public static OngoingMockInjection onFields(Set<Field> set, Object obj) {
        return new OngoingMockInjection((Set) set, obj);
    }

    public static class OngoingMockInjection {
        private final Object fieldOwner;
        private final Set<Field> fields;
        private final MockInjectionStrategy injectionStrategies;
        private final Set<Object> mocks;
        private final MockInjectionStrategy postInjectionStrategies;

        public void apply() {
            for (Field next : this.fields) {
                this.injectionStrategies.process(next, this.fieldOwner, this.mocks);
                this.postInjectionStrategies.process(next, this.fieldOwner, this.mocks);
            }
        }

        public OngoingMockInjection handleSpyAnnotation() {
            this.postInjectionStrategies.thenTry(new SpyOnInjectedFieldsHandler());
            return this;
        }

        public OngoingMockInjection tryConstructorInjection() {
            this.injectionStrategies.thenTry(new ConstructorInjection());
            return this;
        }

        public OngoingMockInjection tryPropertyOrFieldInjection() {
            this.injectionStrategies.thenTry(new PropertyAndSetterInjection());
            return this;
        }

        public OngoingMockInjection withMocks(Set<Object> set) {
            this.mocks.addAll((Collection) Checks.checkNotNull(set, "mocks"));
            return this;
        }

        private OngoingMockInjection(Field field, Object obj) {
            this((Set<Field>) Collections.singleton(field), obj);
        }

        private OngoingMockInjection(Set<Field> set, Object obj) {
            HashSet hashSet = new HashSet();
            this.fields = hashSet;
            this.mocks = Sets.newMockSafeHashSet(new Object[0]);
            this.injectionStrategies = MockInjectionStrategy.nop();
            this.postInjectionStrategies = MockInjectionStrategy.nop();
            this.fieldOwner = Checks.checkNotNull(obj, "fieldOwner");
            hashSet.addAll((Collection) Checks.checkItemsNotNull(set, "fields"));
        }
    }
}
