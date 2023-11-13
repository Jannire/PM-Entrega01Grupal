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
import pe.edu.ulima.pm20232.aulavirtual.models.BodyPart
import pe.edu.ulima.pm20232.aulavirtual.models.Exercise
import pe.edu.ulima.pm20232.aulavirtual.services.BodyPartService
import pe.edu.ulima.pm20232.aulavirtual.services.ExerciseService
import pe.edu.ulima.pm20232.aulavirtual.services.ExerciseService2

class ExerciseScreenViewModel: ViewModel() {
    val bodyPartsMap = mutableMapOf<Int, String>()
    private val ExerciseService2 = BackendClient.buildService(ExerciseService2::class.java)
    private val coroutine: CoroutineScope = viewModelScope
    var exerciseId: Int by mutableStateOf(0)

    var name: String by mutableStateOf("")
    var description: String by mutableStateOf("")
    var videoUrl: String by mutableStateOf("")
    fun getBodyParts() {
        val bodyPartService: BodyPartService = BodyPartService()
        var bodyPartList: ArrayList<BodyPart> = bodyPartService.bodyPartList
        for (p: BodyPart in bodyPartList) {
            val id = p.id
            val name = p.name
            if (!bodyPartsMap.containsKey(id)) {
                bodyPartsMap[id] = name
            }
        }
    }

    private var _exercises = MutableStateFlow<List<Exercise>>(emptyList())
    val exercises: StateFlow<List<Exercise>> get() = _exercises
    fun setExercises(newItems: List<Exercise>) {
        _exercises.value = newItems
    }

    fun listAllExercises() {
        val service: ExerciseService = ExerciseService()
        val list = service.listAll()
        setExercises(list)
    }

    fun filterByBodyParts(bodyPartId: Int) {
        val service: ExerciseService = ExerciseService()
        val list = service.exerciseListByBodyPartId(bodyPartId)
        setExercises(list)
    }

    fun fetchExerciseinfo(): List<String>  {
        coroutine.launch {
            try {
                //var ExerciseTemp = Exercise(0,"","","","")
                withContext(Dispatchers.IO) {
                    val response = ExerciseService2.exercise(exerciseId).execute()
                    println("<FETCH: " + response)
                    if (response.isSuccessful) {
                        val Exercise: Exercise = response.body()!!
                        println("FETCH SUCCESS: " + response)

                        name = Exercise.name
                        description = Exercise.description
                        videoUrl = Exercise.videoUrl




                    } else {
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {

            }
        }
        return listOf(name, description,videoUrl)
    }
}