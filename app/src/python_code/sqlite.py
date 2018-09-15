import sqlite3

conn = sqlite3.connect('employee.db')

cursor = conn.cursor();

table_name = "tasks"


def exists_table(db, name):
    query = "SELECT 1 FROM sqlite_master WHERE type='table' and name = ?"
    return db.execute(query, (name,)).fetchone() is not None


if not exists_table(cursor, table_name):

	cursor.execute("""CREATE TABLE tasks (
					_date text,
					_time text,
					event text
		)""")



# cursor.execute(query)

cursor.execute("INSERT INTO tasks VALUES ('June 15', '1 PM', 'BIRTHDAY')")

if(exists_table(cursor, "tasks")):
	query = 'SELECT * FROM {0} WHERE _date = \'{1}\''.format(table_name, "June 15")
	
	cursor.execute(query) 
	print(cursor.fetchone())

conn.commit()