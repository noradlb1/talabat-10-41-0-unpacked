package com.talabat.userandlocation.choosecountry.presentation.displaymodel;

import com.talabat.userandlocation.choosecountry.presentation.Extras;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/DismissScreenDisplayModel;", "", "()V", "NoResult", "ToHomeScreen", "WithResult", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/DismissScreenDisplayModel$ToHomeScreen;", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/DismissScreenDisplayModel$WithResult;", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/DismissScreenDisplayModel$NoResult;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DismissScreenDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/DismissScreenDisplayModel$NoResult;", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/DismissScreenDisplayModel;", "()V", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NoResult extends DismissScreenDisplayModel {
        @NotNull
        public static final NoResult INSTANCE = new NoResult();

        private NoResult() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/DismissScreenDisplayModel$ToHomeScreen;", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/DismissScreenDisplayModel;", "extras", "Lcom/talabat/userandlocation/choosecountry/presentation/Extras;", "(Lcom/talabat/userandlocation/choosecountry/presentation/Extras;)V", "getExtras", "()Lcom/talabat/userandlocation/choosecountry/presentation/Extras;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ToHomeScreen extends DismissScreenDisplayModel {
        @NotNull
        private final Extras extras;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ToHomeScreen(@NotNull Extras extras2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(extras2, "extras");
            this.extras = extras2;
        }

        public static /* synthetic */ ToHomeScreen copy$default(ToHomeScreen toHomeScreen, Extras extras2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                extras2 = toHomeScreen.extras;
            }
            return toHomeScreen.copy(extras2);
        }

        @NotNull
        public final Extras component1() {
            return this.extras;
        }

        @NotNull
        public final ToHomeScreen copy(@NotNull Extras extras2) {
            Intrinsics.checkNotNullParameter(extras2, "extras");
            return new ToHomeScreen(extras2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ToHomeScreen) && Intrinsics.areEqual((Object) this.extras, (Object) ((ToHomeScreen) obj).extras);
        }

        @NotNull
        public final Extras getExtras() {
            return this.extras;
        }

        public int hashCode() {
            return this.extras.hashCode();
        }

        @NotNull
        public String toString() {
            Extras extras2 = this.extras;
            return "ToHomeScreen(extras=" + extras2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/DismissScreenDisplayModel$WithResult;", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/DismissScreenDisplayModel;", "selectedCountryId", "", "(I)V", "getSelectedCountryId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WithResult extends DismissScreenDisplayModel {
        private final int selectedCountryId;

        public WithResult(int i11) {
            super((DefaultConstructorMarker) null);
            this.selectedCountryId = i11;
        }

        public static /* synthetic */ WithResult copy$default(WithResult withResult, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = withResult.selectedCountryId;
            }
            return withResult.copy(i11);
        }

        public final int component1() {
            return this.selectedCountryId;
        }

        @NotNull
        public final WithResult copy(int i11) {
            return new WithResult(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WithResult) && this.selectedCountryId == ((WithResult) obj).selectedCountryId;
        }

        public final int getSelectedCountryId() {
            return this.selectedCountryId;
        }

        public int hashCode() {
            return this.selectedCountryId;
        }

        @NotNull
        public String toString() {
            int i11 = this.selectedCountryId;
            return "WithResult(selectedCountryId=" + i11 + ")";
        }
    }

    private DismissScreenDisplayModel() {
    }

    public /* synthetic */ DismissScreenDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
