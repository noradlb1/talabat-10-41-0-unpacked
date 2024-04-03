package androidx.navigation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.core.app.TaskStackBuilder;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002,-B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0007J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u0018\u0010 \u001a\u00020\u00002\u0010\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010%0$J\u001e\u0010&\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00162\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0007J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u000eJ\u0010\u0010(\u001a\u00020\u00002\b\b\u0001\u0010*\u001a\u00020\u0013J\b\u0010+\u001a\u00020\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder;", "", "navController", "Landroidx/navigation/NavController;", "(Landroidx/navigation/NavController;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "destinations", "", "Landroidx/navigation/NavDeepLinkBuilder$DeepLinkDestination;", "globalArgs", "Landroid/os/Bundle;", "graph", "Landroidx/navigation/NavGraph;", "intent", "Landroid/content/Intent;", "addDestination", "destId", "", "args", "route", "", "createPendingIntent", "Landroid/app/PendingIntent;", "createTaskStackBuilder", "Landroidx/core/app/TaskStackBuilder;", "fillInIntent", "", "findDestination", "Landroidx/navigation/NavDestination;", "setArguments", "setComponentName", "componentName", "Landroid/content/ComponentName;", "activityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "setDestination", "destRoute", "setGraph", "navGraph", "navGraphId", "verifyAllDestinations", "DeepLinkDestination", "PermissiveNavigatorProvider", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavDeepLinkBuilder {
    @NotNull
    private final Context context;
    @NotNull
    private final List<DeepLinkDestination> destinations;
    @Nullable
    private Bundle globalArgs;
    @Nullable
    private NavGraph graph;
    @NotNull
    private final Intent intent;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder$DeepLinkDestination;", "", "destinationId", "", "arguments", "Landroid/os/Bundle;", "(ILandroid/os/Bundle;)V", "getArguments", "()Landroid/os/Bundle;", "getDestinationId", "()I", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DeepLinkDestination {
        @Nullable
        private final Bundle arguments;
        private final int destinationId;

        public DeepLinkDestination(int i11, @Nullable Bundle bundle) {
            this.destinationId = i11;
            this.arguments = bundle;
        }

        @Nullable
        public final Bundle getArguments() {
            return this.arguments;
        }

        public final int getDestinationId() {
            return this.destinationId;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0006\u001a\u0002H\u0007\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder$PermissiveNavigatorProvider;", "Landroidx/navigation/NavigatorProvider;", "()V", "mDestNavigator", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "getNavigator", "T", "name", "", "(Ljava/lang/String;)Landroidx/navigation/Navigator;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PermissiveNavigatorProvider extends NavigatorProvider {
        @NotNull
        private final Navigator<NavDestination> mDestNavigator = new NavDeepLinkBuilder$PermissiveNavigatorProvider$mDestNavigator$1();

        public PermissiveNavigatorProvider() {
            addNavigator(new NavGraphNavigator(this));
        }

        @NotNull
        public <T extends Navigator<? extends NavDestination>> T getNavigator(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            try {
                return super.getNavigator(str);
            } catch (IllegalStateException unused) {
                return this.mDestNavigator;
            }
        }
    }

    public NavDeepLinkBuilder(@NotNull Context context2) {
        Intent intent2;
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        if (context2 instanceof Activity) {
            intent2 = new Intent(context2, context2.getClass());
        } else {
            intent2 = context2.getPackageManager().getLaunchIntentForPackage(context2.getPackageName());
            if (intent2 == null) {
                intent2 = new Intent();
            }
        }
        intent2.addFlags(268468224);
        this.intent = intent2;
        this.destinations = new ArrayList();
    }

    public static /* synthetic */ NavDeepLinkBuilder addDestination$default(NavDeepLinkBuilder navDeepLinkBuilder, int i11, Bundle bundle, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            bundle = null;
        }
        return navDeepLinkBuilder.addDestination(i11, bundle);
    }

    private final void fillInIntent() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        NavDestination navDestination = null;
        for (DeepLinkDestination next : this.destinations) {
            int destinationId = next.getDestinationId();
            Bundle arguments = next.getArguments();
            NavDestination findDestination = findDestination(destinationId);
            if (findDestination != null) {
                for (int valueOf : findDestination.buildDeepLinkIds(navDestination)) {
                    arrayList.add(Integer.valueOf(valueOf));
                    arrayList2.add(arguments);
                }
                navDestination = findDestination;
            } else {
                throw new IllegalArgumentException("Navigation destination " + NavDestination.Companion.getDisplayName(this.context, destinationId) + " cannot be found in the navigation graph " + this.graph);
            }
        }
        this.intent.putExtra(NavController.KEY_DEEP_LINK_IDS, CollectionsKt___CollectionsKt.toIntArray(arrayList));
        this.intent.putParcelableArrayListExtra(NavController.KEY_DEEP_LINK_ARGS, arrayList2);
    }

    private final NavDestination findDestination(@IdRes int i11) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavGraph navGraph = this.graph;
        Intrinsics.checkNotNull(navGraph);
        arrayDeque.add(navGraph);
        while (!arrayDeque.isEmpty()) {
            NavDestination navDestination = (NavDestination) arrayDeque.removeFirst();
            if (navDestination.getId() == i11) {
                return navDestination;
            }
            if (navDestination instanceof NavGraph) {
                Iterator<NavDestination> it = ((NavGraph) navDestination).iterator();
                while (it.hasNext()) {
                    arrayDeque.add(it.next());
                }
            }
        }
        return null;
    }

    public static /* synthetic */ NavDeepLinkBuilder setDestination$default(NavDeepLinkBuilder navDeepLinkBuilder, int i11, Bundle bundle, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            bundle = null;
        }
        return navDeepLinkBuilder.setDestination(i11, bundle);
    }

    private final void verifyAllDestinations() {
        for (DeepLinkDestination destinationId : this.destinations) {
            int destinationId2 = destinationId.getDestinationId();
            if (findDestination(destinationId2) == null) {
                String displayName = NavDestination.Companion.getDisplayName(this.context, destinationId2);
                throw new IllegalArgumentException("Navigation destination " + displayName + " cannot be found in the navigation graph " + this.graph);
            }
        }
    }

    @NotNull
    @JvmOverloads
    public final NavDeepLinkBuilder addDestination(@IdRes int i11) {
        return addDestination$default(this, i11, (Bundle) null, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final NavDeepLinkBuilder addDestination(@IdRes int i11, @Nullable Bundle bundle) {
        this.destinations.add(new DeepLinkDestination(i11, bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    @NotNull
    @JvmOverloads
    public final NavDeepLinkBuilder addDestination(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        return addDestination$default(this, str, (Bundle) null, 2, (Object) null);
    }

    @NotNull
    public final PendingIntent createPendingIntent() {
        int i11;
        int i12;
        int i13;
        Bundle bundle = this.globalArgs;
        if (bundle != null) {
            i11 = 0;
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                int i14 = i11 * 31;
                if (obj != null) {
                    i13 = obj.hashCode();
                } else {
                    i13 = 0;
                }
                i11 = i14 + i13;
            }
        } else {
            i11 = 0;
        }
        for (DeepLinkDestination next : this.destinations) {
            int destinationId = (i11 * 31) + next.getDestinationId();
            Bundle arguments = next.getArguments();
            if (arguments != null) {
                for (String str2 : arguments.keySet()) {
                    Object obj2 = arguments.get(str2);
                    int i15 = destinationId * 31;
                    if (obj2 != null) {
                        i12 = obj2.hashCode();
                    } else {
                        i12 = 0;
                    }
                    destinationId = i15 + i12;
                }
            }
        }
        PendingIntent pendingIntent = createTaskStackBuilder().getPendingIntent(i11, 201326592);
        Intrinsics.checkNotNull(pendingIntent);
        return pendingIntent;
    }

    @NotNull
    public final TaskStackBuilder createTaskStackBuilder() {
        if (this.graph == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link".toString());
        } else if (!this.destinations.isEmpty()) {
            fillInIntent();
            TaskStackBuilder addNextIntentWithParentStack = TaskStackBuilder.create(this.context).addNextIntentWithParentStack(new Intent(this.intent));
            Intrinsics.checkNotNullExpressionValue(addNextIntentWithParentStack, "create(context)\n        …rentStack(Intent(intent))");
            int intentCount = addNextIntentWithParentStack.getIntentCount();
            for (int i11 = 0; i11 < intentCount; i11++) {
                Intent editIntentAt = addNextIntentWithParentStack.editIntentAt(i11);
                if (editIntentAt != null) {
                    editIntentAt.putExtra(NavController.KEY_DEEP_LINK_INTENT, this.intent);
                }
            }
            return addNextIntentWithParentStack;
        } else {
            throw new IllegalStateException("You must call setDestination() or addDestination() before constructing the deep link".toString());
        }
    }

    @NotNull
    public final NavDeepLinkBuilder setArguments(@Nullable Bundle bundle) {
        this.globalArgs = bundle;
        this.intent.putExtra(NavController.KEY_DEEP_LINK_EXTRAS, bundle);
        return this;
    }

    @NotNull
    public final NavDeepLinkBuilder setComponentName(@NotNull Class<? extends Activity> cls) {
        Intrinsics.checkNotNullParameter(cls, "activityClass");
        return setComponentName(new ComponentName(this.context, cls));
    }

    @NotNull
    @JvmOverloads
    public final NavDeepLinkBuilder setDestination(@IdRes int i11) {
        return setDestination$default(this, i11, (Bundle) null, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final NavDeepLinkBuilder setDestination(@IdRes int i11, @Nullable Bundle bundle) {
        this.destinations.clear();
        this.destinations.add(new DeepLinkDestination(i11, bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    @NotNull
    @JvmOverloads
    public final NavDeepLinkBuilder setDestination(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "destRoute");
        return setDestination$default(this, str, (Bundle) null, 2, (Object) null);
    }

    @NotNull
    public final NavDeepLinkBuilder setGraph(@NavigationRes int i11) {
        return setGraph(new NavInflater(this.context, new PermissiveNavigatorProvider()).inflate(i11));
    }

    public static /* synthetic */ NavDeepLinkBuilder addDestination$default(NavDeepLinkBuilder navDeepLinkBuilder, String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bundle = null;
        }
        return navDeepLinkBuilder.addDestination(str, bundle);
    }

    public static /* synthetic */ NavDeepLinkBuilder setDestination$default(NavDeepLinkBuilder navDeepLinkBuilder, String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bundle = null;
        }
        return navDeepLinkBuilder.setDestination(str, bundle);
    }

    @NotNull
    public final NavDeepLinkBuilder setComponentName(@NotNull ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        this.intent.setComponent(componentName);
        return this;
    }

    @NotNull
    public final NavDeepLinkBuilder setGraph(@NotNull NavGraph navGraph) {
        Intrinsics.checkNotNullParameter(navGraph, "navGraph");
        this.graph = navGraph;
        verifyAllDestinations();
        return this;
    }

    @NotNull
    @JvmOverloads
    public final NavDeepLinkBuilder addDestination(@NotNull String str, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        this.destinations.add(new DeepLinkDestination(NavDestination.Companion.createRoute(str).hashCode(), bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    @NotNull
    @JvmOverloads
    public final NavDeepLinkBuilder setDestination(@NotNull String str, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "destRoute");
        this.destinations.clear();
        this.destinations.add(new DeepLinkDestination(NavDestination.Companion.createRoute(str).hashCode(), bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavDeepLinkBuilder(@NotNull NavController navController) {
        this(navController.getContext());
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.graph = navController.getGraph();
    }
}
