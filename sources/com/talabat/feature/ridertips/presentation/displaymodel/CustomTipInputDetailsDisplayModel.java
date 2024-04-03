package com.talabat.feature.ridertips.presentation.displaymodel;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/displaymodel/CustomTipInputDetailsDisplayModel;", "", "ctaMode", "Lcom/talabat/feature/ridertips/presentation/displaymodel/CtaMode;", "ctaTitleResId", "", "hintResId", "inputText", "", "ctaEnabled", "", "(Lcom/talabat/feature/ridertips/presentation/displaymodel/CtaMode;IILjava/lang/String;Z)V", "getCtaEnabled", "()Z", "getCtaMode", "()Lcom/talabat/feature/ridertips/presentation/displaymodel/CtaMode;", "getCtaTitleResId", "()I", "getHintResId", "getInputText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomTipInputDetailsDisplayModel {
    public static final int $stable = 0;
    private final boolean ctaEnabled;
    @NotNull
    private final CtaMode ctaMode;
    private final int ctaTitleResId;
    private final int hintResId;
    @NotNull
    private final String inputText;

    public CustomTipInputDetailsDisplayModel(@NotNull CtaMode ctaMode2, int i11, int i12, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(ctaMode2, "ctaMode");
        Intrinsics.checkNotNullParameter(str, "inputText");
        this.ctaMode = ctaMode2;
        this.ctaTitleResId = i11;
        this.hintResId = i12;
        this.inputText = str;
        this.ctaEnabled = z11;
    }

    public static /* synthetic */ CustomTipInputDetailsDisplayModel copy$default(CustomTipInputDetailsDisplayModel customTipInputDetailsDisplayModel, CtaMode ctaMode2, int i11, int i12, String str, boolean z11, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            ctaMode2 = customTipInputDetailsDisplayModel.ctaMode;
        }
        if ((i13 & 2) != 0) {
            i11 = customTipInputDetailsDisplayModel.ctaTitleResId;
        }
        int i14 = i11;
        if ((i13 & 4) != 0) {
            i12 = customTipInputDetailsDisplayModel.hintResId;
        }
        int i15 = i12;
        if ((i13 & 8) != 0) {
            str = customTipInputDetailsDisplayModel.inputText;
        }
        String str2 = str;
        if ((i13 & 16) != 0) {
            z11 = customTipInputDetailsDisplayModel.ctaEnabled;
        }
        return customTipInputDetailsDisplayModel.copy(ctaMode2, i14, i15, str2, z11);
    }

    @NotNull
    public final CtaMode component1() {
        return this.ctaMode;
    }

    public final int component2() {
        return this.ctaTitleResId;
    }

    public final int component3() {
        return this.hintResId;
    }

    @NotNull
    public final String component4() {
        return this.inputText;
    }

    public final boolean component5() {
        return this.ctaEnabled;
    }

    @NotNull
    public final CustomTipInputDetailsDisplayModel copy(@NotNull CtaMode ctaMode2, int i11, int i12, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(ctaMode2, "ctaMode");
        Intrinsics.checkNotNullParameter(str, "inputText");
        return new CustomTipInputDetailsDisplayModel(ctaMode2, i11, i12, str, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomTipInputDetailsDisplayModel)) {
            return false;
        }
        CustomTipInputDetailsDisplayModel customTipInputDetailsDisplayModel = (CustomTipInputDetailsDisplayModel) obj;
        return this.ctaMode == customTipInputDetailsDisplayModel.ctaMode && this.ctaTitleResId == customTipInputDetailsDisplayModel.ctaTitleResId && this.hintResId == customTipInputDetailsDisplayModel.hintResId && Intrinsics.areEqual((Object) this.inputText, (Object) customTipInputDetailsDisplayModel.inputText) && this.ctaEnabled == customTipInputDetailsDisplayModel.ctaEnabled;
    }

    public final boolean getCtaEnabled() {
        return this.ctaEnabled;
    }

    @NotNull
    public final CtaMode getCtaMode() {
        return this.ctaMode;
    }

    public final int getCtaTitleResId() {
        return this.ctaTitleResId;
    }

    public final int getHintResId() {
        return this.hintResId;
    }

    @NotNull
    public final String getInputText() {
        return this.inputText;
    }

    public int hashCode() {
        int hashCode = ((((((this.ctaMode.hashCode() * 31) + this.ctaTitleResId) * 31) + this.hintResId) * 31) + this.inputText.hashCode()) * 31;
        boolean z11 = this.ctaEnabled;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        CtaMode ctaMode2 = this.ctaMode;
        int i11 = this.ctaTitleResId;
        int i12 = this.hintResId;
        String str = this.inputText;
        boolean z11 = this.ctaEnabled;
        return "CustomTipInputDetailsDisplayModel(ctaMode=" + ctaMode2 + ", ctaTitleResId=" + i11 + ", hintResId=" + i12 + ", inputText=" + str + ", ctaEnabled=" + z11 + ")";
    }
}
