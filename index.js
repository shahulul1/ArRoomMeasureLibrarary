
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
    }
}
// export default RNArRoomMeasureLibrary