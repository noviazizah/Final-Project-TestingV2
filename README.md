# Final Project SwagLabs & Api User Controller Automation Testing 
Repositori ini menyimpan source code pengujian automation untuk SwagLabs dan Api User Controller

## Anggota Kelompok
- Helsa Alika Femiani - 211524044
- Novia Nur Azizah - 211524053
- Regi Purnama - 211524057

## Software Under Test (SUT)
1. Aplikasi Swag Labs
SUT untuk sistem ini adalah aplikasi Swag Labs pada https://saucedemo.com, sebuah aplikasi web yang menyediakan platform simulasi e-commerce. Pengujian pada aplikasi ini didasarkan pada test case yang ditentukan melalui Figma dan dokumen spesifikasi. Pengujian otomatis akan dilakukan pada aplikasi yang tersedia di https://saucedemo.com. Pengujian bertujuan untuk memastikan bahwa semua fitur utama, seperti login, katalog produk, keranjang belanja, dan proses checkout, berfungsi dengan benar. 
2. API User Controller
SUT (Software Under Test) untuk sistem ini adalah API User Controller  pada website https://dummyapi.io  yang merupakan API publik yang menyediakan data pengguna untuk pengujian dan pengembangan. Sistem ini akan diuji untuk memastikan bahwa semua endpoint API (seperti GET, POST, PUT, DELETE) berfungsi sesuai dengan spesifikasi yang telah ditetapkan. Pengujian akan mencakup verifikasi fungsionalitas setiap endpoint. Method yang dapat diuji diantaranya:

1. GET /user/{id}

    Mengambil data user berdasarkan ID

2. POST /user/create

    Membuat user baru dan mengembalikan data user yang telah dibuat
    Body request (field yang dibutuhkan):

```json

    {
      "firstName": "string",
      "lastName": "string",
      "email": "string"
    }
```
3. PUT /user/{id}
    Memperbarui data user berdasarkan ID dan mengembalikan data user yang telah diperbarui
    Body request: field data user yang akan diubah, kecuali ID dan email

4.   DELETE /user/{id}
    Menghapus data user berdasarkan ID dan mengembalikan ID user yang telah dihapus


## Instalasi Project

Langkah-langkah untuk menginstal proyek ini pada lingkungan lokal:

1. Clone repository ini
```
git clone https://github.com/noviazizah/Final-Project-TestingV2.git
```
2. Masuk ke direktori proyek:
```
cd Final-Project-Testing
```
3. Jalankan pengujian dengan Maven:

```sh
mvn test
```

## Tools yang Digunakan

Tools yang digunakan untuk menyelesaikan projek ini diantaranya adalah sebagai berikut:

* Visual Studio Code IDE
* Java Development Kit (JDK) 8 atau lebih tinggi
* JUnit Jupiter 5.8.0
* Selenium Java 3.141.59
* Cucumber Java 6.11.0
* Cucumber PicoContainer 7.0.0
* Cucumber JUnit 6.11.0
* JUnit Vintage Engine 5.8.0 
* Rest Assured 5.2.0
* Google Chrome Browser dan Chrome Driver 125.0.1
* Git dan Github
* CLI (cmd atau Powershell)

