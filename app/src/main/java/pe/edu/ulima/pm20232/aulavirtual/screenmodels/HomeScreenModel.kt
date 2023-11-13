package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pe.edu.ulima.pm20232.aulavirtual.models.BodyPart
import pe.edu.ulima.pm20232.aulavirtual.models.Exercise
import pe.edu.ulima.pm20232.aulavirtual.models.ExerciseMember
import pe.edu.ulima.pm20232.aulavirtual.services.BodyPartService
import pe.edu.ulima.pm20232.aulavirtual.services.ExerciseService
import pe.edu.ulima.pm20232.aulavirtual.services.ExerciseMemberService

import kotlin.math.log

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
    fun countAssignedExercises(userId: Int): Pair<Int, Int> {
        val exerciseMembers = ExerciseMemberService().exerciseMemberList
        val exercises = ExerciseService().listAll()
        val bodyParts = BodyPartService().bodyPartList

        var assignedExerciseCount = 0
        val uniqueBodyPartIds = mutableSetOf<Int>()

        for (exerciseMember in exerciseMembers) {
            if (exerciseMember.memberId == userId) {
                assignedExerciseCount++
                val matchedExercise = exercises.find { it.id == exerciseMember.exerciseId }
                val bodyPartId = matchedExercise?.bodyPartId
                if (bodyPartId != null && uniqueBodyPartIds.add(bodyPartId)) {
                }
            }
        }

        return Pair(assignedExerciseCount, uniqueBodyPartIds.size)
    }
    fun getExerciseMemberForUser(userId: Int, id: Int): ExerciseMember? {
        return ExerciseMemberService().exerciseMemberList.find { it.memberId == userId && it.exerciseId == id }
    }


}