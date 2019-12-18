package ke.co.neverest.kotlinmvvm.utils

import android.content.Context
import ke.co.neverest.kotlinmvvm.data.dao.AuthUserDao
import ke.co.neverest.kotlinmvvm.data.dao.AuthorizationDao
import ke.co.neverest.kotlinmvvm.data.models.AuthUser
import ke.co.neverest.kotlinmvvm.data.models.Authorization
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AuthUser::class,Authorization::class],
    version = 1)
abstract class AppDatabase:RoomDatabase() {


    abstract fun authUserDao(): AuthUserDao
    abstract fun authorizationDao(): AuthorizationDao



    companion object {
        @Volatile private var instance: AppDatabase? = null
//        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(this){
            instance ?: buildDatabase(context).also { instance = it}
        }


        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "kotlin_app_database")
            .build()




    }

}