### Struktur Projek
Adapun struktur projek yang diterapkan adalah sebagai berikut:
```
  root
    ├───.idea
    ├───src
    │   ├───main/java/swaglabs
    │   │             └──App.java      
    │   └───test
    │       ├───java
    │       │       ├───apiusercontroller
    │       │       │    └───stepdefs
    │       │       │         ├───CreateUserSteps.java
    │       │       │         ├───DeleteUserSteps.java
    │       │       │         ├───GetUserSteps.java
    │       │       │         └───UpdateUserSteps.java
    │       │       │  
    │       │       └───swaglab
    │       │       |   ├───cucumber
    │       │       |   |    └───stepdefs
    │       │       |   |         ├───AddToCartSteps.java
    │       │       |   |         ├───CheckoutSteps.java
    │       │       |   |         ├───FilterProductSTeps.java
    │       │       |   |         ├───FooterSteps.java
    │       │       |   |         ├───HamburgerMenuSteps.java
    │       │       |   |         ├───LoginSteps.java
    │       │       |   |         ├───RemoveFromCartSteps.java
    │       │       |   |         ├───StepDefManager.java
    │       │       |   |         ├───ViewCartSteps.java
    │       │       |   |         └───ViewProductSteps.java
    │       │       |   └───pom
    │       │       |       ├───model
    │       │       |       ├───pages
    │       │       |       ├───util
    │       │       |       └───ProductsPageTest.java
    │       │       └───RunTest.java   
    │       │           
    │       └───resources
    │           ├───features
    │           │    ├───apiusercontroller
    │           │    │   
    │           │    └───swaglabs
    │           │        
    │           ├───chromedriver.exe
    │           └───geckodriver.exe
    ├───target
    │   ├───classes
    │   ├───maven-status
    │   ├───surefire-reports
    │   ├───test-classes
    │   ├───jsonReport.json
    │   └───testReport.html
    │       
    ├───pom.xml
    └───README.md

```

Proyek ini terdiri dari dua jenis pengujian otomatis:

1. Pengujian API (apiusercontroller):
   - `src/test/java/apiusercontroller/stepdefs`: Berisi file-file step definition untuk pengujian API, menerjemahkan langkah-langkah Gherkin menjadi kode Java. Ada empat file untuk operasi CRUD pada user:
     - `CreateUserSteps.java`
     - `DeleteUserSteps.java`
     - `GetUserSteps.java`
     - `UpdateUserSteps.java`
   - `src/test/resources/features/apiusercontroller`: Berisi file-file `.feature` dalam bahasa Gherkin, menjelaskan skenario pengujian dalam format "Given-When-Then".

2. Pengujian Web (swaglabs):
   - `src/test/java/swaglab/cucumber/stepdefs`: Berisi file-file step definition untuk pengujian web Swag Labs:
     - `AddToCartSteps.java`: Menambahkan produk ke keranjang
     - `CheckoutSteps.java`: Proses checkout
     - `FilterProductSteps.java`: Menyaring produk
     - `FooterSteps.java`: Pengujian footer
     - `HamburgerMenuSteps.java`: Menu hamburger
     - `LoginSteps.java`: Proses login
     - `RemoveFromCartSteps.java`: Menghapus dari keranjang
     - `ViewCartSteps.java`: Melihat keranjang
     - `ViewProductSteps.java`: Melihat detail produk
     - `StepDefManager.java`: Mengelola step definition
   - `src/test/java/swaglab/pom`: Menggunakan Page Object Model (POM) untuk memisahkan logika halaman dan pengujian.
   - `src/test/resources/features/swaglabs`: Berisi file-file `.feature` sesuai dengan step definition.

3. Target Folder:
   - `target`: Tempat Maven menyimpan hasil kompilasi, laporan, dan artefak.
   - `target/classes` dan `target/test-classes`: File `.class` hasil kompilasi.
   - `target/maven-status`: Status build Maven.
   - `target/surefire-reports`: Laporan JUnit XML.
   - `target/jsonReport.json`: Laporan Cucumber dalam format JSON.
   - `target/testReport.html`: File HTML interaktif dari laporan Cucumber, menampilkan:
     - Ringkasan pengujian (lulus, gagal, dilewati)
     - Daftar skenario dengan status
     - Detail setiap langkah
     - Screenshot untuk kegagalan web (jika dikonfigurasi)
     - Waktu eksekusi dan info lainnya


# SwagLabs Test Design

## 0.0 Login

