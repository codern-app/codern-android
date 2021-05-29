package com.armanco.codern.di

import android.content.Context
import androidx.room.Room
import com.armanco.codern.data.db.Db
import com.armanco.codern.utils.facade.AuthFacade
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFirestore(): FirebaseFirestore {
        return Firebase.firestore
    }

    @Singleton
    @Provides
    fun provideRemoteConfig(): FirebaseRemoteConfig {
        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        return remoteConfig
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): Db {
        return Room.databaseBuilder(
            appContext,
            Db::class.java,
            "database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCourseDao(db: Db) = db.courseDao()

    @Singleton
    @Provides
    fun provideSectionDao(db: Db) = db.sectionDao()

    @Singleton
    @Provides
    fun provideLessonDao(db: Db) = db.lessonDao()

    @Singleton
    @Provides
    fun provideArticleDao(db: Db) = db.articleDao()

    @Singleton
    @Provides
    fun provideElementDao(db: Db) = db.elementDao()

}