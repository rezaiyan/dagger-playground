/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/16/2020 12:36 AM.
 */
public class Deps {

    static class Versions{
        static final String retrofit = "2.6.0";
        static final String okHttp = "3.12.0";
        static final String dagger = "2.27";
    }
    static final String gson = "com.google.code.gson:gson:2.8.6";
    static final String retrofit = "com.squareup.retrofit2:retrofit:"+Versions.retrofit;
    static final String retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:"+Versions.retrofit;
    static final String retrofitRxConverter = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0";
    static final String okHttp = "com.squareup.okhttp3:okhttp:"+Versions.okHttp;
    static final String okHttpLogging = "com.squareup.okhttp3:logging-interceptor:"+Versions.okHttp;
    static final String dagger = "com.google.dagger:dagger:"+Versions.dagger;
    static final String daggerCompiler = "com.google.dagger:dagger-compiler:"+Versions.dagger;
    static final String appCompat = "androidx.appcompat:appcompat:1.2.0-rc01";

}
