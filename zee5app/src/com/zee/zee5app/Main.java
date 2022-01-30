package com.zee.zee5app;

import java.util.Optional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.repository.UserRepository3;
import com.zee.zee5app.dto.service.MovieService;
import com.zee.zee5app.dto.service.SeriesService;
import com.zee.zee5app.dto.service.SubscriptionService;
import com.zee.zee5app.dto.service.UserService;
import com.zee.zee5app.dto.service.UserService2;
import com.zee.zee5app.dto.service.impl.UserServiceImpl;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Register register = new Register();
		Login login = new Login();
		MovieService movieService = MovieService.getInstance();
		SeriesService seriesService = SeriesService.getInstance();
		SubscriptionService subService = SubscriptionService.getInstance();
		UserService2 service = UserServiceImpl.getInstance();
		
		//Register : class name
		//register : is a reference which will refer your object 
		//(reference) : is a location which is capable to hold the address or location of your object nothing but the physical specification 
		// new : is used to create the object (Heap Memory)
		//Register() : constructor ===> Implicit Default constructor cuz we dont have any constructors in Register 
		//new Register() ==>  is the complete object being created
		
		try {
			try {
				register.setId("pmh001");
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			register.setFirstName("Prajwal");
			register.setLastName("Hardekar");
		} catch (InvalidNameException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		register.setEmail("hardpraj@gmail.com");
		String ans = service.addUser(register);
		
		System.out.println(ans + "checkpoint1");
		
		register.setPassword("Hello1234");
		try {
			register.setId("pmh001");
		} catch (InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		login.setUserName("Prajwal");
		login.setPassword("Hello1234");
		
		System.out.println(register);
		//Whenever you will print the reference 
		//It will call toString() method
		System.out.println(register.toString());
		
		System.out.println(register.getEmail());
		
		System.out.println(login);
		System.out.println(login.getUserName());
		
		//Here getters and setters are generated by lombok's
		
		
		
		for(int i=1;i<=15;++i) {
		
		//UserService object 
		//Main is consuming the service right away 
		
			Register register2 = new Register();
			try {
				register2.setId("pmh00" + i);
				register2.setFirstName("Prajwal " + i);
				register2.setLastName("Hardekar " + i);
				
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			register2.setPassword("hello1234");
			String result = service.addUser(register2);
			System.out.println(result);
		}
		//service.addUser(register);
		Optional<Register> register2 = service.getUserById("pmh001");
		System.out.println(register2 != null);
		
		Optional<Register> optional =  service.getUserById("pmh001");
		
		if(optional.isPresent()) {
			System.out.println("Get User by Id :" + optional.get()); 
		} else {
			System.out.println("Id not found");
		} 
		
		
		
		for (Register register3 : service.getAllUsers()) {
			if(register3 != null)
				System.out.println(register3);
		}
		
		Movie movie = new Movie();
		
		movie.setMovieId("1");
		movie.setMovieGenre("Thriller");
		movie.setMovieLanguage("Kannada");
		movie.setMovieLength(180);
		movie.setMovieName("Kavaludari");
		movie.setMovieReleaseDate("01/01/2018");
		movie.setMovieTrailer("https://youtube.com");
		
		
		String res = movieService.addMovie(movie);
		
		String res1 = movieService.deleteMovie("1");
		
		System.out.println(movie);
		System.out.println(res);
		System.out.println(res1);
		
		//1. For Interfaces we can't create objects
		//UserRepository3 repository = new UserRepository3();
		
		//2. Creation of references is valid
		//UserRepository3 repository = null;
		
		
	}

}

