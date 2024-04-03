package fwfd.com.fwfsdk.util;

public interface FWFResultCallback<T> {
    void onError(String str);

    void onResponse(T t11);
}
