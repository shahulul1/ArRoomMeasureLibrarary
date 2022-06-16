
# react-native-ar-room-measure-library

## Getting started

`$ npm install react-native-ar-room-measure-library --save`

### Mostly automatic installation

`$ react-native link react-native-ar-room-measure-library`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-ar-room-measure-library` and add `RNArRoomMeasureLibrary.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNArRoomMeasureLibrary.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNArRoomMeasureLibraryPackage;` to the imports at the top of the file
  - Add `new RNArRoomMeasureLibraryPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-ar-room-measure-library'
  	project(':react-native-ar-room-measure-library').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-ar-room-measure-library/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-ar-room-measure-library')
  	```


## Usage
```javascript
import RNArRoomMeasureLibrary from 'react-native-ar-room-measure-library';

// TODO: What to do with the module?
RNArRoomMeasureLibrary;
```
  