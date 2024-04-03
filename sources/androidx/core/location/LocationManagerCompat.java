package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import i1.j0;
import i1.z;
import j$.util.function.Consumer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    @GuardedBy("sLocationListeners")

    /* renamed from: a  reason: collision with root package name */
    public static final WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> f11307a = new WeakHashMap<>();
    private static Field sContextField;
    private static Method sGnssRequestBuilderBuildMethod;
    private static Class<?> sGnssRequestBuilderClass;
    private static Method sRegisterGnssMeasurementsCallbackMethod;

    @RequiresApi(19)
    public static class Api19Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesLooperMethod;

        private Api19Impl() {
        }

        @DoNotInline
        public static boolean a(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerCompat locationListenerCompat, Looper looper) {
            try {
                if (sLocationRequestClass == null) {
                    sLocationRequestClass = Class.forName("android.location.LocationRequest");
                }
                if (sRequestLocationUpdatesLooperMethod == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});
                    sRequestLocationUpdatesLooperMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    sRequestLocationUpdatesLooperMethod.invoke(locationManager, new Object[]{locationRequest, locationListenerCompat, looper});
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static boolean b(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerTransport locationListenerTransport) {
            try {
                if (sLocationRequestClass == null) {
                    sLocationRequestClass = Class.forName("android.location.LocationRequest");
                }
                if (sRequestLocationUpdatesLooperMethod == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});
                    sRequestLocationUpdatesLooperMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    synchronized (LocationManagerCompat.f11307a) {
                        sRequestLocationUpdatesLooperMethod.invoke(locationManager, new Object[]{locationRequest, locationListenerTransport, Looper.getMainLooper()});
                        LocationManagerCompat.c(locationManager, locationListenerTransport);
                    }
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        public static boolean a(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback, @NonNull Handler handler) {
            return locationManager.registerGnssMeasurementsCallback(callback, handler);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static boolean b(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
            boolean z11;
            if (handler != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11);
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.f11309a;
            synchronized (simpleArrayMap) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap.get(callback);
                if (preRGnssStatusTransport == null) {
                    preRGnssStatusTransport = new PreRGnssStatusTransport(callback);
                } else {
                    preRGnssStatusTransport.unregister();
                }
                preRGnssStatusTransport.register(executor);
                if (!locationManager.registerGnssStatusCallback(preRGnssStatusTransport, handler)) {
                    return false;
                }
                simpleArrayMap.put(callback, preRGnssStatusTransport);
                return true;
            }
        }

        @DoNotInline
        public static void c(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback) {
            locationManager.unregisterGnssMeasurementsCallback(callback);
        }

        @DoNotInline
        public static void d(LocationManager locationManager, Object obj) {
            if (obj instanceof PreRGnssStatusTransport) {
                ((PreRGnssStatusTransport) obj).unregister();
            }
            locationManager.unregisterGnssStatusCallback((GnssStatus.Callback) obj);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static String a(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        @DoNotInline
        public static int b(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        @DoNotInline
        public static boolean c(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesExecutorMethod;

        private Api30Impl() {
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static void a(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
            android.os.CancellationSignal cancellationSignal2;
            if (cancellationSignal != null) {
                cancellationSignal2 = (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject();
            } else {
                cancellationSignal2 = null;
            }
            Objects.requireNonNull(consumer);
            locationManager.getCurrentLocation(str, cancellationSignal2, executor, Consumer.Wrapper.convert(new j0(consumer)));
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static boolean registerGnssStatusCallback(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.f11309a;
            synchronized (simpleArrayMap) {
                GnssStatusTransport gnssStatusTransport = (GnssStatusTransport) simpleArrayMap.get(callback);
                if (gnssStatusTransport == null) {
                    gnssStatusTransport = new GnssStatusTransport(callback);
                }
                if (!locationManager.registerGnssStatusCallback(executor, gnssStatusTransport)) {
                    return false;
                }
                simpleArrayMap.put(callback, gnssStatusTransport);
                return true;
            }
        }

        @DoNotInline
        public static boolean tryRequestLocationUpdates(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, Executor executor, LocationListenerCompat locationListenerCompat) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    if (sLocationRequestClass == null) {
                        sLocationRequestClass = Class.forName("android.location.LocationRequest");
                    }
                    if (sRequestLocationUpdatesExecutorMethod == null) {
                        Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, Executor.class, LocationListener.class});
                        sRequestLocationUpdatesExecutorMethod = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                    if (locationRequest != null) {
                        sRequestLocationUpdatesExecutorMethod.invoke(locationManager, new Object[]{locationRequest, executor, locationListenerCompat});
                        return true;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
                }
            }
            return false;
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static boolean a(LocationManager locationManager, @NonNull String str) {
            return locationManager.hasProvider(str);
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        public static boolean b(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent.Callback callback) {
            return locationManager.registerGnssMeasurementsCallback(executor, callback);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static void c(LocationManager locationManager, @NonNull String str, @NonNull LocationRequest locationRequest, @NonNull Executor executor, @NonNull LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    public static final class CancellableLocationListener implements LocationListener {
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Runnable f11308b;
        private androidx.core.util.Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler = new Handler(Looper.getMainLooper());
        @GuardedBy("this")
        private boolean mTriggered;

        public CancellableLocationListener(LocationManager locationManager, Executor executor, androidx.core.util.Consumer<Location> consumer) {
            this.mLocationManager = locationManager;
            this.mExecutor = executor;
            this.mConsumer = consumer;
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable runnable = this.f11308b;
            if (runnable != null) {
                this.mTimeoutHandler.removeCallbacks(runnable);
                this.f11308b = null;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$startTimeout$0() {
            this.f11308b = null;
            onLocationChanged((Location) null);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void cancel() {
            synchronized (this) {
                if (!this.mTriggered) {
                    this.mTriggered = true;
                    cleanup();
                }
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@Nullable Location location) {
            synchronized (this) {
                if (!this.mTriggered) {
                    this.mTriggered = true;
                    this.mExecutor.execute(new d(this.mConsumer, location));
                    cleanup();
                }
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@NonNull String str) {
            onLocationChanged((Location) null);
        }

        public void onProviderEnabled(@NonNull String str) {
        }

        public void onStatusChanged(String str, int i11, Bundle bundle) {
        }

        @SuppressLint({"MissingPermission"})
        public void startTimeout(long j11) {
            synchronized (this) {
                if (!this.mTriggered) {
                    c cVar = new c(this);
                    this.f11308b = cVar;
                    this.mTimeoutHandler.postDelayed(cVar, j11);
                }
            }
        }
    }

    public static class GnssListenersHolder {
        @GuardedBy("sGnssStatusListeners")

        /* renamed from: a  reason: collision with root package name */
        public static final SimpleArrayMap<Object, Object> f11309a = new SimpleArrayMap<>();

        private GnssListenersHolder() {
        }
    }

    @RequiresApi(30)
    public static class GnssStatusTransport extends GnssStatus.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final GnssStatusCompat.Callback f11310a;

        public GnssStatusTransport(GnssStatusCompat.Callback callback) {
            boolean z11;
            if (callback != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "invalid null callback");
            this.f11310a = callback;
        }

        public void onFirstFix(int i11) {
            this.f11310a.onFirstFix(i11);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.f11310a.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        public void onStarted() {
            this.f11310a.onStarted();
        }

        public void onStopped() {
            this.f11310a.onStopped();
        }
    }

    public static class GpsStatusTransport implements GpsStatus.Listener {

        /* renamed from: a  reason: collision with root package name */
        public final GnssStatusCompat.Callback f11311a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public volatile Executor f11312b;
        private final LocationManager mLocationManager;

        public GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            boolean z11;
            if (callback != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "invalid null callback");
            this.mLocationManager = locationManager;
            this.f11311a = callback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onGpsStatusChanged$0(Executor executor) {
            if (this.f11312b == executor) {
                this.f11311a.onStarted();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onGpsStatusChanged$1(Executor executor) {
            if (this.f11312b == executor) {
                this.f11311a.onStopped();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onGpsStatusChanged$2(Executor executor, int i11) {
            if (this.f11312b == executor) {
                this.f11311a.onFirstFix(i11);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onGpsStatusChanged$3(Executor executor, GnssStatusCompat gnssStatusCompat) {
            if (this.f11312b == executor) {
                this.f11311a.onSatelliteStatusChanged(gnssStatusCompat);
            }
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i11) {
            GpsStatus gpsStatus;
            Executor executor = this.f11312b;
            if (executor != null) {
                if (i11 == 1) {
                    executor.execute(new e(this, executor));
                } else if (i11 == 2) {
                    executor.execute(new f(this, executor));
                } else if (i11 == 3) {
                    GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus((GpsStatus) null);
                    if (gpsStatus2 != null) {
                        executor.execute(new g(this, executor, gpsStatus2.getTimeToFirstFix()));
                    }
                } else if (i11 == 4 && (gpsStatus = this.mLocationManager.getGpsStatus((GpsStatus) null)) != null) {
                    executor.execute(new h(this, executor, GnssStatusCompat.wrap(gpsStatus)));
                }
            }
        }

        public void register(Executor executor) {
            boolean z11;
            if (this.f11312b == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11);
            this.f11312b = executor;
        }

        public void unregister() {
            this.f11312b = null;
        }
    }

    public static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        public InlineHandlerExecutor(@NonNull Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        public void execute(@NonNull Runnable runnable) {
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                runnable.run();
            } else if (!this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }

    public static class LocationListenerKey {

        /* renamed from: a  reason: collision with root package name */
        public final String f11313a;

        /* renamed from: b  reason: collision with root package name */
        public final LocationListenerCompat f11314b;

        public LocationListenerKey(String str, LocationListenerCompat locationListenerCompat) {
            this.f11313a = (String) ObjectsCompat.requireNonNull(str, "invalid null provider");
            this.f11314b = (LocationListenerCompat) ObjectsCompat.requireNonNull(locationListenerCompat, "invalid null listener");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LocationListenerKey)) {
                return false;
            }
            LocationListenerKey locationListenerKey = (LocationListenerKey) obj;
            if (!this.f11313a.equals(locationListenerKey.f11313a) || !this.f11314b.equals(locationListenerKey.f11314b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f11313a, this.f11314b);
        }
    }

    @RequiresApi(24)
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final GnssStatusCompat.Callback f11317a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public volatile Executor f11318b;

        public PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            boolean z11;
            if (callback != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "invalid null callback");
            this.f11317a = callback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onFirstFix$2(Executor executor, int i11) {
            if (this.f11318b == executor) {
                this.f11317a.onFirstFix(i11);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onSatelliteStatusChanged$3(Executor executor, GnssStatus gnssStatus) {
            if (this.f11318b == executor) {
                this.f11317a.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onStarted$0(Executor executor) {
            if (this.f11318b == executor) {
                this.f11317a.onStarted();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onStopped$1(Executor executor) {
            if (this.f11318b == executor) {
                this.f11317a.onStopped();
            }
        }

        public void onFirstFix(int i11) {
            Executor executor = this.f11318b;
            if (executor != null) {
                executor.execute(new q(this, executor, i11));
            }
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            Executor executor = this.f11318b;
            if (executor != null) {
                executor.execute(new p(this, executor, gnssStatus));
            }
        }

        public void onStarted() {
            Executor executor = this.f11318b;
            if (executor != null) {
                executor.execute(new o(this, executor));
            }
        }

        public void onStopped() {
            Executor executor = this.f11318b;
            if (executor != null) {
                executor.execute(new r(this, executor));
            }
        }

        public void register(Executor executor) {
            boolean z11;
            boolean z12 = true;
            if (executor != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "invalid null executor");
            if (this.f11318b != null) {
                z12 = false;
            }
            Preconditions.checkState(z12);
            this.f11318b = executor;
        }

        public void unregister() {
            this.f11318b = null;
        }
    }

    private LocationManagerCompat() {
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @GuardedBy("sLocationListeners")
    public static void c(LocationManager locationManager, LocationListenerTransport locationListenerTransport) {
        LocationListenerTransport locationListenerTransport2;
        WeakReference put = f11307a.put(locationListenerTransport.getKey(), new WeakReference(locationListenerTransport));
        if (put != null) {
            locationListenerTransport2 = (LocationListenerTransport) put.get();
        } else {
            locationListenerTransport2 = null;
        }
        if (locationListenerTransport2 != null) {
            locationListenerTransport2.unregister();
            locationManager.removeUpdates(locationListenerTransport2);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull androidx.core.util.Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation == null || SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) >= 10000) {
            CancellableLocationListener cancellableLocationListener = new CancellableLocationListener(locationManager, executor, consumer);
            locationManager.requestLocationUpdates(str, 0, 0.0f, cancellableLocationListener, Looper.getMainLooper());
            if (cancellationSignal != null) {
                cancellationSignal.setOnCancelListener(new b(cancellableLocationListener));
            }
            cancellableLocationListener.startTimeout(30000);
            return;
        }
        executor.execute(new z(consumer, lastKnownLocation));
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.b(locationManager);
        }
        return 0;
    }

    public static boolean hasProvider(@NonNull LocationManager locationManager, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.a(locationManager, str);
        }
        if (locationManager.getAllProviders().contains(str)) {
            return true;
        }
        try {
            if (locationManager.getProvider(str) != null) {
                return true;
            }
            return false;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.c(locationManager);
        }
        if (locationManager.isProviderEnabled(SDKCoreEvent.Network.TYPE_NETWORK) || locationManager.isProviderEnabled("gps")) {
            return true;
        }
        return false;
    }

    @RequiresApi(24)
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT != 30) {
            return Api24Impl.a(locationManager, callback, handler);
        }
        return registerGnssMeasurementsCallbackOnR(locationManager, ExecutorCompat.create(handler), callback);
    }

    @RequiresApi(30)
    private static boolean registerGnssMeasurementsCallbackOnR(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent.Callback callback) {
        if (Build.VERSION.SDK_INT == 30) {
            try {
                if (sGnssRequestBuilderClass == null) {
                    sGnssRequestBuilderClass = Class.forName("android.location.GnssRequest$Builder");
                }
                if (sGnssRequestBuilderBuildMethod == null) {
                    Method declaredMethod = sGnssRequestBuilderClass.getDeclaredMethod("build", new Class[0]);
                    sGnssRequestBuilderBuildMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                if (sRegisterGnssMeasurementsCallbackMethod == null) {
                    Method declaredMethod2 = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", new Class[]{Class.forName("android.location.GnssRequest"), Executor.class, GnssMeasurementsEvent.Callback.class});
                    sRegisterGnssMeasurementsCallbackMethod = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                Object invoke = sRegisterGnssMeasurementsCallbackMethod.invoke(locationManager, new Object[]{sGnssRequestBuilderBuildMethod.invoke(sGnssRequestBuilderClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]), executor, callback});
                if (invoke == null || !((Boolean) invoke).booleanValue()) {
                    return false;
                }
                return true;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
        }
        return registerGnssStatusCallback(locationManager, (Executor) new InlineHandlerExecutor(handler), callback);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void removeUpdates(@NonNull LocationManager locationManager, @NonNull LocationListenerCompat locationListenerCompat) {
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> weakHashMap = f11307a;
        synchronized (weakHashMap) {
            ArrayList arrayList = null;
            for (WeakReference<LocationListenerTransport> weakReference : weakHashMap.values()) {
                LocationListenerTransport locationListenerTransport = (LocationListenerTransport) weakReference.get();
                if (locationListenerTransport != null) {
                    LocationListenerKey key = locationListenerTransport.getKey();
                    if (key.f11314b == locationListenerCompat) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(key);
                        locationListenerTransport.unregister();
                        locationManager.removeUpdates(locationListenerTransport);
                    }
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    f11307a.remove((LocationListenerKey) it.next());
                }
            }
        }
        locationManager.removeUpdates(locationListenerCompat);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull Executor executor, @NonNull LocationListenerCompat locationListenerCompat) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31) {
            Api31Impl.c(locationManager, str, locationRequestCompat.toLocationRequest(), executor, locationListenerCompat);
        } else if (i11 < 30 || !Api30Impl.tryRequestLocationUpdates(locationManager, str, locationRequestCompat, executor, locationListenerCompat)) {
            LocationListenerTransport locationListenerTransport = new LocationListenerTransport(new LocationListenerKey(str, locationListenerCompat), executor);
            if (!Api19Impl.b(locationManager, str, locationRequestCompat, locationListenerTransport)) {
                synchronized (f11307a) {
                    locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerTransport, Looper.getMainLooper());
                    c(locationManager, locationListenerTransport);
                }
            }
        }
    }

    @RequiresApi(24)
    public static void unregisterGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback) {
        Api24Impl.c(locationManager, callback);
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 24) {
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.f11309a;
            synchronized (simpleArrayMap) {
                Object remove = simpleArrayMap.remove(callback);
                if (remove != null) {
                    Api24Impl.d(locationManager, remove);
                }
            }
            return;
        }
        SimpleArrayMap<Object, Object> simpleArrayMap2 = GnssListenersHolder.f11309a;
        synchronized (simpleArrayMap2) {
            GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) simpleArrayMap2.remove(callback);
            if (gpsStatusTransport != null) {
                gpsStatusTransport.unregister();
                locationManager.removeGpsStatusListener(gpsStatusTransport);
            }
        }
    }

    public static class LocationListenerTransport implements LocationListener {
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public volatile LocationListenerKey f11315b;

        /* renamed from: c  reason: collision with root package name */
        public final Executor f11316c;

        public LocationListenerTransport(@Nullable LocationListenerKey locationListenerKey, Executor executor) {
            this.f11315b = locationListenerKey;
            this.f11316c = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onFlushComplete$2(int i11) {
            LocationListenerKey locationListenerKey = this.f11315b;
            if (locationListenerKey != null) {
                locationListenerKey.f11314b.onFlushComplete(i11);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onLocationChanged$0(Location location) {
            LocationListenerKey locationListenerKey = this.f11315b;
            if (locationListenerKey != null) {
                locationListenerKey.f11314b.onLocationChanged(location);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onLocationChanged$1(List list) {
            LocationListenerKey locationListenerKey = this.f11315b;
            if (locationListenerKey != null) {
                locationListenerKey.f11314b.onLocationChanged(list);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onProviderDisabled$5(String str) {
            LocationListenerKey locationListenerKey = this.f11315b;
            if (locationListenerKey != null) {
                locationListenerKey.f11314b.onProviderDisabled(str);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onProviderEnabled$4(String str) {
            LocationListenerKey locationListenerKey = this.f11315b;
            if (locationListenerKey != null) {
                locationListenerKey.f11314b.onProviderEnabled(str);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onStatusChanged$3(String str, int i11, Bundle bundle) {
            LocationListenerKey locationListenerKey = this.f11315b;
            if (locationListenerKey != null) {
                locationListenerKey.f11314b.onStatusChanged(str, i11, bundle);
            }
        }

        public LocationListenerKey getKey() {
            return (LocationListenerKey) ObjectsCompat.requireNonNull(this.f11315b);
        }

        public void onFlushComplete(int i11) {
            if (this.f11315b != null) {
                this.f11316c.execute(new j(this, i11));
            }
        }

        public void onLocationChanged(@NonNull Location location) {
            if (this.f11315b != null) {
                this.f11316c.execute(new m(this, location));
            }
        }

        public void onProviderDisabled(@NonNull String str) {
            if (this.f11315b != null) {
                this.f11316c.execute(new l(this, str));
            }
        }

        public void onProviderEnabled(@NonNull String str) {
            if (this.f11315b != null) {
                this.f11316c.execute(new i(this, str));
            }
        }

        public void onStatusChanged(String str, int i11, Bundle bundle) {
            if (this.f11315b != null) {
                this.f11316c.execute(new n(this, str, i11, bundle));
            }
        }

        public void unregister() {
            this.f11315b = null;
        }

        public void onLocationChanged(@NonNull List<Location> list) {
            if (this.f11315b != null) {
                this.f11316c.execute(new k(this, list));
            }
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, (Handler) null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new Handler(myLooper), executor, callback);
    }

    @RequiresApi(30)
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent.Callback callback) {
        if (Build.VERSION.SDK_INT > 30) {
            return Api31Impl.b(locationManager, executor, callback);
        }
        return registerGnssMeasurementsCallbackOnR(locationManager, executor, callback);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0089, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0093 */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c5 A[Catch:{ ExecutionException -> 0x00bb, TimeoutException -> 0x00a2, all -> 0x009f, all -> 0x00e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00da A[Catch:{ ExecutionException -> 0x00bb, TimeoutException -> 0x00a2, all -> 0x009f, all -> 0x00e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00e4 A[SYNTHETIC, Splitter:B:72:0x00e4] */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean registerGnssStatusCallback(android.location.LocationManager r9, android.os.Handler r10, java.util.concurrent.Executor r11, androidx.core.location.GnssStatusCompat.Callback r12) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L_0x000b
            boolean r9 = androidx.core.location.LocationManagerCompat.Api30Impl.registerGnssStatusCallback(r9, r10, r11, r12)
            return r9
        L_0x000b:
            r1 = 24
            if (r0 < r1) goto L_0x0014
            boolean r9 = androidx.core.location.LocationManagerCompat.Api24Impl.b(r9, r10, r11, r12)
            return r9
        L_0x0014:
            r0 = 1
            r1 = 0
            if (r10 == 0) goto L_0x001a
            r2 = r0
            goto L_0x001b
        L_0x001a:
            r2 = r1
        L_0x001b:
            androidx.core.util.Preconditions.checkArgument(r2)
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r2 = androidx.core.location.LocationManagerCompat.GnssListenersHolder.f11309a
            monitor-enter(r2)
            java.lang.Object r3 = r2.get(r12)     // Catch:{ all -> 0x0103 }
            androidx.core.location.LocationManagerCompat$GpsStatusTransport r3 = (androidx.core.location.LocationManagerCompat.GpsStatusTransport) r3     // Catch:{ all -> 0x0103 }
            if (r3 != 0) goto L_0x002f
            androidx.core.location.LocationManagerCompat$GpsStatusTransport r3 = new androidx.core.location.LocationManagerCompat$GpsStatusTransport     // Catch:{ all -> 0x0103 }
            r3.<init>(r9, r12)     // Catch:{ all -> 0x0103 }
            goto L_0x0032
        L_0x002f:
            r3.unregister()     // Catch:{ all -> 0x0103 }
        L_0x0032:
            r3.register(r11)     // Catch:{ all -> 0x0103 }
            java.util.concurrent.FutureTask r11 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x0103 }
            androidx.core.location.a r4 = new androidx.core.location.a     // Catch:{ all -> 0x0103 }
            r4.<init>(r9, r3)     // Catch:{ all -> 0x0103 }
            r11.<init>(r4)     // Catch:{ all -> 0x0103 }
            android.os.Looper r9 = android.os.Looper.myLooper()     // Catch:{ all -> 0x0103 }
            android.os.Looper r4 = r10.getLooper()     // Catch:{ all -> 0x0103 }
            if (r9 != r4) goto L_0x004d
            r11.run()     // Catch:{ all -> 0x0103 }
            goto L_0x0053
        L_0x004d:
            boolean r9 = r10.post(r11)     // Catch:{ all -> 0x0103 }
            if (r9 == 0) goto L_0x00ec
        L_0x0053:
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x00bb, TimeoutException -> 0x00a2, all -> 0x009f }
            r4 = 5
            long r4 = r9.toNanos(r4)     // Catch:{ ExecutionException -> 0x00bb, TimeoutException -> 0x00a2, all -> 0x009f }
            long r6 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x00bb, TimeoutException -> 0x00a2, all -> 0x009f }
            long r6 = r6 + r4
            r9 = r1
        L_0x0061:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x0093, ExecutionException -> 0x0090, TimeoutException -> 0x008d, all -> 0x008a }
            java.lang.Object r4 = r11.get(r4, r8)     // Catch:{ InterruptedException -> 0x0093, ExecutionException -> 0x0090, TimeoutException -> 0x008d, all -> 0x008a }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ InterruptedException -> 0x0093, ExecutionException -> 0x0090, TimeoutException -> 0x008d, all -> 0x008a }
            boolean r4 = r4.booleanValue()     // Catch:{ InterruptedException -> 0x0093, ExecutionException -> 0x0090, TimeoutException -> 0x008d, all -> 0x008a }
            if (r4 == 0) goto L_0x007f
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r4 = androidx.core.location.LocationManagerCompat.GnssListenersHolder.f11309a     // Catch:{ InterruptedException -> 0x0093, ExecutionException -> 0x0090, TimeoutException -> 0x008d, all -> 0x008a }
            r4.put(r12, r3)     // Catch:{ InterruptedException -> 0x0093, ExecutionException -> 0x0090, TimeoutException -> 0x008d, all -> 0x008a }
            if (r9 == 0) goto L_0x007d
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0103 }
            r9.interrupt()     // Catch:{ all -> 0x0103 }
        L_0x007d:
            monitor-exit(r2)     // Catch:{ all -> 0x0103 }
            return r0
        L_0x007f:
            if (r9 == 0) goto L_0x0088
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0103 }
            r9.interrupt()     // Catch:{ all -> 0x0103 }
        L_0x0088:
            monitor-exit(r2)     // Catch:{ all -> 0x0103 }
            return r1
        L_0x008a:
            r10 = move-exception
            r0 = r9
            goto L_0x00e2
        L_0x008d:
            r11 = move-exception
            r0 = r9
            goto L_0x00a4
        L_0x0090:
            r10 = move-exception
            r0 = r9
            goto L_0x00bd
        L_0x0093:
            long r4 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x009d, TimeoutException -> 0x009b }
            long r4 = r6 - r4
            r9 = r0
            goto L_0x0061
        L_0x009b:
            r11 = move-exception
            goto L_0x00a4
        L_0x009d:
            r10 = move-exception
            goto L_0x00bd
        L_0x009f:
            r10 = move-exception
            r0 = r1
            goto L_0x00e2
        L_0x00a2:
            r11 = move-exception
            r0 = r1
        L_0x00a4:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e1 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e1 }
            r12.<init>()     // Catch:{ all -> 0x00e1 }
            r12.append(r10)     // Catch:{ all -> 0x00e1 }
            java.lang.String r10 = " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread"
            r12.append(r10)     // Catch:{ all -> 0x00e1 }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x00e1 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x00e1 }
            throw r9     // Catch:{ all -> 0x00e1 }
        L_0x00bb:
            r10 = move-exception
            r0 = r1
        L_0x00bd:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00e1 }
            boolean r9 = r9 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x00e1 }
            if (r9 != 0) goto L_0x00da
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00e1 }
            boolean r9 = r9 instanceof java.lang.Error     // Catch:{ all -> 0x00e1 }
            if (r9 == 0) goto L_0x00d4
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00e1 }
            java.lang.Error r9 = (java.lang.Error) r9     // Catch:{ all -> 0x00e1 }
            throw r9     // Catch:{ all -> 0x00e1 }
        L_0x00d4:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e1 }
            r9.<init>(r10)     // Catch:{ all -> 0x00e1 }
            throw r9     // Catch:{ all -> 0x00e1 }
        L_0x00da:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00e1 }
            java.lang.RuntimeException r9 = (java.lang.RuntimeException) r9     // Catch:{ all -> 0x00e1 }
            throw r9     // Catch:{ all -> 0x00e1 }
        L_0x00e1:
            r10 = move-exception
        L_0x00e2:
            if (r0 == 0) goto L_0x00eb
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0103 }
            r9.interrupt()     // Catch:{ all -> 0x0103 }
        L_0x00eb:
            throw r10     // Catch:{ all -> 0x0103 }
        L_0x00ec:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0103 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r11.<init>()     // Catch:{ all -> 0x0103 }
            r11.append(r10)     // Catch:{ all -> 0x0103 }
            java.lang.String r10 = " is shutting down"
            r11.append(r10)     // Catch:{ all -> 0x0103 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0103 }
            r9.<init>(r10)     // Catch:{ all -> 0x0103 }
            throw r9     // Catch:{ all -> 0x0103 }
        L_0x0103:
            r9 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0103 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.location.LocationManagerCompat.registerGnssStatusCallback(android.location.LocationManager, android.os.Handler, java.util.concurrent.Executor, androidx.core.location.GnssStatusCompat$Callback):boolean");
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull LocationListenerCompat locationListenerCompat, @NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.c(locationManager, str, locationRequestCompat.toLocationRequest(), ExecutorCompat.create(new Handler(looper)), locationListenerCompat);
        } else if (!Api19Impl.a(locationManager, str, locationRequestCompat, locationListenerCompat, looper)) {
            locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerCompat, looper);
        }
    }
}