| Test Case ID | Case Type | Test Case Name | Precondition | Steps to Execute | Test Data | Expected Result |
|-------------|----------|--------------|-------------|--------------|----------|--------------|
| 0.0.1 | Positif | Check successful login by entering a valid username and password | - User has opened the browser<br>- User has navigated on the login page | 1. User enters username & password<br>2. User clicks on login button | Username: standard_user<br>Password: secret_sauce | - System navigates the user to the dashboard page<br>- Dashboard page is displayed on the screen. |
| 0.0.2 | Negative | Check login was not successful by entering invalid username and password | - User has opened the browser<br>- User has navigated on the login page | 1. User enters username & password<br>2. User clicks on login button | Username: invalid_user<br>Password: invalid_password | Display error message "Username and password do not match any user in this service !" |
| 0.0.3 | Negative | Check login was not successful by entering a valid username and invalid password | - User has opened the browser<br>- User has navigated on the login page | 1. User enters username & password<br>2. User clicks on login button | Username: standard_user<br>Password: invalid_password | Display error message "Username and password do not match any user in this service !" |
| 0.0.4 | Negative | Check login was not successful by entering invalid username and valid password | - User has opened the browser<br>- User has navigated on the login page | 1. User enters username & password<br>2. User clicks on login button | Username: invalid_user<br>Password: secret_sauce | Display error message "Username and password do not match any user in this service !" |
| 0.0.5 | Negative | Check login is not successful by entering only username | - User has opened the browser<br>- User has navigated on the login page | 1. User enters username<br>2. User clicks on login button | Username: standard_user<br>Password: {empty} | Display error message "You need Password !" |
| 0.0.6 | Negative | Check login is not successful by entering only password | - User has opened the browser<br>- User has navigated on the login page | 1. User enters password<br>2. User clicks on login button | Username: {empty}<br>Password: secret_sauce | Display error message "You need Username !" |
| 0.0.7 | Negative | Check login was not successful by not entering username and password | - User has opened the browser<br>- User has navigated on the login page | 1. User clicks on login button | Username: {empty}<br>Password: {empty} | Display error message "You need Username & Password !" |

## 1.0 Logout

| Test Case ID | Case Type | Test Case Name | Precondition | Steps to Execute | Test Data | Expected Result |
|-------------|----------|--------------|-------------|--------------|----------|--------------|
| 1.0.1 | Positif | Check successful logout | - User has opened the browser<br>- User has logged in to the application | 1. User click on the menu button<br>2. User click on the logout button | - | - System navigates the user to the login page<br>- Login page is displayed on the screen. |

## 2.0 Dashboard

| Test Case ID | Case Type | Test Case Name | Precondition | Steps to Execute | Test Data | Expected Result |
|-------------|----------|--------------|-------------|--------------|----------|--------------|
| 2.0.1 | Positif | Filtering products by clicking the dropdown filter button | - User has opened the browser<br>- User has logged in to the application<br>- User is on the dashboard page | User clicks the dropdown filter button for products | - | The dropdown filter options are displayed |
| 2.0.2 | Positif | Filtering products by name from A to Z by selecting the "Name (A to Z)" filter | - User has opened the browser<br>- User has logged in to the application<br>- User is on the dashboard page | 1. User clicks the dropdown filter button for products<br>2. User selects the "Name (A to Z)" filter for products | - | -The filter option should display "NAME (A TO Z)"<br>-The products should be displayed alphabetically, in ascending order |
| 2.0.3 | Positif | Filtering products by name from Z to A by selecting the "Name (Z to A)" filter | - User has opened the browser<br>- User has logged in to the application<br>- User is on the dashboard page | 1. User clicks the dropdown filter button for products<br>2. User selects the "Name (Z to A)" filter for products | - | - The filter option should display "NAME (Z TO A)"<br>-The products should be displayed alphabetically, in descending order |
| 2.0.4 | Positif | Filtering products by price from highest to lowest by selecting the "Price (High to Low)" filter | - User has opened the browser<br>- User has logged in to the application<br>- User is on the dashboard page | 1. User clicks the dropdown filter button for products<br>2. User selects the "Price (High to Low)" filter for products | - | - The filter option should display "PRICE (HIGH TO LOW)"<br>-The products should be displayed by price, in descending order |
| 2.0.5 | Positif | Filtering products by price from lowest to highest by selecting the "Price (Low to High)" filter | - User has opened the browser<br>- User has logged in to the application<br>- User is on the dashboard page | 1. User clicks the dropdown filter button for products<br>2. User selects the "Price (Low to High)" filter for products | - | - The filter option should display "PRICE (LOW TO HIGH)"<br>-The products should be displayed by price, in ascending order |

