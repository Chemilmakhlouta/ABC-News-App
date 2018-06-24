package chemilmakhlouta.abcnewsproject.application.injection.module

import chemilmakhlouta.abcnewsproject.data.news.NewsService
import chemilmakhlouta.abcnewsproject.domain.news.NewsRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by Chemil Makhlouta on 23/6/18.
 */
@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsRepository(@Named(RetrofitModule.RETROFIT) retrofit: Retrofit): NewsRepository = NewsService(retrofit)
}