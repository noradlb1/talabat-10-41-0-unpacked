package com.huawei.wearengine.common;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.p2p.Message;
import com.huawei.wearengine.p2p.MessageParcel;
import com.huawei.wearengine.p2p.MessageParcelExtra;
import com.huawei.wearengine.utils.HexUtil;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class a {
    public static int a(String str, String str2) {
        return Log.e("WearEngine_" + str, str2);
    }

    public static MessageParcel a(Message message) {
        File file;
        if (message == null) {
            return null;
        }
        MessageParcel messageParcel = new MessageParcel();
        int type = message.getType();
        messageParcel.setType(type);
        if (type == 1) {
            messageParcel.setData(message.getData());
            return messageParcel;
        } else if (type != 2 || (file = message.getFile()) == null) {
            return messageParcel;
        } else {
            try {
                messageParcel.setParcelFileDescriptor(ParcelFileDescriptor.open(file, 268435456));
                messageParcel.setFileName(file.getName());
                messageParcel.setDescription(message.getDescription());
                messageParcel.setFileSha256(HexUtil.getFileShaHex(file));
                return messageParcel;
            } catch (FileNotFoundException unused) {
                throw com.huawei.wearengine.a.a("ConvertParcelUtil", "convertToMessageParcel FileNotFoundException", 10);
            }
        }
    }

    public static <T> T a(T t11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        a("Preconditions", String.valueOf(obj));
        throw new WearEngineException(5);
    }

    public static void a(String str, int i11) {
        try {
            if (TextUtils.isEmpty(str) || str.getBytes("UTF-8").length > i11) {
                a("Preconditions", "checkArgumentByteLimit exceeded the maximum length: " + str);
                throw new WearEngineException(5);
            }
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.wearengine.a.a("Preconditions", "checkArgumentByteLimit UnsupportedEncodingException", 5);
        }
    }

    public static int b(String str, String str2) {
        return Log.i("WearEngine_" + str, str2);
    }

    public static MessageParcelExtra b(Message message) {
        String str;
        if (message == null) {
            str = "convertToMessageParcelExtra message is null";
        } else {
            MessageParcel a11 = a(message);
            if (a11 == null) {
                str = "convertToMessageParcelExtra messageParcel is null";
            } else {
                MessageParcelExtra messageParcelExtra = new MessageParcelExtra();
                messageParcelExtra.setType(a11.getType());
                messageParcelExtra.setData(a11.getData());
                messageParcelExtra.setParcelFileDescriptor(a11.getParcelFileDescriptor());
                messageParcelExtra.setFileName(a11.getFileName());
                messageParcelExtra.setDescription(a11.getDescription());
                messageParcelExtra.setFileSha256(a11.getFileSha256());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("message_enable_encrypt", message.isEnableEncrypt());
                } catch (JSONException unused) {
                    a("P2pJsonUtil", "buildMessageExJson JSONException");
                }
                messageParcelExtra.setExtendJson(JSONObjectInstrumentation.toString(jSONObject));
                return messageParcelExtra;
            }
        }
        a("ConvertParcelUtil", str);
        return null;
    }

    public static int c(String str, String str2) {
        return Log.w("WearEngine_" + str, str2);
    }
}
