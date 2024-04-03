package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDestination;
import androidx.navigation.common.R;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 >2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001>B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0001J\u001f\u0010\"\u001a\u00020\u001e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010#\"\u00020\u0001¢\u0006\u0002\u0010$J\u0016\u0010\"\u001a\u00020\u001e2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010%J\u0006\u0010&\u001a\u00020\u001eJ\u0013\u0010'\u001a\u00020(2\b\u0010\u001f\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010+\u001a\u00020\u0011J\u001c\u0010*\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020(H\u0007J\u001a\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020(H\u0007J\u0012\u0010*\u001a\u0004\u0018\u00010\u00012\b\u0010-\u001a\u0004\u0018\u00010\u0007J\b\u0010.\u001a\u00020\u0011H\u0007J\b\u0010/\u001a\u00020\u0011H\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000101H\u0002J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205H\u0017J\u0018\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u000e\u0010;\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0001J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0007J\b\u0010=\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078WX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8G¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118G@BX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u001c¨\u0006?"}, d2 = {"Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "", "navGraphNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "nodes", "Landroidx/collection/SparseArrayCompat;", "getNodes", "()Landroidx/collection/SparseArrayCompat;", "startDestDisplayName", "getStartDestDisplayName", "startDestId", "", "startDestIdName", "startDestinationId", "getStartDestinationId", "()I", "setStartDestinationId", "(I)V", "startDestRoute", "startDestinationRoute", "getStartDestinationRoute", "setStartDestinationRoute", "(Ljava/lang/String;)V", "addAll", "", "other", "addDestination", "node", "addDestinations", "", "([Landroidx/navigation/NavDestination;)V", "", "clear", "equals", "", "", "findNode", "resId", "searchParents", "route", "getStartDestination", "hashCode", "iterator", "", "matchDeepLink", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "onInflate", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "remove", "setStartDestination", "toString", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavGraph extends NavDestination implements Iterable<NavDestination>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final SparseArrayCompat<NavDestination> nodes = new SparseArrayCompat<>();
    private int startDestId;
    @Nullable
    private String startDestIdName;
    @Nullable
    private String startDestinationRoute;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavGraph$Companion;", "", "()V", "findStartDestination", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavGraph;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final NavDestination findStartDestination(@NotNull NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return (NavDestination) SequencesKt___SequencesKt.last(SequencesKt__SequencesKt.generateSequence(navGraph.findNode(navGraph.getStartDestinationId()), NavGraph$Companion$findStartDestination$1.INSTANCE));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraph(@NotNull Navigator<? extends NavGraph> navigator) {
        super((Navigator<? extends NavDestination>) navigator);
        Intrinsics.checkNotNullParameter(navigator, "navGraphNavigator");
    }

    @JvmStatic
    @NotNull
    public static final NavDestination findStartDestination(@NotNull NavGraph navGraph) {
        return Companion.findStartDestination(navGraph);
    }

    private final void setStartDestinationId(int i11) {
        boolean z11;
        if (i11 != getId()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (this.startDestinationRoute != null) {
                setStartDestinationRoute((String) null);
            }
            this.startDestId = i11;
            this.startDestIdName = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i11 + " cannot use the same id as the graph " + this).toString());
    }

    private final void setStartDestinationRoute(String str) {
        int i11;
        if (str == null) {
            i11 = 0;
        } else if (!(!Intrinsics.areEqual((Object) str, (Object) getRoute()))) {
            throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this).toString());
        } else if (!StringsKt__StringsJVMKt.isBlank(str)) {
            i11 = NavDestination.Companion.createRoute(str).hashCode();
        } else {
            throw new IllegalArgumentException("Cannot have an empty start destination route".toString());
        }
        this.startDestId = i11;
        this.startDestinationRoute = str;
    }

    public final void addAll(@NotNull NavGraph navGraph) {
        Intrinsics.checkNotNullParameter(navGraph, "other");
        Iterator<NavDestination> it = navGraph.iterator();
        while (it.hasNext()) {
            it.remove();
            addDestination(it.next());
        }
    }

    public final void addDestination(@NotNull NavDestination navDestination) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(navDestination, "node");
        int id2 = navDestination.getId();
        String route = navDestination.getRoute();
        boolean z13 = false;
        if (id2 == 0 && route == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
        } else if (getRoute() == null || (!Intrinsics.areEqual((Object) route, (Object) getRoute()))) {
            if (id2 != getId()) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                NavDestination navDestination2 = this.nodes.get(id2);
                if (navDestination2 != navDestination) {
                    if (navDestination.getParent() == null) {
                        z13 = true;
                    }
                    if (z13) {
                        if (navDestination2 != null) {
                            navDestination2.setParent((NavGraph) null);
                        }
                        navDestination.setParent(this);
                        this.nodes.put(navDestination.getId(), navDestination);
                        return;
                    }
                    throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
                }
                return;
            }
            throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same id as graph " + this).toString());
        } else {
            throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same route as graph " + this).toString());
        }
    }

    public final void addDestinations(@NotNull Collection<? extends NavDestination> collection) {
        Intrinsics.checkNotNullParameter(collection, "nodes");
        for (NavDestination navDestination : collection) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    public final void clear() {
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof NavGraph)) {
            return false;
        }
        List mutableList = SequencesKt___SequencesKt.toMutableList(SequencesKt__SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)));
        NavGraph navGraph = (NavGraph) obj;
        Iterator<T> valueIterator = SparseArrayKt.valueIterator(navGraph.nodes);
        while (valueIterator.hasNext()) {
            mutableList.remove((NavDestination) valueIterator.next());
        }
        if (!super.equals(obj) || this.nodes.size() != navGraph.nodes.size() || getStartDestinationId() != navGraph.getStartDestinationId() || !mutableList.isEmpty()) {
            return false;
        }
        return true;
    }

    @Nullable
    public final NavDestination findNode(@IdRes int i11) {
        return findNode(i11, true);
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getDisplayName() {
        return getId() != 0 ? super.getDisplayName() : "the root navigation";
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SparseArrayCompat<NavDestination> getNodes() {
        return this.nodes;
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getStartDestDisplayName() {
        if (this.startDestIdName == null) {
            String str = this.startDestinationRoute;
            if (str == null) {
                str = String.valueOf(this.startDestId);
            }
            this.startDestIdName = str;
        }
        String str2 = this.startDestIdName;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    @Deprecated(message = "Use getStartDestinationId instead.", replaceWith = @ReplaceWith(expression = "startDestinationId", imports = {}))
    @IdRes
    public final int getStartDestination() {
        return getStartDestinationId();
    }

    @IdRes
    public final int getStartDestinationId() {
        return this.startDestId;
    }

    @Nullable
    public final String getStartDestinationRoute() {
        return this.startDestinationRoute;
    }

    public int hashCode() {
        int startDestinationId = getStartDestinationId();
        SparseArrayCompat<NavDestination> sparseArrayCompat = this.nodes;
        int size = sparseArrayCompat.size();
        for (int i11 = 0; i11 < size; i11++) {
            startDestinationId = (((startDestinationId * 31) + sparseArrayCompat.keyAt(i11)) * 31) + sparseArrayCompat.valueAt(i11).hashCode();
        }
        return startDestinationId;
    }

    @NotNull
    public final Iterator<NavDestination> iterator() {
        return new NavGraph$iterator$1(this);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDestination.DeepLinkMatch matchDeepLink(@NotNull NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        NavDestination.DeepLinkMatch matchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            NavDestination.DeepLinkMatch matchDeepLink2 = ((NavDestination) it.next()).matchDeepLink(navDeepLinkRequest);
            if (matchDeepLink2 != null) {
                arrayList.add(matchDeepLink2);
            }
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) CollectionsKt__CollectionsKt.listOfNotNull((T[]) new NavDestination.DeepLinkMatch[]{matchDeepLink, (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) arrayList)}));
    }

    public void onInflate(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super.onInflate(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.NavGraphNavigator);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…vGraphNavigator\n        )");
        setStartDestinationId(obtainAttributes.getResourceId(R.styleable.NavGraphNavigator_startDestination, 0));
        this.startDestIdName = NavDestination.Companion.getDisplayName(context, this.startDestId);
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    public final void remove(@NotNull NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "node");
        int indexOfKey = this.nodes.indexOfKey(navDestination.getId());
        if (indexOfKey >= 0) {
            this.nodes.valueAt(indexOfKey).setParent((NavGraph) null);
            this.nodes.removeAt(indexOfKey);
        }
    }

    public final void setStartDestination(int i11) {
        setStartDestinationId(i11);
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        NavDestination findNode = findNode(this.startDestinationRoute);
        if (findNode == null) {
            findNode = findNode(getStartDestinationId());
        }
        sb2.append(" startDestination=");
        if (findNode == null) {
            String str = this.startDestinationRoute;
            if (str != null) {
                sb2.append(str);
            } else {
                String str2 = this.startDestIdName;
                if (str2 != null) {
                    sb2.append(str2);
                } else {
                    sb2.append("0x" + Integer.toHexString(this.startDestId));
                }
            }
        } else {
            sb2.append("{");
            sb2.append(findNode.toString());
            sb2.append("}");
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
        return sb3;
    }

    @Nullable
    public final NavDestination findNode(@Nullable String str) {
        if (!(str == null || StringsKt__StringsJVMKt.isBlank(str))) {
            return findNode(str, true);
        }
        return null;
    }

    public final void setStartDestination(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "startDestRoute");
        setStartDestinationRoute(str);
    }

    public final void addDestinations(@NotNull NavDestination... navDestinationArr) {
        Intrinsics.checkNotNullParameter(navDestinationArr, "nodes");
        for (NavDestination addDestination : navDestinationArr) {
            addDestination(addDestination);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findNode(@IdRes int i11, boolean z11) {
        NavDestination navDestination = this.nodes.get(i11);
        if (navDestination != null) {
            return navDestination;
        }
        if (!z11 || getParent() == null) {
            return null;
        }
        NavGraph parent = getParent();
        Intrinsics.checkNotNull(parent);
        return parent.findNode(i11);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findNode(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        NavDestination navDestination = this.nodes.get(NavDestination.Companion.createRoute(str).hashCode());
        if (navDestination != null) {
            return navDestination;
        }
        if (!z11 || getParent() == null) {
            return null;
        }
        NavGraph parent = getParent();
        Intrinsics.checkNotNull(parent);
        return parent.findNode(str);
    }
}
