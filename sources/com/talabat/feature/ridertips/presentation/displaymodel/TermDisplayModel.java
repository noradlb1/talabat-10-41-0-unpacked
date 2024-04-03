package com.talabat.feature.ridertips.presentation.displaymodel;

import androidx.compose.runtime.internal.StabilityInferred;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/displaymodel/TermDisplayModel;", "Ljava/io/Serializable;", "iconResId", "", "text", "", "(ILjava/lang/String;)V", "getIconResId", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TermDisplayModel implements Serializable {
    public static final int $stable = 0;
    private final int iconResId;
    @NotNull
    private final String text;

    public TermDisplayModel(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.iconResId = i11;
        this.text = str;
    }

    public static /* synthetic */ TermDisplayModel copy$default(TermDisplayModel termDisplayModel, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = termDisplayModel.iconResId;
        }
        if ((i12 & 2) != 0) {
            str = termDisplayModel.text;
        }
        return termDisplayModel.copy(i11, str);
    }

    public final int component1() {
        return this.iconResId;
    }

    @NotNull
    public final String component2() {
        return this.text;
    }

    @NotNull
    public final TermDisplayModel copy(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new TermDisplayModel(i11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TermDisplayModel)) {
            return false;
        }
        TermDisplayModel termDisplayModel = (TermDisplayModel) obj;
        return this.iconResId == termDisplayModel.iconResId && Intrinsics.areEqual((Object) this.text, (Object) termDisplayModel.text);
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (this.iconResId * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.iconResId;
        String str = this.text;
        return "TermDisplayModel(iconResId=" + i11 + ", text=" + str + ")";
    }
}
