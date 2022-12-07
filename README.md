# Retrofit-And-RecycleView
實作Retrofit爬取JsonPlaceHolder網頁的圖庫API並使用RecycleView顯示圖片

基本流程:  

1.添加permission INTERNET權限  
`<uses-permission android:name="android.permission.INTERNET" />`  
2.加入下列第三方依賴項目  
```
implementation 'com.squareup.retrofit2:retrofit:2.9.0'      //Retrofit
implementation 'com.squareup.retrofit2:converter-gson:2.6.2'  
implementation 'com.squareup.picasso:picasso:2.8'           //圖片依賴項
```  
3.建立JsonParse模型 `CardItem.java`  
4.建立Retrofit實例處理網路請求 `ApiClient.java`  
5.實作Retrofit Interface介面 `ImageInterface.java`  
Retrofit可實作的HTTP註釋:  
```
@GET  
@POST  
@PUT  
@DELETE  
@PATCH  
@HEAD
```  
6.實作RecycleView Adapter `CardAdapter.java`  
7.在MainActivity實作REST 並完成RecycleView的可視化 `MainActivity.java`
