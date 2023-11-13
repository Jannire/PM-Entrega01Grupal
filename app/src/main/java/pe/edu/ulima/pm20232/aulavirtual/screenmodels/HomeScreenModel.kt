package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.ulima.pm20232.aulavirtual.configs.BackendClient
import pe.edu.ulima.pm20232.aulavirtual.models.BodyPart
import pe.edu.ulima.pm20232.aulavirtual.models.Exercise
import pe.edu.ulima.pm20232.aulavirtual.models.ExerciseMember
import pe.edu.ulima.pm20232.aulavirtual.models.responses.BodyPartExercisesCount
import pe.edu.ulima.pm20232.aulavirtual.services.BodyPartServiceInterface
import pe.edu.ulima.pm20232.aulavirtual.services.ExerciseMemberService
import pe.edu.ulima.pm20232.aulavirtual.services.ExerciseService
import pe.edu.ulima.pm20232.aulavirtual.services.MemberService

class HomeScreenViewModel: ViewModel(){
    val bodyPartsMap = mutableMapOf<Int, String>()
    private val coroutine: CoroutineScope = viewModelScope
    private val memberService = BackendClient.buildService(MemberService::class.java)
    private val bodyPartServiceInterface = BackendClient.buildService(BodyPartServiceInterface::class.java)

    var userId: Int by mutableStateOf(0)
    var memberId: Int by mutableStateOf(0)
    var bodyPartsCount: Int by mutableStateOf(0)
    var exercisesCount: Int by mutableStateOf(0)
    val bodyPartdp = mutableListOf<BodyPart>()

    private var _exercises = MutableStateFlow<List<Exercise>>(emptyList())

    fun fetchBodyParts()
    {

        //var bodyPartdp: List<BodyPart> = listOf<BodyPart>();
        var res: List<BodyPart> = listOf<BodyPart>();
        coroutine.async {
            try {
                withContext(Dispatchers.IO)
                {
                    val response = bodyPartServiceInterface.BodyParts(memberId).execute()
                    bodyPartdp.clear()
                    println("RESPONSE DP: $response")
                    if (response.isSuccessful) {
                        res = response.body()!!
                        println("RESPONSE SUCCESS DP: $res")
                        for(par: BodyPart in res)
                        {
                            val partId = par.id
                            val partName = par.name
                            var tem = BodyPart(partId, partName)
                            bodyPartdp.add(tem)
                        }
                        //bodyPartdp = res;


                    } else {
                        // Maneja errores
                        ;
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {

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

    fun getExerciseMemberForUser(userId: Int, id: Int): ExerciseMember? {
        return ExerciseMemberService().exerciseMemberList.find { it.memberId == userId && it.exerciseId == id }
    }


}