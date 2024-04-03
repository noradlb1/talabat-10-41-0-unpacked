package org.apache.commons.lang3.tuple;

public final class ImmutablePair<L, R> extends Pair<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    public ImmutablePair(L l11, R r11) {
        this.left = l11;
        this.right = r11;
    }

    public static <L, R> ImmutablePair<L, R> of(L l11, R r11) {
        return new ImmutablePair<>(l11, r11);
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }

    public R setValue(R r11) {
        throw new UnsupportedOperationException();
    }
}
