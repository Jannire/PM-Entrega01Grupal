package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.ulima.pm20232.aulavirtual.configs.BackendClient
import pe.edu.ulima.pm20232.aulavirtual.configs.HttpStdResponse
import pe.edu.ulima.pm20232.aulavirtual.models.BodyPart
import pe.edu.ulima.pm20232.aulavirtual.models.Exercise
import pe.edu.ulima.pm20232.aulavirtual.models.ExerciseMember
import pe.edu.ulima.pm20232.aulavirtual.models.responses.BodyPartExercisesCount
import pe.edu.ulima.pm20232.aulavirtual.services.BodyPartService
import pe.edu.ulima.pm20232.aulavirtual.services.ExerciseService
import pe.edu.ulima.pm20232.aulavirtual.services.ExerciseMemberService
import pe.edu.ulima.pm20232.aulavirtual.services.MemberService
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

import kotlin.math.log

class HomeScreenViewModel: ViewModel(){
    val bodyPartsMap = mutableMapOf<Int, String>()
    private val coroutine: CoroutineScope = viewModelScope
    private val memberService = BackendClient.buildService(MemberService::class.java)

    var userId: Int by mutableStateOf(0)
    var memberId: Int by mutableStateOf(0)
    var bodyPartsCount: Int by mutableStateOf(0)
    var exercisesCount: Int by mutableStateOf(0)
    val bodyPartMap = mutableMapOf<Int, String>()
    val bodyPartFlow = MutableStateFlow(bodyPartMap.toMap())

    private var _exercises = MutableStateFlow<List<Exercise>>(emptyList())

    fun getBodyParts(){
        val bodyPartService: BodyPartService = BodyPartService()
        var bodyPartList: ArrayList<BodyPart> = bodyPartService.bodyPartList
        for(p: BodyPart in bodyPartList){
            val id = p.id
            val name = p.name
            if(!bodyPartsMap.containsKey(id)){
                bodyPartsMap[id] = name
            }
        }
    }

    val exercises: StateFlow<List<Exercise>> get() = _exercises
    fun setExercises(newItems: List<Exercise>) {
        _exercises.value = newItems
    }

    fun listAllExercises(){
        val service: ExerciseService = ExerciseService()
        val list = service.listAll()
        setExercises(list)
    }

    fun listAssignedExercises(userId: Int) {
        val exerciseMembers = ExerciseMemberService().exerciseMemberList
        val assignedExercises = exerciseMembers.filter { it.memberId == userId }.map { it.exerciseId }

        val service = ExerciseService()
        val exercises = service.listAll()

        val filteredExercises = exercises.filter { assignedExercises.contains(it.id) }
        setExercises(filteredExercises)
    }

    fun filterByBodyParts(userId: Int, bodyPartId: Int) {
        val exerciseMembers = ExerciseMemberService().exerciseMemberList
        val service: ExerciseService = ExerciseService()

        val assignedExercises = exerciseMembers
            .filter { it.memberId == userId }
            .map { it.exerciseId }

        val filteredExercises = service
            .listAll()
            .filter { assignedExercises.contains(it.id) && it.bodyPartId == bodyPartId }

        setExercises(filteredExercises)
    }

    fun fetchBodyPartsExercises(): Pair<Int, Int>{
        coroutine.launch {
            try {
                withContext(Dispatchers.IO) {
                    val response = memberService.exercisesBodyParts(memberId).execute()
                    println("RESPONSE HM: " + response)
                    if (response.isSuccessful) {
                        val response: BodyPartExercisesCount = response.body()!!
                        println("RESPONSE SUCCESS: " + response)
                        bodyPartsCount = response.bodyParts
                        exercisesCount = response.exercises

                    } else {
                        // Maneja errores
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {

            }
        }
        return Pair(bodyPartsCount, exercisesCount)
    }

    fun countAssignedExercises(userId: Int): Pair<Int, Int> {
        val exerciseMembers = ExerciseMemberService().exerciseMemberList
        val bodyParts = BodyPartService().bodyPartList

        var assignedExerciseCount = 0
        val trainedBodyParts = mutableSetOf<String>()

        //conteo de ejercicios empleados por el miembro
        for (exerciseMember in exerciseMembers) {
            //verifica id miemmrbo de EMS con el parametro recibido osea USER ID
            if (exerciseMember.memberId == userId) {
                assignedExerciseCount++
                println(userId)
                println("Exercise assigned: " + exerciseMember.id)
                println("Cantidad de ejercicios: $assignedExerciseCount")

                // separar partes entrenadas por el usuario
                //Busca en el servicio de bodyparts si existe una instancia de id cuerpo con id parte objetivo
                val matchedExercise = bodyParts.find { it.id == exerciseMember.exerciseId }
                //verifica si ya existe en la lista para evitar repeticiones
                if (matchedExercise != null && !trainedBodyParts.contains(matchedExercise.name)) {
                    trainedBodyParts.add(matchedExercise.name)
                    println("Parte del cuerpo entrenada: ${matchedExercise.name}")
                }
            }
        }
        return Pair(assignedExerciseCount, trainedBodyParts.size)
    }

    fun getExerciseMemberForUser(userId: Int, id: Int): ExerciseMember? {
        return ExerciseMemberService().exerciseMemberList.find { it.memberId == userId && it.exerciseId == id }
    }


}