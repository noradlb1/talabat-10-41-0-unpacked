package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.internal.ServiceWorkerControllerImpl;

public abstract class ServiceWorkerControllerCompat {

    public static class LAZY_HOLDER {

        /* renamed from: a  reason: collision with root package name */
        public static final ServiceWorkerControllerCompat f37931a = new ServiceWorkerControllerImpl();

        private LAZY_HOLDER() {
        }
    }

    @NonNull
    public static ServiceWorkerControllerCompat getInstance() {
        return LAZY_HOLDER.f37931a;
    }

    @NonNull
    public abstract ServiceWorkerWebSettingsCompat getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(@Nullable ServiceWorkerClientCompat serviceWorkerClientCompat);
}
