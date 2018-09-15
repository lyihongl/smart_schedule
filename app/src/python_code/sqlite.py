import sqlite3

conn = sqlite3.connect('employee.db')

cursor = conn.cursor();

table_name = "tasks"


def exists_table(db, name):
    query = "SELECT 1 FROM sqlite_master WHERE type='table' and name = ?"
    return db.execute(query, (name,)).fetchone() is not None


if not exists_table(cursor, table_name):

	query = "CREATE TABLE {0} ( _date text, _time text, event text)".format(table_name);
	cursor.execute(query)



# cursor.execute(query)

def exists_data(date, time, event):
	query = 'SELECT * FROM {0} WHERE _date = \'{1}\' and _time = \'{2}\' and event = \'{3}\''.format(table_name, date, time, event)

	return cursor.execute(query).fetchone() is not None

if not exists_data('June 15', '3 PM', 'BIRTHDAY') and exists_table(cursor, table_name):
	cursor.execute("INSERT INTO {0} VALUES ('June 15', '3 PM', 'BIRTHDAY')".format(table_name))


# if(exists_table(cursor, "tasks")):
query1 = 'SELECT * FROM {0} WHERE _date = \'{1}\''.format(table_name, "June 15")
	
cursor.execute(query1) 
print(cursor.fetchall())

conn.commit()