# INDOOR POSITIONING SYSTEM

## Description of Folders:
### 1) LSTM-Data
This contains all the accelerometer and gyroscope data that has been collected using the data collection app, and which will be used to train the LSTM models.
It includes separate data files as csv along with the combined data files.

### 2) LSTM-Models
This folder contains all the LSTM models that have been trained and tested using LSTMs with the help of Tensorflow.
They are saved as protocol buffer (.pb) files, one for Activity and the other for Activity Unit LSTM.

### 3) LSTM-Notebooks
The Python Jupyter Notebooks that contain the code that was used to create the LSTM models.

### 4) Data Collection App (Code)
The android studio Java code that was used to create the data collection app.

### 5) Indoor Positioning System App (Code)
The android studio Java code that was used to create the main app of our project.

### 6) PPTs & Videos
Contains all Powerpoint Presentations for semester 7 and semester 8 that were used during Project Reviews.
All videos embedded in the PPTs have been added as well.

### 7) Project Documentation
Contains project reports/documentations of both semester 7 and the semester 8.

Instructions to Use:
1. Copy .apk file to Android phone.
2. Install the .apk file.
3. Tap on screen to select current position on map.
4. Tap on "Destination" search box to select place you wish to travel to.
5. Tap on "Directions".
6. Follow the blue path indicated to reach your destination.

Intructions to Build & Run:
1. Open folder inside Indoor Positioning System App (Code) as an Android Studio project.
2. Connect your phone via USB cable.
3. Enable debugging.
4. File -> Sync Project with Gradle Files
5. Install SDK corresponding to your Android version.
6. Click "Build & Run".
