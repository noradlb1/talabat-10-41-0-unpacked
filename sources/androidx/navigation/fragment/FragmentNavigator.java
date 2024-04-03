package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.newrelic.agent.android.agentdata.HexAttribute;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003#$%B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0002H\u0016J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J*\u0010\u0013\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\"H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "context", "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerId", "", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;I)V", "savedIds", "", "", "createDestination", "instantiateFragment", "Landroidx/fragment/app/Fragment;", "className", "args", "Landroid/os/Bundle;", "navigate", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "entries", "", "onRestoreState", "savedState", "onSaveState", "popBackStack", "popUpTo", "", "Companion", "Destination", "Extras", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Navigator.Name("fragment")
public class FragmentNavigator extends Navigator<Destination> {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String KEY_SAVED_IDS = "androidx-nav-fragment:navigator:savedIds";
    @NotNull
    @Deprecated
    private static final String TAG = "FragmentNavigator";
    private final int containerId;
    @NotNull
    private final Context context;
    @NotNull
    private final FragmentManager fragmentManager;
    @NotNull
    private final Set<String> savedIds = new LinkedHashSet();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Companion;", "", "()V", "KEY_SAVED_IDS", "", "TAG", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u001a\u001a\u00020\tH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Destination;", "Landroidx/navigation/NavDestination;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroidx/navigation/NavigatorProvider;)V", "fragmentNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "_className", "", "className", "getClassName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "onInflate", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "setClassName", "toString", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @NavDestination.ClassType(Fragment.class)
    public static class Destination extends NavDestination {
        @Nullable
        private String _className;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Destination(@NotNull Navigator<? extends Destination> navigator) {
            super((Navigator<? extends NavDestination>) navigator);
            Intrinsics.checkNotNullParameter(navigator, "fragmentNavigator");
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == null || !(obj instanceof Destination) || !super.equals(obj) || !Intrinsics.areEqual((Object) this._className, (Object) ((Destination) obj)._className)) {
                return false;
            }
            return true;
        }

