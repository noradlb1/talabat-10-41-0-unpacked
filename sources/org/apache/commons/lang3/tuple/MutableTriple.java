package org.apache.commons.lang3.tuple;

public class MutableTriple<L, M, R> extends Triple<L, M, R> {
    private static final long serialVersionUID = 1;
    public L left;
    public M middle;
    public R right;

    public MutableTriple() {
    }

    public static <L, M, R> MutableTriple<L, M, R> of(L l11, M m11, R r11) {
        return new MutableTriple<>(l11, m11, r11);
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

    public void setLeft(L l11) {
        this.left = l11;
    }

    public void setMiddle(M m11) {
        this.middle = m11;
    }

    public void setRight(R r11) {
        this.right = r11;
    }

    public MutableTriple(L l11, M m11, R r11) {
        this.left = l11;
        this.middle = m11;
        this.right = r11;
    }
}
