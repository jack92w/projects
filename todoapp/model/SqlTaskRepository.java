package io.github.jack92w.todoapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//@RepositoryRestResource//(path = "todos", collectionResourceRel = "todos") //path - zmiana nazwy tabeli w adresie. Jest to część adresu w którym nasz zasó jest dostępny//
// collectionResourceRel - informacja, jak kolekcja zbiór, obiekt powinien być opisywany w kolekcjach
@Repository
interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
    /*  @Override
      @RestResource(exported = false) //pobrane z dokumetacji springa
      void deleteById(Integer integer);

      @Override
      @RestResource(exported = false)
      void delete(Task task);
  */

}

