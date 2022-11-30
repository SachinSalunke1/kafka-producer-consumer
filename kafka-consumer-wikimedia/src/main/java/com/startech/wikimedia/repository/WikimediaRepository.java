package com.startech.wikimedia.repository;

import com.startech.wikimedia.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaData,Long> {
}
