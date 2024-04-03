package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface ContextRuleOrBuilder extends MessageLiteOrBuilder {
    String getAllowedRequestExtensions(int i11);

    ByteString getAllowedRequestExtensionsBytes(int i11);

    int getAllowedRequestExtensionsCount();

    List<String> getAllowedRequestExtensionsList();

    String getAllowedResponseExtensions(int i11);

    ByteString getAllowedResponseExtensionsBytes(int i11);

    int getAllowedResponseExtensionsCount();

    List<String> getAllowedResponseExtensionsList();

    String getProvided(int i11);

    ByteString getProvidedBytes(int i11);

    int getProvidedCount();

    List<String> getProvidedList();

    String getRequested(int i11);

    ByteString getRequestedBytes(int i11);

    int getRequestedCount();

    List<String> getRequestedList();

    String getSelector();

    ByteString getSelectorBytes();
}
