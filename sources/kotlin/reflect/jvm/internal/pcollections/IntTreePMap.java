package kotlin.reflect.jvm.internal.pcollections;

final class IntTreePMap<V> {
    private static final IntTreePMap<Object> EMPTY = new IntTreePMap<>(IntTree.f24987a);
    private final IntTree<V> root;

    private IntTreePMap(IntTree<V> intTree) {
        this.root = intTree;
    }

    public static <V> IntTreePMap<V> empty() {
        return EMPTY;
    }

    private IntTreePMap<V> withRoot(IntTree<V> intTree) {
        if (intTree == this.root) {
            return this;
        }
        return new IntTreePMap<>(intTree);
    }

    public V get(int i11) {
        return this.root.a((long) i11);
    }

    public IntTreePMap<V> minus(int i11) {
        return withRoot(this.root.b((long) i11));
    }

    public IntTreePMap<V> plus(int i11, V v11) {
        return withRoot(this.root.c((long) i11, v11));
    }
}
