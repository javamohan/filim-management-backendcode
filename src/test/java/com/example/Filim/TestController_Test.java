package com.example.Filim;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Filim.model.Filim;
import com.example.Filim.service.FilimService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = TestController_Test.class)
public class TestController_Test {
	
	@Mock
	FilimService serv;
	
	@Test
	public String addFilm_test(){
		Mockito.doNothing();
		serv.addFilim(TestController_Test.getFilim());
		return "Material Created Successfully";
	}
	
	
	@Test
	public Filim getAllFilms_test(){
		Mockito.doNothing();
		Filim film = (Filim) serv.getAllFilims();
		assertEquals(film, TestController_Test.getFilim());
		return film;
	}
	
	
	private static Filim getFilim() {
		Filim filim = new Filim();
		filim.setName("Joker");
		filim.setDescription("Comedy");
		filim.setRealeaseDate(new Date());
		filim.setRating(1);
		filim.setTicketPrice(200);
		filim.setCountry("EUROPE");
		return filim;
	}

}
