package com.talabat.authentication.token.data.model;

import com.talabat.authentication.aaa.GenericErrorBody;
import com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody;
import com.talabat.authentication.token.data.model.TokenData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"toMigrationExchangeTokenDataError", "Lcom/talabat/authentication/token/data/model/TokenData$Error;", "Lcom/talabat/authentication/aaa/MigrationExchangeTokenErrorBody;", "toTokenDataError", "Lcom/talabat/authentication/aaa/GenericErrorBody;", "com_talabat_Authentication_Authentication"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TokenDataExtensionsKt {
    @NotNull
    public static final TokenData.Error toMigrationExchangeTokenDataError(@NotNull MigrationExchangeTokenErrorBody migrationExchangeTokenErrorBody) {
        int i11;
        String str;
        MigrationExchangeTokenErrorBody.Error error;
        MigrationExchangeTokenErrorBody.Error error2;
        MigrationExchangeTokenErrorBody.Error error3;
        String status;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(migrationExchangeTokenErrorBody, "<this>");
        List<MigrationExchangeTokenErrorBody.Error> errors = migrationExchangeTokenErrorBody.getErrors();
        if (errors == null || (error3 = errors.get(0)) == null || (status = error3.getStatus()) == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(status)) == null) {
            i11 = -1;
        } else {
            i11 = intOrNull.intValue();
        }
        List<MigrationExchangeTokenErrorBody.Error> errors2 = migrationExchangeTokenErrorBody.getErrors();
        String str2 = null;
        if (errors2 == null || (error2 = errors2.get(0)) == null) {
            str = null;
        } else {
            str = error2.getTitle();
        }
        List<MigrationExchangeTokenErrorBody.Error> errors3 = migrationExchangeTokenErrorBody.getErrors();
        if (!(errors3 == null || (error = errors3.get(0)) == null)) {
            str2 = error.getDetails();
        }
        if (str2 == null) {
            str2 = "";
        }
        return new TokenData.Error(i11, str, str2);
    }

    @NotNull
    public static final TokenData.Error toTokenDataError(@NotNull GenericErrorBody genericErrorBody) {
        String str;
        GenericErrorBody.Data.ExceptionType exceptionType;
        Intrinsics.checkNotNullParameter(genericErrorBody, "<this>");
        int statusCode = genericErrorBody.getStatusCode();
        GenericErrorBody.Data data = genericErrorBody.getData();
        String str2 = null;
        if (data == null || (exceptionType = data.getExceptionType()) == null) {
            str = null;
        } else {
            str = exceptionType.toString();
        }
        GenericErrorBody.Data data2 = genericErrorBody.getData();
        if (data2 != null) {
            str2 = data2.getExceptionMessage();
        }
        if (str2 == null) {
            str2 = "";
        }
        return new TokenData.Error(statusCode, str, str2);
    }
}
