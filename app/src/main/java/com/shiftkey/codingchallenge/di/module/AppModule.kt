package com.shiftkey.codingchallenge.di.module


import android.app.Application
import android.content.Context
import com.shiftkey.codingchallenge.ShiftsApplication
import com.shiftkey.codingchallenge.data.repository.ShiftsRepositoryImpl
import com.shiftkey.codingchallenge.data.rest.AvailableShiftsApi
import com.shiftkey.codingchallenge.domain.repository.ShiftsRepository
import com.shiftkey.codingchallenge.domain.usecase.GetAvailableShiftsRemotely
import com.shiftkey.codingchallenge.domain.usecase.ShiftsUseCases
import com.shiftkey.codingchallenge.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constant.BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): AvailableShiftsApi =
        retrofit.create(AvailableShiftsApi::class.java)

    @Singleton
    @Provides
    fun providesRepository(availableShiftsApi: AvailableShiftsApi): ShiftsRepository =
        ShiftsRepositoryImpl(availableShiftsApi)

    @Singleton
    @Provides
    fun provideShiftsUseCases(remoteRepository: ShiftsRepository
    ): ShiftsUseCases {
        return ShiftsUseCases(
            getAvailableShiftsRemotely = GetAvailableShiftsRemotely(remoteRepository)
        )
    }

    @Singleton
    @Provides
    fun provideApplicationContext() = ShiftsApplication()

}