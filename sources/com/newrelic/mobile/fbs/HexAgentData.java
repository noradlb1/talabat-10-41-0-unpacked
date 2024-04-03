package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import com.newrelic.mobile.fbs.hex.HandledException;
import com.newrelic.mobile.fbs.jserror.JsError;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class HexAgentData extends Table {
    public static void addApplicationInfo(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(5, i11, 0);
    }

    public static void addBoolAttributes(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(3, i11, 0);
    }

    public static void addDoubleAttributes(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(2, i11, 0);
    }

    public static void addHandledExceptions(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(4, i11, 0);
    }

    public static void addJsErrors(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(7, i11, 0);
    }

    public static void addLongAttributes(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(1, i11, 0);
    }

    public static void addRequestInfo(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(6, i11, 0);
    }

    public static void addStringAttributes(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(0, i11, 0);
    }

    public static int createBoolAttributesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createDoubleAttributesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createHandledExceptionsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createHexAgentData(FlatBufferBuilder flatBufferBuilder, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        flatBufferBuilder.startObject(8);
        addJsErrors(flatBufferBuilder, i18);
        addRequestInfo(flatBufferBuilder, i17);
        addApplicationInfo(flatBufferBuilder, i16);
        addHandledExceptions(flatBufferBuilder, i15);
        addBoolAttributes(flatBufferBuilder, i14);
        addDoubleAttributes(flatBufferBuilder, i13);
        addLongAttributes(flatBufferBuilder, i12);
        addStringAttributes(flatBufferBuilder, i11);
        return endHexAgentData(flatBufferBuilder);
    }

    public static int createJsErrorsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createLongAttributesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createStringAttributesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int endHexAgentData(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishHexAgentDataBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finish(i11);
    }

    public static void finishSizePrefixedHexAgentDataBuffer(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.finishSizePrefixed(i11);
    }

    public static HexAgentData getRootAsHexAgentData(ByteBuffer byteBuffer) {
        return getRootAsHexAgentData(byteBuffer, new HexAgentData());
    }

    public static void startBoolAttributesVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public static void startDoubleAttributesVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public static void startHandledExceptionsVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public static void startHexAgentData(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(8);
    }

    public static void startJsErrorsVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public static void startLongAttributesVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public static void startStringAttributesVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public HexAgentData __assign(int i11, ByteBuffer byteBuffer) {
        __init(i11, byteBuffer);
        return this;
    }

    public void __init(int i11, ByteBuffer byteBuffer) {
        this.bb_pos = i11;
        this.f52789bb = byteBuffer;
        int i12 = i11 - byteBuffer.getInt(i11);
        this.vtable_start = i12;
        this.vtable_size = this.f52789bb.getShort(i12);
    }

    public ApplicationInfo applicationInfo() {
        return applicationInfo(new ApplicationInfo());
    }

    public BoolSessionAttribute boolAttributes(int i11) {
        return boolAttributes(new BoolSessionAttribute(), i11);
    }

    public BoolSessionAttribute boolAttributesByKey(String str) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return BoolSessionAttribute.__lookup_by_key((BoolSessionAttribute) null, __vector(__offset), str, this.f52789bb);
        }
        return null;
    }

    public int boolAttributesLength() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public DoubleSessionAttribute doubleAttributes(int i11) {
        return doubleAttributes(new DoubleSessionAttribute(), i11);
    }

    public DoubleSessionAttribute doubleAttributesByKey(String str) {
        int __offset = __offset(8);
        if (__offset != 0) {
            return DoubleSessionAttribute.__lookup_by_key((DoubleSessionAttribute) null, __vector(__offset), str, this.f52789bb);
        }
        return null;
    }

    public int doubleAttributesLength() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public HandledException handledExceptions(int i11) {
        return handledExceptions(new HandledException(), i11);
    }

    public int handledExceptionsLength() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public JsError jsErrors(int i11) {
        return jsErrors(new JsError(), i11);
    }

    public int jsErrorsLength() {
        int __offset = __offset(18);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public LongSessionAttribute longAttributes(int i11) {
        return longAttributes(new LongSessionAttribute(), i11);
    }

    public LongSessionAttribute longAttributesByKey(String str) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return LongSessionAttribute.__lookup_by_key((LongSessionAttribute) null, __vector(__offset), str, this.f52789bb);
        }
        return null;
    }

    public int longAttributesLength() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public RequestInformation requestInfo() {
        return requestInfo(new RequestInformation());
    }

    public StringSessionAttribute stringAttributes(int i11) {
        return stringAttributes(new StringSessionAttribute(), i11);
    }

    public StringSessionAttribute stringAttributesByKey(String str) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return StringSessionAttribute.__lookup_by_key((StringSessionAttribute) null, __vector(__offset), str, this.f52789bb);
        }
        return null;
    }

    public int stringAttributesLength() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public static HexAgentData getRootAsHexAgentData(ByteBuffer byteBuffer, HexAgentData hexAgentData) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return hexAgentData.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public ApplicationInfo applicationInfo(ApplicationInfo applicationInfo) {
        int __offset = __offset(14);
        if (__offset != 0) {
            return applicationInfo.__assign(__indirect(__offset + this.bb_pos), this.f52789bb);
        }
        return null;
    }

    public BoolSessionAttribute boolAttributes(BoolSessionAttribute boolSessionAttribute, int i11) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return boolSessionAttribute.__assign(__indirect(__vector(__offset) + (i11 * 4)), this.f52789bb);
        }
        return null;
    }

    public BoolSessionAttribute boolAttributesByKey(BoolSessionAttribute boolSessionAttribute, String str) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return BoolSessionAttribute.__lookup_by_key(boolSessionAttribute, __vector(__offset), str, this.f52789bb);
        }
        return null;
    }

    public DoubleSessionAttribute doubleAttributes(DoubleSessionAttribute doubleSessionAttribute, int i11) {
        int __offset = __offset(8);
        if (__offset != 0) {
            return doubleSessionAttribute.__assign(__indirect(__vector(__offset) + (i11 * 4)), this.f52789bb);
        }
        return null;
    }

    public DoubleSessionAttribute doubleAttributesByKey(DoubleSessionAttribute doubleSessionAttribute, String str) {
        int __offset = __offset(8);
        if (__offset != 0) {
            return DoubleSessionAttribute.__lookup_by_key(doubleSessionAttribute, __vector(__offset), str, this.f52789bb);
        }
        return null;
    }

    public HandledException handledExceptions(HandledException handledException, int i11) {
        int __offset = __offset(12);
        if (__offset != 0) {
            return handledException.__assign(__indirect(__vector(__offset) + (i11 * 4)), this.f52789bb);
        }
        return null;
    }

    public JsError jsErrors(JsError jsError, int i11) {
        int __offset = __offset(18);
        if (__offset != 0) {
            return jsError.__assign(__indirect(__vector(__offset) + (i11 * 4)), this.f52789bb);
        }
        return null;
    }

    public LongSessionAttribute longAttributes(LongSessionAttribute longSessionAttribute, int i11) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return longSessionAttribute.__assign(__indirect(__vector(__offset) + (i11 * 4)), this.f52789bb);
        }
        return null;
    }

    public LongSessionAttribute longAttributesByKey(LongSessionAttribute longSessionAttribute, String str) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return LongSessionAttribute.__lookup_by_key(longSessionAttribute, __vector(__offset), str, this.f52789bb);
        }
        return null;
    }

    public RequestInformation requestInfo(RequestInformation requestInformation) {
        int __offset = __offset(16);
        if (__offset != 0) {
            return requestInformation.__assign(__indirect(__offset + this.bb_pos), this.f52789bb);
        }
        return null;
    }

    public StringSessionAttribute stringAttributes(StringSessionAttribute stringSessionAttribute, int i11) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return stringSessionAttribute.__assign(__indirect(__vector(__offset) + (i11 * 4)), this.f52789bb);
        }
        return null;
    }

    public StringSessionAttribute stringAttributesByKey(StringSessionAttribute stringSessionAttribute, String str) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return StringSessionAttribute.__lookup_by_key(stringSessionAttribute, __vector(__offset), str, this.f52789bb);
        }
        return null;
    }
}
