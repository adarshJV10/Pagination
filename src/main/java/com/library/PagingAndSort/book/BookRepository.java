package com.library.PagingAndSort.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.Locale.Category;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>
{
   public List<Book> findById(int id); 

}
