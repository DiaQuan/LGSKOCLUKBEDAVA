# Yol — LGS 2027 Android Uygulaması

Web sitesiyle (`lgskocluk-fd44a` Firebase projesi) aynı backend'i paylaşan native Android istemcisi. Kotlin + Jetpack Compose + Material 3. Bu paket **tamamen kendi başına bir proje** — Android Studio ile önce boş proje oluşturmana gerek yok, doğrudan bu klasör GitHub'a gidebilir.

## GitHub'a atmak (Android Studio gerekmez)

```bash
cd yol-android
git init
git add .
git commit -m "İlk commit: proje iskeleti"
git branch -M main
git remote add origin <senin-repo-url'in>
git push -u origin main
```

`.gitignore` zaten `google-services.json`, imza anahtarları ve build klasörlerini hariç tutuyor.

## Firebase bağlantısı

`app/google-services.json` zaten bu pakette — senin gerçek Firebase projenden (`lgskocluk-fd44a`, paket adı `com.yol.lgs2027`), hiçbir şey yapmana gerek yok.

Tek eksik: Firebase Console → Authentication → Sign-in method → **Google**'ı henüz etkinleştirmediysen etkinleştir (google-services.json'da sadece Web OAuth client'ı var, Google girişini kullanmak için bu şart).

## Bunu nasıl derlersin?

Android Studio'n olmadığı için üç seçeneğin var:

**A) GitHub Actions ile (hiçbir şey kurmadan)** — bu repoda `.github/workflows/android-build.yml` zaten var, her push'ta otomatik derleme dener.
- Repo → Settings → Secrets and variables → Actions → **New repository secret**
- İsim: `GOOGLE_SERVICES_JSON`, değer: `google-services.json` dosyanın base64 hali (`base64 -i google-services.json` ile üretirsin, tek satır çıktısını yapıştır)
- Push ettiğinde Actions sekmesinde derleme geçerse (yeşil tik), **Artifacts** altından derlenen APK'yı indirebilirsin.

**B) Android Studio kurarsan** — en rahat yol; klasörü "Open" ile açman yeterli, gerisi kendiliğinden çalışır.

**C) Sadece komut satırı (JDK yeterli, SDK da gerekiyor)** — `sdkmanager` ile command-line tools kurup `./gradlew assembleDebug` çalıştırabilirsin; bunun için ayrı bir Android SDK kurulumu gerekiyor, Android Studio'dan daha zahmetli.

En hızlısı **A** — hiçbir şey kurmadan, sırf push ederek uygulamanın derlenip derlenmediğini görürsün.

## Bilmen gerekenler

- **`FirebaseServices.kt`** içindeki `ADMIN_EMAIL` alanını web'deki `js/admin.js`'teki değerle doldur.
- **Fontlar şimdilik sistem fontu.** Space Grotesk / Inter eklemek istersen bir sonraki turda birlikte ekleriz.
- **Renkler ve köşe yuvarlaklıkları siteyle birebir aynı** (`ui/theme/Color.kt`, `Shape.kt`).
- Gradle wrapper (`gradlew`, `gradle-wrapper.jar`) gerçek ve çalışır durumda — Google'ın kendi açık kaynak Android referans projesinden alındı, uydurma değil.

## Sırada ne var?

Şu an sadece iskelet var: gezinme, tema, Firebase bağlantısı çalışıyor ama hiçbir ekranda gerçek işlev yok. GitHub'a attıktan (ve mümkünse Actions'ın yeşil tik verdiğini gördükten) sonra devam yazarsan, sırada **gerçek Auth ekranı** var (e-posta/şifre + Google girişi).
