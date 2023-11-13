package pe.edu.ulima.pm20232.aulavirtual.services

import pe.edu.ulima.pm20232.aulavirtual.models.BodyPart
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BodyPartServiceInterface {
    @GET("/member/body_parts")
    fun BodyParts(
        @Query("member_id") memberId: Int? = null,
    ): Call<List<BodyPart>>

}
