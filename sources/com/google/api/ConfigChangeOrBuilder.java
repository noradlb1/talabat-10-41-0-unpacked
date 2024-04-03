package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface ConfigChangeOrBuilder extends MessageLiteOrBuilder {
    Advice getAdvices(int i11);

    int getAdvicesCount();

    List<Advice> getAdvicesList();

    ChangeType getChangeType();

    int getChangeTypeValue();

    String getElement();

    ByteString getElementBytes();

    String getNewValue();

    ByteString getNewValueBytes();

    String getOldValue();

    ByteString getOldValueBytes();
}
