# Everless SDK Android

Android SDK untuk platform Everless

## Getting Started

SDK ini digunakan untuk membantu penggunaan Everless pada platform Android.

### Prerequisites

Sebelum menggunakan SDK ini, diharapkan telah mengerti teknologi dibawah:

```
Java
REST API
Android SDK
```

### Installing

Berikut tahap untuk menggunakan SDK

Pada root `build.gradle` tambahkan baris berikut

```gradle
repositories {
    maven {
        url  "https://dl.bintray.com/riochr17/everlesdk-alpha" 
    }
}
```

Lalu pada bagian project `build.gradle` tambahkan baris berikut

```gradle
compile 'org.rio.pilottestsdk:everlesssdk:0.0.4'
```

## Everless API General

Sebelum mulai menggunakan fitur SDK, lakukan inisialisasi SDK

### SDK Initialization

```java
private String BASE_URL = "<Everless base URL>";
private String CLIENT_KEY = "<your Client Key>";
private String CLIENT_SECRET = "<your Client Secret>";

constructor(){

    // Init SDK
    AnimalRunner.init(BASE_URL, CLIENT_KEY, CLIENT_SECRET);
}
```

Berikut daftar fitur yang terdapat pada SDK. Setiap _method_ yang terdapat pada SDK menggunakan sistem _asynchronous_ dengan implementasi _callback_. 

## Everless API User Authentication

terdiri dari Login dan Logout

### Login

Login menggunakan _username_ dan _password_

```java
AnimalRunner.AuthUser.login(String username, String password, LoginCallback callback)
```

### Logout

```java
AnimalRunner.AuthUser.logout(LogoutCallback callback)
```

## Everless API Collection

terdiri dari Create, Retrieve, Update, Delete _collection_

### Collection

Kelas `Collection` memiliki empat _method_ yaitu `create()`, `retrieve()`, `update()`, dan `delete()`.

```java
Collection clx = AnimalRunner.Ref.collection(String collectionName);
```

##### Create
```java
clx.create(EVPair body, CollectionCallback callback);                 // create collection variasi 1
clx.create(String uniqueID, EVPair body, CollectionCallback callback) // create collection variasi 2
```

##### Retrieve
```java
clx.retrieve(CollectionCallback callback)                             // retrieve collection
```

##### Update
```java
clx.update(EVPair body, CollectionCallback callback)                  // update collection variasi 1
clx.update(String uniqueID, EVPair body, CollectionCallback callback) // update collection variasi 2
```

##### Delete
```java
clx.delete(CollectionCallback callback)                               // delete collection
```

### Child Collection

Pada kelas `Collection` terdapat child collection yang mengembalikan kelas `Collection`. Fitur ini digunakan untuk mengakses _child path_ dari _collection_ tersebut.

```java
Collection childClx = clx.child(String child);
```

## Everless API Storage

terdiri dari Upload, Get File URL, Delete _storage_

### Storage

Kelas `Storage` memiliki empat _method_ yaitu `upload()`, `directDownloadFile()`, `getFileURL()`, dan `delete()`.

```java
Storage stg = AnimalRunner.Ref.storage();
```

##### Upload
```java
stg.upload(final String fileName, final File file, final StorageCallback callback)
```

##### Direct File Download

Direct alamat url berkas akan mengunduh berkas menggunakan Download Manager yang tersedia pada device versi Gingerbread atau lebih terbaru. Metode ini mengembalikan `Exception` jika Download Manager tidak tersedia pada device yang digunakan.

```java
stg.directDownloadFile(Context context, String fileUrl) throws Exception;
```

##### Get File URL

Method ini mengembalikan url berdasarkan UUID berkas tersebut.

```java
stg.getFileURL(final String uuid, final StorageCallback callback);
```

##### Delete
```java
stg.delete(final String uid, final StorageCallback callback)
```

### Geo

Kelas `Geo` memiliki tiga _method_ yaitu `saveLocation()`, `getLocation()`, dan `getLocationByRadius()`. Pada Geo terdapat dua jenis model data yaitu `Geo` dan `ListGeo`, `ListGeo` merupakan data berisi list dari `Geo`.

```java
Geo geo = AnimalRunner.Ref.geo();
```

##### Save Location
```java
geo.saveLocation(final EVPair body, final GeoCallback callback)
```

##### Get Location Specific
```java
geo.getLocation(final String uuid, final GeoCallback callback)
```

##### Get Location By Radius
```java
geo.getLocationByRadius(final Double radius, final ListGeoCallback callback)
```

## Built With

* [Gradle](http://www.https://gradle.org/) - Adaptable, fast automation for all
* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Rio Chandra Rajagukguk** - *Alpha version* - [Rio's Github](https://github.com/riochr17)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Everless, Bandung Digital Valey, Telkom Indonesia, Gegerkalong, Bandung
