package ke.co.neverest.kotlinmvvm.data.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "authorization_table")
data class Authorization(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    var id: Int? =0,

    @field:SerializedName("token_type")
    @ColumnInfo(name = "token_type")
    var token_type: String? = null,

    @ColumnInfo(name = "expires_in")
    @field:SerializedName("expires_in")
    var expires_in: String? = null,

    @ColumnInfo(name = "access_token")
    @field:SerializedName("access_token")
    var access_token: String? = null,

    @ColumnInfo(name = "refresh_token")
    @field:SerializedName("refresh_token")
    var refresh_token: String? = null

){


}