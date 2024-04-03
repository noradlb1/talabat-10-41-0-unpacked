package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DartMessenger.SerialTaskQueue f14183b;

    public /* synthetic */ b(DartMessenger.SerialTaskQueue serialTaskQueue) {
        this.f14183b = serialTaskQueue;
    }

    public final void run() {
        this.f14183b.lambda$flush$1();
    }
}
