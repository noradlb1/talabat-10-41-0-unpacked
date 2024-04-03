package com.talabat.darkstores.feature.searchResults;

import androidx.navigation.NavDirections;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/NavigationCommand;", "", "()V", "Back", "OpenScreen", "Lcom/talabat/darkstores/feature/searchResults/NavigationCommand$OpenScreen;", "Lcom/talabat/darkstores/feature/searchResults/NavigationCommand$Back;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class NavigationCommand {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/NavigationCommand$Back;", "Lcom/talabat/darkstores/feature/searchResults/NavigationCommand;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Back extends NavigationCommand {
        @NotNull
        public static final Back INSTANCE = new Back();

        private Back() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/NavigationCommand$OpenScreen;", "Lcom/talabat/darkstores/feature/searchResults/NavigationCommand;", "action", "Landroidx/navigation/NavDirections;", "(Landroidx/navigation/NavDirections;)V", "getAction", "()Landroidx/navigation/NavDirections;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OpenScreen extends NavigationCommand {
        @NotNull
        private final NavDirections action;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenScreen(@NotNull NavDirections navDirections) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(navDirections, NativeProtocol.WEB_DIALOG_ACTION);
            this.action = navDirections;
        }

        public static /* synthetic */ OpenScreen copy$default(OpenScreen openScreen, NavDirections navDirections, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                navDirections = openScreen.action;
            }
            return openScreen.copy(navDirections);
        }

        @NotNull
        public final NavDirections component1() {
            return this.action;
        }

        @NotNull
        public final OpenScreen copy(@NotNull NavDirections navDirections) {
            Intrinsics.checkNotNullParameter(navDirections, NativeProtocol.WEB_DIALOG_ACTION);
            return new OpenScreen(navDirections);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenScreen) && Intrinsics.areEqual((Object) this.action, (Object) ((OpenScreen) obj).action);
        }

        @NotNull
        public final NavDirections getAction() {
            return this.action;
        }

        public int hashCode() {
            return this.action.hashCode();
        }

        @NotNull
        public String toString() {
            NavDirections navDirections = this.action;
            return "OpenScreen(action=" + navDirections + ")";
        }
    }

    private NavigationCommand() {
    }

    public /* synthetic */ NavigationCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
