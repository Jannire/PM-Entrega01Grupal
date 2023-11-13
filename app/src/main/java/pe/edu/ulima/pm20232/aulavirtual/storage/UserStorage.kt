package pe.edu.ulima.pm20232.aulavirtual.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserStorage(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(("User"))
        val USER_EMAIL_KEY = stringPreferencesKey("user_email")
        val USER_ID_KEY = intPreferencesKey("user_id")
    }

    val getEmail: Flow<String?> = context.dataStore.data.map{ preferences ->
        preferences[USER_EMAIL_KEY] ?: ""
    }

    suspend fun saveEmail(name: String){
        context.dataStore.edit{ preferences ->
            preferences[USER_EMAIL_KEY] = name
        }
    }

    val getUserId: Flow<Int?> = context.dataStore.data.map{ preferences ->
        preferences[USER_ID_KEY] ?: 0
    }

    suspend fun saveUserId(userId: Int){
        context.dataStore.edit{ preferences ->
            preferences[USER_ID_KEY] = userId
        }
    }
}