## 3.0 Cart

| Test Case ID | Case Type | Test Case Name | Precondition | Steps to Execute | Test Data | Expected Result |
|-------------|----------|--------------|-------------|--------------|----------|--------------|
| 3.0.1 | Positif | Adding a product to the cart by clicking the "Add to Cart" button on a specific product | - User has opened the browser<br>- User has logged in to the application<br>- User is on the dashboard page | User clicks the "Add to Cart" button | - | - The product is added to the cart<br>-The cart icon updates to reflect the new item count<br>-A confirmation message is displayed indicating the product has been added to the cart |
| 3.0.2 | Positif | Removing a product from the cart by clicking the "Remove" button on the product | - User has opened the browser<br>- User has logged in to the application<br>- User is on the dashboard page | User clicks the "Remove" button for a product | - | -The product is removed from the cart<br>-The cart icon updates to reflect the new item count<br>-A confirmation message is displayed indicating the product has been removed from the cart |
| 3.0.3 | Positif | Verify cart page displays products | - User has opened the browser<br>- User has logged in to the application<br>- User is on the dashboard page | User click on the cart icon | - | -The cart page is displayed<br>-The cart page contains the products |

## 4.0 Checkout

| Test Case ID | Case Type | Test Case Name | Precondition | Steps to Execute | Test Data | Expected Result |
|-------------|----------|--------------|-------------|--------------|----------|--------------|
| 4.0.1 | Positif | Verify navigation from Cart Page to Checkout Information Page when Cart contains more than one product | - Application is open<br>- User has added several products to the cart<br>- Application is on the cart page | User click the Checkout button | - | Application navigates to the Checkout Information page |
| 4.0.2 | Positif | Verify navigation from Checkout Information Page to Shipping Information Page | - Application is on the cart page<br>- User has clicked the Checkout button<br>- Checkout Information page is displayed | - Fill in all Checkout Information fields<br>- User click the Continue button | - | - Application navigates to the Shipping Information page<br>- Application displays an overview of the products to be purchased |
| 4.0.3 | Negatif | Filling Last Name and Zip/Postal Code on Checkout Information, Leaving First Name Field Empty | - Application is open<br>- Checkout Information page is displayed | - Fill in the Last Name and Zip/Postal Code fields<br>- User click the Continue button | - | - Application displays an error message indicating that the First Name field is required<br>- Application does not navigate to the Shipping Information page |

## 5.0 Detail Produk

| Test Case ID | Case Type | Test Case Name | Precondition | Steps to Execute | Test Data | Expected Result |
|-------------|----------|--------------|-------------|--------------|----------|--------------|
| 5.0.1 | - | Displaying product details by clicking on the product image | - User has opened the browser<br>- User has logged in to the application<br>- User is on the dashboard page | User clicks on the image of a product | - | User navigates to the product detail page |
| 5.0.2 | - | Displaying product details by clicking on the product name | - User has opened the browser<br>- User has logged in to the application<br>- User is on the dashboard page | User clicks on the name of a product | - | User navigates to the product detail page |
| 5.0.3 | - | View Product Listings on the Products Page | User is on the Products page | - | - | User sees a list of products on the Products page |

## 6.0 Menu

