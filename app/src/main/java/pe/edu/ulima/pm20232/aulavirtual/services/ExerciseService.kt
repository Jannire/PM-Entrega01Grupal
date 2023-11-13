package pe.edu.ulima.pm20232.aulavirtual.services


import pe.edu.ulima.pm20232.aulavirtual.configs.BASE_URL
import pe.edu.ulima.pm20232.aulavirtual.models.BodyPart
import pe.edu.ulima.pm20232.aulavirtual.models.Exercise
import pe.edu.ulima.pm20232.aulavirtual.models.responses.ExerciseSetReps
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

class ExerciseService {
    var exerciseList: ArrayList<Exercise> = ArrayList<Exercise>()

    constructor(){
        val baseUrl = BASE_URL
        val description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        exerciseList.add(Exercise(id = 1, name = "ELEVACIONES DE PIERNAS ACOSTADAS", imageUrl = "${baseUrl}ejercicios/abdomen01.png", videoUrl = "https://www.youtube.com/watch?v=u51ytLWD15g", bodyPartId = 1, description = description))
        exerciseList.add(Exercise(id = 2, name = "SILLA ROMANA", imageUrl = "${baseUrl}ejercicios/abdomen02.png", videoUrl = "https://www.youtube.com/watch?v=u51ytLWD15g", bodyPartId = 1, description = description))
        exerciseList.add(Exercise(id = 3, name = "CAMINADORA", imageUrl = "${baseUrl}ejercicios/abdomen03.png", videoUrl = "https://www.youtube.com/watch?v=u51ytLWD15g", bodyPartId = 1, description = description))
        exerciseList.add(Exercise(id = 4, name = "PRESS DECLINADO EN BANCO", imageUrl = "${baseUrl}ejercicios/abdomen04.png", videoUrl = "https://www.youtube.com/watch?v=u51ytLWD15g", bodyPartId = 1, description = description))
        exerciseList.add(Exercise(id = 5, name = "FLEXIONES DE PIERNAS EN BANCO SENTADO", imageUrl = "${baseUrl}ejercicios/abdomen05.png", videoUrl = "https://www.youtube.com/watch?v=u51ytLWD15g", bodyPartId = 1, description = description))
        exerciseList.add(Exercise(id = 6, name = "ABDOMINALES EN MÁQUINA", imageUrl = "${baseUrl}ejercicios/abdomen06.png", videoUrl = "https://www.youtube.com/watch?v=u51ytLWD15g", bodyPartId = 1, description = description))
        exerciseList.add(Exercise(id = 7, name = "ABDOMINALES INVERTIDOS EN BANCO", imageUrl = "${baseUrl}ejercicios/abdomen07.png", videoUrl = "https://www.youtube.com/watch?v=u51ytLWD15g", bodyPartId = 1, description = description))
        exerciseList.add(Exercise(id = 8, name = "SENTADILLA", imageUrl = "${baseUrl}ejercicios/piernas01.png", videoUrl = "https://www.youtube.com/watch?v=KrpKmehR--A", bodyPartId = 2, description = description))
        exerciseList.add(Exercise(id = 9, name = "MÁQUINA HACK", imageUrl = "${baseUrl}ejercicios/piernas02.png", videoUrl = "https://www.youtube.com/watch?v=KrpKmehR--A", bodyPartId = 2, description = description))
        exerciseList.add(Exercise(id = 10, name =  "PRESS DE PIERNA", imageUrl = "${baseUrl}ejercicios/piernas03.png", videoUrl = "https://www.youtube.com/watch?v=KrpKmehR--A", bodyPartId = 2, description = description))
        exerciseList.add(Exercise(id = 11, name =  "SENTADILLA FRONTAL", imageUrl = "${baseUrl}ejercicios/piernas04.png", videoUrl = "https://www.youtube.com/watch?v=KrpKmehR--A", bodyPartId = 2, description = description))
        exerciseList.add(Exercise(id = 12, name =  "EXTENSIÓN DE PIERNAS", imageUrl = "${baseUrl}ejercicios/piernas05.png", videoUrl = "https://www.youtube.com/watch?v=KrpKmehR--A", bodyPartId = 2, description = description))
        exerciseList.add(Exercise(id = 13, name =  "ADUCTORES EN MÁQUINA", imageUrl = "${baseUrl}ejercicios/piernas06.png", videoUrl = "https://www.youtube.com/watch?v=KrpKmehR--A", bodyPartId = 2, description = description))
        exerciseList.add(Exercise(id = 14, name =  "MÁQUINA SMITH", imageUrl = "${baseUrl}ejercicios/piernas07.png", videoUrl = "https://www.youtube.com/watch?v=KrpKmehR--A", bodyPartId = 2, description = description))
        exerciseList.add(Exercise(id = 15, name =  "FLEXIONES DE PIERNAS", imageUrl = "${baseUrl}ejercicios/piernas08.png", videoUrl = "https://www.youtube.com/watch?v=KrpKmehR--A", bodyPartId = 2, description = description))
        exerciseList.add(Exercise(id = 16, name =  "ESTOCADAS LATERALES CON MANCUERNAS", imageUrl = "${baseUrl}ejercicios/piernas09.png", videoUrl = "https://www.youtube.com/watch?v=KrpKmehR--A", bodyPartId = 2, description = description))
        exerciseList.add(Exercise(id = 17, name =  "LUNGES CON MANCUERNAS", imageUrl = "${baseUrl}ejercicios/piernas10.png", videoUrl = "https://www.youtube.com/watch?v=KrpKmehR--A", bodyPartId = 2, description = description))
        exerciseList.add(Exercise(id = 18, name =  "PESO MUERTO", imageUrl = "${baseUrl}ejercicios/piernas11.png", videoUrl = "https://www.youtube.com/watch?v=KrpKmehR--A", bodyPartId = 2, description = description))
        exerciseList.add(Exercise(id = 19, name =  "JALÓN CON POLEA", imageUrl = "${baseUrl}ejercicios/espalda01.png", videoUrl = "https://www.youtube.com/watch?v=D7z3g0Eg9BY", bodyPartId = 5, description = description))
        exerciseList.add(Exercise(id = 20, name =  "PULLOVER DE BANCA SENTADO", imageUrl = "${baseUrl}ejercicios/espalda02.png", videoUrl = "https://www.youtube.com/watch?v=D7z3g0Eg9BY", bodyPartId = 5, description = description))
        exerciseList.add(Exercise(id = 21, name =  "REMO SENTADO", imageUrl = "${baseUrl}ejercicios/espalda03.png", videoUrl = "https://www.youtube.com/watch?v=D7z3g0Eg9BY", bodyPartId = 5, description = description))
        exerciseList.add(Exercise(id = 22, name =  "PESO MUERTO", imageUrl = "${baseUrl}ejercicios/espalda04.png", videoUrl = "https://www.youtube.com/watch?v=D7z3g0Eg9BY", bodyPartId = 5, description = description))
        exerciseList.add(Exercise(id = 23, name =  "DOMINADAS", imageUrl = "${baseUrl}ejercicios/espalda05.png", videoUrl = "https://www.youtube.com/watch?v=D7z3g0Eg9BY", bodyPartId = 5, description = description))
        exerciseList.add(Exercise(id = 24, name =  "HIPEREXTENSIÓN", imageUrl = "${baseUrl}ejercicios/espalda06.png", videoUrl = "https://www.youtube.com/watch?v=D7z3g0Eg9BY", bodyPartId = 5, description = description))
        exerciseList.add(Exercise(id = 25, name =  "COPA SENTADO", imageUrl = "${baseUrl}ejercicios/espalda07.png", videoUrl = "https://www.youtube.com/watch?v=D7z3g0Eg9BY", bodyPartId = 5, description = description))
        exerciseList.add(Exercise(id = 26, name =  "ENCOGIMIENTO DE HOMBROS", imageUrl = "${baseUrl}ejercicios/espalda08.png", videoUrl = "https://www.youtube.com/watch?v=D7z3g0Eg9BY", bodyPartId = 5, description = description))
        exerciseList.add(Exercise(id = 27, name =  "CURL CON BARRA", imageUrl = "${baseUrl}ejercicios/biceps01.png", videoUrl = "https://www.youtube.com/watch?v=ZIm_qrJSOds", bodyPartId = 7, description = description))
        exerciseList.add(Exercise(id = 28, name =  "SCOOT SENTADO", imageUrl = "${baseUrl}ejercicios/biceps02.png", videoUrl = "https://www.youtube.com/watch?v=ZIm_qrJSOds", bodyPartId = 7, description = description))
        exerciseList.add(Exercise(id = 29, name =  "SCOOT POR LADO", imageUrl = "${baseUrl}ejercicios/biceps03.png", videoUrl = "https://www.youtube.com/watch?v=ZIm_qrJSOds", bodyPartId = 7, description = description))
        exerciseList.add(Exercise(id = 30, name =  "CURL ALTERNADO INCLINADO", imageUrl = "${baseUrl}ejercicios/biceps04.png", videoUrl = "https://www.youtube.com/watch?v=ZIm_qrJSOds", bodyPartId = 7, description = description))
        exerciseList.add(Exercise(id = 31, name =  "SCOOT CON MÁQUINA", imageUrl = "${baseUrl}ejercicios/biceps05.png", videoUrl = "https://www.youtube.com/watch?v=ZIm_qrJSOds", bodyPartId = 7, description = description))
        exerciseList.add(Exercise(id = 32, name =  "CURL POLEA CON UN BRAZO", imageUrl = "${baseUrl}ejercicios/biceps06.png", videoUrl = "https://www.youtube.com/watch?v=ZIm_qrJSOds", bodyPartId = 7, description = description))
        exerciseList.add(Exercise(id = 33, name =  "CURL ARTILLO", imageUrl = "${baseUrl}ejercicios/biceps07.png", videoUrl = "https://www.youtube.com/watch?v=ZIm_qrJSOds", bodyPartId = 7, description = description))
        exerciseList.add(Exercise(id = 34, name =  "PANTORRILLA EN MÁQUINA SMITH", imageUrl = "${baseUrl}ejercicios/pantorrilla01.png", videoUrl = "https://www.youtube.com/watch?v=F16IZhxfP3w", bodyPartId = 3, description = description))
        exerciseList.add(Exercise(id = 35, name =  "PANTORRILLA PARADO LIBRE", imageUrl = "${baseUrl}ejercicios/pantorrilla02.png", videoUrl = "https://www.youtube.com/watch?v=F16IZhxfP3w", bodyPartId = 3, description = description))
        exerciseList.add(Exercise(id = 36, name =  "PANTORRILLA PRENSA", imageUrl = "${baseUrl}ejercicios/pantorrilla03.png", videoUrl = "https://www.youtube.com/watch?v=F16IZhxfP3w", bodyPartId = 3, description = description))
        exerciseList.add(Exercise(id = 37, name =  "PANTORRILLA CON MANCUERNAS", imageUrl = "${baseUrl}ejercicios/pantorrilla04.png", videoUrl = "https://www.youtube.com/watch?v=F16IZhxfP3w", bodyPartId = 3, description = description))
        exerciseList.add(Exercise(id = 38, name =  "PANTORRILLA SENTADO", imageUrl = "${baseUrl}ejercicios/pantorrilla05.png", videoUrl = "https://www.youtube.com/watch?v=F16IZhxfP3w", bodyPartId = 3, description = description))
        exerciseList.add(Exercise(id = 39, name =  "PRESS DE BANCA", imageUrl = "${baseUrl}ejercicios/pectoral01.png", videoUrl = "https://www.youtube.com/watch?v=VRMLeECpyYc", bodyPartId = 4, description = description))
        exerciseList.add(Exercise(id = 40, name =  "PRESS DE BANCA DECLINADA", imageUrl = "${baseUrl}ejercicios/pectoral02.png", videoUrl = "https://www.youtube.com/watch?v=VRMLeECpyYc", bodyPartId = 4, description = description))
        exerciseList.add(Exercise(id = 41, name =  "PRESS DE BANCA CON MANCUERNAS INCLINADAS", imageUrl = "${baseUrl}ejercicios/pectoral03.png", videoUrl = "https://www.youtube.com/watch?v=VRMLeECpyYc", bodyPartId = 4, description = description))
        exerciseList.add(Exercise(id = 42, name =  "PRESS DE BANCA CON MANCUERNAS", imageUrl = "${baseUrl}ejercicios/pectoral04.png", videoUrl = "https://www.youtube.com/watch?v=VRMLeECpyYc", bodyPartId = 4, description = description))
        exerciseList.add(Exercise(id = 43, name =  "APERTURAS LATERALES EN BANCO", imageUrl = "${baseUrl}ejercicios/pectoral05.png", videoUrl = "https://www.youtube.com/watch?v=VRMLeECpyYc", bodyPartId = 4, description = description))
        exerciseList.add(Exercise(id = 44, name =  "CRUCE CON CABLES", imageUrl = "${baseUrl}ejercicios/pectoral06.png", videoUrl = "https://www.youtube.com/watch?v=VRMLeECpyYc", bodyPartId = 4, description = description))
        exerciseList.add(Exercise(id = 45, name =  "MÁQUINA PRESS SENTADO", imageUrl = "${baseUrl}ejercicios/pectoral07.png", videoUrl = "https://www.youtube.com/watch?v=VRMLeECpyYc", bodyPartId = 4, description = description))
        exerciseList.add(Exercise(id = 46, name =  "DECK PRESS", imageUrl = "${baseUrl}ejercicios/pectoral08.png", videoUrl = "https://www.youtube.com/watch?v=VRMLeECpyYc", bodyPartId = 4, description = description))
        exerciseList.add(Exercise(id = 47, name =  "PLANCHAS", imageUrl = "${baseUrl}ejercicios/pectoral09.png", videoUrl = "https://www.youtube.com/watch?v=VRMLeECpyYc", bodyPartId = 4, description = description))
        exerciseList.add(Exercise(id = 48, name =  "PRESS FRONTAL", imageUrl = "${baseUrl}ejercicios/hombros01.png", videoUrl = "https://www.youtube.com/watch?v=QcyC8hXLQ40", bodyPartId = 6, description = description))
        exerciseList.add(Exercise(id = 49, name =  "PRESS TRAS LA NUCA CON MÁQUINA", imageUrl = "${baseUrl}ejercicios/hombros02.png", videoUrl = "https://www.youtube.com/watch?v=QcyC8hXLQ40", bodyPartId = 6, description = description))
        exerciseList.add(Exercise(id = 50, name =  "PRESS MILITAR", imageUrl = "${baseUrl}ejercicios/hombros03.png", videoUrl = "https://www.youtube.com/watch?v=QcyC8hXLQ40", bodyPartId = 6, description = description))
        exerciseList.add(Exercise(id = 51, name =  "PRESS MILITAR CON MANCUERNA", imageUrl = "${baseUrl}ejercicios/hombros04.png", videoUrl = "https://www.youtube.com/watch?v=QcyC8hXLQ40", bodyPartId = 6, description = description))
        exerciseList.add(Exercise(id = 52, name =  "FACE PULL", imageUrl = "${baseUrl}ejercicios/hombros05.png", videoUrl = "https://www.youtube.com/watch?v=QcyC8hXLQ40", bodyPartId = 6, description = description))
        exerciseList.add(Exercise(id = 53, name =  "BARRAS EN MÁQUINA", imageUrl = "${baseUrl}ejercicios/hombros06.png", videoUrl = "https://www.youtube.com/watch?v=QcyC8hXLQ40", bodyPartId = 6, description = description))
        exerciseList.add(Exercise(id = 54, name =  "ELVACIÓN LATERAL ALTERNA", imageUrl = "${baseUrl}ejercicios/hombros07.png", videoUrl = "https://www.youtube.com/watch?v=QcyC8hXLQ40", bodyPartId = 6, description = description))
    }

    fun listAll(): List<Exercise> {
        return exerciseList
    }

    fun exerciseListByBodyPartId(bodyPartId: Int): List<Exercise>  {
        var reducedList = ArrayList<Exercise>()
        for (exercise in exerciseList) {
            if(exercise.bodyPartId == bodyPartId){
                reducedList.add(exercise)
            }
        }
        return reducedList
    }
}

interface ExerciseService2 {
    @GET("exercise/list") // Reemplaza con la URL de tu punto final
    fun bodyList(
        @Query("body_part_id") bodyPartId: Int? = null,
    ): Call<List<BodyPart>>
    @GET("exercise/find") // Reemplaza con la URL de tu punto final
    fun exercise(
        @Query("exercise_id") exerciseId: Int? = null,
    ): Call<Exercise>
}