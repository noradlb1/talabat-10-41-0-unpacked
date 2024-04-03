package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.navigation.NavDestination;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003B-\b\u0000\u0012\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0017\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0010\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b5\u00106B#\b\u0017\u0012\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0017\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0010¢\u0006\u0004\b5\u00107B#\b\u0016\u0012\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0017\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b5\u00108J'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004J\u001f\u0010\r\u001a\u00020\b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tJ)\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0007J\u000f\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00178\u0004X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020,0+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00101\u001a\b\u0012\u0004\u0012\u0002000/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\"\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002030+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010.¨\u00069"}, d2 = {"Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/NavDestination;", "D", "", "", "name", "Lkotlin/Function1;", "Landroidx/navigation/NavArgumentBuilder;", "", "Lkotlin/ExtensionFunctionType;", "argumentBuilder", "argument", "uriPattern", "deepLink", "Landroidx/navigation/NavDeepLinkDslBuilder;", "navDeepLink", "", "actionId", "Landroidx/navigation/NavActionBuilder;", "actionBuilder", "action", "build", "()Landroidx/navigation/NavDestination;", "Landroidx/navigation/Navigator;", "navigator", "Landroidx/navigation/Navigator;", "getNavigator", "()Landroidx/navigation/Navigator;", "id", "I", "getId", "()I", "route", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "label", "Ljava/lang/CharSequence;", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "", "Landroidx/navigation/NavArgument;", "arguments", "Ljava/util/Map;", "", "Landroidx/navigation/NavDeepLink;", "deepLinks", "Ljava/util/List;", "Landroidx/navigation/NavAction;", "actions", "<init>", "(Landroidx/navigation/Navigator;ILjava/lang/String;)V", "(Landroidx/navigation/Navigator;I)V", "(Landroidx/navigation/Navigator;Ljava/lang/String;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
@NavDestinationDsl
public class NavDestinationBuilder<D extends NavDestination> {
    @NotNull
    private Map<Integer, NavAction> actions;
    @NotNull
    private Map<String, NavArgument> arguments;
    @NotNull
    private List<NavDeepLink> deepLinks;

    /* renamed from: id  reason: collision with root package name */
    private final int f36332id;
    @Nullable
    private CharSequence label;
    @NotNull
    private final Navigator<? extends D> navigator;
    @Nullable
    private final String route;

    public NavDestinationBuilder(@NotNull Navigator<? extends D> navigator2, @IdRes int i11, @Nullable String str) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        this.navigator = navigator2;
        this.f36332id = i11;
        this.route = str;
        this.arguments = new LinkedHashMap();
        this.deepLinks = new ArrayList();
        this.actions = new LinkedHashMap();
    }

    @Deprecated(message = "Building NavDestinations using IDs with the Kotlin DSL has been deprecated in favor of using routes. When using routes there is no need for actions.")
    public final void action(int i11, @NotNull Function1<? super NavActionBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "actionBuilder");
        Map<Integer, NavAction> map = this.actions;
        Integer valueOf = Integer.valueOf(i11);
        NavActionBuilder navActionBuilder = new NavActionBuilder();
        function1.invoke(navActionBuilder);
        map.put(valueOf, navActionBuilder.build$navigation_common_release());
    }

    public final void argument(@NotNull String str, @NotNull Function1<? super NavArgumentBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "argumentBuilder");
        Map<String, NavArgument> map = this.arguments;
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        function1.invoke(navArgumentBuilder);
        map.put(str, navArgumentBuilder.build());
    }

    @NotNull
    public D build() {
        D createDestination = this.navigator.createDestination();
        String str = this.route;
        if (str != null) {
            createDestination.setRoute(str);
        }
        int i11 = this.f36332id;
        if (i11 != -1) {
            createDestination.setId(i11);
        }
        createDestination.setLabel(this.label);
        for (Map.Entry next : this.arguments.entrySet()) {
            createDestination.addArgument((String) next.getKey(), (NavArgument) next.getValue());
        }
        for (NavDeepLink addDeepLink : this.deepLinks) {
            createDestination.addDeepLink(addDeepLink);
        }
        for (Map.Entry next2 : this.actions.entrySet()) {
            createDestination.putAction(((Number) next2.getKey()).intValue(), (NavAction) next2.getValue());
        }
        return createDestination;
    }

    public final void deepLink(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "uriPattern");
        this.deepLinks.add(new NavDeepLink(str));
    }

    public final int getId() {
        return this.f36332id;
    }

    @Nullable
    public final CharSequence getLabel() {
        return this.label;
    }

    @Nullable
    public final String getRoute() {
        return this.route;
    }

    public final void setLabel(@Nullable CharSequence charSequence) {
        this.label = charSequence;
    }

    public final void deepLink(@NotNull Function1<? super NavDeepLinkDslBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "navDeepLink");
        List<NavDeepLink> list = this.deepLinks;
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
        function1.invoke(navDeepLinkDslBuilder);
        list.add(navDeepLinkDslBuilder.build$navigation_common_release());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use routes to build your NavDestination instead", replaceWith = @ReplaceWith(expression = "NavDestinationBuilder(navigator, route = id.toString())", imports = {}))
    public NavDestinationBuilder(@NotNull Navigator<? extends D> navigator2, @IdRes int i11) {
        this(navigator2, i11, (String) null);
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavDestinationBuilder(@NotNull Navigator<? extends D> navigator2, @Nullable String str) {
        this(navigator2, -1, str);
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
    }
}
