# INDOOR POSITIONING SYSTEM
>Machine learning based mobile application developed in android studio which uses data collected from the inertial sensors in the smartphone to locate the user. the application can be used in large indoor spaces to navigate to a specified destination using the shortest path.


## Description of Folders:
### LSTM-Data
This contains all the accelerometer and gyroscope data that has been collected using the data collection app, and which will be used to train the LSTM models.


* ### LSTM-Models
This folder contains all the LSTM models that have been trained and tested using LSTMs with the help of Tensorflow.
They are saved as protocol buffer (.pb) files, one for Activity and the other for Activity Unit LSTM.

* ### LSTM-Notebooks
The Python Jupyter Notebooks that contain the code that was used to create the LSTM models.

* ### Data Collection App (Code)
The android studio Java code that was used to create the data collection app.

* ### Indoor Positioning System App (Code)
The android studio Java code that was used to create the main app of our project.

* ### PPTs & Videos
Contains all Powerpoint Presentations  that were used during Project Reviews.
All videos embedded in the PPTs have been added as well.

* ### Project Documentation
Contains project reports/documentations of both semester 7 and the semester 8.

<br>

## Instructions to Use:
1. Copy .apk file to Android phone.
2. Install the .apk file.
3. Tap on screen to select current position on map.
4. Tap on "Destination" search box to select place you wish to travel to.
5. Tap on "Directions".
6. Follow the blue path indicated to reach your destination.

<br>

## Intructions to Build & Run:
1. Open folder inside Indoor Positioning System App (Code) as an Android Studio project.
2. Connect your phone via USB cable.
3. Enable debugging.
4. File -> Sync Project with Gradle Files
5. Install SDK corresponding to your Android version.
6. Click "Build & Run".

<br>

## Screenshots
<img src="https://user-images.githubusercontent.com/69889290/110186935-aa7ea300-7e0e-11eb-8ac0-54d3b9e71efc.png" width="200">             <img src="https://user-images.githubusercontent.com/69889290/110186978-c08c6380-7e0e-11eb-8463-8da8190ec762.png" width="200">

## [VIDEO DEMO](https://drive.google.com/file/d/1WEDI0Jt8ZPH1I-SFdTRIqrca7OstX5Io/view?usp=sharing)  |  [PROJECT REPORT](https://drive.google.com/file/d/17Eri4WDYI_enL5I9tk8zML1icJx5wQo_/view?usp=sharing)
