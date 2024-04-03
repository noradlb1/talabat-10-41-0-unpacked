package com.talabat.feature.ridertips.presentation.displaymodel;

import androidx.compose.runtime.internal.StabilityInferred;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/displaymodel/TermsDisplayModel;", "Ljava/io/Serializable;", "title", "", "description", "contents", "", "Lcom/talabat/feature/ridertips/presentation/displaymodel/TermDisplayModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContents", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TermsDisplayModel implements Serializable {
    public static final int $stable = 8;
    @NotNull
    private final List<TermDisplayModel> contents;
    @NotNull
    private final String description;
    @NotNull
    private final String title;

    public TermsDisplayModel(@NotNull String str, @NotNull String str2, @NotNull List<TermDisplayModel> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(list, "contents");
        this.title = str;
        this.description = str2;
        this.contents = list;
    }

    public static /* synthetic */ TermsDisplayModel copy$default(TermsDisplayModel termsDisplayModel, String str, String str2, List<TermDisplayModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = termsDisplayModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = termsDisplayModel.description;
        }
        if ((i11 & 4) != 0) {
            list = termsDisplayModel.contents;
        }
        return termsDisplayModel.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final List<TermDisplayModel> component3() {
        return this.contents;
    }

    @NotNull
    public final TermsDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull List<TermDisplayModel> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(list, "contents");
        return new TermsDisplayModel(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TermsDisplayModel)) {
            return false;
        }
        TermsDisplayModel termsDisplayModel = (TermsDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) termsDisplayModel.title) && Intrinsics.areEqual((Object) this.description, (Object) termsDisplayModel.description) && Intrinsics.areEqual((Object) this.contents, (Object) termsDisplayModel.contents);
    }

    @NotNull
    public final List<TermDisplayModel> getContents() {
        return this.contents;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.contents.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.description;
        List<TermDisplayModel> list = this.contents;
        return "TermsDisplayModel(title=" + str + ", description=" + str2 + ", contents=" + list + ")";
    }
}
