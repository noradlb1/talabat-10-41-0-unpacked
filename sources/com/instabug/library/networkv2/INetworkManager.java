package com.instabug.library.networkv2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.request.Request;

public interface INetworkManager {
    @WorkerThread
    void doRequest(@IBGNetworkWorker String str, int i11, @NonNull Request request, Request.Callbacks<RequestResponse, Throwable> callbacks);

    @WorkerThread
    void doRequestOnSameThread(int i11, @NonNull Request request, Request.Callbacks<RequestResponse, Throwable> callbacks);

    @Nullable
    NetworkManager.OnDoRequestListener getOnDoRequestListener();

    void setOnDoRequestListener(@Nullable NetworkManager.OnDoRequestListener onDoRequestListener);
}
