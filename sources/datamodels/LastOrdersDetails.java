package datamodels;

import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

public class LastOrdersDetails {
    public int lastOrderId;
    public int lastOrderRestId;
    public String lastOrderRestName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LastOrdersDetails lastOrdersDetails = (LastOrdersDetails) obj;
        if (this.lastOrderId == lastOrdersDetails.lastOrderId && this.lastOrderRestId == lastOrdersDetails.lastOrderRestId && Objects.equals(this.lastOrderRestName, lastOrdersDetails.lastOrderRestName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.lastOrderId), Integer.valueOf(this.lastOrderRestId), this.lastOrderRestName});
    }

    @NotNull
    public String toString() {
        return "LastOrdersDetails{lastOrderId=" + this.lastOrderId + ", lastOrderRestId=" + this.lastOrderRestId + ", lastOrderRestName='" + this.lastOrderRestName + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
