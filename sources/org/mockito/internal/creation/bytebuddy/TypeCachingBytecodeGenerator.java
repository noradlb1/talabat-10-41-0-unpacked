package org.mockito.internal.creation.bytebuddy;

import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import net.bytebuddy.TypeCache;
import org.mockito.mock.SerializableMode;

class TypeCachingBytecodeGenerator extends ReferenceQueue<ClassLoader> implements BytecodeGenerator {
    private static final Object BOOTSTRAP_LOCK = new Object();
    private final BytecodeGenerator bytecodeGenerator;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final TypeCache<MockitoMockKey> typeCache;

    public static class MockitoMockKey extends TypeCache.SimpleKey {
        private final SerializableMode serializableMode;
        private final boolean stripAnnotations;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
                return false;
            }
            MockitoMockKey mockitoMockKey = (MockitoMockKey) obj;
            if (this.stripAnnotations != mockitoMockKey.stripAnnotations || !this.serializableMode.equals(mockitoMockKey.serializableMode)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((super.hashCode() * 31) + (this.stripAnnotations ? 1 : 0)) * 31) + this.serializableMode.hashCode();
        }

        private MockitoMockKey(Class<?> cls, Set<Class<?>> set, SerializableMode serializableMode2, boolean z11) {
            super(cls, (Collection<? extends Class<?>>) set);
            this.serializableMode = serializableMode2;
            this.stripAnnotations = z11;
        }
    }

    public TypeCachingBytecodeGenerator(BytecodeGenerator bytecodeGenerator2, boolean z11) {
        TypeCache.Sort sort;
        this.bytecodeGenerator = bytecodeGenerator2;
        if (z11) {
            sort = TypeCache.Sort.WEAK;
        } else {
            sort = TypeCache.Sort.SOFT;
        }
        this.typeCache = new TypeCache.WithInlineExpunction(sort);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Class lambda$mockClass$0(MockFeatures mockFeatures) throws Exception {
        return this.bytecodeGenerator.mockClass(mockFeatures);
    }

    public void clearAllCaches() {
        this.lock.writeLock().lock();
        try {
            this.typeCache.clear();
            this.bytecodeGenerator.clearAllCaches();
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public <T> Class<T> mockClass(MockFeatures<T> mockFeatures) {
        this.lock.readLock().lock();
        try {
            Class<?> findOrInsert = this.typeCache.findOrInsert(mockFeatures.f63158a.getClassLoader(), new MockitoMockKey(mockFeatures.f63158a, mockFeatures.f63159b, mockFeatures.f63160c, mockFeatures.f63161d), new h(this, mockFeatures), BOOTSTRAP_LOCK);
            this.lock.readLock().unlock();
            return findOrInsert;
        } catch (IllegalArgumentException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw e11;
        } catch (Throwable th2) {
            this.lock.readLock().unlock();
            throw th2;
        }
    }

    public void mockClassConstruction(Class<?> cls) {
        this.bytecodeGenerator.mockClassConstruction(cls);
    }

    public void mockClassStatic(Class<?> cls) {
        this.bytecodeGenerator.mockClassStatic(cls);
    }
}
