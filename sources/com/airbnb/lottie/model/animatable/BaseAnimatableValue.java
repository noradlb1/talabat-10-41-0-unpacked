package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {

    /* renamed from: a  reason: collision with root package name */
    public final List<Keyframe<V>> f40648a;

    public BaseAnimatableValue(V v11) {
        this(Collections.singletonList(new Keyframe(v11)));
    }

    public List<Keyframe<V>> getKeyframes() {
        return this.f40648a;
    }

    public boolean isStatic() {
        if (!this.f40648a.isEmpty()) {
            return this.f40648a.size() == 1 && this.f40648a.get(0).isStatic();
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.f40648a.isEmpty()) {
            sb2.append("values=");
            sb2.append(Arrays.toString(this.f40648a.toArray()));
        }
        return sb2.toString();
    }

    public BaseAnimatableValue(List<Keyframe<V>> list) {
        this.f40648a = list;
    }
}
