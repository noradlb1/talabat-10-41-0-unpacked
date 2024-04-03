package com.huawei.hms.dtm.provider.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import java.util.Map;

public interface IDtmDelegate extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.dtm.provider.api.IDtmDelegate";

    public static class Default implements IDtmDelegate {
        public IBinder asBinder() {
            return null;
        }

        public void flush() throws RemoteException {
        }

        public int getDtmCoreVersion() throws RemoteException {
            return 0;
        }

        public void init(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        }

        public void initWithConfig(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Map map) throws RemoteException {
        }

        public void logAutoEvent(String str, Bundle bundle) throws RemoteException {
        }

        public void logEvent(String str, Bundle bundle) throws RemoteException {
        }

        public void preview(String str) throws RemoteException {
        }

        public void registFilter(IDtmFilter iDtmFilter) throws RemoteException {
        }

        public void setParameter(Map map) throws RemoteException {
        }

        public void startVisualTrace(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDtmDelegate {

        public static class Proxy implements IDtmDelegate {
            public static IDtmDelegate sDefaultImpl;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f48670a;

            public Proxy(IBinder iBinder) {
                this.f48670a = iBinder;
            }

            public IBinder asBinder() {
                return this.f48670a;
            }

            public void flush() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmDelegate.DESCRIPTOR);
                    if (this.f48670a.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().flush();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getDtmCoreVersion() throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmDelegate.DESCRIPTOR);
                    if (this.f48670a.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().getDtmCoreVersion();
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDtmDelegate.DESCRIPTOR;
            }

            public void init(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmDelegate.DESCRIPTOR);
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (iObjectWrapper2 != null) {
                        iBinder = iObjectWrapper2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.f48670a.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().init(iObjectWrapper, iObjectWrapper2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void initWithConfig(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmDelegate.DESCRIPTOR);
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (iObjectWrapper2 != null) {
                        iBinder = iObjectWrapper2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeMap(map);
                    if (this.f48670a.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().initWithConfig(iObjectWrapper, iObjectWrapper2, map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void logAutoEvent(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmDelegate.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f48670a.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().logAutoEvent(str, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void logEvent(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmDelegate.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f48670a.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().logEvent(str, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void preview(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmDelegate.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.f48670a.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().preview(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registFilter(IDtmFilter iDtmFilter) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmDelegate.DESCRIPTOR);
                    obtain.writeStrongBinder(iDtmFilter != null ? iDtmFilter.asBinder() : null);
                    if (this.f48670a.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registFilter(iDtmFilter);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setParameter(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmDelegate.DESCRIPTOR);
                    obtain.writeMap(map);
                    if (this.f48670a.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setParameter(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startVisualTrace(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDtmDelegate.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.f48670a.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().startVisualTrace(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDtmDelegate.DESCRIPTOR);
        }

        public static IDtmDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDtmDelegate.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDtmDelegate)) ? new Proxy(iBinder) : (IDtmDelegate) queryLocalInterface;
        }

        public static IDtmDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDtmDelegate iDtmDelegate) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iDtmDelegate == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iDtmDelegate;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "com.huawei.hms.dtm.provider.api.IDtmDelegate"
                if (r5 == r0) goto L_0x00e1
                r0 = 0
                java.lang.Class<com.huawei.hms.dtm.provider.api.IDtmDelegate$Stub> r3 = com.huawei.hms.dtm.provider.api.IDtmDelegate.Stub.class
                switch(r5) {
                    case 1: goto L_0x00cf;
                    case 2: goto L_0x00b5;
                    case 3: goto L_0x0098;
                    case 4: goto L_0x007b;
                    case 5: goto L_0x006d;
                    case 6: goto L_0x005f;
                    case 7: goto L_0x0055;
                    case 8: goto L_0x0047;
                    case 9: goto L_0x0035;
                    case 10: goto L_0x0013;
                    default: goto L_0x000e;
                }
            L_0x000e:
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x0013:
                r6.enforceInterface(r2)
                android.os.IBinder r5 = r6.readStrongBinder()
                com.huawei.hms.feature.dynamic.IObjectWrapper r5 = com.huawei.hms.feature.dynamic.IObjectWrapper.Stub.asInterface(r5)
                android.os.IBinder r8 = r6.readStrongBinder()
                com.huawei.hms.feature.dynamic.IObjectWrapper r8 = com.huawei.hms.feature.dynamic.IObjectWrapper.Stub.asInterface(r8)
                java.lang.ClassLoader r0 = r3.getClassLoader()
                java.util.HashMap r6 = r6.readHashMap(r0)
                r4.initWithConfig(r5, r8, r6)
                r7.writeNoException()
                return r1
            L_0x0035:
                r6.enforceInterface(r2)
                java.lang.ClassLoader r5 = r3.getClassLoader()
                java.util.HashMap r5 = r6.readHashMap(r5)
                r4.setParameter(r5)
                r7.writeNoException()
                return r1
            L_0x0047:
                r6.enforceInterface(r2)
                java.lang.String r5 = r6.readString()
                r4.startVisualTrace(r5)
                r7.writeNoException()
                return r1
            L_0x0055:
                r6.enforceInterface(r2)
                r4.flush()
                r7.writeNoException()
                return r1
            L_0x005f:
                r6.enforceInterface(r2)
                int r5 = r4.getDtmCoreVersion()
                r7.writeNoException()
                r7.writeInt(r5)
                return r1
            L_0x006d:
                r6.enforceInterface(r2)
                java.lang.String r5 = r6.readString()
                r4.preview(r5)
                r7.writeNoException()
                return r1
            L_0x007b:
                r6.enforceInterface(r2)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x0091
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r0 = r6
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0091:
                r4.logAutoEvent(r5, r0)
                r7.writeNoException()
                return r1
            L_0x0098:
                r6.enforceInterface(r2)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x00ae
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r0 = r6
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x00ae:
                r4.logEvent(r5, r0)
                r7.writeNoException()
                return r1
            L_0x00b5:
                r6.enforceInterface(r2)
                android.os.IBinder r5 = r6.readStrongBinder()
                com.huawei.hms.feature.dynamic.IObjectWrapper r5 = com.huawei.hms.feature.dynamic.IObjectWrapper.Stub.asInterface(r5)
                android.os.IBinder r6 = r6.readStrongBinder()
                com.huawei.hms.feature.dynamic.IObjectWrapper r6 = com.huawei.hms.feature.dynamic.IObjectWrapper.Stub.asInterface(r6)
                r4.init(r5, r6)
                r7.writeNoException()
                return r1
            L_0x00cf:
                r6.enforceInterface(r2)
                android.os.IBinder r5 = r6.readStrongBinder()
                com.huawei.hms.dtm.provider.api.IDtmFilter r5 = com.huawei.hms.dtm.provider.api.IDtmFilter.Stub.asInterface(r5)
                r4.registFilter(r5)
                r7.writeNoException()
                return r1
            L_0x00e1:
                r7.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.provider.api.IDtmDelegate.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void flush() throws RemoteException;

    int getDtmCoreVersion() throws RemoteException;

    void init(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    void initWithConfig(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Map map) throws RemoteException;

    void logAutoEvent(String str, Bundle bundle) throws RemoteException;

    void logEvent(String str, Bundle bundle) throws RemoteException;

    void preview(String str) throws RemoteException;

    void registFilter(IDtmFilter iDtmFilter) throws RemoteException;

    void setParameter(Map map) throws RemoteException;

    void startVisualTrace(String str) throws RemoteException;
}
