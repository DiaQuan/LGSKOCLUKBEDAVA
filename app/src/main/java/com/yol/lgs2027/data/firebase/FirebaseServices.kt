package com.yol.lgs2027.data.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

/**
 * Web tarafındaki js/firebase-config.js'nin Android karşılığı.
 * Aynı Firebase projesine (lgskocluk-fd44a) bağlanır; web ile aynı
 * kullanıcılar ve aynı Firestore koleksiyonları kullanılır, böylece
 * bir kullanıcının ilerlemesi siteyle uygulama arasında senkron olur.
 */
object FirebaseServices {
    val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    val firestore: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    val storage: FirebaseStorage by lazy { FirebaseStorage.getInstance() }

    // Firestore koleksiyon adları - web tarafıyla (firestore.rules) birebir aynı
    const val COLLECTION_USERS = "users"
    const val COLLECTION_DAILY_LOGS = "dailyLogs"
    const val COLLECTION_NOTES = "notes"
    const val COLLECTION_SCHEDULES = "schedules"
    const val COLLECTION_GOALS = "goals"
    const val COLLECTION_QUESTION_LOGS = "questionLogs"
    const val COLLECTION_EXAMS = "exams"

    // TODO: js/admin.js içindeki ADMIN_EMAIL değerini buraya aynen yapıştır
    const val ADMIN_EMAIL = ""

    // Google Sign-In (Credential Manager) için "server client ID".
    // google-services.json'daki oauth_client (client_type: 3) ile aynı - Auth ekranında kullanılacak.
    const val GOOGLE_WEB_CLIENT_ID = "296762217990-on42uem5taqj27kii3v2gis7ummtsksq.apps.googleusercontent.com"
}
