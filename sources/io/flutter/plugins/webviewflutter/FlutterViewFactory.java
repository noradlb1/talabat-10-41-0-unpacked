package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import xz.b;

class FlutterViewFactory extends PlatformViewFactory {
    private final InstanceManager instanceManager;

    public FlutterViewFactory(InstanceManager instanceManager2) {
        super(StandardMessageCodec.INSTANCE);
        this.instanceManager = instanceManager2;
    }

    @NonNull
    public PlatformView create(Context context, int i11, @Nullable Object obj) {
        Integer num = (Integer) obj;
        if (num != null) {
            final Object instance = this.instanceManager.getInstance((long) num.intValue());
            if (instance instanceof PlatformView) {
                return (PlatformView) instance;
            }
            if (instance instanceof View) {
                return new PlatformView() {
                    public void dispose() {
                    }

                    public View getView() {
                        return (View) instance;
                    }

                    public /* synthetic */ void onFlutterViewAttached(View view) {
                        b.a(this, view);
                    }

                    public /* synthetic */ void onFlutterViewDetached() {
                        b.b(this);
                    }

                    public /* synthetic */ void onInputConnectionLocked() {
                        b.c(this);
                    }

                    public /* synthetic */ void onInputConnectionUnlocked() {
                        b.d(this);
                    }
                };
            }
            throw new IllegalStateException("Unable to find a PlatformView or View instance: " + obj + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + instance);
        }
        throw new IllegalStateException("An identifier is required to retrieve a View instance.");
    }
}
