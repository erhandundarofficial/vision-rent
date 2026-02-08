package com.visionrent.repository;

import com.visionrent.domain.ImageFile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageFileRepository extends JpaRepository<ImageFile, String> {

    @EntityGraph(attributePaths = "id") // parametreye id değeri girildiği zaman, aynı seviyedeki datalar gelir, bağlı olduğu imageData lar gelmemiş olacak
    List<ImageFile> findAll();

    @EntityGraph(attributePaths = "id") // imageFile ile ilgili datalar gelsin
    Optional<ImageFile> findImageById(String id);
}
