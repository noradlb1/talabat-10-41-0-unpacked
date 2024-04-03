package com.talabat.darkstores.feature.cart.partialFulfillment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.talabat.darkstores.data.partialFulfillment.model.PreferencesResponse;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentBottomSheetArgs;", "Landroidx/navigation/NavArgs;", "preferences", "Lcom/talabat/darkstores/data/partialFulfillment/model/PreferencesResponse;", "selected", "", "(Lcom/talabat/darkstores/data/partialFulfillment/model/PreferencesResponse;Ljava/lang/String;)V", "getPreferences", "()Lcom/talabat/darkstores/data/partialFulfillment/model/PreferencesResponse;", "getSelected", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PartialFulfillmentBottomSheetArgs implements NavArgs {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final PreferencesResponse preferences;
    @NotNull
    private final String selected;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentBottomSheetArgs$Companion;", "", "()V", "fromBundle", "Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentBottomSheetArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final PartialFulfillmentBottomSheetArgs fromBundle(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(PartialFulfillmentBottomSheetArgs.class.getClassLoader());
            if (bundle.containsKey("preferences")) {
                Class<PreferencesResponse> cls = PreferencesResponse.class;
                if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                    PreferencesResponse preferencesResponse = (PreferencesResponse) bundle.get("preferences");
                    if (preferencesResponse == null) {
                        throw new IllegalArgumentException("Argument \"preferences\" is marked as non-null but was passed a null value.");
                    } else if (bundle.containsKey("selected")) {
                        String string = bundle.getString("selected");
                        if (string != null) {
                            return new PartialFulfillmentBottomSheetArgs(preferencesResponse, string);
                        }
                        throw new IllegalArgumentException("Argument \"selected\" is marked as non-null but was passed a null value.");
                    } else {
                        throw new IllegalArgumentException("Required argument \"selected\" is missing and does not have an android:defaultValue");
                    }
                } else {
                    String name2 = cls.getName();
                    throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
                }
            } else {
                throw new IllegalArgumentException("Required argument \"preferences\" is missing and does not have an android:defaultValue");
            }
        }

        @JvmStatic
        @NotNull
        public final PartialFulfillmentBottomSheetArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("preferences")) {
                Class<PreferencesResponse> cls = PreferencesResponse.class;
                if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                    PreferencesResponse preferencesResponse = (PreferencesResponse) savedStateHandle.get("preferences");
                    if (preferencesResponse == null) {
                        throw new IllegalArgumentException("Argument \"preferences\" is marked as non-null but was passed a null value");
                    } else if (savedStateHandle.contains("selected")) {
                        String str = (String) savedStateHandle.get("selected");
                        if (str != null) {
                            return new PartialFulfillmentBottomSheetArgs(preferencesResponse, str);
                        }
                        throw new IllegalArgumentException("Argument \"selected\" is marked as non-null but was passed a null value");
                    } else {
                        throw new IllegalArgumentException("Required argument \"selected\" is missing and does not have an android:defaultValue");
                    }
                } else {
                    String name2 = cls.getName();
                    throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
                }
            } else {
                throw new IllegalArgumentException("Required argument \"preferences\" is missing and does not have an android:defaultValue");
            }
        }
    }

    public PartialFulfillmentBottomSheetArgs(@NotNull PreferencesResponse preferencesResponse, @NotNull String str) {
        Intrinsics.checkNotNullParameter(preferencesResponse, "preferences");
        Intrinsics.checkNotNullParameter(str, "selected");
        this.preferences = preferencesResponse;
        this.selected = str;
    }

    public static /* synthetic */ PartialFulfillmentBottomSheetArgs copy$default(PartialFulfillmentBottomSheetArgs partialFulfillmentBottomSheetArgs, PreferencesResponse preferencesResponse, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            preferencesResponse = partialFulfillmentBottomSheetArgs.preferences;
        }
        if ((i11 & 2) != 0) {
            str = partialFulfillmentBottomSheetArgs.selected;
        }
        return partialFulfillmentBottomSheetArgs.copy(preferencesResponse, str);
    }

    @JvmStatic
    @NotNull
    public static final PartialFulfillmentBottomSheetArgs fromBundle(@NotNull Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    @NotNull
    public static final PartialFulfillmentBottomSheetArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    @NotNull
    public final PreferencesResponse component1() {
        return this.preferences;
    }

    @NotNull
    public final String component2() {
        return this.selected;
    }

    @NotNull
    public final PartialFulfillmentBottomSheetArgs copy(@NotNull PreferencesResponse preferencesResponse, @NotNull String str) {
        Intrinsics.checkNotNullParameter(preferencesResponse, "preferences");
        Intrinsics.checkNotNullParameter(str, "selected");
        return new PartialFulfillmentBottomSheetArgs(preferencesResponse, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialFulfillmentBottomSheetArgs)) {
            return false;
        }
        PartialFulfillmentBottomSheetArgs partialFulfillmentBottomSheetArgs = (PartialFulfillmentBottomSheetArgs) obj;
        return Intrinsics.areEqual((Object) this.preferences, (Object) partialFulfillmentBottomSheetArgs.preferences) && Intrinsics.areEqual((Object) this.selected, (Object) partialFulfillmentBottomSheetArgs.selected);
    }

    @NotNull
    public final PreferencesResponse getPreferences() {
        return this.preferences;
    }

    @NotNull
    public final String getSelected() {
        return this.selected;
    }

    public int hashCode() {
        return (this.preferences.hashCode() * 31) + this.selected.hashCode();
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        Class<PreferencesResponse> cls = PreferencesResponse.class;
        if (Parcelable.class.isAssignableFrom(cls)) {
            bundle.putParcelable("preferences", this.preferences);
        } else if (Serializable.class.isAssignableFrom(cls)) {
            bundle.putSerializable("preferences", (Serializable) this.preferences);
        } else {
            String name2 = cls.getName();
            throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        bundle.putString("selected", this.selected);
        return bundle;
    }

    @NotNull
    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        Class<PreferencesResponse> cls = PreferencesResponse.class;
        if (Parcelable.class.isAssignableFrom(cls)) {
            savedStateHandle.set("preferences", this.preferences);
        } else if (Serializable.class.isAssignableFrom(cls)) {
            savedStateHandle.set("preferences", (Serializable) this.preferences);
        } else {
            String name2 = cls.getName();
            throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        savedStateHandle.set("selected", this.selected);
        return savedStateHandle;
    }

    @NotNull
    public String toString() {
        PreferencesResponse preferencesResponse = this.preferences;
        String str = this.selected;
        return "PartialFulfillmentBottomSheetArgs(preferences=" + preferencesResponse + ", selected=" + str + ")";
    }
}
