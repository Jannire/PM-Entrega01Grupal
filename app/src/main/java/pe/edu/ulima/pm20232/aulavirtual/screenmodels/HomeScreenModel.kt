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

    fun filterByBodyParts(bodyPartId: Int){
        val service: ExerciseService = ExerciseService()
        val list = service.exerciseListByBodyPartId(bodyPartId)
        setExercises(list)
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

    fun getExerciseMember(exerciseId: Int): ExerciseMember {
        TODO("Not yet implemented")
    }
}
