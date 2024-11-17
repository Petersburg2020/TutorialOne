package nx.peter.app.tutorialone.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

const val table = "todos"

@Entity(tableName =table)
data class TodoEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String,
    val date: Date,
    val isComplete: Boolean)