        @NotNull
        public final String getClassName() {
            String str = this._className;
            if (str == null) {
                throw new IllegalStateException("Fragment class was not set".toString());
            } else if (str != null) {
                return str;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }

        public int hashCode() {
            int i11;
            int hashCode = super.hashCode() * 31;
            String str = this._className;
            if (str != null) {
                i11 = str.hashCode();
            } else {
                i11 = 0;
            }
            return hashCode + i11;
        }

        @CallSuper
        public void onInflate(@NotNull Context context, @NotNull AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.FragmentNavigator);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…leable.FragmentNavigator)");
            String string = obtainAttributes.getString(R.styleable.FragmentNavigator_android_name);
            if (string != null) {
                setClassName(string);
            }
            Unit unit = Unit.INSTANCE;
            obtainAttributes.recycle();
        }

        @NotNull
        public final Destination setClassName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
            this._className = str;
            return this;
        }

        @NotNull
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(super.toString());
            sb2.append(" class=");
            String str = this._className;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
            return sb3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Destination(@NotNull NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(FragmentNavigator.class));
            Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u001b\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "sharedElements", "", "Landroid/view/View;", "", "(Ljava/util/Map;)V", "_sharedElements", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "getSharedElements", "()Ljava/util/Map;", "Builder", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Extras implements Navigator.Extras {
        @NotNull
        private final LinkedHashMap<View, String> _sharedElements;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006J\u001a\u0010\u000b\u001a\u00020\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\rJ\u0006\u0010\u000e\u001a\u00020\u000fR*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras$Builder;", "", "()V", "_sharedElements", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "", "Lkotlin/collections/LinkedHashMap;", "addSharedElement", "sharedElement", "name", "addSharedElements", "sharedElements", "", "build", "Landroidx/navigation/fragment/FragmentNavigator$Extras;", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Builder {
            @NotNull
            private final LinkedHashMap<View, String> _sharedElements = new LinkedHashMap<>();

            @NotNull
            public final Builder addSharedElement(@NotNull View view, @NotNull String str) {
                Intrinsics.checkNotNullParameter(view, "sharedElement");
                Intrinsics.checkNotNullParameter(str, "name");
                this._sharedElements.put(view, str);
                return this;
            }

            @NotNull
            public final Builder addSharedElements(@NotNull Map<View, String> map) {
                Intrinsics.checkNotNullParameter(map, "sharedElements");
                for (Map.Entry next : map.entrySet()) {
                    addSharedElement((View) next.getKey(), (String) next.getValue());
                }
                return this;
            }

            @NotNull
            public final Extras build() {
                return new Extras(this._sharedElements);
            }
        }

        public Extras(@NotNull Map<View, String> map) {
            Intrinsics.checkNotNullParameter(map, "sharedElements");
            LinkedHashMap<View, String> linkedHashMap = new LinkedHashMap<>();
            this._sharedElements = linkedHashMap;
            linkedHashMap.putAll(map);
        }

        @NotNull
        public final Map<View, String> getSharedElements() {
            return MapsKt__MapsKt.toMap(this._sharedElements);
        }
    }

    public FragmentNavigator(@NotNull Context context2, @NotNull FragmentManager fragmentManager2, int i11) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(fragmentManager2, "fragmentManager");
        this.context = context2;
        this.fragmentManager = fragmentManager2;
        this.containerId = i11;
    }

    @NotNull
    @Deprecated(message = "Set a custom {@link androidx.fragment.app.FragmentFactory} via\n      {@link FragmentManager#setFragmentFactory(FragmentFactory)} to control\n      instantiation of Fragments.")
    public Fragment instantiateFragment(@NotNull Context context2, @NotNull FragmentManager fragmentManager2, @NotNull String str, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(fragmentManager2, "fragmentManager");
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
        Fragment instantiate = fragmentManager2.getFragmentFactory().instantiate(context2.getClassLoader(), str);
        Intrinsics.checkNotNullExpressionValue(instantiate, "fragmentManager.fragment…t.classLoader, className)");
        return instantiate;
    }

    public void navigate(@NotNull List<NavBackStackEntry> list, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(list, RemoteConfigConstants.ResponseFieldKey.ENTRIES);
        if (this.fragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        for (NavBackStackEntry navigate : list) {
            navigate(navigate, navOptions, extras);
        }
    }

    public void onRestoreState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "savedState");
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_SAVED_IDS);
        if (stringArrayList != null) {
            this.savedIds.clear();
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(this.savedIds, stringArrayList);
        }
    }

    @Nullable
    public Bundle onSaveState() {
        if (this.savedIds.isEmpty()) {
            return null;
        }
        return BundleKt.bundleOf(TuplesKt.to(KEY_SAVED_IDS, new ArrayList(this.savedIds)));
    }

    public void popBackStack(@NotNull NavBackStackEntry navBackStackEntry, boolean z11) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        if (this.fragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        if (z11) {
            List value = getState().getBackStack().getValue();
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt___CollectionsKt.first(value);
            for (NavBackStackEntry navBackStackEntry3 : CollectionsKt___CollectionsKt.reversed(value.subList(value.indexOf(navBackStackEntry), value.size()))) {
                if (Intrinsics.areEqual((Object) navBackStackEntry3, (Object) navBackStackEntry2)) {
                    Log.i(TAG, "FragmentManager cannot save the state of the initial destination " + navBackStackEntry3);
                } else {
                    this.fragmentManager.saveBackStack(navBackStackEntry3.getId());
                    this.savedIds.add(navBackStackEntry3.getId());
                }
            }
        } else {
            this.fragmentManager.popBackStack(navBackStackEntry.getId(), 1);
        }
        getState().pop(navBackStackEntry, z11);
    }

    @NotNull
    public Destination createDestination() {
        return new Destination((Navigator<? extends Destination>) this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void navigate(androidx.navigation.NavBackStackEntry r13, androidx.navigation.NavOptions r14, androidx.navigation.Navigator.Extras r15) {
        /*
            r12 = this;
            androidx.navigation.NavigatorState r0 = r12.getState()
            kotlinx.coroutines.flow.StateFlow r0 = r0.getBackStack()
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            r2 = 1
            r3 = 0
            if (r14 == 0) goto L_0x002c
            if (r1 != 0) goto L_0x002c
            boolean r4 = r14.shouldRestoreState()
            if (r4 == 0) goto L_0x002c
            java.util.Set<java.lang.String> r4 = r12.savedIds
            java.lang.String r5 = r13.getId()
            boolean r4 = r4.remove(r5)
            if (r4 == 0) goto L_0x002c
            r4 = r2
            goto L_0x002d
        L_0x002c:
            r4 = r3
        L_0x002d:
            if (r4 == 0) goto L_0x0040
            androidx.fragment.app.FragmentManager r14 = r12.fragmentManager
            java.lang.String r15 = r13.getId()
            r14.restoreBackStack(r15)
            androidx.navigation.NavigatorState r14 = r12.getState()
            r14.push(r13)
            return
        L_0x0040:
            androidx.navigation.NavDestination r4 = r13.getDestination()
            androidx.navigation.fragment.FragmentNavigator$Destination r4 = (androidx.navigation.fragment.FragmentNavigator.Destination) r4
            android.os.Bundle r5 = r13.getArguments()
            java.lang.String r6 = r4.getClassName()
            char r7 = r6.charAt(r3)
            r8 = 46
            if (r7 != r8) goto L_0x006b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            android.content.Context r8 = r12.context
            java.lang.String r8 = r8.getPackageName()
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
        L_0x006b:
            androidx.fragment.app.FragmentManager r7 = r12.fragmentManager
            androidx.fragment.app.FragmentFactory r7 = r7.getFragmentFactory()
            android.content.Context r8 = r12.context
            java.lang.ClassLoader r8 = r8.getClassLoader()
            androidx.fragment.app.Fragment r6 = r7.instantiate(r8, r6)
            java.lang.String r7 = "fragmentManager.fragment…t.classLoader, className)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r6.setArguments(r5)
            androidx.fragment.app.FragmentManager r5 = r12.fragmentManager
            androidx.fragment.app.FragmentTransaction r5 = r5.beginTransaction()
            java.lang.String r7 = "fragmentManager.beginTransaction()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            r7 = -1
            if (r14 == 0) goto L_0x0096
            int r8 = r14.getEnterAnim()
            goto L_0x0097
        L_0x0096:
            r8 = r7
        L_0x0097:
            if (r14 == 0) goto L_0x009e
            int r9 = r14.getExitAnim()
            goto L_0x009f
        L_0x009e:
            r9 = r7
        L_0x009f:
            if (r14 == 0) goto L_0x00a6
            int r10 = r14.getPopEnterAnim()
            goto L_0x00a7
        L_0x00a6:
            r10 = r7
        L_0x00a7:
            if (r14 == 0) goto L_0x00ae
            int r11 = r14.getPopExitAnim()
            goto L_0x00af
        L_0x00ae:
            r11 = r7
        L_0x00af:
            if (r8 != r7) goto L_0x00b7
            if (r9 != r7) goto L_0x00b7
            if (r10 != r7) goto L_0x00b7
            if (r11 == r7) goto L_0x00ca
        L_0x00b7:
            if (r8 == r7) goto L_0x00ba
            goto L_0x00bb
        L_0x00ba:
            r8 = r3
        L_0x00bb:
            if (r9 == r7) goto L_0x00be
            goto L_0x00bf
        L_0x00be:
            r9 = r3
        L_0x00bf:
            if (r10 == r7) goto L_0x00c2
            goto L_0x00c3
        L_0x00c2:
            r10 = r3
        L_0x00c3:
            if (r11 == r7) goto L_0x00c6
            goto L_0x00c7
        L_0x00c6:
            r11 = r3
        L_0x00c7:
            r5.setCustomAnimations(r8, r9, r10, r11)
        L_0x00ca:
            int r7 = r12.containerId
            r5.replace(r7, r6)
            r5.setPrimaryNavigationFragment(r6)
            int r4 = r4.getId()
            if (r14 == 0) goto L_0x00f2
            if (r1 != 0) goto L_0x00f2
            boolean r14 = r14.shouldLaunchSingleTop()
            if (r14 == 0) goto L_0x00f2
            java.lang.Object r14 = kotlin.collections.CollectionsKt___CollectionsKt.last(r0)
            androidx.navigation.NavBackStackEntry r14 = (androidx.navigation.NavBackStackEntry) r14
            androidx.navigation.NavDestination r14 = r14.getDestination()
            int r14 = r14.getId()
            if (r14 != r4) goto L_0x00f2
            r14 = r2
            goto L_0x00f3
        L_0x00f2:
            r14 = r3
        L_0x00f3:
            if (r1 == 0) goto L_0x00f7
        L_0x00f5:
            r3 = r2
            goto L_0x0118
        L_0x00f7:
            if (r14 == 0) goto L_0x0110
            int r14 = r0.size()
            if (r14 <= r2) goto L_0x0118
            androidx.fragment.app.FragmentManager r14 = r12.fragmentManager
            java.lang.String r0 = r13.getId()
            r14.popBackStack((java.lang.String) r0, (int) r2)
            java.lang.String r14 = r13.getId()
            r5.addToBackStack(r14)
            goto L_0x0118
        L_0x0110:
            java.lang.String r14 = r13.getId()
            r5.addToBackStack(r14)
            goto L_0x00f5
        L_0x0118:
            boolean r14 = r15 instanceof androidx.navigation.fragment.FragmentNavigator.Extras
            if (r14 == 0) goto L_0x0146
            androidx.navigation.fragment.FragmentNavigator$Extras r15 = (androidx.navigation.fragment.FragmentNavigator.Extras) r15
            java.util.Map r14 = r15.getSharedElements()
            java.util.Set r14 = r14.entrySet()
            java.util.Iterator r14 = r14.iterator()
        L_0x012a:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0146
            java.lang.Object r15 = r14.next()
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15
            java.lang.Object r0 = r15.getKey()
            android.view.View r0 = (android.view.View) r0
            java.lang.Object r15 = r15.getValue()
            java.lang.String r15 = (java.lang.String) r15
            r5.addSharedElement(r0, r15)
            goto L_0x012a
        L_0x0146:
            r5.setReorderingAllowed(r2)
            r5.commit()
            if (r3 == 0) goto L_0x0155
            androidx.navigation.NavigatorState r14 = r12.getState()
            r14.push(r13)
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.FragmentNavigator.navigate(androidx.navigation.NavBackStackEntry, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }
}
