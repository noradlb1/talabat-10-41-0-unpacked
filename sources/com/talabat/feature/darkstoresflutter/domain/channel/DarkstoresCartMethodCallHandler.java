package com.talabat.feature.darkstoresflutter.domain.channel;

import io.flutter.embedding.engine.FlutterEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandler;", "", "setUpWithEngine", "", "engine", "Lio/flutter/embedding/engine/FlutterEngine;", "methodHandlerCallback", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandler$MethodHandlerCallback;", "terminate", "MethodHandlerCallback", "com_talabat_feature_darkstores-flutter_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresCartMethodCallHandler {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandler$MethodHandlerCallback;", "", "com_talabat_feature_darkstores-flutter_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface MethodHandlerCallback {
    }

    void setUpWithEngine(@NotNull FlutterEngine flutterEngine, @NotNull MethodHandlerCallback methodHandlerCallback);

    void terminate();
}
