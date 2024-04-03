package io.reactivex.rxjava3.operators;

import io.reactivex.rxjava3.disposables.Disposable;

public interface QueueDisposable<T> extends QueueFuseable<T>, Disposable {
}
