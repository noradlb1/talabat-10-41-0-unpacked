package com.talabat.darkstores.feature.searchResults;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentArgs;", "Landroidx/navigation/NavArgs;", "resultsType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "eventOrigin", "", "(Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;Ljava/lang/String;)V", "getEventOrigin", "()Ljava/lang/String;", "getResultsType", "()Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsFragmentArgs implements NavArgs {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final String eventOrigin;
    @NotNull
    private final SearchResultsType resultsType;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SearchResultsFragmentArgs fromBundle(@NotNull Bundle bundle) {
            String str;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(SearchResultsFragmentArgs.class.getClassLoader());
            if (bundle.containsKey("resultsType")) {
                Class<SearchResultsType> cls = SearchResultsType.class;
                if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                    SearchResultsType searchResultsType = (SearchResultsType) bundle.get("resultsType");
                    if (searchResultsType != null) {
                        if (bundle.containsKey("eventOrigin")) {
                            str = bundle.getString("eventOrigin");
                        } else {
                            str = null;
                        }
                        return new SearchResultsFragmentArgs(searchResultsType, str);
                    }
                    throw new IllegalArgumentException("Argument \"resultsType\" is marked as non-null but was passed a null value.");
                }
                String name2 = cls.getName();
                throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
            }
            throw new IllegalArgumentException("Required argument \"resultsType\" is missing and does not have an android:defaultValue");
        }

        @JvmStatic
        @NotNull
        public final SearchResultsFragmentArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
            String str;
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("resultsType")) {
                Class<SearchResultsType> cls = SearchResultsType.class;
                if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                    SearchResultsType searchResultsType = (SearchResultsType) savedStateHandle.get("resultsType");
                    if (searchResultsType != null) {
                        if (savedStateHandle.contains("eventOrigin")) {
                            str = (String) savedStateHandle.get("eventOrigin");
                        } else {
                            str = null;
                        }
                        return new SearchResultsFragmentArgs(searchResultsType, str);
                    }
                    throw new IllegalArgumentException("Argument \"resultsType\" is marked as non-null but was passed a null value");
                }
                String name2 = cls.getName();
                throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
            }
            throw new IllegalArgumentException("Required argument \"resultsType\" is missing and does not have an android:defaultValue");
        }
    }

    public SearchResultsFragmentArgs(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
        Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
        this.resultsType = searchResultsType;
        this.eventOrigin = str;
    }

    public static /* synthetic */ SearchResultsFragmentArgs copy$default(SearchResultsFragmentArgs searchResultsFragmentArgs, SearchResultsType searchResultsType, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            searchResultsType = searchResultsFragmentArgs.resultsType;
        }
        if ((i11 & 2) != 0) {
            str = searchResultsFragmentArgs.eventOrigin;
        }
        return searchResultsFragmentArgs.copy(searchResultsType, str);
    }

    @JvmStatic
    @NotNull
    public static final SearchResultsFragmentArgs fromBundle(@NotNull Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    @NotNull
    public static final SearchResultsFragmentArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    @NotNull
    public final SearchResultsType component1() {
        return this.resultsType;
    }

    @Nullable
    public final String component2() {
        return this.eventOrigin;
    }

    @NotNull
    public final SearchResultsFragmentArgs copy(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
        Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
        return new SearchResultsFragmentArgs(searchResultsType, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchResultsFragmentArgs)) {
            return false;
        }
        SearchResultsFragmentArgs searchResultsFragmentArgs = (SearchResultsFragmentArgs) obj;
        return Intrinsics.areEqual((Object) this.resultsType, (Object) searchResultsFragmentArgs.resultsType) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) searchResultsFragmentArgs.eventOrigin);
    }

    @Nullable
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    @NotNull
    public final SearchResultsType getResultsType() {
        return this.resultsType;
    }

    public int hashCode() {
        int hashCode = this.resultsType.hashCode() * 31;
        String str = this.eventOrigin;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        Class<SearchResultsType> cls = SearchResultsType.class;
        if (Parcelable.class.isAssignableFrom(cls)) {
            bundle.putParcelable("resultsType", this.resultsType);
        } else if (Serializable.class.isAssignableFrom(cls)) {
            bundle.putSerializable("resultsType", (Serializable) this.resultsType);
        } else {
            String name2 = cls.getName();
            throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        bundle.putString("eventOrigin", this.eventOrigin);
        return bundle;
    }

    @NotNull
    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        Class<SearchResultsType> cls = SearchResultsType.class;
        if (Parcelable.class.isAssignableFrom(cls)) {
            savedStateHandle.set("resultsType", this.resultsType);
        } else if (Serializable.class.isAssignableFrom(cls)) {
            savedStateHandle.set("resultsType", (Serializable) this.resultsType);
        } else {
            String name2 = cls.getName();
            throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        savedStateHandle.set("eventOrigin", this.eventOrigin);
        return savedStateHandle;
    }

    @NotNull
    public String toString() {
        SearchResultsType searchResultsType = this.resultsType;
        String str = this.eventOrigin;
        return "SearchResultsFragmentArgs(resultsType=" + searchResultsType + ", eventOrigin=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchResultsFragmentArgs(SearchResultsType searchResultsType, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(searchResultsType, (i11 & 2) != 0 ? null : str);
    }
}
