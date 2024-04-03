package com.talabat.home.navigation;

import com.talabat.feature.bnplcore.domain.model.BnplNavigationOptionLoadedEventKt;
import java.util.ArrayDeque;
import java.util.Deque;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/home/navigation/NavigationEventStack;", "", "maxSizeOfEvents", "", "(I)V", "deque", "Ljava/util/Deque;", "Lcom/talabat/home/navigation/NavigationEventStack$Screen;", "peek", "peekFirst", "push", "", "screen", "Screen", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavigationEventStack {
    @NotNull
    private final Deque<Screen> deque;
    private final int maxSizeOfEvents;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/home/navigation/NavigationEventStack$Screen;", "", "navigationOption", "", "navigationOrigin", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getNavigationOption", "()Ljava/lang/String;", "getNavigationOrigin", "HOME", "FLUTTER_HOME", "SEARCH", "FLUTTER_ACCOUNT", "ACCOUNT", "HOME_OF_OFFERS", "ORDER_LIST", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Screen {
        HOME("", "bottom_navigation_home"),
        FLUTTER_HOME("", "bottom_navigation_home"),
        SEARCH("", "bottom_navigation_search"),
        FLUTTER_ACCOUNT("", BnplNavigationOptionLoadedEventKt.VALUE_EVENT_ORIGIN_NAVIGATION_ACCOUNT),
        ACCOUNT("Account", BnplNavigationOptionLoadedEventKt.VALUE_EVENT_ORIGIN_NAVIGATION_ACCOUNT),
        HOME_OF_OFFERS("offer_zone", "bottom_navigation_offers"),
        ORDER_LIST("orders-list", "bottom_nav_orders");
        
        @NotNull
        private final String navigationOption;
        @NotNull
        private final String navigationOrigin;

        private Screen(String str, String str2) {
            this.navigationOption = str;
            this.navigationOrigin = str2;
        }

        @NotNull
        public final String getNavigationOption() {
            return this.navigationOption;
        }

        @NotNull
        public final String getNavigationOrigin() {
            return this.navigationOrigin;
        }
    }

    public NavigationEventStack() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public NavigationEventStack(int i11) {
        this.maxSizeOfEvents = i11;
        this.deque = new ArrayDeque();
    }

    @Nullable
    public final Screen peek() {
        return this.deque.peek();
    }

    @Nullable
    public final Screen peekFirst() {
        return this.deque.peekLast();
    }

    public final void push(@NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (this.deque.size() >= this.maxSizeOfEvents) {
            this.deque.removeLast();
        }
        this.deque.push(screen);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavigationEventStack(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 100 : i11);
    }
}
