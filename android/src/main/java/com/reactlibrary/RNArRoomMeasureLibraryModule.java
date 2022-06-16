
package com.reactlibrary;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.shibuiwilliam.arcoremeasurement.Measurement;


public class RNArRoomMeasureLibraryModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNArRoomMeasureLibraryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod
  public void createCalendarEvent(String name, String location) {
  }

  @ReactMethod
  public void openSession() {
    Intent intent = new Intent(getCurrentActivity(),Measurement.class);
//    Bundle bundle = Measurement.Companion.createBundle();
    Activity currentActivity = getCurrentActivity();

//    intent.putExtra(Measurement.ON_BUTTON_CLICK_EVENT, new MeasurementViewCallback(reactContext));
//    if (bundle != null) {
      intent.putExtra(Measurement.ON_BUTTON_CLICK_EVENT, new MeasurementViewCallback(reactContext));

      if (currentActivity != null) {
        currentActivity.startActivity(intent);
      }
//    }
  }

  @Override
  public String getName() {
    return "RNArRoomMeasureLibrary";
  }
}