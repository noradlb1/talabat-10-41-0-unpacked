package com.talabat.feature.ridertips.data.remote.dto;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/ridertips/data/remote/dto/TermDto;", "", "keyword", "", "text", "(Ljava/lang/String;Ljava/lang/String;)V", "getKeyword", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TermDto {
    @Nullable
    private final String keyword;
    @Nullable
    private final String text;

    public TermDto(@Nullable @Json(name = "keyword") String str, @Nullable @Json(name = "text") String str2) {
        this.keyword = str;
        this.text = str2;
    }

    public static /* synthetic */ TermDto copy$default(TermDto termDto, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = termDto.keyword;
        }
        if ((i11 & 2) != 0) {
            str2 = termDto.text;
        }
        return termDto.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.keyword;
    }

    @Nullable
    public final String component2() {
        return this.text;
    }

    @NotNull
    public final TermDto copy(@Nullable @Json(name = "keyword") String str, @Nullable @Json(name = "text") String str2) {
        return new TermDto(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TermDto)) {
            return false;
        }
        TermDto termDto = (TermDto) obj;
        return Intrinsics.areEqual((Object) this.keyword, (Object) termDto.keyword) && Intrinsics.areEqual((Object) this.text, (Object) termDto.text);
    }

    @Nullable
    public final String getKeyword() {
        return this.keyword;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.keyword;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.keyword;
        String str2 = this.text;
        return "TermDto(keyword=" + str + ", text=" + str2 + ")";
    }
}
