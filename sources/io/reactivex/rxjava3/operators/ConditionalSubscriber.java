package io.reactivex.rxjava3.operators;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;

public interface ConditionalSubscriber<T> extends FlowableSubscriber<T> {
    boolean tryOnNext(@NonNull T t11);
}
