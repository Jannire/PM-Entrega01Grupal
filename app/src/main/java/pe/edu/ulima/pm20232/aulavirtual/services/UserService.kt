package pe.edu.ulima.pm20232.aulavirtual.services

import pe.edu.ulima.pm20232.aulavirtual.configs.HttpStdResponse
import pe.edu.ulima.pm20232.aulavirtual.models.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

class UserService {
    var userList: ArrayList<User> = ArrayList<User>()

    fun checkUser(userName: String, password: String): Int{
        var resp: Int = 0
        userList.forEach{user ->
            if(user.user == userName && user.password == password){
                resp = user.id
            }
        }
        return resp
    }
}


interface UserService2 {
    @FormUrlEncoded
    @POST("user/validate")
    fun findOne(
        @Field("user") name: String?,
        @Field("password") age: String?
    ): Call<HttpStdResponse?>?

    @FormUrlEncoded
    @POST("user/reset_password")
    fun resetPass(
        @Field("dni") name: String?,
        @Field("email") age: String?
    ): Call<HttpStdResponse?>?
    @FormUrlEncoded
    @POST("user/create")
    fun createAccount(
        @Field("dni") name: String?,
        @Field("email") email: String?
    ): Call<HttpStdResponse?>?
}