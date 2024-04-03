package io.flutter.plugins.googlemaps;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

class TileProviderController implements TileProvider {
    private static final String TAG = "TileProviderController";
    /* access modifiers changed from: private */
    public final Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final MethodChannel methodChannel;
    /* access modifiers changed from: private */
    public final String tileOverlayId;

    public final class Worker implements MethodChannel.Result {
        private final CountDownLatch countDownLatch = new CountDownLatch(1);
        private Map<String, ?> result;

        /* renamed from: x  reason: collision with root package name */
        private final int f14335x;

        /* renamed from: y  reason: collision with root package name */
        private final int f14336y;
        private final int zoom;

        public Worker(int i11, int i12, int i13) {
            this.f14335x = i11;
            this.f14336y = i12;
            this.zoom = i13;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$getTile$0() {
            TileProviderController.this.methodChannel.invokeMethod("tileOverlay#getTile", Convert.p(TileProviderController.this.tileOverlayId, this.f14335x, this.f14336y, this.zoom), this);
        }

        @NonNull
        public Tile b() {
            TileProviderController.this.handler.post(new a(this));
            try {
                this.countDownLatch.await();
                try {
                    return Convert.h(this.result);
                } catch (Exception e11) {
                    Log.e(TileProviderController.TAG, "Can't parse tile data", e11);
                    return TileProvider.NO_TILE;
                }
            } catch (InterruptedException e12) {
                Log.e(TileProviderController.TAG, String.format("countDownLatch: can't get tile: x = %d, y= %d, zoom = %d", new Object[]{Integer.valueOf(this.f14335x), Integer.valueOf(this.f14336y), Integer.valueOf(this.zoom)}), e12);
                return TileProvider.NO_TILE;
            }
        }

        public void error(String str, String str2, Object obj) {
            Log.e(TileProviderController.TAG, String.format("Can't get tile: errorCode = %s, errorMessage = %s, date = %s", new Object[]{str, str, obj}));
            this.result = null;
            this.countDownLatch.countDown();
        }

        public void notImplemented() {
            Log.e(TileProviderController.TAG, "Can't get tile: notImplemented");
            this.result = null;
            this.countDownLatch.countDown();
        }

        public void success(Object obj) {
            this.result = (Map) obj;
            this.countDownLatch.countDown();
        }
    }

    public TileProviderController(MethodChannel methodChannel2, String str) {
        this.tileOverlayId = str;
        this.methodChannel = methodChannel2;
    }

    public Tile getTile(int i11, int i12, int i13) {
        return new Worker(i11, i12, i13).b();
    }
}