| Test Case ID | Case Type | Test Case Name | Precondition | Steps to Execute | Test Data | Expected Result |
|-------------|----------|--------------|-------------|--------------|----------|--------------|
| 6.0.1 | - | Test navigation to the dashboard page when the user selects the "All Items" menu from the sidebar | 1. The application is open<br>2. The dashboard page is displayed<br>3. The user has clicked the sidebar menu icon | The user clicks the "All Items" menu | - | The application interface navigates to the dashboard page |
| 6.0.2 | - | Test navigation to the Swag Labs website when the user selects the "About" menu from the sidebar | 1. The application is open<br>2. The dashboard page is displayed<br>3. The user has clicked the sidebar menu icon | The user clicks the "About" menu | - | The application interface navigates to the Swag Labs website |
| 6.0.3 | - | Test navigation to the login page when the user selects the "Logout" menu from the sidebar | 1. The application is open<br>2. The dashboard page is displayed<br>3. The user has clicked the sidebar menu icon | The user clicks the "About" menu | - | The application interface navigates to the login page |
| 6.0.4 | - | Test navigation to the login page when the user selects the "Logout" menu from the sidebar | 1. The application is open<br>2. The dashboard page is displayed<br>3. The user has clicked the sidebar menu icon | The user Menu "Reset App" | - | The application interface navigates to the dashboard page and the cart is emptied |


# API User Controller Test Design

API User Controller adalah bagian dari website https://dummyapi.io yang menyediakan data pengguna untuk pengujian dan pengembangan. Pengujian ini memastikan bahwa semua endpoint API (GET, POST, PUT, DELETE) berfungsi sesuai spesifikasi.

## 1.0 Create User

| Test Case ID | Case Type | Test Case Name | Precondition | Steps to Execute | Test Data | Expected Result |
|-------------|----------|--------------|-------------|--------------|----------|--------------|
| 1.0.1 | Positif | Input data valid dengan field title "mr" | 1. App-id valid dari DUMMYAPI<br>2. POSTMAN terbuka<br>3. Header berisi app-id | 1. Pilih POST<br>2. Masukkan URL create user<br>3. Masukkan data user JSON<br>4. Klik send | App-id: 665c257a4ff6ee05ceaa8edf<br>JSON: `{"title":"mr","firstName":"Alex","lastName":"Gonzales",...}` | 1. JSON data user ditambahkan<br>2. Status 200 OK<br>3. Data user bertambah |
| 1.0.2 | Positif | Input data valid, firstName length 2-50 | 1. App-id valid dari DUMMYAPI<br>2. POSTMAN terbuka<br>3. Header berisi app-id | 1. Pilih POST<br>2. Masukkan URL create user<br>3. Masukkan data user JSON<br>4. Klik send | App-id: 662718606cae037669dee7b6<br>JSON: `{"title":"mr","firstName":"Johnathan","lastName":"Doe",...}` | 1. JSON data user ditambahkan<br>2. Status 200 OK<br>3. Data user bertambah |
| 1.0.3 | Negatif | Input data tanpa field email | 1. App-id valid dari DUMMYAPI<br>2. POSTMAN terbuka<br>3. Header berisi app-id | 1. Pilih POST<br>2. Masukkan URL create user<br>3. Masukkan data user JSON<br>4. Klik send | App-id: 662718606cae037669dee7b6<br>JSON: `{"title":"mrs","firstName":"Felicya","lastName":"Vernede","email":"",...}` | 1. BODY NOT VALID<br>2. Status 400 Bad Request<br>3. Data user tidak bertambah |
| 1.0.4 | Negatif | Input firstName > 50 karakter | 1. App-id valid dari DUMMYAPI<br>2. POSTMAN terbuka<br>3. Header berisi app-id | 1. Pilih POST<br>2. Masukkan URL create user<br>3. Masukkan data user JSON<br>4. Klik send | App-id: 662718606cae037669dee7b6<br>JSON: `{"firstName":"MichaelMichael...","lastName":"Brown",...}` | 1. BODY NOT VALID<br>2. Status 400 Bad Request<br>3. Data user tidak bertambah |
| 1.0.5 | Negatif | Input data dengan app-id invalid | 1. POSTMAN terbuka | 1. Pilih POST<br>2. Masukkan URL create user<br>3. Klik send | App-id: 12345678790abc1234567<br>JSON: `{"firstName":"Grace","lastName":"Madison",...}` | 1. APP ID NOT EXIST<br>2. Status 403 Forbidden<br>3. Data user tidak bertambah |

