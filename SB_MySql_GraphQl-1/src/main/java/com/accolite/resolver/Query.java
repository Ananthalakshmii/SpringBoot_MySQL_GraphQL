package com.accolite.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.accolite.model.Author;
import com.accolite.model.Tutorial;
import com.accolite.repository.AuthorRepo;
import com.accolite.repository.TutorialRepo;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver{
	//@Autowired
	private AuthorRepo authorRepo;
	//@Autowired
	private TutorialRepo tutorialRepo;
	
	@Autowired
	  public Query(AuthorRepo authorRepository, TutorialRepo tutorialRepository) {
	    this.authorRepo = authorRepository;
	    this.tutorialRepo = tutorialRepository;
	    System.out.println("inside query constructor");
	    System.out.println(authorRepo+" "+tutorialRepo);
	  }
	@PostMapping("/post")
	public List<Author> findAllAuthors(){
		System.out.println("inside find all authors");
		return authorRepo.findAll();
	}
	
	public long countAuthors() {
		return authorRepo.count();
	}
	
	public List<Tutorial> findAllTutorials(){
		return tutorialRepo.findAll();
	}
	
	public long countTutorials() {
		return tutorialRepo.count();
	}

}
