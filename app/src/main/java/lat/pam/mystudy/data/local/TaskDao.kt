package lat.pam.mystudy.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import lat.pam.mystudy.domain.model.Task

@Dao
interface TaskDao {
    @Upsert
    suspend fun upsertTask(task: Task)

    @Query("DELETE FROM Task WHERE taskId = :taskId")
    suspend fun deleteTask(taskId: Int)

    @Query("DELETE FROM Task WHERE taskSubjectId = :subjectId")
    suspend fun deleteTaskBySubjectId(subjectId: Int)

    @Query("SELECT * FROM Task WHERE taskId = :taskId")
    suspend fun getTaskById(taskId: Int): Task?

    @Query("SELECT * FROM Task Where taskSubjectId = :subjectId")
    fun getTasksForSubject(subjectId: Int):Flow<List<Task>>

    @Query("SELECT * FROM Task")
    fun getAllTasks(): Flow<List<Task>>
}