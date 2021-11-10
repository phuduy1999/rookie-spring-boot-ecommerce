package com.nashtech.rookies.repository;

import com.nashtech.rookies.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoryByName(String name);

    Category findByIdAndCategoryIsNull(Long id);

    boolean existsCategoryByIdNotAndName(Long id, String name);

    List<Category> findByCategoryIsNull();

    @Query("FROM Category c WHERE c.category.id = ?1")
    List<Category> findSubCategoryByParentCategoryId(Long parentId);
}
