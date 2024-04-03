package com.talabat.feature.nfvinvendorsearch.presentation.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/fragment/QCommerceFlutterFragmentArgs;", "Landroidx/navigation/NavArgs;", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "(Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;)V", "getConfigurationParams", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "getRoute", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceFlutterFragmentArgs implements NavArgs {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final FlutterConfigurationParams configurationParams;
    @NotNull
    private final FlutterRoute route;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/fragment/QCommerceFlutterFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/talabat/feature/nfvinvendorsearch/presentation/fragment/QCommerceFlutterFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final QCommerceFlutterFragmentArgs fromBundle(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(QCommerceFlutterFragmentArgs.class.getClassLoader());
            if (bundle.containsKey(Constants.ARG_CONFIGURATION_PARAMS)) {
                Class<Parcelable> cls = Parcelable.class;
                Class<FlutterConfigurationParams> cls2 = FlutterConfigurationParams.class;
                Class<Serializable> cls3 = Serializable.class;
                if (cls.isAssignableFrom(cls2) || cls3.isAssignableFrom(cls2)) {
                    FlutterConfigurationParams flutterConfigurationParams = (FlutterConfigurationParams) bundle.get(Constants.ARG_CONFIGURATION_PARAMS);
                    if (flutterConfigurationParams == null) {
                        throw new IllegalArgumentException("Argument \"configurationParams\" is marked as non-null but was passed a null value.");
                    } else if (bundle.containsKey(Constants.ARG_ROUTE)) {
                        Class<FlutterRoute> cls4 = FlutterRoute.class;
                        if (cls.isAssignableFrom(cls4) || cls3.isAssignableFrom(cls4)) {
                            FlutterRoute flutterRoute = (FlutterRoute) bundle.get(Constants.ARG_ROUTE);
                            if (flutterRoute != null) {
                                return new QCommerceFlutterFragmentArgs(flutterConfigurationParams, flutterRoute);
                            }
                            throw new IllegalArgumentException("Argument \"route\" is marked as non-null but was passed a null value.");
                        }
                        String name2 = cls4.getName();
                        throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
                    } else {
                        throw new IllegalArgumentException("Required argument \"route\" is missing and does not have an android:defaultValue");
                    }
                } else {
                    String name3 = cls2.getName();
                    throw new UnsupportedOperationException(name3 + " must implement Parcelable or Serializable or must be an Enum.");
                }
            } else {
                throw new IllegalArgumentException("Required argument \"configurationParams\" is missing and does not have an android:defaultValue");
            }
        }

        @JvmStatic
        @NotNull
        public final QCommerceFlutterFragmentArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains(Constants.ARG_CONFIGURATION_PARAMS)) {
                Class<Parcelable> cls = Parcelable.class;
                Class<FlutterConfigurationParams> cls2 = FlutterConfigurationParams.class;
                Class<Serializable> cls3 = Serializable.class;
                if (cls.isAssignableFrom(cls2) || cls3.isAssignableFrom(cls2)) {
                    FlutterConfigurationParams flutterConfigurationParams = (FlutterConfigurationParams) savedStateHandle.get(Constants.ARG_CONFIGURATION_PARAMS);
                    if (flutterConfigurationParams == null) {
                        throw new IllegalArgumentException("Argument \"configurationParams\" is marked as non-null but was passed a null value");
                    } else if (savedStateHandle.contains(Constants.ARG_ROUTE)) {
                        Class<FlutterRoute> cls4 = FlutterRoute.class;
                        if (cls.isAssignableFrom(cls4) || cls3.isAssignableFrom(cls4)) {
                            FlutterRoute flutterRoute = (FlutterRoute) savedStateHandle.get(Constants.ARG_ROUTE);
                            if (flutterRoute != null) {
                                return new QCommerceFlutterFragmentArgs(flutterConfigurationParams, flutterRoute);
                            }
                            throw new IllegalArgumentException("Argument \"route\" is marked as non-null but was passed a null value");
                        }
                        String name2 = cls4.getName();
                        throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
                    } else {
                        throw new IllegalArgumentException("Required argument \"route\" is missing and does not have an android:defaultValue");
                    }
                } else {
                    String name3 = cls2.getName();
                    throw new UnsupportedOperationException(name3 + " must implement Parcelable or Serializable or must be an Enum.");
                }
            } else {
                throw new IllegalArgumentException("Required argument \"configurationParams\" is missing and does not have an android:defaultValue");
            }
        }
    }

    public QCommerceFlutterFragmentArgs(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
        Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
        this.configurationParams = flutterConfigurationParams;
        this.route = flutterRoute;
    }

    public static /* synthetic */ QCommerceFlutterFragmentArgs copy$default(QCommerceFlutterFragmentArgs qCommerceFlutterFragmentArgs, FlutterConfigurationParams flutterConfigurationParams, FlutterRoute flutterRoute, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            flutterConfigurationParams = qCommerceFlutterFragmentArgs.configurationParams;
        }
        if ((i11 & 2) != 0) {
            flutterRoute = qCommerceFlutterFragmentArgs.route;
        }
        return qCommerceFlutterFragmentArgs.copy(flutterConfigurationParams, flutterRoute);
    }

    @JvmStatic
    @NotNull
    public static final QCommerceFlutterFragmentArgs fromBundle(@NotNull Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    @NotNull
    public static final QCommerceFlutterFragmentArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    @NotNull
    public final FlutterConfigurationParams component1() {
        return this.configurationParams;
    }

    @NotNull
    public final FlutterRoute component2() {
        return this.route;
    }

    @NotNull
    public final QCommerceFlutterFragmentArgs copy(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
        Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
        return new QCommerceFlutterFragmentArgs(flutterConfigurationParams, flutterRoute);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QCommerceFlutterFragmentArgs)) {
            return false;
        }
        QCommerceFlutterFragmentArgs qCommerceFlutterFragmentArgs = (QCommerceFlutterFragmentArgs) obj;
        return Intrinsics.areEqual((Object) this.configurationParams, (Object) qCommerceFlutterFragmentArgs.configurationParams) && Intrinsics.areEqual((Object) this.route, (Object) qCommerceFlutterFragmentArgs.route);
    }

    @NotNull
    public final FlutterConfigurationParams getConfigurationParams() {
        return this.configurationParams;
    }

    @NotNull
    public final FlutterRoute getRoute() {
        return this.route;
    }

    public int hashCode() {
        return (this.configurationParams.hashCode() * 31) + this.route.hashCode();
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        Class<Parcelable> cls = Parcelable.class;
        Class<FlutterConfigurationParams> cls2 = FlutterConfigurationParams.class;
        Class<Serializable> cls3 = Serializable.class;
        if (cls.isAssignableFrom(cls2)) {
            bundle.putParcelable(Constants.ARG_CONFIGURATION_PARAMS, this.configurationParams);
        } else if (cls3.isAssignableFrom(cls2)) {
            bundle.putSerializable(Constants.ARG_CONFIGURATION_PARAMS, (Serializable) this.configurationParams);
        } else {
            String name2 = cls2.getName();
            throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        Class<FlutterRoute> cls4 = FlutterRoute.class;
        if (cls.isAssignableFrom(cls4)) {
            bundle.putParcelable(Constants.ARG_ROUTE, this.route);
        } else if (cls3.isAssignableFrom(cls4)) {
            bundle.putSerializable(Constants.ARG_ROUTE, (Serializable) this.route);
        } else {
            String name3 = cls4.getName();
            throw new UnsupportedOperationException(name3 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        return bundle;
    }

    @NotNull
    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        Class<Parcelable> cls = Parcelable.class;
        Class<FlutterConfigurationParams> cls2 = FlutterConfigurationParams.class;
        Class<Serializable> cls3 = Serializable.class;
        if (cls.isAssignableFrom(cls2)) {
            savedStateHandle.set(Constants.ARG_CONFIGURATION_PARAMS, this.configurationParams);
        } else if (cls3.isAssignableFrom(cls2)) {
            savedStateHandle.set(Constants.ARG_CONFIGURATION_PARAMS, (Serializable) this.configurationParams);
        } else {
            String name2 = cls2.getName();
            throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        Class<FlutterRoute> cls4 = FlutterRoute.class;
        if (cls.isAssignableFrom(cls4)) {
            savedStateHandle.set(Constants.ARG_ROUTE, this.route);
        } else if (cls3.isAssignableFrom(cls4)) {
            savedStateHandle.set(Constants.ARG_ROUTE, (Serializable) this.route);
        } else {
            String name3 = cls4.getName();
            throw new UnsupportedOperationException(name3 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        return savedStateHandle;
    }

    @NotNull
    public String toString() {
        FlutterConfigurationParams flutterConfigurationParams = this.configurationParams;
        FlutterRoute flutterRoute = this.route;
        return "QCommerceFlutterFragmentArgs(configurationParams=" + flutterConfigurationParams + ", route=" + flutterRoute + ")";
    }
}
