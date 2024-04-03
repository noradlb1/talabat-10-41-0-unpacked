package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.navigation.Navigator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006J*\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0017J'\u0010\u000f\u001a\u0002H\u0010\"\f\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012¢\u0006\u0002\u0010\u0013J#\u0010\u000f\u001a\u0002H\u0010\"\f\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000e\u001a\u00020\u0005H\u0017¢\u0006\u0002\u0010\u0014R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/navigation/NavigatorProvider;", "", "()V", "_navigators", "", "", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigators", "", "getNavigators", "()Ljava/util/Map;", "addNavigator", "navigator", "name", "getNavigator", "T", "navigatorClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/navigation/Navigator;", "(Ljava/lang/String;)Landroidx/navigation/Navigator;", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"TypeParameterUnusedInFormals"})
public class NavigatorProvider {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<Class<?>, String> annotationNames = new LinkedHashMap();
    @NotNull
    private final Map<String, Navigator<? extends NavDestination>> _navigators = new LinkedHashMap();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t0\u0005H\u0001¢\u0006\u0002\b\nJ\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u000eR \u0010\u0003\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavigatorProvider$Companion;", "", "()V", "annotationNames", "", "Ljava/lang/Class;", "", "getNameForNavigator", "navigatorClass", "Landroidx/navigation/Navigator;", "getNameForNavigator$navigation_common_release", "validateName", "", "name", "validateName$navigation_common_release", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String getNameForNavigator$navigation_common_release(@NotNull Class<? extends Navigator<?>> cls) {
            Intrinsics.checkNotNullParameter(cls, "navigatorClass");
            String str = (String) NavigatorProvider.annotationNames.get(cls);
            if (str == null) {
                Navigator.Name name2 = (Navigator.Name) cls.getAnnotation(Navigator.Name.class);
                if (name2 != null) {
                    str = name2.value();
                } else {
                    str = null;
                }
                if (validateName$navigation_common_release(str)) {
                    NavigatorProvider.annotationNames.put(cls, str);
                } else {
                    throw new IllegalArgumentException(("No @Navigator.Name annotation found for " + cls.getSimpleName()).toString());
                }
            }
            Intrinsics.checkNotNull(str);
            return str;
        }

        public final boolean validateName$navigation_common_release(@Nullable String str) {
            if (str == null) {
                return false;
            }
            return str.length() > 0;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getNameForNavigator$navigation_common_release(@NotNull Class<? extends Navigator<?>> cls) {
        return Companion.getNameForNavigator$navigation_common_release(cls);
    }

    @Nullable
    public final Navigator<? extends NavDestination> addNavigator(@NotNull Navigator<? extends NavDestination> navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        return addNavigator(Companion.getNameForNavigator$navigation_common_release(navigator.getClass()), navigator);
    }

    @NotNull
    public final <T extends Navigator<?>> T getNavigator(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "navigatorClass");
        return getNavigator(Companion.getNameForNavigator$navigation_common_release(cls));
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Map<String, Navigator<? extends NavDestination>> getNavigators() {
        return MapsKt__MapsKt.toMap(this._navigators);
    }

    @CallSuper
    @Nullable
    public Navigator<? extends NavDestination> addNavigator(@NotNull String str, @NotNull Navigator<? extends NavDestination> navigator) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        if (Companion.validateName$navigation_common_release(str)) {
            Navigator navigator2 = this._navigators.get(str);
            if (Intrinsics.areEqual((Object) navigator2, (Object) navigator)) {
                return navigator;
            }
            boolean z11 = false;
            if (navigator2 != null && navigator2.isAttached()) {
                z11 = true;
            }
            if (!(!z11)) {
                throw new IllegalStateException(("Navigator " + navigator + " is replacing an already attached " + navigator2).toString());
            } else if (!navigator.isAttached()) {
                return this._navigators.put(str, navigator);
            } else {
                throw new IllegalStateException(("Navigator " + navigator + " is already attached to another NavController").toString());
            }
        } else {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
    }

    @NotNull
    @CallSuper
    public <T extends Navigator<?>> T getNavigator(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (Companion.validateName$navigation_common_release(str)) {
            T t11 = (Navigator) this._navigators.get(str);
            if (t11 != null) {
                return t11;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
    }
}
