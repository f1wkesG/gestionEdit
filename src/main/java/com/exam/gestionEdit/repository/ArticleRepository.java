package com.exam.gestionEdit.repository;

import com.exam.gestionEdit.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    List<Article> findArticleByTitre(String titre);

}
