package io.reactivex.rxjava3.operators;

import org.reactivestreams.Subscription;

public interface QueueSubscription<T> extends QueueFuseable<T>, Subscription {
}
