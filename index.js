
import { NativeEventEmitter, NativeModules } from 'react-native';

const { RNArRoomMeasureLibrary } = NativeModules;

export default {
    getMeasurements() {
        RNArRoomMeasureLibrary.getMeasurements()
    },
    openSession() {
        RNArRoomMeasureLibrary.openSession()
    },
    subScribeForEvent(eventName,callback) {
        return new NativeEventEmitter(RNArRoomMeasureLibrary).addListener(
            eventName,
            e => {
                if (callback) {
                    callback(e)
                }
            }
        )
    },
    unSubScribeForEvent(eventName) {
        return new NativeEventEmitter(RNArRoomMeasureLibrary).removeAllListeners(eventName)
    }
}
// export default RNArRoomMeasureLibrary