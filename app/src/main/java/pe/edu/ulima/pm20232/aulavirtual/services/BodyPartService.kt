package pe.edu.ulima.pm20232.aulavirtual.services

import pe.edu.ulima.pm20232.aulavirtual.configs.HttpStdResponse
import pe.edu.ulima.pm20232.aulavirtual.models.BodyPart
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

class BodyPartService {
    var bodyPartList: ArrayList<BodyPart> = ArrayList<BodyPart>()

    constructor(){
        bodyPartList.add(BodyPart(id = 1, name = "ABDOMEN"))
        bodyPartList.add(BodyPart(id = 2, name = "PIERNAS"))
        bodyPartList.add(BodyPart(id = 3, name = "PANTORRILLA"))
        bodyPartList.add(BodyPart(id = 4, name = "PECTORAL"))
        bodyPartList.add(BodyPart(id = 5, name = "ESPALDA"))
        bodyPartList.add(BodyPart(id = 6, name = "HOMBROS"))
        bodyPartList.add(BodyPart(id = 7, name = "BICEPS"))
        bodyPartList.add(BodyPart(id = 8, name = "TRICEPS"))
    }
}
interface BodyPartService2 {
    @GET("body_part/list")
    fun getBodyPartList(): Call<BodyPart>
}