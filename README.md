# school
http://localhost:8080/teacher/create	-> tworzy nauczyciela

http://localhost:8080/teacher/update	-> aktualizuje nauczyciela

http://localhost:8080/teacher/delete/id	-> usuwa nauczyciela

http://localhost:8080/teacher/get_all?pageNumber=0&pageSize=5&sort=name	-> wyświetla listę nauczycieli

http://localhost:8080/teacher/find_by_name_and_last_name?name=imie&lastName=nazwisko	->  wyszukuje nauczyciela po imieniu i nazwisku

http://localhost:8080/teacher/id-nauczyciela/add_to_collection/id-ucznia	-> dodaje ucznia nauczycielowi

http://localhost:8080/teacher/id-nauczyciela/remove_from_collection/id-ucznia	-> usuwa ucznia nauczycielowi

http://localhost:8080/teacher/id-nauczyciela/get_collection	-> wyświetla kolekcje, w przypadku nauczyciela- studentów


Analogicznie w drugą stronę działa to w przypadku studentów
http://localhost:8080/student/id-studenta/add_to_collection/id-nauczyciela
itd..
