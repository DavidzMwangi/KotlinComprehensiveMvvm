package ke.co.neverest.kotlinmvvm.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ke.co.neverest.kotlinmvvm.data.models.Authorization

@Dao
interface AuthorizationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(authorization: Authorization)


    @Query("SELECT * FROM authorization_table LIMIT 1")
    fun getAuthorization(): LiveData<Authorization>

}