package chemilmakhlouta.abcnewsproject.application.injection.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Chemil Makhlouta on 25/6/18.
 */
@Module
class RetrofitModule {
    companion object {
        const val RETROFIT = "RETROFIT"
    }

    @Provides
    @Singleton
    @Named(RETROFIT)
    fun provideRetrofit(httpClient: OkHttpClient,
                         retrofitBuilder: Retrofit.Builder): Retrofit =
            retrofitBuilder.client(httpClient)
                    .baseUrl("https://google.com/")
                    .build()
}