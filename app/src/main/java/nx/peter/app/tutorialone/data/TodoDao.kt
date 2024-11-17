package nx.peter.app.tutorialone.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class TodoDao {

    @Query("SELECT * FROM todos")
    abstract fun getAllTodos(): Flow<List<TodoEntity>>

    @Insert(entity = TodoEntity::class, onConflict = REPLACE)
    abstract suspend fun addTodo(todoEntity: TodoEntity)

    @Update
    abstract suspend fun updateTodo(todoEntity: TodoEntity)

    @Delete
    abstract suspend fun deleteTodo(todoEntity: TodoEntity)
}