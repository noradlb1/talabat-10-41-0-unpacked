package JsonModels.Response;

import com.talabat.domain.address.Address;
import datamodels.Area;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"LJsonModels/Response/HomeMapAreaResponse;", "", "()V", "address", "Lcom/talabat/domain/address/Address;", "getAddress", "()Lcom/talabat/domain/address/Address;", "setAddress", "(Lcom/talabat/domain/address/Address;)V", "area", "Ldatamodels/Area;", "getArea", "()Ldatamodels/Area;", "setArea", "(Ldatamodels/Area;)V", "msg", "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapAreaResponse {
    @Nullable
    private Address address;
    @Nullable
    private Area area;
    @Nullable
    private String msg;

    @Nullable
    public final Address getAddress() {
        return this.address;
    }

    @Nullable
    public final Area getArea() {
        return this.area;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public final void setAddress(@Nullable Address address2) {
        this.address = address2;
    }

    public final void setArea(@Nullable Area area2) {
        this.area = area2;
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }
}
