package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pe.edu.ulima.pm20232.aulavirtual.models.BodyPart
import pe.edu.ulima.pm20232.aulavirtual.models.Exercise
import pe.edu.ulima.pm20232.aulavirtual.services.BodyPartService
import pe.edu.ulima.pm20232.aulavirtual.services.ExerciseService

class HomeScreenViewModel: ViewModel(){
    val bodyPartsMap = mutableMapOf<Int, String>()

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

    private var _exercises = MutableStateFlow<List<Exercise>>(emptyList())
    val exercises: StateFlow<List<Exercise>> get() = _exercises
    fun setExercises(newItems: List<Exercise>) {
        _exercises.value = newItems
    }

    fun listAllExercises(){
        val service: ExerciseService = ExerciseService()
        val list = service.listAll()
        setExercises(list)
    }

    fun filterByBodyParts(bodyPartId: Int){
        val service: ExerciseService = ExerciseService()
        val list = service.exerciseListByBodyPartId(bodyPartId)
        setExercises(list)
    }
}