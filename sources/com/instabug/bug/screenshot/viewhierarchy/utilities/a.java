package com.instabug.bug.screenshot.viewhierarchy.utilities;

import net.bytebuddy.pool.TypePool;

class a implements CharSequence {

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f45761a;

    public a(CharSequence charSequence) {
        this.f45761a = charSequence;
    }

    public char charAt(int i11) {
        return TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH;
    }

    public int length() {
        return this.f45761a.length();
    }

    public CharSequence subSequence(int i11, int i12) {
        return this.f45761a.subSequence(i11, i12);
    }
}
