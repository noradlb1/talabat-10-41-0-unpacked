package hb;

import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.IDownloadSupport;
import com.huawei.location.vdr.file.yn;

public final /* synthetic */ class a implements IDownloadSupport {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ yn f50641a;

    public /* synthetic */ a(yn ynVar) {
        this.f50641a = ynVar;
    }

    public final boolean isSupportDownloadFile(DownLoadFileBean downLoadFileBean) {
        return this.f50641a.yn(downLoadFileBean);
    }
}
