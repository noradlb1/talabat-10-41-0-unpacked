package library.talabat.mvp.login.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel;", "", "()V", "Available", "Error", "Unavailable", "Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel$Unavailable;", "Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel$Error;", "Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel$Available;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DeliveryAreaDetailsModel {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0002\u0010\u0014J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005HÆ\u0001J\u0013\u00107\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016¨\u0006="}, d2 = {"Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel$Available;", "Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel;", "istgo", "", "cvgid", "", "dlvid", "pdvid", "", "dlvst", "tstxt", "tstxv", "dlfet", "dlfev", "mnovl", "dlvtm", "mntxt", "mntxv", "vendorId", "chnid", "(ZJJLjava/lang/String;JJJJJJJJJJJ)V", "getChnid", "()J", "getCvgid", "getDlfet", "getDlfev", "getDlvid", "getDlvst", "getDlvtm", "getIstgo", "()Z", "getMnovl", "getMntxt", "getMntxv", "getPdvid", "()Ljava/lang/String;", "getTstxt", "getTstxv", "getVendorId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Available extends DeliveryAreaDetailsModel {
        private final long chnid;
        private final long cvgid;
        private final long dlfet;
        private final long dlfev;
        private final long dlvid;
        private final long dlvst;
        private final long dlvtm;
        private final boolean istgo;
        private final long mnovl;
        private final long mntxt;
        private final long mntxv;
        @NotNull
        private final String pdvid;
        private final long tstxt;
        private final long tstxv;
        private final long vendorId;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Available(boolean z11, long j11, long j12, @NotNull String str, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "pdvid");
            this.istgo = z11;
            this.cvgid = j11;
            this.dlvid = j12;
            this.pdvid = str;
            this.dlvst = j13;
            this.tstxt = j14;
            this.tstxv = j15;
            this.dlfet = j16;
            this.dlfev = j17;
            this.mnovl = j18;
            this.dlvtm = j19;
            this.mntxt = j21;
            this.mntxv = j22;
            this.vendorId = j23;
            this.chnid = j24;
        }

        public static /* synthetic */ Available copy$default(Available available, boolean z11, long j11, long j12, String str, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, int i11, Object obj) {
            Available available2 = available;
            int i12 = i11;
            return available.copy((i12 & 1) != 0 ? available2.istgo : z11, (i12 & 2) != 0 ? available2.cvgid : j11, (i12 & 4) != 0 ? available2.dlvid : j12, (i12 & 8) != 0 ? available2.pdvid : str, (i12 & 16) != 0 ? available2.dlvst : j13, (i12 & 32) != 0 ? available2.tstxt : j14, (i12 & 64) != 0 ? available2.tstxv : j15, (i12 & 128) != 0 ? available2.dlfet : j16, (i12 & 256) != 0 ? available2.dlfev : j17, (i12 & 512) != 0 ? available2.mnovl : j18, (i12 & 1024) != 0 ? available2.dlvtm : j19, (i12 & 2048) != 0 ? available2.mntxt : j21, (i12 & 4096) != 0 ? available2.mntxv : j22, (i12 & 8192) != 0 ? available2.vendorId : j23, (i12 & 16384) != 0 ? available2.chnid : j24);
        }

        public final boolean component1() {
            return this.istgo;
        }

        public final long component10() {
            return this.mnovl;
        }

        public final long component11() {
            return this.dlvtm;
        }

        public final long component12() {
            return this.mntxt;
        }

        public final long component13() {
            return this.mntxv;
        }

        public final long component14() {
            return this.vendorId;
        }

        public final long component15() {
            return this.chnid;
        }

        public final long component2() {
            return this.cvgid;
        }

        public final long component3() {
            return this.dlvid;
        }

        @NotNull
        public final String component4() {
            return this.pdvid;
        }

        public final long component5() {
            return this.dlvst;
        }

        public final long component6() {
            return this.tstxt;
        }

        public final long component7() {
            return this.tstxv;
        }

        public final long component8() {
            return this.dlfet;
        }

        public final long component9() {
            return this.dlfev;
        }

        @NotNull
        public final Available copy(boolean z11, long j11, long j12, @NotNull String str, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24) {
            boolean z12 = z11;
            Intrinsics.checkNotNullParameter(str, "pdvid");
            return new Available(z11, j11, j12, str, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, j24);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Available)) {
                return false;
            }
            Available available = (Available) obj;
            return this.istgo == available.istgo && this.cvgid == available.cvgid && this.dlvid == available.dlvid && Intrinsics.areEqual((Object) this.pdvid, (Object) available.pdvid) && this.dlvst == available.dlvst && this.tstxt == available.tstxt && this.tstxv == available.tstxv && this.dlfet == available.dlfet && this.dlfev == available.dlfev && this.mnovl == available.mnovl && this.dlvtm == available.dlvtm && this.mntxt == available.mntxt && this.mntxv == available.mntxv && this.vendorId == available.vendorId && this.chnid == available.chnid;
        }

        public final long getChnid() {
            return this.chnid;
        }

        public final long getCvgid() {
            return this.cvgid;
        }

        public final long getDlfet() {
            return this.dlfet;
        }

        public final long getDlfev() {
            return this.dlfev;
        }

        public final long getDlvid() {
            return this.dlvid;
        }

        public final long getDlvst() {
            return this.dlvst;
        }

        public final long getDlvtm() {
            return this.dlvtm;
        }

        public final boolean getIstgo() {
            return this.istgo;
        }

        public final long getMnovl() {
            return this.mnovl;
        }

        public final long getMntxt() {
            return this.mntxt;
        }

        public final long getMntxv() {
            return this.mntxv;
        }

        @NotNull
        public final String getPdvid() {
            return this.pdvid;
        }

        public final long getTstxt() {
            return this.tstxt;
        }

        public final long getTstxv() {
            return this.tstxv;
        }

        public final long getVendorId() {
            return this.vendorId;
        }

        public int hashCode() {
            boolean z11 = this.istgo;
            if (z11) {
                z11 = true;
            }
            return ((((((((((((((((((((((((((((z11 ? 1 : 0) * true) + a.a(this.cvgid)) * 31) + a.a(this.dlvid)) * 31) + this.pdvid.hashCode()) * 31) + a.a(this.dlvst)) * 31) + a.a(this.tstxt)) * 31) + a.a(this.tstxv)) * 31) + a.a(this.dlfet)) * 31) + a.a(this.dlfev)) * 31) + a.a(this.mnovl)) * 31) + a.a(this.dlvtm)) * 31) + a.a(this.mntxt)) * 31) + a.a(this.mntxv)) * 31) + a.a(this.vendorId)) * 31) + a.a(this.chnid);
        }

        @NotNull
        public String toString() {
            boolean z11 = this.istgo;
            long j11 = this.cvgid;
            long j12 = this.dlvid;
            String str = this.pdvid;
            long j13 = this.dlvst;
            long j14 = this.tstxt;
            long j15 = this.tstxv;
            long j16 = this.dlfet;
            long j17 = this.dlfev;
            long j18 = this.mnovl;
            long j19 = this.dlvtm;
            long j21 = this.mntxt;
            long j22 = this.mntxv;
            long j23 = this.vendorId;
            long j24 = this.chnid;
            return "Available(istgo=" + z11 + ", cvgid=" + j11 + ", dlvid=" + j12 + ", pdvid=" + str + ", dlvst=" + j13 + ", tstxt=" + j14 + ", tstxv=" + j15 + ", dlfet=" + j16 + ", dlfev=" + j17 + ", mnovl=" + j18 + ", dlvtm=" + j19 + ", mntxt=" + j21 + ", mntxv=" + j22 + ", vendorId=" + j23 + ", chnid=" + j24 + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel$Error;", "Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel;", "errorCode", "", "title", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getMessage", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends DeliveryAreaDetailsModel {
        @NotNull
        private final String errorCode;
        @NotNull
        private final String message;
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "errorCode");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "message");
            this.errorCode = str;
            this.title = str2;
            this.message = str3;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = error.errorCode;
            }
            if ((i11 & 2) != 0) {
                str2 = error.title;
            }
            if ((i11 & 4) != 0) {
                str3 = error.message;
            }
            return error.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.errorCode;
        }

        @NotNull
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final String component3() {
            return this.message;
        }

        @NotNull
        public final Error copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "errorCode");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "message");
            return new Error(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.errorCode, (Object) error.errorCode) && Intrinsics.areEqual((Object) this.title, (Object) error.title) && Intrinsics.areEqual((Object) this.message, (Object) error.message);
        }

        @NotNull
        public final String getErrorCode() {
            return this.errorCode;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((this.errorCode.hashCode() * 31) + this.title.hashCode()) * 31) + this.message.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.errorCode;
            String str2 = this.title;
            String str3 = this.message;
            return "Error(errorCode=" + str + ", title=" + str2 + ", message=" + str3 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel$Unavailable;", "Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel;", "()V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Unavailable extends DeliveryAreaDetailsModel {
        @NotNull
        public static final Unavailable INSTANCE = new Unavailable();

        private Unavailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    private DeliveryAreaDetailsModel() {
    }

    public /* synthetic */ DeliveryAreaDetailsModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
