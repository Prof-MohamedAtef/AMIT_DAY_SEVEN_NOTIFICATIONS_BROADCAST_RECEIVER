# AMIT_DAY_SEVEN_NOTIFICATIONS_BROADCAST_RECEIVER
### Project includes:
1. Notification Builder for: BigText, BigPicture, Messages, Emails, and Lines.
2. BroadcastReciever for: Airplane mode changes, and Wifi connection changes.

# 3 Firebase Messageing Service
3.1 initialize your project of Firebase and set it enabled on Google Cloud. 
3.2 Download google-services.json file and move it to app level on your project.
3.3 Import dependencies for firebase and google play services in your gradle files for project and app level.
3.4 Add Firebase Service xml tag element to your AndroidManifest.xml file.
3.5 Add a class for your project that extend FirebaseMessagingService class.
3.6 Add onMessageReceived(@NonNull RemoteMessage remoteMessage) function to receive Push notification updates.
3.7 Add onNewToken(@NonNull String token) function to receive the device token on app run.
