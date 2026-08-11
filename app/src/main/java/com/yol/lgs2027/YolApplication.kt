package com.yol.lgs2027

import android.app.Application
import com.google.firebase.FirebaseApp

class YolApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}
