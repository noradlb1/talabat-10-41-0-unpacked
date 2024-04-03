package org.apache.commons.lang3.tuple;

public final class ImmutableTriple<L, M, R> extends Triple<L, M, R> {
    private static final long serialVersionUID = 1;
    public final L left;
    public final M middle;
    public final R right;

    public ImmutableTriple(L l11, M m11, R r11) {
        this.left = l11;
        this.middle = m11;
        this.right = r11;
    }

    public static <L, M, R> ImmutableTriple<L, M, R> of(L l11, M m11, R r11) {
        return new ImmutableTriple<>(l11, m11, r11);
    }

    public L getLeft() {
        return this.left;
    }

    public M getMiddle() {
        return this.middle;
    }

    public R getRight() {
        return this.right;
    }
}
