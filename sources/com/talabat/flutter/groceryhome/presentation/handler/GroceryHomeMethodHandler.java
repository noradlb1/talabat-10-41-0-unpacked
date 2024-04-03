package com.talabat.flutter.groceryhome.presentation.handler;

import datamodels.Restaurant;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "unsubscribe", "", "Callback", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GroceryHomeMethodHandler extends MethodChannel.MethodCallHandler {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandler$Callback;", "", "onNavigationToLifestyleProducts", "", "vendor", "Ldatamodels/Restaurant;", "swimlaneId", "", "missionName", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Callback {
        void onNavigationToLifestyleProducts(@NotNull Restaurant restaurant, @NotNull String str, @NotNull String str2);
    }

    void unsubscribe();
}
