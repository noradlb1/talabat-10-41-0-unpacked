package com.huawei.wearengine.monitor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface MonitorDataCallback extends IInterface {

    public static class Default implements MonitorDataCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onChanged(int i11, MonitorItem monitorItem, MonitorData monitorData) {
        }
    }

    public static abstract class Stub extends Binder implements MonitorDataCallback {
        private static final String DESCRIPTOR = "com.huawei.wearengine.monitor.MonitorDataCallback";

        public static class Proxy implements MonitorDataCallback {
            public static MonitorDataCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onChanged(int i11, MonitorItem monitorItem, MonitorData monitorData) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    if (monitorItem != null) {
                        obtain.writeInt(1);
                        monitorItem.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (monitorData != null) {
                        obtain.writeInt(1);
                        monitorData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            monitorItem.readFromParcel(obtain2);
                        }
                        if (obtain2.readInt() != 0) {
                            monitorData.readFromParcel(obtain2);
                        }
                    } else {
                        Stub.getDefaultImpl().onChanged(i11, monitorItem, monitorData);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static MonitorDataCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof MonitorDataCallback)) ? new Proxy(iBinder) : (MonitorDataCallback) queryLocalInterface;
        }

        public static MonitorDataCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(MonitorDataCallback monitorDataCallback) {
            if (Proxy.sDefaultImpl != null || monitorDataCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = monitorDataCallback;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int readInt = parcel.readInt();
                MonitorData monitorData = null;
                MonitorItem createFromParcel = parcel.readInt() != 0 ? MonitorItem.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    monitorData = MonitorData.CREATOR.createFromParcel(parcel);
                }
                onChanged(readInt, createFromParcel, monitorData);
                parcel2.writeNoException();
                if (createFromParcel != null) {
                    parcel2.writeInt(1);
                    createFromParcel.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                if (monitorData != null) {
                    parcel2.writeInt(1);
                    monitorData.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onChanged(int i11, MonitorItem monitorItem, MonitorData monitorData);
}
