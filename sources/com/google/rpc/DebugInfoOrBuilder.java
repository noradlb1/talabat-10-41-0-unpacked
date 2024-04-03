package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface DebugInfoOrBuilder extends MessageLiteOrBuilder {
    String getDetail();

    ByteString getDetailBytes();

    String getStackEntries(int i11);

    ByteString getStackEntriesBytes(int i11);

    int getStackEntriesCount();

    List<String> getStackEntriesList();
}
