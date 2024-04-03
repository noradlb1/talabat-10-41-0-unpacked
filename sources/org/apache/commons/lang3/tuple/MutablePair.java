package org.apache.commons.lang3.tuple;

public class MutablePair<L, R> extends Pair<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public L left;
    public R right;

    public MutablePair() {
    }

    public static <L, R> MutablePair<L, R> of(L l11, R r11) {
        return new MutablePair<>(l11, r11);
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }

    public void setLeft(L l11) {
        this.left = l11;
    }

    public void setRight(R r11) {
        this.right = r11;
    }

    public R setValue(R r11) {
        R right2 = getRight();
        setRight(r11);
        return right2;
    }

    public MutablePair(L l11, R r11) {
        this.left = l11;
        this.right = r11;
    }
}
