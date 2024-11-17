package nx.peter.app.tutorialone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import nx.peter.app.tutorialone.data.TodoEntity
import nx.peter.app.tutorialone.data.TodoRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val _todoUiState = MutableStateFlow<TodoUiState>(TodoUiState.Loading)

    val todoUiState: StateFlow<TodoUiState> = _todoUiState.asStateFlow()

    init {
        viewModelScope.launch {
            todoRepository.getAllTodos().collect {
                _todoUiState.value = TodoUiState.Success(it)
            }
        }
    }

    fun addTodo(todoEntity: TodoEntity){
        viewModelScope.launch {
            todoRepository.addTodo(todoEntity)
        }
    }

    fun updateTodo(todoEntity: TodoEntity){
        viewModelScope.launch {
            todoRepository.updateTodo(todoEntity)
        }
    }

    fun deleteTodo(todoEntity: TodoEntity){
        viewModelScope.launch {
            todoRepository.deleteTodo(todoEntity)
        }
    }

}

sealed class TodoUiState {
    data object Loading : TodoUiState()

    data class Error(val message: String) : TodoUiState()

    data class Success(val data: List<TodoEntity>) : TodoUiState()
}
