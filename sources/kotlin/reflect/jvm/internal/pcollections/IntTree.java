package kotlin.reflect.jvm.internal.pcollections;

final class IntTree<V> {

    /* renamed from: a  reason: collision with root package name */
    public static final IntTree<Object> f24987a = new IntTree<>();
    private final long key;
    private final IntTree<V> left;
    private final IntTree<V> right;
    private final int size;
    private final V value;

    private IntTree() {
        this.size = 0;
        this.key = 0;
        this.value = null;
        this.left = null;
        this.right = null;
    }

    private long minKey() {
        IntTree<V> intTree = this.left;
        if (intTree.size == 0) {
            return this.key;
        }
        return intTree.minKey() + this.key;
    }

    private IntTree<V> rebalanced(IntTree<V> intTree, IntTree<V> intTree2) {
        if (intTree == this.left && intTree2 == this.right) {
            return this;
        }
        return rebalanced(this.key, this.value, intTree, intTree2);
    }

    private IntTree<V> withKey(long j11) {
        if (this.size == 0 || j11 == this.key) {
            return this;
        }
        return new IntTree(j11, this.value, this.left, this.right);
    }

    public V a(long j11) {
        if (this.size == 0) {
            return null;
        }
        long j12 = this.key;
        if (j11 < j12) {
            return this.left.a(j11 - j12);
        }
        if (j11 > j12) {
            return this.right.a(j11 - j12);
        }
        return this.value;
    }

    public IntTree<V> b(long j11) {
        if (this.size == 0) {
            return this;
        }
        long j12 = this.key;
        if (j11 < j12) {
            return rebalanced(this.left.b(j11 - j12), this.right);
        }
        if (j11 > j12) {
            return rebalanced(this.left, this.right.b(j11 - j12));
        }
        IntTree<V> intTree = this.left;
        if (intTree.size == 0) {
            IntTree<V> intTree2 = this.right;
            return intTree2.withKey(intTree2.key + j12);
        }
        IntTree<V> intTree3 = this.right;
        if (intTree3.size == 0) {
            return intTree.withKey(intTree.key + j12);
        }
        long minKey = intTree3.minKey();
        long j13 = this.key;
        long j14 = minKey + j13;
        V a11 = this.right.a(j14 - j13);
        IntTree<V> b11 = this.right.b(j14 - this.key);
        IntTree<V> withKey = b11.withKey((b11.key + this.key) - j14);
        IntTree<V> intTree4 = this.left;
        return rebalanced(j14, a11, intTree4.withKey((intTree4.key + this.key) - j14), withKey);
    }

    public IntTree<V> c(long j11, V v11) {
        if (this.size == 0) {
            return new IntTree(j11, v11, this, this);
        }
        long j12 = this.key;
        if (j11 < j12) {
            return rebalanced(this.left.c(j11 - j12, v11), this.right);
        }
        if (j11 > j12) {
            return rebalanced(this.left, this.right.c(j11 - j12, v11));
        }
        if (v11 == this.value) {
            return this;
        }
        return new IntTree(j11, v11, this.left, this.right);
    }

    private static <V> IntTree<V> rebalanced(long j11, V v11, IntTree<V> intTree, IntTree<V> intTree2) {
        IntTree<V> intTree3 = intTree;
        int i11 = intTree3.size;
        int i12 = intTree2.size;
        if (i11 + i12 > 1) {
            if (i11 >= i12 * 5) {
                IntTree<V> intTree4 = intTree3.left;
                IntTree<V> intTree5 = intTree3.right;
                if (intTree5.size < intTree4.size * 2) {
                    long j12 = intTree3.key;
                    return new IntTree(j12 + j11, intTree3.value, intTree4, new IntTree(-j12, v11, intTree5.withKey(intTree5.key + j12), intTree2));
                }
                IntTree<V> intTree6 = intTree5.left;
                IntTree<V> intTree7 = intTree5.right;
                long j13 = intTree5.key;
                long j14 = intTree3.key + j13 + j11;
                V v12 = intTree5.value;
                V v13 = v12;
                IntTree intTree8 = new IntTree(-j13, intTree3.value, intTree4, intTree6.withKey(intTree6.key + j13));
                long j15 = intTree3.key;
                long j16 = intTree5.key;
                return new IntTree(j14, v13, intTree8, new IntTree((-j15) - j16, v11, intTree7.withKey(intTree7.key + j16 + j15), intTree2));
            }
            IntTree<V> intTree9 = intTree2;
            if (i12 >= i11 * 5) {
                IntTree<V> intTree10 = intTree9.left;
                IntTree<V> intTree11 = intTree9.right;
                if (intTree10.size < intTree11.size * 2) {
                    long j17 = intTree9.key;
                    return new IntTree(j17 + j11, intTree9.value, new IntTree(-j17, v11, intTree, intTree10.withKey(intTree10.key + j17)), intTree11);
                }
                IntTree<V> intTree12 = intTree10.left;
                IntTree<V> intTree13 = intTree10.right;
                long j18 = intTree10.key;
                long j19 = intTree9.key;
                V v14 = intTree10.value;
                long j21 = j18 + j19 + j11;
                IntTree intTree14 = new IntTree((-j19) - j18, v11, intTree, intTree12.withKey(intTree12.key + j18 + j19));
                long j22 = intTree10.key;
                return new IntTree(j21, v14, intTree14, new IntTree(-j22, intTree9.value, intTree13.withKey(intTree13.key + j22), intTree11));
            }
        }
        return new IntTree(j11, v11, intTree, intTree2);
    }

    private IntTree(long j11, V v11, IntTree<V> intTree, IntTree<V> intTree2) {
        this.key = j11;
        this.value = v11;
        this.left = intTree;
        this.right = intTree2;
        this.size = intTree.size + 1 + intTree2.size;
    }
}
