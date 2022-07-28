package com.accolite.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accolite.model.Author;
import com.accolite.model.Tutorial;
import com.accolite.repository.AuthorRepo;
import com.coxautodev.graphql.tools.GraphQLResolver;

@Component
public class TutorialAuthorResolver implements GraphQLResolver<Tutorial>{
	@Autowired
	private AuthorRepo authorRepo;
	
	public Author getAuthor(Tutorial tutorial) {
		return authorRepo.findById(tutorial.getAuthor().getId()).orElseThrow(null);
	}
	
	
}
