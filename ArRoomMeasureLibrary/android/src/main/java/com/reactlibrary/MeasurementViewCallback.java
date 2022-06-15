package com.reactlibrary;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.ar.sceneform.AnchorNode;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class MeasurementViewCallback implements com.shibuiwilliam.arcoremeasurement.MeasurementViewCallback {
    private static ReactApplicationContext reactContext = null;
    public MeasurementViewCallback(ReactApplicationContext currentContext) {
        reactContext = currentContext;
    }

    protected  MeasurementViewCallback(Parcel var1) {

    }

    public static final Parcelable.Creator<MeasurementViewCallback> CREATOR = new Parcelable.Creator<MeasurementViewCallback>() {
        @Override
        public MeasurementViewCallback createFromParcel(Parcel source) {
            return new MeasurementViewCallback(source);
        }

        @Override
        public MeasurementViewCallback[] newArray(int size) {
                return new MeasurementViewCallback[size];
        }
    };

//    @Override
//    public void onButtonClick() {
//        Log.e("mynameshahulll","workin fine");
//        WritableMap sampleCode = Arguments.createMap();
//        sampleCode.putString("name","shahul");
//        sendEvent("myName",sampleCode);
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    private  void sendEvent(String eventName, @Nullable WritableMap parms) {
        if (reactContext != null) {
            reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName,parms);
        }
    }

    @Override
    public void onButtonClick(@NonNull ArrayList<AnchorNode> placedAnchorNodes, @NonNull ArrayList<String> cordinatesType) {
        WritableMap payload = Arguments.createMap();
        for (int i=0; i<placedAnchorNodes.size(); i++){
            String type = cordinatesType.get(i);
            JSONObject obj = new JSONObject();
            try {
                obj.put("x", placedAnchorNodes.get(i).getWorldPosition().x * 100 );
                obj.put("y", placedAnchorNodes.get(i).getWorldPosition().z * 100 ) ;// y and z cordinates are different in backend
                obj.put("z", placedAnchorNodes.get(i).getWorldPosition().y * 100 );
                obj.put("position", "edede");
                obj.put("type",type );
                payload.putString(new String(String.valueOf(i)), obj.toString());
            } catch (JSONException e) {
                //some exception handler code.
            }
        }
        sendEvent("Coordinates", payload);
    }
}
