package ke.co.neverest.kotlinmvvm.data.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "auth_user_table")
data class AuthUser(

    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    @ColumnInfo(name = "id")
    @NonNull
    var id: Int,

    @field:SerializedName("name")
    @ColumnInfo(name = "name")
    var name: String,

    @field:SerializedName("email")
    @ColumnInfo(name = "email")
    var email: String,


    @field:SerializedName("email_verified_at")
    @ColumnInfo(name = "email_verified_at")
    var email_verified_at: String? = null,



    @field:SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    var createdAt: String,


    @field:SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    var updatedAt: String,

    @field:SerializedName("user_type")
    @ColumnInfo(name = "user_type")
    var userType: String



    ){

    override fun toString(): String {
        return name
    }
}