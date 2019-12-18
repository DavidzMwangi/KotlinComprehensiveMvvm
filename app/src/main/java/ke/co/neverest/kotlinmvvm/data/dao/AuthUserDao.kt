package ke.co.neverest.kotlinmvvm.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ke.co.neverest.kotlinmvvm.data.models.AuthUser

@Dao
interface AuthUserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(authUser: AuthUser)


    @Query("SELECT * FROM auth_user_table LIMIT 1")
    fun getAuthUser(): LiveData<AuthUser>

}