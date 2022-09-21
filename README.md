# AMIT_DAY_SEVEN_NOTIFICATIONS_BROADCAST_RECEIVER
### Project includes:
## 1. Notification Builder for: BigText, BigPicture, Messages, Emails, and Lines.
## 2. BroadcastReciever for: Airplane mode changes, and Wifi connection changes.

## 3 Firebase Messageing Service

3.1 initialize your project of Firebase and set it enabled on Google Cloud. 

3.2 Download google-services.json file and move it to app level on your project.

3.3 Import dependencies for firebase and google play services in your gradle files for project and app level.

3.4 Add Firebase Service xml tag element to your AndroidManifest.xml file.

3.5 Add a class for your project that extend FirebaseMessagingService class.

3.6 Add onMessageReceived(@NonNull RemoteMessage remoteMessage) function to receive Push notification updates.

3.7 Add onNewToken(@NonNull String token) function to receive the device token on app run.
## Postman Request Body
use the following json object to send your push notification via Firebase from Postman:

   
     {    
       "to":"eR1pfsQ1Rvmz_o3kSYB6oL:APA91bET_IQIvySW91aNpbYT2o490k8MKl5x9BUhiLhI3Zmws_8QMWnVEaAne5bNGw3vZiW2AE0l4av93RKSQ53bbrqNf4iDHzNCf7eecxyvSNV00vMVE_-Cy9xaZ5P5Gjt-mZbtk7-b", 
      
       "notification" : {
       
        "body" : "AMIT - Android Course",
        
        "OrganizationId":"2",
        
        "content_available" : true,
        
        "priority" : "high",
        
        "subtitle":"Day Seven",
        
        "sound":"app_sound.wav",
        
        "title":"Firebase Messaging Service tutorial",
        
        "imageUrl":"https://www.gstatic.com/mobilesdk/160503_mobilesdk/logo/2x/firebase_28dp.png"
        
   },
   
        "data" : {
        
        "priority" : "high",
        
        "sound":"app_sound.wav",
        
        "content_available" : true,
        
        "bodyText" : "New Announcement assigned",
        
        "organization" :"Elementary school"
        
   }
   
}
