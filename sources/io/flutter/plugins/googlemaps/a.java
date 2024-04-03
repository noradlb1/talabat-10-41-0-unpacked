package io.flutter.plugins.googlemaps;

import io.flutter.plugins.googlemaps.TileProviderController;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TileProviderController.Worker f14337b;

    public /* synthetic */ a(TileProviderController.Worker worker) {
        this.f14337b = worker;
    }

    public final void run() {
        this.f14337b.lambda$getTile$0();
    }
}
