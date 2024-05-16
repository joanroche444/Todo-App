package com.example.taskapp.utils

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class DatabaseHandler<ToDoModel>(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {
    private lateinit var db: SQLiteDatabase

    companion object {
        private const val VERSION = 2
        private const val NAME = "toDoListDatabase"
        private const val TODO_TABLE = "todo"
        private const val ID = "id"
        private const val TASK = "task"
        private const val STATUS = "status"
        private const val DESCRIPTION = "description"
        private const val PRIORITY = "priority"
        private const val DEADLINE = "deadline"
        private const val CREATE_TODO_TABLE = """
            CREATE TABLE $TODO_TABLE (
                $ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $TASK TEXT,
                $STATUS INTEGER,
                $DESCRIPTION TEXT,
                $PRIORITY TEXT,
                $DEADLINE TEXT
            )
        """
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TODO_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) {
            db.execSQL("DROP TABLE IF EXISTS $TODO_TABLE")
            onCreate(db)
        }
    }

    fun openDatabase() {
        db = this.writableDatabase
    }

   /* fun insertTask(task: ToDoModel) {
        val cv = ContentValues().apply {
            put(TASK, task.getTask())
            put(STATUS, task.getStatus())
            put(DESCRIPTION, task.getDescription())
            put(PRIORITY, task.getPriority())
            put(DEADLINE, task.getDeadline())
        }
        db.insert(TODO_TABLE, null, cv)
    }

    val allTasks: List<ToDoModel>
        get() {
            val tasks = mutableListOf<ToDoModel>()
            db.query(
                TODO_TABLE, null, null, null,
                null, null, "$ID DESC"
            ).use { cursor ->
                while (cursor.moveToNext()) {
                    tasks.add(
                        ToDoModel(
                            cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(TASK)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(STATUS)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)),
                            cursor.getString(cursor.getColumnIndexOrThrow(PRIORITY)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DEADLINE))
                        )
                    )
                }
            }
            return tasks
        }

    fun updateStatus(id: Int, status: Int) {
        val cv = ContentValues().apply {
            put(STATUS, status)
        }
        db.update(TODO_TABLE, cv, "$ID = ?", arrayOf(id.toString()))
    }

    fun updateTask(task: ToDoModel) {
        val cv = ContentValues().apply {
            put(TASK, task.getTask())
            put(DESCRIPTION, task.getDescription())
            put(PRIORITY, task.getPriority())
            put(DEADLINE, task.getDeadline())
        }
        db.update(TODO_TABLE, cv, "$ID = ?", arrayOf(task.getId().toString()))
    }

    fun deleteTask(id: Int) {
        db.delete(TODO_TABLE, "$ID = ?", arrayOf(id.toString()))
    }*/
}