## 2.0 Get User

| Test Case ID | Case Type | Test Case Name | Precondition | Steps to Execute | Test Data | Expected Result |
|-------------|----------|--------------|-------------|--------------|----------|--------------|
| 2.0.1 | Positif | Get user by id dengan id valid & terdaftar | 1. POSTMAN terbuka<br>2. Method GET | 1. Masukkan endpoint<br>2. Masukkan app-id<br>3. Masukkan id user<br>4. Klik Send | id: 60d0fe4f5311236168a109cb<br>app-id: 662e0effbb70a725c32592e9 | 1. Status 200 OK<br>2. JSON Data User ditampilkan<br>3. Database tidak berubah |
| 2.0.2 | Negatif | Get user by id dengan id valid tapi tidak terdaftar | 1. POSTMAN terbuka<br>2. Method GET | 1. Masukkan endpoint<br>2. Masukkan app-id<br>3. Masukkan id user<br>4. Klik Send | id: 60d0fe4f5311236168a202ca<br>app-id: 662e0effbb70a725c32592e9 | 1. Status 404 Not Found<br>2. Error: "RESOURCE_NOT_FOUND"<br>3. Database tidak berubah |
| 2.0.3 | Negatif | Get user by id dengan id tidak valid | 1. POSTMAN terbuka<br>2. Method GET | 1. Masukkan endpoint<br>2. Masukkan app-id<br>3. Masukkan id user<br>4. Klik Send | id: 60d0fe4f5<br>app-id: 662e0effbb70a725c32592e9 | 1. Status 400 Bad Request<br>2. Error: "PARAMS_NOT_VALID"<br>3. Database tidak berubah |
| 2.0.4 | Negatif | Get user by id tanpa app-id | 1. POSTMAN terbuka<br>2. Method GET | 1. Masukkan endpoint<br>2. Masukkan id user<br>3. Klik Send | id: 60d0fe4f5311236168a109cb | 1. Status 403 Forbidden<br>2. Error: "APP_ID_MISSING"<br>3. Database tidak berubah |
| 2.0.5 | Negatif | Get user by id dengan app-id tidak valid | 1. POSTMAN terbuka<br>2. Method GET | 1. Masukkan endpoint<br>2. Masukkan app-id<br>3. Masukkan id user<br>4. Klik Send | id: 60d0fe4f5311236168a109cb<br>app-id: 662e0effbb70a725c3259220 | 1. Status 403 Forbidden<br>2. Error: "APP_ID_NOT_EXIST"<br>3. Database tidak berubah |

## 3.0 Update User

