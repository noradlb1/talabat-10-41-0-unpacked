package JsonModels;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.google.gson.annotations.SerializedName;
import datamodels.CustomerInfo;
import datamodels.TTransactionResponse;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class TransactionDetailsResponse {
    @SerializedName("customer")
    public CustomerInfo customerInfo;
    public TokenisationCreditCard[] tokens;
    public TTransactionResponse transaction;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TransactionDetailsResponse transactionDetailsResponse = (TransactionDetailsResponse) obj;
        TTransactionResponse tTransactionResponse = this.transaction;
        if (tTransactionResponse == null ? transactionDetailsResponse.transaction != null : !tTransactionResponse.equals(transactionDetailsResponse.transaction)) {
            return false;
        }
        if (!Arrays.equals(this.tokens, transactionDetailsResponse.tokens)) {
            return false;
        }
        CustomerInfo customerInfo2 = this.customerInfo;
        if (customerInfo2 != null) {
            return customerInfo2.equals(transactionDetailsResponse.customerInfo);
        }
        if (transactionDetailsResponse.customerInfo == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        TTransactionResponse tTransactionResponse = this.transaction;
        int i12 = 0;
        if (tTransactionResponse != null) {
            i11 = tTransactionResponse.hashCode();
        } else {
            i11 = 0;
        }
        int hashCode = ((i11 * 31) + Arrays.hashCode(this.tokens)) * 31;
        CustomerInfo customerInfo2 = this.customerInfo;
        if (customerInfo2 != null) {
            i12 = customerInfo2.hashCode();
        }
        return hashCode + i12;
    }

    public String toString() {
        return "TransactionDetailsResponse{transaction=" + this.transaction + ", tokens=" + Arrays.toString(this.tokens) + ", customerInfo=" + this.customerInfo + AbstractJsonLexerKt.END_OBJ;
    }
}
