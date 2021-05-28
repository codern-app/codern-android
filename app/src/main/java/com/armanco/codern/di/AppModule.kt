package com.armanco.codern.di

import android.content.Context
import androidx.room.Room
import com.armanco.codern.data.db.Db
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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