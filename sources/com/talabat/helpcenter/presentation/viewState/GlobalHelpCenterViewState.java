package com.talabat.helpcenter.presentation.viewState;

import android.net.Uri;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState;", "", "()V", "CheckPermissions", "Hidden", "Loading", "ReturnDataToClient", "ShowImageChooser", "Visible", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$Loading;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$Visible;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$Hidden;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$CheckPermissions;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$ReturnDataToClient;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$ShowImageChooser;", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class GlobalHelpCenterViewState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$CheckPermissions;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState;", "()V", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CheckPermissions extends GlobalHelpCenterViewState {
        @NotNull
        public static final CheckPermissions INSTANCE = new CheckPermissions();

        private CheckPermissions() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$Hidden;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState;", "()V", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends GlobalHelpCenterViewState {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$Loading;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState;", "()V", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends GlobalHelpCenterViewState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J \u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001b\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$ReturnDataToClient;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState;", "value", "", "Landroid/net/Uri;", "([Landroid/net/Uri;)V", "getValue", "()[Landroid/net/Uri;", "[Landroid/net/Uri;", "component1", "copy", "([Landroid/net/Uri;)Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$ReturnDataToClient;", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ReturnDataToClient extends GlobalHelpCenterViewState {
        @Nullable
        private final Uri[] value;

        public ReturnDataToClient(@Nullable Uri[] uriArr) {
            super((DefaultConstructorMarker) null);
            this.value = uriArr;
        }

        public static /* synthetic */ ReturnDataToClient copy$default(ReturnDataToClient returnDataToClient, Uri[] uriArr, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                uriArr = returnDataToClient.value;
            }
            return returnDataToClient.copy(uriArr);
        }

        @Nullable
        public final Uri[] component1() {
            return this.value;
        }

        @NotNull
        public final ReturnDataToClient copy(@Nullable Uri[] uriArr) {
            return new ReturnDataToClient(uriArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ReturnDataToClient) && Intrinsics.areEqual((Object) this.value, (Object) ((ReturnDataToClient) obj).value);
        }

        @Nullable
        public final Uri[] getValue() {
            return this.value;
        }

        public int hashCode() {
            Uri[] uriArr = this.value;
            if (uriArr == null) {
                return 0;
            }
            return Arrays.hashCode(uriArr);
        }

        @NotNull
        public String toString() {
            String arrays = Arrays.toString(this.value);
            return "ReturnDataToClient(value=" + arrays + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$ShowImageChooser;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState;", "()V", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowImageChooser extends GlobalHelpCenterViewState {
        @NotNull
        public static final ShowImageChooser INSTANCE = new ShowImageChooser();

        private ShowImageChooser() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState$Visible;", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Visible extends GlobalHelpCenterViewState {
        @NotNull
        private final String url;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Visible(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "url");
            this.url = str;
        }

        public static /* synthetic */ Visible copy$default(Visible visible, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = visible.url;
            }
            return visible.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.url;
        }

        @NotNull
        public final Visible copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new Visible(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Visible) && Intrinsics.areEqual((Object) this.url, (Object) ((Visible) obj).url);
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.url;
            return "Visible(url=" + str + ")";
        }
    }

    private GlobalHelpCenterViewState() {
    }

    public /* synthetic */ GlobalHelpCenterViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
