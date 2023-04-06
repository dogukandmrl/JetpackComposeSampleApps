package com.example.notificationexample

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import com.example.notificationexample.ui.theme.NotificationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotificationExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NotificationActivity()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotificationExampleTheme {
        NotificationActivity()
    }
}

@Composable
fun NotificationActivity() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            setNotification(context)
        }) {
            Text(text = "Get notification")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "DO!")
        }
    }
}

fun setNotification(context: Context) {
    val builder: NotificationCompat.Builder
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val canalId = "canalId"
        val canalName = "canalName"
        val canalPriority = NotificationManager.IMPORTANCE_HIGH
        val canalDescription = "canalDescription"

        var canal: NotificationChannel? = notificationManager.getNotificationChannel(canalId)

        if (canal == null) {
            canal = NotificationChannel(canalId, canalName, canalPriority)
            canal.description = canalDescription
            notificationManager.createNotificationChannel(canal)
        }
        builder = NotificationCompat.Builder(context, canalId)

        builder.setContentTitle("Title")
            .setContentText("Content")
            .setSmallIcon(R.drawable.notification_alert)
            .setAutoCancel(true)
    } else {
        builder = NotificationCompat.Builder(context)

        builder.setContentTitle("Title")
            .setContentText("Content")
            .setSmallIcon(R.drawable.notification_alert)
            .setAutoCancel(true)
            .priority = Notification.PRIORITY_HIGH
    }
    notificationManager.notify(1,builder.build())
}

