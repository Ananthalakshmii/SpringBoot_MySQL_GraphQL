package com.accolite.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accolite.model.Author;
import com.accolite.model.Tutorial;
import com.accolite.repository.AuthorRepo;
import com.accolite.repository.TutorialRepo;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class Mutation implements GraphQLMutationResolver{
	//@Autowired
	private AuthorRepo authorRepo;
	//@Autowired
	private TutorialRepo tutorialRepo;
	
	@Autowired
	  public Mutation(AuthorRepo authorRepository, TutorialRepo tutorialRepository) {
	    this.authorRepo = authorRepository;
	    this.tutorialRepo = tutorialRepository;
	    System.out.println("inside mutation constructor");
	    System.out.println(authorRepo+" "+tutorialRepo);
	  }
	
	public Author createAuthor(String name, Integer age) {
		Author author=new Author();
		author.setName(name);
		author.setAge(age);
		authorRepo.save(author);
		return author;
	}
	
	public Tutorial createTutorial(String title, String description,Long authorId) {
		Tutorial tutorial=new Tutorial();
		tutorial.setAuthor(new Author(authorId));
		tutorial.setTitle(title);
		tutorial.setDescription(description);
		tutorialRepo.save(tutorial);
		return tutorial;
	}
	
	public Tutorial updateTutorial(Long id, String title, String description) {
		Tutorial tutorial=tutorialRepo.findById(id).get();
		if(title!=null)
			tutorial.setTitle(title);
		if(description!=null)
			tutorial.setDescription(description);
		tutorialRepo.save(tutorial);
		return tutorial;
		
	}
	
	public boolean deleteTutorial(Long id) {
		tutorialRepo.deleteById(id);
		return true;
	}
	
	
	
	
}
