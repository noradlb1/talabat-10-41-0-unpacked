package JsonModels.Response;

import JsonModels.TransactionDetailsResponse;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class TransactionDetailsRM {
    public TransactionDetailsResponse result;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TransactionDetailsResponse transactionDetailsResponse = this.result;
        TransactionDetailsResponse transactionDetailsResponse2 = ((TransactionDetailsRM) obj).result;
        if (transactionDetailsResponse != null) {
            return transactionDetailsResponse.equals(transactionDetailsResponse2);
        }
        if (transactionDetailsResponse2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        TransactionDetailsResponse transactionDetailsResponse = this.result;
        if (transactionDetailsResponse != null) {
            return transactionDetailsResponse.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "TransactionDetailsRM{result=" + this.result + AbstractJsonLexerKt.END_OBJ;
    }
}
