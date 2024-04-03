package com.braze.enums.inappmessage;

import com.braze.models.IPutIntoJson;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/braze/enums/inappmessage/InAppMessageFailureType;", "", "Lcom/braze/models/IPutIntoJson;", "", "(Ljava/lang/String;I)V", "forJsonPut", "IMAGE_DOWNLOAD", "TEMPLATE_REQUEST", "ZIP_ASSET_DOWNLOAD", "DISPLAY_VIEW_GENERATION", "INTERNAL_TIMEOUT_EXCEEDED", "UNKNOWN_MESSAGE_TYPE", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum InAppMessageFailureType implements IPutIntoJson<String> {
    IMAGE_DOWNLOAD,
    TEMPLATE_REQUEST,
    ZIP_ASSET_DOWNLOAD,
    DISPLAY_VIEW_GENERATION,
    INTERNAL_TIMEOUT_EXCEEDED,
    UNKNOWN_MESSAGE_TYPE;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43724a = null;

        static {
            int[] iArr = new int[InAppMessageFailureType.values().length];
            iArr[InAppMessageFailureType.IMAGE_DOWNLOAD.ordinal()] = 1;
            iArr[InAppMessageFailureType.TEMPLATE_REQUEST.ordinal()] = 2;
            iArr[InAppMessageFailureType.ZIP_ASSET_DOWNLOAD.ordinal()] = 3;
            iArr[InAppMessageFailureType.DISPLAY_VIEW_GENERATION.ordinal()] = 4;
            iArr[InAppMessageFailureType.INTERNAL_TIMEOUT_EXCEEDED.ordinal()] = 5;
            iArr[InAppMessageFailureType.UNKNOWN_MESSAGE_TYPE.ordinal()] = 6;
            f43724a = iArr;
        }
    }

    public String forJsonPut() {
        switch (a.f43724a[ordinal()]) {
            case 1:
                return "if";
            case 2:
                return "tf";
            case 3:
                return "zf";
            case 4:
                return "vf";
            case 5:
                return "te";
            case 6:
                return "umt";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
