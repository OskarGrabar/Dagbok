package com.example.dagbok;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface DiaryEntryRepository extends CrudRepository<DiaryEntry, Integer> {
    @Query("SELECT d FROM DiaryEntry d WHERE d.date <= CURRENT_DATE")
    List<DiaryEntry> findVisibleEntries();
}
