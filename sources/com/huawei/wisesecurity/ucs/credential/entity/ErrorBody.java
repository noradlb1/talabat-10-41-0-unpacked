package com.huawei.wisesecurity.ucs.credential.entity;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import org.json.JSONException;
import org.json.JSONObject;

public class ErrorBody {
    @KfsStringNotEmpty
    public String errorCode;
    @KfsStringNotEmpty
    public String errorMessage;

    public static ErrorBody fromString(String str) throws UcsException {
        try {
            ErrorBody errorBody = new ErrorBody();
            JSONObject jSONObject = new JSONObject(str);
            errorBody.errorCode = jSONObject.optString("errorCode");
            errorBody.errorMessage = jSONObject.optString("errorMessage");
            KfsValidator.validate(errorBody);
            return errorBody;
        } catch (JSONException e11) {
            throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "ErrorBody param is not a valid json string : " + e11.getMessage());
        } catch (KfsValidationException e12) {
            throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "ErrorBody param invalid : " + e12.getMessage());
        }
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
