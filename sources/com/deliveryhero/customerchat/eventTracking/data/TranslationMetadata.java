package com.deliveryhero.customerchat.eventTracking.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/data/TranslationMetadata;", "", "defaultLanguage", "", "supportedTranslations", "", "(Ljava/lang/String;Ljava/util/List;)V", "getDefaultLanguage", "()Ljava/lang/String;", "getSupportedTranslations", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TranslationMetadata {
    @Nullable
    private final String defaultLanguage;
    @Nullable
    private final List<String> supportedTranslations;

    public TranslationMetadata(@Nullable String str, @Nullable List<String> list) {
        this.defaultLanguage = str;
        this.supportedTranslations = list;
    }

    public static /* synthetic */ TranslationMetadata copy$default(TranslationMetadata translationMetadata, String str, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = translationMetadata.defaultLanguage;
        }
        if ((i11 & 2) != 0) {
            list = translationMetadata.supportedTranslations;
        }
        return translationMetadata.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.defaultLanguage;
    }

    @Nullable
    public final List<String> component2() {
        return this.supportedTranslations;
    }

    @NotNull
    public final TranslationMetadata copy(@Nullable String str, @Nullable List<String> list) {
        return new TranslationMetadata(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranslationMetadata)) {
            return false;
        }
        TranslationMetadata translationMetadata = (TranslationMetadata) obj;
        return Intrinsics.areEqual((Object) this.defaultLanguage, (Object) translationMetadata.defaultLanguage) && Intrinsics.areEqual((Object) this.supportedTranslations, (Object) translationMetadata.supportedTranslations);
    }

    @Nullable
    public final String getDefaultLanguage() {
        return this.defaultLanguage;
    }

    @Nullable
    public final List<String> getSupportedTranslations() {
        return this.supportedTranslations;
    }

    public int hashCode() {
        String str = this.defaultLanguage;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.supportedTranslations;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "TranslationMetadata(defaultLanguage=" + this.defaultLanguage + ", supportedTranslations=" + this.supportedTranslations + ')';
    }
}
