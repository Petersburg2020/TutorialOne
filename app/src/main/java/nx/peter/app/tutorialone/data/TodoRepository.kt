package nx.peter.app.tutorialone.data

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    fun getAllTodos(): Flow<List<TodoEntity>> = todoDao.getAllTodos()

    suspend fun addTodo(todoEntity: TodoEntity){
        todoDao.addTodo(todoEntity)
    }


    suspend fun updateTodo(todoEntity: TodoEntity) {
        todoDao.updateTodo(todoEntity)
    }

    suspend fun deleteTodo(todoEntity: TodoEntity) {
        todoDao.deleteTodo(todoEntity)
    }

}