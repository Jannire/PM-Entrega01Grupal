package pe.edu.ulima.pm20232.aulavirtual.configs

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("nombre_preferencias")

class PreferencesManager(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("MiPreferencia", Context.MODE_PRIVATE)

    private val dataStore = context.dataStore

    val userId: Flow<Int?> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.userId]
    }

    suspend fun setUserId(userId: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.userId] = userId
        }
    }

    fun getUserId(): Int{
        return sharedPreferences.getInt("userId", 999)
    }

}