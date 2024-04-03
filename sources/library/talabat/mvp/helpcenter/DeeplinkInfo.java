package library.talabat.mvp.helpcenter;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Llibrary/talabat/mvp/helpcenter/DeeplinkInfo;", "Ljava/io/Serializable;", "sectionDeeplinkId", "", "questionDeeplinkId", "(II)V", "getQuestionDeeplinkId", "()I", "getSectionDeeplinkId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeeplinkInfo implements Serializable {
    private final int questionDeeplinkId;
    private final int sectionDeeplinkId;

    public DeeplinkInfo(int i11, int i12) {
        this.sectionDeeplinkId = i11;
        this.questionDeeplinkId = i12;
    }

    public static /* synthetic */ DeeplinkInfo copy$default(DeeplinkInfo deeplinkInfo, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = deeplinkInfo.sectionDeeplinkId;
        }
        if ((i13 & 2) != 0) {
            i12 = deeplinkInfo.questionDeeplinkId;
        }
        return deeplinkInfo.copy(i11, i12);
    }

    public final int component1() {
        return this.sectionDeeplinkId;
    }

    public final int component2() {
        return this.questionDeeplinkId;
    }

    @NotNull
    public final DeeplinkInfo copy(int i11, int i12) {
        return new DeeplinkInfo(i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeeplinkInfo)) {
            return false;
        }
        DeeplinkInfo deeplinkInfo = (DeeplinkInfo) obj;
        return this.sectionDeeplinkId == deeplinkInfo.sectionDeeplinkId && this.questionDeeplinkId == deeplinkInfo.questionDeeplinkId;
    }

    public final int getQuestionDeeplinkId() {
        return this.questionDeeplinkId;
    }

    public final int getSectionDeeplinkId() {
        return this.sectionDeeplinkId;
    }

    public int hashCode() {
        return (this.sectionDeeplinkId * 31) + this.questionDeeplinkId;
    }

    @NotNull
    public String toString() {
        int i11 = this.sectionDeeplinkId;
        int i12 = this.questionDeeplinkId;
        return "DeeplinkInfo(sectionDeeplinkId=" + i11 + ", questionDeeplinkId=" + i12 + ")";
    }
}
