package datamodels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ldatamodels/UserOrderPreference;", "", "branchId", "", "branchName", "", "(ILjava/lang/String;)V", "()V", "additionalRequest", "getBranchId", "()I", "setBranchId", "(I)V", "getBranchName", "()Ljava/lang/String;", "setBranchName", "(Ljava/lang/String;)V", "isGoGreen", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserOrderPreference {
    @Nullable
    @JvmField
    public String additionalRequest;
    private int branchId;
    @Nullable
    private String branchName;
    @JvmField
    public boolean isGoGreen;

    public UserOrderPreference() {
        this.isGoGreen = true;
    }

    public final int getBranchId() {
        return this.branchId;
    }

    @Nullable
    public final String getBranchName() {
        return this.branchName;
    }

    public final void setBranchId(int i11) {
        this.branchId = i11;
    }

    public final void setBranchName(@Nullable String str) {
        this.branchName = str;
    }

    @NotNull
    public String toString() {
        int i11 = this.branchId;
        String str = this.branchName;
        boolean z11 = this.isGoGreen;
        String str2 = this.additionalRequest;
        return "toString() ---> " + i11 + " " + str + " " + z11 + " " + str2;
    }

    public UserOrderPreference(int i11, @Nullable String str) {
        this();
        this.branchId = i11;
        this.branchName = str;
        this.isGoGreen = true;
        this.additionalRequest = "";
    }
}