| Test Case ID | Case Type | Test Case Name | Precondition | Steps to Execute | Test Data | Expected Result |
|-------------|----------|--------------|-------------|--------------|----------|--------------|
| 3.0.1 | Positif | Update field 'title' | 1. App-id di header<br>2. Method PUT<br>3. ID valid tersedia | 1. Request PUT ke endpoint<br>2. Masukkan data JSON<br>3. Klik SEND | app-id: 66271b536cae0377a3dee7c6<br>id: 60d0fe4f5311236168a109ca<br>JSON: `{"title":"miss"}` | 1. Status 200 OK<br>2. JSON: `{"id":"60d0fe4f5311236168a109ca","title":"miss",...}`<br>3. Field title berubah |
| 3.0.2 | Positif | Update field 'firstName' | 1. App-id di header<br>2. Method PUT<br>3. ID valid tersedia | 1. Request PUT ke endpoint<br>2. Masukkan data JSON<br>3. Klik SEND | app-id: 66271b536cae0377a3dee7c6<br>id: 60d0fe4f5311236168a109ca<br>JSON: `{"firstName":"Suzy"}` | 1. Status 200 OK<br>2. JSON: `{"firstName":"Suzy",...}`<br>3. Field firstName berubah |
| 3.0.3 | Positif | Update field 'lastName' | 1. App-id di header<br>2. Method PUT<br>3. ID valid tersedia | 1. Request PUT ke endpoint<br>2. Masukkan data JSON<br>3. Klik SEND | app-id: 66271b536cae0377a3dee7c6<br>id: 60d0fe4f5311236168a109ca<br>JSON: `{"lastName":"Bae"}` | 1. Status 200 OK<br>2. JSON: `{"lastName":"Bae",...}`<br>3. Field lastName berubah |
| 3.0.4 | Positif | Update field 'gender' | 1. App-id di header<br>2. Method PUT<br>3. ID valid tersedia | 1. Request PUT ke endpoint<br>2. Masukkan data JSON<br>3. Klik SEND | app-id: 66271b536cae0377a3dee7c6<br>id: 60d0fe4f5311236168a109ca<br>JSON: `{"gender":"other"}` | 1. Status 200 OK<br>2. JSON: `{"gender":"other",...}`<br>3. Field gender berubah |
| 3.0.5 | Positif | Update field 'dateOfBirth' | 1. App-id di header<br>2. Method PUT<br>3. ID valid tersedia | 1. Request PUT ke endpoint<br>2. Masukkan data JSON<br>3. Klik SEND | app-id: 66271b536cae0377a3dee7c6<br>id: 60d0fe4f5311236168a109ca<br>JSON: `{"dateOfBirth":"13/05/2003"}` | 1. Status 200 OK<br>2. JSON: `{"dateOfBirth":"13/05/2003",...}`<br>3. Field dateOfBirth berubah |

## 4.0 Delete User

| Test Case ID | Case Type | Test Case Name | Precondition | Steps to Execute | Test Data | Expected Result |
|-------------|----------|--------------|-------------|--------------|----------|--------------|
| 4.0.1 | Positif | Delete user dengan id valid & terdaftar | 1. POSTMAN terbuka<br>2. Method DELETE | 1. Masukkan endpoint<br>2. Masukkan app-id<br>3. Masukkan id user<br>4. Klik Send | id: 60d0fe4f5311236168a109cc<br>app-id: 662e0effbb70a725c32592e9 | 1. Status 200 OK<br>2. ID User yang dihapus ditampilkan<br>3. Data user terhapus dari database |
| 4.0.2 | Negatif | Delete user dengan id valid tapi tidak terdaftar | 1. POSTMAN terbuka<br>2. Method DELETE | 1. Masukkan endpoint<br>2. Masukkan app-id<br>3. Masukkan id user<br>4. Klik Send | id: 60d0fe4f5311236168a109d4<br>app-id: 662e0effbb70a725c32592e9 | 1. Status 404 Not Found<br>2. Error: "RESOURCE_NOT_FOUND"<br>3. Database tidak berubah |
| 4.0.3 | Negatif | Delete user dengan id tidak valid | 1. POSTMAN terbuka<br>2. Method DELETE | 1. Masukkan endpoint<br>2. Masukkan app-id<br>3. Masukkan id user<br>4. Klik Send | id: 60d0fe4f5<br>app-id: 662e0effbb70a725c32592e9 | 1. Status 400 Bad Request<br>2. Error: "PARAMS_NOT_VALID"<br>3. Database tidak berubah |
| 4.0.4 | Negatif | Delete user tanpa app-id | 1. POSTMAN terbuka<br>2. Method DELETE | 1. Masukkan endpoint<br>2. Masukkan id user<br>3. Klik Send | id: 60d0fe4f5311236168a109d4 | 1. Status 403 Forbidden<br>2. Error: "APP_ID_MISSING"<br>3. Database tidak berubah |
| 4.0.5 | Negatif | Delete user dengan app-id tidak valid | 1. POSTMAN terbuka<br>2. Method DELETE | 1. Masukkan endpoint<br>2. Masukkan app-id<br>3. Masukkan id user<br>4. Klik Send | id: 60d0fe4f5311236168a109d4<br>app-id: 662e0effbb70a725c3259220 | 1. Status 403 Forbidden<br>2. Error: "APP_ID_NOT_EXIST"<br>3. Database tidak berubah |